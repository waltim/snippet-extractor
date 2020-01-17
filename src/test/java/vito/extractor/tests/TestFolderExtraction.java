package vito.extractor.tests;

import org.junit.Test;
import org.junit.Assert;

import vito.extractor.folderUtil.FolderExtractor;

/**
 * @author Vito, the best programmer
 * @date 14/01/2020
 */
public class TestFolderExtraction {

    private final FolderExtractor folderExtractor = new FolderExtractor();

    @Test
    public void testMultipleProjects() {
        Assert.assertTrue(folderExtractor.getProjectFolders().size() > 1);
    }

    @Test
    public void testNonMasterProjects() {
        Assert.assertTrue(folderExtractor.getNonMainProjects().size() > 0);
    }

    @Test
    public void testMasterProject() {
        Assert.assertTrue(folderExtractor.getMainProjects().size() == 1);
    }
}