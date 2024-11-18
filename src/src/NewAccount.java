public class NewAccount {
    String name;
    String birthdate;
    boolean active;      //false = passiv, hvis man vil sætte sin konto på pause

    NewAccount(String name, String birthdate, boolean active){
        this.birthdate= birthdate;
        this.name= name;
        this.active= active;
    }

    @Override
    public String toString() {
        return name + birthdate;
    }
}

