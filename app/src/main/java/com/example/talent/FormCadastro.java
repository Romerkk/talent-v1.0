package com.example.talent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FormCadastro extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private EditText edit_nome_completo,edit_email,edit_senha,edit_experiencias,edit_habilidades;
    private Button bt_Inscrever;

    private Button edit_voltar;

    String[] mensagens = {"preecha todos dos campos","Cadastro realizado com sucesso"};
    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        getSupportActionBar().hide();

        IniciarComponentes();


        edit_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormCadastro.this,formLogin.class);
                startActivity(intent);







            }
        });


        bt_Inscrever.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                String nome = edit_nome_completo.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                String experiencia = edit_experiencias.getText().toString();
                String habilidades = edit_habilidades.getText().toString();

                if (nome.isEmpty()  || email.isEmpty() || senha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                     CadastrarUsuario(v);



                }






            }


        });


    }
                private void CadastrarUsuario(View v){
                    String email = edit_email.getText().toString();
                    String senha = edit_senha.getText().toString();

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                SalvarDadosUsuario();

                                Snackbar snackbar = Snackbar.make(v,mensagens[1],Snackbar.LENGTH_SHORT);
                                snackbar.setBackgroundTint(Color.WHITE);
                                snackbar.setTextColor(Color.BLACK);
                                snackbar.show();
                            }else {
                                String erro;
                                try {
                                    throw task.getException();

                                    }catch (FirebaseAuthWeakPasswordException e){
                                    erro = "digite uma senha com no minimo 6 caracteres";
                                }catch (FirebaseAuthUserCollisionException e) {
                                    erro = "Esta conta ja foi cadastrada";
                                }catch (FirebaseAuthInvalidCredentialsException e){
                                    erro = "Email invalido";

                                }catch (Exception e){
                                    erro = "Erro ao cadastrar usuario";
                                }

                                Snackbar snackbar = Snackbar.make(v,erro,Snackbar.LENGTH_SHORT);
                                snackbar.setBackgroundTint(Color.WHITE);
                                snackbar.setTextColor(Color.BLACK);
                                snackbar.show();

                            }

                        }


                    });




    }


    private void  SalvarDadosUsuario(){
        String nome = edit_nome_completo.getText().toString();
        String habilidade = edit_habilidades.getText().toString();
        String experiencias = edit_experiencias.getText().toString();


        FirebaseFirestore db =FirebaseFirestore.getInstance();
        Map<String,Object> usuarios = new HashMap<>();
        usuarios.put("nome",nome);
        usuarios.put("habilidade",habilidade);
        usuarios.put("experiencia",experiencias);

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = db.collection( "Usuarios").document(usuarioID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("db",  "Sucesso ao salvar os dados");



            }

        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_error", "Erro ao salvar os dados" + e.toString());

                    }
                });


    }






    private void IniciarComponentes(){

        edit_nome_completo = findViewById(R.id.edit_nome_usuario);
        edit_email = findViewById(R.id.edit_email);
        edit_senha =findViewById(R.id.edit_senha);
        bt_Inscrever = findViewById(R.id.edit_Inscrever);
        edit_experiencias = findViewById(R.id.edit_experiencia);
        edit_habilidades = findViewById(R.id.edit_habilidades);
        edit_voltar = findViewById(R.id.edit_voltar);
        }
    }