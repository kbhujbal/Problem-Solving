import java.util.ArrayList;

public class Union_of_arrays{
    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 6, 7};

        ArrayList <Integer > Union = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        
        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                if(Union.size() == 0 || Union.get(Union.size() - 1) != nums1[i]){
                    Union.add(nums1[i]);
                }
                i++;
            }
            else{
                if(Union.size() == 0 || Union.get(Union.size() - 1) != nums2[j]){
                    Union.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if(Union.get(Union.size() - 1) != nums1[i]){
                Union.add(nums1[i]);
            }
            i++;
        }

        while (j < n2) {
            if(Union.get(Union.size() - 1) != nums2[j]){
                Union.add(nums2[j]);
            }
            j++;
        }

        System.out.println("Union of the two arrays: ");
        for(int k = 0; k < Union.size(); k++){
            System.out.print(Union.get(k) + " ");
        }
    }
}