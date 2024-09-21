package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

public class TabBarControl extends Control {

    public TabBarControl(By locator) {
        super(locator);
    }
    //android.widget.HorizontalScrollView[@resource-id="com.solunes.endeapp:id/sliding_tabs"]/android.widget.LinearLayout
    //android.widget.HorizontalScrollView[@resource-id="com.solunes.endeapp:id/sliding_tabs"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]
    //android.widget.HorizontalScrollView[@resource-id="com.solunes.endeapp:id/sliding_tabs"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]
    public void selectTabByIndex(int index) {
        this.findControl();
        String xpathExpression = this.locator.toString() + "/android.support.v7.app.ActionBar.Tab["+index+"]";
        String baseXpath = xpathExpression.replace("By.xpath: ", "");
        By tabLocator = By.xpath(baseXpath);
        WebElement tab = Session.getInstance().getDevice().findElement(tabLocator);
        tab.click();
    }
}