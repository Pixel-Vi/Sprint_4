package ru.yandex.praktikum.page.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page.object.HomePage;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class HomePageTest extends BaseTest {
    private final String expected;

    public HomePageTest(String expected) {
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Проверка ответа: {0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }



    @Test
    public void checkQuestionsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions();
        // Проверка для каждого вопроса
        if (expected.equals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.")) {
            homePage.openQuestionPrice();
            String result = homePage.getAnswerTextForPrice();
            assertEquals(expected, result);
        } else if (expected.equals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.")) {
            homePage.openQuestionOneScooter();
            String result = homePage.getAnswerTextForOneScooter();
            assertEquals(expected, result);
        } else if (expected.equals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.")) {
            homePage.openQuestionRentalPeriod();
            String result = homePage.getAnswerTextForRentalPeriod();
            assertEquals(expected, result);
        } else if (expected.equals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.")) {
            homePage.openQuestionDeliveryTime();
            String result = homePage.getAnswerTextForDeliveryTime();
            assertEquals(expected, result);
        } else if (expected.equals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.")) {
            homePage.openQuestionOwnership();
            String result = homePage.getAnswerTextForOwnership();
            assertEquals(expected, result);
        } else if (expected.equals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.")) {
            homePage.openQuestionCharging();
            String result = homePage.getAnswerTextForCharging();
            assertEquals(expected, result);
        } else if (expected.equals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.")) {
            homePage.openQuestionCancelOrder();
            String result = homePage.getAnswerTextForCancelOrder();
            assertEquals(expected, result);
        } else if (expected.equals("Да, обязательно. Всем самокатов! И Москве, и Московской области.")) {
            homePage.openQuestionCoverageArea();
            String result = homePage.getAnswerTextForCoverageArea();
            assertEquals(expected, result);
        }
    }
}