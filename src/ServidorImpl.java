import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorImpl implements Validadora{

    @Override
    public boolean validarCpf(String cpf) throws RemoteException {
        return cpf.length() == 11;
    }

    @Override
    public String maiorMenorZero(Integer valor) throws RemoteException {
        return valor >= 0 ? "Valor maior que zero" : "Valor menor que zero";
    }

    public static void main(String[] args) {
        try{

            ServidorImpl servidor = new ServidorImpl();
            //Canal de comunicaçäo para consumir os métodos de Validadora.
            Validadora stub = (Validadora) UnicastRemoteObject.exportObject(servidor, 0);

            //Registra local onde estará disponivel os stub
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            //Registra o neme para o cliente encontrar o stub
            registro.bind("validador", stub);

            System.out.println("Servidor RMI está UP!");

        }catch (Exception e){
            System.out.println("erro 500");
        }
    }
}
