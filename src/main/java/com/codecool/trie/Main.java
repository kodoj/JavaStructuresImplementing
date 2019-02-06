package com.codecool.trie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path worldListPath = new File("wordlist.txt").toPath();
        List<String> wordList = Files.readAllLines(worldListPath);

        AutoComplete ac = new AutoComplete();
        for (String word : wordList) {
            ac.addWord(word);
        }

        // Try to write tests to verify your code!
        System.out.println(ac.autoComplete("spectro"));
        System.out.println("done");
    }

}
