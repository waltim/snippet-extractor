package vito.extractor.configEnums;

import lombok.Getter;

/**
 * @author Vito
 * @date 14/01/2020
 */

public enum RegexEnum {
    METHOD_EXTRACTION("((public|protected|private|static) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*?)(public|protected|private|static|\\Z)");

    RegexEnum(String name) {
        this.name = name;
    }

    @Getter
    private String name;
}