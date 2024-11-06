import java.util.Arrays;

/**
 * Example Output:
 * Hallo, anbei meine Prüfungen und Noten: Datum, Fach, Prüfungsart, Note 11.11.1111, IT , Stegreifaufgabe, 1 12.12.1212, Englisch , Schulaufgabe , 1 Bei Fragen kommen Sie gerne auf mich zu. Beste Grüße Diese Nachricht wurde aus Notenapp - Schulplaner digital versendet. Erfahre mehr unter www.notenapp.com
 */

public class AnalyzeInput {
    static final int MAX_EXAMS = 500;

    public static Exam[] getExamsFromString(String in) {

        char[] chars = getFormatedCharArray(in.toCharArray()); // input
        int index = 0;

        short type = 0; // 0 = date, 1 = subject, 2 = type, 3 = grade
        int typeIndex = 0; // index of the current char in the typeArray
        char[] typeArray = new char[50];

        Exam[] exams = new Exam[MAX_EXAMS];
        int examIndex = 0;
        Exam currentExam = new Exam();


        for (char symbol : chars) {
            if (checkForGap(typeIndex, typeArray, symbol, type)) {

                currentExam.setByIndex(type, CharConverter.toString(typeArray, typeIndex));

                if (type == 3) {
                    exams[examIndex] = currentExam;
                    examIndex++;
                    currentExam = new Exam();

                    type = 0;
                    typeIndex = 0;
                } else {
                    type++;
                    typeIndex = 0;
                }
            } else if (index == chars.length - 1) { // last char (grade)
                currentExam.setByIndex(3, Character.toString(symbol));
                exams[examIndex] = currentExam;
            } else {
                typeArray[typeIndex] = symbol;
                typeIndex++;
            }
            index++;
        }
        return exams;
    }

    public static Boolean checkForGap(int index, char[] typeArray, char symbol, int type) {
        // grade
        if (index != 0 && typeArray[index - 1] == ',' && symbol == ' ') {
            return true;
        } else return type == 3 && index > 0 && symbol == ' ';
    }

    // removes unnecessary characters from the input
    public static char[] getFormatedCharArray(char[] in) {

        int beforeContent = 0;
        int length = 0;

        boolean inContent = false;
        for (char currentChar : in) {
            if (!inContent && Character.isDigit(currentChar)) {
                inContent = true;
            } else if (currentChar == ' ' && in[beforeContent + length + 1] == 'B' && Character.isDigit(in[beforeContent + length -1])) {
                break;
            }

            if (inContent) {
                length++;
            } else {
                beforeContent++;
            }
        }

        char[] out = new char[length];
        System.arraycopy(in , beforeContent, out, 0, length);

        return out;
    }
}
