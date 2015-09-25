package br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.cast.turmaformacao.controledeestoque.controllers.util.ApplicationUtil;

public class DataBaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "estoquedb";
    private static final int DATABASE_VERSION = 1;


    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DataBaseHelper getInstance(){
        return new DataBaseHelper(ApplicationUtil.getApplicationContext());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.e("Task Manager", "Criando Tabela Task");
        db.execSQL(CadastroProdutoContract.getCreateTableScript());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
