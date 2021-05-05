package com.sanger.sprintel.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToMany(cascade = CascadeType.MERGE)
    @NotNull
    @JoinTable(name = "customers_stays", joinColumns = @JoinColumn(name = "stay_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<@Valid @NotNull Customer> customers;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "stay_id")
    @JsonManagedReference(value = "stay-payment")
    private Set<Payment> payments;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "stay_id")
    @JsonManagedReference(value = "stay-consumption")
    private Set<Consumption> consumptions;

    @ManyToOne()
    private Reason reason;

    @NotNull
    @ManyToOne()
    private RoomPrice roomPrice;

    @NotNull
    @Column(nullable = false)
    private Short totalGuest;

    private Double pricePerDay;

    private Double totalToPay;

    private Double paid;

    private Date entryDate;

    private Date outDate;

    private boolean active;

    private Date checkIn;

    private Date checkOut;

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

}
