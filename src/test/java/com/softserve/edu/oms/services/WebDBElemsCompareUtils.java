package com.softserve.edu.oms.services;

import com.softserve.edu.oms.data.OrderContainer;

import java.util.List;

/**
 * Checks whether given list of orders from the page equals to the list of orders fetched from the DB
 *
 * @param pageOrders - list of order from the page
 * @param dbOrders   - list of orders from the DB
 */

public class WebDBElemsCompareUtils {


    public boolean isTheSameOrder(List<OrderContainer> pageOrders, List<OrderContainer> dbOrders) {
        if (pageOrders.size() > dbOrders.size()) return false;
        for (int i = 0; i < pageOrders.size(); i++) {
            OrderContainer pageOrder = pageOrders.get(i);
            OrderContainer dbOrder = dbOrders.get(i);
            if (!pageOrder.equals(dbOrder)) return false;
        }
        return true;
    }

}
