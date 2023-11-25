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
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    // Variables
    private EditText txtMail;
    private EditText txtPass;
    private EditText txtPassConfirm;
    private RadioButton rbHombre;
    private RadioButton rbMujer;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register);
        txtMail = findViewById(R.id.txtCorreo);
        txtPass = findViewById(R.id.txtPass);
        txtPassConfirm = findViewById(R.id.txtPassConfirm);
        rbHombre = findViewById(R.id.rdHombre);
        rbMujer = findViewById(R.id.rdMujer);
    }
    public void registrar(View view) {
        String email = txtMail.getText().toString();
        String password = txtPass.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registro exitoso
                            Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent (RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);

                        } else {
                            // Si el registro falla, muestra un mensaje al usuario.
                            Toast.makeText(RegisterActivity.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    }
