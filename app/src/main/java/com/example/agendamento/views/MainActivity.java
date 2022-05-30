package com.example.agendamento.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.agendamento.R;
import com.example.agendamento.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Declaracao das variaveis
    private ActivityMainBinding binding;

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botao para a tela de novo agendamento
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewAgendamento.class);
                startActivity(intent);
            }
        });

        // Botao para a tela do ultimo agendamento
        binding.btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Agendamentos.class);
                startActivity(intent);
            }
        });
    }
}