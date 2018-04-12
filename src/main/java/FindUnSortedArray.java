import java.util.Stack;

/**
 * Created by amit.k.mannur on 3/30/2018.
 */

public class FindUnSortedArray {


    public static void main(String[] args) {
        int[] ints = {2, 3, 3, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(ints));
       /* String s = "amit";
        System.out.println(s.codePointAt(0));
        System.out.println(Character.toTitleCase('a'));
        System.out.println(Character.getNumericValue('0'));
*/
    }

    private static int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}

