import java.util.Scanner;
//passiv medlemskab er hvor du sætter det på pause

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

        }




    }
}

//Trin 1: Analyse og Planlægning
//Vi skal finde ud af, hvad programmet skal kunne. Forestil dig, at programmet skal gøre dette:
//
//Registrere medlemmer:
//
//Når nogen melder sig ind, skal vi kunne skrive deres navn, alder, og hvilken type medlem de er (aktiv eller passiv).
//Regne kontingentet ud:
//
//Programmet skal automatisk finde ud af, hvor meget et medlem skal betale baseret på deres alder og medlemsstatus.
//Lave en liste over medlemmer, der ikke har betalt:
//
//Hvis nogen skylder penge, skal programmet vise dem på en liste, så klubben kan minde dem om det.
//Registrere resultater for konkurrencesvømmere:
//
//Programmet skal holde styr på, hvilke discipliner (som crawl eller rygsvømning) de træner i, deres bedste tider, og hvordan de klarer sig i konkurrencer.
//Lave top 5-lister:
//
//For hver disciplin skal programmet kunne vise de 5 bedste svømmere baseret på deres tider.
