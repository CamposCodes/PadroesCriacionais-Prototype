package padraoescriacao.prototype;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Prototype - Sistema de Pedidos")
class BebidaTest {

    private Bebida bebidaTemplate;
    private Localizacao localizacaoMenu;

    @BeforeEach
    void setUp() {
        localizacaoMenu = new Localizacao("Balcão", 0, "10:00");
        bebidaTemplate = new Bebida(101, "Cappuccino", 12.50, "Grande", 
                                    localizacaoMenu, "Café Arábica, Leite Integral, Espuma");
    }

    @Test
    @DisplayName("Deve clonar pedido com independência total")
    void testClonarPedido() throws CloneNotSupportedException {
        Bebida pedido1 = bebidaTemplate.clone();
        pedido1.setQuantidade(2);
        pedido1.getLocalizacao().setMesa(5);
        pedido1.getLocalizacao().setHora("10:30");

        assertEquals(1, bebidaTemplate.getQuantidade());
        assertEquals(2, pedido1.getQuantidade());
        assertEquals(0, bebidaTemplate.getLocalizacao().getMesa());
        assertEquals(5, pedido1.getLocalizacao().getMesa());
    }

    @Test
    @DisplayName("Deve manter independência de quantidade")
    void testQuantidadeIndependente() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();
        pedido.setQuantidade(5);

        assertEquals(1, bebidaTemplate.getQuantidade());
        assertEquals(5, pedido.getQuantidade());
    }

    @Test
    @DisplayName("Deve manter independência de tamanho")
    void testTamanhoIndependente() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();
        pedido.setTamanho("Pequeno");

        assertEquals("Grande", bebidaTemplate.getTamanho());
        assertEquals("Pequeno", pedido.getTamanho());
    }

    @Test
    @DisplayName("Deve manter independência de preço")
    void testPrecoIndependente() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();
        pedido.setPreco(9.90);

        assertEquals(12.50, bebidaTemplate.getPreco(), 0.01);
        assertEquals(9.90, pedido.getPreco(), 0.01);
    }

    @Test
    @DisplayName("Deve realizar deep copy da localização do pedido")
    void testDeepCopyLocalizacao() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();
        pedido.getLocalizacao().setMesa(7);
        pedido.getLocalizacao().setHora("10:45");
        pedido.getLocalizacao().setSetor("Salão");

        assertEquals(0, bebidaTemplate.getLocalizacao().getMesa());
        assertEquals("10:00", bebidaTemplate.getLocalizacao().getHora());
        assertEquals("Balcão", bebidaTemplate.getLocalizacao().getSetor());
        
        assertEquals(7, pedido.getLocalizacao().getMesa());
        assertEquals("10:45", pedido.getLocalizacao().getHora());
        assertEquals("Salão", pedido.getLocalizacao().getSetor());
    }

    @Test
    @DisplayName("Deve manter independência de gelo")
    void testGelIndependente() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();
        pedido.setComGelo(false);

        assertTrue(bebidaTemplate.isComGelo());
        assertFalse(pedido.isComGelo());
    }

    @Test
    @DisplayName("Deve calcular total de preço corretamente")
    void testCalculoTotalPreco() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();
        pedido.setQuantidade(3);

        assertEquals(12.50, bebidaTemplate.getTotalPreco(), 0.01);
        assertEquals(37.50, pedido.getTotalPreco(), 0.01);
    }

    @Test
    @DisplayName("Deve manter múltiplos pedidos independentes")
    void testMultiplosPedidosIndependentes() throws CloneNotSupportedException {
        Bebida pedido1 = bebidaTemplate.clone();
        Bebida pedido2 = bebidaTemplate.clone();
        Bebida pedido3 = bebidaTemplate.clone();

        pedido1.setQuantidade(2);
        pedido1.getLocalizacao().setMesa(5);

        pedido2.setQuantidade(1);
        pedido2.setTamanho("Pequeno");
        pedido2.getLocalizacao().setMesa(8);

        pedido3.setQuantidade(3);
        pedido3.setPreco(15.00);
        pedido3.getLocalizacao().setMesa(12);

        assertEquals(1, bebidaTemplate.getQuantidade());
        assertEquals("Grande", bebidaTemplate.getTamanho());
        assertEquals(12.50, bebidaTemplate.getPreco(), 0.01);

        assertEquals(2, pedido1.getQuantidade());
        assertEquals(1, pedido2.getQuantidade());
        assertEquals(3, pedido3.getQuantidade());
    }

    @Test
    @DisplayName("Deve validar que localizações não compartilham referências")
    void testLocalizacaoNaoCompartilhada() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();

        assertNotSame(bebidaTemplate.getLocalizacao(), pedido.getLocalizacao());
        assertEquals(bebidaTemplate.getLocalizacao().getMesa(), pedido.getLocalizacao().getMesa());
    }

    @Test
    @DisplayName("Deve manter nome original independente em variações")
    void testNomeComVariacoes() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();
        pedido.setNome("Cappuccino com Caramelo");

        assertEquals("Cappuccino", bebidaTemplate.getNome());
        assertEquals("Cappuccino com Caramelo", pedido.getNome());
    }

    @Test
    @DisplayName("Deve preservar todos os atributos durante clonagem")
    void testPreservacaoAtributosCompleta() throws CloneNotSupportedException {
        Bebida pedido = bebidaTemplate.clone();

        assertEquals(bebidaTemplate.getCodigoProduto(), pedido.getCodigoProduto());
        assertEquals(bebidaTemplate.getIngredientesPrincipais(), pedido.getIngredientesPrincipais());
        assertEquals(bebidaTemplate.getTamanho(), pedido.getTamanho());
        assertEquals(bebidaTemplate.getPreco(), pedido.getPreco(), 0.01);
    }
}
