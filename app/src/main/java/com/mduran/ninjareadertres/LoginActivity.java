package com.mduran.ninjareadertres;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    // Variables
    private EditText txtUsuario;
    private EditText txtPass;
    private CheckBox chkEdad;
    private ProgressBar barLoading;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        barLoading = findViewById(R.id.barLogin);
        barLoading.setVisibility(View.INVISIBLE);
        FirebaseApp.initializeApp(this);
        txtUsuario = findViewById(R.id.txtMail);
        txtPass = findViewById(R.id.txtPass);
        chkEdad = findViewById(R.id.chkEdad);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onButtonClickedReg(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        String email = txtUsuario.getText().toString();
        String password = txtPass.getText().toString();


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Inicio de sesión exitoso
                            Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent (LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            // Puedes redirigir a la siguiente actividad aquí
                        } else {
                            // Si el inicio de sesión falla, muestra un mensaje al usuario.
                            Toast.makeText(LoginActivity.this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show();
                            // Asegúrate de que los EditText estén inicializados correctamente
                            if (email == null || password == null) {
                                // Maneja el error, por ejemplo, mostrando un mensaje de log o una alerta
                                Log.e("LoginActivity", "Error: EditText no inicializado correctamente");
                                return;
                            }
                        }
                    }
                });
    }
}
