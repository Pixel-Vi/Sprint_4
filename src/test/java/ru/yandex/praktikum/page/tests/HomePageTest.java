package ru.yandex.praktikum.page.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page.object.HomePage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class HomePageTest extends BaseTest {
    private final int questionIndex;
    private final String expected;

    public HomePageTest(int questionIndex, String expected) {
        this.questionIndex = questionIndex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Проверка вопроса {0}")
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        });
    }

    @Test
    public void checkQuestionsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions();

        switch (questionIndex) {
            case 0:
                homePage.openQuestionPrice();
                assertEquals(expected, homePage.getAnswerTextForPrice());
                break;
            case 1:
                homePage.openQuestionOneScooter();
                assertEquals(expected, homePage.getAnswerTextForOneScooter());
                break;
            case 2:
                homePage.openQuestionRentalPeriod();
                assertEquals(expected, homePage.getAnswerTextForRentalPeriod());
                break;
            case 3:
                homePage.openQuestionDeliveryTime();
                assertEquals(expected, homePage.getAnswerTextForDeliveryTime());
                break;
            case 4:
                homePage.openQuestionOwnership();
                assertEquals(expected, homePage.getAnswerTextForOwnership());
                break;
            case 5:
                homePage.openQuestionCharging();
                assertEquals(expected, homePage.getAnswerTextForCharging());
                break;
            case 6:
                homePage.openQuestionCancelOrder();
                assertEquals(expected, homePage.getAnswerTextForCancelOrder());
                break;
            case 7:
                homePage.openQuestionCoverageArea();
                assertEquals(expected, homePage.getAnswerTextForCoverageArea());
                break;
            default:
                throw new IllegalArgumentException("Неверный индекс вопроса: " + questionIndex);
        }
    }

    @Test
    public void checkQuestionOneScooterTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionOneScooter();
        String result = homePage.getAnswerTextForOneScooter();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", result);
    }

    @Test
    public void checkQuestionRentalPeriodTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionRentalPeriod();
        String result = homePage.getAnswerTextForRentalPeriod();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", result);
    }

    @Test
    public void checkQuestionDeliveryTimeTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionDeliveryTime();
        String result = homePage.getAnswerTextForDeliveryTime();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", result);
    }

    @Test
    public void checkQuestionOwnershipTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionOwnership();
        String result = homePage.getAnswerTextForOwnership();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", result);
    }

    @Test
    public void checkQuestionChargingTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionCharging();
        String result = homePage.getAnswerTextForCharging();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", result);
    }

    @Test
    public void checkQuestionCancelOrderTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionCancelOrder();
        String result = homePage.getAnswerTextForCancelOrder();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", result);
    }

    @Test
    public void checkQuestionCoverageAreaTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .openQuestionCoverageArea();
        String result = homePage.getAnswerTextForCoverageArea();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", result);
    }
}