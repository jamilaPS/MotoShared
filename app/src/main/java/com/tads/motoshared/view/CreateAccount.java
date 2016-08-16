package com.tads.motoshared.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tads.motoshared.R;
import com.tads.motoshared.control.UserControl;
import com.tads.motoshared.model.User;

public class CreateAccount extends AppCompatActivity {
    UserControl control = new UserControl();
    EditText edName;
    EditText edUsername;
    EditText edPassword;
    EditText edAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        edName = (EditText) findViewById(R.id.ed_name);
        edUsername = (EditText) findViewById(R.id.ed_username);
        edPassword = (EditText) findViewById(R.id.ed_password);
        edAge = (EditText) findViewById(R.id.ed_age);
    }

    public void save(View view)
    {
        User user = new User();
        user.setName(edName.getText().toString());
        user.setUsername(edUsername.getText().toString());
        user.setPassword(edPassword.getText().toString());
        user.setAge(Integer.parseInt(edAge.getText().toString()));

        control.save(user);
        Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void cancel(View view)
    {
        finish();
    }
}
