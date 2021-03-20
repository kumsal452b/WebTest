package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button basla;

    @FXML
    private Button dur;

    @FXML
    private ListView<String> list;

    @FXML
    private TextField urlgir;

    @FXML
    private ProgressBar progress;

    @FXML
    private TableView<modelList> table;

    @FXML
    private TableColumn<modelList, String> sira;

    @FXML
    private TableColumn<modelList, String> uadi;

    @FXML
    private TableColumn<modelList, String> ilkfiyat;

    @FXML
    private TableColumn<modelList, String> sonfiyat;

    @FXML
    private TableColumn<modelList, ?> url;

    @FXML
    void basla(ActionEvent event) {
        if (urlgir.getText()!=null || urlgir.getText()!=""){

        }

    }

    @FXML
    void dur(ActionEvent event) {

    }

    @FXML
    void initialize() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/keski/Desktop/chromedriver.exe");
    }
    public static double parseDouble2(String aString) {

        aString = aString.toLowerCase().trim();
        aString = aString.replace('.', ' ');
        aString = aString.replaceAll("\\s+", "");
        aString = aString.replace(',', '.');
        StringBuilder builder = new StringBuilder(aString);
        builder.delete(aString.length() - 2, aString.length());
        double v = Double.parseDouble(builder.toString());
        return v;
    }
    static public List<String> checkLinkEnd(List<String> Recvdata){
        int num1=0;
        int num2=0;
        String currentUrl="";
        String beforeUrl="";

        boolean isChange=true;
        ArrayList<String> tempData=new ArrayList<>();
        for(int i=0;i<Recvdata.size(); i++){
            String data =Recvdata.get(i);
            if (!data.contains("pg=")) {
                data+="&pg=1";
            }
            if (isChange) {
                String teString2=String.valueOf(StringUtils.indexOf(data, "pg="));
                String number1=data.substring(Integer.parseInt(teString2)+3, data.length());
                num1=Integer.parseInt(number1);
                isChange=false;
                beforeUrl=data;
                if (num2!=0) {
                    if (num2+1==num1) {
                        if (!tempData.contains(beforeUrl)) {
                            tempData.add(beforeUrl);
                        }
                        if (!tempData.contains(currentUrl)) {
                            tempData.add(currentUrl);
                        }
                    }
                }
            }else{

                String teString2=String.valueOf(StringUtils.indexOf(data, "pg="));
                String number1=data.substring(Integer.parseInt(teString2)+3, data.length());
                num2=Integer.parseInt(number1);
                isChange=true;
                currentUrl=data;
                if (num1+1==num2){
                    if (!tempData.contains(beforeUrl)) {
                        tempData.add(beforeUrl);
                    }
                    if (!tempData.contains(currentUrl)) {
                        tempData.add(currentUrl);
                    }
                }
            }

        }
        return tempData;
    }
    static public String extractDataWithSelenium(String url) throws InterruptedException {
        int pageNumber = 1;
        int mCount = 1;
        int count = 0;
        int topLevelIndex=3;
        int currentPageIndex=1;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get(url);

        WebElement containerlinks = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'pagination')]")));
        List<WebElement> clickedEleement = containerlinks.findElements(By.tagName(("a")));

        List<String> linkElement = new ArrayList<>();
        int countEn=0;

        for (WebElement ele : clickedEleement) {
            linkElement.add(ele.getAttribute("href"));
            countEn++;
            if (countEn==4) {
                break;
            }
        }
        //

        List<WebElement> oldPrice = new ArrayList<WebElement>();
        List<WebElement> newPrice = new ArrayList<WebElement>();
        List<String> newPrice2 = new ArrayList<String>();
        List<String> newlinks = new ArrayList<String>();
        List<model_data> allStuff = new ArrayList<model_data>();

//		if (linkElement.size()>11) {
//			String temp = linkElement.get(11);
//			linkElement.add(10, temp);
//		}
        List<String> allList=new ArrayList<>();
        allList.addAll(checkLinkEnd(linkElement));
        for (int i = 0; i < allList.size(); i++) {

            driver.get(allList.get(i));
            WebElement container = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'clearfix')]")));
            oldPrice = container.findElements(By.xpath("//a[contains(@class,'oldPrice')]"));
            newPrice = container.findElements(By.xpath("//a[contains(@class,'newPrice')]"));
            for (WebElement ele : newPrice) {
                newPrice2.add(ele.getText());
                newlinks.add(ele.getAttribute("href"));
            }
            for (WebElement ele : oldPrice) {
                String currentUrl = ele.getAttribute("href");
                if (newlinks.contains(currentUrl)) {
                    int index = newlinks.indexOf(ele.getAttribute("href"));
                    model_data data = new model_data();
                    String oldC = "";
                    // System.out.println(newPrice2.get(index)+"
                    // "+ele.getText());
                    data = new model_data(ele.getAttribute("title"), ele.getAttribute("href"),
                            parseDouble2(newPrice2.get(index)), parseDouble2(ele.getText()));
                    allStuff.add(data);
                }
            }

            if (currentPageIndex==45) {
                System.out.println("test");
            }

            if (i == topLevelIndex) {

                WebElement containerlinks2 = wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'pagination')]")));
                List<WebElement> clickedEleement2 = containerlinks2.findElements(By.tagName(("a")));
                allList.clear();
                for (WebElement ele : clickedEleement2) {
                    allList.add(ele.getAttribute("href"));
                }
                List<String> tempList=new ArrayList<>();
                tempList.addAll(checkLinkEnd(allList));
                allList.clear();
                int countFourElement=0;
                for(String link:tempList){
                    String teString2=String.valueOf(StringUtils.indexOf(link, "pg="));
                    String number1=link.substring(Integer.parseInt(teString2)+3, link.length());
                    int num=Integer.parseInt(number1);
                    if (num>currentPageIndex) {
                        allList.add(link);
                        countFourElement++;
                        if (countFourElement==4) {
                            break;
                        }
                    }
                }
                tempList.clear();
                topLevelIndex=allList.size()-1;
                i=-1;
            }
            currentPageIndex++;
            System.out.println(currentPageIndex);

        }

        if (allStuff.size() > 0) {
            for (model_data ele : allStuff) {
                System.out.println(count + " " + ele.getNewValue() + " " + ele.getOldValue());
                count++;
            }
        }
        return "";
    }

}
