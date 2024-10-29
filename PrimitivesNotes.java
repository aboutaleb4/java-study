public class PrimitivesNotes {
    public static void notes() {
        System.out.println(Integer.MAX_VALUE);                     //2147483647
        System.out.println(Integer.MAX_VALUE + 1);                 //-2147483648
        System.out.println(Integer.MAX_VALUE * 2);                 //-2
        System.out.println(2 * Integer.MAX_VALUE);                 //-2
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE); //-2
        System.out.println();
        System.out.println(Integer.MIN_VALUE);                     //-2147483648
        System.out.println(Integer.MIN_VALUE - 1);                 //2147483647
        System.out.println(Integer.MIN_VALUE * 2);                 //0
        System.out.println(2 * Integer.MIN_VALUE);                 //0
        System.out.println(Integer.MIN_VALUE + Integer.MIN_VALUE); //0
        System.out.println();
        System.out.println(Integer.MIN_VALUE - Integer.MAX_VALUE); //1
        System.out.println(Integer.MAX_VALUE - Integer.MIN_VALUE); //-1
        System.out.println(Integer.MIN_VALUE + Integer.MAX_VALUE); //-1
        System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE); //-1

    }
}
