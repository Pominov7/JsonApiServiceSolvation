package org.top.jsonapiservicesolvation.messages;

// входное сообщение
public class InputMessage implements IMessage {

    public double a;
    public double b;
    public double y;

    public InputMessage(double a, double b, double y) {
        this.a = a;
        this.b = b;
        this.y = y;
    }

    @Override
    public String toString() {
        return "\n сторона треугольника a = " + a +
                "\n сторона треугольника b = " + b +
                "\n угол треугольника y = " + y;
    }
}


