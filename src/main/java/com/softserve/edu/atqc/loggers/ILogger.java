package com.softserve.edu.atqc.loggers;

public interface ILogger {

    void error(String message);

    void warning(String message);

    void info(String message);

    //void debug(String message);

    void insertScreenShot(String fileNamePath);

    //void insertHtmlCode(String fileNamePath);

}
