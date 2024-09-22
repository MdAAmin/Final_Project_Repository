package com.example.menumade;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int TRANSITION_DURATION = 3000; // 3 seconds animation jonno

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startProgressBar();
    }

    private void startProgressBar() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, WelcomePage.class);
            startActivity(intent);
            finish();
        }, TRANSITION_DURATION);
    }
}
