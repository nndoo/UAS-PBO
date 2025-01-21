class SepatuBasket extends Produk {
    public SepatuBasket(String idProduk, String nama, double harga, int stok) {
        super(idProduk, nama, harga, stok, "Sepatu Basket");
    }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.15; // Diskon 15%
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getIdProduk() + " | Nama: " + getNama() + " | Kategori: " + getKategori()
                + " | Harga: " + Main.formatRupiah(getHarga()) + " | Stok: " + getStok());
    }
}