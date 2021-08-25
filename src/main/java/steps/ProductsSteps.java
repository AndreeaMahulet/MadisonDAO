package steps;

import net.thucydides.core.annotations.Step;
import pages.ProductsPage;

public class ProductsSteps {
    private static final long serialVersionUID = 1L;
    private ProductsPage productsPage;

    @Step
    public void openProductsDetailsPage(String productName){
        productsPage.openProductDetailsPage(productName);
    }
}
