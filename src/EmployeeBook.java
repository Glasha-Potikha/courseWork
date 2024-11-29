public record EmployeeBook(Employee[] employees) {

    //новые методы:
    //4.a
    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    //4.b
    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
        throw new RuntimeException("Сотрудник не найден");
    }

    //5.
    public Employee getEmployeeBuId(int id) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new RuntimeException("Сотрудник не найден");
    }
    //методы базовой и повышенной сложности:

    public void outListEmployees() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println(employee);
        }
    }

    public int getTotalSalary() {
        int res = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            res += employee.getSalary();
        }
        return res;
    }

    public int getAverageSalary() {
        return getTotalSalary() / employees().length;
    }

    public int getMinSalary() {
        int res = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
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

    public int getMaxSalary() {
        int res = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
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

    public void outListEmployeesNames() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println(employee.getFullName());
        }
    }

    public void indexSalary(double percent) {
        double percentFloat = percent / 100.0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int salary = employee.getSalary();
            salary += (int) (salary * percentFloat);
            employee.setSalary(salary);
        }
    }

    public int getMinSalaryInDepartment(int department) {
        int res = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
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

    public int getMaxSalaryInDepartment(int department) {
        int res = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
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

    public int getTotalSalaryInDepartment(int department) {
        int res = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                res += employee.getSalary();
            }
        }
        return res;
    }

    public int getAverageSalaryInDepartment(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                count++;
            }
        }
        return this.getTotalSalaryInDepartment(department) / count;
    }

    public void indexSalaryInDepartment(int department, int percent) {
        double percentFloat = percent / 100.0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                int salary = employee.getSalary();
                salary += (int) (salary * percentFloat);
                employee.setSalary(salary);
            }
        }
    }

    public void outListEmployeesInDepartment(int department) {
        //все данные, кроме отдела
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary() + " рублей");
            }
        }
    }

    public void outEmployeesWithLowerSalaries(int salary) {

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < salary) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary() + " рублей");
            }
        }
    }

    public void outEmployeesWithHigherSalaries(int salary) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() >= salary) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary() + " рублей");
            }
        }
    }
}