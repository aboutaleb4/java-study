import java.util.ArrayList;
import java.util.List;

public class study {

    public static void main(String[] args) {
        /* Lists */
        //List Creation
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(4);
        System.out.println("Integer List: " + integerList);
        System.out.println();
        for (int i : integerList) {
            System.out.println("Integer List item: " + i);
        }
        System.out.println();

        //Arrays
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("The third number is: " + numbers[2]);
    }
}