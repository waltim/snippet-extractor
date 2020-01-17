package vito.extractor.tests;

import org.junit.Test;
import org.junit.Assert;
import vito.extractor.classExtraction.JavaClassExtraction;

import vito.extractor.folderUtil.FolderExtractor;

/**
 * @author Vito, the best programmer
 * @date 14/01/2020
 */
public class TestClassFolderExtraction {

    private final JavaClassExtraction javaClassExtraction = new JavaClassExtraction();
    private final FolderExtractor folderExtractor = new FolderExtractor();

    @Test
    public void testMultipleProjects() {
        Assert.assertTrue(javaClassExtraction.listGetAllJavaClassesOfProject(folderExtractor.getMainProjects().get(0)).size() > 0);
        System.out.println(javaClassExtraction.listGetAllJavaClassesOfProject(folderExtractor.getMainProjects().get(0)).size());
    }
}