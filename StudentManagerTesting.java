import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private Set<String> courses;

    public Student(int id, String name, int age, Set<String> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new HashSet<>(courses);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }
}

class StudentManager {
    private Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(Integer id) {
        students.remove(id);
    }

    public void updateStudent(Integer id, String name, Integer age, Set<String> courses) {
        Student student = students.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.getCourses().clear();
            student.getCourses().addAll(courses);
        } else {
            System.out.println("Студент с ID " + id + " не существует");
        }
    }

    public Student findStudentById(Integer id) {
        return students.get(id);
    }

    public void printStudentsByCourse(String course) {
        for (Student student : students.values()) {
            if (student.getCourses().contains(course)) {
                System.out.println(student);
            }
        }
    }

    public void printAllStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
}
public class StudentManagerTesting {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Set<String> courses1 = new HashSet<>();
        courses1.add("Java");
        courses1.add("Python");
        Student s1 = new Student(1, "Элина Бактыгулова", 18, courses1);

        Set<String> courses2 = new HashSet<>();
        courses2.add("Java");
        courses2.add("C++");
        Student s2 = new Student(2, "Назима Дилдебекова", 18, courses2);

        Set<String> courses3 = new HashSet<>();
        courses3.add("HTML");
        courses3.add("JavaScript");
        Student s3 = new Student(3, "Кубанычбек Алибеков", 50, courses3);

        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addStudent(s3);

        System.out.println("Список всех студентов:");
        manager.printAllStudents();

        System.out.println("\nПоиск студента с ID 2:");
        System.out.println(manager.findStudentById(2));

        System.out.println("\nОбновляем данные студента ID 1...");
        Set<String> newCourses = new HashSet<>();
        newCourses.add("Machine Learning");
        newCourses.add("Python"); // Дубликаты не добавятся
        manager.updateStudent(1, "Алиса Петрова", 21, newCourses);

        System.out.println("\nСписок всех студентов после обновления:");
        manager.printAllStudents();

        System.out.println("\nУдаляем студента с ID 3...");
        manager.removeStudent(3);

        System.out.println("\nСписок всех студентов после удаления:");
        manager.printAllStudents();

        System.out.println("\nСтуденты, изучающие курс 'Java':");
        manager.printStudentsByCourse("Java");
    }
}
