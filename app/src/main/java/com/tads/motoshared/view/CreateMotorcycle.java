package com.tads.motoshared.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tads.motoshared.R;
import com.tads.motoshared.control.MotorcycleControl;
import com.tads.motoshared.model.Motorcycle;
import com.tads.motoshared.util.LoggedUserUtil;

public class CreateMotorcycle extends AppCompatActivity {
    EditText edPrice;
    EditText edBrand;
    EditText edModel;
    EditText edYear;

    MotorcycleControl control = new MotorcycleControl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_motorcycle);

        edPrice = (EditText) findViewById(R.id.ed_price);
        edBrand = (EditText) findViewById(R.id.ed_brand);
        edModel = (EditText) findViewById(R.id.ed_model);
        edYear = (EditText) findViewById(R.id.ed_year);
    }

    public void save(View view)
    {
        Motorcycle moto = new Motorcycle();
        moto.setOwner(LoggedUserUtil.LOGGED_USER);
        moto.setPrice(Double.parseDouble(edPrice.getText().toString()));
        moto.setBrand(edBrand.getText().toString());
        moto.setModel(edModel.getText().toString());
        moto.setYear(Integer.parseInt(edYear.getText().toString()));

        control.save(moto);
        Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void cancel(View view)
    {
        finish();
    }

    public void takePicture(View view)
    {

    }
}
