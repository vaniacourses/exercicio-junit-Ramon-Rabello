package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTestGpt {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;
    private Produto produtoMesmoNomeQueProduto1;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();

        produto1 = new Produto("Produto 1", 10.0);
        produto2 = new Produto("Produto 2", 20.0);
        // Produto com mesmo nome do produto1, mas preço diferente → será considerado igual pelo equals
        produtoMesmoNomeQueProduto1 = new Produto("Produto 1", 50.0);
    }

    @Test
    void deveIniciarCarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveAdicionarItensNoCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(30.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveRemoverItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.removeItem(produto1);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(20.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveLancarExcecaoAoRemoverItemInexistente() {
        carrinho.addItem(produto1);

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produto2);
        });
    }

    @Test
    void deveEsvaziarCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveReconhecerProdutosComMesmoNomeComoIguais() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        // Mesmo nome, preço diferente
        carrinho.removeItem(produtoMesmoNomeQueProduto1);

        assertEquals(0, carrinho.getQtdeItems());
    }
}
