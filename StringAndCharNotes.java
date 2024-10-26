public class StringAndCharNotes {
    static void notes() {
        String s = "ahmedmostafa";
        System.out.println(s);

        char[] charArray = new char[]{'a', 'h', 'm', 'e', 'd'};
        String sFromCharArray = new String(charArray);
        System.out.println(sFromCharArray);

        charArray = s.toCharArray();
        sFromCharArray = new String(charArray);
        System.out.println(sFromCharArray);


        /*
        Any arithmatic operations on char converts it to it's ascii and then applies the opration.
         */
        System.out.println('a' - 'a'); // returns int: 0
        System.out.println('a' - 0); // returns int: 97
        System.out.println(0 + 'a'); // returns int: 97
        System.out.println('a' + 1); // returns int: 98
        System.out.println((char)('a' + 1)); // returns int: 98
        System.out.println((char)('0' + ('9' - '0' + 1) % 10)); // returns char: '0'
        System.out.println((char)('0' + ('8' - '0' + 1) % 10)); // returns char: '9'

    }
}
