package registroAnimais;

import java.util.ArrayList;
import java.util.List;

public class Especie {
    private String nome;
    private String descricao;
    private Genero genero;
    private List<Exemplar> exemplares;

    public Especie(String nome, String descricao, Genero genero) {
    	if (genero == null )
    	{
    		throw new IllegalArgumentException("Genero não pode ser nula");
    	}
        this.nome = nome;
        this.descricao = descricao;
        this.genero = genero;
        this.exemplares = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }	

    public String getDescricao() {
        return descricao;
    }

    public Genero getGenero() {
        return genero;
    }

    public List<Exemplar> listExemplar() {
        return exemplares;
    }

    public void addExemplar(Exemplar e) {
        exemplares.add(e);
    }
}
