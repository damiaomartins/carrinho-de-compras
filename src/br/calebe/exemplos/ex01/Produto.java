package br.calebe.exemplos.ex01;

public class Produto {
    
    enum TIPO {
        LIVRO,
        CADEIRA
    }

    private String nome;
    private double preco;
    private TIPO tipoProduto;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        //this.tipoProduto = tipo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object obj) {
        return equals((Produto) obj);
    }

    public boolean equals(Produto obj) {
        return nome.equals(obj.nome);
    }
}
