import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {
    private List<DBConnection> freeConnections = new ArrayList<>();
    private List<DBConnection> inUseConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;
    private static DBConnectionPoolManager dbConnectionPoolManagerInstance = null;

    private DBConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnections.add(new DBConnection());
        }
    }

    public static DBConnectionPoolManager getInstance() {
        if (dbConnectionPoolManagerInstance == null) {
            synchronized (DBConnectionPoolManager.class) {
                if (dbConnectionPoolManagerInstance == null) {
                    dbConnectionPoolManagerInstance = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManagerInstance;
    }

    public synchronized DBConnection getFreeConnection() {
        if (freeConnections.isEmpty() && inUseConnections.size() < MAX_POOL_SIZE) {
            freeConnections.add(new DBConnection());
        } else if (freeConnections.isEmpty()) {
            return null;
        }
        DBConnection freeConnection = freeConnections.remove(freeConnections.size() - 1);
        inUseConnections.add(freeConnection);
        return freeConnection;
    }

    public synchronized void releaseConnection(DBConnection inUseConnection) {
        if (inUseConnection != null) {
            inUseConnections.remove(inUseConnection);
            freeConnections.add(inUseConnection);
        }
    }
}
