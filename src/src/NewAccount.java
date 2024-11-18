public class NewAccount {
    String name;
    String birthdate;

    NewAccount(String name, String birthdate){
        this.birthdate= birthdate;
        this.name= name;
    }

    @Override
    public String toString() {
        return name + birthdate;
    }
}
