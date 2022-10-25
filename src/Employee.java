public class Employee {

    private final String name;
    private double salary;
    private final int workHours;
    private final int hireYear;

    private int bonus;
    private int tax;
    private int salaryIncrease;

    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public int tax() {
        this.tax = salary > 1000 ? (int) (salary * 3 / 100) : 0;
        return tax;
    }

    public int bonus() {
        this.bonus = workHours > 40 ? (workHours - 40) * 30 : 0;
        return bonus;
    }

    public void raiseSalary() {
        int currentYear = 2021;
        int totalWorkedYear = currentYear - hireYear;
        tax();
        bonus();
        if (totalWorkedYear < 10) {
            salaryIncrease += salary * 5 / 100;
        } else if (totalWorkedYear > 9 && totalWorkedYear < 20) {
            salaryIncrease += salary * 10 / 100;
        } else {
            salaryIncrease += salary * 15 / 100;
        }
    }

    @Override
    public String toString() {
        return "İsim :  " + name +
                "\nMaaş : " + salary +
                "\nÇalışma saati : " + workHours +
                "\nBaşlangıç yılı : " + hireYear +
                "\nVergi : " + tax +
                "\nBonus : " + bonus +
                "\nMaaş artışı : " + salaryIncrease +
                "\nVeri ve bonusla toplam maaş : " + ( salary + bonus  - tax) +
                "\nToplam maaş : " + (salary + bonus - tax + salaryIncrease);


    }

    public static void main(String[] args) {
        Employee employee = new Employee("Kemal", 2000, 45, 1985);
        employee.raiseSalary();
        System.out.println(employee.toString());
    }
}