package S4_CW;

import java.util.Random;

public class Seminar4 {
    public static void main(String[] args) {

        Mapa<String, String> mapa = new Mapa<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            mapa.put(Integer.toString(i + 10), Integer.toString(i));

        }
        // System.out.println(mapa.get("10"));
        System.out.println(mapa.remove("14"));

    }

}
