package com.softserve.edu.oms.data;

import java.util.List;

public final class ListUtils {
    private static final String NUMBER_ERROR = "Number must be bigger than 1";

    public Object[][] toMultiArray(List<?> list) {
        Object[][] array = new Object[list.size()][1];
        for (int i = 0; i < list.size(); i++) {
            array[i][0] = list.get(i);
        }
        return array;
    }

    public Object[][] toMultiArrayNumber(List<?> list, int columnsNumber) {
        if (columnsNumber < 2) {
            // TODO Develop Custom Exception
            throw new RuntimeException(NUMBER_ERROR);
        }
        Object[][] array = new Object[list.size()][columnsNumber];
        for (int i = 0; i < list.size(); i++) {
            array[i][0] = list.get(i);
            for (int j = 1; j < columnsNumber; j++)
                array[i][j] = null;
        }
        return array;
    }

}
