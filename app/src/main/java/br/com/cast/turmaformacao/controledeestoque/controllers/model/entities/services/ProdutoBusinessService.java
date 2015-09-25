package br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.services;

import java.util.List;

import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities.Produto;
import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.persistence.CadastroProdutoRepository;

public final class ProdutoBusinessService {

    private ProdutoBusinessService(){
        super();
    }

    public static List<Produto> findAll() {
        return CadastroProdutoRepository.getAll();
    }

    public static void save(Produto produto) {
        CadastroProdutoRepository.save(produto);
    }

    public static void delete(Produto produto){
        CadastroProdutoRepository.delete(produto.getId());
    }
}
