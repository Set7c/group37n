import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HomeWork {
    public static void main(String[] args) {
        int sum = 0;
        int allSum = 0;

        int[][] array = new int[][]{
                {23, 52, 19, 5},
                {36, 28, 18, 3},
                {64, 6, 9, 24}
        };
        System.out.println(Arrays.deepToString(array));
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = array[i][j] + scanner.nextInt();
                sum += array[i][j];
            }
        }
        allSum += sum;
        System.out.println(" сумма всех занчений " + " =" + " " + allSum);
        scanner.close();

        String[][] chessDesk = new String[8][8];

        for (int i = 0; i < chessDesk.length; i++) {
            for (int j = 0; j < chessDesk[i].length; j++) {
                if ((i + j) % 2 == 0){
                    chessDesk[i][j] = "W";
                }else {
                    chessDesk[i][j] = "B";
                }
                System.out.print(chessDesk[i][j] + " ");
            }
            System.out.println();
        }
    }
}