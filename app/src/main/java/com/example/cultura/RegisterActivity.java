package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView btnMasuk;
    private EditText username, namaLengkap, email, noTelp, password;
    private Button daftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.edt_username_register);
        namaLengkap = findViewById(R.id.edt_namaLengkap_register);
        email = findViewById(R.id.edt_email_register);
        noTelp = findViewById(R.id.edt_noTelp_register);
        password = findViewById(R.id.edt_password_register);

        btnMasuk = findViewById(R.id.tv_masuk_register);
        btnMasuk.setOnClickListener(this);

        daftar = findViewById(R.id.btn_register);
        daftar.setOnClickListener(this);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_masuk_register:
                Intent reg = new Intent(this, LoginActivity.class);
                startActivity(reg);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.btn_register:
                register();
                break;
        }
    }

    private void register() {
        String user = username.getText().toString();
        String nama = namaLengkap.getText().toString();
        String eMail = email.getText().toString();
        String nomer = noTelp.getText().toString();
        String pass = password.getText().toString();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(user)) {
            isEmptyFields = true;
            username.setError("Field ini tidak boleh kosong");
        }
        if (TextUtils.isEmpty(nama)) {
            isEmptyFields = true;
            namaLengkap.setError("Field ini tidak boleh kosong");
        }
        if (TextUtils.isEmpty(eMail)) {
            isEmptyFields = true;
            email.setError("Field ini tidak boleh kosong");
        }
        if (TextUtils.isEmpty(nomer)) {
            isEmptyFields = true;
            noTelp.setError("Field ini tidak boleh kosong");
        }
        if (TextUtils.isEmpty(pass)) {
            isEmptyFields = true;
            password.setError("Field ini tidak boleh kosong");
        }

        Intent reg = new Intent(this, HomeActivity.class);
        startActivity(reg);
    }
}
