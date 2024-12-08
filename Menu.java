import processing.core.PApplet;
import java.util.Scanner;



public class Menu {
    // Scanner bruges til input
    Scanner scanner = new Scanner(System.in);

    // Brugerdetaljer gemt til sammenligning
    String correctEmail = "test@example.com";
    String correctPassword = "password123";
    String correctUsername = "testUser";

    // Hovedmenu
    public void startMenu() {
        while (true) {
            System.out.println("\nHovedmenu:");
            System.out.println("1. Log ind");
            System.out.println("2. Opret bruger");
            System.out.println("3. Afslut");
            System.out.print("Vælg en mulighed: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    logIn(); // Kalder log ind-funktionen
                    break;
                case "2":
                    createUser(); // Kalder opret bruger-funktionen
                    break;
                case "3":
                    System.out.println("Farvel!");
                    return; // Afslut programmet
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    // Log ind-funktion
    public void logIn() {
        System.out.print("Indtast din email: ");
        String email = scanner.nextLine();

        System.out.print("Indtast din adgangskode: ");
        String password = scanner.nextLine();

        if (email.equals(correctEmail) && password.equals(correctPassword)) {
            System.out.println("Velkommen, " + correctUsername + "! Du er nu logget ind.");
            startGame(); // Start spillet efter succesfuld login
        } else {
            System.out.println("Forkert email eller adgangskode. Prøv igen.");
        }
    }

    // Opret bruger-funktion
    public void createUser() {
        System.out.print("Indtast din ønskede email: ");
        correctEmail = scanner.nextLine();

        System.out.print("Indtast din ønskede adgangskode: ");
        correctPassword = scanner.nextLine();

        System.out.print("Indtast dit brugernavn: ");
        correctUsername = scanner.nextLine();

        System.out.println("Bruger oprettet med følgende oplysninger:");
        System.out.println("Email: " + correctEmail);
        System.out.println("Adgangskode: " + correctPassword);
        System.out.println("Brugernavn: " + correctUsername);
        System.out.println("Du kan nu logge ind.");
    }

    // Funktion til at starte spillet
    public void startGame() {
        System.out.println("Spillet starter nu...");
        PApplet.main("SnakeGame");


    }

    // Hovedmetode til at starte menuen
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu(); // Start hovedmenuen
    }
}
