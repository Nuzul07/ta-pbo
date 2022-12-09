package com;

import java.time.LocalDateTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;
import java.util.*;
import java.lang.*;
public class rentalmobil
{
    static List<transaksim> ls = new ArrayList<transaksim>();
    static Map<String, List<transaksim>> hm = new HashMap<>();
    static transaksim tr = new transaksim();
    static mobil mb = new mobil();
    static mobil mb1 = new mobil();
    static mobil mb2 = new mobil();
    static mobil mb3 = new mobil();
    
    static LocalDateTime date = LocalDateTime.now();
    static DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static String frmtdate = date.format(frmt);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public static void main(String []args)
    {   
        Scanner input = new Scanner(System.in);
        System.out.println("---------- Selamat Datang Di AMN Rental Car ----------");
        System.out.println("Apa yang ingin anda lakukan ? \n 1. Meminjam \n 2. Mengembalikan \n 3. Ubah Mobil");
        System.out.print("Pilih angka : ");
        int plh = input.nextInt();
        if (plh == 1)
        {
            newloan();
        }
        else if (plh == 2 || plh == 3)
        {
            System.out.println();
            System.out.println("Maaf kami tidak memiliki data pinjaman anda.....");
        }
        else
        {
            System.out.println();
            System.out.println("Maaf pilihan tersebut tidak tersedia.....");
        }
        for (int i = 0; i < 10; i++)
        {
            System.out.println();
            System.out.println("Apakah ada yang bisa kami bantu lagi ? \n 1. Iya \n 2. Tidak");
            System.out.print("Pilih angka : ");
            int plh1 = input.nextInt();
            if (plh1 == 1)
            {
                System.out.println();
                System.out.println("Apa yang ingin anda lakukan ? \n 1. Meminjam \n 2. Mengembalikan \n 3. Ubah Mobil");
                System.out.print("Pilih angka : ");
                plh = input.nextInt();
                if (plh == 1)
                {
                    newloan();
                }
                else if (plh == 2)
                {
                    returnm();
                }
                else if (plh == 3)
                {
                    change();
                }
            }
            else if (plh1 == 2)
            {
                System.out.println();
                System.out.println("Terima kasih atas kunjungannya.....");
                System.exit(0); 
            }
        }
    }
    public static void newloan(){
    
        Scanner input = new Scanner(System.in);

        int min = 10;
        int max = 10000000;
        int rd = (int)Math.floor(Math.random()*(max-min+1)+min);
        String kd = "BO"+Integer.toString(rd);
    
        mb.merk = "Toyota";
        mb.type = "Avanza";
        mb.hrg = 700000;
    
        mb1.merk = "Honda";
        mb1.type = "Mobilio";
        mb1.hrg = 780000;
    
        mb2.merk = "Toyota";
        mb2.type = "Rush";
        mb2.hrg = 1100000;
    
        mb3.merk = "Daihatsu";
        mb3.type = "GranMax";
        mb3.hrg = 1300000;

        tr.kdbk = kd;
        tr.date = frmtdate;
        
        System.out.print("\nMasukkan Nama : ");
        tr.name = input.nextLine();
        System.out.print("Daftar tipe mobil : \n 1. "+mb.merk+" "+mb.type+" Rp."+mb.hrg+"\n 2. "+mb1.merk+" "+mb1.type+" Rp."+mb1.hrg+"\n 3. "+mb2.merk+" "+mb2.type+" Rp."+mb2.hrg+"\n 4. "+mb3.merk+" "+mb3.type+" Rp."+mb3.hrg+"\n");
        System.out.print("Pilih nomor: ");
        int plh = input.nextInt();
    
        switch(plh)
        {
            case 1:
                tr.merkM = mb.merk;
                tr.typeM = mb.type;
                tr.hrgM = mb.hrg;
                break;
            case 2:
                tr.merkM = mb1.merk;
                tr.typeM = mb1.type;
                tr.hrgM = mb1.hrg;
                break;
            case 3:
                tr.merkM = mb2.merk;
                tr.typeM = mb2.type;
                tr.hrgM = mb2.hrg;
                break;
            case 4:
                tr.merkM = mb3.merk;
                tr.typeM = mb3.type;
                tr.hrgM = mb3.hrg;
                break;
            default:
            System.out.println();
            System.out.println("Pilihan mobil tidak tersedia....");
            System.exit(0);
        }
            System.out.println("Dapatkan @Potongan 20% jika sewa lebih dari 3 hari !!!");
            System.out.println("Masukkan rencana tanggal pengembalian (dd-MM-yyyy) : ");
            tr.dateB = input.next();
            try 
            {
                Date dateI = sdf.parse(tr.dateB);
                Date dateII = sdf.parse(frmtdate);
                if (dateI.getTime() <= dateII.getTime())
                {
                    for (int d = 0; d < 10; d++) 
                    {
                        System.out.println();
                        System.out.println("Mohon masukkan tanggal melewati dari tanggal sekarang : ");
                        tr.dateB = input.next();
                        Date dateIII = sdf.parse(tr.dateB);
                        if (dateIII.getTime() > dateII.getTime())
                        {
                            break;
                        }
                    }
                }
            } catch (ParseException e) {
            e.printStackTrace();
            }
            tr.Cdate();
            System.out.println();
            System.out.print("Lama Menyewa (dihitung dari tanggal sekarang) : " + tr.lm);
            System.out.println("");
            if (tr.lm > 3)
            {
                tr.dis = 20;
                tr.disc();
            }
            else
            {
                tr.calcu();
            }
                System.out.println("Total harga yang harus dibayar : Rp."+tr.ttl);
                System.out.print("Bayar : ");
                tr.pay = input.nextInt();
                if(tr.pay < tr.ttl)
                {
                    for (int i = 0; i < 3; i++)
                    {   
                        System.out.println("");
                        System.out.println("Maaf jumlah pembayaran anda kurang mencukupi, tersisa "+(3-i)+"x percobaan !!!");
                        System.out.print("Bayar : \n");
                        tr.pay = input.nextInt();
                        if (tr.pay >= tr.ttl)
                        {
                            System.out.println();
                            tr.payment();
                            ls.add(tr);
                            hm.put(tr.kdbk, ls);
                            System.out.println("Selamat anda berhasil melakukan pembayaran...");
                            tr.show();
                            break;
                        }
                        if (i == 2)
                        {
                            System.out.println();
                            System.out.println("Maaf anda dinyatakan gagal dalam melakukan pembayaran...");
                        }
                    }
                }
                else 
                {
                    System.out.println();
                    tr.payment();
                    ls.add(tr);
                    hm.put(tr.kdbk,ls);
                    System.out.println("Selamat anda berhasil melakukan pembayaran...");
                    tr.show();
                }
    }

    public static void returnm()
    {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.print("Masukkan Kode Booking anda : ");
        String book = input.next();
        boolean check = hm.containsKey(book);
        if (check == true)
        {
            // Collection<transaksim> values = hm.get(book);
            // ArrayList<transaksim> los = new ArrayList<>(values);
            List<transaksim> booK = hm.get(book);
            System.out.println();
            System.out.println("---------- Data pinjaman mobil anda ----------\n");
            for(transaksim trm : booK)
            {
                System.out.println("Nama \t\t\t\t : " +trm.getName());
                System.out.println("Merk Mobil \t\t\t : "+trm.getMerkM());
                System.out.println("Tipe Mobil \t\t\t : "+trm.getTypeM());
                System.out.println("Harga Mobil \t\t\t : "+trm.getHrgM());
                System.out.println("Lama Menyewa \t\t\t : "+trm.getLm()+" Hari");
                System.out.println("Tanggal Menyewa \t\t : "+trm.getDate());
                System.out.println("Tanggal Perjanjian Pengembalian  : "+trm.getDateB());
                System.out.println("Total Harga \t\t\t : Rp."+trm.getTtl());
                break;
            }
            System.out.println("----------------------------------------------\n");
            System.out.println("Masukkan tanggal anda mengembalikan mobil (dd-MM-yyyy) : ");
            tr.dateR = input.next();
            try {
                Date dateI = sdf.parse(tr.dateR);
                Date dateII = sdf.parse(tr.date);
                if (dateI.getTime() <= dateII.getTime()) 
                {
                    for (int d = 0; d < 10; d++) 
                    {
                        System.out.println();
                        System.out.println("Mohon masukkan tanggal melewati dari tanggal peminjaman : ");
                        tr.dateR = input.next();
                        Date dateIII = sdf.parse(tr.dateR);
                        if (dateIII.getTime() > dateII.getTime()) {
                            break;
                        }
                    }
                }
                Date dateIII = sdf.parse(tr.dateR);
                Date dateIIII = sdf.parse(tr.dateB);
                if (dateIII.getTime() > dateIIII.getTime()) 
                {
                    tr.Cdate1();
                    int denda = tr.ha * 750000;
                    System.out.println();
                    System.out.println("Dikarenakan anda mengembalikan mobil melewati "+tr.ha+" hari dari perjanjian pengembalian maka harus membayar denda sebesar : Rp."+denda);
                    System.out.print("Bayar denda sesuai dengan nominal yang telah ditentukan : ");
                    int byrd = input.nextInt();
                    if (byrd != denda)
                    {
                        for (int a = 0; a < 3; a++)
                        {   
                            System.out.println("");
                            System.out.println("Maaf jumlah pembayaran anda tidak sesuai, tersisa "+(3-a)+"x percobaan !!!");
                            System.out.print("Bayar : \n");
                            byrd = input.nextInt();
                            if (byrd == denda)
                            {
                                hm.remove(book);
                                System.out.println();
                                System.out.println("--------- Berhasil melalukan pembayaran denda ---------");
                                break;
                            }
                            else if (a == 2)
                            {
                                System.out.println();
                                System.out.println("--------- Anda dinyatakan gagal melalukan pembayaran denda ---------");
                                System.out.println("--------- Silahkan mencoba kembali lewat menu awal ---------");
                            }
                        }
                    }
                    else 
                    {
                        hm.remove(book);
                        System.out.println();
                        System.out.println("--------- Berhasil melalukan pembayaran denda ---------");
                    }
                }
                else {
                    hm.remove(book);
                    System.out.println();
                    System.out.println("--------- Berhasil melalukan pengembalian mobil ---------");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else if (check == false)
        {
            for (int b = 0; b < 3; b++)
            {
                System.out.println();
                System.out.println("Maaf kode booking tersebut tidak terdaftar....\n");
                System.out.print("Masukkan kembali kode booking anda : ");
                String kbl = input.next();
                boolean check1 = hm.containsKey(kbl);
                if (check1 == true)
                {
                    List<transaksim> booK = hm.get(kbl);
                    System.out.println();
                    System.out.println("---------- Data pinjaman mobil anda ----------\n");
                    for(transaksim trm : booK)
                    {
                        System.out.println("Nama \t\t\t\t : " +trm.getName());
                        System.out.println("Merk Mobil \t\t\t : "+trm.getMerkM());
                        System.out.println("Tipe Mobil \t\t\t : "+trm.getTypeM());
                        System.out.println("Harga Mobil \t\t\t : "+trm.getHrgM());
                        System.out.println("Lama Menyewa \t\t\t : "+trm.getLm()+" Hari");
                        System.out.println("Tanggal Menyewa \t\t : "+trm.getDate());
                        System.out.println("Tanggal Perjanjian Pengembalian  : "+trm.getDateB());
                        System.out.println("Total Harga \t\t\t : Rp."+trm.getTtl());
                        break;
                    }
                    System.out.println("----------------------------------------------\n");
                    System.out.println("Masukkan tanggal anda mengembalikan mobil (dd-MM-yyyy) : ");
                    tr.dateR = input.next();
                    try {
                        Date dateI = sdf.parse(tr.dateR);
                        Date dateII = sdf.parse(tr.date);
                        if (dateI.getTime() <= dateII.getTime()) {
                            for (int d = 0; d < 10; d++) {
                                System.out.println();
                                System.out.println("Mohon masukkan tanggal melewati dari tanggal peminjaman : ");
                                tr.dateR = input.next();
                                Date dateIII = sdf.parse(tr.dateR);
                                if (dateIII.getTime() > dateII.getTime()) {
                                    break;
                                }
                            }
                        }
                        Date dateIII = sdf.parse(tr.dateR);
                        Date dateIIII = sdf.parse(tr.dateB);
                        if (dateIII.getTime() > dateIIII.getTime()) {
                            tr.Cdate1();
                            int denda = tr.ha * 750000;
                            System.out.println();
                            System.out.println("Dikarenakan anda mengembalikan mobil melewati " + tr.ha
                                    + " hari dari perjanjian pengembalian maka harus membayar denda sebesar : Rp."
                                    + denda);
                            System.out.print("Bayar denda sesuai dengan nominal yang telah ditentukan : ");
                            int byrd = input.nextInt();
                            if (byrd != denda) {
                                for (int a = 0; a < 3; a++) {
                                    System.out.println("");
                                    System.out.println("Maaf jumlah pembayaran anda tidak sesuai, tersisa " + (3 - a)
                                            + "x percobaan !!!");
                                    System.out.print("Bayar : \n");
                                    byrd = input.nextInt();
                                    if (byrd == denda) {
                                        hm.remove(book);
                                        System.out.println();
                                        System.out.println("--------- Berhasil melalukan pembayaran denda ---------");
                                        break;
                                    } else if (a == 2) {
                                        System.out.println();
                                        System.out.println(
                                                "--------- Anda dinyatakan gagal melalukan pembayaran denda ---------");
                                        System.out.println(
                                                "--------- Silahkan mencoba kembali lewat menu awal ---------");
                                    }
                                }
                            } else {
                                hm.remove(book);
                                System.out.println();
                                System.out.println("--------- Berhasil melalukan pembayaran denda ---------");
                            }
                        } else {
                            hm.remove(book);
                            System.out.println();
                            System.out.println("--------- Berhasil melalukan pengembalian mobil ---------");
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                if (b == 2)
                {
                    System.out.println();
                    System.out.println("--------- Silahkan mencoba kembali di menu awal ---------");
                }
            }
        }
    }
    public static void change()
    {
        Scanner input = new Scanner(System.in);

        mb.merk = "Toyota";
        mb.type = "Avanza";
        mb.hrg = 700000;
    
        mb1.merk = "Honda";
        mb1.type = "Mobilio";
        mb1.hrg = 780000;
    
        mb2.merk = "Toyota";
        mb2.type = "Rush";
        mb2.hrg = 1100000;
    
        mb3.merk = "Daihatsu";
        mb3.type = "GranMax";
        mb3.hrg = 1300000;

        System.out.println();
        System.out.print("Masukkan Kode Booking anda : ");
        String book = input.next();
        boolean check = hm.containsKey(book);
        if (check == true) {
            // Collection<transaksim> values = hm.get(book);
            // ArrayList<transaksim> los = new ArrayList<>(values);
            List<transaksim> booK = hm.get(book);
            System.out.println();
            System.out.println("---------- Data pinjaman mobil anda ----------\n");
            for (transaksim trm : booK) {
                System.out.println("Nama \t\t\t\t : " + trm.getName());
                System.out.println("Merk Mobil \t\t\t : " + trm.getMerkM());
                System.out.println("Tipe Mobil \t\t\t : " + trm.getTypeM());
                System.out.println("Harga Mobil \t\t\t : " + trm.getHrgM());
                System.out.println("Lama Menyewa \t\t\t : " + trm.getLm() + " Hari");
                System.out.println("Tanggal Menyewa \t\t : " + trm.getDate());
                System.out.println("Tanggal Perjanjian Pengembalian  : " + trm.getDateB());
                System.out.println("Total Harga \t\t\t : Rp." + trm.getTtl());
                ls.remove(tr);
                break;
            }
            System.out.println("----------------------------------------------\n");
            System.out.print("Daftar tipe mobil : \n 1. " + mb.merk + " " + mb.type + " Rp." + mb.hrg + "\n 2. "
                    + mb1.merk + " " + mb1.type + " Rp." + mb1.hrg + "\n 3. " + mb2.merk + " " + mb2.type + " Rp."
                    + mb2.hrg + "\n 4. " + mb3.merk + " " + mb3.type + " Rp." + mb3.hrg + "\n");
            System.out.println("Masukkan mobil yang ingin anda ubah....");
            System.out.print("Pilih nomor: ");
            int plh = input.nextInt();

            switch (plh) {
            case 1:
                tr.merkM = mb.merk;
                tr.typeM = mb.type;
                tr.hrgM = mb.hrg;
                break;
            case 2:
                tr.merkM = mb1.merk;
                tr.typeM = mb1.type;
                tr.hrgM = mb1.hrg;
                break;
            case 3:
                tr.merkM = mb2.merk;
                tr.typeM = mb2.type;
                tr.hrgM = mb2.hrg;
                break;
            case 4:
                tr.merkM = mb3.merk;
                tr.typeM = mb3.type;
                tr.hrgM = mb3.hrg;
                break;
            }
            if (tr.lm > 3) 
            {
                tr.dis = 20;
                tr.disc();
            } 
            else 
            {
                tr.calcu();
            }
            System.out.println("Total harga yang harus dibayar : Rp." + tr.ttl);
            System.out.print("Bayar : ");
            tr.pay = input.nextInt();
            if (tr.pay < tr.ttl) {
                for (int i = 0; i < 3; i++) {
                    System.out.println("");
                    System.out.println(
                            "Maaf jumlah pembayaran anda kurang mencukupi, tersisa " + (3 - i) + "x percobaan !!!");
                    System.out.print("Bayar : \n");
                    tr.pay = input.nextInt();
                    if (tr.pay >= tr.ttl) {
                        System.out.println();
                        tr.payment();
                        ls.add(tr);
                        hm.put(tr.kdbk, ls);
                        for (transaksim trm : booK) {
                        System.out.println("Kembalian : Rp." + trm.getPayB());
                        break;
                        }
                        System.out.println();
                        System.out.println("Berhasil melakukan pembayaran...\n");
                        booK = hm.get(book);
                        System.out.println();
                        System.out.println("---------- Data pinjaman mobil anda ----------\n");
                        for (transaksim trm : booK) {
                            System.out.println("Nama \t\t\t\t : " + trm.getName());
                            System.out.println("Merk Mobil \t\t\t : " + trm.getMerkM());
                            System.out.println("Tipe Mobil \t\t\t : " + trm.getTypeM());
                            System.out.println("Harga Mobil \t\t\t : " + trm.getHrgM());
                            System.out.println("Lama Menyewa \t\t\t : " + trm.getLm() + " Hari");
                            System.out.println("Tanggal Menyewa \t\t : " + trm.getDate());
                            System.out.println("Tanggal Perjanjian Pengembalian  : " + trm.getDateB());
                            System.out.println("Total Harga \t\t\t : Rp." + trm.getTtl());
                            break;
                        }
                        System.out.println("----------------------------------------------\n");
                        System.out.println("--------- Selamat anda berhasil mengubah data mobil anda ---------");
                        break;
                    }
                    if (i == 2) {
                        System.out.println();
                        System.out.println("Maaf anda dinyatakan gagal dalam melakukan pembayaran...");
                    }
                }
            }
            else
            {
                tr.payment();
                ls.add(tr);
                hm.put(tr.kdbk, ls);
                for (transaksim trm : booK) {
                    System.out.println("Kembalian : Rp." + trm.getPayB());
                    break;
                }
                System.out.println();
                System.out.println("Berhasil melakukan pembayaran...\n");
                booK = hm.get(book);
                System.out.println();
                System.out.println("---------- Data pinjaman mobil anda ----------\n");
                for (transaksim trm : booK) {
                    System.out.println("Nama \t\t\t\t : " + trm.getName());
                    System.out.println("Merk Mobil \t\t\t : " + trm.getMerkM());
                    System.out.println("Tipe Mobil \t\t\t : " + trm.getTypeM());
                    System.out.println("Harga Mobil \t\t\t : " + trm.getHrgM());
                    System.out.println("Lama Menyewa \t\t\t : " + trm.getLm() + " Hari");
                    System.out.println("Tanggal Menyewa \t\t : " + trm.getDate());
                    System.out.println("Tanggal Perjanjian Pengembalian  : " + trm.getDateB());
                    System.out.println("Total Harga \t\t\t : Rp." + trm.getTtl());
                    break;
                }
                System.out.println("----------------------------------------------\n");
                System.out.println("--------- Selamat anda berhasil mengubah data mobil anda ---------");
            }
        } 
        else if (check == false) 
        {
            for (int b = 0; b < 3; b++) {
                System.out.println();
                System.out.println("Maaf kode booking tersebut tidak terdaftar....\n");
                System.out.print("Masukkan kembali kode booking anda : ");
                String kbl = input.next();
                boolean check1 = hm.containsKey(kbl);
                if (check1 == true) {
                    List<transaksim> booK = hm.get(kbl);
                    System.out.println();
                    System.out.println("---------- Data pinjaman mobil anda ----------\n");
                    for (transaksim trm : booK) {
                        System.out.println("Nama \t\t\t\t : " + trm.getName());
                        System.out.println("Merk Mobil \t\t\t : " + trm.getMerkM());
                        System.out.println("Tipe Mobil \t\t\t : " + trm.getTypeM());
                        System.out.println("Harga Mobil \t\t\t : " + trm.getHrgM());
                        System.out.println("Lama Menyewa \t\t\t : " + trm.getLm() + " Hari");
                        System.out.println("Tanggal Menyewa \t\t : " + trm.getDate());
                        System.out.println("Tanggal Perjanjian Pengembalian  : " + trm.getDateB());
                        System.out.println("Total Harga \t\t\t : Rp." + trm.getTtl());
                        ls.remove(tr);
                        break;
                    }
                    System.out.println("----------------------------------------------\n");
                    System.out.print("Daftar tipe mobil : \n 1. " + mb.merk + " " + mb.type + " Rp." + mb.hrg + "\n 2. "
                            + mb1.merk + " " + mb1.type + " Rp." + mb1.hrg + "\n 3. " + mb2.merk + " " + mb2.type
                            + " Rp." + mb2.hrg + "\n 4. " + mb3.merk + " " + mb3.type + " Rp." + mb3.hrg + "\n");
                    System.out.println("Masukkan mobil yang ingin anda ubah....");
                    System.out.print("Pilih nomor: ");
                    int plh = input.nextInt();

                    switch (plh) {
                    case 1:
                        tr.merkM = mb.merk;
                        tr.typeM = mb.type;
                        tr.hrgM = mb.hrg;
                        break;
                    case 2:
                        tr.merkM = mb1.merk;
                        tr.typeM = mb1.type;
                        tr.hrgM = mb1.hrg;
                        break;
                    case 3:
                        tr.merkM = mb2.merk;
                        tr.typeM = mb2.type;
                        tr.hrgM = mb2.hrg;
                        break;
                    case 4:
                        tr.merkM = mb3.merk;
                        tr.typeM = mb3.type;
                        tr.hrgM = mb3.hrg;
                        break;
                    }
                    if (tr.lm > 3) {
                        tr.dis = 20;
                        tr.disc();
                    } else {
                        tr.calcu();
                    }
                    System.out.println("Total harga yang harus dibayar : Rp." + tr.ttl);
                    System.out.print("Bayar : ");
                    tr.pay = input.nextInt();
                    if (tr.pay < tr.ttl) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("");
                            System.out.println("Maaf jumlah pembayaran anda kurang mencukupi, tersisa " + (3 - i)
                                    + "x percobaan !!!");
                            System.out.print("Bayar : \n");
                            tr.pay = input.nextInt();
                            if (tr.pay >= tr.ttl) {
                                System.out.println();
                                tr.payment();
                                ls.add(tr);
                                hm.put(tr.kdbk, ls);
                                for (transaksim trm : booK) {
                                    System.out.println("Kembalian : Rp." + trm.getPayB());
                                    break;
                                }
                                System.out.println();
                                System.out.println("Berhasil melakukan pembayaran...\n");
                                booK = hm.get(book);
                                System.out.println();
                                System.out.println("---------- Data pinjaman mobil anda ----------\n");
                                for (transaksim trm : booK) {
                                    System.out.println("Nama \t\t\t\t : " + trm.getName());
                                    System.out.println("Merk Mobil \t\t\t : " + trm.getMerkM());
                                    System.out.println("Tipe Mobil \t\t\t : " + trm.getTypeM());
                                    System.out.println("Harga Mobil \t\t\t : " + trm.getHrgM());
                                    System.out.println("Lama Menyewa \t\t\t : " + trm.getLm() + " Hari");
                                    System.out.println("Tanggal Menyewa \t\t : " + trm.getDate());
                                    System.out.println("Tanggal Perjanjian Pengembalian  : " + trm.getDateB());
                                    System.out.println("Total Harga \t\t\t : Rp." + trm.getTtl());
                                    break;
                                }
                                System.out.println("----------------------------------------------\n");
                                System.out
                                        .println("--------- Selamat anda berhasil mengubah data mobil anda ---------");
                                break;
                            }
                            if (i == 2) {
                                System.out.println();
                                System.out.println("Maaf anda dinyatakan gagal dalam melakukan pembayaran...");
                            }
                        }
                    } 
                    else 
                    {
                        tr.payment();
                        ls.add(tr);
                        hm.put(tr.kdbk, ls);
                        for (transaksim trm : booK) {
                            System.out.println("Kembalian : Rp." + trm.getPayB());
                            break;
                        }
                        System.out.println();
                        System.out.println("Berhasil melakukan pembayaran...\n");
                        booK = hm.get(book);
                        System.out.println();
                        System.out.println("---------- Data pinjaman mobil anda ----------\n");
                        for (transaksim trm : booK) {
                            System.out.println("Nama \t\t\t\t : " + trm.getName());
                            System.out.println("Merk Mobil \t\t\t : " + trm.getMerkM());
                            System.out.println("Tipe Mobil \t\t\t : " + trm.getTypeM());
                            System.out.println("Harga Mobil \t\t\t : " + trm.getHrgM());
                            System.out.println("Lama Menyewa \t\t\t : " + trm.getLm() + " Hari");
                            System.out.println("Tanggal Menyewa \t\t : " + trm.getDate());
                            System.out.println("Tanggal Perjanjian Pengembalian  : " + trm.getDateB());
                            System.out.println("Total Harga \t\t\t : Rp." + trm.getTtl());
                            break;
                        }
                        System.out.println("----------------------------------------------\n");
                        System.out.println("--------- Selamat anda berhasil mengubah data mobil anda ---------");
                    }
                }
                if (b == 2) {
                    System.out.println();
                    System.out.println("--------- Silahkan mencoba kembali di menu awal ---------");
                }
            }
        }   
    }
}