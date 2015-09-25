package br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities.Produto;

public final class CadastroProdutoContract {

    public static final String TABLE = "task";
    public static final String ID = "id";
    public static final String IMAGEM = "imagem";
    public static final String NOME = "nome";
    public static final String DESCRICAO = "descricao";
    public static final String QUANTIDADE = "quantidade";
    public static final String QUANTIDADE_MINIMA = "quantidade_minima";
    public static final String VALOR = "valor";

    public static final String[] COLUNS = {ID, IMAGEM, NOME, DESCRICAO, QUANTIDADE, QUANTIDADE_MINIMA, VALOR};

    private CadastroProdutoContract(){
        super();
    }

    public static String getCreateTableScript() {

        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " + TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(NOME + " TEXT NOT NULL, ");
        create.append(IMAGEM + " TEXT, ");
        create.append(DESCRICAO + " TEXT, ");
        create.append(QUANTIDADE + " INTEGER, ");
        create.append(QUANTIDADE_MINIMA + " INTEGER, ");
        create.append(VALOR + " REAL ");
        create.append(" ); ");

        return create.toString();
    }

    public static ContentValues getContentValues(Produto produto) {
        ContentValues values = new ContentValues();

        values.put(CadastroProdutoContract.ID, produto.getId());
        values.put(CadastroProdutoContract.IMAGEM, produto.getImagem());
        values.put(CadastroProdutoContract.NOME, produto.getNome());
        values.put(CadastroProdutoContract.DESCRICAO, produto.getDescricao());
        values.put(CadastroProdutoContract.QUANTIDADE, produto.getQuantidade());
        values.put(CadastroProdutoContract.QUANTIDADE_MINIMA, produto.getQuantidadeMinima());
        values.put(CadastroProdutoContract.VALOR, produto.getValor());


        return values;

    }

    public static Produto getProduto(Cursor cursor) {

        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            Produto produto = new Produto();
            produto.setId(cursor.getLong(cursor.getColumnIndex(CadastroProdutoContract.ID)));
            produto.setImagem(cursor.getString(cursor.getColumnIndex(CadastroProdutoContract.IMAGEM)));
            produto.setNome(cursor.getString(cursor.getColumnIndex(CadastroProdutoContract.NOME)));
            produto.setDescricao(cursor.getString(cursor.getColumnIndex(CadastroProdutoContract.DESCRICAO)));
            produto.setQuantidade(cursor.getLong(cursor.getColumnIndex(CadastroProdutoContract.QUANTIDADE)));
            produto.setQuantidadeMinima(cursor.getLong(cursor.getColumnIndex(CadastroProdutoContract.QUANTIDADE_MINIMA)));
            produto.setValor(cursor.getLong(cursor.getColumnIndex(CadastroProdutoContract.VALOR)));

            return produto;
        }

        return null;

    }

    public static List<Produto> getProdutos(Cursor cursor) {

        Produto produto = new Produto();

        List<Produto> produtos = new ArrayList<>();

        while (cursor.moveToNext()) {
            produtos.add(getProduto(cursor));
        }

        return produtos;

    }

}
