package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Іван", 2);

        student.addCourse("Математика");
        student.addCourse("Фізика");
        student.addCourse("Програмування");

        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}