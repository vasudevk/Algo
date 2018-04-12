/**
 * Created by amit.k.mannur on 4/1/2018.
 */
//greedy-minimum-number-platforms-required-railwaybus-station

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfPlatforms {
    //This gives the max platform requied when we increment based on arrivals
    static int result = 0;
    //Keep track if the time is from Arrival or Departure array
    enum ArrivalOrDeparture {
        A, D
    }
    //An object created from the both arrays.
    //Will hold time and whether its arrival or departure
    //I could have used map and merge sort.
    static class TrainScheduleTimeStamp implements Comparable<TrainScheduleTimeStamp> {
        public int timeStamp;
        public ArrivalOrDeparture arrivalOrDeparture;

        TrainScheduleTimeStamp(int timeStamp, ArrivalOrDeparture arrivalOrDeparture) {
            this.timeStamp = timeStamp;
            this.arrivalOrDeparture = arrivalOrDeparture;
        }

        @Override
        public int compareTo(TrainScheduleTimeStamp o) {
            return this.timeStamp - o.timeStamp;
        }

        @Override
        public String toString() {
            return "timeStamp := " + this.timeStamp + ", arrivalOrDeparture := " + this.arrivalOrDeparture;
        }
    }

    public static void main(String[] args) {

        int[] arrival = { 900,910,940 };
        int[] dep = { 920,950,1000 };

		/*int[] arrival = { 1100, 1103 };
		int[] dep = { 1102, 1105 };*/

		/*int[] arrival = { 1100, 1100 };
		int[] dep = { 1102, 1102 };*/

        int countNumberOfPlatforms = 0;

        //create and fill arraylist
        List<TrainScheduleTimeStamp> trainScheTimeStampArrLst = new ArrayList<>();
        for (int i = 0; i < arrival.length; i++) {
            trainScheTimeStampArrLst.add(new TrainScheduleTimeStamp(arrival[i], ArrivalOrDeparture.A));
            trainScheTimeStampArrLst.add(new TrainScheduleTimeStamp(dep[i], ArrivalOrDeparture.D));
        }
        //sort based on time
        Collections.sort(trainScheTimeStampArrLst);
       // System.out.println(Arrays.toString(trainScheTimeStampArrLst.toArray()));
        //based whether its arrival or departure set the counts and pass it to track max
        for (TrainScheduleTimeStamp tsTs : trainScheTimeStampArrLst) {
            if (tsTs.arrivalOrDeparture.equals(ArrivalOrDeparture.A)) {
                getPlatformsRequired(countNumberOfPlatforms++);
            } else {
                getPlatformsRequired(countNumberOfPlatforms--);
            }
        }
        System.out.println("number of platforms required " + result);
    }

    private static void getPlatformsRequired(int i) {
        if (i > result)
            result++;
    }
}
