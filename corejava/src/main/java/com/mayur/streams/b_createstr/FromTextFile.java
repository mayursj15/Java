package com.mayur.streams.b_createstr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FromTextFile {

    /***
     *
     * create stream from file
     *
     **/

    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Mayur\\work\\coding\\Java\\corejava\\src\\main\\java\\com\\mayur\\streams\\createstr\\firstName.txt");
        try (Stream<String> lines = Files.lines(path);) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw e;
        }

    }
}
