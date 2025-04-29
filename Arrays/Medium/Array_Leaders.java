import java.util.ArrayList;
import java.util.Collections;

public class Array_Leaders{
    public static void main(String [] args){
        int [] arr = {30, 10, 10, 5};

        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = arr[n - 1];

        ans.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if(arr[i] >= max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(ans);
        System.out.println(ans);
    }
}