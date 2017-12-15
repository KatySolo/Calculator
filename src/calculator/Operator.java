package calculator;

public class Operator implements ICalculatable{

    private Character operator;

    public Operator(String input){
        operator = input.charAt(0);
    }

    public Character getOperator() {return operator;}
}
