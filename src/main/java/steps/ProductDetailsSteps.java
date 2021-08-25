package steps;

import dao.product.ProductAbstractDao;
import dao.product.ProductDao;
import models.Product;
import net.thucydides.core.annotations.Step;
import pages.ProductDetailsPage;
import tools.constants.SerenityKeyConstants;

public class ProductDetailsSteps {
    private static final long serialVersionUID = 1L;
    private ProductDetailsPage productDetailsPage;
    private ProductAbstractDao productDao=new ProductDao();

    public Product getProductDetails(){
        Product product=new Product();
        product.setName(productDetailsPage.getProductName());
        product.setSize(productDetailsPage.getProductRandomSize());
        product.setColor(productDetailsPage.getProductRandomColor());
        product.setPrice(productDetailsPage.getPrice());
        return product;
    }
    @Step
    public void addProductToCart(int quantity) {
        Product product = getProductDetails();
        productDetailsPage.typeInInputWithTitle("Qty", String.valueOf(quantity));
        product.setQty(quantity);
        product.setSubtotal(quantity * product.getPrice());
        productDetailsPage.clickOnWebElementWithText("Add to Cart");
        productDao.saveProduct(SerenityKeyConstants.CART_PRODUCTS_LIST, product);
    }

}
