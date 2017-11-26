package readers;

import sun.tools.tree.CharExpression;

import java.util.ArrayList;

public class WhitespaceReader implements IReadable {

    @Override
    public Token tryReadToken(String s) {
        char[] letters = s.toCharArray();
        if (Character.isWhitespace(letters[0])){
            return new Token("whitespace",Character.toString(letters[0]));
        }
        return null;
    }
}
