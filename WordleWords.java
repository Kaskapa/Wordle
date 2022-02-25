package lv.jak.veveris;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class WordleWords{
	public String getAnwer() {
		Random rand = new Random();
		String lineIWant = "";
		try {
			
			FileInputStream fs= new FileInputStream("C:\\Users\\krist\\OneDrive\\Documents\\Eclipse\\workspace_1p\\Personal Projects\\src\\lv\\jak\\veveris\\words.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for(int i = 0; i < rand.nextInt(5757); i++) {
				br.readLine();
			}
			lineIWant = br.readLine();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineIWant;
		
		
	}
	public boolean contains(String guess) {
		boolean check = false;
		try {
			
			FileInputStream fs= new FileInputStream("C:\\Users\\krist\\OneDrive\\Documents\\Eclipse\\workspace_1p\\Personal Projects\\src\\lv\\jak\\veveris\\words.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for(int i = 0; i < 5757; i++) {
				if(br.readLine().toUpperCase().equals(guess)) {
					check = true;
				}
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(check) {
			return true;
		}
		else{
			return false;
		}
	}
}

//"C:\\Users\\krist\\OneDrive\\Documents\\Eclipse\\workspace_1p\\Personal Projects\\src\\lv\\jak\\veveris\\words.txt"
