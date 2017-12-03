package tests;

import calculator.Calculator;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp()
    {
        calc = new Calculator();
    }

    @Test
    public void TestGetExpression (){
        //assertEquals("[int[2]]",calc.GetExpression(new ));
    }

}