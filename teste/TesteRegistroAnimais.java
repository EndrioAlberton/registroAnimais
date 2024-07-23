package registroAnimais.teste;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import registroAnimais.*;

import java.util.Date;

public class TesteRegistroAnimais {
	
	private String sigla = "RS"; 
	
    @Test
    public void testEstado() {
        Estado estado = new Estado(sigla);
        assertEquals(this.sigla, estado.getSigla());
    }

    @Test
    public void testMunicipio() {
        Estado estado = new Estado("RS");

        Municipio municipio = new Municipio("Porto Alegre", estado);
        assertEquals("Porto Alegre", municipio.getNome());
        assertEquals("RS", municipio.getEstado().getSigla());
    }

    @Test
    public void testUsuario() {
        Usuario usuario = new Usuario("endrio123", "senha123", "Endrio");
        assertEquals("endrio123", usuario.getLogin());
        assertEquals("Endrio", usuario.getNome());
    }

    @Test
    public void testFamiliaGenero() {
        Familia familia = new Familia("Felidae", "Descrição da família Felidae");
        Genero genero = new Genero("Panthera", "Descrição do gênero Panthera", familia);
        assertEquals("Felidae", familia.getNome());
        assertEquals("Descrição da família Felidae", familia.getDescricao());
        assertEquals("Panthera", genero.getNome());
        assertEquals("Descrição do gênero Panthera", genero.getDescricao());
        assertEquals("Felidae", genero.getFamilia().getNome());
    }

    @Test
    public void testEspecieExemplar() {
        Familia familia = new Familia("Felidae", "Descrição da família Felidae");
        Genero genero = new Genero("Panthera", "Descrição do gênero Panthera", familia);
        Especie especie = new Especie("Leo", "Descrição da espécie Leo", genero);
        Exemplar exemplar = new Exemplar("123", "Leo", especie);
        assertEquals("Leo", especie.getNome());
        assertEquals("Descrição da espécie Leo", especie.getDescricao());
        assertEquals("Panthera", especie.getGenero().getNome());
        assertEquals("123", exemplar.getId());
        assertEquals("Leo", exemplar.getDescricao());
        assertEquals("Leo", exemplar.getEspecie().getNome());
    }

    @Test
    public void testRegistro() {
        Estado estado = new Estado("RS");
        Municipio municipio = new Municipio("Rio Grande Do Sul", estado);
        Usuario usuario = new Usuario("endrio123", "senha123", "Endrio");

        Familia familia = new Familia("Felidae", "Descrição da família Felidae");
        Genero genero = new Genero("Panthera", "Descrição do gênero Panthera", familia);
        Especie especie = new Especie("Leo", "Descrição da espécie Leo", genero);

        Exemplar exemplar = new Exemplar("123", "Leo", especie);
        Registro registro = new Registro(usuario, new Date(), exemplar, 200.0f, 2.5f, "Avistado na selva", municipio);

        assertEquals(200.0f, registro.getPeso(), 0.01);
        assertEquals(2.5f, registro.getComprimento(), 0.01);
        assertEquals("Avistado na selva", registro.getDescricao());
        assertEquals("123", registro.getExemplar().getId());
        assertEquals("Endrio", registro.getUsuario().getNome());
    }

    @Test
    public void testCriarRegistro() {
        Usuario usuario = new Usuario("endrio123", "senha123", "Endrio");
        Exemplar exemplar = new Exemplar("123", "Leão", null);
        Municipio municipio = new Municipio("Rio Grande Do Sul", null);

        Registro registro = usuario.criaRegistro(new Date(), exemplar, 200.0f, 2.5f, "Avistado na selva", municipio);

        assertNotNull(registro);
        assertEquals("endrio123", registro.getUsuario().getLogin());
        assertEquals(exemplar, registro.getExemplar());
        assertEquals(200.0f, registro.getPeso(), 0.01);
        assertEquals(2.5f, registro.getComprimento(), 0.01);
        assertEquals("Avistado na selva", registro.getDescricao());
        assertEquals(municipio, registro.getMunicipio());
    }
}
