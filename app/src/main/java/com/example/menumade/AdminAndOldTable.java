package com.example.menumade;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminAndOldTable extends AppCompatActivity {

    private EditText tableNameEditText, tableNumberEditText, tableCapacityEditText;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_and_old_table);

        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) View layout = inflater.inflate(R.layout.toaster, findViewById(R.id.go));

        Toast customToast = new Toast(getApplicationContext());
        customToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        customToast.setDuration(Toast.LENGTH_SHORT);
        customToast.setView(layout);
        databaseHelper = new DatabaseHelper(this);

        tableNameEditText = findViewById(R.id.AD_ed);
        tableNumberEditText = findViewById(R.id.pass_ed);
        tableCapacityEditText = findViewById(R.id.table_capacity);

        Button addTableButton = findViewById(R.id.BTN_Add_Table);
        addTableButton.setOnClickListener(v -> {
            String tableName = tableNameEditText.getText().toString();
            String tableNumber = tableNumberEditText.getText().toString();
            String tableCapacityStr = tableCapacityEditText.getText().toString();

            if (!tableName.isEmpty() && !tableNumber.isEmpty() && !tableCapacityStr.isEmpty()) {

                int tableCapacity = Integer.parseInt(tableCapacityStr);
                databaseHelper.addTable(tableName, tableNumber, tableCapacity);
                Toast.makeText(AdminAndOldTable.this, "Table Added Successfully", Toast.LENGTH_SHORT).show();


                tableNameEditText.setText("");
                tableNumberEditText.setText("");
                tableCapacityEditText.setText("");
            } else {
                Toast.makeText(AdminAndOldTable.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });


        Button adminButton = findViewById(R.id.BTN_ADMIN);
        adminButton.setOnClickListener(v -> {
            customToast.show();
            Intent intent1 = new Intent(AdminAndOldTable.this, AdminLogin.class);
            startActivity(intent1);
        });

        Button backButton = findViewById(R.id.BTN_Back);
        backButton.setOnClickListener(v -> {

            Intent intent3 = new Intent(AdminAndOldTable.this, MainActivity.class);
            startActivity(intent3);
        });
    }
}
