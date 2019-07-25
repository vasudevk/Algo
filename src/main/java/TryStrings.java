import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TryStrings {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Arsenal", "Chelsea", "Liverpool", "Manchester United", "Manchester City");

        String joiner = stringList.stream().collect(Collectors.joining(" || "));

        String builder = stringList.stream().collect(Collector.of(StringBuilder::new,
                (stringBuilder, str) -> stringBuilder.append(str).append(", "),
                StringBuilder::append,
                StringBuilder::toString));
//
//        System.out.println(joiner);
//        System.out.println(builder);


        String a = "Vasu";
        String b = a;
        System.out.println(a);

        a = "Dev";
        System.out.println(a);
        System.out.println(b); // Since b is always referring to initial value of a which is "abc", b takes the value "abc"

        /*
         * This concept is only applicable for literals only. i.e., primitives
         * Main object is created in Heap Memory and references are stored in String/int/char Literal Pool
         * */

        int x = 10;
        int y = x;
        System.out.println(x);

        x = 15;
        System.out.println(x);
        System.out.println(y);


        Party party = new Party();
        party.setLeader("Jagan");
        party.setPartyName("YSRCP");

        Party party1;
        party1 = party;

        party.setPartyName("BJP");
        party.setLeader("Modi");

        System.out.println(party.getLeader());
        System.out.println(party1.getLeader()); //Copy by reference - addresses of the object are copied
    }
}