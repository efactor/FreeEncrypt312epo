package freeencryptrepo.UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	public void toUser(String s)
	{
		System.out.println(s);
	}
	
	/*
	 * wait until the method returns JOptionPane.OK_OPTION as the result
	 * 
	 */
	public int PopupDialog()
	{
		String prompt = "Click OK once the repo commit has finished.";
		JFrame jf = new JFrame("Waiting...");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JOptionPane.showMessageDialog(jf, );
		return JOptionPane.showConfirmDialog(jf, prompt,
			       "Waiting...", JOptionPane.PLAIN_MESSAGE);
	}

	public boolean checkPopupResult(int result)
	{
		if(result==JOptionPane.OK_OPTION)
			return true;
		else
			return false;
	}
}
