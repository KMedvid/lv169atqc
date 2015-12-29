package com.softserve.edu.oms.services;

import com.softserve.edu.oms.data.OrderContainer;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Parse data about orders from the page table
 */
public class PageService {
    private static final Logger log = Logger.getLogger(PageService.class);


    public List<OrderContainer> parseOrderPage(WebElement orderTable) {
        List<WebElement> eles = orderTable.findElements(By.tagName("td"));
        int counter = 0;
        List<OrderContainer> pageContainers = new ArrayList<>();
        OrderContainer container = new OrderContainer();

        for (WebElement el : eles) {
            String value = el.getText();

            if (counter == 0) container.setOrderName(value);
            if (counter == 1) container.setTotalPrice(value);
            if (counter == 2) container.setMaxDiscount(value);
            if (counter == 3) container.setDeliveryDate(value);
            if (counter == 4) container.setStatus(value);
            if (counter == 5) container.setAssignee(value);
            if (counter == 6) container.setRole(value);
            if (counter == 8) {
                pageContainers.add(container);
                container = new OrderContainer();
                counter = 0;
            } else {
                counter++;
            }
        }
        return pageContainers;
    }
}
