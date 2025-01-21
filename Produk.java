public abstract class Produk {
    private String idProduk;
    private String nama;
    private double harga;
    private int stok;
    protected String kategori;

    // Konstruktor
    public Produk(String idProduk, String nama, double harga, int stok, String kategori) {
        this.idProduk = idProduk;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    // Getter dan Setter
    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getKategori() {
        return kategori;
    }

    // Metode abstrak untuk menghitung diskon dan menampilkan informasi produk
    public abstract double hitungDiskon();
    public abstract void tampilkanInfo();
}
