package servidor;

import interfaces.SalarioRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class SalarioImpl extends UnicastRemoteObject implements SalarioRMI {
    private int[][] matrizSalarios;
    private int empleados;
    private int meses;

    protected SalarioImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean verificarCredenciales(String usuario, String password) throws RemoteException {
        return usuario.equals("admin") && password.equals("1234");
    }

    @Override
    public void llenarMatriz(int empleados, int meses) throws RemoteException {
        this.empleados = empleados;
        this.meses = meses;
        this.matrizSalarios = new int[empleados][meses];
        Random rand = new Random();

        for (int i = 0; i < empleados; i++) {
            for (int j = 0; j < meses; j++) {
                matrizSalarios[i][j] = rand.nextInt(2000) + 1000;
            }
        }
    }

    @Override
    public int[] totalPorEmpleado() throws RemoteException {
        int[] totales = new int[empleados];
        for (int i = 0; i < empleados; i++) {
            int suma = 0;
            for (int j = 0; j < meses; j++) {
                suma += matrizSalarios[i][j];
            }
            totales[i] = suma;
        }
        return totales;
    }

    @Override
    public double[] promedioPorMes() throws RemoteException {
        double[] promedios = new double[meses];
        for (int j = 0; j < meses; j++) {
            int suma = 0;
            for (int i = 0; i < empleados; i++) {
                suma += matrizSalarios[i][j];
            }
            promedios[j] = (double) suma / empleados;
        }
        return promedios;
    }

    @Override
    public int totalPagado() throws RemoteException {
        int total = 0;
        for (int i = 0; i < empleados; i++) {
            for (int j = 0; j < meses; j++) {
                total += matrizSalarios[i][j];
            }
        }
        return total;
    }
}
