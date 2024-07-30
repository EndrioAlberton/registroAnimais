package registroAnimais;

import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class registroAnimais {
    public static void main(String[] args) {
        DB.criarUsuarios();
        DB.criarEstados();
        DB.criarMunicipios();
        DB.criarFamilias();
        DB.criarGeneros();
        DB.criarEspecies();
        DB.criarExemplares();
        DB.criarRegistro();

        List<Usuario> usuarios = DB.getUsuarios();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String usuarioNome = "";
        Usuario currentUser = null;

        while (!loggedIn) {
            System.out.println("Insira os dados de login:");
            System.out.println("Login:");
            String login = scanner.nextLine();

            System.out.println("Senha:");
            String senha = scanner.nextLine();

            for (Usuario user : usuarios) {
                if (login.equals(user.getLogin()) && senha.equals(user.getSenha())) {
                    usuarioNome = user.getNome();
                    currentUser = user;
                    loggedIn = true;
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("Login inválido. Tente novamente.");
            }
        }

        while (loggedIn) {
            System.out.println("Bem-vindo, " + usuarioNome + "!");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Registrar avistamento de exemplar.");
            System.out.println("2 - Mostrar todos os registros do usuário.");
            System.out.println("3 - Mostrar estados por família.");
            System.out.println("0 - Deslogar.");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    registrarAvistamento(scanner, currentUser);
                    break;
                case 2:
                    mostrarRegistros(currentUser);
                    break;
                case 3:
                    mostrarEstadosPorFamilia(scanner);
                    break;
                case 0:
                    loggedIn = false;
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    public static void registrarAvistamento(Scanner scanner, Usuario usuario) {
        System.out.println("Registrar avistamento de exemplar");

        System.out.println("Insira o código do exemplar:");
        String codigoExemplar = scanner.nextLine();

        Exemplar exemplar = null;
        for (Exemplar ex : DB.getExemplares()) {
            if (ex.getId().equals(codigoExemplar)) {
                exemplar = ex;
                break;
            }
        }

        if (exemplar == null) {
            System.out.println("Exemplar não encontrado.");
            return;
        }

        System.out.println("Insira o peso do exemplar:");
        float peso = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Insira o comprimento do exemplar:");
        float comprimento = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Insira a descrição do avistamento:");
        String descricao = scanner.nextLine();

        System.out.println("Insira o nome do município:");
        String nomeMunicipio = scanner.nextLine();

        Municipio municipio = null;
        for (Municipio mun : DB.getMunicipios()) {
            if (mun.getNome().equalsIgnoreCase(nomeMunicipio)) {
                municipio = mun;
                break;
            }
        }

        if (municipio == null) {
            System.out.println("Município não encontrado.");
            return;
        }

        Registro registro = new Registro(usuario, new Date(), exemplar, peso, comprimento, descricao, municipio);
        DB.addRegistro(registro);
        System.out.println("Avistamento registrado com sucesso.");
    }

    public static void mostrarRegistros(Usuario usuario) {
        System.out.println("Registros do usuário " + usuario.getNome() + ":");
        List<Registro> registros = DB.getRegistros();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (Registro reg : registros) {
            if (reg.getUsuario().equals(usuario)) {
                System.out.println("Data e Hora: " + sdf.format(reg.getDataHora()));
                System.out.println("Exemplar: " + reg.getExemplar().getId());
                System.out.println("Peso: " + reg.getPeso());
                System.out.println("Comprimento: " + reg.getComprimento());
                System.out.println("Descrição: " + reg.getDescricao());
                System.out.println("Município: " + reg.getMunicipio().getNome());
                System.out.println("------------------------------------");
            }
        }
    }

    public static void mostrarEstadosPorFamilia(Scanner scanner) {
        System.out.println("Mostrar estados que tiveram registro de espécies de uma determinada família.");

        System.out.println("Insira o nome da família:");
        String nomeFamilia = scanner.nextLine();

        Familia familia = null;
        for (Familia fam : DB.getFamilias()) {
            if (fam.getNome().equalsIgnoreCase(nomeFamilia)) {
                familia = fam;
                break;
            }
        }

        if (familia == null) {
            System.out.println("Família não encontrada.");
            return;
        }

        List<Registro> registros = DB.getRegistros();
        List<Estado> estados = DB.getEstados();

        System.out.println("Estado(s): ");
        boolean encontrado = false;
        for (Estado estado : estados) {
            boolean estadoRegistrado = false;
            for (Registro registro : registros) {
                if (registro.getExemplar().getEspecie().getGenero().getFamilia().equals(familia) &&
                    registro.getMunicipio().getEstado().equals(estado)) {
                    estadoRegistrado = true;
                    encontrado = true;
                    break;
                }
            }
            if (estadoRegistrado) {
                System.out.println(estado.getSigla());
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum estado encontrado para a família especificada.");
        }
    }
}
