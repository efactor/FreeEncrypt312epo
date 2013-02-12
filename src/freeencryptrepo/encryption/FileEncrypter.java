package freeencryptrepo.encryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class FileEncrypter {
	
	public boolean encryptFilesinFolder(String folderpath)
	{
		File directoryPath = new File(folderpath);
		File encryptedFolderPath = new File(directoryPath.getParent()+"\\"+directoryPath.getName()+"FER");
		if(!encryptedFolderPath.exists())
		{
			if(!encryptedFolderPath.mkdir())
				// if the destination path is unable to be created, then don't worry about encrypting the files when there is no place to put them
				return false;
		}
		for(String filename : directoryPath.list())
		{
			File current = new File(directoryPath.getAbsolutePath()+filename);
			if(current.isFile())
			{
				
			}
			else
			{
				
			}
			//encrypt the contents
			
			//create a file with the encrypted contents
			
			//put the encrypted contents into a file 
		}
		return true;
	}
	
	public String encryptFileName(File f)
	{
		return "";
	}
	public String encryptFileContents(File f)
	{
		return "";
	}
	
	/* @param File f - the file where the contents will be written
	 * 			String contents - the contents of the file being written
	 * 
	 * @returns true or false based on whether the file was written or not
	 */
	public boolean FWriter(File f, String contents)
	{
		PrintWriter pw;
		
		try{ pw = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
			pw.append(contents);
			pw.close();
			return true;
		}
		catch(IOException ioe)
		{
			return false;
		}
	}
	/*
	 * @param File f - the file to be read and the contents returned
	 * 
	 * @returns the contents of the file being read or the reason the read failed (an exception occured)
	 */
	public String FReader(File f)
	{
		BufferedReader br;
		try{
			br = new BufferedReader(new FileReader(f));
			String line;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine())!=null)
			{
				sb.append(line);
			}
			return sb.toString();
			
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
			return "FileNotFoundException";
		}
		catch (IOException e) {
			e.printStackTrace();
			return "IOException";
		}
		
	}
	
}
