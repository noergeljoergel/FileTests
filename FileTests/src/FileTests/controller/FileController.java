package FileTests.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileController {
    private final String ordner;
    private final String dateiname;
    private final File datei;

    public FileController(String ordner, String dateiname) {
        this.ordner = ordner;
        this.dateiname = dateiname;
        this.datei = new File(ordner, dateiname);
    }

    /**
     * Erstellt das Verzeichnis (falls nötig) und dann die Datei.
     */
    public void createFile() {
        File ordnerObjekt = new File(ordner);

        if (!ordnerObjekt.exists()) {
            if (ordnerObjekt.mkdirs()) {
                System.out.println("Ordner erstellt: " + ordner);
            } else {
                System.err.println("Ordner konnte nicht erstellt werden.");
                return;
            }
        }

        try {
            if (datei.createNewFile()) {
                System.out.println("Datei erstellt: " + datei.getAbsolutePath());
            } else {
                System.out.println("Datei existiert bereits: " + datei.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Erstellen der Datei: " + e.getMessage());
        }
    }

    /**
     * Schreibt den angegebenen Text in die Datei.
     */
    public void writeToFile(String text) {
        try (FileWriter writer = new FileWriter(datei)) {
            writer.write(text);
            System.out.println("Text erfolgreich geschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }

    /**
     * Löscht die Datei.
     */
    public void deleteFile() {
        if (datei.exists()) {
            if (datei.delete()) {
                System.out.println("Datei gelöscht: " + datei.getAbsolutePath());
            } else {
                System.err.println("Datei konnte nicht gelöscht werden.");
            }
        } else {
            System.out.println("Datei existiert nicht.");
        }
    }
}