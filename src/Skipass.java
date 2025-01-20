public class Skipass {
    protected String nome;
    protected int eta;
    protected String stagione;
    protected int giorni;
    protected double costo;

    public Skipass(String nome, int eta, String stagione, int giorni) {
        this.nome = nome;
        this.eta = eta;
        this.stagione = stagione;
        this.giorni = giorni;
        this.costo = calcolaCosto();
    }

    protected double calcolaCosto() {
        double tariffaBase = (stagione.equalsIgnoreCase("Alta")) ? 40 : 30;
        double totale = tariffaBase * giorni;
        return applicaSconto(totale, giorni);
    }

    protected double applicaSconto(double totale, int giorni) {
        if (giorni >= 7) {
            return totale * 0.8; // Sconto del 20%
        } else if (giorni >= 3) {
            return totale * 0.9; // Sconto del 10%
        }
        return totale;
    }

    public String toString() {
        return "Skipass{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                ", stagione='" + stagione + '\'' +
                ", giorni=" + giorni +
                ", costo=" + costo +
                '}';
    }
}
