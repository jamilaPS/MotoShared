package com.tads.motoshared.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jamila on 13/08/16.
 */
public class User extends SugarRecord
{
    private String name;
    private Integer age;
    @Unique
    private String username;
    private String password;

    public User()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
