package registroAnimais;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB {
    public static List<Usuario> listUsuarios = new ArrayList<Usuario>();
    public static List<Estado> listEstados = new ArrayList<Estado>();
    public static List<Municipio> listMunicipios = new ArrayList<Municipio>();
    public static List<Familia> listFamilias = new ArrayList<Familia>();
    public static List<Genero> listGeneros = new ArrayList<Genero>();
    public static List<Especie> listEspecies = new ArrayList<Especie>();
    public static List<Exemplar> listExemplares = new ArrayList<Exemplar>();
    public static List<Registro> listRegistros = new ArrayList<Registro>();

    public static void criarUsuarios() {
    	//add 2 usuarios(banco tem mais registros)
        Usuario usuario1 = new Usuario("banco", "123b", "Banco");
        listUsuarios.add(usuario1);
        Usuario usuario2 = new Usuario("admin", "123a", "Administrador");
        listUsuarios.add(usuario2);
    }
    
    public static List<Usuario> getUsuarios() {
        return listUsuarios;
    }

    public static void criarEstados() {
    	//add 3 estados
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
    	//add 4 municipios(2 rs, 1 sc, 1 pr)
        Municipio municipio1 = new Municipio("Gravataí", getEstados().get(0));
        listMunicipios.add(municipio1);
        Municipio municipio2 = new Municipio("Florianópolis", getEstados().get(1));
        listMunicipios.add(municipio2);
        Municipio municipio3 = new Municipio("Porto Alegre", getEstados().get(0));
        listMunicipios.add(municipio3);
        Municipio municipio4 = new Municipio("Curitiba", getEstados().get(2));
        listMunicipios.add(municipio4);
    }

    public static List<Municipio> getMunicipios() {
        return listMunicipios;
    }
    
    public static void criarFamilias() {
    	//add 2 familias
        Familia familia1 = new Familia("Felidae", "Família de felinos, como leões, tigres e gatos.");
        listFamilias.add(familia1);
        Familia familia2 = new Familia("Canidae", "Família de canídeos, como cães, lobos e raposas.");
        listFamilias.add(familia2); 
    }

    public static List<Familia> getFamilias() {
        return listFamilias;
    }
    
    public static void criarGeneros() {
    	//add 3 generos(2 felidade e 1 canidae)
        Genero genero1 = new Genero("Panthera", "Gênero que inclui leões, tigres, leopardos e onças.", getFamilias().get(0)); // panthera -> felidae
        listGeneros.add(genero1);
        Genero genero2 = new Genero("Lynx", "Gênero que inclui linces.", getFamilias().get(0)); // lynx -> felidae
        listGeneros.add(genero2);
        Genero genero3 = new Genero("Canis", " Gênero que inclui cães e lobos.", getFamilias().get(1)); // canis -> canidae
        listGeneros.add(genero3);
    }

    public static List<Genero> getGeneros() {
        return listGeneros;
    }
    
    public static void criarEspecies() {
    	//add 3 especies 1 para cada genero
        Especie especie1 = new Especie("Leo", "Descrição da espécie Leo", getGeneros().get(0));// leo -> panthera
        listEspecies.add(especie1);
        Especie especie2 = new Especie("lince-ibérico", "Descrição da espécie lince-ibérico", getGeneros().get(1)); // lince -> lynx
        listEspecies.add(especie2);
        Especie especie3 = new Especie("Canis lupus", "Descrição da espécie Canis lupus", getGeneros().get(2)); // Canis lupus -> canis
        listEspecies.add(especie3);
    }

    public static List<Especie> getEspecies() {
        return listEspecies;
    }
    
    public static void criarExemplares() {
    	//add 3 exemplares 1 pra cada especie
        Exemplar exemplar1 = new Exemplar("1", "Leo", getEspecies().get(0));
        listExemplares.add(exemplar1);
        Exemplar exemplar2 = new Exemplar("2", "Lince", getEspecies().get(1));
        listExemplares.add(exemplar2);
        Exemplar exemplar3 = new Exemplar("3", "Canis lupus", getEspecies().get(2));
        listExemplares.add(exemplar3);
    }

    public static List<Exemplar> getExemplares() {
        return listExemplares;
    }

    public static void addRegistro(Registro registro) {
        listRegistros.add(registro);
    }

    public static List<Registro> getRegistros() {
        return listRegistros;
    }

    public static void criarRegistro(){
    	//criando 4 registros(estados: 2 rs, 1 sc, 1 pr. usuarios: 3 banco e 1 adm)
        Usuario usuario = getUsuarios().get(0); // Usuário banco
        
        Exemplar exemplar1 = getExemplares().get(0); // Exemplar 1 Leo	
        Registro registro1 = new Registro(usuario, new Date(), exemplar1, 190.2f, 1.70f, "Avistamento inicial Leo", getMunicipios().get(0)); // RS
        addRegistro(registro1);
        Registro registro2 = new Registro(usuario, new Date(), exemplar1, 187.5f, 1.75f, "Segundo avistamento Leo", getMunicipios().get(0)); // RS
        addRegistro(registro2);
        
        Exemplar exemplar2 = getExemplares().get(1); // Exemplar 2 Lynx	
        Registro registro3 = new Registro(usuario, new Date(), exemplar2, 25.3f, 0.97f, "Primeiro avistamento Lynx", getMunicipios().get(1)); // SC
        addRegistro(registro3);
        //
        Usuario usuarioA = getUsuarios().get(1); // Usuário administrador
        Exemplar exemplar3 = getExemplares().get(2); // Exemplar 3 Canis
        Registro registro4 = new Registro(usuarioA, new Date(), exemplar3, 30.5f, 0.80f, "Primeiro avistamento Canis lupus", getMunicipios().get(3)); // PR
        addRegistro(registro4);
    }
}
