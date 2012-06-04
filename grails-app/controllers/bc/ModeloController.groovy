package bc

import grails.converters.JSON

class ModeloController {

    def scaffold = true

    def listJSON(){

        def sqlId=""
        def paramsSQL = [:]
        paramsSQL.put('term', params.term)
        
        if(params.marcaId){
            paramsSQL.put('marcaId', params.marcaId as long)
            sqlId="and M.marca.id = :marcaId  "
        }

        def results = Modelo.findAll("from Modelo as M where "+
                "upper(M.nombre) like upper(:term||'%') "+
                sqlId,
                paramsSQL)

        render results as JSON
    }

    def listJSON2(){

        // examples with named parameters
        //Book.findAll("from Book as b where b.author=:author",
        //             [author: 'Dan Brown'])

        // Use where criteria (since Grails 2.0)
        //def results = Person.findAll {
        //     lastName == "Simpson"
        //}

        //def results = Modelo.withCriteria {
        //    like 'nombre', params.term + '%'
        //}
        
    }
}
