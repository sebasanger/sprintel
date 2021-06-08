package com.sanger.sprintel.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "payments")
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "stay_id")
    @NotNull
    @JsonBackReference(value = "stay-payment")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Stay stay;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "register_id")
    @JsonBackReference(value = "payment-register")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Register register;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
