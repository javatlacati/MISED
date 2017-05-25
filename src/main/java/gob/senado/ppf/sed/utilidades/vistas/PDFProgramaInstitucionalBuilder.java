package gob.senado.ppf.sed.utilidades.vistas;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Javatlacati on 24/05/2017.
 */
public class PDFProgramaInstitucionalBuilder extends AbstractITextPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document documento,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // obtiene información del modelo de datos
        List<ProgramaInstitucional> programaInstitucionales = (List<ProgramaInstitucional>) model.get("programas");

        documento.add(new Paragraph("Listado de Programas Institucionales"));

        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100.0f);
        tabla.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 2.0f});
        tabla.setSpacingBefore(10);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(BaseColor.WHITE);

        PdfPCell encabezado = new PdfPCell();
        encabezado.setBackgroundColor(BaseColor.DARK_GRAY);
        encabezado.setPadding(5);

        // write tabla header
        encabezado.setPhrase(new Phrase("Clave de Programa", fuente));
        tabla.addCell(encabezado);

        encabezado.setPhrase(new Phrase("Nombre", fuente));
        tabla.addCell(encabezado);

        encabezado.setPhrase(new Phrase("Descripci\u00f3n", fuente));
        tabla.addCell(encabezado);

        encabezado.setPhrase(new Phrase("Identificador", fuente));
        tabla.addCell(encabezado);

        encabezado.setPhrase(new Phrase("Unidades Asociadas", fuente));
        tabla.addCell(encabezado);

        for (ProgramaInstitucional programaInstitucional : programaInstitucionales) {
            tabla.addCell(programaInstitucional.getClave());
            tabla.addCell(programaInstitucional.getNombre());
            tabla.addCell(programaInstitucional.getDescripcion());
            tabla.addCell(String.valueOf(programaInstitucional.getIdProgramaInstitucional()));
            tabla.addCell(
                    String.valueOf(
                            programaInstitucional
                                    .getTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos()
                    )
            );
        }

        documento.add(tabla);

    }
}
