package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

public class TabBarControl extends Control {

    public TabBarControl(By locator) {
        super(locator);
    }

    public void selectTabByIndex(int index) {
        this.findControl();
        String xpathExpression = this.locator.toString() + "/android.widget.LinearLayout[" + index + "]/android.widget.RelativeLayout";
        String baseXpath = xpathExpression.replace("By.xpath: ", "");
        By tabLocator = By.xpath(baseXpath);
        WebElement tab = Session.getInstance().getDevice().findElement(tabLocator);
        tab.click();
    }
}