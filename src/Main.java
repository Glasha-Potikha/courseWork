public class Main {
    public static void main(String[] args) {
        Employee[] firstDepartment = {new Employee(1, "Кабан Кабанов", 100000), new Employee(1, "Сергей Сергеев", 15000), new Employee(1, "Олег Олегов", 15000), new Employee(1, "Зинаида Борисова", 145000), new Employee(1, "Антон Семенов", 15000), new Employee(1, "Василий Петров", 10000), new Employee(1, "Денис Викторов", 150000), new Employee(1, "Павел Константинов", 15000), new Employee(1, "Валентин Петров", 15000), new Employee(1, "Анастасия Васильева", 15000)};

        outListEmployees(firstDepartment);

        System.out.println("Сумма затрат на ЗП в месяц состовляет " + getTotalSalary(firstDepartment) + " рублей");

        System.out.println("Минимальная зарплата в отделе составляет " + getMinSalary(firstDepartment) + " рублей");

        System.out.println("Максимальная зарплата в отделе составляет " + getMaxSalary(firstDepartment) + " рублей");

        System.out.println("Средняя зарплата по отделу " + getAverageSalary(firstDepartment) + " рублей");

        outListEmployeesNames(firstDepartment);
    }

    public static void outListEmployees(Employee[] department) {
        for (Employee employee : department) {
            System.out.println(employee);
        }
    }

    public static int getTotalSalary(Employee[] department) {
        int res = 0;
        for (Employee employee : department) {
            res += employee.getSalary();
        }

        return res;
    }

    public static int getMinSalary(Employee[] department) {
        int res = Integer.MAX_VALUE;
        for (Employee employee : department) {
            int salary = employee.getSalary();
            if (res > salary) {
                res = salary;
            }
        }
        if (res == Integer.MAX_VALUE) {
            throw new RuntimeException("Значение не найдено");
        }
        return res;
    }

    public static int getMaxSalary(Employee[] department) {
        int res = 0;
        for (Employee employee : department) {
            int salary = employee.getSalary();
            if (res < salary) {
                res = salary;
            }
        }
        if (res == 0) {
            throw new RuntimeException("Значение не найдено");
        }
        return res;
    }

    public static int getAverageSalary(Employee[] department) {
        return getTotalSalary(department) / department.length;
    }

    public static void outListEmployeesNames(Employee[] department) {
        for (Employee employee : department) {
            System.out.println(employee.getFullName());
        }
    }
}