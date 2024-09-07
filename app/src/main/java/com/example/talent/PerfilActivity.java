package com.example.talent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class PerfilActivity extends AppCompatActivity {


    private TextView edit_nome,edit_email,edit_experiencias,edit_habilidade;
    private Button bt_desconectar;

    private Button bottom_voltarhome;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_perfil );



        getSupportActionBar().hide();

        IniciarComponentes ();

        bt_desconectar.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance ().signOut ();
                Intent intent = new Intent (PerfilActivity.this,formLogin.class);
                startActivity ( intent );
                finish ();


            }
        } );

        bottom_voltarhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.talent.PerfilActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });




    }


    @Override
    protected void onStart() {
        super.onStart ();

        String email = FirebaseAuth.getInstance ().getCurrentUser ().getEmail ();
        usuarioID = FirebaseAuth.getInstance ().getCurrentUser ().getUid ();
        DocumentReference documentReference = db.collection ( "Usuarios").document (usuarioID);
        documentReference.addSnapshotListener ( new EventListener<DocumentSnapshot> () {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null){
                    edit_nome.setText ( documentSnapshot.getString ( "nome" ) );
                    edit_email.setText ( email );
                    edit_experiencias.setText(documentSnapshot.getString("experiencia"));
                    edit_habilidade.setText(documentSnapshot.getString("habilidade"));
                }


            }
        } );





    }

    private void IniciarComponentes(){

        edit_nome = findViewById ( R.id.edit_Nome );
        edit_email = findViewById ( R.id.edit_email );
        bt_desconectar = findViewById ( R.id.bt_desconectar);
        edit_experiencias = findViewById ( R.id.edit_experiencias );
        edit_habilidade = findViewById ( R.id.edit_habilidade );
        bottom_voltarhome = findViewById ( R.id.bottom_voltarhome );

    }

        
    }





