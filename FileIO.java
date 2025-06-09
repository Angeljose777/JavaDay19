import java.io.*;

public class FileIO {

    public static void main(String[] args) {
        String textFile = "names_scores.txt";
        String binaryFile = "numbers.dat";

        // Write text data using PrintWriter
        writeTextData(textFile);

        // Read and display text data
        readTextData(textFile);

        // Write binary data using DataOutputStream
        writeBinaryData(binaryFile);

        // Read and process binary data using DataInputStream
        readBinaryData(binaryFile);
    }

    private static void writeTextData(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Alice, 85");
            writer.println("Bob, 90");
            writer.println("Charlie, 78");
            writer.println("Diana, 92");
            System.out.println("✅ Text data written to " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    private static void readTextData(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\n📄 Contents of " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println("👉 " + line);
            }
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    private static void writeBinaryData(String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("\n✅ Binary data written to " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error writing binary data: " + e.getMessage());
        }
    }

    private static void readBinaryData(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\n📦 Reading binary data from " + filename + ":");
            int sum = 0, count = 0;
            while (dis.available() > 0) {
                int num = dis.readInt();
                System.out.println("🔢 Read number: " + num);
                sum += num;
                count++;
            }
            double average = (count > 0) ? (double) sum / count : 0;
            System.out.println("📊 Sum: " + sum + ", Average: " + average);
        } catch (IOException e) {
            System.err.println("❌ Error reading binary data: " + e.getMessage());
        }
    }
}
