package ua.opnu;

public class Student {

    private String name;
    private int year; // від 1 до 4
    private String[] courses;
    private int courseCount; // поточна кількість дисциплін

    private static final int MAX_COURSES = 20; // максимум дисциплін
    private static final int YEARLY_TUITION = 20000;

    // Конструктор
    public Student(String name, int year) {
        this.name = (name != null) ? name : "Unknown";
        if (year < 1 || year > 4) {
            this.year = 1;
        } else {
            this.year = year;
        }
        this.courses = new String[MAX_COURSES];
        this.courseCount = 0;
    }

    // Додає дисципліну
    public void addCourse(String courseName) {
        if (courseName != null && !courseName.trim().isEmpty() && courseCount < MAX_COURSES) {
            courses[courseCount] = courseName;
            courseCount++;
        }
    }

    // Видаляє всі дисципліни
    public void dropAll() {
        for (int i = 0; i < courseCount; i++) {
            courses[i] = null;
        }
        courseCount = 0;
    }

    // Кількість дисциплін
    public int getCourseCount() {
        return courseCount;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getTuition() {
        return year * YEARLY_TUITION;
    }

    // Додатковий метод для виведення всіх дисциплін
    public String getAllCourses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courseCount; i++) {
            sb.append(courses[i]);
            if (i < courseCount - 1) sb.append(", ");
        }
        return sb.toString();
    }
}

