package playground;

import java.util.ArrayList;
import java.util.List;

public class BuyTransaction implements Transaction {

    private String tx;

    public BuyTransaction(String tx) {
        this.tx = tx;
    }

    @Override
    public void print() {
        System.out.println(tx);
    }

    public void run() {
        List<Integer> is = new ArrayList<>();
        is.add(transform("zero", 4));
        is.add(transform("half", 4));
        is.add(transform("double", 4));
        is.add(transform("triple", 4));
        is.add(transform("square", 4));
        is.add(transform("powOf2", 4));
        System.out.println(is);
    }

    private int transform(String key, int number) {
        int transformed = 0;
        switch (key) {
            case "zero" -> transformed = 0;
            case "half" -> transformed = number/2;
            case "double" -> transformed = number*2;
            case "triple" -> transformed = number*3;
            case "square" -> transformed = number*number;
            default -> System.err.println("Error key not handled: " + key);
        }
        return transformed;

        // playing around with streams? Java streams?
    }

}
