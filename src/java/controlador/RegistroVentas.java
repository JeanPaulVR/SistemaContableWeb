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
import modelo.beans.LibroRegistroCompraVenta;
import modelo.beans.PeriodoContable;
import modelo.dao.LibroRegistroCompraVentaDao;
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

@WebServlet(name = "RegistroVentas", urlPatterns = {"/RegistroVentas"})
public class RegistroVentas extends HttpServlet {

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
        XSSFSheet sheet = workbook.createSheet("Ventas");

        //Definimos los arreglos que seran las columnas
        String[] columnElements = {"NUMERO CORRELATIVO DEL REGISTRO O CODIGO UNICO DE LA OPERACION",
            "FECHA DE EMISION DEL COMPROBANTE DE PAGO O DOCUMENTO", "FECHA DE VENCIMIENTO Y/O PAGO",
            "COMPROBANTE DE PAGO O DOCUMENTO", "", "", "INFORMACION DEL CLIENTE", "", "", "VALOR FACTURADO DE LA EXPORTACION",
            "BASE IMPONIBLE DE LA OPERACION GRAVADA", "IMPORTE DE LA OPERACION EXONERADA O INAFECTA", "", "DIFERENCIA DE CAMBIO", "IGV Y/O IPM",
            "ISC", "OTROS TRIBUTOS Y CARGOS QUE NO FORMAN PARTE DE LA BASE IMPONIBLE", "IMPORTE TOTAL",
            "TIPO DE CAMBIO", "REFERENCIA DEL COMPROBANTE DE PAGO O DOCUMENTO ORIGINAL QUE SE MODIFICA", "", "", ""};

        String[] columnElements1 = {"", "", "", "", "", "", "DOCUMENTO DE IDENTIDAD", "",
            "APELLIDOS Y NOMBRES, DENOMINACION O RAZON SOCIAL", "", "", "", "", "", "", "", "", "", "",
            "FECHA", "TIPO(TABLA 10)", "SERIE", "N° DEL COMPROBANTE DE PAGO O DOCUMENTO"};

        String[] columnElements2 = {"", "", "", "TIPO(TABLA 10)", "N° SERIE", "NUMERO", "TIPO(TABLA 2)",
            "NUMERO", "", "", "", "EXONERADA", "INAFECTA", "", "", "", "", "", "", "", "", "", ""};

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
        cell1.setCellValue("REGISTRO DE VENTAS");
        cell1.setCellStyle(style2);

        row = sheet.createRow(3);
        cell1 = row.createCell(1);
        cell1.setCellValue("PERIODO");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(4);
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
        cell1 = row.createCell(4);
        cell1.setCellValue(": " + RUC);
        cell1.setCellStyle(style2);

        row = sheet.createRow(5);
        cell1 = row.createCell(1);
        cell1.setCellValue("APELLIDOS Y NOMBRES, RAZON SOCIAL");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(4);
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

                if ("".equals(columnElements1[i]) && "".equals(columnElements2[i]) && !"".equals(columnElements[i + 1])) {
                    CellRangeAddress range = new CellRangeAddress(7, 9, (i + 1), (i + 1));
                    sheet.addMergedRegion(range);

                } else if ("".equals(columnElements1[i]) && !"".equals(columnElements[i + 1])) {
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
                if (i != 22) {
                    if (!"".equals(columnElements1[i + 1]) || !"".equals(columnElements[i + 1])) {
                        if ("".equals(columnElements2[i])) {
                            CellRangeAddress range = new CellRangeAddress(8, 9, (i + 1), (i + 1));
                            sheet.addMergedRegion(range);
                        }
                    }
                } else if (i == 22) {
                    CellRangeAddress range = new CellRangeAddress(8, 9, (i + 1), (i + 1));
                    sheet.addMergedRegion(range);
                }

                it++;
            } else {
                if (i != 0) {
                    if (!"".equals(columnElements1[i - 1]) && "".equals(columnElements[i])) {
                        int count = 0;
                        for (int j = i; j < columnElements1.length; j++) {
                            if (columnElements1[j].equals("") && columnElements[j].equals("")) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if ("".equals(columnElements2[i - 1])) {
                            CellRangeAddress range = new CellRangeAddress(8, 9, i, (i + count));
                            sheet.addMergedRegion(range);
                        } else {
                            CellRangeAddress range = new CellRangeAddress(8, 8, i, (i + count));
                            sheet.addMergedRegion(range);
                        }
                        it += count;
                    } else {
                        it++;
                    }
                } else {
                    it++;
                }
            }

        }

        // Crear 3ra fila
        row = sheet.createRow(9);
        row.setHeight((short) 600);

        it = 0;
        for (int i = 0; i < columnElements2.length; i = it) {
            if (!"".equals(columnElements2[i])) {
                cell1 = row.createCell(i + 1);
                cell1.setCellValue(columnElements2[i]);
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

        sheet.setColumnWidth(1, 256 * 20);
        sheet.setColumnWidth(2, 256 * 15);
        sheet.setColumnWidth(3, 256 * 15);
        sheet.setColumnWidth(4, 256 * 20);
        sheet.setColumnWidth(5, 256 * 20);
        sheet.setColumnWidth(6, 256 * 20);
        sheet.setColumnWidth(7, 256 * 20);
        sheet.setColumnWidth(8, 256 * 20);
        sheet.setColumnWidth(9, 256 * 45);
        sheet.setColumnWidth(10, 256 * 15);
        sheet.setColumnWidth(11, 256 * 12);
        sheet.setColumnWidth(12, 256 * 12);
        sheet.setColumnWidth(13, 256 * 12);
        sheet.setColumnWidth(14, 256 * 12);
        sheet.setColumnWidth(15, 256 * 12);
        sheet.setColumnWidth(16, 256 * 12);
        sheet.setColumnWidth(17, 256 * 25);
        sheet.setColumnWidth(18, 256 * 20);
        sheet.setColumnWidth(19, 256 * 12);
        sheet.setColumnWidth(20, 256 * 20);
        sheet.setColumnWidth(21, 256 * 20);
        sheet.setColumnWidth(22, 256 * 20);
        sheet.setColumnWidth(23, 256 * 20);

        //Añadir datos
        int pos = 0;
        int sum = 0;
        LibroRegistroCompraVentaDao libroDao = new LibroRegistroCompraVentaDao();
        List<LibroRegistroCompraVenta> libros;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        libros = libroDao.listarVentas(fi, ff, id);
        XSSFCell celda;
        for (int i = 0; i < libros.size(); i++) {
            row = sheet.createRow(i + 10);

            celda = row.createCell(1);
            celda.setCellValue(libros.get(i).getNumerocorrelativo());
            celda.setCellStyle(style3);
            celda = row.createCell(2);
            celda.setCellValue(formatter.format(libros.get(i).getFechaemision()));
            celda.setCellStyle(style3);
            celda = row.createCell(3);
            celda.setCellValue(formatter.format(libros.get(i).getFechavencimiento()));
            celda.setCellStyle(style3);
            celda = row.createCell(4);
            celda.setCellValue(libros.get(i).getCodtipo());
            celda.setCellStyle(style3);
            celda = row.createCell(5);
            celda.setCellValue(libros.get(i).getSerie());
            celda.setCellStyle(style3);
            celda = row.createCell(6);
            celda.setCellValue(libros.get(i).getCorrelativo());
            celda.setCellStyle(style3);
            celda = row.createCell(7);
            celda.setCellValue(libros.get(i).getTipoidenti());
            celda.setCellStyle(style3);
            celda = row.createCell(8);
            celda.setCellValue(libros.get(i).getNumeroidenti());
            celda.setCellStyle(style3);
            celda = row.createCell(9);
            celda.setCellValue(libros.get(i).getDenominacion());
            celda.setCellStyle(style3);
            celda = row.createCell(10);
            celda.setCellValue("");
            celda.setCellStyle(style3);
            celda = row.createCell(12);
            celda.setCellValue("");
            celda.setCellStyle(style3);
            celda = row.createCell(13);
            celda.setCellValue("");
            celda.setCellStyle(style3);
            if (libros.get(i).getCodtipo().equals("07")) {

                celda = row.createCell(11);
                celda.setCellValue(Math.round(((libros.get(i).getImporte() / 1.18)) * Math.pow(10, 2)) / Math.pow(10, 2) * -1);
                celda.setCellStyle(style3);
                celda = row.createCell(14);
                celda.setCellValue(libros.get(i).getDiferencia() * -1);
                celda.setCellStyle(style3);
                celda = row.createCell(15);
                celda.setCellValue((Math.round(((libros.get(i).getImporte() / 1.18) * 0.18) * Math.pow(10, 2)) / Math.pow(10, 2)) * -1);
                celda.setCellStyle(style3);
                celda = row.createCell(16);
                celda.setCellValue(libros.get(i).getMontoISC() * -1);
                celda.setCellStyle(style3);
                celda = row.createCell(17);
                celda.setCellValue((libros.get(i).getOtrosM()) * -1);
                celda.setCellStyle(style3);
                celda = row.createCell(18);
                celda.setCellValue((libros.get(i).getImporte()) * -1);
                celda.setCellStyle(style3);

            } else {

                celda = row.createCell(11);
                celda.setCellValue(Math.round(((libros.get(i).getImporte() / 1.18)) * Math.pow(10, 2)) / Math.pow(10, 2));
                celda.setCellStyle(style3);
                celda = row.createCell(14);
                celda.setCellValue(libros.get(i).getDiferencia());
                celda.setCellStyle(style3);
                celda = row.createCell(15);
                celda.setCellValue(Math.round(((libros.get(i).getImporte() / 1.18) * 0.18) * Math.pow(10, 2)) / Math.pow(10, 2));
                celda.setCellStyle(style3);
                celda = row.createCell(16);
                celda.setCellValue(libros.get(i).getMontoISC());
                celda.setCellStyle(style3);
                celda = row.createCell(17);
                celda.setCellValue((libros.get(i).getOtrosM()));
                celda.setCellStyle(style3);
                celda = row.createCell(18);
                celda.setCellValue((libros.get(i).getImporte()));
                celda.setCellStyle(style3);
            }
            celda = row.createCell(19);
            celda.setCellValue(libros.get(i).getTipocambio());
            celda.setCellStyle(style3);

            if (libros.get(i).getFkfecha() != null) {
                celda = row.createCell(20);
                celda.setCellValue(formatter.format(libros.get(i).getFkfecha()));
                celda.setCellStyle(style3);
                celda = row.createCell(21);
                celda.setCellValue(libros.get(i).getFktipo());
                celda.setCellStyle(style3);
                celda = row.createCell(22);
                celda.setCellValue(libros.get(i).getFkserie());
                celda.setCellStyle(style3);
                celda = row.createCell(23);
                celda.setCellValue(libros.get(i).getFkcorrelativo());
                celda.setCellStyle(style3);
            } else {
                celda = row.createCell(20);
                celda.setCellValue("");
                celda.setCellStyle(style3);
                celda = row.createCell(21);
                celda.setCellValue("");
                celda.setCellStyle(style3);
                celda = row.createCell(22);
                celda.setCellValue("");
                celda.setCellStyle(style3);
                celda = row.createCell(23);
                celda.setCellValue("");
                celda.setCellStyle(style3);
            }
            pos++;
        }

        if (!libros.isEmpty()) {
            row = sheet.createRow(10 + libros.size());
            celda = row.createCell(9);
            celda.setCellValue("TOTAL");
            celda.setCellStyle(style1);
            celda = row.createCell(10);
            celda.setCellFormula("SUM(K" + (11 + sum) + ":K" + (10 + pos) + ")");
            celda.setCellStyle(style1);
            celda = row.createCell(11);
            celda.setCellFormula("SUM(L" + (11 + sum) + ":L" + (10 + pos) + ")");
            celda.setCellStyle(style1);
            celda = row.createCell(12);
            celda.setCellFormula("SUM(M" + (11 + sum) + ":M" + (10 + pos) + ")");
            celda.setCellStyle(style1);
            celda = row.createCell(13);
            celda.setCellFormula("SUM(N" + (11 + sum) + ":N" + (10 + pos) + ")");
            celda.setCellStyle(style1);
            celda = row.createCell(14);
            celda.setCellFormula("SUM(O" + (11 + sum) + ":O" + (10 + pos) + ")");
            celda.setCellStyle(style1);
            celda = row.createCell(15);
            celda.setCellFormula("SUM(P" + (11 + sum) + ":P" + (10 + pos) + ")");
            celda.setCellStyle(style1);
            celda = row.createCell(16);
            celda.setCellFormula("SUM(Q" + (11 + sum) + ":Q" + (10 + pos) + ")");
            celda.setCellStyle(style1);
            celda = row.createCell(18);
            celda.setCellFormula("SUM(R" + (11 + sum) + ":R" + (10 + pos) + ")");
            celda.setCellStyle(style1);

        }

        // Establecer la respuesta HTTP para descargar el archivo
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=RegistroVentas.xlsx");

        // Escribir el libro de trabajo en el flujo de salida
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
    }
}
