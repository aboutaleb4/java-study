import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class study {

    public static void main(String[] args) {
        arrayNotes();

        listNotes();

        hashMapNotes();

    }

    private static void hashMapNotes() {
        /* HashMaps */
        // Creating an empty hashmap
        // HashMap<int, int> hm = new HashMap<>(); --> Error
        HashMap<Integer, Integer> hm = new HashMap<>();

        //Adding to hashmap
        hm.put(1, 2);

        //Getting from Hashmap
        int gottenAsPrimitiveInt = hm.get(1);
        System.out.println("Got Item: " + gottenAsPrimitiveInt);

        //Checking if a key exists
        System.out.println("Key Exists: " + hm.containsKey(1));
        System.out.println("Key Doesn't Exist: " + hm.containsKey(2));

        //Checking if a value exists
        System.out.println("Value Exists: " + hm.containsValue(2));
        System.out.println("Value Doesn't Exist: " + hm.containsValue(1));
    }

    private static void listNotes() {
        /* Lists */
        //List Creation
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(4);
        System.out.println("Integer List: " + integerList);
        //Looping over list items
        for (int i : integerList) {
            System.out.println("Integer List item: " + i);
        }
        int size = integerList.size();
        System.out.println("Size: " + size);
        System.out.println();
    }

    private static void arrayNotes() {
        /* Arrays */
        //Instantiating an array with items in it.
        int[] numbers = {1, 2, 3, 4, 5};

        //Fetching using index
        int numberFetchedUsingIndex = numbers[2];
        System.out.println("The third number is: " + numberFetchedUsingIndex);
        try {
            //Attempting to fetch using an index that is out of bounds
            numberFetchedUsingIndex = numbers[6];
            System.out.println("The sixth number is: " + numberFetchedUsingIndex);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}