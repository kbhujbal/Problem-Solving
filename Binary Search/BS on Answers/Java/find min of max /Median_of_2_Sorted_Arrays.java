
public class Median_of_2_Sorted_Arrays{
    public static void main(String[] args) {
        boolean found_median = false;
        int[] nums1 = {1, 4, 7, 10, 12};
        int[] nums2 = {2, 3, 6, 15};

        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        int n = n1 + n2;
        int left = (n1 + n2 + 1)/2;

        int low = 0, high = n1;
        while (low <= high) { 
            int mid1 = (low + high)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    System.out.println("Median is : " + Math.max(l1, l2));
                    found_median = true;
                    break;
                }
                else{
                    System.out.println("Median is : " + ((Math.max(l1, l2) + Math.min(r1, r2))/2));
                    found_median = true;
                    break;
                }
            } 
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }
        if (!found_median) {
            System.out.println("No median found");
        }
    }
}