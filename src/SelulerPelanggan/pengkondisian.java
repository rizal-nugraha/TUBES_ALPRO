package SelulerPelanggan;

import java.util.Scanner;

public class pengkondisian {
    SelulerPelanggan selulerPelanggan = new SelulerPelanggan();
    boolean found;
    int batasInput = 3;
    Scanner sc = new Scanner(System.in);

    public void tampilanMenu() {
        found = false;
        System.out.println("===PILIH MENU ===");
        System.out.println("1. Cek Pulsa");
        System.out.println("2. Kirim Pesan");
        System.out.println("3. Isi pulsa");
        System.out.println("4. Panggilan");
        System.out.println("00. Keluar");
        System.out.println("=================");

        while ((found == false) && batasInput > 0) {
            System.out.println("");
            System.out.print("PILIH MENU : ");
            int inputMenu = sc.nextInt();
            System.out.println("");

            switch (inputMenu) {
            case 1:
                selulerPelanggan.openFileBaca();
                selulerPelanggan.cekSaldo();
                selulerPelanggan.closeFileBaca();
                found = true;
                break;
            case 2:
                selulerPelanggan.openFileBaca();
                selulerPelanggan.kirimSMS();
                selulerPelanggan.closeFileBaca();
                selulerPelanggan.closeFileTulis();
                found = true;
                break;
            case 3:
                selulerPelanggan.openFileBaca();
                selulerPelanggan.deposit();
                selulerPelanggan.closeFileBaca();
                selulerPelanggan.closeFileTulis();
                found = true;
                break;
            case 4:
                selulerPelanggan.openFileBaca();
                selulerPelanggan.panggilan();
                selulerPelanggan.closeFileBaca();
                selulerPelanggan.closeFileTulis();
                found = true;
                break;
            case 00:
                System.out.println("TERIMA KASIH");
                System.exit(0);
            default:
                System.out.println("MENU TIDAK ADA");
                batasInput -= 1;
                if (batasInput == 0) {
                    System.out.println("SILAHKAN MEMASUKAN KODE USSD KEMBALI");
                }
            }
        }
    }
}
