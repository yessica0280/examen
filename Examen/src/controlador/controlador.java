package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.consultas;
import modelo.mision;
import modelo.misionC;
import modelo.misionD;
import modelo.misionNinja;
import modelo.ninja;
import vista.Vista;

public class controlador {
    consultas Consultas;
    Vista vista;
    Scanner scan;
    ninja ninjas;
    misionC misionc;
    
    public controlador(consultas Consultas, Vista vista){
        this.Consultas = Consultas;
        this.vista = vista;
        this.scan = scan = new Scanner(System.in);
    }
    
    public void iniciar() {
        boolean salir = true;
        while (salir = true) {
            System.out.println("---- Menú principal ----");
            System.out.println("1. Listar todos los ninjas y sus habilidaes.");
            System.out.println("2. Mostrar misiones que tiene el ninja.");
            System.out.println("3. Mostrar las misiones que completo el ninja.");
            System.out.println("4. Marcar como completada una mision.");
            System.out.println("5. Mostrar misiones completadas.");
            System.out.println("6. Agregar una mision.");
            System.out.println("7. Salir.");
            int opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    List<String> listaNinja = new ArrayList<>();
                    listaNinja = Consultas.obtener(ninjas);
                    for (String tin : listaNinja) {
                        System.out.println(tin);
                    }
                    break;
                    
                case 2:
                    List<String> listaMisionN = new ArrayList<>();
                    misionD md = vista.misionD();
                    listaMisionN = Consultas.misionesd(md);
                    if (listaMisionN.size() > 0) {
                        for (String Tin : listaMisionN) {
                            System.out.println(Tin);
                        }
                        System.out.println("misiones disponibles");
                    }
                    break;
                case 3: 
                    List<String> listaC = new ArrayList<>();
                    misionD Md = vista.misionD();
                    listaC = Consultas.misioncom(Md);
                    if (listaC.size() > 0) {
                        for (String Tin : listaC) {
                            System.out.println(Tin);
                        }
                        System.out.println("misiones completadas");
                    }
                    break;
                    
                case 4:
                    mision misiones = vista.misionA();
                    Consultas.asignarM(misiones);
                    System.out.println("mision asignada con exito");
                    break;
                    
                case 5:
                    /*misionC mc = vista.misiomCom();
                    Consultas.marcarCo(mc);
                    System.out.println("mision completa");
                    break;*/
                    
                case 6:
                    List<String> listaCom = new ArrayList<>();
                    /*listaCom = Consultas.misionesCom(mn);*/
                    for (String Tin : listaCom) {
                        System.out.println(Tin);
                    }
                    System.out.println("Lista de las misiones completas");
                    break;
                    
                case 7:
                    System.out.println("Saliendo...");
                    salir = false;
                    break;
            }
        }
    }
}
