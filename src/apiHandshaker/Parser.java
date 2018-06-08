package apiHandshaker;

import java.util.Scanner;

public class Parser {

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		String input = "";
		while (true) 
		{
			input = scan.nextLine();
			if (!input.isEmpty())
			{
				break;
			}
		}
		scan.close();
		String[] x = parse(input);
		System.out.println(x[0]);
	}
	
	private static String[] parse(String data)
	{
		data = data.split("\\[")[1];
		String[] onDataEntities = data.split("\\}\\},\\{");
		String[] test = null;
		for (int i = 0; i < onDataEntities.length; i++)
		{
			//Clean each String from '{','}','"' and then split
			String[] variableValuePairs = onDataEntities[i].replaceAll("\\{|\\}|\"","").split(",");	
			test = variableValuePairs;
		}	
		return test;
	}
}
