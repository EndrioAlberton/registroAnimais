package registroAnimais;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private List<Registro> registros;

    public Usuario(String login, String senha, String nome) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.registros = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public Registro criaRegistro(Date dh, Exemplar e, float p, float c, String d, Municipio m) {
        Registro registro = new Registro(this, dh, e, p, c, d, m);
        registros.add(registro);
        return registro;
    }

    public List<Registro> listRegistro() {
        return registros;
    }
}
