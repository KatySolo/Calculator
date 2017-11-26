package readers;

import java.util.ArrayList;
import java.util.Objects;

public class ComplexNumberReader implements IReadable {

    @Override
    public Token tryReadToken(String s) {
        //4+1+2i+4 = 5+2i
        //2i+1-3i
        String[] splitedWord = s.split("[+-]");
        int pointer = 0;
        String sign = "+";
        String complexNumber;
        for (String part : splitedWord)
        {
            if (Objects.equals(part, "")){
                break;
            }
            if (part.contains("i") && splitedWord.length > 1)
            {
                if (pointer != 0)
                {
                    int index = s.indexOf(part)-1;
                    sign = s.substring(index,index+1);
                    complexNumber = splitedWord[pointer - 1] + sign + part;
                }
                else
                {
                    complexNumber = part;
                }
                return new Token("complex",complexNumber);

            }
            pointer += 1;
        }
//
           return null;

//        StringBuilder real_part = new StringBuilder();
//        StringBuilder imaginary_part = new StringBuilder();
//        Boolean isImaginary= false;
//        Boolean isReal = true;
//        for (char letter : s.toCharArray())
//        {
//            if (letter == '+')
//            {
//                isImaginary = true;
//                isReal = false;
//                continue;
//            }
//            if (Character.isDigit(letter) && isReal)
//            {
//                real_part.append(letter);
//                continue;
//            }
//            if (Character.isDigit(letter) && isImaginary)
//            {
//                imaginary_part.append(letter);
//                continue;
//            }
//        }
    }
}
