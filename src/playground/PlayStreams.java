package playground;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PlayStreams {

    public void run() {

        List<Form> forms = new ArrayList<Form>();
        forms.add(new Form());
        forms.add(new Form());
        forms.add(new Form());
//        isValidForms(forms);
//        List<String> words = new ArrayList<>(List.of("apple", "banana", "carrots", "big", "g", "", " ", "pig", "rig", "st**ar", "*s*t*a*r*"));
//        for (String word: words) {
//            System.out.println("Current word: " + word);
//        }
//
//        words.forEach(word -> System.out.println("Current word: " + word));
//        System.out.println(usingCollections(words));
//        System.out.println("------------");
//        System.out.println(usingStreams(words));
//        words.stream()
//                .forEach(word -> System.out.println("Current word: " + word));
//
//        words.stream()
//                .forEachOrdered(word -> System.out.println("Current word: " + word));

//        List<Integer> numbers = new ArrayList<>();
//        for (int i = -50; i <= 100; i++) {
//            numbers.add(i);
//        }
//        moreStreams(numbers);
    }

//    private boolean isValidForms(List<Form> forms) {
//        boolean isValid = true;
//        for (Form f : forms) {
//            if (!isValidForm(f)) {
//                isValid = false;
//            }
//        }
//        return isValid;
//    }

//    private boolean isValidForms(List<Form> forms) {
//
//        List<Integer> streams = new ArrayList<>();
//        streams.stream().allMatch(i -> i > 0);
//
//        return forms.stream().allMatch(form ->
//                isValidFirstName(form.getFirstName()) &&
//                isValidLastName(form.getLastName()) &&
//                form.isAgreeToTOC());
//        List<Node> transformedNodes =
//                nodes.streams().map(this::transformNode).toList();
//    }
//
//    private boolean isValidForm(Form form) {
//
//    }

    private List<String> usingCollections(List<String> words) {
        List<String> transformedList = new ArrayList<>();
        for (String word : words) {
            if (!word.isBlank()) {
                String s = word.replaceAll("\\*", "");
                if (word.endsWith("g")) {
                    s += "ly";
                }

                transformedList.add(s);
            }
        }

        return transformedList;
    }

    private List<String> usingStreams(List<String> words) {
        return words.stream()
                .filter(word -> !word.isBlank())
                .map(word -> word.replaceAll("\\*", ""))
                .map(word -> (word.endsWith("g")) ? word + "ly" : word)
                .toList();
    }

    private void moreStreams(List<Integer> numbers) {

        Supplier<IntStream> supplier =
                () -> numbers.stream().mapToInt(num -> num);

        int max = supplier.get().max().orElse(0);
        int min = supplier.get().min().orElse(0);
        double avg = supplier.get().average().orElse(0.0);
        int sum = supplier.get().sum();

        boolean anyMatch = supplier.get().anyMatch(i -> i == 10);
        boolean allMatch = supplier.get().allMatch(i -> i < 200);
        boolean noneMatch = supplier.get().noneMatch(i -> i > 1000);

        System.out.println("anyMatch: " + anyMatch);
        System.out.println("allMatch: " + allMatch);
        System.out.println("noneMatch: " + noneMatch);

        boolean match = false;

        for (int i : numbers) {
            if (i == 10) {
                match = true;
                break;
            }
        }
//        supplier.get()
//                .filter(i -> i > 30 && i < 40)
//                .peek(System.out::print)
//                .map(i -> i/2)
//                .toArray();

//        System.out.println("max: " + max);
//        System.out.println("min: " + min);
//        System.out.println("avg: " + avg);
//        System.out.println("sum: " + sum);
    }

}
