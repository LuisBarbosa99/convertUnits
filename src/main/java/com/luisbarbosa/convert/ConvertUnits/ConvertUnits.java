package com.luisbarbosa.convert.ConvertUnits;

import javax.persistence.*;

@Entity
@Table
public class ConvertUnits {
    @Id
    @SequenceGenerator(
            name = "convert_sequence",
            sequenceName = "convert_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "convert_sequence"
    )
    private Long id;
    private String name;
    private String unitName;
    private float value;
    private String symbol;

    public ConvertUnits(String name, String symbol, String unitName, float value) {
        this.name = name;
        this.symbol = symbol;
        this.unitName = unitName;
        this.value = value;
    }

    public ConvertUnits() {
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
