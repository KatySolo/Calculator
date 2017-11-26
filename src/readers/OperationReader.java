package readers;


import java.util.ArrayList;

public class OperationReader implements IReadable {

    static char[] operations = new char[]{'+', '-', '*', '/'};

    public Token tryReadToken(String s) {
        char[] symbols = s.toCharArray();
        for (char operation : operations) {
            if (operation == symbols[0]) {
                return new Token("operation", Character.toString(symbols[0]));
            }
        }
        return null;
    }
}

