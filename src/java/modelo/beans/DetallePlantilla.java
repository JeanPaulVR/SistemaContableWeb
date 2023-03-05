package modelo.beans;

public class DetallePlantilla {
    
    private int id_detalle_plantilla;
    private int cuenta;
    private String nombre_cuenta;
    private int id_plantilla;

    public int getId_detalle_plantilla() {
        return id_detalle_plantilla;
    }

    public void setId_detalle_plantilla(int id_detalle_plantilla) {
        this.id_detalle_plantilla = id_detalle_plantilla;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    public int getId_plantilla() {
        return id_plantilla;
    }

    public void setId_plantilla(int id_plantilla) {
        this.id_plantilla = id_plantilla;
    }

}
