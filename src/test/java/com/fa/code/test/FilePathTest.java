package com.fa.code.test;

import org.junit.Assert;
import org.junit.Test;

public class FilePathTest {
	private FilePath filePath;
	
	public FilePathTest() {
		this.filePath = new FilePath("src/test/resources/file_list.txt");
	}
	
	@Test
	public void testCurrentDir() {
		Assert.assertEquals(43335,filePath.getSize("."));
	}
	
	@Test
	public void testTopLevelDir(){
		Assert.assertEquals(247394,filePath.getSize("docs"));
	}
	
	@Test
	public void test2SubDirs(){
		Assert.assertEquals(3812,filePath.getSize("spec/rubygems/"));
	}
	
	@Test
	public void test3SubDirs(){
		Assert.assertEquals(9645,filePath.getSize("lib/yard/core_ext/"));
	}
	
	@Test
	public void test4SubDirs(){
		Assert.assertEquals(5273,filePath.getSize("templates/guide/fulldoc/html/css/"));
	}
	
	
	
}
