package readers;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberReader implements IReadable {

    @Override
    public Token tryReadToken(String s) {
        //4+1+2i+4 = 5+2i
        //2i+1-3i
        if (!Character.isDigit(s.charAt(0))) {
            return null;
        }
        Pattern patternWhole = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)([-|+]+[0-9]+\\.?[0-9]?)[i$]+");
        Pattern patternImaginary = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)[i$]");
        Matcher m = patternWhole.matcher(s);
        Matcher m1 = patternImaginary.matcher(s);
        boolean result_whole = m.find();
        boolean result_imag = m1.find();

        if (!(result_imag || result_whole))
        {
            return null;
        }

        if (result_imag && !result_whole)
            return new Token("complex",m1.group());
        if (result_whole && !result_imag)
            return new Token("complex",m.group());

        if (m.start() < m1.start()) {
            return new Token("complex",m.group());
        }
        else
            return new Token("complex",m1.group());
    }
}
