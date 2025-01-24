package Ekspedisi.View;

import Ekspedisi.Model.KategoriPengiriman.*;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void showLogin() {
        System.out.print("Masukkan username: ");
    }

    public void showPassword() {
        System.out.print("Masukkan password: ");
    }

    public void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Pengiriman");
        System.out.println("2. Lihat Riwayat Pengiriman");
        System.out.println("3. Ubah Status Pengiriman");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
    }

    public void showDetailPengiriman(List<Pengiriman> pengirimanList) {
        System.out.println("Riwayat Pengiriman:");
        for (Pengiriman p : pengirimanList) {
            System.out.println(p.detailPengiriman());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public int getIntInput() {
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}