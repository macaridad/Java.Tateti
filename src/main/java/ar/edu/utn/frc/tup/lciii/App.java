package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * Hello to Practica Parcial 1 - TA TE TI
 *
 */
public class App 
{

    /**
     * This is the main program
     * 
     */
    public static void main( String[] args ) {

        System.out.println("Hello, Practica Parcial 1 - TA TE TI.");
        Scanner scanner = new Scanner(System.in);
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        System.out.println("Nombre del jugador 1");
        jugador1.nombre = scanner.nextLine();
        System.out.println("Nombre del jugador 2");
        jugador2.nombre = scanner.nextLine();
        Tablero tablero1 = new Tablero();
        System.out.println(tablero1.imprimirTablero());
        for (int i = 0; i<100; i++)
        {
            System.out.println("Turno de "+jugador1.nombre+", ingrese primero fila y luego columna, separados por un espacio");
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(tablero1.mover(r,c, "x"));
            if(tablero1.hayEmpate(tablero1))
            {
                System.out.println("Hubo un empate. ¿Desean jugar otra partida?");
            } else if (tablero1.hayUnGanador(tablero1)) {
                System.out.println("El ganador es "+jugador1.nombre);
                break;
            }
            System.out.println("Turno de "+jugador2.nombre+", ingrese primero fila y luego columna, separados por un espacio");
            int fila = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println(tablero1.mover(fila,col, "o"));
            if(tablero1.hayEmpate(tablero1))
            {
                System.out.println("Hubo un empate. ¿Desean jugar otra partida?");
            } else if (tablero1.hayUnGanador(tablero1)) {
                System.out.println("El ganador es "+jugador2.nombre);
                break;
            }
        }

    }
}
