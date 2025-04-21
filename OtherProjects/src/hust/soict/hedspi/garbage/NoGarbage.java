package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String fileName = "src/hust/soict/hedspi/garbage/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(fileName));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        String outputString = outputStringBuilder.toString();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
