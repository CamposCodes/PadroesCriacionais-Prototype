package padraoescriacao.prototype;

public class Bebida implements Cloneable {
    private int codigoProduto;
    private String nome;
    private double preco;
    private String tamanho;
    private Localizacao localizacao;
    private String ingredientesPrincipais;
    private int quantidade;
    private boolean comGelo;

    public Bebida(int codigoProduto, String nome, double preco, String tamanho, 
                  Localizacao localizacao, String ingredientesPrincipais) throws IllegalArgumentException {
        if (codigoProduto <= 0) {
            throw new IllegalArgumentException("Código do produto deve ser maior que zero");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da bebida não pode ser vazio");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        if (tamanho == null || tamanho.isEmpty()) {
            throw new IllegalArgumentException("Tamanho não pode ser vazio");
        }
        if (localizacao == null) {
            throw new IllegalArgumentException("Localização não pode ser nula");
        }
        if (ingredientesPrincipais == null || ingredientesPrincipais.isEmpty()) {
            throw new IllegalArgumentException("Ingredientes principais não podem estar vazios");
        }
        
        this.codigoProduto = codigoProduto;
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
        this.localizacao = localizacao;
        this.ingredientesPrincipais = ingredientesPrincipais;
        this.quantidade = 1;
        this.comGelo = true;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getIngredientesPrincipais() {
        return ingredientesPrincipais;
    }

    public void setIngredientesPrincipais(String ingredientesPrincipais) {
        this.ingredientesPrincipais = ingredientesPrincipais;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws IllegalArgumentException {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.quantidade = quantidade;
    }

    public boolean isComGelo() {
        return comGelo;
    }

    public void setComGelo(boolean comGelo) {
        this.comGelo = comGelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws IllegalArgumentException {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getTotalPreco() {
        return preco * quantidade;
    }

    @Override
    public Bebida clone() throws CloneNotSupportedException {
        Bebida bebidaClone = (Bebida) super.clone();
        bebidaClone.localizacao = (Localizacao) bebidaClone.localizacao.clone();
        return bebidaClone;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "codigoProduto=" + codigoProduto +
                ", nome='" + nome + '\'' +
                ", preco=" + String.format("R$ %.2f", preco) +
                ", tamanho='" + tamanho + '\'' +
                ", quantidade=" + quantidade +
                ", comGelo=" + comGelo +
                ", total=" + String.format("R$ %.2f", getTotalPreco()) +
                ", localizacao=" + localizacao +
                '}';
    }
}
