package com.example.talent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class formLogin extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private EditText edit_email,edit_senha;
    private Button bt_conectar;

    private TextView text_tela_reset;


    String[] mensagens = {"preecha todos dos campos","Login efetuado com sucesso"};
    private Intent formLogin;

    public formLogin() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();

        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(formLogin.this,FormCadastro.class);
                startActivity(intent);



            }
        });


        IniciarComponentes();

        text_tela_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.talent.formLogin.this,FormResetSenha.class);
                startActivity(intent);
            }
        });



        bt_conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, senha;
                email = String.valueOf(edit_email.getText());
                senha = String.valueOf(edit_senha.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(formLogin.this,"Digite seu e-mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(senha)){
                    Toast.makeText(formLogin.this, "Digite sua senha", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    TelaPrincipal();

                                }
                            }, 1000);

                        }else {
                            Toast.makeText(formLogin.this, "Falha ao efetuar login, Tente novamente", Toast.LENGTH_SHORT).show();
                        }



                    }
                });

            }
        });
    }





    private void TelaPrincipal(){
        Intent intent = new Intent(formLogin.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private  void IniciarComponentes(){
        text_tela_cadastro=findViewById(R.id.text_tela_cadastro);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        bt_conectar = findViewById(R.id.bt_conectar);
        text_tela_reset = findViewById(R.id.text_tela_reset);




    }
}