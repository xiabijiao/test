import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class SelemiumTest {
        private WebDriver driver;
        @Before
        public void setUp() throws Exception {
            // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
            System.setProperty("webdriver.firefox.bin", "D:\\360downloads\\firefox.exe");
            System.setProperty("webdriver.gecko.driver", "D:\\idea-2018\\geckodriver.exe");
            // 创建一个 FireFox 的浏览器实例
             driver = new FirefoxDriver();
            // 让浏览器访问 Baidu
            driver.get("http://www.baidu.com");

            // 获取 网页的 title
            System.out.println("Home Page title is: " + driver.getTitle());

            // 通过 id 找到 input 的 DOM
            WebElement element = driver.findElement(By.id("kw"));

            // 输入关键字
            element.sendKeys("Selemium");

            // 提交 input 所在的  form
            element.submit();

            // Timeout 设置5秒
           Thread.sleep(5000);

            // 获取 网页的 title
            System.out.println("Find Page title is: " + driver.getTitle());

            //清空搜索框
            element.clear();
        }
        @Test
        public void testFireFox()throws Exception{


            // 通过 Css选择器 找到 input 的 DOM
            WebElement element1 = driver.findElement(By.cssSelector("#kw"));

            // 输入关键字
            element1.sendKeys("Jnuit");

            // 提交 input 所在的  form
            element1.submit();

            //Timeout 设置5秒
            Thread.sleep(5000);

            // 获取 网页的 title
            System.out.println("Find Page title is: " + driver.getTitle());

            // 通过 css选择器找到 “网页” 的 DOM
            WebElement element2= driver.findElement(By.cssSelector(".s_tab_inner > b:nth-child(1)"));

            //判断元素内容
            String expect=element2.getText();
            String actual="网页";
            assertEquals(expect, actual);

            //Timeout 设置10秒
            Thread.sleep(10000);
            
            //关闭浏览器
//           driver.quit();
        }
        @After
        public void fin(){

        }
}
