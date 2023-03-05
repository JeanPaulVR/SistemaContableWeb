/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.BalanceGeneral;
import modelo.beans.PeriodoContable;
import modelo.dao.BalanceGeneralDao;
import modelo.logic.PeriodoContableLogic;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet(name = "RegistroBalanceGeneral", urlPatterns = {"/RegistroBalanceGeneral"})
public class RegistroBalanceGeneral extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Crear un libro de trabajo de Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Crear una hoja de cálculo
        XSSFSheet sheet = workbook.createSheet("BALANCE GENERAL");

        //Definimos los arreglos que seran las columnas
        // Definimos los estilos de la primera fila
        CellStyle style = workbook.createCellStyle();

        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setWrapText(true);

        // Definimos los estilos de la segunda fila
        CellStyle style2 = workbook.createCellStyle();

        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderRight(BorderStyle.THIN);
        style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderTop(BorderStyle.THIN);
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style2.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style2.setWrapText(true);

        // Definimos los estilos de las demas fila
        CellStyle style3 = workbook.createCellStyle();

        style3.setBorderBottom(BorderStyle.THIN);
        style3.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style3.setBorderLeft(BorderStyle.THIN);
        style3.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style3.setBorderRight(BorderStyle.THIN);
        style3.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style3.setBorderTop(BorderStyle.THIN);
        style3.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style3.setWrapText(true);

        // Definimos los estilos de los totales parciales
        CellStyle style4 = workbook.createCellStyle();

        style4.setBorderBottom(BorderStyle.THIN);
        style4.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style4.setBorderLeft(BorderStyle.THIN);
        style4.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style4.setBorderRight(BorderStyle.THIN);
        style4.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style4.setBorderTop(BorderStyle.THIN);
        style4.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style4.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style4.setWrapText(true);

        // Definimos los estilos de los totales netos
        CellStyle style5 = workbook.createCellStyle();

        style5.setBorderBottom(BorderStyle.THIN);
        style5.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style5.setBorderLeft(BorderStyle.THIN);
        style5.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style5.setBorderRight(BorderStyle.THIN);
        style5.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style5.setBorderTop(BorderStyle.THIN);
        style5.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style5.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        style5.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style5.setWrapText(true);

        //Llenado de datos
        String RUC = request.getParameter("RUC");
        String RS = request.getParameter("RS");
        int id = Integer.parseInt(request.getParameter("IDPeriodo"));
        int digitos = Integer.parseInt(request.getParameter("Digitos"));
        PeriodoContableLogic pL = new PeriodoContableLogic();
        PeriodoContable periodo;
        periodo = pL.Datos(id);

        String ffin = String.valueOf(request.getParameter("FechaF"));
        String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

        int ff = Integer.parseInt(ffin);

        String mes = meses[ff - 1];

        XSSFRow row;
        XSSFCell cell1;

        row = sheet.createRow(1);
        cell1 = row.createCell(1);
        cell1.setCellValue("FORMATO 3.1: \"LIBRO DE INVENTARIO Y BALANCES - BALANCE GENERAL\"");

        row = sheet.createRow(3);
        cell1 = row.createCell(1);
        cell1.setCellValue("PERIODO");
        cell1 = row.createCell(2);
        cell1.setCellValue(": " + mes + " " + periodo.getAño());

        row = sheet.createRow(4);
        cell1 = row.createCell(1);
        cell1.setCellValue("RUC");
        cell1 = row.createCell(2);
        cell1.setCellValue(": " + RUC);

        row = sheet.createRow(5);
        cell1 = row.createCell(1);
        cell1.setCellValue("APELLIDOS Y NOMBRES, RAZON SOCIAL");
        cell1 = row.createCell(2);
        cell1.setCellValue(": " + RS);

        sheet.setColumnWidth(1, 256 * 40);
        sheet.setColumnWidth(2, 256 * 20);
        sheet.setColumnWidth(4, 256 * 40);
        sheet.setColumnWidth(5, 256 * 20);

        //Añadir datos
        int pos = 0;
        int sum = 0;
        row = sheet.createRow(7);
        cell1 = row.createCell(1);
        cell1.setCellValue("ACTIVOS");
        CellRangeAddress range = new CellRangeAddress(7, 7, 1, 2);
        sheet.addMergedRegion(range);
        cell1.setCellStyle(style);
        cell1 = row.createCell(2);
        cell1.setCellStyle(style);

        //Activos Corrientes
        row = sheet.createRow(8);
        cell1 = row.createCell(1);
        cell1.setCellValue("ACTIVOS CORRIENTES");
        cell1.setCellStyle(style2);
        BalanceGeneralDao bDao = new BalanceGeneralDao();
        List<BalanceGeneral> lista = new ArrayList<>();

        for (int cuenta = 10; cuenta < 17; cuenta++) {
            lista = bDao.reportelistar(cuenta, ff, digitos, id);
            for (BalanceGeneral bg : lista) {
                row = sheet.createRow(9 + pos);
                cell1 = row.createCell(1);
                cell1.setCellValue(bg.getNombrecuenta());
                cell1.setCellStyle(style3);
                cell1 = row.createCell(2);
                cell1.setCellValue(bg.getImporte());
                cell1.setCellStyle(style3);
                pos++;
            }

        }
        row = sheet.getRow(8 + sum);
        cell1 = row.createCell(2);
        if (pos > 0) {
            cell1.setCellFormula("SUM(C" + (10 + sum) + ":C" + (9 + pos) + ")");
        } else {
            cell1.setCellValue(0);
        }
        cell1.setCellStyle(style2);
        int posActivosC = 9 + sum;
        pos++;
        sum += pos;

        //Activos no Corrientes
        row = sheet.createRow(8 + pos);
        cell1 = row.createCell(1);
        cell1.setCellValue("ACTIVOS NO CORRIENTES");
        cell1.setCellStyle(style2);

        for (int cuenta = 17; cuenta < 22; cuenta++) {
            lista = bDao.reportelistar(cuenta, ff, digitos, id);
            for (BalanceGeneral bg : lista) {
                row = sheet.createRow(9 + pos);
                cell1 = row.createCell(1);
                cell1.setCellValue(bg.getNombrecuenta());
                cell1.setCellStyle(style3);
                cell1 = row.createCell(2);
                cell1.setCellValue(bg.getImporte());
                cell1.setCellStyle(style3);
                pos++;
            }
        }
        row = sheet.getRow(8 + sum);
        cell1 = row.createCell(2);
        if (pos > 1) {
            cell1.setCellFormula("SUM(C" + (10 + sum) + ":C" + (9 + pos) + ")");
        } else {
            cell1.setCellValue(0);
        }
        cell1.setCellStyle(style2);
        int posActivosN = 9 + sum;
        pos++;
        sum = pos;

        row = sheet.createRow(8 + pos);
        cell1 = row.createCell(1);
        cell1.setCellValue("TOTAL DE ACTIVOS");
        cell1.setCellStyle(style4);
        cell1 = row.createCell(2);
        cell1.setCellFormula("C" + posActivosC + "+C" + posActivosN);
        cell1.setCellStyle(style5);

        //Inicio Pasivos
        row = sheet.getRow(7);
        cell1 = row.createCell(4);
        cell1.setCellValue("PASIVOS Y PATRIMONIO");
        range = new CellRangeAddress(7, 7, 4, 5);
        sheet.addMergedRegion(range);
        cell1.setCellStyle(style);
        cell1 = row.createCell(5);
        cell1.setCellStyle(style);

        int pos1 = 0;
        int sum1 = 0;
        //Pasivos Corrientes
        if (sheet.getRow(8 + pos1) != null) {
            row = sheet.getRow(8 + pos1);
        } else {
            row = sheet.createRow(8 + pos1);
        }
        cell1 = row.createCell(4);
        cell1.setCellValue("PASIVOS CORRIENTES");
        cell1.setCellStyle(style2);

        for (int cuenta = 40; cuenta < 47; cuenta++) {
            lista = bDao.reportelistar(cuenta, ff, digitos, id);
            for (BalanceGeneral bg : lista) {
                if (sheet.getRow(9 + pos1) != null) {
                    row = sheet.getRow(9 + pos1);
                } else {
                    row = sheet.createRow(9 + pos1);
                }
                cell1 = row.createCell(4);
                cell1.setCellValue(bg.getNombrecuenta());
                cell1.setCellStyle(style3);
                cell1 = row.createCell(5);
                cell1.setCellValue(bg.getImporte());
                cell1.setCellStyle(style3);
                pos1++;
            }
        }
        row = sheet.getRow(8 + sum1);
        cell1 = row.createCell(5);
        if (pos1 > 1) {
            cell1.setCellFormula("SUM(F" + (10 + sum1) + ":F" + (9 + pos1) + ")");
        } else {
            cell1.setCellValue(0);
        }
        cell1.setCellStyle(style2);
        int posPasivosC = 9 + sum1;
        pos1++;
        sum1 = pos1;

        //Pasivos no Corrientes
        if (sheet.getRow(8 + pos1) != null) {
            row = sheet.getRow(8 + pos1);
        } else {
            row = sheet.createRow(8 + pos1);
        }
        cell1 = row.createCell(4);
        cell1.setCellValue("PASIVOS NO CORRIENTES");
        cell1.setCellStyle(style2);

        for (int cuenta = 47; cuenta < 5; cuenta++) {
            lista = bDao.reportelistar(cuenta, ff, digitos, id);
            for (BalanceGeneral bg : lista) {
                if (sheet.getRow(9 + pos1) != null) {
                    row = sheet.getRow(9 + pos1);
                } else {
                    row = sheet.createRow(9 + pos1);
                }

                cell1 = row.createCell(4);
                cell1.setCellValue(bg.getNombrecuenta());
                cell1.setCellStyle(style3);
                cell1 = row.createCell(5);
                cell1.setCellValue(bg.getImporte());
                cell1.setCellStyle(style3);
                pos1++;
            }
        }
        row = sheet.getRow(8 + sum1);
        cell1 = row.createCell(5);
        if (!lista.isEmpty()) {
            cell1.setCellFormula("SUM(F" + (10 + sum1) + ":F" + (9 + pos1) + ")");
        } else {
            cell1.setCellValue(0);
        }
        cell1.setCellStyle(style2);
        int posPasivosN = 9 + sum1;
        if (sheet.getRow(9 + pos1) != null) {
            row = sheet.getRow(9 + pos1);
        } else {
            row = sheet.createRow(9 + pos1);
        }
        cell1 = row.createCell(4);
        cell1.setCellValue("TOTAL DE PASIVOS");
        cell1.setCellStyle(style4);
        cell1 = row.createCell(5);
        cell1.setCellFormula("F" + posPasivosC + "+F" + posPasivosN);
        cell1.setCellStyle(style4);
        pos1++;
        sum1 = pos1;
        //Patrimonio
        int pat = 0;
        if (sheet.getRow(9 + pos1) != null) {
            row = sheet.getRow(9 + pos1);
        } else {
            row = sheet.createRow(9 + pos1);
        }
        cell1 = row.createCell(4);
        cell1.setCellValue("PATRIMONIO");
        cell1.setCellStyle(style2);

        for (int cuenta = 50; cuenta < 60; cuenta++) {
            lista = bDao.reportelistar(cuenta, ff, digitos, id);
            for (BalanceGeneral bg : lista) {
                if (sheet.getRow(10 + pos1) != null) {
                    row = sheet.getRow(10 + pos1);
                } else {
                    row = sheet.createRow(10 + pos1);
                }
                cell1 = row.createCell(4);
                cell1.setCellValue(bg.getNombrecuenta());
                cell1.setCellStyle(style3);
                cell1 = row.createCell(5);
                cell1.setCellValue(bg.getImporte());
                cell1.setCellStyle(style3);
                pos1++;
                pat++;
            }
        }
        row = sheet.getRow(9 + sum1);
        cell1 = row.createCell(5);
        cell1.setCellFormula("SUM(F" + (11 + sum1) + ":F" + (10 + pos1) + ")");

        cell1.setCellStyle(style2);
        int posPatrimonio = 10 + sum1;
        if (sheet.getRow(10 + pos1) != null) {
            row = sheet.getRow(10 + pos1);
        } else {
            row = sheet.createRow(10 + pos1);
        }
        cell1 = row.createCell(4);
        cell1.setCellValue("TOTAL DE PATRIMONIO");
        cell1.setCellStyle(style4);
        cell1 = row.createCell(5);
        cell1.setCellFormula("F" + posPatrimonio);
        cell1.setCellStyle(style4);

        if (sheet.getRow(11 + pos1) != null) {
            row = sheet.getRow(11 + pos1);
        } else {
            row = sheet.createRow(11 + pos1);
        }
        cell1 = row.createCell(4);
        cell1.setCellValue("TOTAL DE PASIVOS Y PATRIMONIO");
        cell1.setCellStyle(style4);
        cell1 = row.createCell(5);
        cell1.setCellFormula("F" + posPasivosC + "+F" + posPasivosN + "+F" + posPatrimonio);
        cell1.setCellStyle(style5);

        // Establecer la respuesta HTTP para descargar el archivo
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=RegistroBalanceGeneral.xlsx");

        // Escribir el libro de trabajo en el flujo de salida
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
    }
}
