package grokaem.algoritmy.ch9;

import java.util.List;

public class DinamicPrograming {
	
	public int fillBag(int size, List<Good> goods) {
		int[][] table = new int[goods.size()][size];
		
		for (int i = 0; i < goods.size(); i++) {
			Good good = goods.get(i);
			for (int j = 0; j < size; j++) {
				int max = 0;
				if (i == 0) {
					if (good.getSize() <= j + 1) {
						max = good.getPrice();
					}
				} else {
					max = table[i-1][j];
					if (good.getSize() == j + 1) {
						max = good.getPrice() > max ? good.getPrice() : max;
					} else if (good.getSize() <= j) {
						int newPrice = good.getPrice() + table[i-1][j - good.getSize()];
						max = newPrice > max ? newPrice : max;
					}
				}
				table[i][j] = max;
			}
		}
		
		return table[goods.size() - 1][size - 1];
	}
	
	public int longestCommonSequence(String first, String second) {
		int[][] table = new int[first.length()][second.length()];
		
		for (int i = 0; i < first.length(); i++) {
			for (int j = 0; j < second.length(); j++) {
				if (first.charAt(i) == second.charAt(j)) {
					if (i > 0 && j > 0) {
						table[i][j] = table[i - 1][j - 1] + 1;
					} else {
						table[i][j] = 1;
					}
				} else {
					if (i > 0 && j > 0) {
						table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
					} else {
						table [i][j] = 0;
					}
				}
			}
		}
		
		return table[first.length() - 1][second.length() - 1];
	}
	
	public int longestSequence(String first, String second) {
		int[][] table = new int[first.length()][second.length()];
		
		for (int i = 0; i < first.length(); i++) {
			for (int j = 0; j < second.length(); j++) {
				if (first.charAt(i) == second.charAt(j)) {
					if (i > 0 && j > 0) {
						table[i][j] = table[i - 1][j - 1] + 1;
					} else {
						table[i][j] = 1;
					}
				} else {
					if (i > 0 && j > 0) {
						table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
					} else if (j > 0) {
						table[i][j] = table[i][j - 1];
					} else {
						table [i][j] = 0;
					}
				}
			}
		}
		
		return table[first.length() - 1][second.length() - 1];
	}
}
