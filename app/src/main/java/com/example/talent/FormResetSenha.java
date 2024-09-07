package com.example.talent;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class FormResetSenha extends AppCompatActivity {

    private Button edit_voltar;
    private EditText edit_email;
    private Button edit_esqueceuSenha;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_reset_senha);

        edit_email = findViewById(R.id.edit_email);
        edit_esqueceuSenha = findViewById(R.id.edit_esqueceuSenha);
        mAuth = FirebaseAuth.getInstance();

        edit_esqueceuSenha.setOnClickListener(v -> {
            String email = edit_email.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(FormResetSenha.this, "Por favor, digite seu E-mail!", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(FormResetSenha.this, "Por favor, verifique seu e-mail para redefinir sua senha.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(FormResetSenha.this, "Falha ao enviar e-mail para redefinição de senha", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });




        getSupportActionBar().hide();

        IniciarComponentes();

        edit_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormResetSenha.this,formLogin.class);
                startActivity(intent);







            }
        });









    }
    private  void IniciarComponentes(){
        edit_voltar = findViewById(R.id.edit_voltar);


    }


    }












