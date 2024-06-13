
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DoubleLinkedListMain10 {
    public static void main(String[] args) throws Exception {
        DoubleLinkedList10 dll = new DoubleLinkedList10();
        ArrayList<TransaksiPajak10> transactions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("========================================");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Bayar Pajak");
            System.out.println("3. Tampilkan seluruh transaksi");
            System.out.println("4. Urutkan Transaksi Berdasarkan Nama Pemilik");
            System.out.println("5. Keluar");
            System.out.println("========================================");
            System.out.print("Pilihan(1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nomor TNKB: ");
                    String noTNKB = scanner.nextLine();
                    System.out.print("Masukkan Nama Pemilik: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jenis: ");
                    String jenis = scanner.nextLine();
                    System.out.print("Masukkan CC Kendaraan: ");
                    int cc = scanner.nextInt();
                    System.out.print("Masukkan tahun: ");
                    int tahun = scanner.nextInt();
                    System.out.print("Masukkan bulan harus bayar: ");
                    int bulanHarusBayar = scanner.nextInt();
                    scanner.nextLine();
                    dll.addLast(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
                    break;

                case 2:
                    System.out.print("Masukkan kode: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan noTNKB kendaraan: ");
                    noTNKB = scanner.nextLine();
                    System.out.print("Nama: ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Nominal: ");
                    long nominalBayar = scanner.nextLong();
                    System.out.print("Masukkan denda: ");
                    long denda = scanner.nextLong();
                    scanner.nextLine();
                    Kendaraan10 kendaraan = dll.findByNoTNKB(noTNKB);
                    if (kendaraan != null) {
                        TransaksiPajak10 transaksi = new TransaksiPajak10(kode, kendaraan, nama, nominalBayar, denda);
                        transactions.add(transaksi);
                    } else {
                        System.out.println("Kendaraan tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.println("Daftar Kendaraan:");
                    dll.print();
                    System.out.println("Daftar Transaksi Pajak:");
                    System.out.println("Kode\tNoTNKB\tNama\tNominalBayar\tDenda\tBulanBayar\tNamaPemilik");
                    for (TransaksiPajak10 trans : transactions) {
                        System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%s\n", trans.kode, trans.kendaraan.noTNKB,
                                trans.kendaraan.nama,
                                trans.nominalBayar, trans.denda, trans.bulanBayar, trans.kendaraan.nama);
                    }

                    break;

                case 4:
                    Collections.sort(transactions, Comparator.comparing(trans -> trans.kendaraan.nama));
                    System.out.println("Transaksi diurutkan berdasarkan nama:");
                    System.out.println("Kode\tNoTNKB\tNama\tNominalBayar\tDenda\tBulanBayar\tNamaPemilik");
                    for (TransaksiPajak10 trans : transactions) {
                        System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%s\n", trans.kode, trans.kendaraan.noTNKB,
                                trans.kendaraan.nama,
                                trans.nominalBayar, trans.denda, trans.bulanBayar, trans.kendaraan.nama);
                    }
                    break;

                case 5:
                    System.out.println("Keluar.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}