package test;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
public class OrangeHRM extends Basetest {
    @Test
    public void CreateOrganiationName() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\nemil\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String OrganizationName = row.getCell(1).getStringCellValue();
            Page page = new Page(driver);
            page.Admin.click();
            page.Organisation.click();
            page.GeneralOrganisation.click();
            page.Edit.click();
            page.OrganisationName.click();
            page.OrganisationName.sendKeys(Keys.CONTROL + "a");
            page.OrganisationName.sendKeys(Keys.DELETE);
            page.OrganisationName.sendKeys(OrganizationName);
            page.Save.click();
            boolean displayed = page.VerifySave.isDisplayed();
            Assert.assertEquals(displayed, true);
        }
    }
    @Test
    public void CreateOrganiationNameReq() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.Admin.click();
        page.Organisation.click();
        page.GeneralOrganisation.click();
        page.Edit.click();
        page.OrganisationName.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        page.Save.click();
        boolean displayed = page.VerifyBlankSave.isDisplayed();
        Assert.assertEquals(displayed, true);
    }
    @Test
    public void SearchLocation() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\nemil\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(2);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String locationName = row.getCell(1).getStringCellValue();
            String locationCity = row.getCell(2).getStringCellValue();
            Page page = new Page(driver);
            page.Admin.click();
            page.Organisation.click();
            page.SelectLocation.click();
            page.LocationName.sendKeys(locationName);
            page.LocationCity.sendKeys(locationCity);
            page.LocationCountry.click();
            page.LocationCountrySelect.click();
            page.LocationSearch.click();
        }
    }
    @Test
    public void Locationdatareset() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\nemil\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(2);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String locationName = row.getCell(1).getStringCellValue();
            String locationCity = row.getCell(2).getStringCellValue();
            Page page = new Page(driver);
            page.Admin.click();
            page.Organisation.click();
            page.SelectLocation.click();
            page.LocationName.sendKeys(locationName);
            page.LocationCity.sendKeys(locationCity);
            page.LocationCountry.click();
            page.LocationCountrySelect.click();
            page.LocationSearch.click();
            WebElement new3 = page.LocationName;
            String firstlocation = new3.getAttribute("value");
            page.LocationDataReset.click();
            WebElement new2 = page.LocationName;
            String resetlocation = new2.getAttribute("value");
            Assert.assertNotEquals(resetlocation, firstlocation);
        }
    }
    @Test
    public void CreateLocation() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\nemil\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(2);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String locationName = row.getCell(3).getStringCellValue();
            Page page = new Page(driver);
            page.Admin.click();
            page.Organisation.click();
            page.SelectLocation.click();
            page.LocationAdd.click();
            page.LocationAddName.sendKeys(locationName);
            page.LocationAddCountryDropdown.click();
            page.LocationAddCountrySelect.click();
            page.LocationAddSave.click();
        }
    }
    @Test
    public void RequireFieldTest() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\nemil\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(2);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String locationName = row.getCell(3).getStringCellValue();
            Page page = new Page(driver);
            page.Admin.click();
            page.Organisation.click();
            page.SelectLocation.click();
            page.LocationAdd.click();
            page.LocationAddName.sendKeys(locationName);
            page.LocationAddSave.click();
            WebElement new1 = page.LocationCountryMiss;
            String newlocation = new1.getText();
            Assert.assertEquals(newlocation, "Required", "Text should match");

        }
    }
    @Test
    public void DeleteLocation() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.Admin.click();
        page.Organisation.click();
        page.SelectLocation.click();
        page.LocationDeleteSelect.click();
        page.LocationDeleteClick.click();
        page.LocationDeleteYes.click();
        boolean display = page.VerifyLocationDeleted.isDisplayed();
        Assert.assertEquals(display, true);
    }
    @Test
    public void SearchStructure() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\nemil\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(3);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String structureName = row.getCell(1).getStringCellValue();
            Page page = new Page(driver);
            page.Admin.click();
            page.Organisation.click();
            page.SelectStructure.click();
            page.StructureEditEnable.click();
            page.StructureAddFunctionality.click();
            Thread.sleep(2000);
            page.StructureSaveFunctionality.click();
            page.StructureSaveButtonFunctionality.click();
            boolean display = page.StructureSaveVerifyFunctionality.isDisplayed();
            Assert.assertEquals(display, true);
        }
    }
    @Test
    public void EditFunctionalityVerify() throws InterruptedException {
        Page page = new Page(driver);
        page.Admin.click();
        page.Organisation.click();
        page.GeneralOrganisation.click();
        boolean enalbled = page.EditFunctionalityVerify.isEnabled();
        Assert.assertEquals(enalbled,false);
    }
    @Test
    public void SaveButtonHiddenVerify() throws InterruptedException {
        Page page = new Page(driver);
        page.Admin.click();
        page.Organisation.click();
        page.GeneralOrganisation.click();
        WebElement element = page.Save;
        Assert.assertNotNull(element, "Element is not present");
    }
    @Test
    public void DefaultEnableWhileEditDisable() throws InterruptedException {
        Page page = new Page(driver);
        page.Admin.click();
        page.Organisation.click();
        page.GeneralOrganisation.click();
        boolean enalbled = page.DefaultEnableWhileEditDisable.isEnabled();
        Assert.assertEquals(enalbled,true);
    }
    @Test
    public void SelectAllFunctionality() throws InterruptedException {
        Page page = new Page(driver);
        page.Admin.click();
        page.Organisation.click();
        page.SelectLocation.click();
        page.LocationSelectAllFunctionality.click();
        boolean Displayed = page.VerifySelectAll.isDisplayed();
        Assert.assertEquals(Displayed,true);
    }
    @Test
    public void SelectAllDeleteLocation() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.Admin.click();
        page.Organisation.click();
        page.SelectLocation.click();
        page.LocationSelectAllFunctionality.click();
        page.LocationDeleteClick.click();
        page.LocationDeleteYes.click();
        boolean display = page.VerifyLocationDeleted.isDisplayed();
        Assert.assertEquals(display, true);
    }
}


