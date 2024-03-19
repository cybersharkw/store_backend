package org.acme.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends PanacheEntity  {

    private String name;
    private String info;
    private double price;
    private int inventory;

    private String country;
    private String region;
    private int gramm;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;




}