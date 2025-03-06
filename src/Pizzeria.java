import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SliceOHeaven {
    private String ing1;
    private String ing2;
    private String ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String drinks;
    private long cardNumber;
    private String expiryDate;
    private int cvv;
    private long blacklistedNumber = 12345678901234L;

    // 1. Update the takeOrder() method
    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        ing1 = scanner.next();
        ing2 = scanner.next();
        ing3 = scanner.next();

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        pizzaSize = scanner.next();

        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.next();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        sideDish = scanner.next();

        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        drinks = scanner.next();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.next();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }

        scanner.close();
    }

    // 2. Create a new method called isItYourBirthday()
    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthday (YYYY-MM-DD):");
        String birthdateStr = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateStr);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(birthdate, now);
        int age = diff.getYears();

        if (age < 18 && birthdate.getMonth() == now.getMonth() && birthdate.getDayOfMonth() == now.getDayOfMonth()) {
            System.out.println("Congratulations! You pay only half the price for your order");
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
            makeCardPayment();
        }

        scanner.close();
    }

    // 3. Create a method called makeCardPayment()
    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        cardNumber = scanner.nextLong();
        System.out.println("Enter the card’s expiry date (Year - Month):");
        expiryDate = scanner.next();
        System.out.println("Enter the card’s cvv number:");
        cvv = scanner.nextInt();
        processCardPayment(cardNumber, expiryDate, cvv);
        scanner.close();
    }

    // Update the processCardPayment()
    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.length() == 14) {
            if (cardNumber == blacklistedNumber) {
                System.out.println("Card is blacklisted. Please use another card");
                return;
            }
            System.out.println("Card accepted");
            char firstCardDigit = cardNumberStr.charAt(0);
            String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
            StringBuilder cardNumberToDisplay = new StringBuilder();
            cardNumberToDisplay.append(firstCardDigit);
            for (int i = 1; i < cardNumberStr.length() - 4; i++) {
                cardNumberToDisplay.append('*');
            }
            cardNumberToDisplay.append(lastFourDigits);
            System.out.println("Card number to display: " + cardNumberToDisplay);
        } else {
            System.out.println("Invalid card");
        }
    }

    // The method specialOfTheDay() does not change.
    public void specialOfTheDay() {
        System.out.println("The special of the day is a Margherita pizza with a free drink!");
    }

    // 5. Update the method printReceipt()
    public void printReceipt() {
        System.out.println("----- Pizza Order Receipt -----");
        System.out.println("Pizza Ingredients: " + ing1 + ", " + ing2 + ", " + ing3);
        System.out.println("Pizza Size: " + pizzaSize);
        System.out.println("Extra Cheese: " + extraCheese);
        System.out.println("Side Dish: " + sideDish);
        System.out.println("Drinks: " + drinks);
        String cardNumberStr = Long.toString(cardNumber);
        String maskedCard = cardNumberStr.charAt(0) +
                cardNumberStr.substring(1, cardNumberStr.length() - 4).replaceAll(".", "*") +
                cardNumberStr.substring(cardNumberStr.length() - 4);
        System.out.println("Card Number: " + maskedCard);
        System.out.println("Card Expiry Date: " + expiryDate);
        System.out.println("CVV: ***");
        System.out.println("-------------------------------");
    }


    public static void main(String[] args) {
        SliceOHeaven order = new SliceOHeaven();
        order.takeOrder();
        order.printReceipt();
    }
