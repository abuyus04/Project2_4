import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateMember2 {

    Scanner sc = new Scanner(System.in);
    boolean isMotionist;
    ArrayList<Member> memberList = new ArrayList<Member>();

    public void createMember() {

        System.out.println("Hi Welcome to create new Member");
        System.out.println("What is the first name of the member?");
        String firstName = sc.next();

        System.out.println("What is the last name of the member?");
        String lastName = sc.next();

        System.out.println("What gender is the member? (Man, Women or other)");
        String gender = sc.next();

        System.out.println("What day is the member born?");
        int day = sc.nextInt();

        System.out.println("What month is the member born? (1-12)");
        int month = sc.nextInt();

        System.out.println("What year is the member born?");
        int year = sc.nextInt();

        System.out.println("What kind of membership has the member (Active = 1 or Passive = 2)");
        boolean isActive = sc.nextInt() == 1;

        if (isActive) {
            System.out
                    .println("Is the member a Motionist swimmer or a Competetive (1 = Motionist or 2 = Competitive )");
            isMotionist = sc.nextInt() == 1;
        }
        memberList.add(
                new Member(memberList.size() + 1, firstName, lastName, day, month, year, gender, isUnder18(day, month, year),
                        false, isMotionist, isActive, true,
                        price(isOver60(day, month, year), isUnder18(day, month, year), isActive)));
        System.out.println("Member " + memberList.size() + ": " + firstName + " is created");
    }

    public boolean isUnder18(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        return Period.between(date, today).getYears() < 18;
    }

    public boolean isOver60(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        return Period.between(date, today).getYears() >= 60;
    }

    public int price(boolean over60, boolean under18, boolean isActive) {
        int price = 1;
        if (!isActive) {
            price = 500;
            return price;
        } else if (isActive && under18) {
            price = 1000;
            return price;
        } else if (isActive && over60) {
            price = 1200;
            return price;
        } else if (!under18 && isActive) {
            price = 1600;
            return price;
        }
        return price;
    }

    public void printMemberList() {
        System.out.println("Hi Welcome to member site\n" +
                "Here is all the members for the union\n" + " ");

        for (Member member : memberList) {
            System.out.println("Member Number: " + member.memberNumber + " First Name: "
                    + member.firstName
                    + " Last Name: " + member.lastName
                    + " Date of birth: " + member.day
                    + "/" + member.month
                    + "/" + member.year + "\n");
        }
    }


    public void printInvoices() {
        System.out.println("Hi Welcome to Invoice site\n" +
                "Here are all the invoices\n");

        for (Member member : memberList) {
            System.out.println("First Name: " + member.firstName
                    + " Last Name: " + member.lastName
                    + " Date of birth: " + member.day + "/" + member.month + "/" + member.year
                    + " Price: " + member.price
                    + " Unpaid invoice: " + member.restance + "\n");
        }
        printPaymentStatus();
        System.out.println("Would you like to change invoice status?\n" + "Yes = 1 \n" + "No = 2");
        int answer2 = 0;
        answer2 = sc.nextInt();
        if (answer2 == 1) {
            System.out.println("Which member do you want to change invoice status?\n" + "Enter Member Number ");
            int memberNumber = 0;
            memberNumber = sc.nextInt();
            Member member = findMemberByMemberNumber(memberNumber);
            if (member != null) {
                if (member.restance == true) {
                    member.restance = false;
                } else {
                    member.restance = true;
                }
                System.out.println(
                        "Invoice status for member " + memberNumber + " has been updated to = " + member.restance);
            } else {
                System.out.println("Member not found.");
            }
        }

    }

    public Member findMemberByMemberNumber(int memberNumber) {
        for (Member m : memberList) {
            if (m.memberNumber == memberNumber) {
                return m;
            }
        }

        return null;
    }

    public void printmembersu18() {
        System.out.println("Here is all the members who are competetive and can be made records to under 18 ");
        for (Member member : memberList) {
            if (!member.isMotionist() && member.isUnder18()) {
                System.out.println("First Name: "
                        + member.getFirstName() + " Last Name: "
                        + member.getLastName() + " Date of birth: "
                        + member.getDay() + "/" + member.getMonth() + "/" + member.getYear() + "\n");

            }

        }
    }

    public void printmemberso18() {
        System.out.println("Here is all the members who are competetive and can be made records to over 18 ");
        for (Member member : memberList) {
            if (!member.isMotionist() && !member.isUnder18()) {
                System.out.println("First Name: "
                        + member.getFirstName() + " Last Name: "
                        + member.getLastName() + " Date of birth: "
                        + member.getDay() + "/" + member.getMonth() + "/" + member.getYear() + "\n");

            }
        }
    }


    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void printPaymentStatus() {
        int paidinvoices = 0;
        int unpaidinvoices = 0;
        for (Member member : memberList) {
            if (member.isRestance()) {
                unpaidinvoices += member.getPrice();
            } else {
                paidinvoices += member.getPrice();
            }

        }
        System.out.println("Here is the total of invoices paid and unpaid :)\n" +
                "Paid invoices: " + paidinvoices + ",- DKK"
                + "\nUnpaid invoices: " + unpaidinvoices + ",- DKK");

    }


    public void loadMembers() {
        String allMembers = "allmembers1.csv";
        String line;
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(allMembers))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                try {
                    String[] members = line.split(csvSplitBy);

                    if (members.length != 13) {
                        continue;
                    }

                    if (findMemberByMemberNumber(Integer.parseInt(members[0])) != null) {
                        continue;
                    }

                    int memberNumber = Integer.parseInt(members[0]);
                    String firstName = members[1];
                    String lastName = members[2];
                    int dayOfBirth = Integer.parseInt(members[3]);
                    int monthOfBirth = Integer.parseInt(members[4]);
                    int yearOfBirth = Integer.parseInt(members[5]);


                    if (dayOfBirth < 1 || dayOfBirth > 31 || monthOfBirth < 1 || monthOfBirth > 12 || yearOfBirth < 1900
                            || yearOfBirth > 2100) {
                        System.out.println("Skipping line due to invalid date of birth: " + line);
                        continue;
                    }

                    String gender = members[6];
                    boolean under18 = Boolean.parseBoolean(members[7]);
                    boolean over60 = Boolean.parseBoolean(members[8]);
                    boolean isMotionist = Boolean.parseBoolean(members[9]);
                    boolean isActive = Boolean.parseBoolean(members[10]);
                    boolean restance = Boolean.parseBoolean(members[11]);
                    int price = Integer.parseInt(members[12]);


                    memberList.add(new Member(memberNumber, firstName, lastName, dayOfBirth, monthOfBirth,
                            yearOfBirth, gender, under18, over60, isMotionist, isActive, restance, price));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping line due to number format issue: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
