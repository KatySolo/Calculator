package lexer;

import readers.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by KatySolo on 15.10.17.
 */
public class Lexer {

    private static ArrayList<IReadable> readers = new ArrayList<IReadable>();

    public Lexer() {}

    public ArrayList<Token> tokenize(String s) throws Exception{ //// TODO: 20.11.17 покрытие интов и векторов пересекаются
        ArrayList<Token> tokens = new ArrayList<>();
        int length_prev = s.length();
        for (int i=0; i < s.length(); i++){
            Token token = AnalyzePart(s.substring(i));
            if (token != null){
                int shift = token.getText().length();
                i += shift-1;
                tokens.add(token);
            }
            else
            {
                throw new Exception("No reader");
            }
        }
//        while (!Objects.equals(s, "")) {
//            for (IReadable reader : readers) {
//                Token newToken = reader.tryReadToken(s);
//                if (newToken != null) {
//                    tokens.add(newToken);
//                    s = s.substring(newToken.getText().length());
//                    break;
//                }
//            }
//            if (length_prev == s.length()) {
//                throw new Exception("No reader");
//            }
//            length_prev = s.length();
//        }
        return tokens;

//        public Token[] Tokenize(String input) throws TokenNotRecognizedException{
//            ArrayList<Token> result = new ArrayList<>();
//            int len = input.length();
//            for (int i = 0; i < len; i++){
//                Token token = AnalyzePart(input.substring(i));
//                if (token != null){
//                    int step = token.getText().length();
//                    i += step - 1;
//                    result.add(token);
//                }
//                else
//                    throw new TokenNotRecognizedException("Unrecognized token (index: " + i + ")");
//            }
//            Token[] tokens = new Token[result.size()];
//            return result.toArray(tokens);
//        }

//        String str = s;
//        ArrayList<Token> tokens = new ArrayList<>();
//        for (IReadable reader : readers) {
//            ArrayList<Token> newTokens = reader.tryReadToken(str);
//            tokens.addAll(newTokens);
//            for (Token token : newTokens) {
//                if (Objects.equals(token.getType(), "vector")) {
//                    str = str.replace("("+token.getText().substring(1,token.getText().length()-1)+")","");
//                }
//                str = str.replace(token.getText(),"");
//            }
//            if (str.length() == 0){
//                break;
//            }

//            readers.sort(new Comparator<IReadable>() {
//                @Override
//                public int compare(IReadable o1, IReadable o2) {
////                    return priority[] > priority[o2]
//                }
//            });
        }


        //если один токен включает в себя какие то дургие токены, то вывести максимальный по длине
        // 1.2 должен вывести double, а не два int с точкой

    private Token AnalyzePart(String input){
        Token maxToken = null;
        for (IReadable reader : readers){
            Token token = reader.tryReadToken(input);
            if (token != null)
                if (maxToken == null || token.getText().length() > maxToken.getText().length())
                    maxToken = token;
        }
        return maxToken;
    }

    public void register(IReadable reader) {
        readers.add(reader);
//        priority[i] = reader;
//        i++;
    }

}
