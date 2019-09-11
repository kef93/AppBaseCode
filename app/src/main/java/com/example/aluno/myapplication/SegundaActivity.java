package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        TextView viewNome = (TextView) findViewById(R.id.txvNome);
        TextView viewIdade = (TextView) findViewById(R.id.txvIdade);
        TextView viewSexo = (TextView) findViewById(R.id.txvSexo);

        Intent intent = getIntent();
        Bundle dados = new Bundle();
        dados = intent.getExtras();
        viewNome.setText("Bem vindo " + dados.get("nome"));
        viewIdade.setText("Sua idade: " +dados.get("idade"));
        viewSexo.setText("Seu sexo " +dados.get("sexo"));

    }

    @Override
    public void finish() {
        Intent dados = new Intent();
        dados.putExtra("retorno", "retornando da segunda");
        setResult(100, dados);
        super.finish();
    }
}
