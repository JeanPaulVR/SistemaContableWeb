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
import modelo.beans.CuentaContable;
import modelo.beans.LibroMayor;
import modelo.beans.PeriodoContable;
import modelo.dao.LibroMayorDao;
import modelo.logic.CuentaContableLogic;
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

@WebServlet(name = "RegistroLibroMayor", urlPatterns = {"/RegistroLibroMayor"})
public class RegistroLibroMayor extends HttpServlet {

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

        // Crear una hoja de c??lculo
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
        String[] columnElements = {"FECHA DE LA OPERACION", "NUMERO CORRELATIVO DEL LIBRO DIARIO", "DESCRIPCION O GLOSA", "SALDOS Y MOVIMENTOS", ""};
        String[] columnElements1 = {"", "", "", "DEUDOR", "ACREEDOR"};

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
        int cuenta = Integer.parseInt(request.getParameter("txtCuentaLM"));
        PeriodoContableLogic pL = new PeriodoContableLogic();
        String cuentaS = "" + cuenta;
        int num = cuentaS.length();
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
        cell1.setCellValue("FORMATO 6.1 : \"LIBRO MAYOR\"");
        cell1.setCellStyle(style2);

        row = sheet.createRow(3);
        cell1 = row.createCell(1);
        cell1.setCellValue("PERIODO");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(3);
        if (mes1.equals(mes2)) {
            cell1.setCellValue(": " + mes1 + " " + periodo.getA??o());
        } else {
            cell1.setCellValue(": " + mes1 + "-" + mes2 + " " + periodo.getA??o());
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
        row = sheet.createRow(8 + num);
        row.setHeight((short) 900);
        int it = 0;
        for (int i = 0; i < columnElements.length; i = it) {
            if (!"".equals(columnElements[i])) {
                cell1 = row.createCell(i + 1);
                cell1.setCellValue(columnElements[i]);

                if ("".equals(columnElements1[i]) && !"".equals(columnElements[i + 1])) {
                    CellRangeAddress range = new CellRangeAddress(8 + num, 9 + num, (i + 1), (i + 1));
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
                    CellRangeAddress range = new CellRangeAddress(8 + num, 9 + num, i, (i + count));
                    sheet.addMergedRegion(range);

                } else {
                    CellRangeAddress range = new CellRangeAddress(8 + num, 8 + num, i, (i + count));
                    sheet.addMergedRegion(range);
                }

                it += count;

            }

        }

        // Crear 2da fila
        row = sheet.createRow(9 + num);
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

        //A??adimos los dise??os
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

        //A??adir datos
        LibroMayorDao bcDao = new LibroMayorDao();
        List<LibroMayor> libros;
        libros = bcDao.repotelistar(cuenta, fi, ff, id);

        XSSFCell celda;
        row = sheet.createRow(7);
        celda = row.createCell(1);
        celda.setCellValue("CODIGO Y/O DENOMINACION DE LA CUENTA CONTABLE:");
        celda.setCellStyle(style2);

        for (int i = 0; i < num; i++) {

            CuentaContable ccBeans = new CuentaContable();
            CuentaContableLogic ccLogic = new CuentaContableLogic();
            ccBeans = ccLogic.DatosCC(Integer.parseInt(cuentaS));

            if (cuentaS.length() > 2) {

                row = sheet.createRow(6 + num - i);
                celda = row.createCell(1);
                celda.setCellValue(ccBeans.getNumero());
                celda.setCellStyle(style2);
                celda = row.createCell(2);
                celda.setCellValue(": " + ccBeans.getNombre());
                celda.setCellStyle(style2);
                cuentaS = cuentaS.substring(0, cuentaS.length() - 1);

            } else {

                row = sheet.createRow(8);
                celda = row.createCell(1);
                celda.setCellValue(ccBeans.getNumero());
                celda.setCellStyle(style2);
                celda = row.createCell(2);
                celda.setCellValue(": " + ccBeans.getNombre());
                celda.setCellStyle(style2);
                break;
            }
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int pos = 0;
        int sum = 0;
        for (int i = 0; i < libros.size(); i++) {
            row = sheet.createRow(10 + num + i);
            celda = row.createCell(1);
            celda.setCellValue(formatter.format(libros.get(i).getFecha_operacion()));
            celda.setCellStyle(style3);
            celda = row.createCell(2);
            celda.setCellValue(libros.get(i).getNumero_correlativo());
            celda.setCellStyle(style3);
            celda = row.createCell(3);
            celda.setCellValue(libros.get(i).getGlosa());
            celda.setCellStyle(style3);
            celda = row.createCell(4);
            celda.setCellValue(libros.get(i).getDeudor());
            celda.setCellStyle(style3);
            celda = row.createCell(5);
            celda.setCellValue(libros.get(i).getAcreedor());
            celda.setCellStyle(style3);
            pos++;
        }
        if (!libros.isEmpty()) {
            row = sheet.createRow(10 + num + libros.size());
            cell1 = row.createCell(3);
            cell1.setCellValue("TOTALES");
            cell1.setCellStyle(style1);
            cell1 = row.createCell(4);
            cell1.setCellFormula("SUM(E" + (16 + sum) + ":E" + (15 + pos) + ")");
            cell1.setCellStyle(style1);
            cell1 = row.createCell(5);
            cell1.setCellFormula("SUM(F" + (16 + sum) + ":F" + (15 + pos) + ")");
            cell1.setCellStyle(style1);

        }
        // Establecer la respuesta HTTP para descargar el archivo
        response.setContentType(
                "application/vnd.ms-excel");
        response.setHeader(
                "Content-Disposition", "attachment; filename=RegistroLibroMayor.xlsx");

        // Escribir el libro de trabajo en el flujo de salida
        OutputStream outputStream = response.getOutputStream();

        workbook.write(outputStream);

        outputStream.flush();
    }
}
