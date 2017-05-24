package gob.senado.ppf.sed.utilidades.vistas;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrador on 24/05/2017.
 */
public class ExcelProgramaInstitucionalBuilder extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // obtiene información del modelo de datos
        List<ProgramaInstitucional> programaInstitucionales = (List<ProgramaInstitucional>) model.get("programas");

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Java Books");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Clave de Programa");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Nombre");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Descripci\u00f3n");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Identificador");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("Unidades Asociadas");
        header.getCell(4).setCellStyle(style);

        // create data rows
        int rowCount = 1;

        for (ProgramaInstitucional programaInstitucional : programaInstitucionales) {
            Row tabla = sheet.createRow(rowCount++);
            tabla.createCell(0).setCellValue(programaInstitucional.getClave());
            tabla.createCell(1).setCellValue(programaInstitucional.getNombre());
            tabla.createCell(2).setCellValue(programaInstitucional.getDescripcion());
            tabla.createCell(3).setCellValue(String.valueOf(programaInstitucional.getIdProgramaInstitucional()));
            tabla.createCell(4).setCellValue(String.valueOf(programaInstitucional.getTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos()));
        }
    }
}
