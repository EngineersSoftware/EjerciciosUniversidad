import java.util.List;

public interface IOperacionEmpleado {

    void agregarEmpleado(Empleado e);
    List<Empleado>  listarTodos();
    Empleado buscarPorDocumento(String doc);
    double calcularSueldo(Empleado e, int horas);

}
