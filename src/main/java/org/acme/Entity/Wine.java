package org.acme.Entity;

import org.acme.Entity.Enum.WineType;

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
public class Wine extends Product{
    
    private String grape;
    private int liter;
    private double alcohol;
    
    @Enumerated(EnumType.STRING)
    private WineType wineType;

}



