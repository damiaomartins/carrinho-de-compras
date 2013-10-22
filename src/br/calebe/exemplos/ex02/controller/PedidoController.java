package br.calebe.exemplos.ex02.controller;

import br.calebe.exemplos.ex01.Carrinho;
import br.calebe.exemplos.ex01.CartaoCredito;
import br.calebe.exemplos.ex01.Status;
import br.calebe.exemplos.ex02.IPedidoController;
import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PedidoController implements IPedidoController {

    private IPedidoController ejb;

    public PedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        ejb = (IPedidoController) ctx.lookup("ejb/EJBStatelessExemplo");
    }

    @Override
    public boolean efetuarPagamento(Carrinho pedido, CartaoCredito cartao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Status consultarStatus(Carrinho pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
