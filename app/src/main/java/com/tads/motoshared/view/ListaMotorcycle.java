package com.tads.motoshared.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        registerForContextMenu(listViewMotorcycle);


    }

    @Override
    public void onCreateContextMenu(final ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Motorcycle motorcycle = (Motorcycle) listViewMotorcycle.getItemAtPosition(info.position);

        MenuItem itemDelete = menu.add("Excluir");
        itemDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                motorcycle.delete(motorcycle);
                completeList();
                return false;
            }
        });


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
