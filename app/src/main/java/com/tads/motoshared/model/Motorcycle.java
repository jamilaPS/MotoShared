package com.tads.motoshared.model;

import com.orm.SugarRecord;

/**
 * Created by jamila on 13/08/16.
 */
public class Motorcycle extends SugarRecord
{
    private User owner;
    private Double price;
    private String brand;
    private String model;
    private Integer year;

    public Motorcycle()
    {

    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }
}
