import amazon.HomePage;
import commun.SetupTeardown;
import org.testng.annotations.Test;
public class TpPageObjectTest extends SetupTeardown {

    final String expectedCapacity  = "256Go";
    final String keyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    final int searchResultIndex = 0;
    final int quantity = 2;
    @Test
    public void testPO() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie()
                .searchWithButton(keyword)
                .openSearchResult(searchResultIndex)
                .addToCart()
                .refuseApplecare()
                .openCart()
                .selectQuantity(quantity);

        // Assert.assertEquals(cartPage.getSubTotal(), "1000");
    }
}
