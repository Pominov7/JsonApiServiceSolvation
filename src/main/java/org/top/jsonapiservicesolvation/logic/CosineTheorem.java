package org.top.jsonapiservicesolvation.logic;

import org.top.jsonapiservicesolvation.messages.InputMessage;
import org.top.jsonapiservicesolvation.messages.OutputMessage;

//Теорема косинусов
public class CosineTheorem implements ICosineTheorem {

    private double a; // сторона А треугольника
    private double b; // сторона B треугольника
    private double y; // угол Y треугольника в градусах

    @Override
    public OutputMessage findingTheThirdLine(InputMessage input) {
        double a = input.a;
        double b = input.b;
        double y = input.y;
        if (a <= 0 || b <= 0 || y <= 0) {
            return null;
        }
        double radian = Math.toRadians(y); // Преобразуем угол в градусах, в угол в радианах
        double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - (2 * a * b) * Math.cos(radian));
        return new OutputMessage(d);
    }
}




