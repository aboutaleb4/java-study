public class CharsStringsAndStringBuilders {
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

        String stringForTesting;
        StringBuilder stringBuilderForTesting;

        stringBuilderForTesting = new StringBuilder();
        stringBuilderForTesting.append(2);
        stringBuilderForTesting.append(2.5);
        stringBuilderForTesting.append('a');
        stringBuilderForTesting.append('b');
        stringBuilderForTesting.append('c');
        stringBuilderForTesting.append("xyz");

        System.out.println(stringBuilderForTesting);

        stringForTesting = stringBuilderForTesting.toString();

        for(int i = 0; i < stringBuilderForTesting.length(); i++) {
            System.out.println(stringBuilderForTesting.charAt(i));
        }

        stringBuilderForTesting = new StringBuilder(stringForTesting);
        stringForTesting = stringBuilderForTesting.reverse().toString();

        System.out.println(stringForTesting);

        stringBuilderForTesting = new StringBuilder(30);
        for(int i = 0; i < 40; i++) {
            stringBuilderForTesting.append(i);
        }
        stringBuilderForTesting.setCharAt(20, 'a');
        System.out.println(stringBuilderForTesting);
        System.out.println(stringBuilderForTesting.length());
    }
}
