
package ejemplooficial2;

/**
 *
 * @author Hp
 */
import java.security.SecureRandom;
import java.util.Scanner;
public class Ejemplooficial2 {

    /**
     * @param args the command line arguments
     */
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private static int nivelDificultad;
    private static int tipoProblema;
    private static int preguntasCorrectas;
    private static int preguntasIncorrectas;
    public static void main(String[] args) {
         try (scanner) {
            while (true) {
                preguntasCorrectas = 0;
                preguntasIncorrectas = 0;
                
                mostrarMenu();
                elegirNivelDificultad();
                elegirTipoProblema();
                
                while (preguntasCorrectas < 10) {
                    int num1 = (int) generarNumeroAleatorio();
                    int num2 = (int) generarNumeroAleatorio();
                    String operacion = obtenerOperacionAleatoria();
                    double respuestaCorrecta =  evaluarRespuesta(num1, num2, operacion);
                    
                    System.out.printf("¿Cuanto es %d %s %d ?   ", num1, operacion, num2);
                    double respuestaEstudiante = scanner.nextDouble();
                    
                    if (Math.abs(respuestaEstudiante - respuestaCorrecta) <= 0.01) {
                        preguntasCorrectas++;
                        mostrarRespPositiva();
                    } else {
                        preguntasIncorrectas++;
                        mostrarRespNegativa();
                        mostrarRespNegativa2();
                    }
                }
                
                double porcentajeCorrectas = (preguntasCorrectas / 10.0) * 100;
                if (porcentajeCorrectas < 75) {
                    System.out.println("Por favor, pide ayuda adicional a tu instructor.");
                } else {
                    System.out.println("¡Felicidades, estas listo para pasar al siguiente nivel!");
                }
                
                System.out.println("¿Deseas continuar dentro del programa? (si/no)");
                String continuar = scanner.next();
                if (!continuar.equalsIgnoreCase("si")) {
                    break;
                }
            }
        }
    
        // TODO code application logic here
    }
    private static void mostrarMenu() {
        System.out.println("BIENVENIDOS AL PROGRAMA DE RESOLUCIÓN DE OPERACIONES ARITMETICAS:");
        System.out.println("---------------------------------------------------------------------:");
        System.out.println("Niveles de dificultad:");
        System.out.println("----------------------------------------:");
        System.out.println("1. Numeros de un di­gito");
        System.out.println("2. Numeros de dos di­gitos");
        System.out.println("3. Numeros de tres di­gitos");
        System.out.println("4. Numeros de cuatro di­gitos");
        System.out.println("----------------------------------------:");
        System.out.print("Elige el nivel de dificultad: ");
        System.out.println("-------:");
        
    }

    private static void elegirNivelDificultad() {
        nivelDificultad = scanner.nextInt();
    }

    private static void elegirTipoProblema() {
        System.out.println("Tipos de operaciones aritmeticas:");
        System.out.println("----------------------------------------:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Mezcla aleatoria");
        System.out.println("----------------------------------------:");
        System.out.print("Elige el tipo de operación aritmetica que deseas resolver: ");
         System.out.print("Elige el tipo de operación aritmetica que deseas resolver: ");
        System.out.println("-------:");
        tipoProblema = scanner.nextInt();
    }

    private static double generarNumeroAleatorio() {
        int maximo = (int) Math.pow(10, nivelDificultad);
        return randomNumbers.nextDouble() * maximo;
    }

    private static String obtenerOperacionAleatoria() {
        if (tipoProblema == 5) {
            int tipoProblemaAleatorio = randomNumbers.nextInt(4) + 1;
            return obtenerOperacion(tipoProblemaAleatorio);
        } else {
            return obtenerOperacion(tipoProblema);
        }
    }

    private static String obtenerOperacion(int tipoProblema) {
        return switch (tipoProblema) {
            case 1 -> "+";
            case 2 -> "-";
            case 3 -> "*";
            case 4 -> "/";
            default -> "+";
        };
    }

    private static double evaluarRespuesta(double num1, double num2, String operacion) {
        return switch (operacion) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "d" -> num1 / num2;
            case "p" -> num1 / num2;
            default -> 0;
        };
    }

    private static void mostrarRespPositiva() {
        String[] respuestasPositivas = {
                "¡Muy bien!",
                "¡Excelente!",
                "¡Buen trabajo!",
                "¡Sigue asi­!"
        };
        int indiceRespuesta = randomNumbers.nextInt(respuestasPositivas.length);
        System.out.println(respuestasPositivas[indiceRespuesta]);
    }

    private static void mostrarRespNegativa() {
        String[] respuestasNegativas = {
                "Por favor intenta de nuevo.",
                "Incorrecto. Intenta una vez mas.",
                "¡No te rindas!",
                "No es correcto. Sigue intentando."
                
        };
        int indiceRespuesta = randomNumbers.nextInt(respuestasNegativas.length);
        System.out.println(respuestasNegativas[indiceRespuesta]);
    }
     private static void mostrarRespNegativa2() {
        String[] respuestasNegativas = {
                "Por favor intenta de nuevo.",
                "Incorrecto. Intenta una vez mas.",
                "¡No te rindas!",
                "No es correcto. Sigue intentando."
                
        };
        int indiceRespuesta = randomNumbers.nextInt(respuestasNegativas.length);
        System.out.println(respuestasNegativas[indiceRespuesta]);
    }
}
