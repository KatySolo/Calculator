package readers;

import org.junit.Test;
import vectors.Vector;
import vectors.VectorNd;

/**
 * Created by KatySolo on 15.10.17.
 */

public class Token {

    private final Object value;
    private final String text;
    private final String type;

    public Token(String type, String text, Object value)
    {
        this.type = type;
        this.value = value;
        this.text = text;
    }

    public Token()
    {
        value = null;
        text= "";
        type = "undefined";
    }
    public Token(String type, String text)
    {
        this(type, text, text);
    }

    public Object getValue()
    {
        return value;
    }

    public String getType()
    {
        return type;
    }

    public String getText()
    {
        return text;
    }
    @Override
    public String toString()
    {
        return type + "[" + text + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        Token other = (Token) obj;
        return type.equals(other.type) && value.equals(other.value)
                && text.equals(other.text);
    }

//    public String Add (Token a) {
//        switch (type)
//        {
//            case "int":
//                return Integer.toString(Integer.parseInt(text) + Integer.parseInt(a.getText()));
//            case "double":
//                return Double.toString(Double.parseDouble(text) + Double.parseDouble(a.getText()));
//            case "complex":
////                String[] splittedFirst = text.split("\\+-");
////                String[] splittedSecond = a.getText().split("\\+-");
//                return "";
//            case "vector":
//                VectorNd vector1 = new VectorNd();
//                VectorNd vector2 = new VectorNd();
//                VectorNd vector3 = vector1.add(vector2);
//                return null;
//
//        }
//    }
}
