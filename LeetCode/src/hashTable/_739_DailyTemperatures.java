/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you
 * would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 *
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000].
 *
 * Each temperature will be an integer in the range [30, 100].
 * 
 */

class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        int len = T.length;
        int[] map = new int[101];
        int[] res = new int[len];
        Arrays.fill(map, Integer.MAX_VALUE);
        for (int i = len - 1; i >= 0; i--) {
            int idx = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                if (map[j] < idx) {
                    idx = map[j];
                }
            }
            if (idx < Integer.MAX_VALUE) {
                res[i] = idx - i;
            }
            map[T[i]] = i;
        }
        return res;
    }
}