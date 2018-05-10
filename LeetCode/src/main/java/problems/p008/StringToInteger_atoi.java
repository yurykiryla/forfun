package problems.p008;

public class StringToInteger_atoi {
	
	public int myAtoi(String str) {
        int result = 0;
        boolean started = false;
        boolean negative = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!started && c == ' ') {
                continue;
            }
            if (!started && c == '-') {
                negative = true;
                started = true;
            } else if (!started && c == '+') {
                started = true;
            } else if (!started && Character.isDigit(c)) {
                started = true;
                int value = Character.getNumericValue(c);
                if (value != 0) {
                    result = negative ? -value : value;
                }
            } else if (Character.isDigit(c)) {
                int value = Character.getNumericValue(c);
                if (result == 0 && value != 0) {
                    result = negative ? -value : value;
                } else if (negative) {
                    int newResult = result * 10 - value % 10;
                    if ((newResult + value % 10) / 10 != result) {
                        result = Integer.MIN_VALUE;
                        break;
                    }
                    result = newResult;
                } else {
                    int newResult = result * 10 + value % 10;
                    if ((newResult - value % 10) / 10 != result || newResult < 0) {
                        result = Integer.MAX_VALUE;
                        break;
                    }
                    result = newResult;
                }
            } else {
                break;
            }
        }
        
        return result;
    }

}
