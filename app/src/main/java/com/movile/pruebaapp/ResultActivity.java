package com.movile.pruebaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_FIRST_NAME = "extra_first_name";
    public static final String EXTRA_LAST_NAME = "extra_last_name";
    public static final String EXTRA_CARNET = "extra_carnet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtName = findViewById(R.id.txtName);
        TextView txtLastName = findViewById(R.id.txtLastName);
        TextView txtCarnet = findViewById(R.id.txtCarnet);
        Button btnClose = findViewById(R.id.btnClose);

        String firstName = getIntent().getStringExtra(EXTRA_FIRST_NAME);
        String lastName = getIntent().getStringExtra(EXTRA_LAST_NAME);
        String carnet = getIntent().getStringExtra(EXTRA_CARNET);

        txtName.setText(firstName != null ? firstName : "");
        txtLastName.setText(lastName != null ? lastName : "");
        txtCarnet.setText(carnet != null ? carnet : "");

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

