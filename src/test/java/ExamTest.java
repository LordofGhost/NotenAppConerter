import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExamTest {

    @Test
    public void testSetByIndex() {
        Exam exam = new Exam();
        exam.setByIndex(0, "21.10.2024");
        exam.setByIndex(1, "IT Technik");
        exam.setByIndex(2, "Stegreifaufgabe");
        exam.setByIndex(3, "1");
        Assertions.assertEquals("21.10.2024", exam.date);
        Assertions.assertEquals("IT Technik", exam.subject);
        Assertions.assertEquals("Stegreifaufgabe", exam.type);
        Assertions.assertEquals("1", exam.grade);
    }
}