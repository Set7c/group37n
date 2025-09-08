import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HomeWork {
    public static void main(String[] args) {
        int[] array = new int[]{23, 52, 19, 5, 46, 0, 13};

        System.out.println(Arrays.toString(array));

        for (int i = array.length - 1; i >= 0; i--) {
            //System.out.println(array[i]);
        }
        System.out.println(Arrays.toString(array));
        // не получается вывести строкой в обратном порядке


        int num = 8;
        Random random = new Random();
        int[] randomArray = new int[num];
        for (int i = 0; i < num; i++) {
            randomArray[i] = random.nextInt(20);
        }

        System.out.println(Arrays.toString(randomArray));

        int max = array[0];
        int min = array[0];
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        System.out.println(" max number" + " " + max);
        System.out.println("min number" + " " + min);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                indexMax = i;
            }
            if (array[i] == min) {
                indexMin = i;
            }
        }
        System.out.println(" индекс максимума" + " " + indexMax + " " + "индекс минимума" + " " + indexMin);
        int zeroCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroCounter++;
                //как то надо через this, но я не разобрался
            }
        }
        if (zeroCounter == 0) ;
        System.out.println("в массиве нет нулевых элементов");
        if (zeroCounter > 0) ;
        System.out.println("в массиве" + " " + zeroCounter + " " + "нулей");

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println("перевернутый массив" + " " + Arrays.toString(array));

        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= array[i + 1]) {
                flag = false;
                break;

            }

        }if (flag) {
            System.out.println("массив возрастающий");
        } else {
            System.out.println("массив не возрастающий");
        }
    }
}