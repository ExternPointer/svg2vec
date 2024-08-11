package org.example;

import com.android.ide.common.vectordrawable.Svg2Vector;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            Path svgTempFile = Files.createTempFile("input", ".svg");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = Files.newBufferedWriter(svgTempFile);

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            String result = Svg2Vector.parseSvgToXml(svgTempFile.toFile(), outStream);

            System.out.println(result);

            System.out.println(outStream);

            Files.deleteIfExists(svgTempFile);

        } catch (IOException ignored) {
        }
    }
}