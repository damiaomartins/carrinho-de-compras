package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Carrinho;
import br.calebe.exemplos.ex01.CartaoCredito;
import br.calebe.exemplos.ex01.Produto;
import br.calebe.exemplos.ex01.Status;
import br.calebe.exemplos.ex02.controller.PedidoController;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({CarrinhoPagamento.class})
public class ClasseExemploTest {

    @Test
    public void executandoEfetuarPagamento() throws Exception {
        // Cria o objeto Mock da classe ClasseExemploController
        PedidoController controllerMock = PowerMock.createMock(PedidoController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(PedidoController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto("Produto", 10.9);
        carrinho.add(p1);
        carrinho.add(p1);
        CartaoCredito cartao = new CartaoCredito();
        cartao.setNumero("1234");
        cartao.setCodigoVerificacao("123");
        EasyMock.expect(controllerMock.efetuarPagamento(carrinho,cartao)).andReturn(true);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, PedidoController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        CarrinhoPagamento tested = new CarrinhoPagamento(carrinho, cartao);
        boolean result =tested.efetuarPagamento();
        
        // Faz a verificaçao agendada
        Assert.assertEquals(true, result);
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
    
    @Test
    public void executandoVerificarStatus() throws Exception {
        // Cria o objeto Mock da classe ClasseExemploController
        PedidoController controllerMock = PowerMock.createMock(PedidoController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(PedidoController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto("Produto", 10.9);
        carrinho.add(p1);
        carrinho.add(p1);
        CartaoCredito cartao = new CartaoCredito();
        cartao.setNumero("1234");
        cartao.setCodigoVerificacao("123");
        EasyMock.expect(controllerMock.consultarStatus(carrinho)).andReturn(Status.PAGO);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, PedidoController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        CarrinhoPagamento tested = new CarrinhoPagamento(carrinho, cartao);
        Status result =tested.consultaStatus();
        
        // Faz a verificaçao agendada
        Assert.assertEquals(Status.PAGO, result);
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
    
}
