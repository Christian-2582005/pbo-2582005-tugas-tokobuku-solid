public class Voucher implements MetodeBayar {

    private int nilai;

    public Voucher(int nilai) {
        this.nilai = nilai;
    }

    @Override
    public String nama() {
        return "Voucher " + Buku.formatRupiah(nilai);
    }

    // Percobaan pertama: return totalBelanja - nilai;
    // Hasil untuk keranjang kedua (total Rp64.000, voucher Rp100.000):
    // Voucher Rp100.000    : Rp-36.000
    // Hasilnya negatif, padahal kontrak MetodeBayar.totalBayar menjanjikan tidak
    // pernah negatif. Kode lain (struk, laporan) percaya pada janji itu, jadi
    // Voucher tidak bisa menggantikan metode bayar lain dengan aman (melanggar LSP).
    // Perbaikan: dasar hasilnya nol, voucher tidak boleh membuat total di bawah nol.
    @Override
    public int totalBayar(int totalBelanja) {
        return Math.max(0, totalBelanja - nilai);
    }
}
