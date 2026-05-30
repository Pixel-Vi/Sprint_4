package ru.yandex.praktikum.page.tests;

import org.junit.Test;
import ru.yandex.praktikum.page.object.HomePage;
import ru.yandex.praktikum.page.object.OrderStatus;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest extends BaseTest {
    private final String numberOrder = "12345";



    @Test
    public void orderStatusWithoutNumber() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber(numberOrder)
                .clickGo();
        OrderStatus orderStatus = new OrderStatus(driver);
        orderStatus.waitLoadOrderStatusPage();
        assertTrue("Изображение 'Not found' не отображается на странице статуса заказа.", orderStatus.isNotFoundImageDisplayed());
    }
}
