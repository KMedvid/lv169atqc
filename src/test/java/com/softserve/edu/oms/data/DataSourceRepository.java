package com.softserve.edu.oms.data;

import java.sql.Driver;
import java.sql.SQLException;

import com.softserve.edu.data.DataSource;
import com.softserve.edu.exceptions.GeneralCustomException;

public final class DataSourceRepository {
    
    private final static String FAILED_JDBC_DRIVER = "Failed to create JDBC Driver";
    private static volatile DataSourceRepository instance = null;

    private DataSourceRepository() {
    }

    public static DataSourceRepository get() {
        if (instance == null) {
            synchronized (DataSourceRepository.class) {
                if (instance == null) {
                    instance = new DataSourceRepository();
                }
            }
        }
        return instance;
    }

    public DataSource getJtdsMsSqlLocal() {
        return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
                "jdbc:jtds:sqlserver://ROMAN/Lv169OMS;instance=SQLEXPRESS;", "db169", "db169");
    }

    public DataSource getJtdsMsSqlSsu() {
        return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
                "jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;", "ssu-oms", "ssu-oms");
    }

    public DataSource getJdbcMySqlLocal() {
        Driver jdbcDriver = null;
        try {
            jdbcDriver = new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            throw new GeneralCustomException(FAILED_JDBC_DRIVER, e);
        }
        return new DataSource(jdbcDriver,
                "jdbc:mysql://localhost:3306/measurement_devices;", "root", "root");
    }

    // TODO Read from properties, Excel, etc.

}
