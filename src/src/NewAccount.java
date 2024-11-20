import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class NewAccount {
    String name;
    LocalDate birthday;

    NewAccount(String name, LocalDate birthday){
        this.birthday = birthday;
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println();
        return "Navn:+"+name +","+ birthday;
    }


}