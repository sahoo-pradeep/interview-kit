package kit.interview.design_patterns.design_principles;

import java.util.Arrays;
import java.util.List;

// Encapsulate what varies : Identify the aspects of your application that vary and separate them
// from what stays the same
public class P1EncapsulateWhatVaries {
    public static void main(String[] args) {
        Order order = new Order();
        List<Item> items = Arrays.asList(new Item(10, 1), new Item(20, 2));
        order.items = items;
        order.country = "IN";

        int totalOld = getOrderTotalOld(order);
        int totalNew = getOrderTotalNew(order);

        System.out.println("totalOld " + totalOld);
        System.out.println("totalNew " + totalNew);
    }

    public static int getOrderTotalOld(Order order) {
        int total = 0;
        for (Item item : order.items) {
            total += item.price * item.quantity;
        }

        // This code changes frequently based on tax system
        if (order.country.equals("IN")) {
            total += total * 0.18;
        } else if (order.country.equals("US")) {
            total += total * 0.30;
        }

        return total;
    }

    public static int getOrderTotalNew(Order order) {
        int total = 0;
        for (Item item : order.items) {
            total += item.price * item.quantity;
        }

        total += getTax(total, order.country);

        return total;
    }

    // Moved to separate method
    public static int getTax(int total, String country) {
        int tax = 0;

        if (country.equals("IN")) {
            tax = (int) (total * 0.18);
        } else if (country.equals("US")) {
            tax = (int) (total * 0.30);
        }

        return tax;
    }


    private static class Order {
        List<Item> items;
        String country;
    }


    private static class Item {
        int price;
        int quantity;

        public Item(int price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }
}
