public class StrukPrinter {

    public void cetakKeranjang(String judul, Keranjang keranjang) {
        // lebar judul total 41 karakter, tanda = dibagi rata kiri dan kanan
        int sisa = 41 - 2 - judul.length();
        int kiri = sisa / 2;
        int kanan = sisa - kiri;
        System.out.println("=".repeat(kiri) + " " + judul + " " + "=".repeat(kanan));

        for (Buku b : keranjang.getIsi()) {
            System.out.println(b.getJudul() + " (" + b.getPenulis() + ")");
            System.out.println("  Harga       : " + Buku.formatRupiah(b.getHarga()));
            System.out.println("  Keterangan  : " + b.keterangan());
            System.out.println("  Harga akhir : " + Buku.formatRupiah(b.hargaAkhir()));
        }
        System.out.println("-----------------------------------------");
        System.out.println("Total belanja : " + Buku.formatRupiah(keranjang.hitungTotal()));
    }

    public void cetakPembayaran(int totalBelanja, MetodeBayar[] pilihan) {
        System.out.println("-------------- PEMBAYARAN ---------------");
        for (MetodeBayar m : pilihan) {
            System.out.printf("%-20s : %s%n", m.nama(), Buku.formatRupiah(m.totalBayar(totalBelanja)));
        }
    }
}
