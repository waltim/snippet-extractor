package vito.extractor.folderUtil;

import vito.extractor.configEnums.GenerationConfigEnum;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vito
 * @date 14/01/2020
 */
public class FolderExtractor {
    public List<File> getProjectFolders(){
        
        return pathListToFileList(getMainFolder().list());
    }
    
    
    public List<File> getNonMainProjects(){
        List<File> out = getProjectFolders();
        out.removeAll(getMainProjects());
        return out;
    }
    
    public List<File> getMainProjects(){
        List<File> out = new ArrayList<>();
        for(File project : getProjectFolders()){
            if(project.getAbsolutePath().contains(GenerationConfigEnum.MASTER_INDICATOR.getName())){
                out.add(project);
            }
        }
        return out;
    }
    
    private File getMainFolder(){
        return new File(GenerationConfigEnum.MAIN_PATH.getName());
    }

    private List<File> pathListToFileList(String[] paths){
        List<File> out = new ArrayList<>();
        for(String path:paths){
            out.add(new File(path));
        }
        return out;
    }
    
}