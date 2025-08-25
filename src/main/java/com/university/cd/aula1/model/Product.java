package com.university.cd.aula1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false)
    private BigDecimal price;

    @NotNull @Min(0)
    private Integer stock;

}
