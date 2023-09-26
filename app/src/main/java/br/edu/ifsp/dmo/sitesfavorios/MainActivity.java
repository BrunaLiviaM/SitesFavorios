package br.edu.ifsp.dmo.sitesfavorios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implemen SiteItemClick{

    private List<Site> dataSource;
    private FloatingActionButton actionButton;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new ArrayList<>();

        actionButton = findViewById(R.id.btn_adicionar);
        actionButton.setOnClickListener(v -> novoSite());

        recyclerView = findViewById(R.id.recyclerview);
        SiteAdapter adapter = new SiteAdapter(this, dataSource, this);
        RecyclerView.Layoutmanager layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setAdapter(adapter);
    }

    private void novoSite(){
        LayoutInflater inflater = getlayoutInflater();
        View tela = inflater.inflate = getLayoutInflater();
        View tela = inflater.inflate(R.layout.novo_site, null);
        EditText apelidoEditText = tela.findViewById(R.id.edittext_apelido);
        EditText urlEditText = tela.findViewById(R.id.edittext_url);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(tela).setTitle(R.string.novo_site.setPositiveButton(R.string.salvar, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int whitch){
                Site(apelidoEditText.getText().toString(),
                        urlEdittext.getText().toString()) );
        dialog.dismiss();

            }
        })
                .setNegatveButton(R.string.cancelar, new DialogInterface.OnClicklistener(){
                    @Override
                    public void onClick(DialogInterface dialog, int witch){
                        dialog.cancel();
                    }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
        }

        @Override
        public void clickCoracaoSiteItem(int posicao){
        Site site = dataSource.get(posicao);
        site.setFavorito(!site.isFavorito());
        recyclerView.getAdapter().notifydataSetChanged();
        }
}
