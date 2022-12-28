package core.config;

public class ApplicationConfig {

    public ApplicationConfig() {

    }
    private DatabaseConfig database;

    public DatabaseConfig getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfig database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "\ndatabase: " + database + "\n";
    }
}
