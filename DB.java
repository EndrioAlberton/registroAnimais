package registroAnimais;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<Usuario> listUsuarios = new ArrayList<Usuario>();
    public static List<Estado> listEstados = new ArrayList<Estado>();
    public static List<Municipio> listMunicipios = new ArrayList<Municipio>();
    public static List<Familia> listFamilias = new ArrayList<Familia>();
    public static List<Genero> listGeneros = new ArrayList<Genero>();
    public static List<Especie> listEspecies = new ArrayList<Especie>();
    public static List<Exemplar> listExemplares = new ArrayList<Exemplar>();

    public static void criarUsuarios() {
        Usuario usuario = new Usuario("endrio", "endrio", "123");
        listUsuarios.add(usuario);

    }
    
    public static List<Usuario> getUsuarios() {
        return listUsuarios;
    }

    public static void criarEstados() {
        Estado estado1 = new Estado("RS");
        listEstados.add(estado1);
        Estado estado2 = new Estado("SC");
        listEstados.add(estado2);
        Estado estado3 = new Estado("PR");
        listEstados.add(estado3);

    }
    
    public static List<Estado> getEstados() {
        return listEstados;
    }
    
    public static void criarMunicipios() {
    	
    	Municipio municipio1 = new Municipio("Gravataí", getEstados().get(0));
        listMunicipios.add(municipio1);
    	Municipio municipio2 = new Municipio("Cachoeirinha", getEstados().get(0));
        listMunicipios.add(municipio2);
    	Municipio municipio3 = new Municipio("Porto Alegre", getEstados().get(0));
        listMunicipios.add(municipio3);
    }

    public static List<Municipio> getMunicipios() {
        return listMunicipios;
    }
    
    public static void criarFamilias() {
    	
    	Familia familia1 =  new Familia ("Felidae", "Descrição da família Felidae");
        listFamilias.add(familia1);
    }

    public static List<Familia> getFamilias() {
        return listFamilias;
    }
    
    public static void criarGeneros() {
    	
    	Genero genero1 =  new Genero ("Panthera", "Descrição do gênero Panthera", getFamilias().get(0));
        listGeneros.add(genero1);
    }

    public static List<Genero> getGeneros() {
        return listGeneros;
    }
    
    public static void criarEspecies() {
    	Especie especie1 =  new Especie ("Leo", "Descrição da espécie Leo", getGeneros().get(0));;
    	listEspecies.add(especie1);
    }

    public static List<Especie> getEspecies() {
        return listEspecies;
    }
    
    public static void criarExemplares() {
    	Exemplar exemplar1 =  new Exemplar("123", "Leo",  getEspecies().get(0));
    	listExemplares.add(exemplar1);
    }

    public static List<Exemplar> getExemplares() {
        return listExemplares;
    }
}
