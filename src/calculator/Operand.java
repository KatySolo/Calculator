package calculator;

import readers.Token;
import vectors.Vector;
import vectors.Vector2d;
import vectors.Vector3d;
import vectors.VectorNd;

import java.util.ArrayList;

public class Operand implements ICalculatable {
    private VectorNd vector = null;
    private ComplexNumber number = null;

    public Operand(Token a) {
        if (a.getType().equals("vector")) {
            String coords = a.getText();
            ArrayList<Integer> coordsList = new ArrayList<>();
            char[] coordsSplitted = coords.toCharArray();
            for (int i = 1; i < coordsSplitted.length - 1; i++) {
                if (coordsSplitted[i] != ',') {
                    coordsList.add(Integer.parseInt(String.valueOf(coordsSplitted[i])));
                }
            }
            int[] coordsArray = new int[coordsList.size()];
            for (int i = 0; i < coordsList.size(); i++) {
                coordsArray[i] = coordsList.get(i);
            }

//            if (coordsArray.length == 2) {
//                vector = new Vector2d(coordsArray[0], coordsArray[1]);
//            } else if (coordsArray.length == 3) {
//                vector = new Vector3d(coordsArray[0], coordsArray[1], coordsArray[2]);
//            } else {
                vector = new VectorNd(coordsArray);
        }else
        {
            number = new ComplexNumber(a.getText());
        }
    }

    public String GetType() {
        if (vector != null && number != null)
        {
            return "Compound";
        }
        if (vector == null)
        {
            if (number == null)
            {
                return "None";
            }
            else
            {
                return "Number";
            }
        }
        else
        {
            return "Vector";
        }
    }


    public Operand Add(Operand a) {
        ComplexNumber resultNumber;
        VectorNd resultVector;

        String fisrtType = GetType();
        String secondType = a.GetType();
        if (fisrtType == secondType)
        {
            switch (fisrtType)
            {
                case "number":
                    resultNumber = number.Add(a.number);
                    return new Operand(resultNumber.toToken());
                case "vector":
                    resultVector = vector.add(a.vector);
//                    return new Operand();
            }
        }
            return null;
    }

    public Operand Sub(Operand a) {
        return null;
    }

    public Operand Mul(Operand a) {
        return null;
    }

    public Operand Pow(Operand a) {
        return null;
    }

}
