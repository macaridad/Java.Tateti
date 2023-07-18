package ar.edu.utn.frc.tup.lciii;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Jugador {
    String nombre = "";
    String email = "";
    List<Integer> posicion = new ArrayList<>();
}
