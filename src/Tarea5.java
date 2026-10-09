
 import java.io.*;

 private static int ficheros = 0;
 private static int carpetas = 0;
 private long bytes = 0;

void main() {

    File file = new File("datos/ud1/practica");
    //1.
    File entrada = new File(file, "entrada");
    File salida = new File(file, "salida");
    File copia = new File(file, "copia");

    boolean hecho = new File(file, "entrada").mkdirs() && salida.mkdirs() && copia.mkdirs();

    System.out.println("Creadas carpetas: " + hecho);

    //2.Mover fichero

    File origen = new File(file, "carta_ok.txt");
    File destino = new File(entrada, "carta_ok.txt");


    if (origen.exists()) {
        boolean mover = origen.renameTo(destino);
        System.out.println("Movido: " + mover);
        System.out.println(destino.getName());
        System.out.println(destino.getAbsolutePath());
    }

    //3.
    System.out.println("Recorrido arbol /practica: ");
    lista(file,0);


//4.
    System.out.println("   Carpetas totales: " + carpetas);
    System.out.println("   Ficheros totales: " + ficheros);
    System.out.println("   Tamaño total: " + bytes + " bytes" + bytes);


//5.

    boolean borrar = entrada.delete();
    System.out.println("   Resultado de entrada.delete(): " + borrar);
    //Devuelve false porque el método delete() exige que el directorio esté completamente vacío




        }

private static void lista (File file,int nivle) {
    String lineas = " ".repeat(nivle);

    if (file.isDirectory()) {
        System.out.printf("CARPETA ", lineas, file.getName());

        File[] contenido = file.listFiles();
        if (contenido != null) {
            for (File f : contenido) {
                lista(f, nivle + 1);
            }
        }
    } else if (file.isFile()) {
        long tbytes = file.length();
        ficheros++;
        tbytes+=tbytes;
        System.out.println("Fichero: "+lineas +file.getName()+tbytes+tbytes/1024);
    }
    }



