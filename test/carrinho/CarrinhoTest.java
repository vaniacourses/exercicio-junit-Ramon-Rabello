package carrinho;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho car;
    private Produto p1;
    private Produto p2;


    @BeforeEach
    public void start(){
        car = new Carrinho();
        p1 = new Produto("produto1", 15.00);
        p2 = new Produto("produto2", 3.00);
    }

    @Test
    public void testEsvazia(){
        car.addItem(p1);
        car.addItem(p2);
        car.esvazia();
        Assertions.assertEquals(0, car.getQtdeItems());
    }
    
    @Test
    public void testAdd(){
        car.addItem(p1);
        Assertions.assertEquals(1, car.getQtdeItems());
    }

    @Test
    public void testValorTotal(){
        car.addItem(p1);
        car.addItem(p2);
        Assertions.assertEquals(18.00, car.getValorTotal());
    }

    @Test
    public void testItemRemoved(){
        car.addItem(p1);
        car.addItem(p2);
        try {
            car.removeItem(p1);
        } catch (ProdutoNaoEncontradoException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(1, car.getQtdeItems());
    }
}
