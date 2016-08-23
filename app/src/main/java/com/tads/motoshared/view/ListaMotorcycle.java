package com.tads.motoshared.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tads.motoshared.R;
import com.tads.motoshared.adapter.AdapterMotorcycle;
import com.tads.motoshared.control.MotorcycleControl;
import com.tads.motoshared.model.Motorcycle;

public class ListaMotorcycle extends AppCompatActivity {

    private ListView listViewMotorcycle;
    private AdapterMotorcycle adapterMotorcycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_motorcycle);

        listViewMotorcycle = (ListView) findViewById(R.id.listView_Motorcycle);


    }

    @Override
    protected void onResume() {
        super.onResume();
        completeList();
    }

    private void completeList() {
        adapterMotorcycle = new AdapterMotorcycle(Motorcycle.listAll(Motorcycle.class), this);
        listViewMotorcycle.setAdapter(adapterMotorcycle);
    }
}
