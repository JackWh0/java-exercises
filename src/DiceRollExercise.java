import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

/* Map exercise
Write a program that simulates a dice roll.
Roll the die 100 times and store the values.
Then show how many times each value has appeared.
 */
public class DiceRollExercise {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> dieValues = new HashMap<Integer, Integer>(){{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};
        int numberOfTimes = 100;

        System.out.println("Rolling the die...");
        for(int i = 0; i < numberOfTimes; i++) {
            int dieNumber = random.nextInt(6) + 1;
            int amountOfTimesItHasAppeared = dieValues.get(dieNumber) + 1;

            System.out.println("Got the number " + dieNumber);
            dieValues.put(dieNumber, amountOfTimesItHasAppeared);
        }

        System.out.println("---- Results -----");
        System.out.println("Number \tAppeared");
        for (Entry<Integer, Integer> die : dieValues.entrySet()) {
            System.out.printf("  %d \t%d times \n", die.getKey(), die.getValue());
        }
    }
}