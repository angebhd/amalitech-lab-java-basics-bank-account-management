import menu.Menu;
import java.util.Scanner;

class Main{
	public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
		System.out.println("Hello World!");
        boolean exitApp = false ;
        char menuChoice;
        do{
            menu.showMainMenu();
            menuChoice = scanner.next().trim().charAt(0);
            switch (menuChoice){
                case '1':
                    System.out.println("Create Account");
                    break;
                case '2':
                    System.out.println("View Accounts");
                    break;
                case '3':
                    System.out.println("Process Transactions");
                    break;
                case '4':
                    System.out.println("View Transaction history");
                    break;
                case '5':
                    System.out.println("Exit");
                    exitApp = true;
                default:
                    continue;
            }

        }while (!exitApp);
	}
}
