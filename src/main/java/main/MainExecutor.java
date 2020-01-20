package main;

import java.io.IOException;
import vito.extractor.codeExtraction.SnippetGenerator;

/**
 * @author Vito
 * @date 14/01/2020
 *
 *
 * RUN HERE TO EXTRACT SNIPPETS Check your paths if an IOExeption is thrown
 */
public class MainExecutor {

    public static void main(String[] args) throws IOException {
        SnippetGenerator snippetGenerator = new SnippetGenerator();
        snippetGenerator.populateFolderBranchesWithSnippets();

    }
}
