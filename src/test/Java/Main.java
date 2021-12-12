public class Main {

    public static void main(String[] args) {

        LoginTest login = new LoginTest();
        WishListTest wishlist = new WishListTest();
        RegisterTest register = new RegisterTest();

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Starting tests...");

        login.loginWithValidCredentials();
        login.loginWithInvalidCredentials();

        wishlist.addToWishlist();

        register.registerNewUser();

    }
}
