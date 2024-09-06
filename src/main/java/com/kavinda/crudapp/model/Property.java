package com.kavinda.crudapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long pId;
    private String pName;
    private String pDescrip;
    private Integer pQty;
    private Double pPrice;
}