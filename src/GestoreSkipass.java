import java.util.ArrayList;
import java.util.Scanner;

public class GestoreSkipass {
    private static ArrayList<Skipass> skipassAcquistati = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean inEsecuzione;

        do {
            System.out.println("\n--- Menu Principale ---");
            System.out.println("1. Calcola e Acquista Skipass");
            System.out.println("2. Visualizza Skipass Acquistati");
            System.out.println("3. Elimina uno Skipass");
            System.out.println("4. Mostra Prezzi di Listino");
            System.out.println("5. Esci");
            System.out.print("Seleziona un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("\n--- Calcola e Acquista Skipass ---");
                    System.out.print("Inserisci il nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Inserisci l'età: ");
                    int eta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Inserisci la stagione (Alta/Bassa): ");
                    String stagione = scanner.nextLine();

                    System.out.print("Inserisci il numero di giorni: ");
                    int giorni = scanner.nextInt();
                    scanner.nextLine();

                    Skipass skipass = calcolaSkipass(nome, eta, stagione, giorni);
                    System.out.printf("Il costo dello skipass è: %.2f€\n", skipass.costo);
                    System.out.print("Confermi l'acquisto? (s/n): ");
                    String conferma = scanner.nextLine();

                    if (acquistaSkipass(skipass, conferma)) {
                        System.out.println("Skipass acquistato con successo!");
                    } else {
                        System.out.println("Acquisto annullato.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Skipass Acquistati ---");
                    if (skipassAcquistati.isEmpty()) {
                        System.out.println("Nessuno skipass acquistato finora.");
                    } else {
                        for (int i = 0; i < skipassAcquistati.size(); i++) {
                            System.out.printf("%d. %s\n", i + 1, skipassAcquistati.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Elimina uno Skipass ---");
                    if (skipassAcquistati.isEmpty()) {
                        System.out.println("Nessuno skipass acquistato finora.");
                        break;
                    }

                    // Mostra la lista degli skipass
                    for (int i = 0; i < skipassAcquistati.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, skipassAcquistati.get(i));
                    }

                    System.out.print("Inserisci il numero dello skipass da eliminare: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    Skipass rimosso = eliminaSkipass(numero);
                    if (rimosso != null) {
                        System.out.printf("Skipass di %s eliminato con successo!\n", rimosso.nome);
                    } else {
                        System.out.println("Numero non valido. Operazione annullata.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Prezzi di Listino ---");
                    String[] listinoPrezzi = calcolaPrezziListino();
                    for (String riga : listinoPrezzi) {
                        System.out.println(riga);
                    }
                    break;

                case 5:
                    System.out.println("Grazie per aver utilizzato il nostro sistema. Arrivederci!");
                    inEsecuzione = false;
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
                    inEsecuzione = true;
                    break;
            }
        } while (inEsecuzione);
    }

    private static Skipass calcolaSkipass(String nome, int eta, String stagione, int giorni) {
        if (eta <= 12) {
            return new SkipassBambino(nome, eta, stagione, giorni);
        } else if (eta >= 60) {
            return new SkipassAnziano(nome, eta, stagione, giorni);
        } else {
            return new SkipassAdulto(nome, eta, stagione, giorni);
        }
    }

    private static boolean acquistaSkipass(Skipass skipass, String conferma) {
        if (conferma.equalsIgnoreCase("s")) {
            skipassAcquistati.add(skipass);
            return true;
        }
        return false;
    }

    private static Skipass eliminaSkipass(int numero) {
        if (numero > 0 && numero <= skipassAcquistati.size()) {
            return skipassAcquistati.remove(numero - 1);
        }
        return null;
    }

    private static String[] calcolaPrezziListino() {
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
                listino.add(String.format("    Bambini: %.2f€", bambino.costo));
                listino.add(String.format("    Adulti: %.2f€", adulto.costo));
                listino.add(String.format("    Anziani: %.2f€", anziano.costo));
            }
        }
        return listino.toArray(new String[0]);
    }
}
