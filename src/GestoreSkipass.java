import java.util.ArrayList;
import java.util.Scanner;

public class GestoreSkipass {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArraySkipass arraySkipass = new ArraySkipass();
        boolean inEsecuzione = true;

        do {
            System.out.println("\n--- Menu Principale ---");
            System.out.println("1. Calcola e Acquista Skipass");
            System.out.println("2. Visualizza Skipass Acquistati");
            System.out.println("3. Elimina uno Skipass");
            System.out.println("4. Mostra Prezzi di Listino");
            System.out.println("5. Mostra Costo Totale Skipass");
            System.out.println("6. Esci");
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

                    Skipass skipass = arraySkipass.calcolaSkipass(nome, eta, stagione, giorni);
                    System.out.printf("Il costo dello skipass è: %.2f€\n", skipass.getCosto());
                    System.out.print("Confermi l'acquisto? (s/n): ");
                    String conferma = scanner.nextLine();

                    if (arraySkipass.acquistaSkipass(skipass, conferma)) {
                        System.out.println("Skipass acquistato con successo!");
                    } else {
                        System.out.println("Acquisto annullato.");
                    }
                    break;

                case 2:
                    ArrayList<String> skipassAcquistati = arraySkipass.visualizzaSkipass();
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
                    ArrayList<String> elencoSkipass = arraySkipass.visualizzaSkipass();
                    System.out.println("\n--- Elimina uno Skipass ---");
                    if (elencoSkipass.isEmpty()) {
                        System.out.println("Nessuno skipass acquistato finora.");
                        break;
                    }

                    for (int i = 0; i < elencoSkipass.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, elencoSkipass.get(i));
                    }

                    System.out.print("Inserisci il numero dello skipass da eliminare: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    String risultatoEliminazione = arraySkipass.eliminaSkipass(numero);
                    System.out.println(risultatoEliminazione);
                    break;

                case 4:
                    String[] listinoPrezzi = arraySkipass.calcolaPrezziListino();
                    System.out.println("\n--- Prezzi di Listino ---");
                    for (String riga : listinoPrezzi) {
                        System.out.println(riga);
                    }
                    break;

                case 5:
                    double costoTotale = arraySkipass.calcolaCostoTotale();
                    System.out.printf("\nIl costo totale degli skipass acquistati è: %.2f€\n", costoTotale);
                    break;

                case 6:
                    System.out.println("Grazie per aver utilizzato il nostro sistema. Arrivederci!");
                    inEsecuzione = false;
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        } while (inEsecuzione);
    }
}