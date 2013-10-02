package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{null}, new Object[]{menor});
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{copia});
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void adicionarObjetoNulo() throws CarrinhoVazioExpected{
        carrinho.add(null);
    }
    
    @Test
    public void listarProdutosCarrinho(){
        Produto p1 = new Produto("Produto1", 9.99);
        Produto p2 = new Produto("Produto2", 10.99);
        Map<Produto,Integer> produtos = new HashMap<Produto,Integer>();
        produtos.put(p1,1);
        produtos.put(p2,1);
        
        carrinho.add(p1);
        carrinho.add(p2);
        Map<Produto,Integer> produtosCarrinho = carrinho.listarProdutos();
        Assert.assertArrayEquals(produtos.entrySet().toArray(), produtosCarrinho.entrySet().toArray());
    }
    
    @Test
    public void removerProduto(){
        Produto p1 = new Produto("Produto1", 9.99);
        carrinho.add(p1);
        carrinho.remove(p1);
        Assert.assertTrue(carrinho.isEmpty());
    }
    
    @Test
    public void totalCarrinho(){
        Double precoP1 = 1.99;
        Double precoP2 = 2.99;
        Produto p1 = new Produto("Produto1", precoP1);
        Produto p2 = new Produto("Produto2", precoP2);
        carrinho.add(p1);
        carrinho.add(p2);
        Double total = carrinho.totalPagar();
        Assert.assertEquals(precoP1 + precoP2, total, 0);
    }
    
    @Test
    public void adicionaOutroTipo(){
        Livro livro = new Livro("Java", 100.0);
        carrinho.add(livro);
        Assert.assertFalse(carrinho.isEmpty());
    }
    
    @Test
    public void adicionarMesmoProduto(){
        Produto p1 = new Produto("Produto", 10.9);
        carrinho.add(p1);
        carrinho.add(p1);
        Assert.assertEquals(carrinho.quantidadeProduto(p1), 2);
        
    }
    
}
