public class Skipass {
    private String nome;
    private int eta;
    private String stagione;
    private int giorni;
    private double costo;

    public Skipass(String nome, int eta, String stagione, int giorni) {
        this.nome = nome;
        this.eta = eta;
        this.stagione = stagione;
        this.giorni = giorni;
        this.costo = calcolaCosto();
    }

    public double calcolaCosto() {
        double tariffaBase = (stagione.equalsIgnoreCase("Alta")) ? 40 : 30;
        double totale = tariffaBase * giorni;
        return applicaSconto(totale, giorni);
    }

    public double applicaSconto(double totale, int giorni) {
        if (giorni >= 7) {
            return totale * 0.8; // Sconto del 20%
        } else if (giorni >= 3) {
            return totale * 0.9; // Sconto del 10%
        }
        return totale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getStagione() {
        return stagione;
    }

    public void setStagione(String stagione) {
        this.stagione = stagione;
    }

    public int getGiorni() {
        return giorni;
    }

    public void setGiorni(int giorni) {
        this.giorni = giorni;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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