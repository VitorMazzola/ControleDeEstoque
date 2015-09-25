package br.com.cast.turmaformacao.controledeestoque.controllers.controllers.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.cast.turmaformacao.controledeestoque.R;
import br.com.cast.turmaformacao.controledeestoque.controllers.controllers.adapters.ProdutoListAdapter;
import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities.Produto;
import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.services.ProdutoBusinessService;

public class ListProdutoActivity extends AppCompatActivity{

    private ListView listViewProdutoList;
    private Produto selectedProduto;
    private List<Produto> getProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produto);

        bindProdutoList();
    }

    private void bindProdutoList() {

        listViewProdutoList = (ListView) findViewById(R.id.listViewProdutoList);
        registerForContextMenu(listViewProdutoList);

        listViewProdutoList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ProdutoListAdapter adapter = (ProdutoListAdapter) listViewProdutoList.getAdapter();
                selectedProduto = (Produto) adapter.getItem(position);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_produto_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                onMenuAddClick();
                break;
        }
        
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        onUpdateList();
        super.onResume();
    }

    private void onUpdateList() {
        List<Produto> values = ProdutoBusinessService.findAll();
        listViewProdutoList.setAdapter(new ProdutoListAdapter(this, values));
        ProdutoListAdapter adapter = (ProdutoListAdapter) listViewProdutoList.getAdapter();
        adapter.notifyDataSetChanged();
    }

    private void onMenuAddClick() {
        Intent goToCadastroProdutoActivity = new Intent(ListProdutoActivity.this, CadastroProdutoActivity.class);
        startActivity(goToCadastroProdutoActivity);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_produto_list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_excluir:
                onMenuDeleteClick();
                break;
            case R.id.menu_editar:
                onMenuUpdateClick();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void onMenuUpdateClick() {
        Intent goToCadastroProduto = new Intent(ListProdutoActivity.this, CadastroProdutoActivity.class);
        goToCadastroProduto.putExtra(CadastroProdutoActivity.PARAM_TASK,selectedProduto);
        startActivity(goToCadastroProduto);
    }

    private void onMenuDeleteClick() {
        new AlertDialog.Builder(ListProdutoActivity.this)
                .setTitle(R.string.lbl_confirm)
                .setMessage(R.string.msg_confirm_delete)
                .setPositiveButton(R.string.lbl_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProdutoBusinessService.delete(selectedProduto);
                        selectedProduto = null;
                        String message = getString(R.string.msg_delete_sucessfull);
                        onUpdateList();
                        Toast.makeText(ListProdutoActivity.this, message, Toast.LENGTH_LONG).show();

                    }
                })
                .setNeutralButton(R.string.lbl_no, null)
                .create()
                .show();
    }


}
