package calculator;

import readers.Token;
import vectors.Vector;
import vectors.Vector2d;
import vectors.Vector3d;
import vectors.VectorNd;

import java.util.ArrayList;

public class Operand implements ICalculatable {
    private Vector vector = null;
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

            if (coordsArray.length == 2) {
                vector = new Vector2d(coordsArray[0], coordsArray[1]);
            } else if (coordsArray.length == 3) {
                vector = new Vector3d(coordsArray[0], coordsArray[1], coordsArray[2]);
            } else {
                vector = new VectorNd(coordsArray);
            }
        }else
        {
            number = new ComplexNumber(a.getText());
        }
    }

//    public String toString() {
//        String vectorStr = (vector == null)? "" : vector.toString();
//        String numberStr = (number == null)? "" : number.toString();
//
//        retun
//    }

}
