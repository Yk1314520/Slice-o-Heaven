public class Pizzeria {
    private String storeAddress;
    private String storeMenu;
    private String storeName;
    private String storeEmail;
    private long storePhone;
    private String orderID;
    private String pizzaIngredients;
    private double orderTotal;
    private String sides;
    private String drinks;

    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;

    // Default constructor
    public Pizzeria() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    // Parameterized constructor
    public Pizzeria(String orderID, String pizzaIngredients, double orderTotal, String sides, String drinks) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.sides = sides;
        this.drinks = drinks;
    }

    // Getters and Setters for private variables
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreMenu() {
        return storeMenu;
    }

    public void setStoreMenu(String storeMenu) {
        this.storeMenu = storeMenu;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public long getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(long storePhone) {
        this.storePhone = storePhone;
    }

    public void takeOrder(String id, String ingredients, double total, String sides, String drinks) {
        setOrderID(id);
        setPizzaIngredients(ingredients);
        setOrderTotal(total);
        setSides(sides);
        setDrinks(drinks);

        System.out.println("Order accepted!");
        System.out.println("Order is being prepared");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Order preparation was interrupted.");
            return;
        }

        System.out.println("Your order is ready!");
        printReceipt();
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
        System.out.println("Sides: " + sides);
        System.out.println("Drinks: " + drinks);
    }

    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.setStoreName("Slice - o - Heaven");
        pizzeria.setStoreAddress("123 Pizza Street");
        pizzeria.setStoreEmail("info@sliceoheaven.com");
        pizzeria.setStorePhone(1234567890);
        pizzeria.setStoreMenu("Pepperoni Pizza, Margherita Pizza");

        String orderId = "001";
        String pizzaIngredients = "Pepperoni, Mushrooms";
        double orderTotal = 20.00;
        String sides = "Garlic Bread";
        String drinks = "Coke";

        pizzeria.takeOrder(orderId, pizzaIngredients, orderTotal, sides, drinks);
    }
}
