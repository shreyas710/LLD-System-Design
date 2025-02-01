public class EmployeeProxy implements EmployeeDao {
    EmployeeDao employeeDao;

    public EmployeeProxy() {
        employeeDao = new EmployeeImpl();
    }

    @Override
    public void create(String client, Employee obj) throws Exception {
        if(client.equals("ADMIN")) {
            employeeDao.create(client, obj);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public void delete(String client, int id) throws Exception {
        if(client.equals("ADMIN")) {
            employeeDao.delete(client, id);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public Employee get(String client, int id) throws Exception {
        if(client.equals("ADMIN") || client.equals("USER")) {
            return employeeDao.get(client, id);
        }
        return null;
    }
}
