package prep;

import java.util.Arrays;
import java.util.List;

public class StringMe {


    public static void main(String[] args) {

        /*String a = "Vasu";
        String b = a;

        System.out.println(a); //Vasu//
        a = "Dev";

        System.out.println(a);//dev
        System.out.println(b);//dev*/


//        Party party1 = new Party();
//        party1.setLeader("Aanam");
//        party1.setPartyName("Congress");
//        Party pitrey2 = party1;
//        party1.setLeader("Babu garu");
//        party1.setPartyName("TDP");
//
//        System.out.println(party1.getLeader()); //aanam
//        System.out.println(party1.getPartyName());//congress
//        System.out.println(pitrey2.getLeader());//babu
//        System.out.println(pitrey2.getPartyName());//tdp


        List<String> stringList = Arrays.asList("Arsenal", "Chelsea", "Liverpool", "Manchester United", "Manchester City");


        // Print all the items in the list

        for (int i = 0; i < stringList.size(); i++) {

            System.out.println(stringList.get(i));
        }


        stringList.stream().forEach(s -> System.out.println(s));
    }
}
