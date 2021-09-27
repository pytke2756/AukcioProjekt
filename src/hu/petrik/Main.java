package hu.petrik;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static List<Festmeny> fl1 = new ArrayList<>();
    public static Random rnd = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Festmeny f1 = new Festmeny("cim1", "festo1", "gotika");
        Festmeny f2 = new Festmeny("cim2", "festo2", "gotika2");

        fl1.add(f1);
        fl1.add(f2);

        int db;
        System.out.print("Adj meg egy darabszámot: ");
        db = sc.nextInt();
        for (int i = 0; i < db; i++) {
            System.out.print("Add meg a festmény címét: ");
            String cim = sc.next();
            System.out.print("Add meg a festmény festőjét: ");
            String festo = sc.next();
            System.out.print("Add meg a festmény stílusát: ");
            String stilus = sc.next();
            Festmeny obj = new Festmeny(cim, festo, stilus);
            fl1.add(obj);
        }
        fileOlvasas("festmenyek.csv");

        for (int i = 0; i < 20; i++) {
            int randomSzam = rnd.nextInt(fl1.size() - 1);
            fl1.get(randomSzam).licit();
        }
        kiir();
        System.out.println("--------------");
        System.out.println("A legdrágábban elkelt: " + fl1.get(legdragabbanElkelt()));
        String vanETiznelTobb = tiznelTobbLicit() ? "Van olyan festmény ami 10-nél több licitet kapott.":
                "Nincs olyan festmény amit 10-nél több licitet kapott volna";
        System.out.println(vanETiznelTobb);
        System.out.printf("%d db festmény nem kelt el.", elkeltFestmenyek());
        legmagasabbLicitCsökkent();
        System.out.println("-----------------------");
        for (Festmeny item :
                fl1) {
            System.out.println(item);
        }



    }
   public static void fileOlvasas(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String sor = br.readLine();
            while (sor != null){
                String[] adatok = sor.split(";");
                Festmeny obj = new Festmeny(adatok[1], adatok[0], adatok[2]);
                fl1.add(obj);
                sor = br.readLine();
            }
            br.close();
            fr.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
   }

   public static void kiir(){
       for (Festmeny item :
               fl1) {
           System.out.println(item);
       }
   }

   public static void felhasznaloLicit(){
        int kepSzorszam;

        boolean fut = true;
        while (fut){
            System.out.println("Add meg a festmény sorszámát ha 0-t adsz meg kilépek: ");
            kepSzorszam = sc.nextInt();
            //nem szám ellenörzés nincs
            if (fl1.size() < kepSzorszam && 0 > kepSzorszam){
                System.out.println("Hibás adat");
                do {
                    System.out.println("Add meg újra: ");
                    kepSzorszam = sc.nextInt();
                }while(kepSzorszam > fl1.size() && kepSzorszam < 0);
            }
            if (fl1.get(kepSzorszam - 1).getElkelt()){
                System.out.println("Adj meg egy másik képet: ");
                kepSzorszam = sc.nextInt();
            }


        }

   }

   public static int legdragabbanElkelt(){
       int legdragabbIndex = 0;
       for (int i = 0; i < fl1.size(); i++) {
           if (fl1.get(i).getElkelt()){
               if (fl1.get(i).getLegmagasabbLicit() > fl1.get(legdragabbIndex).getLegmagasabbLicit()){
                   legdragabbIndex = i;
               }
           }
       }
       return legdragabbIndex;
   }

   public static boolean tiznelTobbLicit(){
       boolean van = false;
       for (Festmeny item : fl1) {
           if (item.getLicitekSzama() > 10){
               van = true;
           }
       }
       return van;
   }

   public static int elkeltFestmenyek(){
       int osszes = 0;
       for (Festmeny item : fl1) {
           if (!item.getElkelt()){
               osszes++;
           }
       }
       return osszes;
   }

   public static void legmagasabbLicitCsökkent(){
       Festmeny temp;
       int n = fl1.size();
       for (int i = n - 1; i > 0; i--) {
           for (int j = 0; j < i; j++) {
               if (fl1.get(j).getLegmagasabbLicit() < fl1.get(j + 1).getLegmagasabbLicit()){
                   temp = fl1.get(j);
                   fl1.set(j, fl1.get(j + 1));
                   fl1.set(j + 1, temp);
               }
           }
       }
   }
}
