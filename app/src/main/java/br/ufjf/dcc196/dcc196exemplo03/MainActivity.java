package br.ufjf.dcc196.dcc196exemplo03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rvPessoas;
    public static List<String> pessoas = new ArrayList<String>(){{
       add("Item 0");
       add("Item 1");
       add("Item 2");
       add("Item 3");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPessoas = (RecyclerView) findViewById(R.id.rv_pessoas);
        rvPessoas.setAdapter(new PessoasAdapter(pessoas));
        rvPessoas.setLayoutManager(new LinearLayoutManager(this));
        final PessoasAdapter adapter = new PessoasAdapter(pessoas);
        adapter.setOnPessoaClickListener(new PessoasAdapter.OnPessoaClickListener() {
            @Override
            public void onPessoaClick(View view, int position) {
                Toast.makeText(MainActivity.this, pessoas.get(position), Toast.LENGTH_SHORT).show();
                pessoas.add("Item " + pessoas.size());
                pessoas.set(position, pessoas.get(position) + "*");
                adapter.notifyItemChanged(pessoas.size()-1);
            }
        });
        rvPessoas.setAdapter(adapter);
    }
}
