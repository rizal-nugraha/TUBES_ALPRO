package Seluler;

import java.io.IOException;
import java.util.Scanner;

public class selulerMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		seluler r = new seluler();
		Scanner input = new Scanner(System.in);
		
		System.out.println("===PILIH MENU ===");
        System.out.println("1. Tambah Simcard");
        System.out.println("2. Ubah Simcard");
        System.out.println("2. Hapus Simcard");
        System.out.println("00. Keluar");
        System.out.println("=================");
        
		int nilai = input.nextInt();
		
		switch(nilai) {
		case 1 :
			r.tambahSimcard();
			r.tampilData();
			break;
		case 2 :
			r.tampilData();
			r.ubahData();
			r.tulisPerubahanData();
			r.tampilData();
			break;
		default :
			System.out.print("goblog");
		}
		

	}

}
