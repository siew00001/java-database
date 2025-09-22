package View;

import Model.Product;

import java.util.List;
import java.util.Scanner;

public class ListCLI {
    Scanner scanner = new Scanner(System.in);
    public int listMenu(){
        System.out.println("Select desired action:\n" +
                "1. View list \n" +
                "2. Add item to list \n" +
                "3. Remove item from list \n"+
                "0. Close list");
        return getInt();
    }
    public void printProducts(List<Product> products){
        if(products.isEmpty()){
            System.out.println("This list is empty!");
            return;
        }
        System.out.println("\nAll products on the list:");
        products.forEach(System.out::println);
        System.out.println("\n");
    }

    public void closeApplication(){
        System.out.println("Closing list!");
    }

    private int getInt(){
        int userInput;
        try{
            userInput = scanner.nextInt();
            return userInput;
        }catch (Exception e){
            System.out.println("Invalid input!");
            scanner = new Scanner(System.in);
            return -1;
        }
    }

    private float getFloat(){
        float userInput;
        try{
            userInput = scanner.nextFloat();
            return userInput;
        }catch (Exception e){
            System.out.println("Invalid input!");
            scanner = new Scanner(System.in);
            return getFloat();
        }
    }

    public Product createNewProduct(){
        String name;
        float price;
        System.out.println("-----Create new product-----");
        System.out.println("Enter the name of the product:");
        name = scanner.next();
        System.out.println("Enter the price of the product:");
        price = getFloat();
        return new Product(name, price);
    }

    public int removeProduct(){
        System.out.println("Enter the id of the product you want to remove:");
        System.out.println("Enter 0 to return.");
        return getInt();
    }

    public void resultOfRemove(int result){
        if(result == 0){
            System.out.println("There is no element of this id!");
        }else{
            System.out.println("Product was removed!");
        }
    }
}
