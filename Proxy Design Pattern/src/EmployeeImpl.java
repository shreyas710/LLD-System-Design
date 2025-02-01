public class EmployeeImpl implements EmployeeDao {
    @Override
    public void create(String client, Employee obj) throws Exception {
        System.out.println("Employee created");
    }

    @Override
    public void delete(String client, int id) throws Exception {
        System.out.println("Employee deleted with id: " + id);
    }

    @Override
    public Employee get(String client, int id) throws Exception {
        System.out.println("Employee get with id: " + id);
        return new Employee();
    }
}
