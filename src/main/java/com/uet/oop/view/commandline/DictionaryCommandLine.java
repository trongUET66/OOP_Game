package com.uet.oop.view.commandline;


import com.uet.oop.controller.FakeDictionaryManagement;
import com.uet.oop.controller.IDictionaryManagement;
import com.uet.oop.model.Word;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandLine {

    IDictionaryManagement management;
    private final String filepath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "dictionary.txt";

    DictionaryCommandLine(IDictionaryManagement management) {
        this.management = management;
    }

    private final Scanner scanner = new Scanner(System.in);

    void runApp() {
        while (true) {
            dictionaryAdvanced();
            int input = getInput();
            if (input >= 0 && input <= 9) {
                handleInput(input);
            }
        }
    }

    private void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private void dictionaryAdvanced() {
        clearConsole();
        System.out.print(
                "Welcome to My Application!\n" +
                        "[0] Exit\n" +
                        "[1] Add\n" +
                        "[2] Remove\n" +
                        "[3] Update\n" +
                        "[4] Display\n" +
                        "[5] Lookup\n" +
                        "[6] Search\n" +
                        "[7] Game\n" +
                        "[8] Import from file\n" +
                        "[9] Export to file\n" +
                        "Your action: "
        );
    }

    private int getInput() {
        int result;
        try {
            result = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Action not supported");
            return -1;
        }
        if (result < 0 || result > 9) {
            System.out.println("Action not supported");
            return -1;
        }
        return result;
    }

    private void handleInput(int input) {
        clearConsole();
        switch (input) {
            case 0 -> System.exit(0);

            case 1 -> addWord();

            case 2 -> removeWord();

            case 3 -> updateWord();

            case 4 -> display();

            case 5 -> lookup();

            case 6 -> search();

            case 7 -> playGame();

            case 8 -> importFromFile();

            case 9 -> exportToFile();
        }
    }

    private void addWord() {
        clearConsole();
        System.out.print("Enter target: ");
        String target = scanner.nextLine();
        System.out.print("Enter explain: ");
        String explain = scanner.nextLine();
        management.insertWord(new Word(target, explain));
    }

    private void removeWord() {
        clearConsole();
        System.out.print("Enter target: ");
        String target = scanner.nextLine();
        management.removeWord(target);
    }

    private void updateWord() {
        clearConsole();
        System.out.print("Enter target: ");
        String target = scanner.nextLine();
        System.out.print("Enter explain: ");
        String explain = scanner.nextLine();
        management.updateWord(new Word(target, explain));
    }

    private void display() {
        clearConsole();
        List<Word> result = management.getAllWord();
        System.out.printf("| %-5s | %-30s | %-100s |\n", "No", "English", "Vietnamese");
        for (int i = 0; i < result.size(); i++) {
            Word word = result.get(i);
            System.out.printf("| %-5d | %-30s | %-100s |\n", i, word.getTarget(), word.getExplain());
        }
    }

    private void lookup() {
        clearConsole();
        System.out.print("Enter target: ");
        String target = scanner.nextLine();
        Word word = management.lookup(target);
        if (word == null) {
            System.out.println("Target not found!");
            return;
        }
        System.out.println("Found word: ");
        System.out.println("\tTarget: " + word.getTarget());
        System.out.println("\tExplain: " + word.getExplain());
    }

    private void search() {
        clearConsole();
        System.out.print("Enter target: ");
        String target = scanner.nextLine();
        List<Word> result = management.search(target);
        System.out.printf("| %-5s | %-30s | %-100s |\n", "No", "English", "Vietnamese");
        for (int i = 0; i < result.size(); i++) {
            Word word = result.get(i);
            System.out.printf("| %-5d | %-30s | %-100s |\n", i, word.getTarget(), word.getExplain());
        }
    }

    private void playGame() {

    }

    private void importFromFile() {
        management.importFromFile(filepath);
    }

    private void exportToFile() {
        management.exportToFile(filepath);
    }

}
