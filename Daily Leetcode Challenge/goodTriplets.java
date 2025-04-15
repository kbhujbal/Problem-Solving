
public class goodTriplets {
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 1, 3};
        int[] nums2 = {0, 1, 2, 3};

        long result = countGoodTriplets(nums1, nums2);
        System.out.println("Number of good triplets: " + result);
    }

    public static long countGoodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = pos[nums1[i]];
        }

        Fenwick left = new Fenwick(n);
        Fenwick right = new Fenwick(n);

        for (int i = 0; i < n; i++) {
            right.add(transformed[i], 1);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            right.add(transformed[i], -1); 

            long smallerLeft = left.sum(transformed[i] - 1);
            long greaterRight = right.sum(n - 1) - right.sum(transformed[i]);

            result += smallerLeft * greaterRight;

            left.add(transformed[i], 1); 
        }

        return result;
    }

    static class Fenwick {
        private final int[] tree;

        public Fenwick(int size) {
            tree = new int[size + 1];
        }

        public void add(int index, int value) {
            index++;
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int sum(int index) {
            index++;
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}
