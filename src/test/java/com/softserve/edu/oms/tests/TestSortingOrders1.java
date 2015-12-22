package com.softserve.edu.oms.tests;

/**
 * Test-cases for verifying functionality of orders sorting on the OrderingPage
 */

import com.softserve.edu.oms.data.*;
import com.softserve.edu.oms.pages.LoginStartPage;
import com.softserve.edu.oms.pages.OrderingPage;
import com.softserve.edu.oms.services.DBService;
import com.softserve.edu.oms.services.PageService;
import com.softserve.edu.oms.services.WebDBElemsCompareUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestSortingOrders1 {
    private static final Logger log = Logger.getLogger(TestSortingOrders1.class);
    private DBService dbService;
    private PageService pageService;
    private WebDBElemsCompareUtils compareElems;

    @BeforeClass
    public void init() {
        dbService = new DBService();
        pageService = new PageService();
        compareElems = new WebDBElemsCompareUtils();
        log.info("Services initialization successfully finished");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod: ThreadId = " + Thread.currentThread().getId());
        LoginStartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
        log.info("@AfterClass - oneTimeTearDown");
        System.out.println("@AfterClass: ThreadId = " + Thread.currentThread().getId());
        LoginStartPage.get().quit();
    }

    @DataProvider
    public Object[][] customerUser() {
        return new Object[][]{
                {UserRepository.get().getCustomerUser(), UrlRepository.get().getLocalUrls()},
        };
    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByOrderNameDesc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        //Thread.sleep(1000);
        orderingPage.clickOrderName();
        //Thread.sleep(1000);
        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by OrderName desc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByOrderNameAsc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        //Thread.sleep(1000);
        orderingPage.clickOrderName();
        //Thread.sleep(1000);
        orderingPage.clickOrderName();
        //Thread.sleep(1000);
        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by OrderName asc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByTotalPriceDesc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        //Thread.sleep(1000);
        orderingPage.clickTotalPrice();
        //Thread.sleep(1000);
        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by TotalPrice desc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByTotalPriceAsc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        //Thread.sleep(1000);
        orderingPage.clickTotalPrice();
        //Thread.sleep(1000);
        orderingPage.clickTotalPrice();
        //Thread.sleep(1000);

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by TotalPrice asc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByMaxDiscountDesc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickMaxDiscount();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by MaxDiscount desc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByMaxDiscountAsc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickMaxDiscount();
        orderingPage.clickMaxDiscount();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by MaxDiscount asc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByDeliveryDateDesc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickDeliveryDate();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by DeliveryDate desc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByDeliveryDateAsc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickDeliveryDate();
        orderingPage.clickDeliveryDate();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by DeliveryDate asc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByAssigneeDesc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickAssignee();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by Login desc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByAssigneeAsc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickAssignee();
        orderingPage.clickAssignee();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by Login asc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByRoleDesc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickRole();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by RoleName desc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByRoleAsc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickRole();
        orderingPage.clickRole();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by RoleName asc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByStatusDesc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickStatus();
        orderingPage.clickStatus();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by OrederStatusName desc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");

    }

    @Test(dataProvider = "customerUser")
    public void testOrdersPageOrderByStatusAsc(IUser customerUser, IUrls urls) throws Exception {
        //Precondition
        OrderingPage orderingPage = LoginStartPage.get().load(urls)
                .successCustomerLogin(UserRepository.get().getCustomerUser()).gotoOrdering();
        // test steps
        orderingPage.clickStatus();

        List<OrderContainer> ordersFromPage = pageService.parseOrderPage(orderingPage.getOrderTableElement());
        List<OrderContainer> ordersFromDB = dbService.getDBOrders("order by OrederStatusName asc");

        Assert.assertTrue(compareElems.isTheSameOrder(ordersFromPage, ordersFromDB), "Order is not the same");
    }

}
