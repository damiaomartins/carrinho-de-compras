package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Carrinho;
import br.calebe.exemplos.ex01.CartaoCredito;
import br.calebe.exemplos.ex01.Status;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface IPedidoController {

    boolean efetuarPagamento(Carrinho pedido, CartaoCredito cartao);
    
    Status consultarStatus(Carrinho pedido);
}
