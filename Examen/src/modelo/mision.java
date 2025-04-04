package modelo;

public class mision {
    private String fechaI;
    private int id_ninja;
    private int id_mision;

    public mision() {}

    public mision(String fechaI, int id_ninja, int id_mision) {
        this.fechaI = fechaI;
        this.id_ninja = id_ninja;
        this.id_mision = id_mision;
    }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public int getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }
}
