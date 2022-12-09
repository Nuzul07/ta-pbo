import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.ParseException;
class transaksim
{
    String kdbk,name,merkM,typeM,date,dateB,dateR;
    int lm,ttl,ttlD,hrgM,dis,pay,payB,ha;
    
    public String getKdbk() {
        return kdbk;
    }

    public void setKdbk(String kd) {
        kdbk = kd;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String nm) {
        this.name = name;
    }
    
    public String getMerkM() {
        return merkM;
    }
    
    public void setMerkM(String merk) {
        this.merkM = merkM;
    }

    public String getTypeM() {
        return typeM;
    }

    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getDateB() {
        return dateB;
    }
    
    public void setDateB(String dateB) {
        this.dateB = dateB;
    }
    
    public void setTypeM(String type) {
        this.typeM = typeM;
    }

    public int getLm() {
        return lm;
    }
    
    public void setLm(int lm) {
        this.lm = lm;
    }

    public int getTtl() {
        return ttl;
    }
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public int getTtlD() {
        return ttlD;
    }
    
    public void setTtlD(int ttlD) {
        this.ttlD = ttlD;
    }

    public int getHrgM() {
        return hrgM;
    }
    
    public void setHrgM(int hrgM) {
        this.hrgM = hrgM;
    }

    public int getDis() {
        return dis;
    }

    public void setDis(int dis) {
        this.dis = dis;
    }

    public int getPay() {
        return pay;
    }
    
    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getPayB() {
        return payB;
    }
    
    public void setPayB(int payB) {
        this.payB = payB;
    }

    @Override
    public String toString() {
            return name + merkM + typeM + hrgM + lm + dis + pay + payB;
    }
    
    void calcu()
   {
     ttl = hrgM * lm;
   }

    void Cdate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
            Date d1 = sdf.parse(date);
            Date d2 = sdf.parse(dateB);
        
            long loan = d1.getTime();
            long rtn = d2.getTime();

            long dif = Math.abs(rtn - loan);

            long rsl = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);

            lm = Math.toIntExact(rsl);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
    }

    void chdate ()
    {   
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            sdf.parse(dateB);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void Cdate1()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
            Date d1 = sdf.parse(dateB);
            Date d2 = sdf.parse(dateR);
        
            long loan = d1.getTime();
            long rtn = d2.getTime();

            long dif = Math.abs(rtn - loan);

            long rsl = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);

            ha = Math.toIntExact(rsl);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
    }

    void disc()
    {
      ttlD = (hrgM * lm * dis) / 100;
      ttl = hrgM * lm - ttlD;  
    }

    void payment()
    {
        payB = pay - ttl;
    }

    void show()
   {
     if(dis == 0)
     {
         System.out.println();
         System.out.println("Kode Booking \t\t : "+kdbk);
         System.out.println("Nama \t\t\t : "+name);
         System.out.println("Merk Mobil \t\t : "+merkM);
         System.out.println("Tipe Mobil \t\t : "+typeM);
         System.out.println("Harga Mobil \t\t : "+hrgM);
         System.out.println("Lama Menyewa \t\t : "+lm+" Hari");
         System.out.println("Tanggal Menyewa \t : "+date);
         System.out.println("Total Harga \t\t : Rp."+ttl);
         if (payB > 0)
         {
            System.out.println("Bayar \t\t\t : Rp."+pay);
            System.out.println("Kembalian \t\t : Rp."+payB);
         }
     }
     else
     {
         System.out.println();
          System.out.println("Kode Booking \t\t : "+kdbk);
         System.out.println("Nama \t\t\t : "+name);
         System.out.println("Merk Mobil \t\t : "+merkM);
         System.out.println("Tipe Mobil \t\t : "+typeM);
         System.out.println("Harga Mobil \t\t : "+hrgM);
         System.out.println("Lama Menyewa \t\t : "+lm+" Hari");
         System.out.println("Tanggal Menyewa \t : "+date);
         System.out.println("Diskon yang didapat \t : "+dis+"%");
         System.out.println("Total Harga \t\t : Rp."+ttl);
         if (payB > 0)
         {
            System.out.println("Bayar \t\t\t : Rp."+pay);
            System.out.println("Kembalian \t\t : Rp."+payB);
         }
      }
    }
}
