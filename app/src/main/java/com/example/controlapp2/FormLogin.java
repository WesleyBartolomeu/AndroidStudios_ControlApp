package com.example.controlapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this,FormCadastro.class);
                startActivity(intent);
            }
        });

        buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();

                // Aqui você pode adicionar a lógica para validar o login do usuário

            }
        });
    }

    private void IniciarComponentes(){
        text_tela_cadastro = findViewById(R.id.remail_register);
        editTextEmail = findViewById(R.id.form_email);
        editTextSenha = findViewById(R.id.form_senha);

    }


}