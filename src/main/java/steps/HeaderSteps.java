package steps;

import net.thucydides.core.annotations.Step;
import pages.HeaderPage;

public class HeaderSteps {
    private static final long serialVersionUID = 1L;
    private HeaderPage headerPage;
    @Step
    public void searchForProduct(String productName){
        headerPage.inputSearchTerm(productName);
        headerPage.clickSearchIcon();
    }
}
