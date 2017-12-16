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


    public Operand Calculate(String input) throws Exception
    {
        if (!isCorrectBrackets(input))
        {
            throw new Exception("Wrong input format");
        }

        ArrayList<Token> tokens = lexer.tokenize(input);
        ArrayList<Token> output = new ArrayList<>();
        try {
            output = GetExpression(tokens); //Преобразовываем выражение в постфиксную запись
            return Counting(output);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(output);
        return new Operand(new Token("double","0"));

    }

    public Operand Counting(ArrayList<Token> input) throws Exception //TODO think about performing operations
    {
        Operand result = null; //Результат
        Stack<Operand> temp = new Stack<>(); //Dhtvtyysq стек для решения

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
                temp.push(new Operand(token)); //Записываем в стек
//                i--;
            } else if (type.equals("operation")) //Если символ - оператор //TODO check the availability of operation
            {
                //Берем два последних значения из стека
                Operand a = temp.pop();
                Operand b = temp.pop();

                switch (token.getText()) //todo make methods
                {
                    case "+":
                        result = a.Add(b);
                        break;
                    case "-":
                        result = a.Sub(b);
                        break;
                    case "*":
                        result = a.Mul(b);
                        break;
                    case "^":
                        result = a.Pow(b);
                        break;

                }
                temp.push(result);//Результат вычисления записываем обратно в стек
//                }
//                else {
//                    throw new Exception("Can not perform the action");
//                }
            }
        }
        return temp.peek(); //Забираем результат всех вычислений из стека и возвращаем его
    }



}