package com.dea.PropertySphere.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    private Long pId;
    private String pName;
    private String pDescrip;
    private Integer pQty;
    private Double pPrice;
}
