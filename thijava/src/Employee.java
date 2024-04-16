abstract class Employee implements IEmployee {
    private static int employeeCount = 0;
    protected int id;
    protected String fullName;
    protected String birthDay;
    protected String phone;
    protected String email;
    protected String employeeType;

    public Employee(String fullName, String birthDay, String phone, String email, String employeeType) {
        this.id = ++employeeCount;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
    }

    public abstract void showInfo();

    public static int getEmployeeCount() {
        return employeeCount;
    }
}
