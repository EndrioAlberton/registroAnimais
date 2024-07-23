package registroAnimais;

import java.util.ArrayList;
import java.util.List;

public class Exemplar {
    private String id;
    private String descricao;
    private Especie especie;
    private List<Registro> registros;

    public Exemplar(String id, String descricao, Especie especie) {
    	if (especie == null )
    	{
    		throw new IllegalArgumentException("Especie não pode ser nula");
    	}
        this.id = id;
        this.descricao = descricao;
        this.especie = especie;
        this.registros = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Especie getEspecie() {
        return especie;
    }

    public List<Registro> listRegistro() {
        return registros;
    }

    public List<Municipio> listMunicipio() {
        List<Municipio> municipios = new ArrayList<>();
        for (Registro registro : registros) {
            municipios.add(registro.getMunicipio());
        }
        return municipios;
    }

    public float getPesoAtual() {
        float pesoAtual = 0;
        for (Registro registro : registros) {
            if (registro.getPeso() > pesoAtual) {
                pesoAtual = registro.getPeso();
            }
        }
        return pesoAtual;
    }

    public float getComprimentoAtual() {
        float comprimentoAtual = 0;
        for (Registro registro : registros) {
            if (registro.getComprimento() > comprimentoAtual) {
                comprimentoAtual = registro.getComprimento();
            }
        }
        return comprimentoAtual;
    }

    public void addRegistro(Registro r) {
        registros.add(r);
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
