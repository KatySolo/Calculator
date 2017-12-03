package main;

import calculator.Calculator;
import lexer.Lexer;
import vectors.*;
import readers.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {


    public static void main(String[] args) {
//        Lexer lexer = new Lexer();
//
//        lexer.register(new ComplexNumberReader());
//        lexer.register(new VectorReader());
//        lexer.register(new IntReader());
//        lexer.register(new OperationReader());
//        lexer.register(new WhitespaceReader());
//        lexer.register(new WordReader());
//        lexer.register(new VectorReader());
//        lexer.register(new DoubleReader());
//
//        try {
//            System.out.println(lexer.tokenize("2i+1-2i"));
//            System.out.println(lexer.tokenize("(1,2,3) + (2,4,6)"));
//            System.out.println(lexer.tokenize("String a = 'ccc'"));
//            System.out.println(lexer.tokenize("24 + 53 / 2"));
//            System.out.println(lexer.tokenize("2.4+4.5"));
//
//        } catch (Exception e) {
//            System.out.print(e.getMessage());
//        }

        Calculator calc = new Calculator();
        try {
//            System.out.println(calc.Calculate("2+3*4")); //14
//            System.out.println(calc.Calculate("(23+4)*2")); // 27*2 = 54
//            System.out.println(calc.Calculate("3^2 + 45 ")); //9+45 =  54
//            System.out.println(calc.Calculate("1+2i + 2+8i"));//3+10i
//            System.out.println(calc.Calculate("(1+2i)*(2+2i)"));
//            System.out.println(calc.Calculate("(1+2i)/(2+2i)"));
//            System.out.println(calc.Calculate("1+2i - 2+2i"));
//            System.out.println(calc.Calculate("2i+2+3i "));
//            System.out.println(calc.Calculate("(1,3,4)+(1,3,4)"));
//            System.out.println(calc.Calculate("(1,3,4)+(1,3,4,4)"));
//            System.out.println(calc.Calculate("(1,3,4)-(1,3,4)"));
//            System.out.println(calc.Calculate("(1,3,4)*4"));
            //System.out.println(calc.Calculate("1+2i+[(i,i,i)+(1,1,1)]+2i+1"));
            System.out.println(calc.Calculate("2*2+6-5"));
            System.out.println(calc.Calculate("2*(2+6)-5"));



        }
        catch (Exception e){
            System.out.println(e.getClass() + e.getMessage());
            e.printStackTrace();
        }

    }
}
///nfnnfnfnf

/*
примерно 6 ноября (13 если нет пары
lexer.Lexer l = new lexer.Lexer()
readers.Token[] tokens = tokenize()
1+2i+(i,i,i)+(1,1,1)+2i+1 = 2+4i+(1+i,1+i,1+i)
написать калькулятор векторов
любые скобки одного типа поддерживаются (отсылка к задачке про скобки)
отсутствие пробелов(заменить пробелы если есть на упстые скобки)
все операции возведения в степень
2 ридера: комплексный и векторный

 */

/*
4 задача
Translator в дргуой язык (это победа, товарищи)
Translator t = new Translator();
----> t.register(ILanguage, "key") // нечто что описывает данный язык и уникальный идентификатор
t.register(PascalLanguage, 'pascal')
t.register(JavaLanguage, 'java')
destination = t.translate(source, 'pascal', 'java') // откуда, куда

if, while, void main() {p()}
static void p {}

направить в обе стороны

механизм трансляции не должен зависить от конкретных языков (полная абстракция)
 */