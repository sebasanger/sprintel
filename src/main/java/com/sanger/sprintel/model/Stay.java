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
    @JoinTable(name = "customers_stays", joinColumns = @JoinColumn(name = "stay_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<@Valid Customer> customers;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "stay_id")
    private Set<Payment> payments;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "stay_id")
    private Set<Consumption> consumptions;

    @ManyToOne(optional = true)
    private Reason reason;

    @ManyToOne(optional = false)
    private RoomPrice roomPrice;

    @Column(nullable = false)
    private Short totalGuest;

    private Double pricePerDay;

    private Double totalToPay;

    private Double paid;

    @Column(nullable = false)
    private Date entryDate;

    @Column(nullable = false)
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
