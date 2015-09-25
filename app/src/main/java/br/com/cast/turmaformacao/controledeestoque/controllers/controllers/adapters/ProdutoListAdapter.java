package br.com.cast.turmaformacao.controledeestoque.controllers.controllers.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.controledeestoque.R;
import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities.Produto;

/**
 * Created by Administrador on 25/09/2015.
 */
public class ProdutoListAdapter extends BaseAdapter{

    private List<Produto> produtoList;
    private Activity context;

    public ProdutoListAdapter(Activity context, List<Produto> produtoList) {
        this.produtoList = produtoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return produtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return produtoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = (Produto) getItem(position);

        View produtoListItemView = context.getLayoutInflater().inflate(R.layout.list_item_produto, parent, false);


        TextView textViewNome = (TextView) produtoListItemView.findViewById(R.id.textViewNome);
        TextView textViewDescricao = (TextView) produtoListItemView.findViewById(R.id.textViewDescricao);
        TextView textViewQuantidade = (TextView) produtoListItemView.findViewById(R.id.textViewQuantidade);
        TextView textViewQuantidadeMinima = (TextView) produtoListItemView.findViewById(R.id.textViewQuantidadeMinima);
        TextView textViewValor = (TextView) produtoListItemView.findViewById(R.id.textViewValor);

        String nome = "Nome do Produto: ";
        textViewNome.setText(nome + produto.getNome());
        String desc = "Descricao: ";
        textViewDescricao.setText(desc + produto.getDescricao());
        String qntde = "Quantidade: ";
        textViewQuantidade.setText(qntde + produto.getQuantidade().toString());
        String qntdeMin = "Quantidade Minima: ";
        textViewQuantidadeMinima.setText(qntdeMin + produto.getQuantidadeMinima().toString());
        String moeda = "Valor Unitario: R$ ";
        textViewValor.setText(moeda + produto.getValor().toString());


        return produtoListItemView;
    }
}
