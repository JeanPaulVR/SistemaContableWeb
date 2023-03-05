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
import modelo.beans.BalanceComprobacion;
import modelo.beans.CuentaContable;
import modelo.beans.PeriodoContable;
import modelo.dao.BalanceComprobacionDao;
import modelo.logic.CuentaContableLogic;
import modelo.logic.PeriodoContableLogic;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet(name = "RegistroEstadosFinancieros", urlPatterns = {"/RegistroEstadosFinancieros"})
public class RegistroEstadosFinancieros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Crear un libro de trabajo de Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Crear una hoja de cálculo
        XSSFSheet sheet = workbook.createSheet("ESTADOS FINANCIEROS");

        //Definimos los arreglos que seran las columnas
        String[] columnElements = {"CUENTA CONTABLE", "", "S.F . DEL ESTADO DE NATURALEZA", "", "S.F. DEL ESTADO DE FUNCION", ""};

        String[] columnElements1 = {"CODIGO", "DENOMINACION", "PERDIDA", "GANANCIA", "PERDIDA", "GANANCIA"};

        // Definimos los estilos
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
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

        // Crear estilo de Totales
        CellStyle style1 = workbook.createCellStyle();
        Font font1 = workbook.createFont();
        font1.setBold(true);
        style1.setFont(font);
        style1.setBorderBottom(BorderStyle.THIN);
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderLeft(BorderStyle.THIN);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderRight(BorderStyle.THIN);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderTop(BorderStyle.THIN);
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style1.setFillForegroundColor(IndexedColors.YELLOW1.getIndex());
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style1.setWrapText(true);

        // Crear estilo de Parametros Inicio
        CellStyle style2 = workbook.createCellStyle();
        Font font2 = workbook.createFont();
        font2.setBold(true);
        style2.setFont(font);

        // Crear una hoja de cálculo
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

        // Definimos los estilos de la primera columna
        CellStyle style5 = workbook.createCellStyle();

        style5.setBorderBottom(BorderStyle.THIN);
        style5.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style5.setBorderLeft(BorderStyle.THIN);
        style5.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style5.setBorderRight(BorderStyle.THIN);
        style5.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style5.setBorderTop(BorderStyle.THIN);
        style5.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style5.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        style5.setVerticalAlignment(VerticalAlignment.CENTER);
        style5.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style5.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style5.setWrapText(true);

        //Llenado de datos
        String RUC = request.getParameter("RUC");
        String RS = request.getParameter("RS");
        int id = Integer.parseInt(request.getParameter("IDPeriodo"));
        PeriodoContableLogic pL = new PeriodoContableLogic();
        PeriodoContable periodo;
        periodo = pL.Datos(id);

        String finicio = String.valueOf(request.getParameter("FechaI"));
        String ffin = String.valueOf(request.getParameter("FechaF"));
        String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

        int fi = Integer.parseInt(finicio);
        int ff = Integer.parseInt(ffin);

        String mes1 = meses[fi - 1];
        String mes2 = meses[ff - 1];

        XSSFRow row;
        XSSFCell cell1;

        row = sheet.createRow(1);
        cell1 = row.createCell(1);
        cell1.setCellValue("REGISTRO ESTADOS DE GANANCIAS Y PERDIDAS - POR FUNCION Y POR NATURALEZA");
        cell1.setCellStyle(style2);
        row = sheet.createRow(3);
        cell1 = row.createCell(1);
        cell1.setCellValue("PERIODO");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(3);
        if (mes1.equals(mes2)) {
            cell1.setCellValue(": " + mes1 + " " + periodo.getAño());
        } else {
            cell1.setCellValue(": " + mes1 + "-" + mes2 + " " + periodo.getAño());
        }
        cell1.setCellStyle(style2);

        row = sheet.createRow(4);
        cell1 = row.createCell(1);
        cell1.setCellValue("RUC");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(3);
        cell1.setCellValue(": " + RUC);
        cell1.setCellStyle(style2);

        row = sheet.createRow(5);
        cell1 = row.createCell(1);
        cell1.setCellValue("APELLIDOS Y NOMBRES, RAZON SOCIAL");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(3);
        cell1.setCellValue(": " + RS);
        cell1.setCellStyle(style2);

        // Crear 1ra fila
        row = sheet.createRow(7);
        row.setHeight((short) 600);
        int it = 0;
        for (int i = 0; i < columnElements.length; i = it) {
            if (!"".equals(columnElements[i])) {
                cell1 = row.createCell(i + 1);
                cell1.setCellValue(columnElements[i]);

                if ("".equals(columnElements1[i]) && !"".equals(columnElements[i + 1])) {
                    CellRangeAddress range = new CellRangeAddress(7, 8, (i + 1), (i + 1));
                    sheet.addMergedRegion(range);
                }

                it++;
            } else if ("".equals(columnElements[i])) {
                int count = 0;
                for (int j = i; j < columnElements.length; j++) {
                    if (columnElements[j].equals("")) {
                        count++;
                    } else {
                        break;
                    }
                }
                if ("".equals(columnElements1[i - 1])) {
                    CellRangeAddress range = new CellRangeAddress(7, 8, i, (i + count));
                    sheet.addMergedRegion(range);

                } else {
                    CellRangeAddress range = new CellRangeAddress(7, 7, i, (i + count));
                    sheet.addMergedRegion(range);
                }

                it += count;

            }

        }

        // Crear 2da fila
        row = sheet.createRow(8);
        row.setHeight((short) 600);

        it = 0;
        for (int i = 0; i < columnElements1.length; i = it) {
            if (!"".equals(columnElements1[i])) {
                cell1 = row.createCell(i + 1);
                cell1.setCellValue(columnElements1[i]);
                cell1.setCellStyle(style);
                it++;
            } else {

                it++;
            }
        }

        //Añadimos los diseños
        sheet = workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress cellRangeAddress = sheet.getMergedRegion(i);
            for (int rowNum = cellRangeAddress.getFirstRow(); rowNum <= cellRangeAddress.getLastRow(); rowNum++) {
                row = sheet.getRow(rowNum);
                for (int colNum = cellRangeAddress.getFirstColumn(); colNum <= cellRangeAddress.getLastColumn(); colNum++) {
                    row = sheet.getRow(rowNum);
                    if (row == null) {
                        row = sheet.createRow(rowNum);
                    }
                    XSSFCell cell = row.getCell(colNum);
                    if (cell == null) {
                        cell = row.createCell(colNum);
                    }

                    cell.setCellStyle(style);
                }
            }
        }
        sheet.setColumnWidth(1, 256 * 15);
        sheet.setColumnWidth(2, 256 * 60);
        sheet.setColumnWidth(3, 256 * 15);
        sheet.setColumnWidth(4, 256 * 15);
        sheet.setColumnWidth(5, 256 * 15);
        sheet.setColumnWidth(6, 256 * 15);

        //Añadir datos
        BalanceComprobacionDao bcDao = new BalanceComprobacionDao();
        CuentaContableLogic ccL = new CuentaContableLogic();
        CuentaContable ccB;
        int pos = 0;
        int suma = 0;
        XSSFCell celda;

        for (int cuenta = 60; cuenta < 100; cuenta++) {

            BalanceComprobacion bc = new BalanceComprobacion();
            BalanceComprobacion bcAnt = new BalanceComprobacion();
            bc = bcDao.ListarGananciasyPerdidas(cuenta, fi, ff, id, "");
            double sumaDeudor = 0.0;
            double sumaAcreedor = 0.0;

            if (bc.getCuenta() > 0) {
                //Cuenta y nombre de la cuenta
                ccB = ccL.DatosCC(cuenta);

                row = sheet.createRow(suma + 9);
                celda = row.createCell(1);
                celda.setCellValue(cuenta);
                celda.setCellStyle(style5);
                celda = row.createCell(2);
                celda.setCellValue(ccB.getNombre());
                celda.setCellStyle(style3);
                sumaDeudor += bc.getDeudor();
                sumaAcreedor += bc.getAcreedor();

                //Saldo Anterior
                if (bcAnt.getCuenta() > 0) {
                    if (fi != 1) {
                        bcAnt = bcDao.ListarGananciasyPerdidas(cuenta, (fi - 1), (fi - 1), id, "");
                    } else {
                        bcAnt = bcDao.ListarGananciasyPerdidas(cuenta, 12, 12, (id - 1), "");
                    }
                    sumaDeudor += bcAnt.getDeudor();
                    sumaAcreedor += bcAnt.getAcreedor();
                }

                //Llenado de filas
                if (cuenta < 70) {
                    if (sumaDeudor > sumaAcreedor) {
                        celda = row.createCell(3);
                        celda.setCellValue(sumaDeudor - sumaAcreedor);
                        celda.setCellStyle(style3);
                        celda = row.createCell(4);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(5);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(6);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                    } else {
                        celda = row.createCell(3);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(4);
                        celda.setCellValue(sumaAcreedor - sumaDeudor);
                        celda.setCellStyle(style3);
                        celda = row.createCell(5);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(6);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                    }
                } else if (cuenta > 69 && cuenta < 90) {
                    if (sumaDeudor > sumaAcreedor) {
                        celda = row.createCell(3);
                        celda.setCellValue(sumaDeudor - sumaAcreedor);
                        celda.setCellStyle(style3);
                        celda = row.createCell(4);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(5);
                        celda.setCellValue(sumaDeudor - sumaAcreedor);
                        celda.setCellStyle(style3);
                        celda = row.createCell(6);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                    } else {
                        celda = row.createCell(3);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(4);
                        celda.setCellValue(sumaAcreedor - sumaDeudor);
                        celda.setCellStyle(style3);
                        celda = row.createCell(5);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(6);
                        celda.setCellValue(sumaAcreedor - sumaDeudor);
                        celda.setCellStyle(style3);
                    }
                } else {
                    if (sumaDeudor > sumaAcreedor) {
                        celda = row.createCell(3);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(4);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(6);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(5);
                        celda.setCellValue(sumaDeudor - sumaAcreedor);
                        celda.setCellStyle(style3);
                    } else {
                        celda = row.createCell(6);
                        celda.setCellValue(sumaAcreedor - sumaDeudor);
                        celda.setCellStyle(style3);
                        celda = row.createCell(3);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(4);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                        celda = row.createCell(5);
                        celda.setCellValue("");
                        celda.setCellStyle(style3);
                    }
                }
                suma++;
            }

        }
        if(suma!=0){
        row = sheet.createRow(suma + 10);
        celda = row.createCell(2);
        celda.setCellValue("SUMA TOTAL");
        celda.setCellStyle(style1);
        celda = row.createCell(3);
        celda.setCellFormula("SUM(D" + (10 + pos) + ":D" + (9 + suma) + ")");
        celda.setCellStyle(style1);
        celda = row.createCell(4);
        celda.setCellFormula("SUM(E" + (10 + pos) + ":E" + (9 + suma) + ")");
        celda.setCellStyle(style1);
        celda = row.createCell(5);
        celda.setCellFormula("SUM(F" + (10 + pos) + ":F" + (9 + suma) + ")");
        celda.setCellStyle(style1);
        celda = row.createCell(6);
        celda.setCellFormula("SUM(G" + (10 + pos) + ":G" + (9 + suma) + ")");
        celda.setCellStyle(style1);
        }
        // Establecer la respuesta HTTP para descargar el archivo
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=RegistroEstadosFinancieros.xlsx");

        // Escribir el libro de trabajo en el flujo de salida
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
    }
}
