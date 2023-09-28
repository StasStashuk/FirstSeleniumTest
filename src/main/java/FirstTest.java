import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class FirstTest {
    String Payments_URL = "https://next.privat24.ua/payments/dashboard";

    @Test
    public void CheckMinPaymentSum() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.get(Payments_URL);
        driver.findElement(By.xpath("//input[@data-qa-node='query']")).sendKeys("UA333510050000026005325079000");
        driver.findElement(By.xpath("//button[contains(text(), 'За реквізитами')]")).click();
        driver.findElement(By.xpath("//textarea[@data-qa-node='FIO']")).sendKeys("Test");
        driver.findElement(By.xpath("//textarea[@data-qa-node='CUSTOM_COMPANY']")).sendKeys("Test");
        driver.findElement(By.xpath("//textarea[@data-qa-node='CUSTOM_OKPO']")).sendKeys("12345678");
        driver.findElement(By.xpath("//textarea[@data-qa-node='DEST']")).sendKeys("комунальні послуги");
        driver.findElement(By.xpath("//input[@data-qa-node='SUM']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@data-qa-node='numberdebitSource']")).sendKeys("5309233034765085");
        driver.findElement(By.xpath("//input[@data-qa-node='expiredebitSource']")).sendKeys("0124");
        driver.findElement(By.xpath("//input[@data-qa-node='cvvdebitSource']")).sendKeys("891");
        driver.findElement(By.xpath("//input[@data-qa-node='firstNamedebitSource']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@data-qa-node='lastNamedebitSource']")).sendKeys("Test");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Додати в кошик')]")).click();

        Assert.assertEquals("Сплата за комунальні послуги", driver.findElement(By.xpath("//div[@data-qa-node='details']")).getText());
        Assert.assertEquals("5309 **** **** 5085", driver.findElement(By.xpath("//td[@data-qa-node='card']")).getText());
        Assert.assertEquals("1 UAH", driver.findElement(By.xpath("//div[@data-qa-node='amount']")).getText());
        Assert.assertEquals("3", driver.findElement(By.xpath("//span[@data-qa-node='commission']")).getText());


    }
}
