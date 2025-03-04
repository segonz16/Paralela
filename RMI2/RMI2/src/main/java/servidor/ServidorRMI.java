package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            SalarioImpl obj = new SalarioImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("SalarioService", obj);
            System.out.println("Servidor RMI en ejecución...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
