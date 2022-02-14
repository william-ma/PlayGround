package playground;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private static final Map<String, Function<Integer, Integer>> transformMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("zero", i -> 0),
            new AbstractMap.SimpleEntry<>("half", i -> i/2),
            new AbstractMap.SimpleEntry<>("double", i -> i*2),
            new AbstractMap.SimpleEntry<>("triple", i -> i*3),
            new AbstractMap.SimpleEntry<>("square", i -> i*i),
            new AbstractMap.SimpleEntry<>("powOf2", i -> 2*i)
    );

    public static void main(String[] args) {

        new PlayStreams().run();

//        new BuyTransaction("").run();
//        Function<Integer, Integer> f = i -> 0;
//        if (transformMap.containsKey("zero")) {
//            System.out.println(transformMap.get("zero").apply(4));
//            System.out.println(transformMap.get("half").apply(4));
//            System.out.println(transformMap.get("double").apply(4));
//            System.out.println(transformMap.get("square").apply(4));
//            System.out.println(transformMap.get("powOf2").apply(4));
//        }




//        List<String> fruits = new ArrayList<>(List.of(
//                "apple",
//                "banana",
//                "carrot",
//                "lemon",
//                "lime",
//                "strawberry",
//                "raspberry",
//                "pear",
//                "blueberry",
//                "watermelon"
//        ));

//        usingAnonymousClasses(fruits);
//        usingLambdas(fruits);

//        callGreeting(new Greeting() {
//            @Override
//            public void greet() {
//                System.out.println("Hi Friend!");
//            }
//        });
//
//        callGreeting(() -> System.out.println("Hi Friend!"));
    }

    private static void usingAnonymousClasses(List<String> words) {
        List<String> beginsWithA = words
                .stream()
                .filter(new Predicate<>() {
                    @Override
                    public boolean test(String s) {
                        return !s.isEmpty() && s.charAt(0) == 'a';
                    }
                })
                .toList();

        beginsWithA.forEach(new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println("This word begins with 'a': " + s);
            }
        });
    }

    private static void usingLambdas(List<String> words) {
        List<String> beginsWithA = words
                .stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> s.charAt(0) == 'a')
                .toList();

        beginsWithA.forEach(s -> System.out.println("This word begins with 'a': " + s));
    }

    private static void callGreeting(Greeting myInterface) {
        myInterface.greet();
    }


}
