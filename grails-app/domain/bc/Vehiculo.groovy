package bc

import java.util.Date;

class Vehiculo {
    
    String placa
    Date fecha
    
    static belongsTo = [modelo:Modelo]
    
    String toString(){
        "${modelo.marca} - ${modelo}  / placa"
    }
    
    static constraints = {
    }
}
