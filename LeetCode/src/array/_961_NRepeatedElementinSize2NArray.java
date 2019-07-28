package array;

/**
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of
 * these elements is repeated N times.
 * 
 * Return the element repeated N times.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,3] Output: 3 Example 2:
 * 
 * Input: [2,1,2,5,3,2] Output: 2 Example 3:
 * 
 * Input: [5,1,5,2,5,3,5,4] Output: 5
 */
class _961_NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        if (A == null | A.length < 4) {
            return 0;
        }
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
                return A[i];
            }
        }
        // corner case [2, 2, 1, 3]
        return A[0];
    }
}