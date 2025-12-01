package padraoescriacao.prototype;

public class Localizacao implements Cloneable {
    private String setor;
    private Integer mesa;
    private String hora;

    public Localizacao(String setor, Integer mesa, String hora) {
        this.setor = setor;
        this.mesa = mesa;
        this.hora = hora;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Localizacao{" +
                "setor='" + setor + '\'' +
                ", mesa=" + mesa +
                ", hora='" + hora + '\'' +
                '}';
    }
}
