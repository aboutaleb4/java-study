import java.util.Arrays;

public class ArrayNotes {
    static void arrayNotes() {
        //Instantiating an array with items in it.
        int[] numbers = {1, 2, 3, 4, 5};

        //Instantiating an empty array
        int[] intArray = new int[5];
        System.out.println(Arrays.toString(intArray));

        //Overriding an empty array of size 5 with a  populated array of size 2.
        intArray = new int[]{2, 1};
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));


        char[] charArray = new char[]{'c', 'b', 'a'};
        Arrays.sort(charArray);
        System.out.println(Arrays.toString(charArray));

        //Fetching using index
        int numberFetchedUsingIndex = numbers[2];
        System.out.println("The third number is: " + numberFetchedUsingIndex);

        //Attempting to fetch using an index that is out of bounds
        try {
            numberFetchedUsingIndex = numbers[6];
            System.out.println("The sixth number is: " + numberFetchedUsingIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
