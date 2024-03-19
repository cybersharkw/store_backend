package org.acme.Entity;




import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Indexed
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FullTextField
    private String name;

    private String info;
    @GenericField
    private double price;

    @Column(nullable = true)
    private int inventory;

    private String country;
    @Column(nullable = true)
    private String region;

    @Column(nullable = true)
    private int gramm;

    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = true)
    private Producer producer;




}