package ru.yandex.praktikum.page.tests;

import org.junit.Test;
import ru.yandex.praktikum.page.object.HomePage;

import static org.junit.Assert.assertEquals;


public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @Test
    public void checkQuestionPriceTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionPrice();
        String result = homePage.getAnswerTextForPrice();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", result);
    }

    @Test
    public void checkQuestionOneScooterTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionOneScooter();
        String result = homePage.getAnswerTextForOneScooter();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", result);
    }

    @Test
    public void checkQuestionRentalPeriodTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionRentalPeriod();
        String result = homePage.getAnswerTextForRentalPeriod();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", result);
    }

    @Test
    public void checkQuestionDeliveryTimeTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionDeliveryTime();
        String result = homePage.getAnswerTextForDeliveryTime();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", result);
    }

    @Test
    public void checkQuestionOwnershipTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionOwnership();
        String result = homePage.getAnswerTextForOwnership();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", result);
    }

    @Test
    public void checkQuestionChargingTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionCharging();
        String result = homePage.getAnswerTextForCharging();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", result);
    }

    @Test
    public void checkQuestionCancelOrderTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionCancelOrder();
        String result = homePage.getAnswerTextForCancelOrder();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", result);
    }

    @Test
    public void checkQuestionCoverageAreaTest() {
        homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionCoverageArea();
        String result = homePage.getAnswerTextForCoverageArea();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", result);
    }
}