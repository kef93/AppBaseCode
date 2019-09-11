package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editNome = (EditText) findViewById(R.id.txtNome);
        final EditText editIdade = (EditText) findViewById(R.id.txtIdade);
        final EditText editSexo = (EditText) findViewById(R.id.txtSexo);
        Button btAction = (Button) findViewById(R.id.btnAcessar);

        btAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                Bundle dados = new Bundle();

                dados.putString("nome", editNome.getText().toString());
                dados.putString("idade", editIdade.getText().toString());
                dados.putString("sexo", editSexo.getText().toString());

                intent.putExtras(dados);
                startActivity(intent);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == 100&&
                requestCode == 200){
            if(data.hasExtra("retorno")){
                Toast.makeText(this, "O parâmetro enviado foi "+
                data.getExtras().getString("retorno"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
