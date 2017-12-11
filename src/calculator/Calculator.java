package calculator;

import lexer.Lexer;
import readers.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Calculator {

    private Lexer lexer = new Lexer();
    public Calculator(){
        lexer.register(new ComplexNumberReader());
        lexer.register(new VectorReader());
        lexer.register(new OperationReader());
        lexer.register(new WhitespaceReader());
        lexer.register(new DoubleReader());
        lexer.register(new IntReader());
        lexer.register(new BracketReader());
    }
    static private Boolean IsDelimeter(char c)
    {
        return (" =".indexOf(c) != -1);
    }

    static private Boolean IsOperator(char с)
    {
        return ("+-/*^()".indexOf(с) != -1);
    }

    static private int GetPriority(String s)
    {
        switch (s)
        {
            case "(": return 0;
            case "[": return 0;
            case "{": return 0;
            case ")": return 1;
            case "]": return 1;
            case "}": return 1;
            case "+": return 2;
            case "-": return 3;
            case "*": return 4;
            case "/": return 4;
            case "^": return 5;
            default: return 6;
        }
    }

    public Token Calculate(String input) throws Exception
    {
        if (!isCorrectBrackets(input))
        {
            throw new Exception("Wrong input format");
        }

        ArrayList<Token> tokens = lexer.tokenize(input);
        ArrayList<Token> output = new ArrayList<>();
        ComplexNumber cp = new ComplexNumber("2+3i");
        try {
            output = GetExpression(tokens); //Преобразовываем выражение в постфиксную запись
            return Counting(output);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(output);
        return new Token("double","0");

    }

    public Token Counting(ArrayList<Token> input) throws Exception //TODO think about performing operations
    {
        Token result = new Token(); //Результат
        Stack<Token> temp = new Stack<>(); //Dhtvtyysq стек для решения

        for (Token token : input) //Для каждого символа в строке
        {
            String type = token.getType();
            //Если символ - цифра, то читаем все число и записываем на вершину стека
            if (!type.equals("operation") && !type.endsWith("bracket")) {
//                String a = "";
//
//                while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i))) //Пока не разделитель
//                {
//                    a += input.charAt(i); //Добавляем
//                    i++;
//                    if (i == input.length()) break;
//                }
                temp.push(token); //Записываем в стек
//                i--;
            } else if (type.equals("operation")) //Если символ - оператор //TODO check the availability of operation
            {
                //Берем два последних значения из стека
                Token a = temp.pop();
                Token b = temp.pop();

                switch (token.getText())
                {
//                    case "+":
//                        return new Token(a.getType(), a.Add(b));
//                    case "-":
//                        return new Token(a.getType(), a.Sub(b));
//                    case "*":
//                        return new Token(a.getType(), a.Mul(b));
//                    case "^":
//                        return new Token(a.getType(), a.Pow(b));

                }
//                result = PerformCalculations(token.getText(), a,b);
//                boolean isAvailable = CheckAvailability(a,b);
//                if (isAvailable) { // TODO rewrite the operation logic
//                switch (token.getText()) //И производим над ними действие, согласно оператору
//                {

//                    case "+":
//                        result = new Token("double", Double.toString(Double.parseDouble(b.getText()) + Double.parseDouble(a.getText())));
//                        break;
//                    case "-":
//                        result = new Token("double", Double.toString(Double.parseDouble(b.getText()) - Double.parseDouble(a.getText())));
//                        break;
//                    case "*":
//                        result = new Token("double", Double.toString(Double.parseDouble(b.getText()) * Double.parseDouble(a.getText())));
//                        break;
//                    case "/":
//                        result = new Token("double", Double.toString(Double.parseDouble(a.getText()) / Double.parseDouble(b.getText())));
//                        break;
//                    case "^":
//                        result = new Token("double",Double.toString(Math.pow(Double.parseDouble(a.getText()),Double.parseDouble(b.getText()))));
//                            result = Double.parseDouble(String.valueOf(Math.pow(
//                                    Double.parseDouble(String.valueOf(b)),
//                                    Double.parseDouble(String.valueOf(a)))));
//                        break;
//                }
                temp.push(result);//Результат вычисления записываем обратно в стек
//                }
//                else {
//                    throw new Exception("Can not perform the action");
//                }
            }
        }
        return temp.peek(); //Забираем результат всех вычислений из стека и возвращаем его
    }


    private boolean CheckAvailability (Token a, Token b) {
        String type_a = a.getType();
        String type_b = b.getType();

        return !(Objects.equals(type_a, "vector") && Objects.equals(type_b, "double")) &&
                !(Objects.equals(type_a, "double") && Objects.equals(type_b, "vector"));
    }
    public ArrayList<Token> GetExpression(ArrayList<Token> input) throws Exception
    {
        ArrayList<Token> output = new ArrayList<>(); //Строка для хранения выражения
        Stack<Token> operStack = new Stack<>(); //Стек для хранения операторов

        for (Token token : input) {
            String type = token.getType();
            //for (int i = 0; i < input.length(); i++) //Для каждого символа в входной строке
            {
                //Разделители пропускаем
                //if (IsDelimeter(input.charAt(i)))
                if (type.equals("whitespace"))
                    continue; //Переходим к следующему символу

                //Если символ - цифра, то считываем все число
                //if (Character.isDigit(input.charAt(i))) //Если цифра
                if (!type.equals("operation") && !type.endsWith("bracket")) {
//                //Читаем до разделителя или оператора, что бы получить число
//                while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i)))
//                {
//                    output += input.charAt(i); //Добавляем каждую цифру числа к нашей строке
//                    i++; //Переходим к следующему символу
//
//                    if (i == input.length()) break; //Если символ - последний, то выходим из цикла
//                }

                    output.add(token); //Дописываем после числа пробел в строку с выражением
                    //i--; //Возвращаемся на один символ назад, к символу перед разделителем
                } else
                //Если символ - оператор
                //if (IsOperator(input.charAt(i)))//Если оператор
                {
                    if (Objects.equals(type,"open bracket")) //Если символ - открывающая скобка
                        operStack.push(token); //Записываем её в стек
                    else if (Objects.equals(type,"closing bracket")) //Если символ - закрывающая скобка
                    {
                        //Выписываем все операторы до открывающей скобки в строку
                        Token s = operStack.pop();

                        String openBr;
                        String closeBr = token.getText();

                        switch (closeBr){
                            case ")":
                                openBr = "(";
                                break;
                            case "]":
                                openBr="[";
                                break;
                            case "}":
                                openBr = "{";
                                break;
                            default:
                                throw new Exception("I do not know this type of brackets");
                        }

                        while (!s.getText().equals(openBr)) {
                            output.add(s);
                            s = operStack.pop();
                        }
                    } else //Если любой другой оператор
                    {
                        if (!operStack.empty()) //Если в стеке есть элементы
                            if (GetPriority(token.getText()) <= GetPriority(operStack.peek().getText())) //И если приоритет нашего оператора меньше или равен приоритету оператора на вершине стека
                                output.add(operStack.pop()); //То добавляем последний оператор из стека в строку с выражением

                        operStack.push(token); //Если стек пуст, или же приоритет оператора выше - добавляем операторов на вершину стека

                    }
                }
            }
        }

        //Когда прошли по всем символам, выкидываем из стека все оставшиеся там операторы в строку
        while (!operStack.empty())
            output.add(operStack.pop());

        return output; //Возвращаем выражение в постфиксной записи
    }

    private boolean isCorrectBrackets (String expression)
    {
        boolean isCorrect = true;
        String openBrackets = "([{";
        String closeBrackets = ")}]";

        Stack<CharSequence> stack = new Stack<>();
        for (int i =0; i < expression.length(); i++)
        {
            CharSequence bracket = Character.toString(expression.charAt(i));
            if (openBrackets.contains(bracket))
            {
                stack.push(bracket);
            }
            else if (closeBrackets.contains(bracket)){
                stack.pop();
            }
        }
        return stack.empty();
    }

}