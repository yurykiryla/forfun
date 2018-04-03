package grokaem.algoritmy.ch3;

import java.security.InvalidParameterException;

public class RecursiveFunctions {
    public int factorial(int x) {
        if (x < 1) {
            throw new InvalidParameterException();
        }

        if (x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }

    }
}
