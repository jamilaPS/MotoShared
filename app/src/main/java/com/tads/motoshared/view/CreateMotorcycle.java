package com.tads.motoshared.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tads.motoshared.R;
import com.tads.motoshared.control.MotorcycleControl;
import com.tads.motoshared.model.Motorcycle;
import com.tads.motoshared.util.LoggedUserUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateMotorcycle extends AppCompatActivity {
    EditText edPrice;
    EditText edBrand;
    EditText edModel;
    EditText edYear;
    EditText edPhone;
    TextView tvCamera;

    private String name;
    private boolean hasPicture = false;

    private Button bt_camera;
    MotorcycleControl control = new MotorcycleControl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_motorcycle);

        edPrice = (EditText) findViewById(R.id.ed_price);
        edBrand = (EditText) findViewById(R.id.ed_brand);
        edModel = (EditText) findViewById(R.id.ed_model);
        edYear = (EditText) findViewById(R.id.ed_year);
        edPhone = (EditText) findViewById(R.id.ed_phone);
        tvCamera = (TextView) findViewById(R.id.tv_erroCamera);

        bt_camera = (Button) findViewById(R.id.bt_camera);
        bt_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean formNotEmpty = true;
                if (edModel.getText().toString().isEmpty()) {
                    edModel.requestFocus();
                    edModel.setError("Por favor preencha o campo Modelo");
                    formNotEmpty = false;
                }
                if (edYear.getText().toString().isEmpty()) {
                    formNotEmpty = false;
                    edYear.requestFocus();
                    edYear.setError("Por favor preencha o campo Ano");
                }
                if (formNotEmpty) {
                    name = LoggedUserUtil.LOGGED_USER.getUsername() + "-" + edModel.getText().toString() + "-" + edYear.getText().toString() + ".png";
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1);
                }

            }
        });
    }

    public void save(View view) {
        boolean formNotEmpty = true;

        if (!hasPicture) {
            tvCamera.setText("Para prosseguir, tire uma foto.");
            formNotEmpty = false;
        }
        if (edPrice.getText().toString().isEmpty()) {
            edPrice.requestFocus();
            edPrice.setError("Por favor preencha o campo Preço");
            formNotEmpty = false;
        }
        if (edBrand.getText().toString().isEmpty()) {
            edBrand.requestFocus();
            edBrand.setError("Por favor preencha o campo Marca");
            formNotEmpty = false;
        }
        if (edModel.getText().toString().isEmpty()) {
            edModel.requestFocus();
            edModel.setError("Por favor preencha o campo Modelo");
            formNotEmpty = false;
        }
        if(edPhone.getText().toString().isEmpty()){
            edPhone.requestFocus();
            edPhone.setError("Por favor, preencha o campo Telefone");
            formNotEmpty = false;
        }
        if (edYear.getText().toString().isEmpty()) {
            edYear.requestFocus();
            edYear.setError("Por favor preencha o campo Ano");
            formNotEmpty = false;
        }
        if (formNotEmpty) {
            Motorcycle moto = new Motorcycle();
            moto.setOwner(LoggedUserUtil.LOGGED_USER);
            moto.setPrice(Double.parseDouble(edPrice.getText().toString()));
            moto.setBrand(edBrand.getText().toString());
            moto.setModel(edModel.getText().toString());
            moto.setPhone(edPhone.getText().toString());
            moto.setYear(Integer.parseInt(edYear.getText().toString()));

            control.save(moto);
            Intent intent = new Intent(getApplicationContext(), ListaMotorcycle.class);
            startActivity(intent);
            Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void cancel(View view) {
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            try {
                savePicture(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void savePicture(Bitmap bitmap) throws IOException {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File dir = cw.getDir("motoSharedImages", Context.MODE_PRIVATE);
        String name = LoggedUserUtil.LOGGED_USER.getUsername() + "-" + edModel.getText().toString() + "-" + edYear.getText().toString() + ".png";
        File photo = new File(dir, name);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(photo);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }
        hasPicture = true;
        openPicture(dir.getAbsolutePath());
    }

    private void openPicture(String dir) {
        File file = new File(dir, name);
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            imgView.setImageBitmap(bitmap);
            tvCamera.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
