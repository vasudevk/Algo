/**
 * Created by amit.k.mannur on 4/12/2018.
 */

public class XOR {

    public static void main(String[] args) {
        int arr[]={1,2,1,2,3};
        int j=0;
        for(int i:arr){
            j=j^i;
        }
            System.out.println(j);
    }
}
