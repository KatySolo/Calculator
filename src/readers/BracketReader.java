package readers;

public class BracketReader implements IReadable {

    @Override
    public Token tryReadToken(String s) {
        CharSequence first_char = Character.toString( s.charAt(0));
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        if (openingBrackets.contains(first_char))
        {
            return new Token("open bracket",first_char.toString());
        }
        if (closingBrackets.contains(first_char))
        {
            return new Token("closing bracket", first_char.toString());
        }

        return null;
    }
}
