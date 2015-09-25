package br.com.cast.turmaformacao.controledeestoque.controllers;

import android.app.Application;

import br.com.cast.turmaformacao.controledeestoque.controllers.util.ApplicationUtil;

/**
 * Created by Administrador on 25/09/2015.
 */
public class ProdutoManagerApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtil.setApplicationContext(getApplicationContext());

    }
}
