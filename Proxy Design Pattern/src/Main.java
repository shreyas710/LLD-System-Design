public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDao emp = new EmployeeProxy();
            emp.create("USER", new Employee());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}