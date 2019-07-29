package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * There are 8 prison cells in a row, and each cell is either occupied or
 * vacant.
 * 
 * Each day, whether the cell is occupied or vacant changes according to the
 * following rules:
 * 
 * If a cell has two adjacent neighbors that are both occupied or both vacant,
 * then the cell becomes occupied. Otherwise, it becomes vacant. (Note that
 * because the prison is a row, the first and the last cells in the row can't
 * have two adjacent neighbors.)
 * 
 * We describe the current state of the prison in the following way: cells[i] ==
 * 1 if the i-th cell is occupied, else cells[i] == 0.
 * 
 * Given the initial state of the prison, return the state of the prison after N
 * days (and N such changes described above.)
 * 
 * Example 1:
 * 
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7 Output: [0,0,1,1,0,0,0,0]
 */
class _957_PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            map.put(Arrays.toString(cells), N);
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            N--;
            if (map.containsKey(Arrays.toString(cells))) {
                N = N % (map.get(Arrays.toString(cells)) - N);
            }
        }
        return cells;
    }
}