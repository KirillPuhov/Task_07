//Вводится массив целых чисел. Найти последнюю самую длинную
//подпоследовательность полностью различных (ни один элемент не равен накакому другому элементу) подряд идущих элементов массива
//(реализовать функцию, которая будет возвращать позицию первого элемента такой подпоследовательности и кол-во элементов).

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,5,4,77,2,12,3,3,3,5,6,7,8,8};
        int[] array2 = {1,2,3,4,15,15,53,65,54,10,0,29,8,8};
        int[] array3 = {1,1};
        int[] array4 = {1,2,1,2,1,2};
        int[] array5 = {0,0,0,0,1,1,1,1,2,3,4,5};
        int[] array6 = {0,1,0,2,0,3,0,4,0,5,0,6};
        int[] array7 = {1,2,3,4,5,1,1,1,1,6,7,8};
        int[] array8 = {0,1,3,4,5,6,7,8,9};
        int[] array9 = {2,2,2,1};
        int[] array10 = {1,2,3,2,2};

        solution(array1);
        solution(array2);
        solution(array3);
        solution(array4);
        solution(array5);
        solution(array6);
        solution(array7);
        solution(array8);
        solution(array9);
        solution(array10);
    }
    private static void solution(int[] arr){
        int maxCounter = 0;
        int maxIndex = 0;
        int index = 0;

        int indexI = 0;

        for(int i=0;i<arr.length;i++){
            indexI++;
            for(int j=index;j<i;j++){
                if(arr[i] == arr[j]){
                    if(maxCounter <= i-index){
                        maxCounter = i-index;
                        maxIndex = index;
                    }
                    index = i;
                }
            }
        }

        if(maxCounter <= indexI-index){
            maxCounter = indexI-index;
            maxIndex = index;
        }

        System.out.println(maxCounter + " - " + maxIndex);
    }
}