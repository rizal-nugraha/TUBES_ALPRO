package selulerAdmin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;
import java.util.StringTokenizer;

public class programPelanggan {

    static long terimaEntryPerMasaaktif(String nomor, String masaaktif) throws IOException {
        FileReader fileInput = new FileReader("dataPelanggan.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        long entry = 0;
        String data = bufferInput.readLine();
        Scanner dataScanner;
        String primaryKey;

        while (data != null) {
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primaryKey = dataScanner.next();
            dataScanner = new Scanner(primaryKey);
            dataScanner.useDelimiter("_");

            nomor = nomor.replaceAll("\\s+", "");

            if (nomor.equalsIgnoreCase(dataScanner.next()) && masaaktif.equalsIgnoreCase(dataScanner.next())) {
                entry = dataScanner.nextInt();
            }

            data = bufferInput.readLine();
        }

        return entry;
    }

    static boolean cekPelangganDiDataPelanggan(String[] keywords, boolean template) throws IOException {

        FileReader fileInput = new FileReader("dataPelanggan.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false;
        int nomorData = 0;

        while (data != null) {

            // cek keywords didalam baris
            isExist = true;

            for (String keyword : keywords) {
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            // jika keywordsnya cocok maka tampilkan

            if (isExist) {
                if (template) {
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data, ",");

                    stringToken.nextToken();
                    System.out.printf(" %2d ,", nomorData);
                    System.out.printf("\t%4s ,", stringToken.nextToken());
                    System.out.printf("\t%-15s ,", stringToken.nextToken());
                    System.out.printf("\t%-10s ,", stringToken.nextToken());
                    System.out.printf("\t%s ;", stringToken.nextToken());
                    System.out.print("\n");
                } else {
                    break;
                }
            }

            data = bufferInput.readLine();
        }

        if (template) {
            System.out.println("<<<<<<<<<------------>>>>>>>>>");
        }
        return isExist;
    }

    protected static String terimaMasaaktif() throws IOException {
        boolean masaaktifValid = false;
        Scanner inputUser = new Scanner(System.in);
        String masaaktifInput = inputUser.nextLine();
        while (!masaaktifValid) {
            try {
                Year.parse(masaaktifInput);
                masaaktifValid = true;
            } catch (Exception e) {
                System.out.println("masukan (tahun habis masa aktif)");
                System.out.print("silahkan masukan masa aktif lagi: ");
                masaaktifValid = false;
                masaaktifInput = inputUser.nextLine();
            }
        }

        return masaaktifInput;
    }

    public static boolean getYaAtauTidak(String pesanyn) {
        Scanner inputUser = new Scanner(System.in);
        System.out.print("\n" + pesanyn + " y / n ? ");
        String inputanUser = inputUser.next();

        while (!inputanUser.equalsIgnoreCase("y") && !inputanUser.equalsIgnoreCase("n")) {
            System.err.println("pilihlah (y atau n)");
            System.out.print("\n" + pesanyn + " y / n ? ");
            inputanUser = inputUser.next();
        }

        return inputanUser.equalsIgnoreCase("y");

    }
}