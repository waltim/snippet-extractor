package vito.extractor.codeExtraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import vito.extractor.classExtraction.JavaClassExtraction;
import vito.extractor.classExtraction.StructureFolderGenerator;
import vito.extractor.configEnums.BranchesEnum;
import vito.extractor.configEnums.GenerationConfigEnum;
import vito.extractor.configEnums.MasterEnum;

/**
 * @author Vito
 * @date 14/01/2020
 */
public class SnippetGenerator {

    private final JavaClassExtraction javaClassExtraction = new JavaClassExtraction();

    public List<String> listAllMethodsOfBranch(String branchPath) throws IOException {
        List<String> listMethod = new ArrayList<>();
        final MethodExtractor methodExtractor = new MethodExtractor();
        List<File> classes = javaClassExtraction.listGetAllJavaClassesOfProject(new File(branchPath));
        for (File currentFileExtraction : classes) {
            listMethod.addAll(methodExtractor.extractContentMethods(getStringOfFile(currentFileExtraction)));
        }
        return listMethod;
    }

    public String getStringOfFile(File fileClass) throws IOException {
        return FileUtils.readFileToString(fileClass);
    }

    public void generateAllSnippets(BranchesEnum branchesEnum) throws IOException {
        final StructureFolderGenerator structureFolderGenerator = new StructureFolderGenerator();
        structureFolderGenerator.setCurrentProject(branchesEnum.toString().toLowerCase());
            
        List<String> listMethods = listAllMethodsOfBranch(branchesEnum.getName());
        //System.out.println("    Processando branch " + branchesEnum.getName());
        
        //System.out.println("");
        int contador = 0;
        int total = listMethods.size();
        
        System.out.println(" " + branchesEnum.toString() + " : "+ total);
        
        generateMasterSnippets(branchesEnum.toString().toLowerCase());
        for (String method : listMethods) {
            //System.out.println("        processando " + contador + " de " + total);
            contador++;
            structureFolderGenerator.createSnippetBranch(method, branchesEnum.toString().toLowerCase());
        }
    }

    public void generateMasterSnippets(String folder) throws IOException {
        final StructureFolderGenerator structureFolderGenerator = new StructureFolderGenerator();
        System.out.println("Master : " + listAllMethodsOfBranch(MasterEnum.PATH.getName()).size());
        for (String method : listAllMethodsOfBranch(MasterEnum.PATH.getName())) {
            structureFolderGenerator.createSnippetMaster(method, folder);
        }
    }

    public boolean validateProjectFolder(File directoryProject) {
        return !directoryProject.exists();
    }

    public List<File> generateFolderStructureBranches() {
        List<File> out = new ArrayList<>();
        for (BranchesEnum branch : BranchesEnum.values()) {
            File directoryProject = new File(GenerationConfigEnum.PATH_OF_SINPPETS_GENERATION.getName() + branch.toString().toLowerCase());
            out.add(directoryProject);
            if (validateProjectFolder(directoryProject)) {
                directoryProject.mkdir();
            }

        }
        return out;
    }

    public void populateFolderBranchesWithSnippets() throws IOException {
        for (BranchesEnum branchesEnum : BranchesEnum.values()) {
            System.out.println("Generating project : " + branchesEnum);
            generateAllSnippets(branchesEnum);
        }
    }
}
