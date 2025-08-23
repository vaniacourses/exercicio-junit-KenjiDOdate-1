package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe de testes do Carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto p1;
    private Produto p2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        p1 = new Produto("Lápis", 2.5);
        p2 = new Produto("Caderno", 15.0);
    }



    @Test
    public void testCarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }


    @Test
    public void testAdicionaItem() {
        carrinho.addItem(p1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(2.5, carrinho.getValorTotal());
    }



    @Test
    public void testAdicionaVariosItens() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(17.5, carrinho.getValorTotal());
    }



    @Test
    public void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(p1);
        carrinho.removeItem(p1);
        assertEquals(0, carrinho.getQtdeItems());
    }



    @Test
    public void testRemoveItemInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(p1));
    }



    @Test
    public void testEsvaziaCarrinho() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    
}

