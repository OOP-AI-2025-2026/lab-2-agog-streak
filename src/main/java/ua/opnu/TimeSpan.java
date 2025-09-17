package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    // Конструктор
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    // Геттери
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // Додавання іншого TimeSpan
    public void addTimeSpan(TimeSpan span) {
        if (span == null) return;
        this.hours += span.hours;
        this.minutes += span.minutes;
        normalize();
    }

    // Додавання конкретних значень
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) return;
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    // Віднімання іншого TimeSpan
    public void subtract(TimeSpan span) {
        if (span == null) return;

        int totalMinutes = this.toMinutes() - span.toMinutes();
        if (totalMinutes < 0) {
            // залишаємо як є
            return;
        }
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Масштабування
    public void scale(int factor) {
        if (factor <= 0) return;
        int totalMinutes = this.toMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Повертає загальну кількість годин (дробова)
    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    // Повертає загальну кількість хвилин
    public int getTotalMinutes() {
        return toMinutes();
    }

    // Переводимо у хвилини
    private int toMinutes() {
        return hours * 60 + minutes;
    }

    // Нормалізація хвилин
    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        }
    }
}



