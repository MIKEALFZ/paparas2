import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo("zoo.ser");

        //Μενού επιλογών για τον χρήστη
        int choice;
        do {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. View all animals");
            System.out.println("2. Add a new animal");
            System.out.println("3. Find animal by name");
            System.out.println("4. Find animal by code");
            System.out.println("5. Remove animal by code");
            System.out.println("6. Feed animals");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Απορρόφηση του newline character
            System.out.println();

            // Έλεγχος έγκυρης εισόδου
            while (choice < 1 || choice >7) {
                System.out.print("Invalid entry. Enter your choice again: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
            }

            //Ενέργεια του προγράμματος ανάλογα με την είσοδο του χρήστη
            switch (choice) {
                case 1 -> {
                    List<Animal> animals = zoo.AllAnimals();
                    if (animals.isEmpty()) {
                        System.out.println("No animals in the zoo.");
                    } else {
                        System.out.println("LIST OF THE ANIMALS");
                        System.out.println();
                        for (Animal animal : animals) {
                            System.out.println(animal);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("NEW ANIMAL REGISTRATION");
                    System.out.print("Enter animal code: ");
                    int code = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter animal name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter animal type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter animal weight: ");
                    double weight = scanner.nextDouble();
                    System.out.print("Enter animal maximum age: ");
                    int maxAge = scanner.nextInt();
                    Animal newAnimal = new Animal(code, name, type, weight, maxAge);
                    zoo.addAnimal(newAnimal);
                    System.out.println("Animal added successfully.");
                }
                case 3 -> {
                    System.out.print("Enter animal name: ");
                    String searchName = scanner.nextLine();
                    Animal foundByName = zoo.findAnimalByName(searchName);
                    if (foundByName != null) {
                        System.out.println("ANIMAL FOUND\n\n" + foundByName);
                    } else {
                        System.out.println("ANIMAL NOT FOUND");
                    }
                }
                case 4 -> {
                    System.out.print("Enter animal code: ");
                    int searchCode = scanner.nextInt();
                    Animal foundByCode = zoo.findAnimalByCode(searchCode);
                    if (foundByCode != null) {
                        System.out.println("ANIMAL FOUND\n\n" + foundByCode);
                    } else {
                        System.out.println("ANIMAL NOT FOUND");
                    }
                }
                case 5 -> {
                    System.out.print("Enter animal code: ");
                    int removeCode = scanner.nextInt();
                    zoo.deleteAnimal(removeCode);
                }
                case 6 -> {
                    System.out.println();
                    zoo.feedAnimals();
                }
                case 7 -> System.out.println("Goodbye!");
            }
        } while (choice != 7);

        //Τερματισμός εφαρμογής
        scanner.close();
    }
}
