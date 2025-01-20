public class SkipassBambino extends Skipass {
    public SkipassBambino(String nome, int eta, String stagione, int giorni) {
        super(nome, eta, stagione, giorni);
    }

    protected double calcolaCosto() {
        double tariffaBase = (stagione.equalsIgnoreCase("Alta")) ? 20 : 15;
        double totale = tariffaBase * giorni * 0.5; // Sconto 50% per bambini
        return applicaSconto(totale, giorni);
    }
}
