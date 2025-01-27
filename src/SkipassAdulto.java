public class SkipassAdulto extends Skipass {
    public SkipassAdulto(String nome, int eta, String stagione, int giorni) {
        super(nome, eta, stagione, giorni);
    }

    public double calcolaCosto() {
        double tariffaBase = (getStagione().equalsIgnoreCase("Alta")) ? 40 : 30;
        double totale = tariffaBase * getGiorni();
        return applicaSconto(totale, getGiorni());
    }
}