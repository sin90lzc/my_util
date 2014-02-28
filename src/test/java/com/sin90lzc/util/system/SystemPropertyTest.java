package com.sin90lzc.util.system;

import org.junit.Assert;
import org.junit.Test;

public class SystemPropertyTest {
	@Test
	public void testPrintSystemProperties() {
		//SystemProperty.printSystemProperties();
	}
	@Test
	public void testGetProjectRootDir(){
		String projectRootDir =SystemProperty.getProjectRootDir();
		Assert.assertTrue(projectRootDir != null
				&& (projectRootDir.endsWith("my_util")
						|| projectRootDir.endsWith("my_util/") || projectRootDir
							.endsWith("my_util\\")));
	}
}
