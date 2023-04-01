package com.br.audiobeatapi.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ValidCell {

    public static String validStringCell(Cell cell) {
        if (cell.getCellType() != CellType.STRING && cell.getCellType() != CellType.BLANK) {
            return "";
        }
        return cell.getStringCellValue();
    }

    public static Double validDoubleCell(Cell cell) {
        if (cell.getCellType() != CellType.NUMERIC && cell.getCellType() != CellType.BLANK) {
            return null ;
        }
        return cell.getNumericCellValue();
    }

    public static String numericToString(Cell cell) {
        return String.valueOf(cell.getNumericCellValue());
    }

    public static Integer doubleToInt(Cell cell) {
        return Integer.valueOf(String.valueOf(cell.getNumericCellValue()));
    }

    public static String getHour(Cell cell) {
        String date;
        DateFormat format = new SimpleDateFormat("HH:mm");
       date = format.format(cell.getDateCellValue());

        return date;

    }

}
