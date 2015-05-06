import java.util.Scanner;
import java.io.*;

public class Main{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean inProgress = true;
		String pathname = "";
		//ask user for pathname input
		while(inProgress){
			try{
				System.out.println("What is the file name");
				pathname = sc.nextLine();
				sc.close();
				sc = new Scanner(new File(pathname));
				inProgress = false;
			}catch(FileNotFoundException f){
				System.out.println("Invalid file, please try again");
				sc = new Scanner(System.in);
			}
		}
		
		try{
			//figure out how long file is
			int lines = 0;
			while(sc.hasNextLine()){
				sc.nextLine();
				lines++;
			}
			sc.close();
			sc = new Scanner(new File(pathname));
			
			//grab all lines of code in an array
			String[] codeLines = new String[lines];
			for(int i = 0; i < codeLines.length; i++){
				codeLines[i] = sc.nextLine();
			}
			sc.close();
			
			int k = 1;
			for(int i = 0; i < codeLines.length; i++){
				char[] characters = codeLines[i].toCharArray();
				
				for(int j = 0; j < characters.length; j++){
					
					File outputFile = new File("test\\"+k+".txt");
					outputFile.createNewFile();
					BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
					bw.write(characters[j]);
					bw.close();
					k++;
				}
				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	
}