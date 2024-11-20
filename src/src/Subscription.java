//Yosef

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Subscription extends NewAccountFile {


    void registerSubscription() {
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
                    }
                }



                if (!found){
                    System.out.println("navn ikke fundet");
                }

                reader.close();



            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public void main(String[] args) {

    Subscription subscription = new Subscription();

    subscription.registerSubscription();

}