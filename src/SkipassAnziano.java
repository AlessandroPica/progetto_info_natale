public class SkipassAnziano extends Skipass {
    public SkipassAnziano(String nome, int eta, String stagione, int giorni) {
        super(nome, eta, stagione, giorni);
    }

    protected double calcolaCosto() {
        double tariffaBase = (stagione.equalsIgnoreCase("Alta")) ? 30 : 25;
        double totale = tariffaBase * giorni * 0.7; // Sconto 30% per anziani
        return applicaSconto(totale, giorni);
    }
}
