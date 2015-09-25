package br.com.cast.turmaformacao.controledeestoque.controllers.controllers.asyncTask;

import android.os.AsyncTask;

import java.util.List;

import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities.Produto;

public abstract class ProdutoAsyncTaskSave extends AsyncTask<String, Void, List<Produto>> {
    @Override
    protected List<Produto> doInBackground(String... params) {
        return null;
    }
}
