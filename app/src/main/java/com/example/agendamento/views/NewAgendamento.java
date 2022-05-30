package com.example.agendamento.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agendamento.R;
import com.example.agendamento.databinding.ActivityNewAgendamentoBinding;

public class NewAgendamento extends AppCompatActivity {

    // Declaracao das variaveis
    private ActivityNewAgendamentoBinding binding;

    private Button btnSave;
    private EditText edtName, edtTime, edtAgendamento;
    boolean lembrar = false;

    SharedPreferences sharedPreferences;

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_agendamento);
        getSupportActionBar().hide();
        //SharedPreferences
        sharedPreferences = getSharedPreferences("chaveGeral", MODE_PRIVATE);

        // Binding
        binding = ActivityNewAgendamentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Pegando os elementos da tela
        btnSave = binding.btnSave;
        edtName = binding.edtName;
        edtTime = binding.edtTime;
        edtAgendamento = binding.edtAgendamento;

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Salvar os dados da activity em variaveis locais
                String nome = edtName.getText().toString();
                String agendamento = edtAgendamento.getText().toString();
                String horario = edtTime.getText().toString();

                // Shared Preferences  e suas chaves
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("chaveNome", nome);
                editor.putString("chaveHorario", horario);
                editor.putString("chaveAgendamento", agendamento);
                editor.apply();

                // Toast para aparecer que foi salvo
                Toast.makeText(NewAgendamento.this, "Seu agendamento foi salvo com sucesso !", Toast.LENGTH_SHORT).show();

                // Intençao para a proxima tela
                Intent intent = new Intent(NewAgendamento.this, Agendamentos.class);
                startActivity(intent);
                finish();
            }
        });
    }
}