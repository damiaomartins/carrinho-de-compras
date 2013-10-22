package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex02.controller.PedidoController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Carrinho {

    private Map<Produto,Integer> produtos;
    
    public Carrinho() {
        produtos = new HashMap<Produto, Integer>();
    }

    public void add(Produto produto) {
        if(produto == null){
            throw new IllegalArgumentException();
        }
        if(produtos.get(produto)==null){
            produtos.put(produto,1);
        } else {
            produtos.put(produto, produtos.get(produto)+1);
        }
    }

    public Produto menorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = null;
        for (Produto produto : produtos.keySet()) {
            if(menor == null){
                menor = produto;
            }
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }

    void remove(Produto p1) {
        produtos.remove(p1);
    }

    boolean isEmpty() {
        return produtos.isEmpty();
    }

    Double totalPagar() {
        Double total = 0.0;
        for(Entry<Produto, Integer> entry : produtos.entrySet()){
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    Map<Produto,Integer> listarProdutos() {
        return produtos;
    }

    int quantidadeProduto(Produto p1) {
        return produtos.get(p1);
    }

}
