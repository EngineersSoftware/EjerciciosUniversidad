public abstract class Empleado {
    
    private String documentos;
    private String nombre;
    private double sueldoHora;
    private Empresa empresa; // Relacion 1:1

    public Empleado(String documentos, String nombre, double sueldoHora, Empresa empresa) {
        this.documentos = documentos;
        this.nombre = nombre;
        this.sueldoHora = sueldoHora;
        this.empresa = empresa;
    }

    // Getters y Setters
    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString(){
        return String.format("Empleado: %s | Documento: %s | Empresa: %s ", nombre, documentos, 
        (empresa != null ? empresa.getNombre() : "Ninguna"));
    }

}
