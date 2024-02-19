package com.examples;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileOperations {

    public static void main(String[] args) {
        File[] hiddenFiles = new File("D:\\2021\\coding\\data-structures-java").listFiles(File::isHidden);

        Stream<File> stream = Arrays.stream(hiddenFiles);

        stream.forEach(str -> System.out.println(str + " "));
    }
}
