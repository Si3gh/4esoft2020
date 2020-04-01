package observer.cofre;

public class AppCofre {

    public static void main(String[] args) {
        Cofre daSala = new Cofre(89756);
        daSala.addListener(new CofreListenerConsole());

        System.out.println("Confre aberto: " + daSala.isAberto() + "\n"); //Retorna TRUE
        daSala.fechar(); //FECHA COFRE
        System.out.println("\nCofre está aberto: " + daSala.isAberto());
        System.out.println(daSala.isAberto());

        try {
            daSala.abrir(89756);
        } catch (SenhaIncorretaException e) {
            System.out.println(e.getLocalizedMessage());
        }

        try {
            daSala.abrir(000);
        } catch (SenhaIncorretaException e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(daSala.isAberto());

        System.out.println("\n\nFim da transmissão.");

    }

}
