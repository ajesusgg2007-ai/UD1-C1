//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.File;
import java.io.IOException;

void main() throws IOException {

     File file = new File("datos/ud1/practica");

    File carta= new File(file,"carta.txt");

    if(carta.exists()) {
        carta.delete();
    }
    if (file.exists()) {
        file.delete();
    }

    new File("datos/ud1").delete();
    new File("datos").delete();

    boolean mkdir = file.mkdir();
    System.out.println("Resultado de ruta.mkdir(): " + mkdir);

    boolean mkdirs = file.mkdirs();
    System.out.println("Resultado de ruta.mkdirs(): " + mkdirs);

    //mkdir() da false porque intenta crear únicamente el directorio final,
    // mientras que mkdirs() crea todos los directorios intermedios, como tiene la estructura,


//2.

    try{
        boolean creado = carta.createNewFile();
        System.out.println("creado: "+creado);
        boolean creado2 = carta.createNewFile();
        System.out.println("creado2: " +creado2);

    } catch (IOException e) {
        System.out.println("Error: "+e.getMessage());
    }

 //3.


   try {
       FileWriter r=new FileWriter("carta.txt");
  r.write("lo que sea\n");
       r.write("lo que sea");

   } catch (Exception e) {
       System.out.println("Error: "+e.getMessage());
   }

    File cartaOk = new File(file,"carta_ok.txt");

    if (cartaOk.exists()) {
        cartaOk.delete();
    }

    boolean resRenombrado = carta.renameTo(cartaOk);
    System.out.println("renombrado: " + resRenombrado);

    File f = new File(file, "fichero_aux.txt");
    try {
        f.createNewFile();
        boolean resBorrado = f.delete();
        System.out.println("Borrado: " + resBorrado);
    }catch (IOException e){
        System.out.println("Error: "+e.getMessage());
    }

    //4.
    System.out.println("getName(): " + cartaOk.getName());
    System.out.println("getAbsolutePath(): " + cartaOk.getAbsolutePath());
    System.out.println("length(): " + cartaOk.length() + " bytes");

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

    System.out.println(sdf.format(new Date(cartaOk.lastModified())));

    //5.
    File[] ficheros = file.listFiles();
    if (ficheros != null){
        for (File F : ficheros)
        {
            String tipo;
            if (F.isDirectory())
            {
                tipo="Directorio";
            }

            else
            {
                tipo="Fichero";
            }
            long b=F.length();
            double kb = b / 1024.0;
            System.out.println(tipo+" "+F.getName()+" "+ b+ " "+ kb);
        }
        System.out.println("   Total entradas en carpeta: " + ficheros.length);

        //6.

        File[] listaFichero = cartaOk.listFiles();
        if (listaFichero == null)
        {
            System.out.println(listaFichero);
        }

    }

}





