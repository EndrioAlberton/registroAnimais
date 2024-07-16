package registroAnimais;

import java.util.List;
import java.util.Scanner;

public class registroAnimais {
    public static void main(String[] args) {
    	
        DB.criarUsuarios();
        DB.criarEstados();
        DB.criarMunicipios();
        DB.criarFamilias();
        DB.criarGeneros();
        DB.criarEspecies();
        
          List<Usuario> usuarios = DB.getUsuarios();
//
//        System.out.println("------------------------------------");
//        for (Usuario user : usuarios) {
//            System.out.println("Login: " + user.getLogin());
//            System.out.println("Nome: " + user.getNome());
//            System.out.println("Senha: " + user.getSenha());
//        }
//        
//        List<Estado> estados = DB.getEstados();
//        
//        System.out.println("------------------------------------");
//        for (Estado e : estados) {
//            System.out.println("Sigla: " + e.getSigla());
//        }
//        
//        List<Municipio> municipios = DB.getMunicipios();
//        
//        System.out.println("------------------------------------");
//        for (Municipio m : municipios) {
//            System.out.println("Municipio: " + m.getNome());
//            System.out.println("Estado: " + m.getEstado().getSigla());
//        }
//        
//        List<Familia> familias = DB.getFamilias();
//        
//        System.out.println("------------------------------------");
//        for (Familia f : familias) {
//            System.out.println("Nome familia: " + f.getNome());
//            System.out.println("Descrição familia: " + f.getDescricao());
//        }
//        
//        List<Genero> generos = DB.getGeneros();
//        
//        System.out.println("------------------------------------");
//        for (Genero g : generos) {
//            System.out.println("Nome genero: " + g.getNome());
//            System.out.println("Descrição genero: " + g.getDescricao());
//        }
//        
//        
//        List<Especie> especies = DB.getEspecies();
//        
//        System.out.println("------------------------------------");
//        for (Especie e : especies) {
//            System.out.println("Nome especie: " + e.getNome());
//            System.out.println("Descrição especie: " + e.getDescricao());
//        }
        
        
        Scanner scanner = new Scanner(System.in);

        int x = 1;
        String usuario;

        do { 
	        System.out.println("Insira os dados de login:");
	        System.out.println("Login:");
	        String login = scanner.nextLine();

	        System.out.println("Senha:");
	        String senha = scanner.nextLine();
	        	        for (Usuario user : usuarios) {
	        	if (login == user.getLogin()) {
	        		if (senha == user.getSenha()) {
	        			usuario = user.getNome();
	        		}
	        	}
	        }

			if (usuario != "" ) {
		        System.out.println("Selecione uma opção:");
		        System.out.println("1 - Resgistrar avistamento de exemplar. ");
		        System.out.println("2 - Mostrar todos os Registros do Usuario");
		        System.out.println("0 - Deslogar.");
		        int option = scanner.nextInt();
		
			        switch (option) {
			
			            case 1:
			
			            case 2:
			  
			                
			            case 3:
			            	x = 0;
			        }
			        
		     }
		     System.out.println("Login invalido:");
	        } while (x != 0);
       
    }
}
