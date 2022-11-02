import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* Exercise Set
Create a set containing the colors of the rainbow and:

A. Display all colors one below the other
B. How many colors does the rainbow have
C. Display colors in alphabetical order
D. Display the colors in the reverse order of what was entered
E. Display all colors starting with the letter ”v”
F. Remove all colors that do not start with the letter “v”
G. Clean the set
H. Check if the set is empty
 */
public class RainbowExercise {

    public static void main(String[] args) {
        Set<String> rainbowColors = new LinkedHashSet<>() {
            {
                add("Red");
                add("Orange");
                add("Yellow");
                add("Green");
                add("Blue");
                add("Indigo");
                add("Violet");
            }
        };

        System.out.println("Display all colors one below the other:");
        for (String color : rainbowColors) {
            System.out.println(color);
        }
        System.out.println("===============================");

        System.out.println("How many colors does the rainbow have?: " + rainbowColors.size());
        System.out.println("===============================");

        System.out.println("Display colors in alphabetical order");
        Set<String> rainbowColorsAlphabeticalOrder = new TreeSet<>(rainbowColors);
        System.out.println(rainbowColorsAlphabeticalOrder);
        System.out.println("===============================");

        System.out.println("Display the colors in the reverse order of what was entered");
        List<String> rainbowColorsReverseOrder = new ArrayList<>(rainbowColors);
        Collections.reverse(rainbowColorsReverseOrder);
        System.out.println(rainbowColorsReverseOrder);
        System.out.println("===============================");

        System.out.println("Display all colors starting with the letter 'V'");
        Iterator<String> rainbowColorsIterator = rainbowColors.iterator();
        while (rainbowColorsIterator.hasNext()) {
            String color = rainbowColorsIterator.next();
            if (color.startsWith("V")) {
                System.out.println(color);
            }
        }
        System.out.println("===============================");

        System.out.println("Remove all colors that do not start with the letter 'v'");
        Iterator<String> rainbowColorsIterator2 = rainbowColors.iterator();
        while (rainbowColorsIterator2.hasNext()) {
            String color = rainbowColorsIterator2.next();
            if (!color.startsWith("V")) {
                rainbowColorsIterator2.remove();
            }
        }
        System.out.println(rainbowColors);
        System.out.println("===============================");

        System.out.println("Clean the set");
        rainbowColors.clear();
        System.out.println(rainbowColors);
        System.out.println("===============================");

        System.out.println("Check if the set is empty");
        System.out.println("Is it empty?: " + rainbowColors.isEmpty());
    }
}