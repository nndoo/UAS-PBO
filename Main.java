import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static ArrayList<Produk> daftarProduk = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Manajemen Toko Sepatu Online ===");
            System.out.println("1. Tampilkan Daftar Sepatu");
            System.out.println("2. Tambahkan Barang");
            System.out.println("3. Tambah Stok Sepatu");
            System.out.println("4. Beli Sepatu");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tampilkanDaftarSepatu();
                    break;
                case 2:
                    tambahkanBarang();
                    break;
                case 3:
                    tambahStokSepatu();
                    break;
                case 4:
                    beliSepatu();
                    break;
                case 5:
                    System.out.println("Terima kasih.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    // Utility untuk format Rupiah
public static String formatRupiah(double amount) {
    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
    return format.format(amount);
}

    // Menampilkan daftar sepatu yang terdaftar
    private static void tampilkanDaftarSepatu() {
        if (daftarProduk.isEmpty()) {
            System.out.println("=== Daftar Sepatu ===");
            System.out.println("Belum ada sepatu yang terdaftar.");
        } else {
            System.out.println("=== Daftar Sepatu ===");
            for (Produk produk : daftarProduk) {
                produk.tampilkanInfo();
            }
        }
    }

    // Menambahkan barang baru ke dalam daftar sepatu
    private static void tambahkanBarang() {
        System.out.println("=== Tambahkan Barang ===");
        System.out.println("Pilih kategori:");
        System.out.println("1. Sepatu Bola");
        System.out.println("2. Sepatu Basket");
        System.out.println("3. Sepatu Lari");
        System.out.print("Pilih: ");
        int kategori = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        System.out.print("Masukkan ID Produk: ");
        String idProduk = scanner.nextLine();
        System.out.print("Masukkan Nama Produk: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan Stok: ");
        int stok = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        switch (kategori) {
            case 1:
            daftarProduk.add(new SepatuBola(idProduk, nama, harga, stok));
            break;
            case 2:
            daftarProduk.add(new SepatuBasket(idProduk, nama, harga, stok));
            break;
            case 3:
            daftarProduk.add(new SepatuLari(idProduk, nama, harga, stok));
            break;
            default:
                System.out.println("Kategori tidak valid.");
                return;
        }

        System.out.println("Barang berhasil ditambahkan!");
    }

    // Menambah stok untuk sepatu yang ada di daftar
    private static void tambahStokSepatu() {
        System.out.println("=== Tambah Stok Sepatu ===");
        System.out.print("Masukkan ID Produk: ");
        String idProduk = scanner.nextLine();
        for (Produk produk : daftarProduk) {
            if (produk.getIdProduk().equals(idProduk)) {
                System.out.print("Masukkan jumlah stok tambahan: ");
                int stokTambahan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer
                produk.setStok(produk.getStok() + stokTambahan);
                System.out.println("Stok berhasil ditambahkan!");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }

    // Melakukan pembelian sepatu
    private static void beliSepatu() {
        System.out.println("=== Beli Sepatu ===");
        System.out.print("Masukkan ID Produk: ");
        String idProduk = scanner.nextLine();
        for (Produk produk : daftarProduk) {
            if (produk.getIdProduk().equals(idProduk)) {
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlahBeli = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer
                
                if (jumlahBeli <= produk.getStok()) {
                    double totalHarga = produk.getHarga() * jumlahBeli;
                    double diskon = produk.hitungDiskon() * jumlahBeli;
                
                    // Menampilkan informasi pembelian
                    System.out.println("Harga sebelum diskon: " + formatRupiah(totalHarga));
                    System.out.println("Diskon: " + formatRupiah(diskon));
                    System.out.println("Total yang harus dibayar: " + formatRupiah(totalHarga - diskon));
                
                    // Kurangi stok produk
                    produk.setStok(produk.getStok() - jumlahBeli);
                
                    // Menampilkan struk pembelian
                    System.out.println("=== Struk Pembelian ===");
                    System.out.println("ID Produk   : " + produk.getIdProduk());
                    System.out.println("Nama Produk : " + produk.getNama());
                    System.out.println("Kategori    : " + produk.getKategori());
                    System.out.println("Jumlah Beli : " + jumlahBeli);
                    System.out.println("Harga Satuan: " + formatRupiah(produk.getHarga()));
                    System.out.println("Harga Total : " + formatRupiah(totalHarga));
                    System.out.println("Diskon      : " + formatRupiah(diskon));
                    System.out.println("Total Bayar : " + formatRupiah(totalHarga - diskon));
                    System.out.println("========================");
                
                    System.out.println("Transaksi berhasil!");
                } else {
                    System.out.println("Stok tidak mencukupi. Stok saat ini: " + produk.getStok());
                }
                
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }
}