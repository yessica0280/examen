package vista;

import java.util.List;
import java.util.Scanner;
import modelo.mision;
import modelo.misionC;
import modelo.misionD;
import modelo.misionNinja;
import modelo.ninja;

public class Vista {
    Scanner scan = new Scanner(System.in);
    
    public void Mostrar(List<ninja> ninjas) {
        System.out.println("lista de ninjas: ");
        for (ninja n : ninjas) {
            System.out.println(n);
        }
    }
    
    public misionD misionD() {
        System.out.println("Ingresa el id del ninja: ");
        int id = scan.nextInt();
        return new misionD(id);
    }
    
    public misionD misionC() {
        System.out.println("Ingresa el id: ");
        int id = scan.nextInt();
        return new misionD(id);
    }
    
    public mision misionA() {
        System.out.println("Ingresar los datos: ");
        System.out.println("fecha de inicio: ");
        String fechaI = scan.nextLine();
        System.out.println("id del ninja: ");
        int idn = scan.nextInt();
        System.out.println("id de la mision: ");
        int idm = scan.nextInt();
        return new mision(fechaI, idn, idm);
    }
    
    public misionNinja misiomCom() {/**/
        System.out.println("id: ");
        int ides = scan.nextInt();
        System.out.println("fecha de finalizacion: ");
        scan.nextLine();
        String fechaF = scan.nextLine();
        return new misionNinja(ides, fechaF);
    }
    
    public void misionC(List<misionC> mc) {
        System.out.println("lista de ninjas: ");
        for (misionC m : mc) {
            System.out.println(m);
        }
    }
}
