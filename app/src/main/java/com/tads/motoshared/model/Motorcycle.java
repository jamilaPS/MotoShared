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
    private Integer age;

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

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
}
