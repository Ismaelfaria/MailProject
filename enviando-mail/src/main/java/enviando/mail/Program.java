package enviando.mail;

public class Program {

	public static void main(String[] args) {

		EnvioDeEmail email = new EnvioDeEmail("Testando a refatoração", "nada a dizer", "Ismael Dev - Treinamentos", "limaismael4444@gmail.com");
		
		email.EnviarEmail();

	}

}
