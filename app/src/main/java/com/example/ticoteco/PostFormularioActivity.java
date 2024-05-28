package com.example.ticoteco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ticoteco.modelo.Post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PostFormularioActivity extends AppCompatActivity {

    private EditText edtAssunto;
    private EditText edtPost;
    private EditText edtCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        edtAssunto = findViewById(R.id.edtAssunto);
        edtPost = findViewById(R.id.edtPost);
        edtCodigo = findViewById(R.id.edtCodigo);

        edtCodigo.setEnabled(false);

        setContentView(R.layout.activity_post_formulario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.formPost), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //evento de clique no FAB (Salvar Post)
        FloatingActionButton fabPostSalvar = findViewById(R.id.fabPostSalvar);
        fabPostSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ler dados do formulario
                int codigo =Integer.parseInt(edtCodigo.getText().toString());
                String assunto = edtAssunto.getText().toString();
                String post = edtPost.getText().toString();

                // montar objeto baseado nos dados lidos do formulário
                Post post = new Post();
                post.setId(codigo);
                post.setAssunto(assunto);
                post.setPost(post);

                // encerrar activity (fechar tela de formulário e voltar para lista)
                finish();
            }
        });

    }
}