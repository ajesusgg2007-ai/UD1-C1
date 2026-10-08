
import java.io.*;


void main() {

    //1.

    File butacas = new File("butacas.dat");


    String[] nombres = {"Ana", "Carlos", "Elena", "David", "Beatriz"};
    final int TAMANO_REGISTRO = 32;

    try (RandomAccessFile r = new RandomAccessFile(butacas, "rw")) {

        for (int i = 1; i <= 5; i++)
        {
        r.writeInt(i);
        String nombre= String.format("%-10s",nombres[i-1]);

        if (nombre.length()>10)
        {
            nombre=nombre.substring(0,10);
        }
            r.writeChars(nombre);

            r.writeLong(System.currentTimeMillis());
        }

        System.out.println("Posición puntero: " + r.getFilePointer() + " bytes");
        System.out.println("Tamaño fichero: " + r.length() + " bytes");


        //2.
        int n=5;
        long posNombreB5 = (long) (n - 1) * TAMANO_REGISTRO + 4;
        r.seek(posNombreB5);

        StringBuilder nombreB5 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            nombreB5.append(r.readChar());
        }
        System.out.println(" butaca 5: '" + nombreB5.toString().trim() + "'");

        //3.
        int nModificar = 3;
        long posNombreB3 = (long) (nModificar - 1) * TAMANO_REGISTRO + 4;
        r.seek(posNombreB3);

        String nuevoNombre10 = String.format("%-10s", "Miguel");
        r.writeChars(nuevoNombre10);



        System.out.println("Posición tras modificar: " + r.getFilePointer() + " bytes");
        System.out.println("Tamaño final: " + r.length() + " bytes");

    } catch (IOException e) {
        e.printStackTrace();
    }



}

