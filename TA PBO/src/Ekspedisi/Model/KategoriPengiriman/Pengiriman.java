package Ekspedisi.Model.KategoriPengiriman;

import Ekspedisi.Model.Barang;
import Ekspedisi.Model.Status;

import java.util.ArrayList;
import java.util.List;

public class Pengiriman {
    private String idPengiriman;
    private List<Barang> barang;
    private Status status; // Menggunakan kelas Status

    public Pengiriman(String idPengiriman) {
        this.idPengiriman = idPengiriman;
        this.barang = new ArrayList<>();
        this.status = new Status(Status.SEDANG_DIPROSES); // Status awal
    }

    public void tambahBarang(Barang barang) {
        this.barang.add(barang);
    }

    public void ubahStatus(String newStatus) {
        this.status.updateStatus(newStatus); // Mengubah status pengiriman
    }

    public String detailPengiriman() {
        String details = "ID Pengiriman: " + idPengiriman + ", Status: " + status + "\nBarang:\n";
        for (Barang b : barang) {
            details += b.detailBarang() + "\n"; // Menggabungkan string dengan operator +
        }
        return details;
    }

    public String getIdPengiriman() {
        return idPengiriman;
    }

    public Status getStatus() {
        return status; // Menambahkan getter untuk status
    }

}