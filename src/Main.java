public class Main {
    public static void main(String[] args) {
        Employee[] a = {new Employee(1, "Кабан Кабанов", 100000), new Employee(2, "Сергей Сергеев", 15000), new Employee(2, "Олег Олегов", 15000), new Employee(1, "Зинаида Борисова", 145000), new Employee(2, "Антон Семенов", 15000), new Employee(2, "Василий Петров", 10000), new Employee(2, "Денис Викторов", 150000), new Employee(1, "Павел Константинов", 15000), new Employee(2, "Валентин Петров", 15000), null};
        EmployeeBook bookA = new EmployeeBook(a);
        System.out.println(bookA.addEmployee(new Employee(2, "Анастасия Васильева", 15000)));
        bookA.outListEmployeesInDepartment(2);
        System.out.println("__________________________________________");

        bookA.deleteEmployee(5);
        bookA.outListEmployeesInDepartment(2);
        System.out.println(bookA.getEmployeeBuId(10));
        System.out.println("__________________________________________");


        Employee[] b = {new Employee(1, "Степан Кабанов", 100000), new Employee(2, "Сергей Сергеев", 15000), new Employee(2, "Олег Олегов", 15000), new Employee(1, "Зинаида Борисова", 145000), new Employee(2, "Антон Семенов", 15000), new Employee(2, "Василий Петров", 10000), new Employee(2, "Денис Викторов", 150000), new Employee(1, "Павел Константинов", 15000), new Employee(2, "Валентин Петров", 15000), new Employee(2, "Анастасия Васильева", 15000)};
        EmployeeBook bookB = new EmployeeBook(b);

        bookB.outListEmployees();

        System.out.println("Сумма затрат на ЗП в месяц состовляет " + bookB.getTotalSalary() + " рублей");

        System.out.println("Минимальная зарплата в отделе составляет " + bookB.getMinSalary() + " рублей");

        System.out.println("Максимальная зарплата в отделе составляет " + bookB.getMaxSalary() + " рублей");

        System.out.println("Средняя зарплата по отделу " + bookB.getAverageSalary() + " рублей");

        bookB.outListEmployeesNames();
        bookB.indexSalary(10);
        System.out.println("Средняя зарплата по отделу " + bookB.getAverageSalary() + " рублей");

        System.out.println(bookB.getMinSalaryInDepartment(2));
        System.out.println(bookB.getMaxSalaryInDepartment(2));
        System.out.println(bookB.getTotalSalaryInDepartment(1));
        System.out.println(bookB.getAverageSalaryInDepartment(1));

        bookB.indexSalaryInDepartment(1, 10);
        System.out.println(bookB.getTotalSalaryInDepartment(1));
        bookB.outListEmployeesInDepartment(2);
        System.out.println();
        bookB.outEmployeesWithLowerSalaries(100000);
        System.out.println();
        bookB.outEmployeesWithHigherSalaries(100000);
    }
}