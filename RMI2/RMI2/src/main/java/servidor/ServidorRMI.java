package servidor;

import interfaces.SalarioRMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            SalarioRMI obj = new SalarioImpl();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("SalarioService", obj);

            System.out.println(" Servidor RMI en ejecución en el puerto 1099...");
        } catch (RemoteException e) {
            System.err.println(" Error al iniciar el servidor RMI.");
            e.printStackTrace();
        }
    }
}
