
package Projekt;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Archivation {
    private static final String archiveFilePath = "D:\\отчет.txt";
    private static final List<String> archiveEntries = new ArrayList<>();

    public static void writeOperation(String fileName, String operation, String details, boolean success) {
        String status = success ? "успешно" : "ошибка";
        String dateTimeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String entry = String.format("%s | %s | %s %s | %s", dateTimeStr, fileName, operation, details, status);
        archiveEntries.add(entry);
    }

    public static void saveReport() {
        try (FileWriter fw = new FileWriter(archiveFilePath, true)) {
            for (String entry : archiveEntries) {
                fw.write(entry + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getReport() {
        StringBuilder sb = new StringBuilder();
        for (String entry : archiveEntries) {
            sb.append(entry).append("\n");
        }
        return sb.toString();
    }
}
