package View;

import java.util.List;
import java.util.Scanner;

public class ListCLI {
    Scanner scanner = new Scanner(System.in);
    public int listMenu(){
        System.out.println("Select desired action:\n" +
                "1. View list \n" +
                "2. Add item to list \n" +
                "3. Remove item from list");
        return scanner.nextInt();
    }
    public void printProducts(List<String> products){
        products.forEach(System.out::println);
    }
}
