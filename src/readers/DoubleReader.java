package readers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleReader implements IReadable {

    @Override
    public Token tryReadToken(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            return null;
        }
        Pattern pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
        Matcher m = pattern.matcher(s);
        boolean result = m.find();
        if (!result)
        {
            return null;
        }

        return new Token("double",m.group());

    }
}
