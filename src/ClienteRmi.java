import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRmi {

    public static void main(String[] args) {
        try{

            //Conectar ao servidor de registro
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            //Invoca métdo do servidor
            Validadora stub = (Validadora) registro.lookup("validador");

            String cpf = "04068307970";
            System.out.println("O CPF: " + cpf + " é valido?" + stub.validarCpf(cpf));
            System.out.println("O número 10 é: " + stub.maiorMenorZero(10));

        }catch (Exception e){
            System.out.println("Não foi possível conectar ao Servidor RMI");
        }
    }
}
