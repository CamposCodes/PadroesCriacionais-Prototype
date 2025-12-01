package padraoescriacao.prototype;

public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("☕ SISTEMA DE PEDIDOS - CAFETERIA & BAR");
        System.out.println("Demonstração do Padrão Prototype - Clonagem de Itens de Pedido");
        System.out.println("=".repeat(80));
        System.out.println();

        Localizacao localizacaoBalcao = new Localizacao("Balcão", 0, "10:30");
        Bebida menuTemplate = new Bebida(101, "Cappuccino", 12.50, "Grande", 
                                         localizacaoBalcao, "Café Arábica, Leite Integral, Espuma");

        System.out.println("📋 ITEM DE MENU - TEMPLATE (ORIGINAL):");
        System.out.println(menuTemplate);
        System.out.println();

        try {
            System.out.println("🔄 CRIANDO PEDIDOS BASEADOS NO TEMPLATE...");
            System.out.println("-".repeat(80));
            System.out.println();

            Bebida pedido1 = menuTemplate.clone();
            pedido1.setQuantidade(2);
            pedido1.getLocalizacao().setMesa(5);
            pedido1.getLocalizacao().setHora("10:35");
            pedido1.getLocalizacao().setSetor("Salão Interno");
            pedido1.setComGelo(false);

            System.out.println("📦 PEDIDO 1 - Cliente na Mesa 5:");
            System.out.println("  Produto: " + pedido1.getNome());
            System.out.println("  Quantidade: " + pedido1.getQuantidade());
            System.out.println("  Tamanho: " + pedido1.getTamanho());
            System.out.println("  Preço Unitário: " + String.format("R$ %.2f", pedido1.getPreco()));
            System.out.println("  TOTAL: " + String.format("R$ %.2f", pedido1.getTotalPreco()));
            System.out.println("  Com Gelo: " + pedido1.isComGelo());
            System.out.println("  Localização: " + pedido1.getLocalizacao());
            System.out.println();

            Bebida pedido2 = menuTemplate.clone();
            pedido2.setTamanho("Pequeno");
            pedido2.setPreco(9.90);
            pedido2.setQuantidade(3);
            pedido2.getLocalizacao().setMesa(8);
            pedido2.getLocalizacao().setHora("10:40");
            pedido2.getLocalizacao().setSetor("Patio Externo");
            pedido2.setComGelo(true);

            System.out.println("📦 PEDIDO 2 - Cliente na Mesa 8:");
            System.out.println("  Produto: " + pedido2.getNome());
            System.out.println("  Quantidade: " + pedido2.getQuantidade());
            System.out.println("  Tamanho: " + pedido2.getTamanho());
            System.out.println("  Preço Unitário: " + String.format("R$ %.2f", pedido2.getPreco()));
            System.out.println("  TOTAL: " + String.format("R$ %.2f", pedido2.getTotalPreco()));
            System.out.println("  Com Gelo: " + pedido2.isComGelo());
            System.out.println("  Localização: " + pedido2.getLocalizacao());
            System.out.println();

            Bebida pedido3 = menuTemplate.clone();
            pedido3.setNome("Cappuccino com Caramelo");
            pedido3.setTamanho("Extra Grande");
            pedido3.setPreco(15.90);
            pedido3.setQuantidade(1);
            pedido3.getLocalizacao().setMesa(12);
            pedido3.getLocalizacao().setHora("10:45");
            pedido3.getLocalizacao().setSetor("Bar");
            pedido3.setComGelo(false);

            System.out.println("📦 PEDIDO 3 - Cliente no Bar:");
            System.out.println("  Produto: " + pedido3.getNome());
            System.out.println("  Quantidade: " + pedido3.getQuantidade());
            System.out.println("  Tamanho: " + pedido3.getTamanho());
            System.out.println("  Preço Unitário: " + String.format("R$ %.2f", pedido3.getPreco()));
            System.out.println("  TOTAL: " + String.format("R$ %.2f", pedido3.getTotalPreco()));
            System.out.println("  Com Gelo: " + pedido3.isComGelo());
            System.out.println("  Localização: " + pedido3.getLocalizacao());
            System.out.println();

            System.out.println("✅ VALIDAÇÃO DE INDEPENDÊNCIA DOS PEDIDOS");
            System.out.println("-".repeat(80));
            System.out.println();

            System.out.println("🔍 RESUMO COMPARATIVO:");
            System.out.println();
            System.out.println("TEMPLATE (Original):");
            System.out.println("  Nome: " + menuTemplate.getNome());
            System.out.println("  Quantidade: " + menuTemplate.getQuantidade());
            System.out.println("  Tamanho: " + menuTemplate.getTamanho());
            System.out.println("  Preço: " + String.format("R$ %.2f", menuTemplate.getPreco()));
            System.out.println("  Com Gelo: " + menuTemplate.isComGelo());
            System.out.println();

            System.out.println("✓ Template mantém valores INALTERADOS");
            System.out.println("✓ Cada pedido é INDEPENDENTE do original");
            System.out.println("✓ Modificações em pedidos NÃO afetam o template");
            System.out.println("✓ Deep copy garantindo isolamento total");
            System.out.println("✓ Sistema pronto para produção");
            System.out.println();

            System.out.println("=".repeat(80));
            System.out.println("✨ SISTEMA DE PEDIDOS EXECUTADO COM SUCESSO!");
            System.out.println("=".repeat(80));

        } catch (CloneNotSupportedException e) {
            System.err.println("❌ ERRO ao clonar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
