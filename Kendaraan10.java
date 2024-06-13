public class Kendaraan10 {

    String noTNKB;
    String nama;
    String jenis;
    int cc;
    int tahun;
    int bulanHarusBayar;
    Kendaraan10 prev;
    Kendaraan10 next;

    Kendaraan10(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        this.noTNKB = noTNKB;
        this.nama = nama;
        this.jenis = jenis;
        this.cc = cc;
        this.tahun = tahun;
        this.bulanHarusBayar = bulanHarusBayar;
        this.prev = null;
        this.next = null;
    }
}