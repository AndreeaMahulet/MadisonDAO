package steps;


import dao.product.ProductAbstractDao;
import dao.product.ProductDao;
import models.Cart;
import models.Product;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.BasePage;
import pages.CartPage;
import tools.constants.SerenityKeyConstants;
import tools.utils.SerenitySessionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Base64;
import java.util.List;

public class CartSteps {
    private static final long serialVersionUID = 1L;
    private CartPage cartPage;
    private BasePage basePage;
    ProductAbstractDao productDao=new ProductDao();
    @Step
    public void verifyCartWithPercentageTaxesDetails(double taxRate) {
        @SuppressWarnings("unchecked")
        Cart expectedCart = new Cart((List<Product>) SerenitySessionUtils.getFromSession(SerenityKeyConstants.CART_PRODUCTS_LIST), taxRate);
        Cart actualCart = cartPage.getCartDetails();
        System.out.println("Expected cart is: " + expectedCart.toString());
        System.out.println("Actual cart is: " + actualCart.toString());
        Assert.assertTrue("Cart details are not as expected!", expectedCart.equals(actualCart));
    }
    @Step
    public void emptyCartIfIsNotAlreadyEmpty() {
        cartPage.emptyCartIfIsNotAlreadyEmpty();
    }

    @Step
    public void emptyCart() {
        cartPage.emptyCart();
    }

    @Step
    public void verifyCartIsEmpty() {
        Assert.assertTrue("Cart is not empty!", basePage.containsText("You have no items in your shopping cart."));
    }

    @Step
    public void updateCartProductQuantity(String productName, int newQuantity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Product product = productDao.getProductByName(SerenityKeyConstants.CART_PRODUCTS_LIST, productName);
        cartPage.updateProductQuantity(productName, newQuantity);
        product.setQty(newQuantity);
        product.setSubtotal(product.getPrice() * newQuantity);
        productDao.updateProduct(SerenityKeyConstants.CART_PRODUCTS_LIST, product);
    }
    @Step
    public void removeCartProduct(String productName) {
        Product product = productDao.getProductByName(SerenityKeyConstants.CART_PRODUCTS_LIST, productName);
        cartPage.removeCartProduct(productName);
        productDao.removeProduct(SerenityKeyConstants.CART_PRODUCTS_LIST, product);
    }
}
