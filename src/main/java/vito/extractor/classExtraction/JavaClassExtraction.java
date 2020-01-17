package vito.extractor.classExtraction;

import vito.extractor.configEnums.FileTypeConfig;
import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import vito.extractor.configEnums.GenerationConfigEnum;

/**
 * @author Vito
 * @date 14/01/2020
 */
public class JavaClassExtraction {

    public List<File> listGetAllJavaClassesOfProject(File project) {
        return (List<File>) FileUtils.listFiles(new File(GenerationConfigEnum.MAIN_PATH.getName() + project.getName()), new String[]{FileTypeConfig.EXTENSION.getName()}, true);
    }
}
