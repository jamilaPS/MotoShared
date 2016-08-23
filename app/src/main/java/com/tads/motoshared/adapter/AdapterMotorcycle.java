package com.tads.motoshared.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tads.motoshared.R;
import com.tads.motoshared.model.Motorcycle;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by maria on 21/08/2016.
 */
public class AdapterMotorcycle extends BaseAdapter {
    private List<Motorcycle> motorcycleList;
    private Activity activity;

    public AdapterMotorcycle(List<Motorcycle> motorcycleList, Activity activity) {
        this.motorcycleList = motorcycleList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return motorcycleList.size();
    }

    @Override
    public Object getItem(int position) {
        return motorcycleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return motorcycleList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(activity).inflate(R.layout.adapter_motocycle, parent, false);

        Motorcycle motorcycle = motorcycleList.get(position);

        //ImageView ivPhoto = (ImageView) view.findViewById(R.id.iv_photo);
        //ivPhoto.setImageBitmap();


        TextView tvBrand = (TextView) view.findViewById(R.id.tv_brand);
        tvBrand.setText(motorcycle.getBrand());

        TextView tvModel = (TextView) view.findViewById(R.id.tv_model);
        tvModel.setText(motorcycle.getModel());

        TextView tvPrice = (TextView) view.findViewById(R.id.tv_price);
        tvPrice.setText(motorcycle.getPrice().toString());


        return view;
    }
}
