//Yosef

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Subscription {//extends NewAccountFile {

    Scanner scanner = new Scanner(System.in);

    void registerSubscription() {

        while (true) {
            //while loop start

            BufferedReader reader;

            {
                try {


                    reader = new BufferedReader(new FileReader("src/UserData.txt"));


                    System.out.println("hent navn");
                    String inputName = scanner.nextLine();

                    String line;
                    boolean found = false;
                    DateTimeFormatter.ofPattern("yyyy-MM-dd");


                    while ((line = reader.readLine()) != null) {
                        if (line.contains(inputName)) {
                            System.out.println(line);
                            found = true;

                            Integer age = extractAge(line);
                            if (age != null) {
                                System.out.println("Alder: " + age);
                            } else {
                                System.out.println("null");
                            }

                            String passiveOrActive = passiveOrActive(line);

                            // extract passiv/aktiv
                            if (age >= 18 && passiveOrActive.equals("Aktiv")) {
                                System.out.println("Medlemsskab pr. år: 1.600kr.");

                            } else if (age < 18 && passiveOrActive.equals("Aktiv")){
                                System.out.println("Medlemsskab pr. år: 1.000kr.");

                            } else if (age >= 60 && passiveOrActive.equals("Aktiv")) {
                                System.out.println("Medlemsskab pr. år: 1.200kr.");
                                
                            } else if (passiveOrActive.equals("Passiv")){
                                System.out.println("Medlemsskab pr. år: 500kr.");
                            }

                        }
                    }


                    if (!found) {
                        System.out.println("navn ikke fundet");
                    }

                    reader.close();


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


            //while loop stopper

            //når du opretter bruger vælger du medlemdsskab
        }
    }

    Integer extractAge(String line){

        String[] parts = line.split(", ");
        for (String part: parts){
            if (part.startsWith("Alder: ")){
                return Integer.parseInt(part.replace("Alder: ", "").trim());
            }
        }
        return null; // hvis alder ikke er fundet
    }


    String passiveOrActive(String line){

        String[] parts = line.split(", ");
        for (String part : parts){
            if (part.startsWith("Medlemsskab: ")){

                return part.replace("Medlemsskab: ","").trim();
            }
        }
        return null;
    }
}


/*
public void main(String[] args) {

    Subscription subscription = new Subscription();

    subscription.registerSubscription();

}
*/
