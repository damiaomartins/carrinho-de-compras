package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Carrinho;
import br.calebe.exemplos.ex01.CartaoCredito;
import br.calebe.exemplos.ex01.Status;
import br.calebe.exemplos.ex02.controller.PedidoController;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class CarrinhoPagamento {

    private PedidoController controller;
    private Carrinho carrinho;
    private CartaoCredito cartao;

    public CarrinhoPagamento(Carrinho carrinho, CartaoCredito cartao) throws Exception {
        controller = new PedidoController();
        this.carrinho = carrinho;
        this.cartao = cartao;
    }

    public boolean efetuarPagamento() {
       return controller.efetuarPagamento(carrinho, cartao);
    }
 
    public Status consultaStatus(){
        return controller.consultarStatus(carrinho);
    }
    
    public Carrinho getCarrinho() {
        return carrinho;
    }
    
    public CartaoCredito getCartaoCredito(){
        return cartao;
    }
}
