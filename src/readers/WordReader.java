package readers;


import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by KatySolo on 29.10.17.
 */
public class WordReader implements IReadable {


    public Token tryReadToken(String input)
    {
        StringBuilder number = new StringBuilder();
        for (char symbol : input.toCharArray()) {
            if (!Character.isDigit(symbol) && !Character.isWhitespace(symbol)) {
                if (number.length() >= 0) {
                    number.append(symbol);
                }
            }
            else if (number.length() > 0) {
                return new Token("word", number.toString());
            }
            else
            {
                break;
            }
        }
        if (!Objects.equals(number.toString(), "")){
            return new Token("word", number.toString());
        }

        return null;
    }
}
