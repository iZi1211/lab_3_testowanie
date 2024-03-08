import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class StudentManagerTest {


    void testAddStudentSuccess() {
        // Given
        StudentManager studentManager = new StudentManager();

        // When
        boolean result = studentManager.addStudent("John", "Doe", "123");

        // Then
        assert result: "Adding a student should return true for success";
    }


    void testAddStudentDuplicateId() {
        // Given
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("John", "Doe", "123");

        // When
        boolean result = studentManager.addStudent("Jane", "Smith", "123");

        // Then
        assert result : "Adding a student with a duplicate ID should return false";
    }
}

 class Student {
    private String name;
    private String surname;
    private String studentId;

    public Student(String name, String surname, String studentId) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
    }


}


 class StudentManager {

    private Map<String, Student> students;

    public StudentManager() {
        this.students = new HashMap<>();
    }

    public boolean addStudent(String name, String surname, String studentId) {
        if (students.containsKey(studentId)) {
            return false; // Student with the same ID already exists
        }

        Student student = new Student(name, surname, studentId);
        students.put(studentId, student);
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
   // new StudentManagerTest().testAddStudentDuplicateId();
    new StudentManagerTest().testAddStudentSuccess();



    }

}