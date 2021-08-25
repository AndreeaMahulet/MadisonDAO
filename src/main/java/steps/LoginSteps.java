package steps;

import dao.registration.UserAbstractDao;
import dao.registration.UserDao;
import models.User;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.HeaderPage;
import pages.LoginPage;
import tools.constants.MessageConstants;

public class LoginSteps {
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private UserAbstractDao userDao = new UserDao();
    @Step
    public void goToLogin(){
        headerPage.clickOnAccount();
        headerPage.clickOnALinkFromAccount("Log In");
        Assert.assertTrue(loginPage.getLoginMsg().equalsIgnoreCase(MessageConstants.loginMsg));
    }

    @Step
    public void loginUser(User user){
        System.out.println(user);
        loginPage.fillUserDetailsLogin(user);
        loginPage.clickOnLoginBtn();
        Assert.assertEquals(loginPage.getLoggedInMsg(), MessageConstants.loggedInMsg);
        userDao.saveLoggedInUser(user);

    }

}
