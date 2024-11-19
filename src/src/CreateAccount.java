import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//Ali
public class CreateAccount extends NewAccount {
    Scanner sc = new Scanner(System.in);

    CreateAccount(String name, LocalDate birthdate) {
        super(name, birthdate);
    }

    public void account(){
        System.out.println("Indtast navn");
        String name = sc.nextLine();

        LocalDate birthdate = null;
        while (birthdate == null){
            System.out.println("Indtast fødselsdag");
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

}