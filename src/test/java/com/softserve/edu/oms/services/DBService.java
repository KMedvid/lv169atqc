package com.softserve.edu.oms.services;

import com.softserve.edu.oms.data.OrderContainer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Fetch data about orders from the DB
 */
public class DBService {

    private static final Logger log = Logger.getLogger(DBService.class);


    public List<OrderContainer> getDBOrders(String orderBy) {
        List<OrderContainer> orders = new ArrayList<>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            ResourceBundle rb = ResourceBundle.getBundle("db");
            Class.forName(rb.getString("db.class"));
            conn = DriverManager.getConnection(rb.getString("db.url"), rb.getString("db.user"), rb.getString("db.password"));

            log.info("Successfully connected to the datasource");
            st = conn.createStatement();
            String sql = "select o.OrderName, o.TotalPrice, o.MaxDiscount, o.DeliveryDate, os.OrederStatusName, u.Login, r.RoleName " +
                    "from Orders o, OrderStatuses os, Users u, Roles r  " +
                    "where o.OrderStatusRef = os.ID " +
                    "and o.Assigne = u.ID " +
                    "and u.RoleRef = r.ID " + orderBy;

            rs = st.executeQuery(sql);
            while (rs.next()) {
                OrderContainer order = new OrderContainer();
                order.setOrderName(rs.getString("OrderName"));
                order.setTotalPrice(rs.getString("TotalPrice"));
                order.setMaxDiscount(rs.getString("MaxDiscount"));
                order.setDeliveryDate(rs.getString("DeliveryDate"));
                order.setStatus(rs.getString("OrederStatusName"));
                order.setAssignee(rs.getString("Login"));
                order.setRole(rs.getString("RoleName"));

                orders.add(order);
            }
        } catch (Exception e) {
            log.info("Exception while fetching orders from DB: " + e.getMessage());
        } finally {
            closeCloseable(conn);
            closeCloseable(st);
            closeCloseable(rs);
        }
        return orders;
    }


    /**
     * Common method for closing opened resources
     *
     * @param closeable - resource to close
     */
    private static void closeCloseable(AutoCloseable closeable) {
        if (closeable != null)
            try {
                closeable.close();
            } catch (Exception e) {

            }
    }
}
