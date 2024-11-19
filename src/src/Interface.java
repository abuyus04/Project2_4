import java.util.Scanner;


public class Interface {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("1. Opret bruger");
            System.out.println("2. Se/køb abonnementer");
            System.out.println("3.Passiv Medlemskab");
            System.out.println("4. top 5 list");
            int enter = scanner.nextInt();
            scanner.nextLine();

            switch (enter){
                case 1:
                    CreateAccount createAccount = new CreateAccount();
                    createAccount.account();
            }

        }




    }
}
