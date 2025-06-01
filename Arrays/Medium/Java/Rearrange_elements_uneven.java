import java.util.*;

public class Rearrange_elements_uneven {
    public static void main(String [] args){
        int [] nums = {1, 2, -4, -5, 3, 4};

        ArrayList <Integer> positives = new ArrayList<>();
        ArrayList <Integer> negatives = new ArrayList<>();

        int [] result = new int[nums.length];

        // Segregating positive and negative numbers in different arraylists
        for(int num : nums){
            if(num > 0){
                positives.add(num);
            }
            else{
                negatives.add(num);
            }
        }

        int i = 0,  j = 0, k = 0;
        while(i < positives.size() && j < negatives.size()){
            result[k++] = positives.get(i++);
            result[k++] = negatives.get(j++);
        }

        // Append remaining positive elements
        while(i < positives.size()){
            result[k++] = positives.get(i++);
        }

        // Append remaining negative elements
        while(j < negatives.size()){
            result[k++] = negatives.get(j++);
        }

        // Printing the result
        for(int resnum : result){
            System.out.print(resnum + ", ");
        }
    }
}
