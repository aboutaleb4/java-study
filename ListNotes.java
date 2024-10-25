import java.util.ArrayList;
import java.util.List;

public class ListNotes {
    static void listNotes() {
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
}
