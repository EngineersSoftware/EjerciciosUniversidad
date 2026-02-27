import java.util.ArrayList;
import java.util.List;

public class OperacionEmpresa implements IOperacionEmpresa {

    private List<Empresa> listaEmpresaas = new ArrayList<>();

    @Override
    public void agregarEmpresa(Empresa e) {
        listaEmpresaas.add(e);
    }

    @Override
    public List<Empresa> listarEmpresa() {
        return listaEmpresaas;
    }

    @Override
    public Empresa buscarPorNit(String nit) {
        for (Empresa e : listaEmpresaas) {
            if (e.getNit().equals(nit)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public int contarEmpleados(String nit, IOperacionEmpleado opEmpleado) {
        int contador = 0;
        for (Empleado emp : opEmpleado.listarTodos()) {
            if (emp.getEmpresa() != null && emp.getEmpresa().getNit().equals(nit)) {
                contador++;
            }
        }
        return contador;
    }
    
}
