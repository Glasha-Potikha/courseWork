import java.util.Objects;

public class Employee {
    private static int counter;
    private int id;
    private int department;
    private String fullName;
    private int salary;

    public Employee(int department, String fullName, int salary) {
        this.id = ++counter;
        this.department = department;
        this.fullName = fullName;
        this.salary = salary;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public int getDepartment() {
        return department;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Сотрудник из отдела №" +

                department +
                " " + fullName +
                " в месяц получает " + salary +
                " рублей в месяц" + " - id " + id;
    }
}
