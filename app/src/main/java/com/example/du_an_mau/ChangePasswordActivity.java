package com.example.du_an_mau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau.dao.UserDAO;
import com.example.du_an_mau.model.User;

import java.util.ArrayList;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Button btnChangePass = findViewById(R.id.btnChangePasss);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePassword();
            }
        });
        goLogin();


    }

    public void changePassword(){
        EditText edtUser = findViewById(R.id.edtUsername);
        EditText edtPass = findViewById(R.id.edtPassword);
        EditText edtNewPass = findViewById(R.id.edtNewPassword);
        EditText edtConfirmNewPass = findViewById(R.id.edtConfirmNewPassword);



        String user = edtUser.getText().toString();
        String pass = edtPass.getText().toString();
        String newPass = edtNewPass.getText().toString();
        String confirmNewPass = edtConfirmNewPass.getText().toString();

        UserDAO userDAO = new UserDAO(ChangePasswordActivity.this);

        int check = userDAO.updatePass(user, pass, newPass);
        if(!newPass.equals(confirmNewPass)){
            Toast.makeText(ChangePasswordActivity.this, "Mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (check) {
            case 1:
                Toast.makeText(ChangePasswordActivity.this, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                break;
            case 0:

                Toast.makeText(ChangePasswordActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
        }

    }


    public void goLogin(){
        TextView txtGoLogin = findViewById(R.id.txtGoLogin);

        txtGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}