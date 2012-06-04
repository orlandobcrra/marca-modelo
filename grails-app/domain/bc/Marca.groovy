package bc

class Marca {
    
    String nombre
    
    static hasMany = [modelos:Modelo]
    
    
    String toString(){
        return nombre
    }
    
    static constraints = {
    }

    static final boolean autocomplete=true
    static final String autocomplete_label="item.nombre"
    static final String autocomplete_value="item.nombre"
    static final String autocomplete_controller="marca"
    static final String autocomplete_action="listJSON";
    
 }
