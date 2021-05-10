package com.sanger.sprintel.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String type;

    @OneToMany(mappedBy = "invoiceType")
    @JsonBackReference
    private List<Customer> customers;

    @PreRemove
    private void preRemove() {
        for (Customer c : this.customers) {
            c.setInvoiceType(null);
        }
    }

}
