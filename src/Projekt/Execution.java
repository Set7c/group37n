package Projekt;



import java.util.Scanner;

public class Execution {
    public static class ConsoleInterface {
        private static final int MAX_ATTEMPTS = 3;

        public void run() {
            Scanner scanner = new Scanner(System.in);
            int attempts = 0;

            while (true) {
                System.out.println("Введите 1 для запуска парсинга файлов или 2 для вывода отчета:");
                String input = scanner.nextLine();

                if (input.equals("1")) {
                    System.out.println("Введите путь к файлу для обработки:");
                    String filePath = scanner.nextLine();

                    Parsing processor = new Parsing(filePath);
                    processor.readFile();

                } else if (input.equals("2")) {
                    Archivation.saveReport();
                    System.out.println("Отчёт сохранён в файл: D:\\отчет.txt");
                } else {
                    attempts++;
                    System.out.println("Неверный ввод. Попытка " + attempts + " из " + MAX_ATTEMPTS);
                    if (attempts >= MAX_ATTEMPTS) {
                        System.out.println("Превышено число попыток. Завершение работы.");
                        scanner.close();
                        break;
                    }
                }
            }
        }
    }
}
