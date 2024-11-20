import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class NewAccountFile {


    String name;
    LocalDate birthDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    int memberShip; //active or passive
    Scanner scanner = new Scanner(System.in);

    void createAccount(){


        while (true) {
            try {


                FileWriter fileWriter = new FileWriter("src/UserData.txt", true);

                PrintWriter printWriter = new PrintWriter(fileWriter);


                System.out.println("----Opret medlemsskab----");
                System.out.println("over 18: 1.600kr pr. år");
                System.out.println("under 18: 1.000kr pr. år");
                System.out.println("over 60 år 1.200kr pr. år");
                System.out.println("passivt medlem 500kr pr. år");

                System.out.println();

                System.out.println("Indtast fulde navn:");
                name = scanner.nextLine();
                System.out.println("Indtast fødselsdato(åååå-MM-dd):");
                birthDate = LocalDate.parse(scanner.nextLine(),formatter);

                String membershipStatus = ActiveOrPassive();
                int age = calculateAge();


                printWriter.print("Navn: "+name+ ", Fødselsdato: "+birthDate+", Alder: "+age+", Medlemsskab: "+membershipStatus);
                printWriter.println();


                printWriter.close();
                printWriter.flush();

                System.out.println("dit medlemsskab er blevet oprettet");
                break;

                //baser abonnoment baseret på aktiv eller passiv


                //calculate age

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    String ActiveOrPassive(){

        while (true) {
            System.out.println("vil du oprette dig et aktivt eller passivt medlemskab");
            System.out.println("1. Aktiv");
            System.out.println("2. Passiv");
            memberShip = scanner.nextInt();
            if (memberShip == 1) {
                return "Aktiv";
            } else if (memberShip == 2) {
                return "Passiv";

            } else if (memberShip < 1 && memberShip > 2) {
                System.out.println("Ugyldigt valg prøv igen");

            }

        }
    }

    int calculateAge(){
        LocalDate currentDate = LocalDate.now();
        return java.time.Period.between(birthDate, currentDate). getYears();
        // beregner år imellem så du får alderen
    }

}

/*
public void main(String[] args) {


    NewAccountFile n = new NewAccountFile();
    n.createAccount();
}
*/

