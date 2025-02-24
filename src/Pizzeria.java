public class  Pizzeria {
    public String storeAddress;
    private String storeMenu;
    public String storeName;
    public String storeEmail;
    public long storePhone;
    private String orderID;
    private String orderDetails;
    private double orderTotal;

    public void takeOrder(String id, String details, double total){
        orderID = id;
        orderDetails = details;
        orderTotal = total;

        System.out.println("Order accepted!");

        System.out.println("Order is being prepared");

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println("Order is ready for pickup!");
        }

        System.out.println("Your order is ready!");

        printReceipt();


    }

    private void printReceipt(){
        System.out.println("********RECEIPT********");

        System.out.println("Order ID: " + orderID);
        System.out.println("Order Details: " + orderDetails);
        System.out.println("Order Total: " + orderTotal);
    }

    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.storeName = "Slice - o - Heaven";
        pizzeria.storeAddress = "123 Pizza Street";
        pizzeria.storeEmail = "info@sliceoheaven.com";
        pizzeria.storePhone = 1234567890;
        pizzeria.storeMenu = "Pepperoni Pizza, Margherita Pizza";

        String orderId = "001";
        String orderDetails = "One Pepperoni Pizza";
        double orderTotal = 15.99;

        pizzeria.takeOrder(orderId, orderDetails, orderTotal);
    }
}
