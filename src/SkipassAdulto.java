public class SkipassAdulto extends Skipass {
    public SkipassAdulto(String nome, int eta, String stagione, int giorni) {
        super(nome, eta, stagione, giorni);
    }

    protected double calcolaCosto() {
        double tariffaBase = (stagione.equalsIgnoreCase("Alta")) ? 40 : 30;
        double totale = tariffaBase * giorni;
        return applicaSconto(totale, giorni);
    }
}
