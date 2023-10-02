import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StreamDemoTest {

    @Test
    public void fileTestWriteIntArrayToBinaryStream() throws IOException{
        try (FileOutputStream outputStream = new FileOutputStream("test.txt")) {
            StreamDemo.writeIntArrayToBinaryStream(outputStream, new int[]{0, 1, 2, 3, 4});
            FileInputStream inputStream = new FileInputStream("test.txt");
            int[] resultArr = new int[5];
            StreamDemo.readIntArrayFromBinaryStream(inputStream, resultArr);
            int[] expectedArr = new int[]{0, 1, 2, 3, 4};
            assertArrayEquals(expectedArr, resultArr);
        }
    }

    @Test
    public void byteTestWriteIntArrayToBinaryStream() throws IOException{
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            StreamDemo.writeIntArrayToBinaryStream(outputStream, new int[]{0, 1, 2, 3, 4});
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            int[] resultArr = new int[5];
            StreamDemo.readIntArrayFromBinaryStream(inputStream, resultArr);
            int[] expectedArr = new int[]{0, 1, 2, 3, 4};
            assertArrayEquals(expectedArr, resultArr);
        }
    }

    @Test
    public void testReadIntArrayFromBinaryStream() throws IOException{
        try (FileOutputStream outputStream = new FileOutputStream("test.txt")){
            StreamDemo.writeIntArrayToBinaryStream(outputStream, new int[]{0, 1, 2, 3, 4});
        }
        try (FileInputStream inputStream = new FileInputStream("test.txt")) {
            int[] resultArr = new int[5];
            StreamDemo.readIntArrayFromBinaryStream(inputStream, resultArr);
            int[] expectedArr = new int[]{0, 1, 2, 3, 4};
            assertArrayEquals(expectedArr, resultArr);
        }
    }

    @Test
    public void testWriteIntArrayToCharStream() throws IOException{
        try(CharArrayWriter charArrayWriter = new CharArrayWriter()){
            int[] writerArr = new int[]{1, 2, 3};
            StreamDemo.writeIntArrayToCharStream(charArrayWriter, writerArr);
            char[] expectedArr = new char[]{'1', ' ', '2', ' ', '3'};
            assertArrayEquals(expectedArr, charArrayWriter.toCharArray());
        }
    }

    @Test
    public void testReadIntArrayFromCharStream() throws IOException{
        try(StringReader stringReader = new StringReader("1 2 3 4 5")){
            int[] resultArr = new int[5];
            StreamDemo.readIntArrayFromCharStream(stringReader, resultArr);
            int[] expectedArr = new int[]{1, 2, 3, 4, 5};
            assertArrayEquals(expectedArr, resultArr);
        }
    }

    @Test
    public void testReadIntArrayFromFileStartPos() throws IOException{
        try(FileWriter fileWriter = new FileWriter("test.txt")){
            StreamDemo.writeIntArrayToCharStream(fileWriter, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        }
        int[] resultArr = new int[5];
        int[] expectedArr = new int[]{5, 6, 7, 8, 9};
        assertArrayEquals(expectedArr, StreamDemo.readIntArrayFromFileStartPos("test.txt", resultArr, 5));
    }

    @Test
    public void testGetFilesInDirectoryWithGivenExtension() {
        ArrayList<File> expectedFileList = new ArrayList<File>();
        Collections.addAll(expectedFileList,
                new File("C://labs//lab 7.1//filetest//filetest1.txt"),
                new File("C://labs//lab 7.1//filetest//filetest3.txt")
                );

        assertEquals(expectedFileList, StreamDemo.getFilesInDirectoryWithGivenExtension("C://labs//lab 7.1//filetest", "txt"));

    }

}