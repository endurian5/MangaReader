package com.mduran.ninjareadertres;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.mduran.ninjareadertres.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.*;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.settings);

    }
    InicioFragment inicioFragment = new InicioFragment();
    FavoritosFragment favoritosFragment = new FavoritosFragment();

    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == R.id.inicio){
            System.out.println("1");
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, inicioFragment).commit();
            return true;
        }
        else if (item.getItemId() == R.id.favoritos) {
            System.out.println("2");
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, favoritosFragment).commit();
            return true;
        }
        else if (item.getItemId() == R.id.settings) {
            System.out.println("3");
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, settingsFragment).commit();
            return true;
        }
        return false;
    }
}