public class TransaksiPajak10 {

    int kode;
    long nominalBayar;
    long denda;
    int bulanBayar;
    Kendaraan10 kendaraan;

    public TransaksiPajak10(int kode, Kendaraan10 kendaraan, String nama, long nominalBayar, long denda) {
        this.kode = kode;
        this.kendaraan = kendaraan;
        this.nominalBayar = nominalBayar;
        this.denda = denda;
    }

    public String getNama() {
        return kendaraan.nama;
    }
}
