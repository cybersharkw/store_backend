package org.acme.Entity;

import org.acme.Entity.Enum.SpiritType;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Spirit extends Product{
    
    private int liter;
    private double alcohol;
    private SpiritType spiritType;

    

}
