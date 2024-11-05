import java.util.Arrays;

/**
 * Example Output:
 * Hallo, anbei meine Prüfungen und Noten: Datum, Fach, Prüfungsart, Note 11.11.1111, IT , Stegreifaufgabe, 1 12.12.1212, Englisch , Schulaufgabe , 1 Bei Fragen kommen Sie gerne auf mich zu. Beste Grüße Diese Nachricht wurde aus Notenapp - Schulplaner digital versendet. Erfahre mehr unter www.notenapp.com
 */

public class AnalyzeInput {
    static final int MAX_EXAMS = 500;

    public static Exam[] getExamsFromString(String in) {

        char[] chars = getFormatedCharArray(in.toCharArray()); // input

        short type = 0; // 0 = date, 1 = subject, 2 = type, 3 = grade
        int index = 0; // index of the current char in the typeArray
        char[] typeArray = new char[50];

        Exam[] exams = new Exam[MAX_EXAMS];
        Exam currentExam = new Exam();


        for (char symbol : chars) {

            System.out.println(type + " " + Arrays.toString(typeArray));
            //System.out.println(index + " " + typeArray[index] + ""+  symbol);
            System.out.println(currentExam.date + " " + currentExam.subject + " " + currentExam.type + " " + currentExam.grade);

            if (checkForGap(index, typeArray, symbol)) {

                System.out.println("next type");

                currentExam.setByIndex(type, CharConverter.toString(typeArray, index).trim());
                if (type == 3) {
                    exams[exams.length] = currentExam;
                    currentExam = new Exam();
                    type = 0;
                } else {
                    type++;
                    index = 0;
                }
            } else {
                typeArray[index] = symbol;
                index++;
            }
        }

        return exams;
    }

    public static Boolean checkForGap(int index, char[] typeArray, char symbol) {
        if (index != 0 && typeArray[index - 1] == ',' && symbol == ' ') {
            return true;
        } else {
            return false;
        }
    }

    // removes unnecessary characters from the input
    public static char[] getFormatedCharArray(char[] in) {

        return in;
    }
}
