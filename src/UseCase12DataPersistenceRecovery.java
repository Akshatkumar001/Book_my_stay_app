import java.io.*;
import java.util.*;

// 🔹 Room Inventory Class
class RoomInventory {

    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();

        // Default values
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public Map<String, Integer> getRooms() {
        return rooms;
    }

    public void setRoom(String type, int count) {
        rooms.put(type, count);
    }

    public void printInventory() {
        System.out.println("\nCurrent Inventory:");
        for (String type : rooms.keySet()) {
            System.out.println(type + ": " + rooms.get(type));
        }
    }
}

// 🔹 File Persistence Service
class FilePersistenceService {

    // Save inventory to file
    public void saveInventory(RoomInventory inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry : inventory.getRooms().entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    // Load inventory from file
    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            boolean hasData = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] parts = line.split("=");
                    String type = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    inventory.setRoom(type, count);
                    hasData = true;
                }
            }

            if (!hasData) {
                System.out.println("No valid inventory data found. Starting fresh.");
            } else {
                System.out.println("Inventory loaded successfully.");
            }

        } catch (Exception e) {
            System.out.println("Error loading inventory. Starting fresh.");
        }
    }
}

// 🔹 Main Class
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        String filePath = "inventory.txt";

        // Load existing data
        persistenceService.loadInventory(inventory, filePath);

        // Show inventory
        inventory.printInventory();

        // Save inventory
        persistenceService.saveInventory(inventory, filePath);
    }
}