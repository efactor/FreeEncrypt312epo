package freeencryptrepo.test;

import java.io.File;

import freeencryptrepo.cipher.*;
import freeencryptrepo.UI.*;
import freeencryptrepo.cipher.FileEncrypter;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	String repo = "C:\\Users\\Pro\\Documents\\GitHub\\EncryptedRepo";
	File repoDir = new File(repo);
	String encryptedRepo = repoDir.getParent()+"\\"+repoDir.getName()+"FER";
	String key = "password";	
	
		new FileEncrypter().encryptFilesinFolder(key, repo);
		int result = new UI().PopupDialog();
		while(!new UI().checkPopupResult(result))
		{
			
		}
		//user confirmed the repo has been committed so now the source files can be moved back 
		
		StringBuffer salts = new StringBuffer();
		for(String s : new FileEncrypter().getSalts())
		{
			salts.append(s+"\n");
		}
		new FileEncrypter().FWriter(new File(repo+"\\"+"salts.txt"), salts.toString());
		StringBuffer source_filenames = new StringBuffer();
		for(String s : new FileEncrypter().getSourceFilenames())
		{
			source_filenames.append(s+"\n");
		}
		new FileEncrypter().FWriter(new File(repo+"\\"+"source_filenames.txt"), salts.toString());
		new FileRelocator().removeAllEncryptedFiles(repo);
		new FileRelocator().moveAllFiles(encryptedRepo, repo);
		
	}

}
