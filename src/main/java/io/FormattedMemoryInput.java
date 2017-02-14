package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by wangqi on 17/2/13.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(
                                    "FormattedMemoryInput.java"
                            ).getBytes()));
            while (true)
                System.out.print((char)in.readByte());
        } catch (IOException e) {
            System.err.println("End of stream");
        }
    }
}
