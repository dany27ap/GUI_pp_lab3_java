package com.dlegacy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BackEnd {
    private String contentBook;
    private String nameOfFile;
    private String newBook;

    public BackEnd(String name){
        nameOfFile = name;
        File file = new File(nameOfFile);
        StringBuilder fileContents = new StringBuilder((int)file.length());

        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
        } catch (Exception e) {
            e.getMessage();
        }
        contentBook = fileContents.toString();
        newBook = contentBook;
    }

    public void printFile(){
        System.out.println(newBook);
    }

    public void mSpace(){
        newBook = contentBook.replaceAll("  +", " ");
    }

    public void mLine(){
        newBook = contentBook.replaceAll("\\n+", "\n");
    }

    public void noPage(){
        newBook = contentBook.replaceAll("\\s{3,}[0-9]+\\s*\\n", "\n");
    }

    public void mChapter(){
        newBook = contentBook.replaceAll("Chapter [0-9]+.*\n", "\n");
    }

    public void saveFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile));
            writer.write(newBook);
            writer.close();
        } catch (Exception e){
            e.getMessage();
        }
    }

}
