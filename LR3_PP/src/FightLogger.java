import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FightLogger {

    // Метод для запису бою у файл
    public static void logFight(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine(); // Для нової строки
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}