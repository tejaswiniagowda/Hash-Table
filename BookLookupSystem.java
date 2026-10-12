import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class BookLookupSystem {
    private static final Hashtable<Integer, String> books =
        new Hashtable<>();

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        int id = readInt(scanner, "Book ID: ");

        if (id <= 0) {
            System.out.println("Book ID must be a positive integer.");
            return;
        }

        if (books.containsKey(id)) {
            System.out.println("Book ID already exists.");
            return;
        }

        System.out.print("Book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Book title cannot be empty.");
            return;
        }

        books.put(id, title);
        System.out.println("Book added successfully.");
    }

    private static void searchBook(Scanner scanner) {
        int id = readInt(scanner, "Book ID to search: ");

        if (books.containsKey(id)) {
            System.out.println("Book ID: " + id + ", Title: " + books.get(id));
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void removeBook(Scanner scanner) {
        int id = readInt(scanner, "Book ID to remove: ");

        if (books.containsKey(id)) {
            books.remove(id);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found. Unable to remove.");
        }
    }

    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        for (Map.Entry<Integer, String> entry : books.entrySet()) {
            System.out.println(
                "Book ID: " + entry.getKey()
                    + ", Title: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Book Lookup System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Search a Book");
            System.out.println("3. Remove a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");

            int choice = readInt(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    searchBook(scanner);
                    break;
                case 3:
                    removeBook(scanner);
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting Book Lookup System.");
                    running = false;
                    break;
                default:
                    System.out.println(
                        "Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}