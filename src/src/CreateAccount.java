import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//Ali
public class CreateAccount {
    Scanner sc = new Scanner(System.in);

    public void account(){
        System.out.println("Skriv dit navn");
        String name = sc.nextLine();

        LocalDate birthdate = null;
        while (birthdate == null){
            System.out.println("Skriv dit fødselsdato");
            String birthdayInput = sc.nextLine();

            try{
                birthdate = LocalDate.parse(birthdayInput);
            }catch (DateTimeParseException e){
                System.out.println("Prøv igen");
            }

        }
    }

}