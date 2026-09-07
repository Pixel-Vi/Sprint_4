package ru.yandex.praktikum.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.page.object.constants.CreateOrderButton.DOWN_BUTTON;
import static ru.yandex.praktikum.page.object.constants.CreateOrderButton.UP_BUTTON;

public class HomePage {
    WebDriver driver;

    // Вопросы о важном
    private static final By QUESTION_PRICE = By.id("accordion__heading-0");
    private static final By ANSWER_PRICE = By.id("accordion__panel-0");
    private static final By ITEM_ANSWER_PRICE = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-0']");

    private static final By QUESTION_ONE_SCOOTER = By.id("accordion__heading-1");
    private static final By ANSWER_ONE_SCOOTER = By.id("accordion__panel-1");
    private static final By ITEM_ANSWER_ONE_SCOOTER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-1']");

    private static final By QUESTION_RENTAL_PERIOD = By.id("accordion__heading-2");
    private static final By ANSWER_RENTAL_PERIOD = By.id("accordion__panel-2");
    private static final By ITEM_ANSWER_RENTAL_PERIOD = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-2']");

    private static final By QUESTION_DELIVERY_TIME = By.id("accordion__heading-3");
    private static final By ANSWER_DELIVERY_TIME = By.id("accordion__panel-3");
    private static final By ITEM_ANSWER_DELIVERY_TIME = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-3']");

    private static final By QUESTION_OWNERSHIP = By.id("accordion__heading-4");
    private static final By ANSWER_OWNERSHIP = By.id("accordion__panel-4");
    private static final By ITEM_ANSWER_OWNERSHIP = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-4']");

    private static final By QUESTION_CHARGING = By.id("accordion__heading-5");
    private static final By ANSWER_CHARGING = By.id("accordion__panel-5");
    private static final By ITEM_ANSWER_CHARGING = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-5']");

    private static final By QUESTION_CANCEL_ORDER = By.id("accordion__heading-6");
    private static final By ANSWER_CANCEL_ORDER = By.id("accordion__panel-6");
    private static final By ITEM_ANSWER_CANCEL_ORDER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-6']");

    private static final By QUESTION_COVERAGE_AREA = By.id("accordion__heading-7");
    private static final By ANSWER_COVERAGE_AREA = By.id("accordion__panel-7");
    private static final By ITEM_ANSWER_COVERAGE_AREA = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-7']");

    private final By homeHeader = By.className("Home_Header__iJKdX");
    private final By upOrderButton = By.className("Button_Button__ra12g");
    private final By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By questionsHeader = By.className("Home_FourPart__1uthg");
    private final By orderState = By.xpath(".//button[text()='Статус заказа']");
    private final By numberOrder = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private final By buttonGo = By.xpath(".//button[text()='Go!']");
    private final By yandexButton = By.xpath(".//*[@alt='Yandex']");
    private final By scooterButton = By.xpath(".//*[@alt='Scooter']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания загрузки главной страницы
    public HomePage waitForLoadHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver -> (driver.findElement(homeHeader).getText() != null
                && !driver.findElement(homeHeader).getText().isEmpty()
        ));
        return this;
    }

    //метод ожидания загрузки ответа на вопрос
    public void waitLoadAfterClickQuestion(By accordionLabel) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(accordionLabel).getText() != null
    && !driver.findElement(accordionLabel).getText().isEmpty()
        ));
    }

    //метод прокрутки к блоку "Вопросы о важном"
    public HomePage scrollToQuestions() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsHeader));
        return this;
    }

    //метод прокрутки ко второй кнопке "Заказать"
    public HomePage scrollToDownOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downOrderButton));
        return this;
    }

    public HomePage clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
        return this;
    }

    public HomePage clickDownOrderButton() {
        driver.findElement(downOrderButton).click();
        return this;
    }

    public void clickCreateOrderButton(Enum button) {
        if (button.equals(UP_BUTTON)) {
            clickUpOrderButton();
        } else if (button.equals(DOWN_BUTTON)) {
            scrollToDownOrderButton();
            clickDownOrderButton();
        }
    }

    public HomePage clickQuestion(By question) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(question))
                .click();
        return this;
    }

    public HomePage clickOrderState() {
        driver.findElement(orderState).click();
        return this;
    }

    public HomePage inputOrderNumber(String number) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(numberOrder))
                .sendKeys(number);
        return this;
    }

    public HomePage clickGo() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonGo))
                .click();
        return this;
    }

    public void clickYandexButton() {
        driver.findElement(yandexButton).click();
    }
    public void clickScooterButton() {
        driver.findElement(scooterButton).click();
    }
    // Методы для работы с аккордеоном "Вопросы о важном"
    public HomePage openQuestionPrice() {
        clickQuestion(QUESTION_PRICE);
        waitLoadAfterClickQuestion(ITEM_ANSWER_PRICE);
        return this;
    }

    public String getAnswerTextForPrice() {
        return driver.findElement(ANSWER_PRICE).getText();
    }

    public HomePage openQuestionOneScooter() {
        clickQuestion(QUESTION_ONE_SCOOTER);
        waitLoadAfterClickQuestion(ITEM_ANSWER_ONE_SCOOTER);
        return this;
    }

    public String getAnswerTextForOneScooter() {
        return driver.findElement(ANSWER_ONE_SCOOTER).getText();
    }

    public HomePage openQuestionRentalPeriod() {
        clickQuestion(QUESTION_RENTAL_PERIOD);
        waitLoadAfterClickQuestion(ITEM_ANSWER_RENTAL_PERIOD);
        return this;
    }

    public String getAnswerTextForRentalPeriod() {
        return driver.findElement(ANSWER_RENTAL_PERIOD).getText();
    }

    public HomePage openQuestionDeliveryTime() {
        clickQuestion(QUESTION_DELIVERY_TIME);
        waitLoadAfterClickQuestion(ITEM_ANSWER_DELIVERY_TIME);
        return this;
    }

    public String getAnswerTextForDeliveryTime() {
        return driver.findElement(ANSWER_DELIVERY_TIME).getText();
    }

    public HomePage openQuestionOwnership() {
        clickQuestion(QUESTION_OWNERSHIP);
        waitLoadAfterClickQuestion(ITEM_ANSWER_OWNERSHIP);
        return this;
    }

    public String getAnswerTextForOwnership() {
        return driver.findElement(ANSWER_OWNERSHIP).getText();
    }

    public HomePage openQuestionCharging() {
        clickQuestion(QUESTION_CHARGING);
        waitLoadAfterClickQuestion(ITEM_ANSWER_CHARGING);
        return this;
    }

    public String getAnswerTextForCharging() {
        return driver.findElement(ANSWER_CHARGING).getText();
    }

    public HomePage openQuestionCancelOrder() {
        clickQuestion(QUESTION_CANCEL_ORDER);
        waitLoadAfterClickQuestion(ITEM_ANSWER_CANCEL_ORDER);
        return this;
    }

    public String getAnswerTextForCancelOrder() {
        return driver.findElement(ANSWER_CANCEL_ORDER).getText();
    }

    public HomePage openQuestionCoverageArea() {
        clickQuestion(QUESTION_COVERAGE_AREA);
        waitLoadAfterClickQuestion(ITEM_ANSWER_COVERAGE_AREA);
        return this;
    }

    public String getAnswerTextForCoverageArea() {
        return driver.findElement(ANSWER_COVERAGE_AREA).getText();
    }

    public By getHomeHeader() {
        return homeHeader;
    }
}
