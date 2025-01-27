public class SkipassAnziano extends Skipass {
    public SkipassAnziano(String nome, int eta, String stagione, int giorni) {
        super(nome, eta, stagione, giorni);
    }

    public double calcolaCosto() {
        double tariffaBase = (getStagione().equalsIgnoreCase("Alta")) ? 30 : 25;
        double totale = tariffaBase * getGiorni() * 0.7; // Sconto 30% per anziani
        return applicaSconto(totale, getGiorni());
    }
}