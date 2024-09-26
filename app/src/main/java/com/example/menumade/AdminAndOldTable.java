package com.example.menumade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminAndOldTable extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_and_old_table);

        databaseHelper = new DatabaseHelper(this);

        usernameEditText = findViewById(R.id.AD_ed);
        passwordEditText = findViewById(R.id.pass_ed);

        Button loginButton = findViewById(R.id.BTN_LOGIN);
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (databaseHelper.checkUser(username, password)) {
                Toast.makeText(AdminAndOldTable.this, "Customer Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(AdminAndOldTable.this, CustomerConnectionActivity.class);
                startActivity(intent2);
            } else {
                Toast.makeText(AdminAndOldTable.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
        });

        Button adminButton = findViewById(R.id.BTN_ADMIN);
        adminButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (databaseHelper.checkAdmin(username, password)) {
                Toast.makeText(AdminAndOldTable.this, "Admin Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(AdminAndOldTable.this, AdminHome.class);
                startActivity(intent1);
            } else {
                Toast.makeText(AdminAndOldTable.this, "Invalid Admin Username or Password", Toast.LENGTH_SHORT).show();
            }
        });

        Button backButton = findViewById(R.id.BTN_Back);
        backButton.setOnClickListener(v -> {
            Intent intent3 = new Intent(AdminAndOldTable.this, MainActivity.class);
            startActivity(intent3);
        });
    }
}
