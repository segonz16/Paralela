package org.example;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            SalarioRMI stub = (SalarioRMI) registry.lookup("SalarioService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el número de empleados: ");
            int empleados = scanner.nextInt();
            System.out.print("Ingrese el número de meses: ");
            int meses = scanner.nextInt();

            stub.llenarMatriz(empleados, meses);

            int[] totalesEmpleados = stub.totalPorEmpleado();
            double[] promediosMes = stub.promedioPorMes();
            int totalPagado = stub.totalPagado();

            System.out.println("\nTotal pagado por cada empleado:");
            for (int i = 0; i < empleados; i++) {
                System.out.println("Empleado " + (i + 1) + ": " + totalesEmpleados[i]);
            }

            System.out.println("\nPromedio de pago por mes:");
            for (int j = 0; j < meses; j++) {
                System.out.println("Mes " + (j + 1) + ": " + promediosMes[j]);
            }

            System.out.println("\nTotal pagado en la matriz: " + totalPagado);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
