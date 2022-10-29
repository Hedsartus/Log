package common;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static Log INSTANCE = null;
    private static FileWriter fileWriter;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd - HH:mm:ss");

    public static Log getInstance() {
        if (INSTANCE == null) {
            synchronized (Log.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Log();
                }
            }
        }
        return INSTANCE;
    }

    public synchronized void log(LevelLog level, String logMessage) {
        try {
            fileWriter = new FileWriter("log.txt", true);
            fileWriter.write("[" + level + "] " + LocalDateTime.now().format(timeFormatter) + " : " + logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
