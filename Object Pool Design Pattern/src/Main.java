public class Main {
    public static void main(String[] args) {
        DBConnectionPoolManager dbConnectionPoolManager = DBConnectionPoolManager.getInstance();

        DBConnection dbConnection1 = dbConnectionPoolManager.getFreeConnection();
        DBConnection dbConnection2 = dbConnectionPoolManager.getFreeConnection();
        DBConnection dbConnection3 = dbConnectionPoolManager.getFreeConnection();
        DBConnection dbConnection4 = dbConnectionPoolManager.getFreeConnection();
        DBConnection dbConnection5 = dbConnectionPoolManager.getFreeConnection();
        DBConnection dbConnection6 = dbConnectionPoolManager.getFreeConnection();
        dbConnectionPoolManager.getFreeConnection();
        dbConnectionPoolManager.releaseConnection(dbConnection6);
    }
}