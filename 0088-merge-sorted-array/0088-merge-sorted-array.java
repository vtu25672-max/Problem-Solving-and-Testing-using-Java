class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      // Pointer for end of valid elements in nums1
        int j = n - 1;      // Pointer for end of nums2
        int k = m + n - 1;  // Pointer for the last position in nums1
        
        // While there are elements to compare in both arrays
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                // If nums2 element is larger or nums1 is exhausted
                nums1[k--] = nums2[j--];
            }
        }
    }
}
