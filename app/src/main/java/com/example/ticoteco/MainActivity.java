package com.example.ticoteco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ListView lvtPostsLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //componente de lista
        lvtPostsLista = findViewById(R.id.lvtPostsLista);

        //evento de clique no FAB (Novo Post)
        FloatingActionButton fabPostNovo = findViewById(R.id.fabPostNovo);
        fabPostNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirPostFormulario = new Intent(MainActivity.this, PostFormularioActivity.class);
                startActivity(abrirPostFormulario);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        recarregarLista();
    }

    private void recarregarLista() {
        //Fontede de dados
        PostDAO postDAO = new PostDAO(PostListaActivity.this);
        ArrayList<Contato> posts = postDAO.pesquisarTodos();

        //Adptador
        PostArrayAdapter adaptador = new PostArrayAdapter(PostListaActivity.this, R.layout.item_post, posts);

        //Associar Adaptador ao componete de lista
        lvtContatos.setAdapter(adaptador);
    }
}