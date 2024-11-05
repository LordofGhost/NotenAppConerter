import java.util.Arrays;

public class CharConverter {
    public static String toString(char[] chars, int index) {
        char[] newChars = new char[index];

        for (int i = 0; i < index; i++) {
            newChars[i] = chars[i];
        }
        return Arrays.toString(newChars);
    }
}
