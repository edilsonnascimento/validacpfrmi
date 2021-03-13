import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validadora extends Remote {

    boolean validarCpf(String cpf) throws RemoteException;

    String maiorMenorZero(Integer valor) throws RemoteException;
}
