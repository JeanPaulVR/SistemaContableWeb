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
import java.util.ArrayList;
import java.util.List;
import modelo.beans.CuentaContable;
import modelo.beans.LibroCajaBanco;
import modelo.beans.PeriodoContable;
import modelo.dao.LibroCajaBancoDao;
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

@WebServlet(name = "RegistroCajayBanco", urlPatterns = {"/RegistroCajayBanco"})
public class RegistroCajayBanco extends HttpServlet {

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
        String[] columnElements = {"NUMERO CORRELATIVO DEL ASIENTO O CODIGO UNICO DE LA OPERACI�N", "FECHA DE LA OPERACIÓN",
            "OPERACIÓNES BANCARIAS", "", "", "", "CUENTA CONTABLE ASOCIADA A LA OPERACIÓN", "", "SALDOS Y MOVIMIENTOS", ""};

        String[] columnElements1 = {"", "", "MEDIO DE PAGO (TABLA 1)", "DESCRIPCION DE LA OPERACIÓN",
            "APELLIDOS Y NOMBRES , DENOMINACION  O RAZON SOCIAL", "NÚMERO DE TRANSACCION BANCARIA, DE DOCUMENTO SUSTENTATORIO O DE CONTROL INTERNO DE LA OPERACION", "CÓDIGO",
            "DENOMINACIÓN", "DEUDOR", " ACREEDOR"};

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
        int cuentaBanco = Integer.parseInt(request.getParameter("Bancos"));
        int id = Integer.parseInt(request.getParameter("IDPeriodo"));
        PeriodoContableLogic pL = new PeriodoContableLogic();
        PeriodoContable periodo;
        periodo = pL.Datos(id);

        String ffin = String.valueOf(request.getParameter("FechaF"));
        String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

        int ff = Integer.parseInt(ffin);

        String mes = meses[ff - 1];

        CuentaContable cc = new CuentaContable();
        CuentaContableLogic ccL = new CuentaContableLogic();
        cc = ccL.DatosCC(cuentaBanco);

        XSSFRow row;
        XSSFCell cell1;

        row = sheet.createRow(1);
        cell1 = row.createCell(1);
        cell1.setCellValue("FORMATO 1.2: \"LIBRO CAJA Y BANCOS - DETALLE DE LA CUENTA CORRIENTE\"");
        cell1.setCellStyle(style2);
        row = sheet.createRow(3);
        cell1 = row.createCell(1);
        cell1.setCellValue("PERIODO");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(5);
        cell1.setCellValue(": " + mes + " " + periodo.getAño());
        cell1.setCellStyle(style2);
        row = sheet.createRow(4);
        cell1 = row.createCell(1);
        cell1.setCellValue("RUC");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(5);
        cell1.setCellValue(": " + RUC);
        cell1.setCellStyle(style2);
        row = sheet.createRow(5);
        cell1 = row.createCell(1);
        cell1.setCellValue("APELLIDOS Y NOMBRES, RAZON SOCIAL");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(5);
        cell1.setCellValue(": " + RS);
        cell1.setCellStyle(style2);
        row = sheet.createRow(6);
        cell1 = row.createCell(1);
        cell1.setCellValue("ENTIDAD FINANCIERA");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(5);
        cell1.setCellValue(": " + cc.getNombre());
        cell1.setCellStyle(style2);

        row = sheet.createRow(7);
        cell1 = row.createCell(1);
        cell1.setCellValue("CUENTA ENTIDAD FINANCIERA");
        cell1.setCellStyle(style2);
        cell1 = row.createCell(5);
        cell1.setCellValue(": " + cc.getNumero());
        cell1.setCellStyle(style2);

        // Crear 1ra fila
        row = sheet.createRow(9);
        row.setHeight((short) 600);
        int it = 0;
        for (int i = 0; i < columnElements.length; i = it) {
            if (!"".equals(columnElements[i])) {
                cell1 = row.createCell(i + 1);
                cell1.setCellValue(columnElements[i]);

                if ("".equals(columnElements1[i]) && !"".equals(columnElements[i + 1])) {
                    CellRangeAddress range = new CellRangeAddress(9, 10, (i + 1), (i + 1));
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
                    CellRangeAddress range = new CellRangeAddress(9, 10, i, (i + count));
                    sheet.addMergedRegion(range);

                } else {
                    CellRangeAddress range = new CellRangeAddress(9, 9, i, (i + count));
                    sheet.addMergedRegion(range);
                }

                it += count;

            }

        }

        // Crear 2da fila
        row = sheet.createRow(10);
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
        sheet.setColumnWidth(2, 256 * 15);
        sheet.setColumnWidth(3, 256 * 15);
        sheet.setColumnWidth(4, 256 * 30);
        sheet.setColumnWidth(5, 256 * 30);
        sheet.setColumnWidth(6, 256 * 30);
        sheet.setColumnWidth(7, 256 * 15);
        sheet.setColumnWidth(8, 256 * 30);
        sheet.setColumnWidth(9, 256 * 15);
        sheet.setColumnWidth(10, 256 * 15);

        //Añadir datos
        LibroCajaBancoDao cbDao = new LibroCajaBancoDao();
        List<LibroCajaBanco> lista = new ArrayList<>();

        lista = cbDao.listar(cuentaBanco, 1, ff, id);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        double saldoAnterior = cbDao.saldo(cuentaBanco, 1, ff, id);
        double saldoApertura = cbDao.saldoAp(cuentaBanco, 1, ff, id);
        double saldoInicial = 0.0;

        if (saldoAnterior > 0) {
            if (saldoApertura > 0) {
                saldoInicial = saldoApertura + saldoAnterior;
            } else {
                saldoInicial = saldoAnterior - saldoApertura;
            }
        } else {
            if (saldoApertura > 0) {
                saldoInicial = saldoApertura - saldoAnterior;
            } else {
                saldoInicial = saldoAnterior + saldoApertura;
            }
        }

        row = sheet.createRow(11);
        cell1 = row.createCell(1);
        cell1.setCellValue("");
        cell1.setCellStyle(style3);
        cell1 = row.createCell(2);
        cell1.setCellValue("");
        cell1.setCellStyle(style3);
        cell1 = row.createCell(3);
        cell1.setCellValue("");
        cell1.setCellStyle(style3);
        cell1 = row.createCell(4);
        cell1.setCellValue("");
        cell1.setCellStyle(style3);
        cell1 = row.createCell(5);
        cell1.setCellValue("");
        cell1.setCellStyle(style3);
        cell1 = row.createCell(6);
        cell1.setCellValue("");
        cell1.setCellStyle(style3);
        cell1 = row.createCell(7);
        cell1.setCellValue("");
        cell1.setCellStyle(style3);

        cell1 = row.createCell(8);
        cell1.setCellValue("SALDO INICIAL");
        cell1.setCellStyle(style3);

        if (saldoInicial > 0) {
            cell1 = row.createCell(9);
            cell1.setCellValue(saldoInicial);
            cell1.setCellStyle(style3);
            cell1 = row.createCell(10);
            cell1.setCellValue("");
            cell1.setCellStyle(style3);
        } else {
            cell1 = row.createCell(10);
            cell1.setCellValue(saldoInicial * -1);
            cell1.setCellStyle(style3);
            cell1 = row.createCell(9);
            cell1.setCellValue("");
            cell1.setCellStyle(style3);
        }
        int pos = 0;
        int sum = 0;
        for (int i = 0; i < lista.size(); i++) {
            row = sheet.createRow(12 + i);
            cell1 = row.createCell(1);
            cell1.setCellValue(lista.get(i).getNumero_correlativo());
            cell1.setCellStyle(style3);
            cell1 = row.createCell(2);
            cell1.setCellValue(formatter.format(lista.get(i).getFecha_operacion()));
            cell1.setCellStyle(style3);
            cell1 = row.createCell(3);
            cell1.setCellValue(lista.get(i).getFormaPago());
            cell1.setCellStyle(style3);
            cell1 = row.createCell(4);
            cell1.setCellValue("");
            cell1.setCellStyle(style3);
            cell1 = row.createCell(5);
            cell1.setCellValue(lista.get(i).getNombreCC());
            cell1.setCellStyle(style3);
            cell1 = row.createCell(6);
            cell1.setCellValue("");
            cell1.setCellStyle(style3);
            cell1 = row.createCell(7);
            cell1.setCellValue(lista.get(i).getNumeroCuenta());
            cell1.setCellStyle(style3);
            cell1 = row.createCell(8);
            cell1.setCellValue(lista.get(i).getNombreCCont());
            cell1.setCellStyle(style3);
            cell1 = row.createCell(9);
            cell1.setCellValue(lista.get(i).getDeudor());
            cell1.setCellStyle(style3);
            cell1 = row.createCell(10);
            cell1.setCellValue(lista.get(i).getAcreedor());
            cell1.setCellStyle(style3);
            pos++;
        }

        if (!lista.isEmpty()) {
            row = sheet.createRow(12 + lista.size());
            cell1 = row.createCell(8);
            cell1.setCellValue("");

            row = sheet.createRow(13 + lista.size());
            cell1 = row.createCell(8);
            cell1.setCellValue("TOTALES");
            cell1.setCellStyle(style1);
            cell1 = row.createCell(9);
            cell1.setCellFormula("SUM(J" + (12 + sum) + ":J" + (12 + pos) + ")");
            cell1.setCellStyle(style1);
            cell1 = row.createCell(10);
            cell1.setCellFormula("SUM(K" + (12 + sum) + ":K" + (12 + pos) + ")");
            cell1.setCellStyle(style1);

        }

        // Establecer la respuesta HTTP para descargar el archivo
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=RegistroCajaBanco.xlsx");

        // Escribir el libro de trabajo en el flujo de salida
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
    }
}
