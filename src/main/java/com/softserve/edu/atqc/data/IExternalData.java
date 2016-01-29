package com.softserve.edu.atqc.data;

import java.util.List;

public interface IExternalData {

    List<List<String>> getAllCells(String absoluteFilePath);

}
