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

    public void testUpdateStudentSuccess() {
        // Given
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("John", "Doe", "123");

        // When
        boolean result = studentManager.updateStudent("Jane", "Smith", "123");

        // Then
        assert result : "Successful update";
        Student updatedStudent = studentManager.getStudent("123");
        assert "Jane".equals(updatedStudent.getName()) : "Name should be updated to Jane";
        assert "Smith".equals(updatedStudent.getSurname()) : "Surname should be updated to Smith";
    }


    public void testUpdateStudentNonExistingId() {
        // Given
        StudentManager studentManager = new StudentManager();

        // When
        boolean result = studentManager.updateStudent("Jane", "Smith", "123");

        // Then
        assert result: "Student don't exists";
    }


    public void testUpdateStudentInvalidData() {
        // Given
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("John", "Doe", "123");

        // When
        boolean result = studentManager.updateStudent(null, null, "123");

        // Then
        assert result : "Updating student is impossible because of wrong data";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public boolean updateStudent(String name, String surname, String studentId) {
        if (name == null || surname == null || studentId == null || !students.containsKey(studentId)) {
            return false;
        }

        Student student = students.get(studentId);
        student.setName(name);
        student.setSurname(surname);
        return true;
    }


     public Student getStudent(String studentId) {
         return students.get(studentId);
     }

}

public class Main {

    public static void main(String[] args) {
   // new StudentManagerTest().testAddStudentDuplicateId();
    //new StudentManagerTest().testAddStudentSuccess();
    //new StudentManagerTest().testUpdateStudentInvalidData();
    //new StudentManagerTest().testUpdateStudentSuccess();
    //new StudentManagerTest().testUpdateStudentNonExistingId();

    }

}