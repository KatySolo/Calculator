package calculator;

import readers.Token;

public class ComplexNumber implements ICalculatable{

    private double Real = 0;
    private double Imaginary = 0;


    public ComplexNumber (String number) //TODO check if it real or int ot without real part
    {
        char sign = '+';
        if (!number.contains("i"))
        {
            Real = Double.parseDouble(number);
            sign = '+';
            Imaginary = 0;

        } else {
            String[] separatedParts = number.split("\\+");
            if (separatedParts.length == 1) {
                separatedParts = number.split("-");
                sign = '-';
            } else {
                sign = '+';
            }
            Real = Double.parseDouble(separatedParts[0]);
            double unsignedImaginary = Double.parseDouble(separatedParts[1].substring(0, separatedParts[1].length() - 1));
            Imaginary = (sign == '+')? unsignedImaginary : (-1)*unsignedImaginary;

        }
    }
    public ComplexNumber (double real,double imaginary){
        Real = real;
        Imaginary = imaginary;
    }


    public double getRealPart(){return Real;}
    public double getImaginaryPart(){return Imaginary;}

    public String toString()
    {
        return String.valueOf(Real) + Imaginary + 'i';
    }

    public ComplexNumber Add(ComplexNumber a) //TODO create add methods
    {
        return new ComplexNumber(getRealPart()+a.getRealPart(), getImaginaryPart()+a.getImaginaryPart());
    }

    public ComplexNumber Sub (ComplexNumber a)
    {
        return new ComplexNumber(getRealPart()-a.getRealPart(), getImaginaryPart()-a.getImaginaryPart());
    }

    public ComplexNumber Div (ComplexNumber a)
    {
        double newRealPart= getRealPart()*a.getRealPart()+getImaginaryPart()*a.getImaginaryPart()/
                (Math.pow(a.getRealPart(),2)+Math.pow(a.getImaginaryPart(),2));
        double newImaginaryPart = a.getRealPart()*getImaginaryPart()-a.getImaginaryPart()*getRealPart()/
                (Math.pow(a.getRealPart(),2)+Math.pow(a.getImaginaryPart(),2));
        return new ComplexNumber(newRealPart, newImaginaryPart);

    }
    public ComplexNumber Mul (ComplexNumber a)
    {

        return new ComplexNumber((getRealPart()*a.getRealPart())-getImaginaryPart()*a.getImaginaryPart(),
                                getRealPart()*a.getImaginaryPart()+getImaginaryPart()*a.getRealPart());

    }

    public ComplexNumber Pow (ComplexNumber a, double pow)
    {
        return new ComplexNumber(Math.pow(a.getRealPart(),pow),0);
    }

    public Token toToken()
    {
        char sign ='-';
        if (Imaginary >= 0)
        {
            sign = '+';
        }
        String complexNum = Real + Character.toString(sign) + Imaginary;
        return new Token ("complex", complexNum);
    }




}
