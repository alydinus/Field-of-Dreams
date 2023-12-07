import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<>();
        a.add("Alydin");
        ArrayList<String> s = new ArrayList<>(List.of(a.get(0).split("")));
        for (String str:
             s) {
            System.out.println(str);
        }

    }
}
