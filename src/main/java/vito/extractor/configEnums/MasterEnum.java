package vito.extractor.configEnums;

import lombok.Getter;

/**
 * @author Vito
 * @date 14/01/2020
 */

public enum MasterEnum {
    PATH("C:\\Users\\73464244172\\Desktop\\ant-ivy-rel-2.5.0-master\\");
    
    MasterEnum(String name) {
        this.name = name;
    }
 
    @Getter
    private String name;
}
