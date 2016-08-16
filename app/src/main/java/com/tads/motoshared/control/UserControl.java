package com.tads.motoshared.control;

import com.tads.motoshared.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamila on 13/08/16.
 */
public class UserControl
{
    public User login(String username, String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return listByFilter(user, null).get(0);
    }

    public void save(User obj)
    {
        //Implements your validations here!
        obj.save();
    }

    public void delete(User obj)
    {
        //Implements your validations here!
        obj.delete();
    }

    public User findById(Long id)
    {
        //Implements your validations here!
        return User.findById(User.class, id);
    }

    public List<User> listAll(String orderBy)
    {
        //Implements your validations here!
        if(orderBy != null && !orderBy.isEmpty())
            return User.listAll(User.class, orderBy);
        else
            return User.listAll(User.class);
    }

    public List<User> listByFilter(User filter, String endQuery)
    {
        String query = "SELECT * FROM User WHERE 1 = 1";
        List<String> args = new ArrayList<>();

        if(filter.getName() != null && !filter.getName().isEmpty())
        {
            query += " AND name = ?";
            args.add(filter.getName());
        }

        if(filter.getAge() != null)
        {
            query += " AND age = ?";
            args.add(filter.getAge().toString());
        }

        if(filter.getUsername() != null && !filter.getUsername().isEmpty())
        {
            query += " AND username = ?";
            args.add(filter.getUsername());
        }

        if(filter.getPassword() != null && !filter.getPassword().isEmpty())
        {
            query += " AND password = ?";
            args.add(filter.getPassword());
        }

        if(endQuery != null && !endQuery.isEmpty())
            query += " "+endQuery;

        return User.findWithQuery(User.class, query, (String[]) args.toArray());
    }

}
