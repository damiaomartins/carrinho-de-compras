package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Carrinho {

    private Map<Produto,Integer> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void add(Produto produto) {
//        if(produto.getTipo() != Produto.TIPO.LIVRO) {
//            throw new Exception("Produto não suportado");
//        }
        //if(produto != null)
        Integer quantidade = produtos.get(produto);
        if(quantidade == null)
            produtos.put(produto,1);
        produtos.put(produto, quantidade++);
    }

    public Produto menorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }

    void remove(Produto p1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Double totalPagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<Produto> listarProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
