package problems.p668;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/solution/
 * 
 *  Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number 
 *  quickly from the multiplication table?
 *  
 *  Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need 
 *  to return the k-th smallest number in this table. 
 * @author Yury_Kiryla
 *
 */
public class Solution {
	
	public int findKthNumber(int m, int n, int k) {
        int[][] table = generateTable(m, n);
        
        List<Integer> sortedValues = collectAndSort(table);
        return sortedValues.get(k - 1);
    }
    
    private int[][] generateTable(int m, int n) {
        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    table[i][j] = j + 1;
                } else if (j == 0) {
                    table[i][j] = i + 1;
                } else {
                    table[i][j] = table[0][j] * table[i][0];
                }
            }
        }
        return table;
    }
    
    private List<Integer> collectAndSort(int[][] table) {
        List<Integer> result = new ArrayList<>();
        for (int[] rowElement : table) {
            for(int cell : rowElement) {
                if (result.isEmpty() || result.get(result.size() - 1) <= cell) {
                    result.add(cell);
                } else {
                    for (int i = 0; i < result.size(); i++) {
                        if (cell <= result.get(i)) {
                            result.add(i, cell);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

}
