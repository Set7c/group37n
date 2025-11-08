package InputLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Archive {
    private static final String AccountPattern = "^(\\d{5}-\\d{5}):(-?\\d+)$";

    public static void readFile(String "D:\\перевод.txt") {
        Pattern accountRegex = Pattern.compile(AccountPattern);

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\перевод.txt"))) {
            List<String> accountsFile = Files.readAllLines(Paths.get("D:\\перевод.txt"));
            List<String> overwritedFile = new ArrayList<>();

            int firstMatchedAccount = -1;
            int secondMatchedAccount = -1;

            for (int i = 0; i < accountsFile.size(); i++) {
                String account = accountsFile.get(i);
                Matcher matcher = accountRegex.matcher(account);
                if (matcher.matches()) {
                    if (firstMatchedAccount == -1) {
                        firstMatchedAccount = i;
                    } else if(secondMatchedAccount == -1) {
                        secondMatchedAccount = i;
                        break;
                    }
                }
            }
            if(firstMatchedAccount != -1 && secondMatchedAccount != -1){
                String accountFrom = accountsFile.get(firstMatchedAccount);
                String accountTo = accountsFile.get(secondMatchedAccount);

                Matcher matcherFrom = accountRegex.matcher(accountFrom);
                Matcher matcherTo = accountRegex.matcher(accountTo);

                if (matcherFrom.matches() && matcherTo.matches()) {
                    String amountFrom = matcherFrom.group(2);
                    String amountTo = matcherTo.group(2);

                    int sum1 = Integer.parseInt(amountFrom);
                    int sum2 = Integer.parseInt(amountTo);

                    // Проверка, что число из первой строки не отрицательное
                    if (sum1 < 0) {
                        System.out.println("Число из первой строки отрицательное в файле: " + filePath.getFileName() + ". Обработка прервана.");
                        return; // Прерываем обработку этого файла
                    }
            }catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        }
    }
}

