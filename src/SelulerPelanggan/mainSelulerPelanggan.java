package SelulerPelanggan;

import java.util.Scanner;

public class mainSelulerPelanggan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int KodeUSSD = 888;

        pengkondisian kondisi = new pengkondisian();
        boolean ulangiTransaksi = true;
        int transaksiLagi;

        while (ulangiTransaksi == true) {
            System.out.println(" == Telepon Seluler ==");

            System.out.print("MASUKAN KodeUSSD : ");
            int inputKodeUSSD = sc.nextInt();
            if (inputKodeUSSD == KodeUSSD) {
                System.out.println("");
                System.out.println("======= Kode USSD Sedang berjalan =======");
                System.out.println("");
                kondisi.tampilanMenu();
            } else {
                System.out.println("[***Kode USSD yang anda masukan salah***]");
                if (inputKodeUSSD != 888) {
                    System.out.println("[Salah membasukan kode USSD]");
                }
            }

            System.out.println("pilih menu lain?");
            System.out.println("1 = ya, 0 = tidak");
            System.out.println("=================");
            System.out.println("");

            transaksiLagi = sc.nextInt();
            if (transaksiLagi != 0) {
                if (transaksiLagi == 1) {
                    ulangiTransaksi = true;
                } else {
                    ulangiTransaksi = false;
                    System.out.println("SALAH INPUT!!!");
                }
            } else {
                ulangiTransaksi = false;
                System.out.println("TERIMA KASIH !!!");
            }
        }
    }
}
