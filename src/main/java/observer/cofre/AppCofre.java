package observer.cofre;

public class AppCofre {
	
	public static void main(String[] args) {
		Cofre daSala = new Cofre(89756);
		
		daSala.addListener(new CofreListenerConsole());
		
		System.out.println(daSala.isAberto());
		
		daSala.fechar();
		System.out.println(daSala.isAberto());
		
		daSala.abrir(111);
		System.out.println(daSala.isAberto());

		daSala.abrir(89756);
		System.out.println(daSala.isAberto());
		
		System.out.println("Fim da transmissão.");
		
	}

}
