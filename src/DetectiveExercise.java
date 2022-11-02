import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/* Exercise Lists
Using lists, write a program that asks 5 questions for a
person about a crime. The questions are:

"Did you call the victim?"
"Were you at the crime scene?"
"Do you live near the victim?"
"Did you owe money to the victim?"
"Have you ever worked with the victim?"

If the person answers positively to 2 questions, he/she should be
classified as "Suspect", between 3 and 4 as "Accomplice" and 5 as
"Killer". Otherwise, he/she will be classified as "Innocent".
*/

public class DetectiveExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> answers = new ArrayList<String>();

        while (true) {
            String answer = "";
            clearScreen();
            System.out.println("---------------------------------");
            System.out.println("-    > Detective Exercise       -");
            System.out.println("-  Answer with a 'yes' or 'no'  -");
            System.out.println("---------------------------------");
         
            answer = getAnswer("Did you call the victim?", scanner);
            answers.add(answer);

            answer = getAnswer("Were you at the crime scene?", scanner);
            answers.add(answer);

            answer = getAnswer("Do you live near the victim?", scanner);
            answers.add(answer);

            answer = getAnswer("Did you owe money to the victim?", scanner);
            answers.add(answer);

            answer = getAnswer("Have you ever worked with the victim?", scanner);
            answers.add(answer);

            System.out.println("====================================");
            System.out.println("Verdict: " + giveVerdict(answers));
            System.out.println("====================================");
            System.out.println("Type anything to repeat the questions \n" +
                    "\t(or press enter to stop the program)");
            answers.clear();

            if (scanner.nextLine().equals(""))
                break;
        }

        scanner.close();
    }

    private static String getAnswer(String question, Scanner scanner) {
        String answer = "";

        do {
            System.out.println(" ");
            System.out.println(question);
            answer = scanner.nextLine();
            if (!checkIfIsAValidAnswer(answer))
                showErrorMessage();
        } while (!checkIfIsAValidAnswer(answer));

        return answer;
    }

    private static int getHowManyTimesItTypedYes(List<String> answers) {
        Iterator<String> pIterator = answers.iterator();
        int sumAnswerYes = 0;

        while (pIterator.hasNext()) {
            if (pIterator.next().trim().equalsIgnoreCase("yes")) {
                sumAnswerYes++;
            }
        }
        return sumAnswerYes;
    }

    private static String giveVerdict(List<String> perguntas) {
        int timesItTypedYes = getHowManyTimesItTypedYes(perguntas);

        if (timesItTypedYes == 2)
            return "Suspect";
        if (timesItTypedYes > 2 && timesItTypedYes < 5)
            return "Accomplice";
        if (timesItTypedYes == 5)
            return "Killer";
        else
            return "Innocent";
    }

    private static boolean checkIfIsAValidAnswer(String answer) {
        return answer.trim().equalsIgnoreCase("yes") ||
                answer.trim().equalsIgnoreCase("no");
    }

    private static void showErrorMessage() {
        System.out.println("Invalid answer! You must type only 'yes' or 'no'!");
    }

    private static void clearScreen() {
        for (int i = 0; i < 100; i++)
            System.out.println(" ");
    }
}