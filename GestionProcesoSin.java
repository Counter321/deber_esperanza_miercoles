package deberes_miercoles_esperanza;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class GestionProcesoSin {
    public static void main(String[] args) {
        try {
            // 1. Lanzamos la consola de Windows en lugar de Paint
            ProcessBuilder pb = new ProcessBuilder("cmd.exe");
            Process proceso = pb.start(); 

            // Obtener el PID
            long pid = proceso.pid();
            System.out.println("La consola se ha abierto con el PID: " + pid);

            // Ver el estado del proceso
            System.out.println("¿El proceso sigue vivo?: " + proceso.isAlive());

            // 2. Nos conectamos a la consola para inyectarle comandos de texto
            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
            
            // 3. LA PAUSA SIN HILOS: Le enviamos el comando 'timeout' a Windows
            // Esto obliga a la consola a congelarse 2 segundos por su cuenta, sin usar Thread.sleep
            System.out.println("Enviando orden a Windows para que espere 2 segundos...");
            escritor.write("timeout /t 2 /nobreak");
            escritor.newLine(); 
            
            // 4. Tras la espera, le enviamos la orden de cerrarse
            escritor.write("exit");
            escritor.newLine(); 
            
            // Cortamos el cable de conexión
            escritor.flush();
            escritor.close(); 
            
            // Obligamos a Java a esperar a que Windows termine la tarea
            proceso.waitFor(); 

            // Comprobamos el estado final (ahora será false porque el 'exit' cerró la consola)
            System.out.println("¿Sigue vivo después de cerrarlo?: " + proceso.isAlive());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}