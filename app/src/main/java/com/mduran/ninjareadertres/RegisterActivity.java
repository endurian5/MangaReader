package com.mduran.ninjareadertres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    // Variables
    private EditText txtUsuario;
    private EditText txtPass;
    private EditText txtPassConfirm;
    private RadioButton rbHombre;
    private RadioButton rbMujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onButtonClicked(View view) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("Info");
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPass = findViewById(R.id.txtPass);
        txtPassConfirm = findViewById(R.id.txtPassConfirm);
        rbHombre = findViewById(R.id.rdHombre);
        rbMujer = findViewById(R.id.rdMujer);
        boolean genero;
        if(rbHombre.isChecked()){
            genero = false;
        }else{
            genero = true;
        }

        if (txtPass.getText().toString().equals(txtPassConfirm.getText().toString())) {
            if (rbHombre.isChecked() || rbMujer.isChecked()) {
                Usuario usuario = new Usuario(txtUsuario.getText().toString(), txtPass.getText().toString(), genero);
                ref = db.getReference("Usuarios:");
                ref.setValue(usuario);
                Intent intent = new Intent (this, LoginActivity.class);
                intent.putExtra("username", txtUsuario.getText().toString());
                intent.putExtra("pass", txtPass.getText().toString());
                startActivity(intent);

            } else {
                Toast.makeText(this, "Por favor, selecciona tu género", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }


    }
}