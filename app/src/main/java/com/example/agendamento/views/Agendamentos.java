package com.example.agendamento.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.agendamento.R;
import com.example.agendamento.databinding.ActivityAgendamentosBinding;


public class Agendamentos extends AppCompatActivity {

    private ActivityAgendamentosBinding binding;

    TextView tvNome, tvHorario, tvAgendamento;
    Button btnSair;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);
        getSupportActionBar().hide();

        binding = ActivityAgendamentosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tvNome = binding.tvNome;
        tvHorario = binding.tvHorario;
        tvAgendamento = binding.tvAgendamento;
        btnSair = binding.btnSair;

        preferences = getSharedPreferences("chaveGeral", MODE_PRIVATE);

        String name = preferences.getString("chaveNome", "");
        tvNome.setText(name);
        String agendamento = preferences.getString("chaveAgendamento", "");
        tvAgendamento.setText(agendamento);
        String horario = preferences.getString("chaveHorario", "");
        tvHorario.setText(horario);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(Agendamentos.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}