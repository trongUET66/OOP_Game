package com.uet.oop.Management;

import com.uet.oop.model.Question;
import com.uet.oop.model.Word;
import com.uet.oop.model.Dictionary;

import java.io.*;
import java.util.*;

import static com.uet.oop.model.Dictionary.dictionary;

public class FakeDictionaryManagement implements IDictionaryManagement {
    private final String filepath = System.getProperty("user.dir")
            + File.separator + "OOP_Game"
            + File.separator + "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "dictionary.txt";

    @Override
    public void insertWord() {
        Scanner getStringInput = new Scanner(System.in);
        Scanner getIntegerInput = new Scanner(System.in);
        int i = 0;
        int size = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the number of words: ");
                size = getIntegerInput.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                getIntegerInput.nextLine();
            }
        }
        while (i < size) {
            System.out.print("Enter Target: ");
            String target = getStringInput.nextLine();
            System.out.print("Enter Meaning: ");
            String meaning = getStringInput.nextLine();
            Word temp = new Word(target, meaning);
            dictionary.add(temp);
            i++;
        }
        Collections.sort(dictionary);
    }

    @Override
    public void removeWord(String target) {
        target = target.toLowerCase();
        Word tempWord = new Word(target, "");
        int index = -1;
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).getTarget().equals(target)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            dictionary.remove(dictionary.get(index));
            System.out.println("Bạn đã xóa: " + target + " ra khỏi từ ");
        } else {
            System.out.println("Từ bạn cần xoá không có trong từ điển!");
        }
    }

    @Override
    public void updateWord(Word word) {
        word.setTarget(word.getTarget().toLowerCase());
        String tempTarget = word.getTarget();
        int index = -1;
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).getTarget().equals(tempTarget)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            dictionary.set(index, word);
            System.out.print("Bạn đã cập nhật từ thành công");
        } else {
            System.out.println("Từ bạn cần xoá không có trong từ điển!");
        }
    }

    @Override
    public List<Word> getAllWord() {
        return dictionary;
    }

    @Override
    public Word lookup(String wordTarget) {
        Word result;
        wordTarget = wordTarget.toLowerCase();
        for (Word word : dictionary) {
            if (word.getTarget().toLowerCase().equals(wordTarget)) {
                result = word;
                return result;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Word> search(String wordTarget) {
        ArrayList<Word> result = new ArrayList<>();
        wordTarget = wordTarget.toLowerCase();
        for (Word word : dictionary) {
            if (word.getTarget().toLowerCase().contains(wordTarget)) {
                result.add(word);
            }
        }
        return result;
    }

    @Override
    public List<Question> mixGames() {
        return null;
    }

    @Override
    public void importFromFile() {
        try {
            File inFile = new File(filepath);
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.split("\t");
                Word temp = new Word(wordsInLine[0], wordsInLine[1]);
                dictionary.add(temp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportToFile() {
        try {
            File file = new File(filepath);
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (Word word : dictionary) {
                bufferedWriter.write(word.getTarget() + "\t" + word.getExplain() + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
