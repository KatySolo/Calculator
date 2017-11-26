package readers;

import lexer.Lexer;

import java.util.ArrayList;
import java.util.Objects;

public class IntReader implements IReadable {

    public Token tryReadToken(String input) {
        StringBuilder number = new StringBuilder();
        for (char symbol : input.toCharArray()) {
            if (Character.isDigit(symbol)) {
                if (number.length() >= 0) {
                    number.append(symbol);
                }
            }
            else if (number.length() > 0) {
                return new Token("int", number.toString());
//                number = new StringBuilder();
            }
            else
            {
                break;
            }
        }
        if (!Objects.equals(number.toString(), "")){
            return new Token("int", number.toString());
        }

        return null;
    }
}