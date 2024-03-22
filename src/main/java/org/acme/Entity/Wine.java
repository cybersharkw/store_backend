package org.acme.Entity;

import org.acme.Entity.Enum.WineType;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Indexed
public class Wine extends Product{
    
    @FullTextField
    private String grape;

    private int liter;
    private double alcohol;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @GenericField
    @FullTextField
    private WineType wineType;

}



