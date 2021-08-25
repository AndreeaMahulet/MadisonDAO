package steps.flowsteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import steps.HeaderSteps;
import steps.ProductDetailsSteps;
import steps.ProductsSteps;

public class ProductFlowSteps {
    private static final long serialVersionUID = 1L;
   @Steps
    private HeaderSteps headerSteps;
   @Steps
   private ProductsSteps productsSteps;
   @Steps
   private ProductDetailsSteps productDetailsSteps;

    @Step
    public void addProductToCart(String productName,int quantity){
        headerSteps.searchForProduct(productName);
        productsSteps.openProductsDetailsPage(productName);
        productDetailsSteps.addProductToCart(quantity);
    }
}
