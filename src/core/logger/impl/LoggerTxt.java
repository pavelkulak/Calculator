package core.logger.impl;

import core.logger.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class LoggerTxt implements Logger {
    String filePath;
    public LoggerTxt(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(filePath, true))
        {

            writer.write(message);

            writer.append('\n');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
