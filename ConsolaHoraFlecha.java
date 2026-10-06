package deberes_miercoles_esperanza;
public class ConsolaHoraFlecha {
    public static void main(String[] args) {
        try {
            // Configuramos cmd para cambiar el diseño con "prompt $T$G", y luego encadenamos un "echo"
            // time para la hora 
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo %date% %time% -^> Este mensaje tiene la fecha y hora de ejecución");
            
            // Heredamos la salida para verlo directamente en Visual Studio Code
            pb.inheritIO(); 
            
            Process proceso = pb.start();
            proceso.waitFor(); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}