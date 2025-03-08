import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SliceoHeaven {
    // Blacklisted card number
    public static final String BLACKLISTED_NUMBER = "12345678901234";

    private String ing1, ing2, ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String drinks;
    private boolean halfPay;
    private LocalDate birthday;
    private String cardNumber;
    private LocalDate cardExpiry;

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean validIngredients = false;
        while (!validIngredients) {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun - dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.print("Enter any three choices (1, 2, 3,…) separated by spaces:");
            int ingChoice1 = scanner.nextInt();
            int ingChoice2 = scanner.nextInt();
            int ingChoice3 = scanner.nextInt();

            if (isValidChoice(ingChoice1) && isValidChoice(ingChoice2) && isValidChoice(ingChoice3)) {
                ing1 = getIngredientName(ingChoice1);
                ing2 = getIngredientName(ingChoice2);
                ing3 = getIngredientName(ingChoice3);
                validIngredients = true;
            } else {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
            }
        }

        boolean validSize = false;
        while (!validSize) {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.print("Enter only one choice (1, 2, or 3):");
            int sizeChoice = scanner.nextInt();
            if (sizeChoice >= 1 && sizeChoice <= 3) {
                pizzaSize = getPizzaSize(sizeChoice);
                validSize = true;
            } else {
                System.out.println("Invalid choice. Please pick a valid size:");
            }
        }

        System.out.print("Do you want extra cheese (Y/N):");
        extraCheese = scanner.next();

        boolean validSideDish = false;
        while (!validSideDish) {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.print("What would you like? Pick one (1, 2, 3,…):");
            int sideDishChoice = scanner.nextInt();
            if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                sideDish = getSideDish(sideDishChoice);
                validSideDish = true;
            } else {
                System.out.println("Invalid choice. Please pick a valid side - dish:");
            }
        }

        boolean validDrink = false;
        while (!validDrink) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.print("Enter your choice:");
            int drinkChoice = scanner.nextInt();
            if (drinkChoice >= 1 && drinkChoice <= 4) {
                drinks = getDrink(drinkChoice);
                validDrink = true;
            } else {
                System.out.println("Invalid choice. Please pick a valid drink:");
            }
        }

        System.out.print("Would you like the chance to pay only half for your order? (Y/N):");
        halfPay = scanner.next().equalsIgnoreCase("Y");
    }

    private boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 5;
    }

    private String getIngredientName(int choice) {
        switch (choice) {
            case 1:
                return "Mushroom";
            case 2:
                return "Paprika";
            case 3:
                return "Sun - dried tomatoes";
            case 4:
                return "Chicken";
            case 5:
                return "Pineapple";
            default:
                return "";
        }
    }

    private String getPizzaSize(int choice) {
        switch (choice) {
            case 1:
                return "Large";
            case 2:
                return "Medium";
            case 3:
                return "Small";
            default:
                return "";
        }
    }

    private String getSideDish(int choice) {
        switch (choice) {
            case 1:
                return "Calzone";
            case 2:
                return "Garlic bread";
            case 3:
                return "Chicken puff";
            case 4:
                return "Muffin";
            case 5:
                return "Nothing for me";
            default:
                return "";
        }
    }

    private String getDrink(int choice) {
        switch (choice) {
            case 1:
                return "Coca Cola";
            case 2:
                return "Cold coffee";
            case 3:
                return "Cocoa Drink";
            case 4:
                return "No drinks for me";
            default:
                return "";
        }
    }

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Is it your birthday today? Enter your birth date (YYYY - MM - DD):");
            String dateStr = scanner.next();
            birthday = LocalDate.parse(dateStr);
            long years = ChronoUnit.YEARS.between(birthday, LocalDate.now());
            if (years < 5 || years > 120) {
                System.out.println("Invalid date. You are either too young or too dead to order.");
                System.out.println("Please enter a valid date:");
            } else {
                validDate = true;
            }
        }
    }

    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        boolean validExpiry = false;
        while (!validExpiry) {
            System.out.print("Enter the expiry date of your card (YYYY - MM - DD):");
            String expiryStr = scanner.next();
            cardExpiry = LocalDate.parse(expiryStr);
            if (cardExpiry.isBefore(LocalDate.now())) {
                System.out.println("Invalid date. The card has expired. Please enter a future date.");
            } else {
                validExpiry = true;
            }
        }
    }

    public void processCardPayment() {
        Scanner scanner = new Scanner(System.in);
        boolean validCard = false;
        while (!validCard) {
            System.out.print("Enter your 14 - digit card number:");
            cardNumber = scanner.next();
            if (cardNumber.length() == 14 &&!cardNumber.equals(BLACKLISTED_NUMBER)) {
                validCard = true;
            } else {
                System.out.println("Invalid card number. Please enter a 14 - digit number not on the blacklist.");
            }
        }
    }

    public String specialOfTheDay() {
        return "Today's special is a free dessert with a large pizza order!";
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Pizza Ingredients: ").append(ing1).append(", ").append(ing2).append(", ").append(ing3).append("\n");
        receipt.append("Pizza Size: ").append(pizzaSize).append("\n");
        receipt.append("Extra Cheese: ").append(extraCheese).append("\n");
        receipt.append("Side Dish: ").append(sideDish).append("\n");
        receipt.append("Drink: ").append(drinks).append("\n");
        receipt.append("Half - Pay Option: ").append(halfPay? "Yes" : "No").append("\n");
        receipt.append("Birthday: ").append(birthday).append("\n");
        receipt.append("Card Number: ").append(cardNumber).append("\n");
        receipt.append("Card Expiry: ").append(cardExpiry).append("\n");
        receipt.append(specialOfTheDay());
        return receipt.toString();
    }

    public static void main(String[] args) {
        SliceoHeaven order = new SliceoHeaven();
        order.takeOrder();
        order.isItYourBirthday();
        order.makeCardPayment();
        order.processCardPayment();
        System.out.println(order);
    }
}
