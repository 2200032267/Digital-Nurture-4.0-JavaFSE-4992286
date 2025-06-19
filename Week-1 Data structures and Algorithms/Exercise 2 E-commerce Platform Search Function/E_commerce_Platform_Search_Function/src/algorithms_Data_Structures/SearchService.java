package algorithms_Data_Structures;

import java.util.Arrays;

public class SearchService {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; 
            }
        }
        return null; 
    }

    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; 
            Product midProduct = sortedProducts[mid];

            if (midProduct.getProductId() == targetId) {
                return midProduct; 
            } else if (midProduct.getProductId() < targetId) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(203, "Keyboard", "Electronics"),
            new Product(301, "Coffee Mug", "Kitchenware"),
            new Product(450, "Running Shoes", "Apparel"),
            new Product(112, "Mouse", "Electronics"),
            new Product(500, "T-shirt", "Apparel")
        };

        System.out.println("--- Linear Search ---");
        System.out.println("\nSearching for product ID 450...");
        Product foundProductLinear = linearSearch(products, 450);
        System.out.println("Result: " + foundProductLinear); 

        System.out.println("\nSearching for product ID 999...");
        foundProductLinear = linearSearch(products, 999);
        System.out.println("Result: " + foundProductLinear);

        System.out.println("\n--- Binary Search ---");
       
        Arrays.sort(products); 
        
        System.out.println("\nSorted products for binary search:");
        for(Product p : products) {
            System.out.println("  - " + p);
        }

        System.out.println("\nSearching for product ID 112...");
        Product foundProductBinary = binarySearch(products, 112);
        System.out.println("Result: " + foundProductBinary); 

        System.out.println("\nSearching for product ID 301...");
        foundProductBinary = binarySearch(products, 301);
        System.out.println("Result: " + foundProductBinary);
    }
}
