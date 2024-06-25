package registroAnimais;

public class Familia {
    private String nome;
    private String descricao;

    public Familia(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
