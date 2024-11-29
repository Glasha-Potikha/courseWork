public class Main {
    public static void main(String[] args) {
        Employee[] firstDepartment = {new Employee(1, "Кабан Кабанов", 100000), new Employee(2, "Сергей Сергеев", 15000), new Employee(2, "Олег Олегов", 15000), new Employee(1, "Зинаида Борисова", 145000), new Employee(2, "Антон Семенов", 15000), new Employee(2, "Василий Петров", 10000), new Employee(2, "Денис Викторов", 150000), new Employee(1, "Павел Константинов", 15000), new Employee(2, "Валентин Петров", 15000), new Employee(2, "Анастасия Васильева", 15000)};

        outListEmployees(firstDepartment);

        System.out.println("Сумма затрат на ЗП в месяц состовляет " + getTotalSalary(firstDepartment) + " рублей");

        System.out.println("Минимальная зарплата в отделе составляет " + getMinSalary(firstDepartment) + " рублей");

        System.out.println("Максимальная зарплата в отделе составляет " + getMaxSalary(firstDepartment) + " рублей");

        System.out.println("Средняя зарплата по отделу " + getAverageSalary(firstDepartment) + " рублей");

        outListEmployeesNames(firstDepartment);
        indexSalary(firstDepartment, 10);
        System.out.println("Средняя зарплата по отделу " + getAverageSalary(firstDepartment) + " рублей");

        System.out.println(getMinSalaryInDepartment(firstDepartment, 2));
        System.out.println(getMaxSalaryInDepartment(firstDepartment, 2));
        System.out.println(getTotalSalaryInDepartment(firstDepartment, 1));
        System.out.println(getAverageSalaryInDepartment(firstDepartment, 1));

        indexSalaryInDepartment(firstDepartment, 1, 10);
        System.out.println(getTotalSalaryInDepartment(firstDepartment, 1));
        outListEmployeesInDepartment(firstDepartment, 2);
        System.out.println();
        outEmployeesWithLowerSalaries(firstDepartment, 100000);
        System.out.println();
        outEmployeesWithHigherSalaries(firstDepartment, 100000);
    }

    //Базовая сложность:
    public static void outListEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int getTotalSalary(Employee[] employees) {
        int res = 0;
        for (Employee employee : employees) {
            res += employee.getSalary();
        }

        return res;
    }

    public static int getMinSalary(Employee[] employees) {
        int res = Integer.MAX_VALUE;
        for (Employee employee : employees) {
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

    public static int getMaxSalary(Employee[] employees) {
        int res = 0;
        for (Employee employee : employees) {
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

    public static int getAverageSalary(Employee[] employees) {
        return getTotalSalary(employees) / employees.length;
    }

    public static void outListEmployeesNames(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    //Повышенная сложность:
    //1.
    public static void indexSalary(Employee[] employees, double percent) {
        double percentFloat = percent / 100.0;
        for (Employee employee : employees) {
            int salary = employee.getSalary();
            salary += (int) (salary * percentFloat);
            employee.setSalary(salary);
        }
    }

    //2.
    public static int getMinSalaryInDepartment(Employee[] employees, int department) {
        int res = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int salary = employee.getSalary();
                if (res > salary) {
                    res = salary;
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            throw new RuntimeException("Значение не найдено");
        }
        return res;
    }

    public static int getMaxSalaryInDepartment(Employee[] employees, int department) {
        int res = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int salary = employee.getSalary();
                if (res < salary) {
                    res = salary;
                }
            }
        }
        if (res == 0) {
            throw new RuntimeException("Значение не найдено");
        }
        return res;
    }

    public static int getTotalSalaryInDepartment(Employee[] employees, int department) {
        int res = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                res += employee.getSalary();
            }
        }
        return res;
    }

    public static int getAverageSalaryInDepartment(Employee[] employees, int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count++;
            }
        }
        return getTotalSalaryInDepartment(employees, department) / count;
    }

    public static void indexSalaryInDepartment(Employee[] employees, int department, int percent) {
        double percentFloat = percent / 100.0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int salary = employee.getSalary();
                salary += (int) (salary * percentFloat);
                employee.setSalary(salary);
            }
        }
    }

    public static void outListEmployeesInDepartment(Employee[] employees, int department) {
        //все данные, кроме отдела
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary() + " рублей");
            }
        }
    }

    //3.
    public static void outEmployeesWithLowerSalaries(Employee[] employees, int salary) {

        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary() + " рублей");
            }
        }
    }

    public static void outEmployeesWithHigherSalaries(Employee[] employees, int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary() + " рублей");
            }
        }
    }

}