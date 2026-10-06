package deberes_miercoles_esperanza;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjecucionProgramada {
        public static void main(String[] args) {
        // 1. Creamos el temporizador de Java
        // servicio de ejecucion programada 
        // usamos executros.newsingle porque no podemos armarlo nosotros mismos
        ScheduledExecutorService programadorTareas = Executors.newSingleThreadScheduledExecutor();
    
        System.out.println("Iniciando temporizador. El comando se ejecutará en 10 segundos.");
        
        // 2. Programamos la tarea
        programadorTareas.schedule(() -> {
            try {
                System.out.println("Tiempo cumplido Lanzamos el ProcessBuilder");
                
                // Aquí metemos el ProcessBuilder habitual
                ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo HOLA, ESTO ES UNA EJECUCIÓN PROGRAMADA");
                pb.inheritIO();
                pb.start().waitFor();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 8, TimeUnit.SECONDS); // Aquí defines cuánto tiempo debe esperar
        
        // 3. Apagamos el temporizador para que el programa de Java pueda terminar
        // apaga el programador para que no siga consumiendo recuersos 
        programadorTareas.shutdown();
    }
}