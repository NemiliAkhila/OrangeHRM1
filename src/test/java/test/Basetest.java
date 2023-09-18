package test;
import utilities.QaEnvPropReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import static java.util.concurrent.TimeUnit.SECONDS;
public class Basetest {
    WebDriver driver;
    @BeforeClass
    public void setup() throws IOException {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        String excelFilePath = "C:\\Users\\nemil\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\Project.xlsx";
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String username1 = row.getCell(1).getStringCellValue();
            String password1 = row.getCell(2).getStringCellValue();
            Page page = new Page(driver);
            page.Login(username1,password1 );
        }
    }
    @AfterClass
    public void teardown(){
//        driver.quit();
    }
}
