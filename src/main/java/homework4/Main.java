package homework4;

import homework4.IO.IOUtils;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        IOUtils utils = new IOUtils();
        String fileName = "test_data.txt";
        ClassLoader classLoader = Main.class.getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        //получение строки занимает больше времени чем просто байты
        String result = utils.readFileWithFileSizeBuffer(file);
        System.out.println("1 :" + result.length());
        //получение байтов
        byte[] bytes = utils.readFileBytesWithFileSizeBuffer(file);
        System.out.println("2: " + bytes.length);

        File replaceFile = new File("replaced_text.txt");
        //utils.replaceStringWithTokenization("Lorem", file, replaceFile);

        utils.replaceCharInFile('.', ';', file, replaceFile);
    }
}
