package Ekspedisi.Model;

import java.time.LocalDateTime;

public class Status {
    private String status;
    private LocalDateTime timestamp;

    // Status yang tersedia
    public static final String SEDANG_DIPROSES = "Sedang Diproses";
    public static final String SEDANG_DALAM_PERJALANAN = "Sedang Dalam Perjalanan";
    public static final String SAMPAI_TUJUAN = "Sampai Tujuan";

    public Status(String status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        this.timestamp = LocalDateTime.now(); // Memperbarui timestamp saat status diubah
    }

    @Override
    public String toString() {
        return status + " (Diperbarui pada: " + timestamp + ")";
    }
}