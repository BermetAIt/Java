import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.BiFunction;
/* //1
@FunctionalInterface
interface MathOperation{
    int operate(int a , int b);
}
public class Exercises {
    public static void main(String[] args) {
        MathOperation addition = (a,b) -> a + b;
        MathOperation subtraction = (a,b) -> a - b;
        MathOperation multiplication = (a,b) -> a * b;
        MathOperation division = (a,b) -> a / b;

        System.out.println("Addition: " + addition.operate(7,3));
        System.out.println("Subtraction: " + subtraction.operate(7,3));
        System.out.println("Multiplication: " + multiplication.operate(7,3));
        System.out.println("Division: " + division.operate(9,3));
    }
}
*/
/* //2
public class Exercises{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 40, 55);
        Predicate<Integer> isOdd = num -> num % 2 != 0;

        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (isOdd.test(num)) {
                oddNumbers.add(num);
            }
        }

        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
 */
/* //3
public class Exercises {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Elina", "Sumaya", "Bermet", "Adina");

        names.sort((name1, name2) -> name2.compareTo(name1));

        System.out.println("Sorted Names: " + names);
    }
}
 */ //4
/*
public class Exercises {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "java", "lambda");

        Function<String, String> transform = s -> new StringBuilder(s.toUpperCase()).reverse().toString();

        List<String> transformedWords = new ArrayList<>();
        for (String word : words) {
            transformedWords.add(transform.apply(word));
        }

        System.out.println("Transformed Strings: " + transformedWords);
    }
}
 */
//5
/*
public class Exercises {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("New York", "London", "Tokyo", "Berlin");

        Consumer<String> printCity = city -> System.out.println(city);

        cities.forEach(printCity);
    }
}
*/
//6
/*
public class Exercises {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("New York", "London", "Tokyo", "Berlin");

        cities.forEach(System.out::println);
    }
}
 */
//7


public class Exercises {
    public static void main(String[] args) {
        int a = 25, b = 40;
        BiFunction<Integer, Integer, Integer> maxFunction = (x, y) -> Math.max(x, y);
        BiFunction<Integer, Integer, Integer> minFunction = (x, y) -> Math.min(x, y);

        System.out.println("Max: " + maxFunction.apply(a, b));
        System.out.println("Min: " + minFunction.apply(a, b));
    }
}
