package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText username, password;
    private Button btnMasuk;
    private TextView daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.edt_username_login);
        password = findViewById(R.id.edt_password_login);
        btnMasuk = findViewById(R.id.btn_masuk);
        daftar = findViewById(R.id.tv_daftar_login);

        btnMasuk.setOnClickListener(this);
        daftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_masuk:
                loginUser();
                break;
            case R.id.tv_daftar_login:
                Intent reg = new Intent(this, RegisterActivity.class);
                startActivity(reg);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
        }

    }

    private void loginUser() {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(user)) {
            isEmptyFields = true;
            username.setError("Field ini tidak boleh kosong");
        }

        if (TextUtils.isEmpty(pass)) {
            isEmptyFields = true;
            password.setError("Field ini tidak boleh kosong");
        }

            Intent reg = new Intent(this, MainActivity.class);
            startActivity(reg);




    }
}
