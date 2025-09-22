package Controller;

import Model.DBAccess;
import Model.Product;
import View.ListCLI;

public class ListLogic {
    ListCLI cli = new ListCLI();
    DBAccess database = new DBAccess();
    public void openList(){
        int userChoice = cli.listMenu();
        switch (userChoice){
            case 1:
                cli.printProducts(database.getAllProducts());
                break;
            case 2:
                database.addProductToDB(cli.createNewProduct());
                break;
            case 3:
                int id = cli.removeProduct();
                if(id == 0){
                    break;
                }
                cli.resultOfRemove(database.removeProductFromDBByID(id));
                break;
            case 0:
                cli.closeApplication();
                return;
        }
        openList();
    }
}
