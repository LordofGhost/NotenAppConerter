import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnalyzeInputTest {

    @Test
    public void checkForGapTest1() {
        char[] typeArray = new char[]{'a', 'b', 'c', ',', ' '};
        char symbol = ' ';
        int index = 4;
        Assertions.assertTrue(AnalyzeInput.checkForGap(index, typeArray, symbol));
    }

    @Test
    public void checkForGapTest2() {
        char[] typeArray = new char[]{'a', 'b', ' ', ',', ' '};
        char symbol = ' ';
        int index = 4;
        Assertions.assertTrue(AnalyzeInput.checkForGap(index, typeArray, symbol));
    }

    @Test
    public void getFormatedCharArrayTest() {
        String text = "Hallo, anbei meine Prüfungen und Noten: Datum, Fach, Prüfungsart, Note 11.11.1111, IT , Stegreifaufgabe, 1 12.12.1212, Englisch , Schulaufgabe , 1 Bei Fragen kommen Sie gerne auf mich zu. Beste Grüße Diese Nachricht wurde aus Notenapp - Schulplaner digital versendet. Erfahre mehr unter www.notenapp.com";
        String formatedText = "11.11.1111, IT , Stegreifaufgabe, 1 12.12.1212, Englisch , Schulaufgabe , 1";
        char [] in = text.toCharArray();
        char[] out = AnalyzeInput.getFormatedCharArray(in);
        System.out.println(out);
        System.out.println(formatedText);
        Assertions.assertArrayEquals(formatedText.toCharArray(), out);
    }

    @Test
    public void getExamsFromStringTest() {
        String in = "Hallo, anbei meine Prüfungen und Noten: Datum, Fach, Prüfungsart, Note 11.11.1111, IT , Stegreifaufgabe, 1 12.12.1212, Englisch , Schulaufgabe , 1 Bei Fragen kommen Sie gerne auf mich zu. Beste Grüße Diese Nachricht wurde aus Notenapp - Schulplaner digital versendet. Erfahre mehr unter www.notenapp.com";
        Exam[] exams = AnalyzeInput.getExamsFromString(in);
        Assertions.assertEquals(2,exams.length);

        Assertions.assertEquals("11.11.1111", exams[0].date);
        Assertions.assertEquals("IT", exams[0].subject);
        Assertions.assertEquals("Stegreifaufgabe", exams[0].type);
        Assertions.assertEquals("1", exams[0].grade);

        Assertions.assertEquals("12.12.1212", exams[1].date);
        Assertions.assertEquals("Englisch", exams[1].subject);
        Assertions.assertEquals("Schulaufgabe", exams[1].type);
        Assertions.assertEquals("1", exams[1].grade);
    }
}