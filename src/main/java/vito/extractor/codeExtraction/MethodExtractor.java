package vito.extractor.codeExtraction;

import vito.extractor.configEnums.RegexEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vito
 * @date 14/01/2020
 */
public class MethodExtractor {

    public List<String> extractContentMethods(String classContent) {
        List<String> out = new ArrayList();
        Pattern middlePattern = Pattern.compile(RegexEnum.METHOD_EXTRACTION.getName(), Pattern.DOTALL);
        Matcher m = middlePattern.matcher(classContent);
        while (m.find()) {
            out.add(m.group(1));
        }
        return out;
    }

    private String getLastMethod(List<String> in) {
        return in.get(in.size() - 1);
    }

    private List<String> filterLastMethod(List<String> in) {
        String last = getLastMethod(in);
        last = removeLastCharacter(last);
        in.set(in.size() - 1,last);
        return in;
    }

    private String removeLastCharacter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }

}
