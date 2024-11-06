import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharConverterTest {

    @Test
    void toStringTest() {
        char[] in = {' ', 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', ' '};
        int index = 12;

        Assertions.assertEquals("Hello World", CharConverter.toString(in, index));
    }

}