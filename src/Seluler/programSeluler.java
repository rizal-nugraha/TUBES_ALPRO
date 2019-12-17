package seluler;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class programSeluler {
    public static void ubahDataPelanggan() throws IOException {
        // terima dataPelanggan
        File dataPelanggan = new File("DataPelanggan.txt");
        FileReader fileInput = new FileReader(dataPelanggan);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // dataPelanggan sementara
        File datPel = new File("datPel.txt");
        FileWriter fileOutput = new FileWriter(datPel);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
        System.out.println("List Pelanggan");
        tampilDataPelanggan();

        // terima user input / pilihan data
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nnomor pelanggan yang akan diubah: ");
        int ubahDtPel = userInput.nextInt();

        // tampilkan data yang ingin diubah

        String data = bufferedInput.readLine();
        int entryCounts = 0;

        while (data != null) {
            entryCounts++;

            StringTokenizer st = new StringTokenizer(data, ",");

            // tampilkan entrycounts == ubahDtPel
            if (ubahDtPel == entryCounts) {
                System.out.println("\nData yang ingin diubah :");
                System.out.println("<<<<<<----------------->>>>>>");
                System.out.println("Kuota           : " + st.nextToken());
                System.out.println("Masaaktif       : " + st.nextToken());
                System.out.println("Nomor           : " + st.nextToken());
                System.out.println("Pulsa           : " + st.nextToken());
                System.out.println("Nama            : " + st.nextToken());

                // ubah data

                // mengterima input dari user

                String[] tabelDataPelanggan = { "masaaktif", "nomor", "pulsa", "nama" };
                String[] datPel1 = new String[4];

                st = new StringTokenizer(data, ",");
                String originalData = st.nextToken();

                for (int i = 0; i < tabelDataPelanggan.length; i++) {
                    boolean iniUbah = programPelanggan
                            .getYaAtauTidak("apakah anda ingin merubah " + tabelDataPelanggan[i]);
                    originalData = st.nextToken();
                    if (iniUbah) {
                        // user input

                        if (tabelDataPelanggan[i].equalsIgnoreCase("masaaktif")) {
                            System.out.print(" masa aktif, (masa aktif simcard): ");
                            datPel1[i] = programPelanggan.terimaMasaaktif();
                        } else {
                            userInput = new Scanner(System.in);
                            System.out.print("\n " + tabelDataPelanggan[i] + " baru: ");
                            datPel1[i] = userInput.nextLine();
                        }

                    } else {
                        datPel1[i] = originalData;
                    }
                }

                // tampilkan data baru ke layar
                st = new StringTokenizer(data, ",");
                st.nextToken();
                System.out.println("\nData baru anda adalah ");
                System.out.println("Masaaktif     : " + st.nextToken() + " => " + datPel1[0]);
                System.out.println("Nomor         : " + st.nextToken() + " => " + datPel1[1]);
                System.out.println("Pulsa         : " + st.nextToken() + " => " + datPel1[2]);
                System.out.println("Nama          : " + st.nextToken() + " => " + datPel1[3]);

                boolean iniUbah = programPelanggan.getYaAtauTidak("apakah anda yakin ingin mengubah data tersebut");

                if (iniUbah) {

                    // cek data baru di dataPelanggan
                    boolean isExist = programPelanggan.cekPelangganDiDataPelanggan(datPel1, false);

                    if (isExist) {
                        System.err.println(
                                "data pelanggan sudah ada di dataPelanggan, proses ubah dibatalkan, \nsilahkan hapus data yang bersangkutan");
                        // copy data
                        bufferedOutput.write(data);

                    } else {

                        // format data baru kedalam dataPelanggan
                        String masaaktif = datPel1[0];
                        String nomor = datPel1[1];
                        String pulsa = datPel1[2];
                        String nama = datPel1[3];

                        // kita bikin primary key
                        long nomorEntry = programPelanggan.terimaEntryPerMasaaktif(nomor, masaaktif) + 1;

                        String punulisTanpaSpasi = nomor.replaceAll("\\s+", "");
                        String idSimcard = punulisTanpaSpasi + "_" + masaaktif + "_" + nomorEntry;

                        // tulis data ke dataPelanggan
                        bufferedOutput.write(idSimcard + "," + masaaktif + "," + nomor + "," + pulsa + "," + nama);
                    }
                } else {
                    // copy data
                    bufferedOutput.write(data);
                }
            } else {
                // copy data
                bufferedOutput.write(data);
            }
            bufferedOutput.newLine();

            data = bufferedInput.readLine();
        }

        // menulis data ke file
        bufferedOutput.flush();

        // rename file datPel menjadi dataPelanggan
        datPel.renameTo(dataPelanggan);

    }

    public static void hapusDataPelanggan() throws IOException {
        // kita terima dataPelanggan original
        File dataPelanggan = new File("DataPelanggan.txt");
        FileReader fileInput = new FileReader(dataPelanggan);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // kita buat dataPelanggan sementara
        File datPel = new File("datPel.txt");
        FileWriter fileOutput = new FileWriter(datPel);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
        System.out.println("List Pelanggan");
        tampilDataPelanggan();

        // kita terima user input untuk menhapus data
        Scanner userInput = new Scanner(System.in);
        System.out.print("\n nomor pelanggan yang akan dihapus: ");
        int hapusNum = userInput.nextInt();

        boolean isFound = false;
        int entryCounts = 0;

        String data = bufferedInput.readLine();

        while (data != null) {
            entryCounts++;
            boolean iniHapus = false;

            StringTokenizer strt = new StringTokenizer(data, ",");

            // tampilkan data yang ingin di hapus
            if (hapusNum == entryCounts) {
                System.out.println("\nData yang ingin dihapus adalah:");
                System.out.println("-----------------------------------");
                System.out.println("Kuota  : " + strt.nextToken());
                System.out.println("Masaaktif      : " + strt.nextToken());
                System.out.println("Nomor    : " + strt.nextToken());
                System.out.println("Pulsa   : " + strt.nextToken());
                System.out.println("Nama      : " + strt.nextToken());

                iniHapus = programPelanggan.getYaAtauTidak("Yakin ingin menghapus?");
                isFound = true;
            }

            if (iniHapus) {
                System.out.println("Data berhasil dihapus");
            } else {
                // kita pindahkan data dari original ke sementara
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }

        if (!isFound) {
            System.err.println("Pelanggan tidak ditemukan");
        }

        // menulis data ke file
        bufferedOutput.flush();

        // rename file sementara ke dataPelanggan
        datPel.renameTo(dataPelanggan);

    }

    public static void tampilDataPelanggan() throws IOException {

        FileReader fileInput;
        BufferedReader bufferInput;

        try {
            fileInput = new FileReader("dataPelanggan.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("Data pelanggan tidak ada");
            System.err.println("tambah data terlebih dahulu");
            tambahData();
            return;
        }

        String data = bufferInput.readLine();
        int nomorData = 0;
        while (data != null) {
            nomorData++;

            StringTokenizer strTokens = new StringTokenizer(data, ",");

            strTokens.nextToken();
            System.out.printf("%2d .", nomorData);
            System.out.printf("\t%4s ,", strTokens.nextToken());
            System.out.printf("\t%-20s ,", strTokens.nextToken());
            System.out.printf("\t%-10s ,", strTokens.nextToken());
            System.out.printf("\t%s ;", strTokens.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

    }

    public static void cariDataPelanggan() throws IOException {

        // membaca dataPelanggan ada atau tidak

        try {
            File file = new File("DataPelanggan.txt");
        } catch (Exception e) {
            System.err.println("Data pelanggan tidak ada");
            System.err.println("tambah data terlebih dulu");
            tambahData();
            return;
        }

        // kita terima keyword dari user

        Scanner userInput = new Scanner(System.in);
        System.out.print(" kata kunci untuk mencari pelanggan: ");
        String cariString = userInput.nextLine();
        String[] keywords = cariString.split("\\s+");

        // cek keyword di dataPelanggan
        programPelanggan.cekPelangganDiDataPelanggan(keywords, true);

    }

    public static void tambahData() throws IOException {

        FileWriter fileOutput = new FileWriter("DataPelanggan.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        // mengterima input dari user
        Scanner userInput = new Scanner(System.in);
        String nomor, nama, pulsa, masaaktif;

        System.out.print("nomor Simcard: ");
        nomor = userInput.nextLine();
        System.out.print("nama pelanggan: ");
        nama = userInput.nextLine();
        System.out.print("Jumlah pulsa: ");
        pulsa = userInput.nextLine();
        System.out.print("masa aktif, (masa aktif simcard): ");
        masaaktif = programPelanggan.terimaMasaaktif();

        // cek pelanggan di dataPelanggan

        String[] keywords = { masaaktif + "," + nomor + "," + pulsa + "," + nama };
        System.out.println(Arrays.toString(keywords));

        boolean isExist = programPelanggan.cekPelangganDiDataPelanggan(keywords, false);

        // menulis pelanggan di databse
        if (!isExist) {

            System.out.println(programPelanggan.terimaEntryPerMasaaktif(nomor, masaaktif));
            long nomorEntry = programPelanggan.terimaEntryPerMasaaktif(nomor, masaaktif) + 1;

            String punulisTanpaSpasi = nomor.replaceAll("\\s+", "");
            String idSimcard = punulisTanpaSpasi + "_" + masaaktif + "_" + nomorEntry;
            System.out.println("\nData yang Simcard");
            System.out.println("ID-SimCard  : " + idSimcard);
            System.out.println("masa aktif  : " + masaaktif);
            System.out.println("nomor       : " + nomor);
            System.out.println("nama        : " + nama);
            System.out.println("pulsa       : " + pulsa);

            boolean isTambah = programPelanggan.getYaAtauTidak("Apakah ingin menambah data ini? ");

            if (isTambah) {
                bufferOutput.write(idSimcard + "," + masaaktif + "," + nomor + "," + pulsa + "," + nama);
                bufferOutput.newLine();
                bufferOutput.flush();
            }

        } else {
            System.out.println("pelanggan yang anda inputkan sudah ada di dataPelanggan dengan data dibawah ini:");
            programPelanggan.cekPelangganDiDataPelanggan(keywords, true);
        }

        bufferOutput.close();
    }

}