/**
 * Created by amit.k.mannur on 3/13/2018.
 */
public class StringToInt {
    public static void main(String... as){
        System.out.println(convertStringToInt("25")*2);
        System.out.println(strToInt("25")*2);

        String[] doub="99.9".split("\\.");
        strToDouble(doub);

    }

    private static void strToDouble(String[] doub) {
        int sum1=strToInt(doub[0])*2;
        int sum2=strToInt(doub[1])*2;
        String a=""+sum2;
        if(a.length()>doub[1].length()){
            System.out.println(sum1+strToInt(""+a.charAt(0))+"."+a.substring(1,a.length()));
        }else{
            System.out.println(sum1+"."+sum2);
        }
    }

    private static int convertStringToInt(String num) {
        int result = 0;

        for (char c: num.toCharArray()) {
            c -= 48;
            if (c <= 9) {
                result = (result << 3) + (result << 1) + c;
            } else return -1;
        }
        return result;
    }

    private static int strToInt( String str ){
        int i = 0;
        int num = 0;
        while( i < str.length()) {
            num *= 10;
            num += str.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
        }
        return num;
    }
}
