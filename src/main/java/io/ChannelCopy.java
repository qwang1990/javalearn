package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangqi on 17/2/14.
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream("data.txt").getChannel(),
                out = new FileOutputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

    }
}
