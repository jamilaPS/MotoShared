package com.tads.motoshared.control;

import com.tads.motoshared.model.Motorcycle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamila on 13/08/16.
 */
public class MotorcycleControl
{
    public void save(Motorcycle obj)
    {
        //Implements your validations here!
        obj.save();
    }

    public void delete(Motorcycle obj)
    {
        //Implements your validations here!
        obj.delete();
    }

    public Motorcycle findById(Long id)
    {
        //Implements your validations here!
        return Motorcycle.findById(Motorcycle.class, id);
    }

    public List<Motorcycle> listAll(String orderBy)
    {
        //Implements your validations here!
        if(orderBy != null && !orderBy.isEmpty())
            return Motorcycle.listAll(Motorcycle.class, orderBy);
        else
            return Motorcycle.listAll(Motorcycle.class);
    }

    public List<Motorcycle> listByFilter(Motorcycle filter, String endQuery)
    {
        String query = "SELECT * FROM Motorcycle WHERE 1 = 1";
        List<String> args = new ArrayList<>();

        if(filter.getOwner() != null && filter.getOwner().getId() != null)
        {
            query += " AND Motorcyle.owner.id = ?";
            args.add(filter.getOwner().getId().toString());
        }

        if(filter.getPrice() != null)
        {
            query += " AND price = ?";
            args.add(filter.getPrice().toString());
        }

        if(filter.getBrand() != null && !filter.getBrand().isEmpty())
        {
            query += " AND brand = ?";
            args.add(filter.getBrand());
        }

        if(filter.getAge() != null)
        {
            query += " AND age = ?";
            args.add(filter.getAge().toString());
        }

        if(endQuery != null && !endQuery.isEmpty())
            query += " "+endQuery;

        return Motorcycle.findWithQuery(Motorcycle.class, query, (String[]) args.toArray());
    }
}
