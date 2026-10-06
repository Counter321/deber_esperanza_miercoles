package deberes_miercoles_esperanza;
public class GestionProceso {
    public static void main(String[] args) {
        try {
            // todo notepad.exe 
            // Lanzamos un proceso visible para comprobarlo fácilmente
            // En este caso, abrimos el Bloc de notas de Windows
            // notepad es un programa fisico independiente de Java, por lo que se puede abrir desde ProcessBuilder
            // si usas un bloc de notas no te vale porque al lanzarlo se abrira
            // primero un programa de lanzador y luego el bloc de notas, por eso usamos mspaint.exe que es un programa independiente
            ProcessBuilder pb = new ProcessBuilder("mspaint.exe");
            Process proceso = pb.start(); 

            // 1. Obtener el PID (Identificador único)
            // long son numeros mas grandes que int, por eso usamos long para el PID
            Long pid = proceso.pid();
            System.out.println("El Bloc de notas se ha abierto con el PID: " + pid);

            // 2. Ver el estado del proceso (isAlive)
            System.out.println("¿El proceso sigue vivo?: " + proceso.isAlive());

            // Pausamos Java 2 segundos para que nos de tiempo a ver el paint abierto por dos segundos
            // ya que java es mas rapido que windows abriendo ventanas 
            // usamos thread que es un hilo de ejecucion, y sleep que es dormir el hilo durante un tiempo
            Thread.sleep(2000); 

            // 3. Matar el proceso a la fuerza
            System.out.println("Matamos el proceso por la fuerza");
            // tambien se puede usar proceso.destroy() pero no siempre funciona, por eso usamos destroyForcibly()
            proceso.destroyForcibly(); 

            // Comprobamos el estado final
            System.out.println("¿Sigue vivo después de matarlo?: " + proceso.isAlive());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}