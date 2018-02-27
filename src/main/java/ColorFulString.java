import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.k.mannur on 11/19/2017.
 */
public class ColorFulString {


    public static void main(String[] aas) {
        //System.out.println(subIntList("57832"));
        System.out.println(isColorful(57832));
    }

    static List subIntList(String inputString) {
        List<String> list = new ArrayList();
        for (int j = 0; j < inputString.length(); j++) {
            for (int i = 0; i <= inputString.length() - j; i++) {
                String substring = inputString.substring(i, i + j).trim();
                if (!substring.isEmpty())
                    list.add(substring);
            }
        }
        System.out.println(list);
        List list1 = new ArrayList();

        list.forEach(e -> {
            int i1 = 1;
            if (e.length() > 1) {
                for (int i = 0; i <= e.length() - 1; i++) {
                    i1 = i1 * Integer.parseInt(String.valueOf(e.charAt(i)));
                    list1.add(i1);
                }
            } else {
                list1.add(e);
            }
        });
        return list1;
    }


    public static boolean isColorful(int number){
        if(number < 10) return true;

        String colorString = String.valueOf(number);
        int length = colorString.length();

        List<Integer> colorMap = new ArrayList<Integer>();

        for(int i =  1; i < length; i++){
            for (int j = 0;  j+i <= length; j++){
                String sub = colorString.substring(j, j+i);
                int product = getProduct(Integer.parseInt(sub));
                if(colorMap.contains(product)) return false;
                else{
                    colorMap.add(product);
                }
            }
        }
        System.out.println(colorMap);
        return true;
    }

    private static int getProduct(int digits) {
        if(digits < 10) return digits;
        int num = digits;
        int product = 1;
        while(num > 0){
            product = product * (num % 10);
            num = num / 10;
        }
        return product;
    }
}
