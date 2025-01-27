import java.util.ArrayList;

public class ArraySkipass {
    private ArrayList<Skipass> skipassAcquistati = new ArrayList<>();

    public Skipass calcolaSkipass(String nome, int eta, String stagione, int giorni) {
        if (eta <= 12) {
            return new SkipassBambino(nome, eta, stagione, giorni);
        } else if (eta >= 60) {
            return new SkipassAnziano(nome, eta, stagione, giorni);
        } else {
            return new SkipassAdulto(nome, eta, stagione, giorni);
        }
    }

    public boolean acquistaSkipass(Skipass skipass, String conferma) {
        if (conferma.equalsIgnoreCase("s")) {
            skipassAcquistati.add(skipass);
            return true;
        }
        return false;
    }

    public ArrayList<String> visualizzaSkipass() {
        ArrayList<String> result = new ArrayList<>();
        for (Skipass skipass : skipassAcquistati) {
            result.add(skipass.toString());
        }
        return result;
    }

    public String eliminaSkipass(int numero) {
        if (numero > 0 && numero <= skipassAcquistati.size()) {
            Skipass rimosso = skipassAcquistati.remove(numero - 1);
            return String.format("Skipass di %s eliminato con successo!", rimosso.getNome());
        } else {
            return "Numero non valido. Operazione annullata.";
        }
    }

    public String[] calcolaPrezziListino() {
        ArrayList<String> listino = new ArrayList<>();
        String[] stagioni = {"Alta", "Bassa"};
        int[] giorniPossibili = {1, 3, 7};

        for (String stagione : stagioni) {
            listino.add(String.format("\nStagione: %s", stagione));
            for (int giorni : giorniPossibili) {
                Skipass bambino = new SkipassBambino("Esempio", 10, stagione, giorni);
                Skipass adulto = new SkipassAdulto("Esempio", 30, stagione, giorni);
                Skipass anziano = new SkipassAnziano("Esempio", 65, stagione, giorni);

                listino.add(String.format("  %d giorni:", giorni));
                listino.add(String.format("    Bambini: %.2f€", bambino.getCosto()));
                listino.add(String.format("    Adulti: %.2f€", adulto.getCosto()));
                listino.add(String.format("    Anziani: %.2f€", anziano.getCosto()));
            }
        }
        return listino.toArray(new String[0]);
    }

    public double calcolaCostoTotale() {
        double totale = 0;
        for (Skipass skipass : skipassAcquistati) {
            totale += skipass.getCosto();
        }
        return totale;
    }
}
