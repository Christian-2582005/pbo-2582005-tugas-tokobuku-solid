public interface MetodeBayar {

    String nama();

    // Kontrak totalBayar: hasilnya tidak pernah negatif, berapa pun total belanja
    // dan nilai potongannya. Semua implementasi wajib mematuhi kontrak ini.
    int totalBayar(int totalBelanja);
}
