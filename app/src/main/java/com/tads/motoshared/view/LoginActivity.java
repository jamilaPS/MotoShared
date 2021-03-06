package com.tads.motoshared.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tads.motoshared.R;
import com.tads.motoshared.control.UserControl;
import com.tads.motoshared.model.User;
import com.tads.motoshared.util.LoggedUserUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText edUser;
    private EditText edPassword;
    private User user;
    private UserControl control = new UserControl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser = (EditText) findViewById(R.id.et_username);
        edPassword = (EditText) findViewById(R.id.et_password);
    }

    public void rememberPassword(View v){

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Título Email");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Teste email");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "mariadefatima775@hotmail.com");
        emailIntent.setType("message/rfc822");
        startActivity(emailIntent);

    }

    public void login(View view)
    {
        User user = control.login(edUser.getText().toString(), edPassword.getText().toString());
        if(user != null)
        {
            LoggedUserUtil.LOGGED_USER = user;
            Intent intent = new Intent(getApplicationContext(), MainProfile.class);
            startActivity(intent);
        }
    }

    public void createAccount(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
        startActivity(intent);
    }
}
