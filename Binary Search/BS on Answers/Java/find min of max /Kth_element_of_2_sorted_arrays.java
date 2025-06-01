public class Kth_element_of_2_sorted_arrays{
    public static void main(String[] args) {
        boolean found = false;
        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};
        int k = 5; 

        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        int left = k;
        int low = Math.max(k - n2, 0);
        int high = Math.min(k, n1); 

        while (low <= high) { 
            int mid1 = (low + high)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                System.out.println(k + "th element is : " + Math.max(l1, l2));
                found = true;
                break;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        if(!found) {
            System.out.println("Element not found");
        }
    }
}