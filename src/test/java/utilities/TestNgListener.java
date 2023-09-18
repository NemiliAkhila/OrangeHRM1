package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.io.File;
import java.io.IOException;
import static utilities.DriverManager.driver;
public class TestNgListener implements ITestListener {
    public void onTestFailure(ITestResult result) {
        TakesScreenshot srcShot = ((TakesScreenshot)DriverManager.getDriver());
        File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
        String srcShotPath = "C:\\Users\\nemil\\Desktop\\Demo\\screenshot/" + driver.getTitle()+".png";
        File DestFile = new File(srcShotPath);
        try {
            FileUtils.copyFile(SrcFile,DestFile);
            String path = "<img src='"+ DestFile.getAbsolutePath() + "'height'500' width'500'/>";
            Reporter.log(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
