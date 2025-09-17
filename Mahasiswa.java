public class Mahasiswa {

    private final int nilai;
    private final String nama;
    private final String nim;

    public Mahasiswa(String nama, String nim, int nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    //cek lulus
    public void cekInfo() {
        System.out.println("-------Informasi Mahasiswa------- ");
        System.out.println("nama = " + nama +", nim = "+nim);
        System.out.println("status = " + (nilai >= 70 ? "Lulus" : "Tidak lulus"));
    }


    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("Bambang", "12345", 86);
        Mahasiswa m2 = new Mahasiswa("Andi", "12346", 55);

        m1.cekInfo();
        System.out.println();
        m2.cekInfo();

    }
}
