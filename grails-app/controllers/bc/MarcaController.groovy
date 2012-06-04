package bc

import grails.converters.JSON

class MarcaController {

    def scaffold = true
    
    def listJSON(){
        
        def results = Marca.withCriteria {
            ilike 'nombre', params.term + '%'
        }
        
        render results as JSON
    }
}