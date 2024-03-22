package org.acme.Entity;

import org.acme.Entity.Enum.SpiritType;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

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
@Indexed
public class Spirit extends Product{
    
    private int liter;
    private double alcohol;
    private SpiritType spiritType;

    

}
