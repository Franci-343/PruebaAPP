package com.movile.pruebaapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editFirstName;
    private EditText editLastName;
    private EditText editCarnet;
    private Button btnLogin;
    private Button btnSalir;
    private TextView textGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editCarnet = findViewById(R.id.editCarnet);
        btnLogin = findViewById(R.id.btnLogin);
        btnSalir = findViewById(R.id.btnSalir);
        textGreeting = findViewById(R.id.textGreeting);

        // Manejar insets para Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Listener del botón Salir
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la aplicación
                finishAffinity();
            }
        });

        // Listener del botón Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editFirstName.getText().toString().trim();
                String lastName = editLastName.getText().toString().trim();
                String carnet = editCarnet.getText().toString().trim();

                if (TextUtils.isEmpty(firstName)) {
                    editFirstName.setError("Ingrese el nombre");
                    editFirstName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(lastName)) {
                    editLastName.setError("Ingrese el apellido");
                    editLastName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(carnet)) {
                    editCarnet.setError("Ingrese el carnet");
                    editCarnet.requestFocus();
                    return;
                }
                if (carnet.length() < 3) {
                    editCarnet.setError("El carnet debe tener al menos 3 caracteres");
                    editCarnet.requestFocus();
                    return;
                }

                String greeting = "Hola, " + firstName + " " + lastName + " (Carnet: " + carnet + ")!";
                textGreeting.setText(greeting);
            }
        });
    }
}