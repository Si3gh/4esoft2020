package observer.cofre;

import java.util.ArrayList;
import java.util.List;

public class Cofre {

    private int senha;
    private boolean aberto;
    private List<CofreListenerAberto> listenersAberto = new ArrayList<>();
    private List<CofreListenerFechado> listenersFechado = new ArrayList<>();
    private List<CofreSenhaIncorretaListener> listenersSenhaIncorreta = new ArrayList<>();

    public Cofre(int senha) {
        this.senha = senha;
        this.aberto = true;
    }

    public boolean isAberto() {
        return this.aberto;
    }

    public void fechar() {
        this.aberto = false;
        this.listenersFechado.forEach(CofreListenerFechado::cofreFoiFechado);
    }

    public void abrir(int senhaRecebida) {
        if (senhaRecebida == this.senha) {
            this.aberto = true;
            listenersAberto.forEach(CofreListenerAberto::cofreFoiAberto);
            return;
        }
        listenersSenhaIncorreta.forEach(listener -> listener.senhaInformadaIncorreta(senhaRecebida));
        throw new RuntimeException("Senha incorreta");
    }

    public void addListener(CofreListenerConsole listener) {
        if (listener instanceof CofreListenerAberto) {
            listenersAberto.add((CofreListenerAberto) listener);
        }
        if (listener instanceof CofreListenerFechado) {
            listenersFechado.add((CofreListenerFechado) listener);
        }
        if (listener instanceof CofreSenhaIncorretaListener) {
            listenersSenhaIncorreta.add((CofreSenhaIncorretaListener) listener);
        }
    }
}

