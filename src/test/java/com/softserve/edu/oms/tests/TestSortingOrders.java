package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.data.*;
import com.softserve.edu.oms.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSortingOrders {
    private WebDriver driver;

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

    @BeforeClass
    public void oneTimeSetUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void oneTimeTearDown() {
        driver.quit();
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @AfterMethod
    public void after() {
        driver.findElement(By.xpath("//a[@class='spec']")).click();
    }

    @DataProvider
    public Object[][] customerUser() {
        return new Object[][]{
                {UserRepository.get().getCustomerUser(), UrlRepository.get().getLocalUrls()},
        };
    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByOrderNameDesc(IUser customerUser,IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        driver.findElement(By.cssSelector("a[href*='orderName']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by OrderName desc");
        orderingPage.gotoLogout();
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByOrderNameAsc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        //Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.cssSelector("a[href*='orderName']"))).doubleClick().build().perform();
        driver.findElement(By.cssSelector("a[href*='orderName']")).click();
        driver.findElement(By.cssSelector("a[href*='orderName']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by OrderName asc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByTotalPriceDesc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='totalPrice']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by TotalPrice desc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByTotalPriceAsc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='totalPrice']")).click();
        driver.findElement(By.cssSelector("a[href*='totalPrice']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by TotalPrice asc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByMaxDiscountDesc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='maxDiscount']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by MaxDiscount desc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByMaxDiscountAsc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='maxDiscount']")).click();
        driver.findElement(By.cssSelector("a[href*='maxDiscount']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by MaxDiscount asc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByDeliveryDateDesc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='deliveryDate']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by DeliveryDate desc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByDeliveryDateAsc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='deliveryDate']")).click();
        driver.findElement(By.cssSelector("a[href*='deliveryDate']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by DeliveryDate asc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByAssigneeDesc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='assignee']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by Login desc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByAssigneeAsc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='assignee']")).click();
        driver.findElement(By.cssSelector("a[href*='assignee']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by Login asc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByRoleDesc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='role']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by RoleName desc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByRoleAsc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='role']")).click();
        driver.findElement(By.cssSelector("a[href*='role']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by RoleName asc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByStatusDesc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='status']")).click(); //another order of sorting
        driver.findElement(By.cssSelector("a[href*='status']")).click();
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by OrederStatusName desc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByStatusAsc(User customerUser) throws Exception {
        //Precondition
        driver.get("http://localhost:8080/OMS");
        CustomerHomePage customerHomePage = new LoginPage(driver).successCustomerLogin(customerUser);
        driver.findElement(By.partialLinkText("Ordering")).click();
        // test steps
        driver.findElement(By.cssSelector("a[href*='status']")).click(); //another order of sorting
        WebElement orderTable = driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
        List<OrderContainer> ordersFromPage = parseOrderPage(orderTable);
        List<OrderContainer> ordersFromDB = getDBOrders("order by OrederStatusName asc");
        Assert.assertTrue(isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");
        driver.findElement(By.xpath("//a[@class='spec']")).click();
    }

    /**
     * Checks whether given list of orders from the page equals to the list of orders fetched from the DB
     *
     * @param pageOrders - list of order from the page
     * @param dbOrders   - list of orders from the DB
     */
    private boolean isTheSameOrder(List<OrderContainer> pageOrders, List<OrderContainer> dbOrders) {
        if (pageOrders.size() > dbOrders.size()) return false;
        for (int i = 0; i < pageOrders.size(); i++) {
            OrderContainer pageOrder = pageOrders.get(i);
            OrderContainer dbOrder = dbOrders.get(i);
            if (!pageOrder.equals(dbOrder)) return false;
        }
        return true;
    }

    private List<OrderContainer> parseOrderPage(WebElement orderTable) {
        List<WebElement> eles = orderTable.findElements(By.tagName("td"));
        int counter = 0;
        List<OrderContainer> pageContainers = new ArrayList<>();
        OrderContainer container = new OrderContainer();

        for (WebElement el : eles) {
            String value = el.getText();
//            System.out.printf("cell: %s  counter: %d \n", value, counter);
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

    private List<OrderContainer> getDBOrders(String orderBy) {
        List<OrderContainer> orders = new ArrayList<>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://Jane-PC\\SQLExpress;user=db169;password=db169;database=Lv169OMS");
            System.out.println("test");
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
            System.out.println("Exception while fetching orders from DB: " + e.getMessage());
        } finally {
            closeCloseable(conn);
            closeCloseable(st);
            closeCloseable(rs);
        }

        return orders;
    }

}
