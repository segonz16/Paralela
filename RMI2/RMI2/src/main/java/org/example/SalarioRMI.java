package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SalarioRMI extends Remote {
    void llenarMatriz(int empleados, int meses) throws RemoteException;

    int[] totalPorEmpleado() throws RemoteException;

    double[] promedioPorMes() throws RemoteException;

    int totalPagado() throws RemoteException;
}
