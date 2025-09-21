package Controller;

import Model.DBAccess;
import View.ListCLI;

public class ListLogic {
    ListCLI cli = new ListCLI();
    DBAccess database = new DBAccess();
    public void openList(){
        int userChoice = cli.listMenu();
        switch (userChoice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }
}
