package Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


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
    // Метод для зчитування всього файлу
    public static void readFightLog(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Виводимо кожен рядок у консоль
            }
        } catch (IOException e) {
            e.printStackTrace();  // Якщо виникла помилка при читанні файлу
        }
    }
}