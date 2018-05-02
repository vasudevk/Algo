import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by amit.k.mannur on 4/29/2018.
 */

public class Barclayad {
    static int tAvail = 3;

    public static int solution(int N, String S) {


        String[][] columns = {{"A", "B", "C"}, {"D", "E", "F", "G"},{"H", "J", "K"}};
        String[] seatsR = S.split(" ");
        List<String> seatsRL = Arrays.asList(seatsR);
        tAvail = tAvail * N;
        IntStream.range(1, N).forEach(e -> {
                    IntStream.range(0, 3).forEach(e1 -> {
                        String res = e + columns[0][e1];
                        if (seatsRL.contains(res)) {
                            tAvail = tAvail - 1;
                            return;
                        }
                    });

                    IntStream.range(1,2).forEach(e1->{
                        String seatRes = e + columns[1][e1];
                        if (seatsRL.contains(seatRes)) {
                            tAvail = tAvail - 1;
                            return;
                        }
                    });
                    IntStream.range(0,2).forEach(e1->{
                        String seatRes = e + columns[2][e1];
                        if (seatsRL.contains(seatRes)) {
                            tAvail = tAvail - 1;
                            return;
                        }
                    });
                }
        );

        /*for (int i = 1; i <= N; i++) {
            *//*for (int j = 0; j < 3; j++) {
                String seatRes = i + columns[0][j];
                if (seatsRL.contains(seatRes)) {
                    tAvail = tAvail - 1;
                    break;
                }
            }*//*
            for (int j = 1; j <= 2; j++) {
                String seatRes = i + columns[1][j];
                if (seatsRL.contains(seatRes)) {
                    tAvail = tAvail - 1;
                    break;
                }
            }
            for (int j = 0; j < 3; j++) {
                String seatRes = i + columns[2][j];
                if (seatsRL.contains(seatRes)) {
                    tAvail = tAvail - 1;
                    break;
                }
            }
        }*/
        return tAvail;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, "1A 2F 1C"));
    }
}
