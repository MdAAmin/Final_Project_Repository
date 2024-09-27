package com.example.menumade;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {

    private EditText adminNameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        adminNameEditText = findViewById(R.id.ed_admin_name);
        passwordEditText = findViewById(R.id.ed_password);

        Button loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(v -> {
            String adminName = adminNameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (databaseHelper.checkAdmin(adminName, password)) {
                Intent intent = new Intent(AdminLogin.this, AdminAndOldTable.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(AdminLogin.this, "Invalid Admin Name or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
