import java.util.Arrays;

public class CharConverter {

    public static String toString(char[] chars, int index) {
        char[] newChars = new char[index];

        System.arraycopy(chars, 0, newChars, 0, index);

        String copy = String.copyValueOf(newChars);
        copy = copy.replace(",", "");
        return copy.trim();
    }
}
