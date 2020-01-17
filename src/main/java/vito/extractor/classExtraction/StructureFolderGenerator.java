package vito.extractor.classExtraction;

import java.io.File;
import java.io.IOException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import vito.extractor.configEnums.GenerationConfigEnum;

/**
 * @author Vito
 * @date 14/01/2020
 */
public class StructureFolderGenerator {

    int snippetCounter = 1;
    @Getter
    @Setter
    private String currentProject = "";
    private File currentSnippetSubFolder = new File("");

    public File getFolderSnippets() {
        return new File(GenerationConfigEnum.PATH_OF_SINPPETS_GENERATION.getName());
    }

    public void generateSnippetFolder(String current) {
        currentSnippetSubFolder = new File(GenerationConfigEnum.PATH_OF_SINPPETS_GENERATION.getName() + "\\" + current + "\\" + currentProject + GenerationConfigEnum.NAME_SNIPPET_SEPARATOR.getName() + snippetCounter);
        currentSnippetSubFolder.mkdir();
        snippetCounter++;
    }
    
    public void createSnippetMaster(String method, String currentProject) throws IOException {
        this.currentProject = currentProject;
        populateSnippetFolder(method, "a", currentProject);
    }

    public void createSnippetBranch(String method, String currentProject) throws IOException {
        this.currentProject = currentProject;
        populateSnippetFolder(method, "b", currentProject);
    }

    private void populateSnippetFolder(String method, String fileName, String pathGeneration) throws IOException {
        generateSnippetFolder(pathGeneration);
        File methodContentFile = new File(currentSnippetSubFolder.getPath() + "\\" + fileName + GenerationConfigEnum.EXTENSION_GENERATED_FILE.getName());
        FileUtils.writeStringToFile(methodContentFile, method);
    }

    // Test
    public static void main(String[] args) throws IOException {
        StructureFolderGenerator folderGenerator = new StructureFolderGenerator();
        folderGenerator.createSnippetMaster("teste", "netbeans");
    }
}