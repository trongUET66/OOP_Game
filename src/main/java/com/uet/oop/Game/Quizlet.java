package com.uet.oop.Game;

import com.uet.oop.model.Word;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import static com.uet.oop.model.Dictionary.dictionary;

public class Quizlet {
    public void runGame() {
        Random random = new Random();
        Set<Integer> chosenIndexes = new HashSet<>();

        String[] ansRan = new String[4];
        boolean status = true;
        int count = 1;

        while (status) {
            int index;
            do {
                index = random.nextInt(dictionary.size());
            } while (chosenIndexes.contains(index));
            chosenIndexes.add(index);
            Word word = dictionary.get(index);
            System.out.println("Question " + count + ": What does the word \"" + word.getTarget() + "\" mean?");

            for (int i = 1; i < 4; i++) {
                int randomIndex = random.nextInt(dictionary.size());
                ansRan[i] = dictionary.get(randomIndex).getExplain();
            }
            ansRan[0] = word.getExplain();
            for (int i = ansRan.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                String temp = ansRan[i];
                ansRan[i] = ansRan[j];
                ansRan[j] = temp;
            }

            System.out.println("[A] " + ansRan[0]);
            System.out.println("[B] " + ansRan[1]);
            System.out.println("[C] " + ansRan[2]);
            System.out.println("[D] " + ansRan[3]);

            String userAns;
            Scanner sc = new Scanner(System.in);
            System.out.print("Your Answer: ");
            userAns = sc.nextLine();
            switch (userAns) {
                case "A": {
                    if (!word.getExplain().equals(ansRan[0])) {
                        System.out.println("Incorrect! The correct meaning is: " + word.getExplain());
                        System.out.println("Score: " + (count-1));
                        status = false;
                    } else {
                        System.out.println("Correct!");
                        count++;
                    }
                    break;
                }
                case "B": {
                    if (!word.getExplain().equals(ansRan[1])) {
                        System.out.println("Incorrect! The correct meaning is: " + word.getExplain());
                        System.out.println("Score: " + (count-1));
                        status = false;
                    } else {
                        System.out.println("Correct!");
                        count++;
                    }
                    break;
                }
                case "C": {
                    if (!word.getExplain().equals(ansRan[2])) {
                        System.out.println("Incorrect! The correct meaning is: " + word.getExplain());
                        System.out.println("Score: " + (count-1));
                        status = false;
                    } else {
                        System.out.println("Correct!");
                        count++;
                    }
                    break;
                }
                case "D": {
                    if (!word.getExplain().equals(ansRan[3])) {
                        System.out.println("Incorrect! The correct meaning is: " + word.getExplain());
                        System.out.println("Score: " + (count-1));
                        status = false;
                    } else {
                        System.out.println("Correct!");
                        count++;
                    }
                    break;
                }
            }
        }
    }
}
