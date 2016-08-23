package com.tads.motoshared.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jamila on 13/08/16.
 */
public class User extends SugarRecord
{

    @Unique
    private String username;
    private String password;
    private String email;

    public User()
    {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
