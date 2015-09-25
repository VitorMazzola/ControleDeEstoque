package br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities.Produto;

public final class CadastroProdutoRepository {

    private CadastroProdutoRepository(){
        super();
    }

    public static void save(Produto produto) {

        DataBaseHelper dataBaseHelper = DataBaseHelper.getInstance();

        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        ContentValues values = CadastroProdutoContract.getContentValues(produto);

        if (produto.getId() == null) {

            db.insert(CadastroProdutoContract.TABLE, null, values);

        } else {

            String where = CadastroProdutoContract.ID + " = ? ";
            String[] params = {produto.getId().toString()};
            db.update(CadastroProdutoContract.TABLE, values, where, params);
        }

        db.close();
        dataBaseHelper.close();

    }

    public static void delete(long id) {

        DataBaseHelper dataBaseHelper = DataBaseHelper.getInstance();
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        String where = CadastroProdutoContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};

        db.delete(CadastroProdutoContract.TABLE, where, params);

        db.close();
        dataBaseHelper.close();

    }

    public static List<Produto> getAll() {

        DataBaseHelper dataBaseHelper = DataBaseHelper.getInstance();
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        Cursor cursor = db.query(CadastroProdutoContract.TABLE, CadastroProdutoContract.COLUNS, null, null, null, null, CadastroProdutoContract.ID);
        List<Produto> values = CadastroProdutoContract.getProdutos(cursor);

        db.close();
        dataBaseHelper.close();

        return values;

    }

}
