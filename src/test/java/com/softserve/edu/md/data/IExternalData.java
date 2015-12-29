package com.softserve.edu.md.data;

import java.util.List;

public interface IExternalData {

    List<List<String>> getAllCells(String absoluteFilePath);

}