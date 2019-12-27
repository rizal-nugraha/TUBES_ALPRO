package SelulerPelanggan;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;

public class SelulerPelanggan {
    Scanner sc = new Scanner(System.in);
    BufferedInputStream bis = null;
    PrintWriter pw = null;

    char ch;
    String isiPulsaTxt, konversiString, SMS;
    int data, konversiInt, biayaSms = 1000, transaksi, IsiSaldo;

    public void cekSaldo() {
        try {
            data = bis.read();
            ch = 0;
            System.out.print("Sisa Pulsa Anda : Rp. ");
            while (data != -1) {
                ch = (char) data;
                System.out.print(ch);
                data = bis.read();
            }
            System.out.println("");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    public void tarikTunai() {
        try {
            data = bis.read();
            ch = 0;
            isiPulsaTxt = "";
            while (data != -1) {
                ch = (char) data;
                isiPulsaTxt += ch;
                data = bis.read();
            }
            konversiInt = Integer.parseInt(isiPulsaTxt);
            System.out.println("Sisa Pulsa Anda: Rp. " + isiPulsaTxt);

            System.out.print("Kirim pesan : ");
            SMS = sc.nextLine();
            transaksi = konversiInt - biayaSms;
            konversiString = Integer.toString(transaksi);
            openFileTulis();
            pw.print(konversiString);

            System.out.println("Sisa Pulsa Anda: Rp. " + transaksi);
            System.out.println("");
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        }
    }

    public void deposit() {
        try {
            data = bis.read();
            ch = 0;
            isiPulsaTxt = "";
            while (data != -1) {
                ch = (char) data;
                isiPulsaTxt += ch;
                data = bis.read();
            }
            konversiInt = Integer.parseInt(isiPulsaTxt);
            System.out.println("Sisa pulsa anda: Rp. " + isiPulsaTxt);

            System.out.println("Silahkan pilih Mau isi Pulsa berapa : ");
            System.out.println("1. Rp.5.000");
            System.out.println("2. Rp.10.000");
            System.out.println("3. Rp.20.000");
            System.out.println("4. Rp.25.000");
            System.out.println("5. Rp.50.000");
            System.out.println("6. Rp.100.000");

            System.out.print("pilih nomor : ");

            int pengisisanPulsa = sc.nextInt();

            switch (pengisisanPulsa) {
            case 1:
                transaksi = konversiInt + 5000;
                konversiString = Integer.toString(transaksi);
                openFileTulis();
                pw.print(konversiString);
                System.out.println("");
                System.out.println("Sisa Pulsa Anda SEKARANG : Rp. " + transaksi);
                System.out.println("");
                break;
            case 2:
                transaksi = konversiInt + 10000;
                konversiString = Integer.toString(transaksi);
                openFileTulis();
                pw.print(konversiString);
                System.out.println("");
                System.out.println("Sisa Pulsa Anda SEKARANG : Rp. " + transaksi);
                System.out.println("");
                break;
            case 3:
                transaksi = konversiInt + 20000;
                konversiString = Integer.toString(transaksi);
                openFileTulis();
                pw.print(konversiString);
                System.out.println("");
                System.out.println("Sisa Pulsa Anda SEKARANG : Rp. " + transaksi);
                System.out.println("");
                break;
            case 4:
                transaksi = konversiInt + 25000;
                konversiString = Integer.toString(transaksi);
                openFileTulis();
                pw.print(konversiString);
                System.out.println("");
                System.out.println("Sisa Pulsa Anda SEKARANG : Rp. " + transaksi);
                System.out.println("");
                break;
            case 5:
                transaksi = konversiInt + 50000;
                konversiString = Integer.toString(transaksi);
                openFileTulis();
                pw.print(konversiString);
                System.out.println("");
                System.out.println("Sisa Pulsa Anda SEKARANG : Rp. " + transaksi);
                System.out.println("");
                break;
            case 6:
                transaksi = konversiInt + 100000;
                konversiString = Integer.toString(transaksi);
                openFileTulis();
                pw.print(konversiString);
                System.out.println("");
                System.out.println("Sisa Pulsa Anda SEKARANG : Rp. " + transaksi);
                System.out.println("");
                break;

            default:
                System.out.println("MENU TIDAK ADA");

            }
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        }
    }

    public void openFileBaca() {
        try {
            bis = new BufferedInputStream(new FileInputStream("Pulsa.txt"));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void openFileTulis() {
        try {
            pw = new PrintWriter("Pulsa.txt");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeFileBaca() {
        try {
            if (bis != null) {
                bis.close();
            }
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    public void closeFileTulis() {
        if (pw != null) {
            pw.close();
        }
    }

}
