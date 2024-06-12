package com.example.du_an_mau;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private boolean hasNavigated = false;
    private Handler handler = new Handler();
    private Runnable navigateRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        LinearLayout linearLayout = findViewById(R.id.activityStar);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }
        });

        onActivity3s();
    }

    private void onActivity3s() {
        navigateRunnable = new Runnable() {
            @Override
            public void run() {
                goLogin();
            }
        };
        handler.postDelayed(navigateRunnable, 3000);
    }

    private synchronized void goLogin() {
        if (!hasNavigated) {
            hasNavigated = true;
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(navigateRunnable);
    }
}
