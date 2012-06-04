package bc

class Modelo {

    String nombre
    
    static belongsTo = [marca:Marca]
    
    String toString(){
        return nombre
    }
    
    static constraints = {
    }
    
    static final boolean autocomplete=true
    static final String autocomplete_label="item.nombre"
    static final String autocomplete_value="item.nombre"
    static final String autocomplete_controller="modelo"
    static final String autocomplete_action="listJSON";
    
}
