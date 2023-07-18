package ar.edu.utn.frc.tup.lciii;

import java.util.Arrays;

public class Tablero {
    String[][] casillas = new String[3][3];
    public Tablero() {
        for (int r = 0; r<casillas.length; r++)
        {
            for(int c =0; c<casillas.length;c++)
            {
                if(casillas[r][c]==null)
                {
                    casillas[r][c]="_";
                }
            }
        }
    }
    public String imprimirTablero() {
        String tablero = new String();
        for (int r = 0; r < casillas.length; r++) {
            for (int c = 0; c < casillas[r].length; c++) {
                tablero += casillas[r][c];
            }
            tablero += System.lineSeparator();
        }
        return tablero;
    }
    public boolean validarCasilla(int r, int c){
        boolean valida = false;
        if(casillas[r-1][c-1].equals("_"))
        {
            valida = true;
        }
        else
        {
            System.out.println("Esa casilla ya está ocupada");
        }
        return valida;
    }
    public String mover(int r, int c, String s) {
        if(validarCasilla(r,c)) {
            casillas[r - 1][c - 1] = s;
        }
        return imprimirTablero();
    }

    public boolean hayUnGanador(Tablero t){
        boolean hayGanador = false;
        for (int r = 0; r < casillas.length; r++) {
            for (int c = 0; c < casillas[r].length; c++) {
                if(!casillas[r][c].equals("_")){
                    if(r==0 && c==0 && casillas[r][c].equals(casillas[r][c+1]) &&casillas[r][c+1].equals(casillas[r][c+2])){  //horizontal
                    hayGanador = true;
                    } else if (r==0 && c==1 && casillas[r][c].equals(casillas[r+1][c]) &&casillas[r+1][c].equals(casillas[r+2][c])){ //vertical
                        hayGanador = true;
                    } else if (r==0 && c==2 && casillas[r][c].equals(casillas[r+1][c]) &&casillas[r+1][c].equals(casillas[r+2][c])){  //vertical
                        hayGanador = true;
                    } else if (r==1 && c==0 && casillas[r][c].equals(casillas[r][c+1]) &&casillas[r][c+1].equals(casillas[r][c+2])){ //horizontal
                        hayGanador = true;
                    } else if (r==2 && c==0 && casillas[r][c].equals(casillas[r][c+1]) &&casillas[r][c+1].equals(casillas[r][c+2])){ //horizontal
                        hayGanador = true;
                    } else if (r==0 && c==0 && casillas[r][c].equals(casillas[r+1][c]) &&casillas[r+1][c].equals(casillas[r+2][c])){ //vertical
                        hayGanador = true;
                    } else if (r==0 && c==0 && casillas[r][c].equals(casillas[r+1][c+1]) &&casillas[r+1][c+1].equals(casillas[r+2][c+2])){ //diagonal derecha
                        hayGanador = true;
                    } else if (r==0 && c==2 && casillas[r][c].equals(casillas[r+1][c-1]) &&casillas[r+1][c-1].equals(casillas[r+2][c-2])){ //diagonal izquierda
                        hayGanador = true;
                    }
                }
            }
        }
        return hayGanador;
    }

    public boolean hayEmpate(Tablero t) {
        boolean empate = true;
        if (!hayUnGanador(t)) {
            for (int r = 0; r < casillas.length; r++) {
                for (int c = 0; c < casillas[r].length; c++) {
                    if (casillas[r][c] == "_") {
                        empate =false;
                    }
                }
            }
        }
        return empate;
    }
}
