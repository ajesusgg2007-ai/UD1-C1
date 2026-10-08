
import java.io.*;
import java.nio.charset.StandardCharsets;

void main() {

    File file = new File("datos/ud1/practica");
    if (!file.exists()) {
        file.mkdirs();
    }

    //1.
    File frases=new File(file,"frases.txt");

    try(FileOutputStream fos=new FileOutputStream(frases))
    {
        String frase="Programación\nmañana\ncamión\n";
        fos.write(frase.getBytes(StandardCharsets.UTF_8));

    }catch (IOException e){
        e.printStackTrace();
    }

    //2.
    try (BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(frases), StandardCharsets.UTF_8)))
    {
    String linea;
    while ((linea=br.readLine()) != null){
        System.out.println(" "+linea);
    }
    }catch (IOException e){
        e.printStackTrace();
    }

    //3.

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(frases), "Cp1252"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println("   " + linea);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    //Donde estaban las líneas se ha quedado con letras totalmente cambiadas

    //4.
    int lineas=0;
    int palabras=0;
    int vocales=0;

    try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(frases),StandardCharsets.UTF_8)))
    {

        String linea;

        while((linea=br.readLine()) != null)
        {
            lineas++;
            if (!linea.trim().isEmpty())
            {
                String[] npalabras = linea.split("\\s+");
                palabras += npalabras.length;

            }
            for (char c : linea.toLowerCase().toCharArray())
            {
                if ("aáeéiíoóuú".indexOf(c) != -1)
                {
                    vocales++;
                }
            }
        }

        System.out.println("   Líneas: " + lineas);
        System.out.println("   Palabras: " + palabras);
        System.out.println("   Vocales: " + vocales);

    }catch (IOException e){
        e.printStackTrace();
    }
}