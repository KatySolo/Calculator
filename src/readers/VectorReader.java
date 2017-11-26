package readers;


import java.util.ArrayList;

/**
 * Created by KatySolo on 29.10.17.
 */
public class VectorReader implements IReadable {

    public Token tryReadToken(String s) {
        //(1,2,3)
        ArrayList<Token> tokens = new ArrayList<>();
        StringBuilder numberBuilder =new StringBuilder();
       ArrayList<String> cords = new ArrayList<>();
        boolean isOpen = false;
        for (char letter : s.toCharArray())
        {
            if (letter == '('){
                isOpen = true;
                continue;
            }
            if (Character.isDigit(letter))
            {
                numberBuilder.append(letter);
                continue;
            }
            if (letter ==',' && numberBuilder.length() > 0)
            {
                cords.add(numberBuilder.toString());
                numberBuilder = new StringBuilder();
                continue;
            }
            if (letter == ')' && isOpen)
            {
                if (numberBuilder.length() >= 0){
                    cords.add(numberBuilder.toString());
                    numberBuilder = new StringBuilder();
                }
                String cords_string = cords.toString();
                return new Token("vector",cords_string.replace(" ",""));
            }
            else
            {
                break;
            }

        }
        return null;
    }

}
