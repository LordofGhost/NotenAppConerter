import java.util.Arrays;

public class CharConverter {

    public static String toString(char[] chars, int index) {
        char[] newChars = new char[index];

        System.arraycopy(chars, 0, newChars, 0, index);

        String out = String.copyValueOf(newChars);
        return out.trim();
    }
}
