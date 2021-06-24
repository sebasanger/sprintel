package com.sanger.sprintel.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "registers")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Double openMount;

    private Double closeMount;

    private LocalDateTime closeTime;

    private Boolean active;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "register", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> payments;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Double getTotalPayments() {
        if (this.payments != null) {
            return this.payments.stream().mapToDouble(Payment::getAmount).sum();
        } else {
            return 0D;
        }
    }

    public Double getActualBalance() {
        if (this.getTotalPayments() != 0) {
            return getTotalPayments() + this.openMount;
        } else {
            return this.openMount;
        }
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setRegister(this);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
        payment.getStay().removePayment(payment);
        payment.setRegister(null);
    }

}
