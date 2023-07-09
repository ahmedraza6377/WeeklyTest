package com.productManagament.productManagament.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer prodQuantity;

    @ManyToOne
    @JoinColumn(name="fk_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_prod_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_add_id")
    private Address address;




}
