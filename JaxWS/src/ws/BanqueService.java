package ws;
import javax.
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@webService(ServiceName="BanqueWS")
class BanqueService {
    @webMethod(operatinName="ConversionEuroToDH")
    public double conversion(@webParam(name="montant") double mt){
        return mt*11;
    }
    @webMethod
    public Compte getCompte(@webParam(name="code") int code){
        return new Compte(code,Math.random()*9000,new Date());
    }
    @webMethod
    public List<Compte> listComptes(){
        List<Compte> comptes=new ArrayList<>();
        comptes.add(new Compte(1,Math.random()*9000,new Date()));
        comptes.add(new Compte(2,Math.random()*9000,new Date()));
        comptes.add(new Compte(3,Math.random()*9000,new Date()));
        return comptes;
    }
}
