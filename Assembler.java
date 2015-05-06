import java.util.Scanner;
import java.io.*;

public class Assembler{
	
	public static void main(String[] args)throws IOException{
		
		int k = 1;
		File file = new File("test\\"+k+".txt");
		while(file.exists()){
			k++;
			file= new File("test\\"+k+".txt");
		}
		k--;
		BufferedWriter bw = new BufferedWriter(new FileWriter("Assembled.txt"));
		for(int i = 1; i <=k; i++){
			Scanner sc = new Scanner(new File("test\\"+i+".txt"));
			char thing = sc.nextLine().charAt(0);
			bw.write(thing);
		}
		bw.close();
		
	}
	
}