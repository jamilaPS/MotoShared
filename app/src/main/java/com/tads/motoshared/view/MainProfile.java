package com.tads.motoshared.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.ContextMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tads.motoshared.R;
import com.tads.motoshared.adapter.AdapterMotorcycle;
import com.tads.motoshared.model.Motorcycle;

public class MainProfile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listViewMotorcycle;
    private AdapterMotorcycle adapterMotorcycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewMotorcycle = (ListView) findViewById(R.id.listView_Motorcycle);
        registerForContextMenu(listViewMotorcycle);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Motorcycle motorcycle = (Motorcycle) listViewMotorcycle.getItemAtPosition(info.position);

        MenuItem itemCall = menu.add("Ligar");
        itemCall.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(ActivityCompat.checkSelfPermission(MainProfile.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainProfile.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }else {
                    Intent intentLigar = new Intent(Intent.ACTION_CALL);
                    //intentLigar.setData(Uri.parse("tel: " +motorcycle.getPhone()));
                    startActivity(intentLigar);
                }
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_motorcycle) {
            //CADASTRAR MOTO A SER VENDIDA
            Intent intentCreateMoto = new Intent(getApplicationContext(), CreateMotorcycle.class );
            startActivity(intentCreateMoto);
        } else if (id == R.id.nav_motorcycles_sale) {
            //MINHAS MOTOS
        } else if (id == R.id.nav_motorcycles_sale) {
            //MOTOS A VENDA

        } else if (id == R.id.nav_shopping_cart) {
            //CARRINHO DE COMPRAS

        } else if (id == R.id.nav_wishlist) {
            //LISTA DE DESEJOS

        } else if (id == R.id.nav_log_out) {
            //SAIR
            Intent intentLogOut = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intentLogOut);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
