import java.util.List;

public interface IOperacionEmpresa {

    void agregarEmpresa(Empresa e);
    List<Empresa> listarEmpresa();
    Empresa buscarPorNit(String nit);
    int contarEmpleados(String nit, IOperacionEmpleado opEmpleado);

}
