/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 31041949
 */
public class ProdutoTest {
   
    
    @Test
    public void criandoProduto(){
        String nome = "Livro";
        Double preco = 9.90;
        Produto prod = new Produto(nome, preco);
        Assert.assertEquals(preco, prod.getPreco(),0d);
    }
    
    @Test
    public void mesmoProduto(){
        Produto p1 = new Produto("Livro",9.90);
        Produto p2 = new Produto("Livro", 9.90);
        Assert.assertEquals(p1, p2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nomeVazio(){
        Produto p1 = new Produto("", 9.90);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void precoInvalido(){
        Produto p1 = new Produto("Livro", -1.0);
    }
}
