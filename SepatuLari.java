class SepatuLari extends Produk {
    public SepatuLari(String idProduk, String nama, double harga, int stok) {
        super(idProduk, nama, harga, stok, "Sepatu Lari");
    }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.05; // Diskon 5%
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getIdProduk() + " | Nama: " + getNama() + " | Kategori: " + getKategori()
                + " | Harga: " + Main.formatRupiah(getHarga()) + " | Stok: " + getStok());
    }
}