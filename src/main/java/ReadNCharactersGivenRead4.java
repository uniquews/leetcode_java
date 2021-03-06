/**
 * Created by shuaiwang on 4/2/17.
 */

// 这道题有一个没有说明白的暗示，read和read4在read一个固定的文件, 是要往buf写， 而不是往buf里读。
public class ReadNCharactersGivenRead4 {
    private int read4(char[] buf) {
        return 4;
    }


//    private int currentRead = 0;
//    private char[] bufferFor4 = new char[4];
//    private boolean endOfFile = false;
//
//    public int read(char[] buf, int n) {
//        while (currentRead < n) {
//            int readAtOneTime = read4(bufferFor4);
//            if (readAtOneTime < 4) {
//                endOfFile = true;
//            }
//
//            int len = Math.min(readAtOneTime, n - currentRead);
//            for (int i = 0; i < len; i++) {
//                buf[currentRead + i] = bufferFor4[i];
//            }
//            currentRead += len;
//            if (endOfFile)
//                break;
//
//        }
//        return currentRead;
//    }

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int ptr = 0;
        while (ptr < n) {
            int offsetInRead4 = 0;
            int currentRead = read4(buffer);
            if (currentRead == 0) {
                return ptr;
            }

            while (ptr < n && offsetInRead4 < currentRead) {
                buf[ptr++] = buffer[offsetInRead4++];
            }
        }
        return ptr;
    }


    // 模仿2的写法
//    private char[] buff = new char[4];
//    public int read(char[] buf, int n) {
//        if (n == 0)
//            return 0;
//        int current = 0;
//        int numOfCharReadFromFile = 0;
//        int actualRead = 0;
//        while (numOfCharReadFromFile < n) {
//            current = read4(buff);
//            if (current == 0)
//                break;
//
//            while (numOfCharReadFromFile < n && actualRead < current) {
//                buf[numOfCharReadFromFile++] = buff[actualRead++];
//            }
//            actualRead = 0;
//        }
//        return numOfCharReadFromFile;
//    }
}
