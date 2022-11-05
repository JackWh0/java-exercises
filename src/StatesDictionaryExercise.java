import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/* Exercise Map
Given the estimated population of some NE Brazilian states, do:

State = PE - Population = 9,616,621
State = AL - Population = 3,351,543
State = CE - Population = 9,187,103
State = RN - Population = 3,534,265

A. Create a dictionary and list the states and their populations;
B. Replace the population of the state of RN with 3,534,165;
C. Check if the PB state is in the dictionary, if not add: PB -
4,039,277;
D. Display the PE population;
Display all states and their populations in the order they were
informed;
E. Display states and their populations in alphabetical order;
F. Display the state with the smallest population and its amount;
G. Display the state with the largest population and its amount;
H. Display the sum of the population of all states;
I. Display the population mean of this states dictionary;
J. Remove states with population less than 4,000,000;
K. Clear the states dictionary;
L. Check if the dictionary is empty.
 */
public class StatesDictionaryExercise {
    public static void main(String[] args) {
        System.out.println("A. Create a dictionary and list the states and their populations");
        Map<String, Integer> statesDictionary = new HashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };

        displayStatesDictionary(statesDictionary);
        System.out.println("-------------------------------------------------");

        System.out.println("B. Replace the population of the state of RN with 3,534,165");
        statesDictionary.put("RN", 3534165);
        displayStatesDictionary(statesDictionary);
        System.out.println("-------------------------------------------------");

        System.out.println("C. Check if the PB state is in the dictionary, if not add: PB - 4,039,277");
        System.out.println("PB state is in the dictionary?: " + statesDictionary.containsKey("PB"));
        if (!statesDictionary.containsKey("PB")) {
            statesDictionary.put("PB", 4039277);
            System.out.println("Successfully added!");
        }
        displayStatesDictionary(statesDictionary);
        System.out.println("-------------------------------------------------");

        System.out.println("D. Display the PE population");
        System.out.printf("PE population: %,d\n", statesDictionary.get("PE"));
        System.out.println("-------------------------------------------------");

        System.out.println("E. Display states and their populations in alphabetical order");
        Map<String, Integer> statesAlphabeticalOrder = new TreeMap<>(statesDictionary);
        displayStatesDictionary(statesAlphabeticalOrder);
        System.out.println("-------------------------------------------------");

        System.out.println("F. Display the state with the smallest population and its amount");
        int smallestPopulation = Collections.min(statesDictionary.values());

        for (Entry<String, Integer> state : statesDictionary.entrySet()) {
            if (state.getValue() == smallestPopulation) {
                String stateName = state.getKey();
                System.out.printf("State = %s - Population = %,d\n", stateName, smallestPopulation);
                // Just in case there's more than one state with the same amount of population,
                // I won't break the for loop here.
            }
        }
        System.out.println("-------------------------------------------------");

        System.out.println("G. Display the state with the largest population and its amount");
        int largestPopulation = Collections.max(statesDictionary.values());
        for (Entry<String, Integer> state : statesDictionary.entrySet()) {
            if (state.getValue() == largestPopulation) {
                String stateName = state.getKey();
                System.out.printf("State = %s - Population = %,d\n", stateName, largestPopulation);
                // I won't break the for loop here for the same reason as before.
            }
        }
        System.out.println("-------------------------------------------------");

        System.out.println("H. Display the sum of the population of all states");
        int sumOfThePopulation = 0;
        for (Entry<String, Integer> state : statesDictionary.entrySet()) {
            sumOfThePopulation += state.getValue();
        }
        System.out.printf("Sum of all populations: %,d\n", sumOfThePopulation);
        System.out.println("-------------------------------------------------");

        System.out.println("I. Display the population mean of this states dictionary");
        double populationMean = sumOfThePopulation / statesDictionary.size();
        System.out.printf("Population mean: %,.2f\n", populationMean);
        System.out.println("-------------------------------------------------");

        System.out.println("J. Remove states with population less than 4,000,000");
        Iterator<Integer> statesIterator = statesDictionary.values().iterator();
        while (statesIterator.hasNext()) {
            Integer statePopulation = statesIterator.next();
            if (statePopulation < 4000000) {
                statesIterator.remove();
            }
        }
        displayStatesDictionary(statesDictionary);
        System.out.println("-------------------------------------------------");

        System.out.println("K. Clear the states dictionary");
        statesDictionary.clear();
        System.out.println(statesDictionary);
        System.out.println("-------------------------------------------------");

        System.out.println("L. Check if the dictionary is empty");
        System.out.println("Is it empty?: " + statesDictionary.isEmpty());
    }

    public static void displayStatesDictionary(Map<String, Integer> dictionary) {
        for (Entry<String, Integer> state : dictionary.entrySet()) {
            System.out.printf("State = %s - Population = %,d\n", state.getKey(), state.getValue());
        }
    }
}
