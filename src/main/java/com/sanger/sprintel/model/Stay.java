package com.sanger.sprintel.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "stays")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customers_stays", joinColumns = @JoinColumn(name = "stay_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<@Valid Customer> customers;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "stay_id")
    @Builder.Default
    private Set<Payment> payments = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stay_id")
    @Builder.Default
    private Set<Consumption> consumptions = new HashSet<>();

    @ManyToOne(optional = true)
    private Reason reason;

    @ManyToOne(optional = false)
    private RoomPrice roomPrice;

    @Column(nullable = false)
    private Short totalGuest;

    private Double pricePerDay;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate outDate;

    private boolean active;

    private LocalDate checkIn;

    private LocalDate checkOut;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void deleteProducto(Customer customer) {
        this.customers.remove(customer);
    }

    public Double getTotalConsumptions() {
        if (this.consumptions.isEmpty()) {
            return 0D;
        } else {
            return consumptions.stream().mapToDouble(Consumption::getSubtotal).sum();
        }
    }

    public Double getTotalPayments() {
        if (this.payments.isEmpty()) {
            return 0D;
        } else {
            return payments.stream().mapToDouble(Payment::getAmount).sum();
        }
    }

    public Double getTotalToPay() {
        if (this.pricePerDay == null) {
            return 0D;
        } else {
            long noOfDaysBetween = ChronoUnit.DAYS.between(entryDate, outDate);

            Double totalRoomPrice = roomPrice.getPrice() * noOfDaysBetween;

            return totalRoomPrice + getTotalConsumptions();

        }
    }

    public Double getTotalRemaining() {
        if (this.getTotalToPay() == null) {
            return 0D;
        } else {
            return getTotalToPay() - getTotalPayments();

        }
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setStay(this);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
        payment.setStay(null);
    }

    public void addConsumption(Consumption consumption) {
        consumptions.add(consumption);
        consumption.setStay(this);
    }

    public void removeConsumption(Consumption consumption) {
        consumptions.remove(consumption);
        consumption.setStay(null);
    }

}
