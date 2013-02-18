package freeencryptrepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
	
	public String getUserInput()
	{
		try {
			return new BufferedReader(new InputStreamReader(System.in)).readLine().toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	public void ToUser(String s)
	{
		System.out.println(s);
	}

}
