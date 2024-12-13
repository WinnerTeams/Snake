import processing.core.PApplet;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Money money = new Money(); // Money-objekt til økonomistyring

    String correctEmail = "test@example.com";
    String correctPassword = "password123";
    String correctUsername = "testUser";

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
                    logIn();
                    break;
                case "2":
                    createUser();
                    break;
                case "3":
                    System.out.println("Farvel!");
                    money.saveBalance(); // Gem saldoen, når programmet afsluttes
                    return;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    public void logIn() {
        System.out.print("Indtast din email: ");
        String email = scanner.nextLine();

        System.out.print("Indtast din adgangskode: ");
        String password = scanner.nextLine();

        if (email.equals(correctEmail) && password.equals(correctPassword)) {
            System.out.println("Velkommen, " + correctUsername + "! Du er nu logget ind.");
            if (money.withdraw(100)) { // Træk 100 kr for at starte spillet
                System.out.println("100 kr er trukket fra din konto. Din saldo: " + money.getBalance() + " kr.");
                checkAge();
            } else {
                System.out.println("Du har ikke nok penge til at starte spillet. Din saldo: " + money.getBalance() + " kr.");
            }
        } else {
            System.out.println("Forkert email eller adgangskode. Prøv igen.");
        }
    }

    public void checkAge() {
        System.out.print("Indtast din alder: ");
        String ageInput = scanner.nextLine();
        try {
            int age = Integer.parseInt(ageInput);
            if (age >= 18) {
                System.out.println("Du er over 18 år. Spillet starter nu...");
                startGame();
            } else {
                System.out.println("Du skal være mindst 18 år for at spille dette spil.");
                System.out.println("Adgang nægtet. Lukker programmet.");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt input. Prøv igen.");
            checkAge();
        }
    }

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

    public void startGame() {
        PApplet.main("Main");
    }



}
