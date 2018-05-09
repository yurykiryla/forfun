package problems.p006;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * 
 * @author Yury_Kiryla
 *
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows < 1) {
            return "";
        }
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        @SuppressWarnings("unchecked")
		List<Character>[] resultArray = new List[numRows];
        
        for (int i = 0; i < numRows; i++) {
            resultArray[i] = new ArrayList<Character>();
        }
        
        boolean down = true;
        int offset = 0;
        for (int i = 0; i < s.length(); i++) {
            if (down) {
                resultArray[(i - offset) % numRows].add(s.charAt(i));
                if ((i - offset) % numRows == numRows - 1) {
                    down = false;
                }
            } else {
                resultArray[numRows - ((i - offset) % numRows) - 2].add(s.charAt(i));
                if (numRows - ((i - offset) % numRows) - 2 == 0) {
                    down = true;
                    offset = i % numRows;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> line : resultArray) {
            for (char c : line) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
