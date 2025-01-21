class SepatuBola extends Produk {
    public SepatuBola(String idProduk, String nama, double harga, int stok) {
        super(idProduk, nama, harga, stok, "Sepatu Bola");
    }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.10; // Diskon 10%
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getIdProduk() + " | Nama: " + getNama() + " | Kategori: " + getKategori()
                + " | Harga: " + Main.formatRupiah(getHarga()) + " | Stok: " + getStok());
    }
}