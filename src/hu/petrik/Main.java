package hu.petrik;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Festmeny> fl1 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

    }
   public void fileOlvasas(String fileName){
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
}
