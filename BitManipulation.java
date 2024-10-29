import java.util.Arrays;

public class BitManipulation {
    static void notes() {
        for (int x = 0; x < 16; x++) {
            StringBuilder sb = new StringBuilder();
            int i = x;
            while (i > 0) {
                sb.append(i&1);
                i=i>>1;
            }
            System.out.println("The bit representation of " + x + " is: " + sb.reverse());
        }
    }
}
