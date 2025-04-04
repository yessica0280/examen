package examen;

import controlador.controlador;
import modelo.consultas;
import modelo.ninja;
import vista.Vista;
import java.sql.*;

public class Examen {

    public static void main(String[] args) {
        consultas Consultas = new consultas();
        Vista vista = new Vista();
        controlador Controlador = new controlador(Consultas, vista);
        Controlador.iniciar();
    }
    
}
