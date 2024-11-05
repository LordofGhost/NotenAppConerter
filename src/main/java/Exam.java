public class Exam {
    String date;
    String subject;
    String type;
    String grade;

    public void setByIndex(int index, String value) {
        switch (index) {
            case 0:
                date = value;
                break;
            case 1:
                subject = value;
                break;
            case 2:
                type = value;
                break;
            case 3:
                grade = value;
                break;
        }
    }
}
