package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;


public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        /**
         * check file exists
         */
        Path homePath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));

        /**
         * delete file and check file not exists
         */
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Path p = Paths.get(HOME + "/playDelete.txt");
        Assertions.assertFalse(Files.exists(p));
        Files.createFile(p);
        Assertions.assertTrue(Files.exists(p));
        Files.delete(p);
        Assertions.assertFalse(Files.exists(p));

        /**
         * create directory
         */
        Files.createDirectory(playPath);
        Assertions.assertTrue((Files.exists(playPath)));

        /**
         * / create File
         */
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            Assertions.assertTrue(Files.exists(tempFile));
        });

        /**
         * List files, Directories as well as Files with Extension
         */
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);

    }

}
