import java.io.*;

public class Money {
    private int balance;
    private final String filePath = "player_balance.txt"; // Fil til at gemme saldoen

    public Money() {
        // Indlæs saldo fra filen, hvis den findes
        File file = new File(filePath);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                balance = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                balance = 100; // Hvis noget går galt, starter vi med 100 kr
            }
        } else {
            balance = 100; // Start med 100 kr, hvis filen ikke findes
        }
    }

    // Træk penge fra saldoen
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false; // Ikke nok penge
        }
    }

    // Tilføj penge til saldoen
    public void deposit(int amount) {
        balance += amount;
    }

    // Gem saldoen i filen
    public void saveBalance() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            System.out.println("Kunne ikke gemme saldoen.");
        }
    }

    // Hent den aktuelle saldo
    public int getBalance() {
        return balance;
    }
}
