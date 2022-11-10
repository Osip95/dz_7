import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //task 1
        findLeapYear(1997);

        // task 2
        checkApplicationVersion(2021, 0);

        //task 3
        findNumberDeliveryDays(100);

        //task 4
        findDuplicateSymbols("aabccddefgghiijjkk");

        //task 5
        int[] array = new int[]{3, 2, 1, 6, 5};
        changeArray(array);
        System.out.println(Arrays.toString(array));

        //task 6
        int[] randomArray = generateRandomArray();
        System.out.println("Средняя сумма трат за месяц составила " + getMediumSpending(randomArray) + " рублей");
    }


    //task1
    public static void findLeapYear(int year) {
        String result = "";
        if ((year % 4 == 0) || (year % 400 == 0)) {
            if (year % 100 == 0) result = year + " не високосный";
            else result = year + " високосный";
        } else result = year + " не високосный";
        System.out.println(result);
    }

    //task 2
    public static void checkApplicationVersion(int yearCreation, float clientOS) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 0 || clientOS == 0.1) {
            if (yearCreation < currentYear)
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            else System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOS == 1) {
            if (yearCreation < currentYear)
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
            else System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    //task 3
    public static void findNumberDeliveryDays(int deliveryDistance) {
        if (deliveryDistance <= 20) System.out.println("Потребуется дней:1");
        else if (deliveryDistance <= 60) System.out.println("Потребуется дней:2");
        else if (deliveryDistance <= 100) System.out.println("Потребуется дней:3");
        else System.out.println("Потребуется дней:>3");
    }

    //task 4
    public static void findDuplicateSymbols(String str) {
        char[] arrayChars = str.toCharArray();
        for (int i = 0; i < arrayChars.length; i++) {
            if (i == arrayChars.length - 1) {
                System.out.println("Дублей не найдено");
                continue;
            }
            if (arrayChars[i] == arrayChars[i + 1]) {
                System.out.println("Найден дубль символа: " + arrayChars[i]);
                break;
            }
        }
    }

    //task 5
    public static void changeArray(int[] initalArray) {
        int intermediateVar = 0;
        for (int i = 0, n = initalArray.length - 1; i < n; i++, n--) {
            intermediateVar = initalArray[i];
            initalArray[i] = initalArray[n];
            initalArray[n] = intermediateVar;

        }
    }

    //task 6
    public static float getMediumSpending(int[] array) {
        int cost = getSum(array);
        float medium = getMedium(cost);
        return medium;
    }

    public static float getMedium(int i) {
        return i / 30f;
    }

    public static int getSum(int[] array) {
        int sum = 0;
        for (int c : array) {
            sum = sum + c;
        }
        return sum;
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

}