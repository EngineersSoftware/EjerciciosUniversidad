import java.util.ArrayList;
import java.util.List;

public class OperacionEmpleado implements IOperacionEmpleado{

    private List<Empleado> empleados = new ArrayList<>();

    @Override
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    @Override
    public List<Empleado> listarTodos() {
        return empleados;
    }

    @Override
    public Empleado buscarPorDocumento(String doc) {
        return empleados.stream()
                        .filter(e -> e.getDocumentos().equals(doc))
                        .findFirst().orElse(null);
    }

    @Override
    public double calcularSueldo(Empleado e, int horas) {
        return e.getSueldoHora() * horas;
    }

}
