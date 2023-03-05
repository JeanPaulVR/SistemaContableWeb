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

@WebServlet(name = "RegistroBalanceComprobacion", urlPatterns = {"/RegistroBalanceComprobacion"})
public class RegistroBalanceComprobacion extends HttpServlet {

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
        XSSFSheet sheet = workbook.createSheet("BALANCE COMPROBACION");

        //Definimos los arreglos que seran las columnas
        String[] columnElements = {"CUENTA CONTABLE", "", "SALDOS ANTERIORES", "", "MOVIMIENTOS DEL PERIODO", "", "ACUMULADO",
            "", "SALDOS FINALES", "", "S.F. DEL BALANCE GENERAL", "", "S.F . DEL ESTADO DE NATURALEZA", "",
            "S.F. DEL ESTADO DE FUNCION", ""};

        String[] columnElements1 = {"CODIGO", "DENOMINACION", "DEUDOR", "ACREEDOR", "DEBE", "HABER", "DEBE", "HABER", "DEUDOR",
            "ACREEDOR", "ACTIVO", "PASIVO", "PERDIDA", "GANANCIA", "PERDIDA", "GANANCIA"};

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

        // Crear estilo UTILIDAD
        CellStyle style5 = workbook.createCellStyle();
        Font font5 = workbook.createFont();
        font5.setBold(true);
        style5.setFont(font);
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
        cell1.setCellValue("REGISTRO DE BALANCE DE COMPROBACION");
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
        sheet.setColumnWidth(7, 256 * 15);
        sheet.setColumnWidth(8, 256 * 15);
        sheet.setColumnWidth(9, 256 * 15);
        sheet.setColumnWidth(10, 256 * 15);
        sheet.setColumnWidth(11, 256 * 15);
        sheet.setColumnWidth(12, 256 * 15);
        sheet.setColumnWidth(13, 256 * 15);
        sheet.setColumnWidth(14, 256 * 15);
        sheet.setColumnWidth(15, 256 * 15);
        sheet.setColumnWidth(16, 256 * 15);

        //Añadir datos
        int celd = 0;
        BalanceComprobacionDao bcDao = new BalanceComprobacionDao();
        CuentaContableLogic ccL = new CuentaContableLogic();
        CuentaContable ccB;
        int suma = 0;
        XSSFCell celda;
        int pos = 0;
        String[] letra = {"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q"};

        List<Integer> lugar = new ArrayList<>();

        for (int cuenta = 10; cuenta < 100; cuenta++) {

            List<BalanceComprobacion> lista;
            List<BalanceComprobacion> listaAnterior;
            lista = bcDao.ListarCuentas(cuenta, fi, ff, id, "");

            if (!lista.isEmpty()) {
                celd += lista.size() + 2;
                ccB = ccL.DatosCC(cuenta);
                //Cuenta y nombre de la cuenta
                row = sheet.createRow(suma + 9);
                celda = row.createCell(1);
                celda.setCellValue(cuenta);

                celda = row.createCell(2);
                celda.setCellValue(ccB.getNombre());

                for (int i = 0; i < lista.size(); i++) {
                    //Llenado de datos
                    row = sheet.createRow(10 + suma);
                    celda = row.createCell(1);
                    celda.setCellValue(lista.get(i).getCuenta());

                    celda = row.createCell(2);
                    celda.setCellValue(lista.get(i).getNombreCuenta());

                    //Declaracion de sumadores
                    double acumulado1 = 0;
                    double acumulado2 = 0;

                    //Saldo Anterior
                    if (fi != 1) {
                        listaAnterior = bcDao.ListarCuentas(lista.get(i).getCuenta(), (fi - 1), (fi - 1), id, "");
                    } else {
                        listaAnterior = bcDao.ListarCuentas(lista.get(i).getCuenta(), 12, 12, (id - 1), "");
                    }
                    celda.setCellStyle(style3);
                    if (!listaAnterior.isEmpty()) {
                        double deudorA = listaAnterior.get(0).getDeudor();
                        double acreedorA = listaAnterior.get(0).getAcreedor();
                        if (deudorA > acreedorA) {
                            celda = row.createCell(3);
                            celda.setCellValue(deudorA - acreedorA);

                        } else {
                            celda = row.createCell(4);
                            celda.setCellValue(acreedorA - deudorA);

                        }

                        acumulado1 += listaAnterior.get(0).getDeudor();
                        acumulado2 += listaAnterior.get(0).getAcreedor();
                    } else {
                        celda = row.createCell(3);
                        celda.setCellValue("");

                        celda = row.createCell(4);
                        celda.setCellValue("");

                    }

                    //Movimientos del Periodo
                    double deudor = lista.get(i).getDeudor();
                    double acreedor = lista.get(i).getAcreedor();

                    if (deudor > acreedor) {

                        celda = row.createCell(5);
                        celda.setCellValue(deudor - acreedor);

                    } else {

                        celda = row.createCell(6);
                        celda.setCellValue(acreedor - deudor);

                    }

                    acumulado1 += lista.get(i).getDeudor();
                    acumulado2 += lista.get(i).getAcreedor();

                    //Acumulado
                    if (acumulado1 > acumulado2) {
                        celda = row.createCell(7);
                        celda.setCellValue(acumulado1 - acumulado2);

                    } else {
                        celda = row.createCell(8);
                        celda.setCellValue(acumulado2 - acumulado1);

                    }

                    //Saldos Finales
                    if (acumulado1 > acumulado2) {
                        celda = row.createCell(9);
                        celda.setCellValue(acumulado1 - acumulado2);

                        //S.F Distribucion
                        if (cuenta >= 10 && cuenta <= 59) {
                            celda = row.createCell(11);
                            celda.setCellValue(acumulado1 - acumulado2);

                        } else if (cuenta >= 60 && cuenta <= 69) {
                            celda = row.createCell(13);
                            celda.setCellValue(acumulado1 - acumulado2);

                        } else if (cuenta >= 70 && cuenta <= 79) {
                            celda = row.createCell(14);
                            celda.setCellValue(acumulado1 - acumulado2);

                            celda = row.createCell(16);
                            celda.setCellValue(acumulado1 - acumulado2);

                        } else if (cuenta >= 90) {
                            celda = row.createCell(15);
                            celda.setCellValue(acumulado1 - acumulado2);

                        }
                    } else {
                        celda = row.createCell(9);
                        celda.setCellValue("");

                        celda = row.createCell(10);
                        celda.setCellValue(acumulado2 - acumulado1);

                        //S.F Distribucion
                        if (cuenta >= 10 && cuenta <= 59) {
                            celda = row.createCell(12);
                            celda.setCellValue(acumulado2 - acumulado1);

                        } else if (cuenta >= 60 && cuenta <= 69) {
                            celda = row.createCell(13);
                            celda.setCellValue(acumulado2 - acumulado1);

                        } else if (cuenta >= 70 && cuenta <= 79) {
                            celda = row.createCell(14);
                            celda.setCellValue(acumulado2 - acumulado1);

                            celda = row.createCell(16);
                            celda.setCellValue(acumulado2 - acumulado1);

                        } else if (cuenta >= 90) {
                            celda = row.createCell(15);
                            celda.setCellValue(acumulado2 - acumulado1);

                        }
                    }
                    suma++;

                }

                for (int i = 0; i < suma; i++) {
                    row = sheet.createRow(suma + 10);

                    celda = row.createCell(2);
                    celda.setCellValue("TOTAL CONSOLIDADO");
                    celda.setCellStyle(style1);

                    for (int j = 0; j < letra.length; j++) {
                        celda = row.createCell(j + 3);
                        celda.setCellFormula("SUM(" + letra[j] + (11 + pos) + ":" + letra[j] + (10 + lista.size() + pos) + ")");
                        celda.setCellStyle(style1);

                    }
                }
                lugar.add(suma + 10);
                pos += lista.size() + 2;
                suma += 2;
            }

        }
        row = sheet.createRow(suma + 10);
        celda = row.createCell(2);
        celda.setCellValue("SUMA TOTAL");
        celda.setCellStyle(style1);

        if (!lugar.isEmpty()) {
            for (int j = 0; j < letra.length; j++) {
                celda = row.createCell(j + 3);
                String form = "";
                for (int pos1 : lugar) {
                    form += letra[j] + (pos1 + 1) + "+";
                }
                form = form.substring(0, form.length() - 1);
                celda.setCellFormula(form);
                celda.setCellStyle(style1);

            }
        }

//        row = sheet.createRow(suma + 11);
//        celda = row.createCell(2);
//        celda.setCellValue("UTILIDAD O PERDIDA CONTABLE DEL EJERCICIO");
//        celda.setCellStyle(style5);
//        celda = row.createCell(3);
//        celda.setCellStyle(style5);
//        celda = row.createCell(4);
//        celda.setCellStyle(style5);
//        celda = row.createCell(5);
//        celda.setCellStyle(style5);
//        celda = row.createCell(6);
//        celda.setCellStyle(style5);
//        celda = row.createCell(7);
//        celda.setCellStyle(style5);
//        celda = row.createCell(8);
//        celda.setCellStyle(style5);
//        celda = row.createCell(9);
//        celda.setCellStyle(style5);
//        celda = row.createCell(10);
//        celda.setCellStyle(style5);
//
//        //utilidad
//        double gen = 0;
//        
//        double nat = 0;
//        double fun = 0;
//        row = sheet.getRow(suma + 10);
//        celda = row.getCell(11);
//        gen += celda.getNumericCellValue();
//        celda = row.getCell(12);
//        gen -= celda.getNumericCellValue();
//        if (gen > 0) {
//            row = sheet.getRow(suma + 11);
//            celda = row.createCell(12);
//            celda.setCellValue(gen);
//        } else {
//            row = sheet.getRow(suma + 11);
//            celda = row.createCell(11);
//            celda.setCellValue(gen);
//        }
        CellRangeAddress range = new CellRangeAddress(suma + 11, suma + 11, 2, 10);
        sheet.addMergedRegion(range);

        //Estilos contenido
        for (int row1 = 9; row1 <= (8 + celd); row1++) {
            row = sheet.getRow(row1);
            if (row == null) {
                row = sheet.createRow(row1);
            }
            for (int col = 1; col <= 16; col++) {
                Cell cell = row.getCell(col);
                if (cell == null) {
                    cell = row.createCell(col);
                }
                if (cell.getCellStyle() != style1) {
                    cell.setCellStyle(style3);
                }
            }
        }

        if (!lugar.isEmpty()) {
            for (int i = 0; i < lugar.size(); i++) {
                row = sheet.getRow(lugar.get(i));
                for(int j=1; j<17; j++){
                    celda = row.getCell(j);
                    celda.setCellStyle(style5);
                }
            }

        }

        // Establecer la respuesta HTTP para descargar el archivo
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=RegistroBalanceComprobacion.xlsx");

        // Escribir el libro de trabajo en el flujo de salida
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
    }
}
