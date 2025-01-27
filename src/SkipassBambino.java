public class SkipassBambino extends Skipass {
    public SkipassBambino(String nome, int eta, String stagione, int giorni) {
        super(nome, eta, stagione, giorni);
    }

    public double calcolaCosto() {
        double tariffaBase = (getStagione().equalsIgnoreCase("Alta")) ? 20 : 15;
        double totale = tariffaBase * getGiorni() * 0.5; // Sconto 50% per bambini
        return applicaSconto(totale, getGiorni());
    }
}