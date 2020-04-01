package observer.cofre;

import java.util.Date;

public class CofreListenerConsole implements CofreListenerAberto, CofreListenerFechado, CofreSenhaIncorretaListener  {

	@Override
	public void cofreFoiAberto() {
		System.out.println("O cofre foi aberto: " + new Date().toLocaleString());
	}

	@Override
	public void cofreFoiFechado() {
		System.out.println("O cofre foi fechado: " + new Date().toLocaleString());
	}

	@Override
	public void senhaInformadaIncorreta(int senhaInformada) {
		System.out.println("Senha Incorreta: " + senhaInformada + " - " + new Date().toLocaleString());
	}

}
