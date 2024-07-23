package registroAnimais;

import java.util.Date;

public class Registro {
    private Date dataHora;
    private float peso;
    private float comprimento;
    private String descricao;
    private Usuario usuario;
    private Exemplar exemplar;
    private Municipio municipio;

    public Registro(Usuario usuario, Date dataHora, Exemplar exemplar, float peso, float comprimento, String descricao, Municipio municipio) {
    	if (usuario == null || usuario == null || municipio == null)
    	{
    		throw new IllegalArgumentException("Usuario, Exemplar Municipio e/ou não podem ser nulas");
    	}
    	
        this.usuario = usuario;
        this.dataHora = dataHora;
        this.exemplar = exemplar;
        this.peso = peso;
        this.comprimento = comprimento;
        this.descricao = descricao;
        this.municipio = municipio;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public float getPeso() {
        return peso;
    }

    public float getComprimento() {
        return comprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
