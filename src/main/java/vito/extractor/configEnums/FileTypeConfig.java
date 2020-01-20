package vito.extractor.configEnums;

import lombok.Getter;

/**
 * @author Vito
 * @date 14/01/2020
 */
public enum FileTypeConfig {
    EXTENSION("java");

    FileTypeConfig(String name) {
        this.name = name;
    }
 
    @Getter
    private String name;
}