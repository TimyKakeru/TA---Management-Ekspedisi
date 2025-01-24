package Ekspedisi.Model.KategoriPengiriman;

public class PengirimanEkspres extends Pengiriman {
    private double biayaEkstra;

    public PengirimanEkspres(String idPengiriman, double biayaEkstra) {
        super(idPengiriman);
        this.biayaEkstra = biayaEkstra;
    }

    @Override
    public String detailPengiriman() {
        return super.detailPengiriman() + " (Biaya Ekstra: " + biayaEkstra + ")";
    }
}
