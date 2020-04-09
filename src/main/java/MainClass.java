import java.util.Arrays;

public class MainClass {

    /*
    Я понимаю, что код местами перегружен, но зато в консоль выводится всё красиво.
    Так же, старался обойтись без "гениальных" решений, которые уменьшают количество операций,
    но затрудняют прочтение.
     */

    public static void main(String[] args) {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();

        int[] goodArray = {1, 2, 3, 4, 8, 2}; // 1 + 2 + 3 + 4 = 8 + 2 = 10
        questionSix(goodArray);
        int[] badArray = {0, 1, 2, 3, 4, 5};  // hasn't sum
        questionSix(badArray);

        int[] moveArray = {0, 1, 2, 3, 4, 5};
        questionSeven(moveArray, 1);
        questionSeven(moveArray, -1);

        System.out.println();
    }

    // вспомогательные методы
    public static int getRandomArraySize(int varArraySize){
      return (int) (Math.random() * varArraySize) + 1;
    }

    public static int getOneOrZero(){
        if (Math.random() >= 0.5) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void printTitle(String title){
        System.out.println("\n\n---------------------------");
        System.out.println(title);
    }

    // основные методы

    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void questionOne(){
        printTitle("Question 1. Upgrading array");

        int[] binaryArray = new int[getRandomArraySize(10)];

        // filling array
        System.out.println("The array's state BEFORE");
        for (int i  = 0; i < binaryArray.length; i++) {
            binaryArray[i] = getOneOrZero();
            System.out.printf("%s\t", binaryArray[i]);
        }

        // upgrading array
        System.out.println("\nThe array's state AFTER");
        for (int i  = 0; i < binaryArray.length; i++) {
            binaryArray[i] = binaryArray[i] ^ 1;
            System.out.printf("%s\t", binaryArray[i]);
        }
    }

    /*
    Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    public static void questionTwo() {
        printTitle("Question 2. Filling progression");

        int[] prgsArray = new int[8];
        for (int i = 0; i < 8; i++){
            prgsArray[i] = i * 3;
        }
        System.out.println(Arrays.toString(prgsArray));
    }

    /*
    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void questionThree(){
        printTitle("Question 3. Multiplication");

        int[] multArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i : multArray){
            System.out.printf("before: %s;\t after: %s\n", i, i < 6 ? i * 2 : i);
        }
    }

    /*
    Создать квадратный двумерный целочисленный массив
    (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    заполнить его диагональные элементы единицами;
     */
    public static void questionFour(){
        printTitle("Question 4. Matrix");

        int arraySize = getRandomArraySize(10);
        int[][] matrixArray = new int[arraySize][arraySize];

        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (i == j) {
                    matrixArray[i][j] = 1;
                }
                else {
                    matrixArray[i][j] = 0;
                }
                System.out.printf("%s\t", matrixArray[i][j]);
            }
            System.out.println();
        }
    }

    /*
     ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public static void questionFive(){
        printTitle("Question 5. Max and min elem");

        int[] minMaxArray = new int[getRandomArraySize(10)];
        // fill and print array
        for (int i = 0; i < minMaxArray.length; i ++) {
            minMaxArray[i] = (int) (Math.random() * 100);
            System.out.printf("%s\t", minMaxArray[i]);
        }

        int minValue = 101;
        int maxValue = -1;
        // getting min and max value
        for (int i : minMaxArray){
            if (minValue > i){
                minValue = i;
            }
            if (maxValue < i){
                maxValue = i;
            }
        }

        System.out.printf("\nMin value = %s;\tMax value = %s\n", minValue, maxValue);
    }

    /*
     ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     метод должен вернуть true, если в массиве есть место, в котором сумма левой и
     правой части массива равны.
     Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
     checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
     эти символы в массив не входят.
     */
    public static void questionSix(int[] inputArray){
        printTitle("Question 6. Search equivalent parts");
        int sumLeft;
        int sumRight;
        int sumPosition;

        sumLeft = 0;
        sumRight = 0;
        sumPosition = -1;
        for (int i = 0; i < inputArray.length - 1; i++){
            sumLeft = sumLeft + inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++){
                sumRight = sumRight + inputArray[j];
            }
            if (sumLeft == sumRight){
                sumPosition = i;
                break;
            }
            sumRight = 0;
        }
        if (sumPosition >= 0){
            for (int i = 0; i < inputArray.length; i ++){
                System.out.printf("%s\t", inputArray[i]);
                if (i == sumPosition){
                    System.out.printf("||\t");
                }
            }
            System.out.println();
        }
        else{
            System.out.println("Array doesn't exist equivalent parts.");
        }
    }

    /*
     **** Написать метод, которому на вход подается одномерный массив
     и число n (может быть положительным, или отрицательным),
     при этом метод должен сместить все элементы массива на n позиций.
     Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static void questionSeven(int[] inputArray, int delta){
        printTitle("Question 7. Move array.");

        System.out.println("...in process...");
    }
}
