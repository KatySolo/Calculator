package calculator;

import readers.Token;

import java.io.Console;
import java.util.logging.ConsoleHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber {

    private double Real = 0;
    private char Sign = ' ';
    private double Imaginary = 0;


    public ComplexNumber (String number)
    {
        String[] separatedParts = number.split("\\+");
        if (separatedParts.length == 1)
        {
            separatedParts = number.split("-");
            Sign = '-';
        }
        else {
            Sign = '+';
        }
        Real = Double.parseDouble(separatedParts[0]);
        Imaginary = Double.parseDouble(separatedParts[1].substring(0,separatedParts[1].length()-1));

    }
    public ComplexNumber (double real, char sign, double imaginary){
        Real = real;
        Sign = sign;
        Imaginary = imaginary;
    }


    public double getRealPart(){return Real;}
    public double getSign(){return Sign;}
    public double getImaginaryPart(){return Imaginary;}

    public String toString()
    {
        return String.format("{%a}{%c}{%a}i",Real,Sign,Imaginary);
    }

    public ComplexNumber Add(ComplexNumber a)
    {


    }

    public ComplexNumber Sub (ComplexNumber a)
    {
        return null;
    }

    public ComplexNumber Mul (ComplexNumber a)
    {
        return null;
    }

    public ComplexNumber Pow (ComplexNumber a)
    {
        return null;
    }



}
