package selulerAdmin;

import java.io.IOException;
import java.util.Scanner;

public class selulerMain {
    public static void main(String[] args) throws IOException {

        Scanner userInput = new Scanner(System.in);
        String inputanUser;
        boolean pilihanUser = true;

        while (pilihanUser) {
            System.out.println("<<---MENU DATA SELULER--->>");
            System.out.println("1." + "Tampilkan daftar pelanggan");
            System.out.println("2." + "Tambah data pelanggan");
            System.out.println("3." + "Ubah data pelanggan");
            System.out.println("4." + "Hapus data pelanggan");
            System.out.println("5." + "Cari data pelanggan");
            System.out.println("6." + "Tampilkan daftar pelanggan Terkini");

            System.out.print("\npilih nomor : ");
            inputanUser = userInput.next();

            switch (inputanUser) {
            case "1":
                System.out.println("<<<<<<<<<<<<<<<<<<<<<< DAFTAR PELANGGAN >>>>>>>>>>>>>>>>>>>>>");
                programSeluler.tampilDataPelanggan();
                break;
            case "2":
                System.out.println("TAMBAH DATA PELANGGAN");
                programSeluler.tambahData();
                programSeluler.tampilDataPelanggan();
                break;
            case "3":
                System.out.println("UBAH DATA PELANGGAN");
                programSeluler.ubahDataPelanggan();
                break;
            case "4":
                System.out.println("HAPUS DATA PELANGGAN");
                programSeluler.hapusDataPelanggan();
                break;
            case "5":
                System.out.println("CARI PELANGGAN");
                programSeluler.cariDataPelanggan();
                break;
            case "6":
                System.out.println("<<<<<<<<<<<<<<<<<<<<<< DAFTAR PELANGGAN TERKINI >>>>>>>>>>>>>>>>>>>>>");
                programSeluler.tampilDataPelangganBaru();
                break;
            default:
                System.err.println("\nInputan tidak ditemukan\nSilahkan pilih menu 1-5");
            }

            pilihanUser = programPelanggan.getYaAtauTidak("Apakah melanjutkan ke menu lain?");
        }
    }

}