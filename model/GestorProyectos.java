public class GestorProyectos extends Empleado {

    private String area;
    
    public GestorProyectos(String documentos, String nombre, double sueldoHora, Empresa empresa, String area) {
        super(documentos, nombre, sueldoHora, empresa);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
