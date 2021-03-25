package homework4.IO;

import homework4.timer.TimerStopWatch;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.io.StreamTokenizer.TT_EOF;
import static java.io.StreamTokenizer.TT_WORD;

public class IOUtils {

    //читаем через FileInputStream имитируем буфер - прямая буферизация
    public byte[] readFileBytesWithCustomBuffer(File file) {
        TimerStopWatch.getInstance().startTime();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(file)) {
            int i;
            byte[] buf;
            do {
                buf = new byte[4096]; //можно поиграть размером массива байтов для ускроения чтения
                i = fis.read(buf);
                outputStream.write(buf);
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время получения массива байт: " + TimerStopWatch.getInstance().stopTime());
        return outputStream.toByteArray();
    }

    //читаем через readFileWithCustomBuffer имитируем буфер - прямая буферизация
    public String readFileWithCustomBuffer(File file) {
        TimerStopWatch.getInstance().startTime();
        String resultString = "";
        try (FileInputStream fis = new FileInputStream(file)) {
            int i;
            byte[] buf;
            do {
                buf = new byte[4096]; //можно поиграть размером массива байтов для ускроения чтения
                i = fis.read(buf);
                resultString = resultString.concat(new String(buf, StandardCharsets.UTF_8));
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время получения строкового типа: " + TimerStopWatch.getInstance().stopTime());
        return resultString;
    }

    //читаем через readFileWithDefaultBufferClass + прямая буферизация
    public String readFileWithDefaultBufferClass(File file) {
        TimerStopWatch.getInstance().startTime();
        String resultString = "";

        try (FileInputStream fis = new FileInputStream(file)) {
            BufferedInputStream buf = new BufferedInputStream(fis);
            int i;
            byte[] bytes = new byte[4096]; //можно снова менять буфер
            do {
                i = buf.read(bytes);
                resultString = resultString.concat(new String(bytes, StandardCharsets.UTF_8));
            } while (i != -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время получения строкового типа: " + TimerStopWatch.getInstance().stopTime());
        return resultString;
    }

    //читаем через readFileBytesWithDefaultBufferClass + прямая буферизация
    public byte[] readFileBytesWithDefaultBufferClass(File file) {
        TimerStopWatch.getInstance().startTime();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(file)) {
            BufferedInputStream buf = new BufferedInputStream(fis);
            int i;
            byte[] contents = new byte[4096]; //снова можно поиграться буфером
            do {
                i = buf.read(contents);
                outputStream.write(contents);
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время получения строкового типа: " + TimerStopWatch.getInstance().stopTime());
        return outputStream.toByteArray();
    }

    //указание сразу рамзера буфера - может не хватить памяти
    public byte[] readFileBytesWithFileSizeBuffer(File file) {
        TimerStopWatch.getInstance().startTime();
        byte[] contents = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)){
            //тут не нужно ждать пока не прочитаем файл, размер буфера равен размеру файла
            fis.read(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время получения строкового типа: " + TimerStopWatch.getInstance().stopTime());
        return contents;
    }

    //указание сразу рамзера буфера - может не хватить памяти
    public String readFileWithFileSizeBuffer(File file) {
        TimerStopWatch.getInstance().startTime();
        byte[] contents = new byte[(int) file.length()];
        String resultString;
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultString = new String(contents, StandardCharsets.UTF_8);
        System.out.println("Время получения строкового типа: " + TimerStopWatch.getInstance().stopTime());
        return resultString;
    }

    //можно разбить часть данных на логические фргаменты и читать через StreamTokenization
    public void replaceStringWithTokenization(String stringValue, File file, File fileOutput) {
        TimerStopWatch.getInstance().startTime();
        FileReader fr;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput, false));
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StreamTokenizer st = new StreamTokenizer(br);

            while (st.nextToken() != TT_EOF) {
                if (st.ttype == TT_WORD) {
                    if (!st.sval.equals(stringValue)) {
                        writer.append(st.sval.concat(" "));
                    }
                }
            }
            writer.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время работы заменителя строки через токенайзер: " + TimerStopWatch.getInstance().stopTime());
    }

    //Заменяем символы
    public void replaceCharInFile(char oldCharValue, char newCharValue, File file, File fileOutput) {
        TimerStopWatch.getInstance().startTime();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput, false));
            writer.append(readFileWithFileSizeBuffer(file).replace(oldCharValue, newCharValue));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время заменителя строки через буферы: " + TimerStopWatch.getInstance().stopTime());
    }
}


