package com.mduran.ninjareadertres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // Variables
    private EditText txtUsuario;
    private EditText txtPass;
    private CheckBox chkEdad;
    private ProgressBar barLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        barLoading = findViewById(R.id.barLogin);
        barLoading.setVisibility(View.INVISIBLE);

    }

    public void onButtonClicked(View view) {
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPass = findViewById(R.id.txtPass);
        chkEdad = findViewById(R.id.chkEdad);

        // Traigo los datos del otro intent
        Bundle datos = LoginActivity.this.getIntent().getExtras();
        String user = datos.getString("username");
        String pass = datos.getString("pass");

        if(txtUsuario.getText().toString().equals(user) && txtPass.getText().toString().equals(pass) && chkEdad.isChecked() ){
            try {
                // Sleep for 200 milliseconds.
                Thread.sleep(600);
                barLoading.setVisibility(View.VISIBLE);
                Intent intent = new Intent (this, MainActivity.class);
                startActivity(intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            String error = "Usuario y/o clave invalid@";
            System.out.println(user);
            System.out.println(pass);
            Toast toast = Toast.makeText(this, error, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90, 0);
            toast.show();
            if(!chkEdad.isChecked()){
                String errorEdad = "Debes ser mayor de doce años.";
                Toast toastEdad = Toast.makeText(this, errorEdad, Toast.LENGTH_SHORT);
                toastEdad.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90, 0);
                toastEdad.show();
            }
        }

    }

    public void onButtonClickedReg(View view) {
        Intent intent = new Intent (this, RegisterActivity.class);
        startActivity(intent);
    }
}