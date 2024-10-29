import java.util.Date;
import java.util.HashMap;

public class HashMapNotes {
    static void hashMapNotes() {
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

        HashMap<String, HashMap<String, Double>> hashMap = new HashMap<>();
        hashMap.computeIfAbsent("key", k -> new HashMap<>()).put("inner key", 1.0);
        hashMap.computeIfAbsent("key 2", k -> new HashMap<>()).put("inner key 2", 2.0);
        hashMap.computeIfAbsent("key", k -> new HashMap<>()).put("inner key 3", 3.0);

        System.out.println(hashMap);
    }
}
