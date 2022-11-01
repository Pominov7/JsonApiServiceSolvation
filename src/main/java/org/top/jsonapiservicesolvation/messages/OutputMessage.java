package org.top.jsonapiservicesolvation.messages;

// сообщение результата (выходное сообщение)
public class OutputMessage implements IMessage {

    public double thirdParty;  // третья сторона треугольника

    public OutputMessage(double thirdParty) {
        this.thirdParty = thirdParty;

    }

    @Override
    public String toString() {
        return "Третья сторона треугольника = " + thirdParty;
    }
}
