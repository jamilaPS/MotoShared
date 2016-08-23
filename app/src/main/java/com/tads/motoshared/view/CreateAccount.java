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
    //EditText edName;
    EditText edUsername;
    EditText edPassword;
    EditText edEmail;
    //EditText edAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        edUsername = (EditText) findViewById(R.id.ed_username);
        edPassword = (EditText) findViewById(R.id.ed_password);
        edEmail = (EditText) findViewById(R.id.ed_email);

    }

    public void save(View view)
    {
        boolean formNotEmpty = true;
        if(edUsername.getText().toString().isEmpty()){
            edUsername.requestFocus();
            edUsername.setError("Por favor preencha o campo Nome de Usuário");
            formNotEmpty = false;
        }
        if(edPassword.getText().toString().isEmpty()){
            edPassword.requestFocus();
            edPassword.setError("Por favor preencha o campo Senha");
            formNotEmpty = false;
        }

        if(edEmail.getText().toString().isEmpty()){
            edEmail.requestFocus();
            edEmail.setError("Por favor preencha o campo Email");
            formNotEmpty = false;
        }
        if(formNotEmpty){
            User user = new User();

            user.setUsername(edUsername.getText().toString());
            user.setPassword(edPassword.getText().toString());
            user.setEmail(edEmail.getText().toString());

            control.save(user);
            Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void cancel(View view)
    {
        finish();
    }
}
