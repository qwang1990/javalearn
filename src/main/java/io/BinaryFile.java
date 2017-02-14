package io;

import java.io.*;

/**
 * Created by wangqi on 17/2/13.
 */
public class BinaryFile {
    public static byte[] read(File bfile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bfile)
        );
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
}
