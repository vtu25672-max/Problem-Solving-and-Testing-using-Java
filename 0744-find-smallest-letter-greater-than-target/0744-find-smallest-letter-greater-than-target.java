class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        // Standard Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If 'low' is out of bounds, it means no character is greater than target.
        // The problem asks to wrap around and return the first element.
        return letters[low % letters.length];
    }
}
