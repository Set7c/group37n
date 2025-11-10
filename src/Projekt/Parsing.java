package Projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {
    private static final String accountPattern = "^(\\d{5}-\\d{5}):(-?\\d+)$";

    public static void readFile() {
        String filePathStr = "D:\\перевод.txt";
        Path filePath = Paths.get(filePathStr);
        Pattern accountRegex = Pattern.compile(accountPattern);

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\перевод.txt"))) {
            List<String> accountsFile = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                accountsFile.add(line);
                List<String> overwritedFile = new ArrayList<>();

                int firstMatchedAccount = -1;
                int secondMatchedAccount = -1;

                for (int i = 0; i < accountsFile.size(); i++) {
                    String account = accountsFile.get(i);
                    Matcher matcher = accountRegex.matcher(account);
                    if (matcher.matches()) {
                        if (firstMatchedAccount == -1) {
                            firstMatchedAccount = i;
                        } else if (secondMatchedAccount == -1) {
                            secondMatchedAccount = i;
                            break;
                        }
                    }
                }
                if (firstMatchedAccount != -1 && secondMatchedAccount != -1) {
                    String accountFrom = accountsFile.get(firstMatchedAccount);
                    String accountTo = accountsFile.get(secondMatchedAccount);

                    Matcher matcherFrom = accountRegex.matcher(accountFrom);
                    Matcher matcherTo = accountRegex.matcher(accountTo);

                    if (matcherFrom.matches() && matcherTo.matches()) {
                        String amountFrom = matcherFrom.group(2);
                        String amountTo = matcherTo.group(2);

                        int sum1 = Integer.parseInt(amountFrom);
                        int sum2 = Integer.parseInt(amountTo);


                        if (sum1 < 0) {
                            Archivation.writeOperation(
                                    filePath.getFileName().toString(),
                                    "перевод с " + matcherFrom.group(1) + " на " + matcherTo.group(1),
                                    "ошибка: отрицательное значение " + sum1,
                                    false
                            );
                            System.err.println("Отрицательное значение перевода. Обработка остановлена.");
                            return;
                        }

                        int amountSum = sum1 + sum2;
                        int transferAmount = 0;
                        String transferAccount = matcherTo.group(1) + ":" + amountSum;
                        String resultAccount = matcherFrom.group(1) + ":" + transferAmount;

                        for (int i = 0; i < accountsFile.size(); i++) {
                            if (i == firstMatchedAccount) {
                                overwritedFile.add(transferAccount);
                            } else if (i == secondMatchedAccount) {
                                overwritedFile.add(resultAccount);
                            } else {
                                overwritedFile.add(accountsFile.get(i));
                            }
                        }

                        try {
                            Files.write(filePath, overwritedFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Archivation.writeOperation(
                                filePath.getFileName().toString(),
                                "перевод с " + matcherFrom.group(1) + " на " + matcherTo.group(1),
                                String.valueOf(transferAmount),
                                true
                        );

                        try {
                            Files.write(filePath, overwritedFile);
                        } catch (IOException e) {
                            System.err.println("Ошибка при чтении файла: " + e.getMessage());
                        }
                    } else {

                        System.out.println("Не найдены обе учетные записи в файле: " + filePath.getFileName());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

