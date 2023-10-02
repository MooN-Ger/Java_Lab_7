import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDemo {
    public static void writeIntArrayToBinaryStream(OutputStream outputStream, int[] arr) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            for (int value : arr) {
                dataOutputStream.write(value);
            }
        }
    }
    public static int[] readIntArrayFromBinaryStream(InputStream inputStream, int[] arr) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = dataInputStream.read();
            }
            return arr;
        }
    }
    public static void writeIntArrayToCharStream(Writer writer, int[] arr) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (int i = 0; i < arr.length; i++) {
                bufferedWriter.write(String.valueOf(arr[i]));
                if (i < arr.length - 1) {
                    bufferedWriter.write(" ");
                }
            }
        }
    }
    public static int[] readIntArrayFromCharStream(Reader reader, int[] arr) throws IOException {
        try (BufferedReader stringReader = new BufferedReader(reader)) {
            String[] stringArr = stringReader.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(stringArr[i]);
            }
            return arr;
        }
    }
    public static int[] readIntArrayFromFileStartPos(String filename, int[] arr, int startPos) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "r")) {
            if (arr.length + startPos >= randomAccessFile.length()) throw new IllegalArgumentException();
            randomAccessFile.seek(startPos*2L);
            String[] stringArr = randomAccessFile.readLine().split(" ");
            for (int i = 0; i < arr.length && i < stringArr.length; i++) {
                arr[i] = Integer.parseInt(stringArr[i]);
            }
            return arr;
        }
    }

    public static ArrayList<File> getFilesInDirectoryWithGivenExtension (String directoryName, String extension) {
        File[] filesArr = new File(directoryName).listFiles(File::isFile);
        if (filesArr == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<File> fileList = new ArrayList<File>();
        Arrays.stream(filesArr).filter(x->x.getName().endsWith("." + extension)).forEach(fileList::add);

        return fileList;
    }

}
