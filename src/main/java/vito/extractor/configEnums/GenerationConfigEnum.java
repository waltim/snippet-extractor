package vito.extractor.configEnums;

import lombok.Getter;

/**
 * @author Vito
 * @date 14/01/2020
 */

public enum GenerationConfigEnum {
    MASTER_INDICATOR("master"),
    MAIN_PATH("C:\\Users\\73464244172\\Desktop\\"),
    PATH_OF_SINPPETS_GENERATION("E:\\snippetsValder\\"),
    NAME_SNIPPET_SEPARATOR(" snippet - "),
    EXTENSION_GENERATED_FILE(".txt");
    

    GenerationConfigEnum(String name) {
        this.name = name;
    }
 
    @Getter
    private String name;
}