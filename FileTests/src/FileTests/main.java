package FileTests;

import FileTests.controller.FileController;

public class main {
    public static void main(String[] args) {
        String ordner = "output/testdaten";
        String dateiname = "beispiel.txt";

        FileController fileController = new FileController(ordner, dateiname);

        fileController.createFile();
        fileController.writeToFile("Dies ist ein Testeintrag in die Datei.");
        // fileController.deleteFile(); // Optional zum Testen
    }
}