import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Uso de interfaces para instanciar (Polimorfismo)
        IOperacionEmpresa opEmpresa = new OperacionEmpresa();
        IOperacionEmpleado opEmpleado = new OperacionEmpleado();

        var menu = "\n1. Registrar Empresa\n2. Registar Empleados\n3. Listar Todo\n4. Salir";

        var opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch (opcion) {
                case 1:
                    var nit = JOptionPane.showInputDialog("Nombre: ");
                    opEmpresa.agregarEmpresa(new EmpresaDesarollo(nit, nit, "Medellin", nit));
                    break;
                case 2:
                    var nitBusqueda = JOptionPane.showInputDialog("NIT de la empresa a la que pertenece");
                    var empEcontrada = opEmpresa.buscarPorNit(nitBusqueda);
                    if (empEcontrada != null) {
                        var doc = JOptionPane.showInputDialog("Documento:");
                        var nombre = JOptionPane.showInputDialog("Nombre:");
                        var sueldoH = Double.parseDouble(JOptionPane.showInputDialog("Sueldo por hora:"));

                        // Polimorfismo: Creamos un Desarrollador pero lo tratamos como Empleado
                        Empleado nuevo = new Desarrollador(doc, nombre, sueldoH, empEcontrada);
                        opEmpleado.agregarEmpleado(nuevo);
                        JOptionPane.showMessageDialog(null, "Empleado asignado a: " + empEcontrada.getNombre());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: La empresa no existe");
                    }
                case 3:
                    StringBuilder reporte = new StringBuilder("----- REPORTE DEL SISTEMA -----\n\n");
                    reporte.append("EMPRESAS REGISTRADAS:\n");
                    if (opEmpresa.listarEmpresa().isEmpty()) {
                        reporte.append("[Sin empresas en el sistema]\n");
                    } else {
                        for (Empresa emp : opEmpresa.listarEmpresa()) {
                            reporte.append(String.format(" %s (NIT: %s) - %s\n", emp.getNombre(), emp.getNit(), "Activa"));
                        }
                    }

                    reporte.append("\n--------------------------------------------------------\n\n");
                    reporte.append("EMPLEADOS REGISTRADOS:\n");
                    if (opEmpleado.listarTodos().isEmpty()) {
                        reporte.append("[Sin empleados en el sistemas]\n");
                    } else {
                        for (Empleado e : opEmpleado.listarTodos()) {
                            // Aplicamos polimorfismo y Reflection basico para saber el tipo
                            var tipo = e.getClass().getSimpleName();
                            // Simulamos o pedimos horas trabajadas, ejemplo 40 horas
                            var horasBase = 40;
                            double sueldoTotal = opEmpleado.calcularSueldo(e, horasBase);
                            reporte.append("[")
                                    .append(tipo)
                                    .append("]\n")
                                    .append(" - Nombre:")
                                    .append(e.getNombre()).append("\n")
                                    .append(" - Documento:")
                                    .append(e.getDocumentos()).append("\n")
                                    .append(" - Valor Hora: $")
                                    .append(e.getSueldoHora())
                                    .append("\n")
                                    .append(" - Sueldo (40h): $")
                                    .append(String.format("%.2f", sueldoTotal))
                                    .append("\n")
                                    .append(" - Empresa:")
                                    .append(e.getEmpresa() != null ? e.getEmpresa().getNombre() : "N/A")
                                    .append("\n\n")
                                    .append("-----------------------------------------------");
                        }
                    }
                    // Mostramos todo el acomulado en un panel con un scroll si es necesario
                    JOptionPane.showMessageDialog(null, reporte.toString(), "Consulta General de Datos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...\n¡Gracias por usar Gestion pro!", "Cierre", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida. Intenter de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
            
        } while (opcion != 4);
    }
}
