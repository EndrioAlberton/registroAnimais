package registroAnimais;

public class Genero {
    private String nome;
    private String descricao;
    private Familia familia;

    public Genero(String nome, String descricao, Familia familia) {
        this.nome = nome;
        this.descricao = descricao;
        this.familia = familia;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Familia getFamilia() {
        return familia;
    }
}
