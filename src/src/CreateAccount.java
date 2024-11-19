import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

//Ali
public class CreateAccount{
    Scanner sc = new Scanner(System.in);

    public void account(){
        System.out.println("Indtast navn");
        String name = sc.nextLine();

        LocalDate birthdate = null;
        while (birthdate == null){
            System.out.println("Indtast fødselsdag (yyyy-MM-dd)");
            String birthdayInput = sc.nextLine();

            try{
                birthdate = LocalDate.parse(birthdayInput);

            }catch (DateTimeParseException e){
                System.out.println("Prøv igen");
            }

        }
        NewAccount newAccount = new NewAccount(name,birthdate);
        System.out.println(newAccount);

    }

    public void showAccount(){
        ArrayList<CreateAccount> names = new ArrayList<>();

    }

}