//Вводится массив целых чисел. Найти последнюю самую длинную
//подпоследовательность полностью различных (ни один элемент не равен накакому другому элементу) подряд идущих элементов массива
//(реализовать функцию, которая будет возвращать позицию первого элемента такой подпоследовательности и кол-во элементов).

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        tests();
        randomArrQuestion();
    }

    private static void tests(){
        solution(new int[]{1,2,3,4,5,5,4,77,2,12,3,3,3,5,6,7,8,8});
        solution(new int[]{1,2,3,4,15,15,53,65,54,10,0,29,8,8});
        solution(new int[]{1,1});
        solution(new int[]{1,2,1,2,1,2});
        solution(new int[]{0,0,0,0,1,1,1,1,2,3,4,5});
        solution(new int[]{0,1,0,2,0,3,0,4,0,5,0,6});
        solution(new int[]{1,2,3,4,5,1,1,1,1,6,7,8});
        solution(new int[]{0,1,3,4,5,6,7,8,9});
        solution(new int[]{2,2,2,1});
        solution(new int[]{1,2,3,2,2});
        solution(new int[]{1,2,2,3});
    }

    private static void randomArrQuestion(){
        System.out.println("Задать произвольный массив в качестве входных данных?");
        String answer = scan.nextLine().toUpperCase();
        System.out.println("Задайте кол-во элементов: ");
        int size = scan.nextInt();

        if(answer.equals("YES"))
            solution(randomizeArray(size));
    }

    private static void solution(int[] arr){
        printArray(arr);

        int maxLength = 0;
        int maxIndex = 0;
        int index = 0;

        int indexI = 0;

        for(int i=0;i<arr.length;i++){
            indexI++;
            for(int j=index;j<i;j++){
                if(arr[i] == arr[j]){
                    if(maxLength <= i-index){
                        maxLength = i-index;
                        maxIndex = index;
                    }
                    index = i;
                }
            }
        }

        if(maxLength <= indexI-index){
            maxLength = indexI-index;
            maxIndex = index;
        }

        System.out.printf("Позиция первого элемента: %d; Кол-во элементов: %d\n", maxIndex, maxLength);
        System.out.println("------------------------------------------------");
    }

    private static int[] randomizeArray(int size){
        var rand = new Random();

        int[] array = new int[size];

        for(int i=0; i < size; i++){
            array[i] = rand.nextInt(200);
        }

        return array;
    }

    private static void printArray(int[] arr){
        for (int j : arr) {
            System.out.printf("%d\s", j);
        }
        System.out.println();
    }
}