package com.tads.motoshared.view;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tads.motoshared.R;
import com.tads.motoshared.adapter.AdapterMotorcycle;
import com.tads.motoshared.model.Motorcycle;

public class ListMotorcycleFragment extends Fragment {

    private Motorcycle motorcycle;
    private ListView listViewMotorcycle;
    private AdapterMotorcycle adapterMotorcycle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_lista_motorcycle, container, false);

        //listViewMotorcycle = (ListView) view.findViewById(R.id.list_view_motorcycle);

        completeList();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        completeList();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        completeList();
    }


    private void completeList() {
        adapterMotorcycle = new AdapterMotorcycle(Motorcycle.listAll(Motorcycle.class), getActivity());
        //listViewMotorcycle.setAdapter(adapterMotorcycle);
    }
}
