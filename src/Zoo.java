import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Zoo {
    private List<Animal> animals;
    private String dataFile;

    //Δημιουργία λίστας ζώων και αρχείου
    public Zoo(String dataFile) {
        this.animals = new ArrayList<>();
        this.dataFile = dataFile;
        loadAnimals();
    }

    //Φόρτωμα αρχείου
    private void loadAnimals() {
        try {
            FileInputStream fis = new FileInputStream(dataFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            animals = (List<Animal>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load data");
        }
    }

    //Αποθήκευση αρχείου
    private void saveAnimals() {
        try {
            FileOutputStream fos = new FileOutputStream(dataFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animals);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Καταχώρηση νέου ζώου στην λίστα
    public void addAnimal(Animal animal) {
        animals.add(animal);
        saveAnimals();
    }

    //Λίστα με όλα τα ζώα
    public List<Animal> AllAnimals() {
        return animals;
    }

    //Εύρεση ζώου από το όνομα
    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    //Εύρεση ζώου από τον κωδικό
    public Animal findAnimalByCode(int code) {
        for (Animal animal : animals) {
            if (animal.getCode() == code) {
                return animal;
            }
        }
        return null;
    }

    //Διαγραφή ζώου
    public void deleteAnimal(int code) {
          Animal animal = findAnimalByCode(code);
            if (animal != null) {
                animals.remove(animal);
                saveAnimals();
                System.out.println("Animal removed successfully.");
                return;
            }
            else System.out.println("Animal not found.");
            return;
    }

    // Προσομοίωση ταΐσματος
    public void feedAnimals() {
        for (Animal animal : animals) {
            System.out.println("--------------");
            System.out.println(animal.getName() + " is fed");
        }
    }
}
