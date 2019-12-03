package Seluler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class seluler {
	
	
static Scanner sc = new Scanner(System.in);
static StringBuffer stringBufferOfdata = new StringBuffer();

<<<<<<< HEAD
public static void tambahSimcard() {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter outFile;
	try {
		
		outFile = new BufferedWriter(new FileWriter("data.txt", true));
		System.out.print("masukan nomor : ");
		String nomor = br.readLine();
		outFile.write("nomor : " + nomor);
		System.out.print("masukan pulsa : ");
		String pulsa = br.readLine();
		outFile.write(" sisa pulsa : " + pulsa + "\n");
		outFile.close();	
	} catch (IOException e) {
		System.out.println(e);
	}
	
}
=======
>>>>>>> tambah data simcard

public static void tampilData() {
	
	BufferedReader inFile = null;
	try {
		inFile = new BufferedReader(new FileReader("data.txt"));
		
		String text = inFile.readLine();
		while (text != null) {
			System.out.println(text);
			text = inFile.readLine();
		}
		inFile.close();
	} catch (IOException e) {
		System.out.println(e);
	}
	
}

public static void ubahData() {
	System.out.println("Masukkan nomor simcard yang akan di ubah:");
	String lineToEdit = sc.nextLine();
	System.out.println("Masukkan nomor simcard Baru:");
	String replacementText = sc.nextLine();
	
	int startIndex = stringBufferOfdata.indexOf(lineToEdit);
	int endIndex = startIndex + lineToEdit.length();
	stringBufferOfdata.replace(startIndex, endIndex, replacementText);
	System.out.println("Data yang telah ubah:\n"+stringBufferOfdata);
}

public static void tulisPerubahanData() throws IOException {
	try {
		BufferedWriter bufwriter = new BufferedWriter(new FileWriter("data.txt"));
		bufwriter.write(stringBufferOfdata.toString());
		bufwriter.close();
	} catch (Exception e) {
		System.out.println("masukkan ulang"+e.getMessage());
	}
}
}
