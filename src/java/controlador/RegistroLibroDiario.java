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
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.beans.LibroDiario;
import modelo.beans.PeriodoContable;
import modelo.dao.LibroDiarioDao;
import modelo.logic.PeriodoContableLogic;
import org.apache.poi.ss.usermodel.BorderStyle;
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

@WebServlet(name = "RegistroLibroDiario", urlPatterns = {"/RegistroLibroDiario"})
public class RegistroLibroDiario extends HttpServlet {

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
        XSSFSheet sheet = workbook.createSheet("LIBRODIARIO");

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

        // Crear estilo de Totales
        CellStyle style1 = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
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
        Font font1 = workbook.createFont();
        font1.setBold(true);
        style2.setFont(font);
        // Celdas inicio
        CellStyle style4 = workbook.createCellStyle();
        Font font2 = workbook.createFont();
        font2.setBold(true);
        style4.setFont(font);
        style4.setBorderBottom(BorderStyle.THIN);
        style4.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style4.setBorderLeft(BorderStyle.THIN);
        style4.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style4.setBorderRight(BorderStyle.THIN);
        style4.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style4.setBorderTop(BorderStyle.THIN);
        style4.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style4.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        style4.setVerticalAlignment(VerticalAlignment.CENTER);
        style4.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style4.setWrapText(true);

        //Definimos los arreglos que seran las columnas
        String[] columnElements = {"NUMERO CORRELATIVO DEL ASIENTO O CODIGO UNICO DE LA OPERACIÓN",
            "FECHA DE LA OPERACIÓN", "GLOSA O DESCRIPCIÓN DE LA OPERACIÓN", "REFERENCIA DE LA OPERACIÓN", "", "",
            "CUENTA CONTABLE ASOCIADA A LA OPERACIÓN", "", "MOVIMIENTO", ""};

        String[] columnElements1 = {"", "", "", "CODIGO DEL LIBRO O REGISTRO (TABLA 8)",
            "NÚMERO CORRELATIVO", "NÚMERO DEL DOCUMENTO SUSTENTATORIO", "CÓDIGO", "DENOMINACIÓN", "DEBE", " HABER"};

        // Definimos los estilos
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
        style.setWrapText(true);

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
        cell1.setCellValue("FORMATO 5.1 : \"LIBRO DIARIO\"");
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
        row = sheet.createRow(3);
        cell1 = row.createCell(1);
        cell1.setCellValue("APELLIDOS Y NOMBRES, RAZON SOCIAL");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(3);
        cell1.setCellValue(": " + RS);
        cell1.setCellStyle(style2);

        // Crear 1ra fila
        row = sheet.createRow(7);
        row.setHeight((short) 900);
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
        row.setHeight((short) 900);

        it = 0;
        for (int i = 0; i < columnElements1.length; i = it) {
            if (!"".equals(columnElements1[i])) {
                cell1 = row.createCell(i + 1);
                cell1.setCellValue(columnElements1[i]);
                cell1.setCellStyle(style4);
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

                    cell.setCellStyle(style4);
                }
            }
        }
        sheet.setColumnWidth(1, 256 * 20);
        sheet.setColumnWidth(2, 256 * 15);
        sheet.setColumnWidth(3, 256 * 45);
        sheet.setColumnWidth(4, 256 * 20);
        sheet.setColumnWidth(5, 256 * 13);
        sheet.setColumnWidth(6, 256 * 16);
        sheet.setColumnWidth(7, 256 * 10);
        sheet.setColumnWidth(8, 256 * 60);
        sheet.setColumnWidth(9, 256 * 20);
        sheet.setColumnWidth(10, 256 * 20);

        //Añadir datos
        int pos = 0;
        int sum = 0;
        LibroDiarioDao libroDao = new LibroDiarioDao();
        List<LibroDiario> libros;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        libros = libroDao.reportelistar(fi, ff, id);
        XSSFCell celda;
        for (int i = 0; i < libros.size(); i++) {
            row = sheet.createRow(i + 9);

            celda = row.createCell(1);
            celda.setCellValue(libros.get(i).getNumeroasiento());
            celda.setCellStyle(style3);
            celda = row.createCell(2);
            celda.setCellValue(formatter.format(libros.get(i).getFecha()));
            celda.setCellStyle(style3);
            celda = row.createCell(3);
            celda.setCellValue(libros.get(i).getGlosa());
            celda.setCellStyle(style3);
            celda = row.createCell(4);
            celda.setCellValue("");
            celda.setCellStyle(style3);
            celda = row.createCell(5);
            celda.setCellValue("");
            celda.setCellStyle(style);
            celda = row.createCell(6);
            celda.setCellValue("");
            celda.setCellStyle(style3);
            celda = row.createCell(7);
            celda.setCellValue(libros.get(i).getNumerocuenta());
            celda.setCellStyle(style3);
            celda = row.createCell(8);
            celda.setCellValue(libros.get(i).getNombrecuenta());
            celda.setCellStyle(style3);
            celda = row.createCell(9);
            celda.setCellValue(libros.get(i).getDebesoles());
            celda.setCellStyle(style3);
            celda = row.createCell(10);
            celda.setCellValue(libros.get(i).getHabersoles());
            celda.setCellStyle(style3);
            pos++;
        }

        row = sheet.createRow(9 + libros.size());
        celda = row.createCell(8);
        celda.setCellValue("SUMA TOTAL ");
        celda.setCellStyle(style1);
        celda = row.createCell(9);
        celda.setCellFormula("SUM(J" + (10 + sum) + ":J" + (9 + pos) + ")");
        celda.setCellStyle(style1);
        celda = row.createCell(10);
        celda.setCellFormula("SUM(K" + (10 + sum) + ":K" + (9 + pos) + ")");
        celda.setCellStyle(style1);

        // Establecer la respuesta HTTP para descargar el archivo
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=RegistroLibroDiario.xlsx");

        // Escribir el libro de trabajo en el flujo de salida
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
    }
}
