package gob.senado.ppf.sed.repositorio.programainstitucional;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.builder.ColumnSpec;
import org.dbunit.dataset.builder.DataSetBuilder;
import org.dbunit.dataset.xml.XmlDataSetWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.dbunit.dataset.builder.ColumnSpec.newColumn;

/**
 * Created by Administrador on 16/05/2017.
 */
public class ConfiguaPruebaProgramaInstitucionalRepositorio {

    public static void main(String[] args) throws DataSetException, IOException {
        ClassLoader classLoader = ConfiguaPruebaProgramaInstitucionalRepositorio.class.getClassLoader();

        final String TABLE_NAME = "programa_institucional";
        //columnas
        ColumnSpec<Long> ID_PROGRAMA = newColumn("id_programa_institucional");
        ColumnSpec<String> clave = newColumn("clave");
        ColumnSpec<String> nombre = newColumn("nombre");
        ColumnSpec<String> descripcion = newColumn("descripcion");

        DataSetBuilder builder = new DataSetBuilder();
        //datos

        builder.newRow(TABLE_NAME).
                with(ID_PROGRAMA, 0L).
                with(clave, "p00001").
                with(nombre, "Programa institucional 1").
                with(descripcion, "Programad e ejemplo 1").
                add();

        builder.newRow(TABLE_NAME).
                with(ID_PROGRAMA, 1L).
                with(clave, "p00002").
                with(nombre, "Programa institucional 2").
                with(descripcion, "Programad e ejemplo 2").
                add();

        IDataSet dataSet = builder.build();
        Path resourceDirectory = Paths.get("src/test/resources");

        File file = new File(resourceDirectory.toString() + "/datasetProgramaInsitucional.xml");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
        XmlDataSetWriter xmlDataSetWriter = new XmlDataSetWriter(new FileWriter(file), "UTF-8");
        xmlDataSetWriter.write(dataSet);

        System.out.println(file.getAbsolutePath());
    }
}
