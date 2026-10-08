import java.io.*;
import java.util.Random;

public class Tarea2 {

    void main() {

        //1.

        File original = new File("original.bin");

        if (original.exists() && original.isDirectory()) {
            original.delete();
        }

        Random rd = new Random(1);

        try (FileOutputStream w = new FileOutputStream(original)) {

            for (int i = 0; i < 20000; i++) {
                w.write(rd.nextInt(256));
            }

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

        System.out.println("Creado " + original.getName() + " " + original.length() + " bytes");

        //2.

        File copia = new File("copia.bin");

        int bytes = 0;

        try (FileInputStream fis = new FileInputStream(original);
             FileOutputStream fos = new FileOutputStream(copia)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
                bytes++;
            }

            System.out.println("2. Copia finalizada. Total bytes copiados: " + bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

// 3.
        System.out.println("Original: " + original.length() + "Total bytes copiados: " + copia.length());

//4.
        try (FileReader fr = new FileReader(original)) {
            for (int i = 0; i < 5; i++) {
                int c = fr.read();
                System.out.print(c + " ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
