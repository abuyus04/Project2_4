public class CompetetiveSwimmer extends Member {

    String swimDisciple;

    public CompetetiveSwimmer(int memberNumber, String firstName, String lastName, int day, int month, int year, String gender, boolean under18, boolean over60, boolean isMotionist, boolean isActive, boolean restance, int price, String  swimDisciple) {
        super(memberNumber,firstName,lastName,day,month,year,gender,under18,over60,isMotionist,isActive,restance,price);
        this.swimDisciple= swimDisciple;
    }

    public String getSwimDisciple() {
        return swimDisciple;
    }
}
