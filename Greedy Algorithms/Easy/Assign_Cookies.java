
import java.util.Arrays;

public class Assign_Cookies{
    public static void main(String[] args){
        int[] greed = {1, 5, 3, 3, 4};
        int[] cookie_size= {4, 2, 1, 2, 1, 3};

        int n = greed.length, m = cookie_size.length;
        int l = 0, r = 0;

        Arrays.sort(greed);
        Arrays.sort(cookie_size);

        while (l < m && r < n) { 
            if (greed[r] <= cookie_size[l]) {
                r++;
            }
            l = l + 1;
        }
        System.out.println(r + " children can be satisfied !");
    }
}