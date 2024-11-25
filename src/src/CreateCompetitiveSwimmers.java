import java.util.*;
import java.util.stream.Collectors;

public class CreateCompetitiveSwimmers {

    ArrayList<CompetetiveSwimmer> Competitiveo18 = new ArrayList<>();
    ArrayList<CompetetiveSwimmer> Competitiveu18 = new ArrayList<>();
    ArrayList<RecordsTournament> recordsTournamentArrayListo18 = new ArrayList<>();
    ArrayList<RecordsTraining> recordsTrainingoArraylisto18 = new ArrayList<>();
    ArrayList<RecordsTournament> recordsTournamentArrayListu18 = new ArrayList<>();
    ArrayList<RecordsTraining> recordsTrainingoArraylistu18 = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    CreateMember2 createMember2;

    public CreateCompetitiveSwimmers(CreateMember2 createMember2) {
        this.createMember2 = createMember2;
    }

    public void createCompetitiveSwimmersu18() {
        createMember2.printmembersu18();
        String answer = "";
        System.out.println("Enter the ID of the member you want to add a record to: ");
        int memberId = sc.nextInt();

        System.out.println("What disciple does he swim in: \n" +
                " 1 = Crawl\n" +
                " 2 = Breast swimming\n " +
                " 3 = Butterfly\n " +
                " 4 = BackCrawl");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> answer = "Crawl";
            case 2 -> answer = "Breast Swimming";
            case 3 -> answer = "Butterfly Swimming";
            case 4 -> answer = "BackCrawl";
            default -> System.out.println("Invalid choice");

        }

        String swimCompetitive = answer;
        Member member = createMember2.findMemberByMemberNumber(memberId);

        if (member != null && member.isUnder18() && !member.isMotionist()) {
            System.out.println(member.memberNumber + " " + member.firstName + " " + member.lastName);
            Competitiveu18.add(new CompetetiveSwimmer(member.memberNumber, member.firstName, member.lastName, member.day,
                    member.month, member.year, member.gender, member.isUnder18(), false, member.isMotionist(),
                    member.isActive(), true,
                    member.price, swimCompetitive));
        }
    }

    public void createCompetitiveSwimmerso18() {
        createMember2.printmemberso18();
        String answer = "";
        System.out.println("Enter the ID of the member you want to add a record to: ");
        int memberId = sc.nextInt();
        System.out.println("What disciple does he swim in: \n" +
                " 1 = Crawl\n" +
                " 2 = Breast swimming\n " +
                " 3 = Butterfly\n " +
                " 4 = BackCrawl");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> answer = "Crawl";
            case 2 -> answer = "Breast Swimming";
            case 3 -> answer = "Butterfly Swimming";
            case 4 -> answer = "BackCrawl";
            default -> System.out.println("Invalid choice");
        }

        String swimCompetitive = answer;
        Member member = createMember2.findMemberByMemberNumber(memberId);

        if (member != null && !member.isUnder18() && !member.isMotionist()) {
            System.out.println(member.memberNumber + " " + member.firstName + " " + member.lastName);
            Competitiveo18.add(new CompetetiveSwimmer(member.memberNumber, member.firstName, member.lastName, member.day,
                    member.month, member.year, member.gender, member.isUnder18(), false, member.isMotionist(),
                    member.isActive(), true,
                    member.price, swimCompetitive));
        }
    }

    public void creatingaRecordso18() {
        System.out.println("Here are all the record holders over 18 years");

        for (CompetetiveSwimmer swimmer : Competitiveo18) {
            if (!swimmer.isMotionist() && swimmer.isActive() && !swimmer.isUnder18()) {
                System.out.println("First Name: " + swimmer.getFirstName() + "\nLast Name: " + swimmer.getLastName()
                        + "\nDate of birth: " + swimmer.getDay() + "/" + swimmer.getMonth() + "/" + swimmer.getYear()
                        + "\nGender: " + swimmer.getGender()
                        + "\nSwim Disciple: " + swimmer.getSwimDisciple() + "\n");
            }
        }

        System.out.println("\nWhich member do you want to add a record to? ");
        int memberNumber = sc.nextInt();
        CompetetiveSwimmer swimmer = null;
        for (CompetetiveSwimmer s : Competitiveo18) {
            if (s.memberNumber == memberNumber) {
                swimmer = s;
            }
        }

        if (swimmer == null) {
            System.out.println("\nCould not find swimmer");
            return;
        }

        System.out.println("\nYou chose to make a record for " + swimmer.getFirstName() + " " + swimmer.getLastName());
        System.out.println("\nIs the record creation for a tournament (1) or a personal record (2)?");
        int asw1 = sc.nextInt();
        if (asw1 == 1) {
            System.out.println("Where was the tournament?");
            String convention = sc.next();
            System.out.println("What day was it?");
            int day = sc.nextInt();
            System.out.println("What month was it?");
            int month = sc.nextInt();
            System.out.println("What year was it?");
            int year = sc.nextInt();
            System.out.println("What placement did the swimmer get?");
            int placement = sc.nextInt();
            RecordsTournament recordsTournament = new RecordsTournament(swimmer.getMemberNumber(),
                    swimmer.getFirstName(), swimmer.getLastName(),
                    swimmer.getDay(), swimmer.getMonth(), swimmer.getYear(), swimmer.getGender(), swimmer.isUnder18(),
                    swimmer.isOver60(), swimmer.isMotionist(),
                    swimmer.isActive(), swimmer.isRestance(), swimmer.getPrice(), swimmer.getSwimDisciple(), convention,
                    day, month, year, placement);
            recordsTournamentArrayListo18.add(recordsTournament);
        } else if (asw1 == 2) {
            System.out.println("What was the time for the record (e.g., 10.82)?");
            double time = sc.nextDouble();
            System.out.println("What day was it?");
            int day = sc.nextInt();
            System.out.println("What month was it?");
            int month = sc.nextInt();
            System.out.println("What year was it?");
            int year = sc.nextInt();
            RecordsTraining recordsTraining = new RecordsTraining(swimmer.getMemberNumber(), swimmer.getFirstName(),
                    swimmer.getLastName(),
                    swimmer.getDay(), swimmer.getMonth(), swimmer.getYear(), swimmer.getGender(), swimmer.isUnder18(),
                    swimmer.isOver60(), swimmer.isMotionist(),
                    swimmer.isActive(), swimmer.isRestance(), swimmer.getPrice(), swimmer.getSwimDisciple(), time, day,
                    month, year);
            recordsTrainingoArraylisto18.add(recordsTraining);
        }
    }

    public void creatingaRecordsu18() {
        System.out.println("Here are all the record holders under 18 years");

        for (CompetetiveSwimmer swimmer : Competitiveo18) {
            if (!swimmer.isMotionist() && swimmer.isActive() && swimmer.isUnder18()) {
                System.out.println("First Name: " + swimmer.getFirstName() + "\nLast Name: " + swimmer.getLastName()
                        + "\nDate of birth: " + swimmer.getDay() + "/" + swimmer.getMonth() + "/" + swimmer.getYear()
                        + "\nGender: " + swimmer.getGender()
                        + "\nSwim Disciple: " + swimmer.getSwimDisciple() + "\n");
            }
        }

        System.out.println("\nWhich member do you want to add a record to? ");
        int memberNumber = sc.nextInt();

        CompetetiveSwimmer swimmer = null;
        for (CompetetiveSwimmer s : Competitiveo18) {
            if (s.memberNumber == memberNumber) {
                swimmer = s;
            }
        }

        if (swimmer == null) {
            System.out.println("\nCould not find swimmer");
            return;
        }

        System.out.println("\nYou chose to make a record for " + swimmer.getFirstName() + " " + swimmer.getLastName());
        System.out.println("\nIs the record creation for a tournament (1) or a personal record (2)?");
        int asw1 = sc.nextInt();
        if (asw1 == 1) {
            System.out.println("Where was the tournament?");
            String convention = sc.next();
            System.out.println("What day was it?");
            int day = sc.nextInt();
            System.out.println("What month was it?");
            int month = sc.nextInt();
            System.out.println("What year was it?");
            int year = sc.nextInt();
            System.out.println("What placement did the swimmer get?");
            int placement = sc.nextInt();
            RecordsTournament recordsTournament = new RecordsTournament(swimmer.getMemberNumber(),
                    swimmer.getFirstName(), swimmer.getLastName(),
                    swimmer.getDay(), swimmer.getMonth(), swimmer.getYear(), swimmer.getGender(), swimmer.isUnder18(),
                    swimmer.isOver60(), swimmer.isMotionist(),
                    swimmer.isActive(), swimmer.isRestance(), swimmer.getPrice(), swimmer.getSwimDisciple(), convention,
                    day, month, year, placement);
            recordsTournamentArrayListu18.add(recordsTournament);
        } else if (asw1 == 2) {
            System.out.println("What was the time for the record (e.g., 10.82)?");
            double time = sc.nextDouble();
            System.out.println("What day was it?");
            int day = sc.nextInt();
            System.out.println("What month was it?");
            int month = sc.nextInt();
            System.out.println("What year was it?");
            int year = sc.nextInt();
            RecordsTraining recordsTraining = new RecordsTraining(swimmer.getMemberNumber(), swimmer.getFirstName(),
                    swimmer.getLastName(),
                    swimmer.getDay(), swimmer.getMonth(), swimmer.getYear(), swimmer.getGender(), swimmer.isUnder18(),
                    swimmer.isOver60(), swimmer.isMotionist(),
                    swimmer.isActive(), swimmer.isRestance(), swimmer.getPrice(), swimmer.getSwimDisciple(), time, day,
                    month, year);
            recordsTrainingoArraylistu18.add(recordsTraining);
        }
    }

    public void printingSortedlistTrainingu18() {
        List<RecordsTraining> sortedList = recordsTrainingoArraylistu18.stream()
                .sorted(Comparator.comparing(RecordsTraining::getTrainingResultTime))
                .collect(Collectors.toList());

        System.out.println("Best training records for under 18:");
        for (RecordsTraining rt : sortedList) {
            System.out.println("\nFirst Name: " + rt.getFirstName() +
                    "\nLast Name: " + rt.getLastName() +
                    "\nDate of birth: " + rt.getDay() + "/" + rt.getMonth() + "/" + rt.getYear() +
                    "\nGender: " + rt.getGender() +
                    "\nSwim Disciple: " + rt.getSwimDisciple() +
                    "\nTraining result: " + rt.getTrainingResultTime() +
                    "\nTraining day: " + rt.getTrainingResultDay() + "/" + rt.getTrainingResultMonth() + "/"
                    + rt.getTrainingresultYear() + "\n");
        }
    }

    public void printingSortedlistTournamentu18() {
        List<RecordsTournament> sortedList = recordsTournamentArrayListu18.stream()
                .sorted(Comparator.comparing(RecordsTournament::getplacement))
                .collect(Collectors.toList());

        System.out.println("Best tournament records for under 18:");
        for (RecordsTournament rt : sortedList) {
            System.out.println("\nFirst Name: " + rt.getFirstName() +
                    "\nLast Name: " + rt.getLastName() +
                    "\nDate of birth: " + rt.getDay() + "/" + rt.getMonth() + "/" + rt.getYear() +
                    "\nGender: " + rt.getGender() +
                    "\nSwim Disciple: " + rt.getSwimDisciple() +
                    "\nPlacement: " + rt.getplacement() +
                    "\nTournament Place: " + rt.getConvention()
                    + "\nDay " + rt.gettournementDay() + "/" + rt.gettournementMonth() + "/" + rt.gettournementYear()
                    + "\n");
        }
    }

    public void printingSortedlistTrainingo18() {
        List<RecordsTraining> sortedList = recordsTrainingoArraylisto18.stream()
                .sorted(Comparator.comparing(RecordsTraining::getTrainingResultTime))
                .collect(Collectors.toList());

        System.out.println("Best training records for over 18:");
        for (RecordsTraining rt : sortedList) {
            System.out.println("\nFirst Name: " + rt.getFirstName() +
                    "\nLast Name: " + rt.getLastName() +
                    "\nDate of birth: " + rt.getDay() + "/" + rt.getMonth() + "/" + rt.getYear() +
                    "\nGender: " + rt.getGender() +
                    "\nSwim Disciple: " + rt.getSwimDisciple() +
                    "\nTraining result: " + rt.getTrainingResultTime() +
                    "\nTraining day: " + rt.getTrainingResultDay() + "/" + rt.getTrainingResultMonth() + "/"
                    + rt.getTrainingresultYear() + "\n");
        }
    }

    public void printingSortedlistTournamento18() {
        List<RecordsTournament> sortedList = recordsTournamentArrayListo18.stream()
                .sorted(Comparator.comparing(RecordsTournament::getplacement))
                .collect(Collectors.toList());

        System.out.println("Best tournament records for over 18:");
        for (RecordsTournament rt : sortedList) {
            System.out.println("\nFirst Name: " + rt.getFirstName() +
                    "\nLast Name: " + rt.getLastName() +
                    "\nDate of birth: " + rt.getDay() + "/" + rt.getMonth() + "/" + rt.getYear() +
                    "\nGender: " + rt.getGender() +
                    "\nSwim Disciple: " + rt.getSwimDisciple() +
                    "\nPlacement: " + rt.getplacement() +
                    "\nTournament Place: " + rt.getConvention()
                    + "\nDay " + rt.gettournementDay() + "/" + rt.gettournementMonth() + "/" + rt.gettournementYear()
                    + "\n");
        }
    }
}
