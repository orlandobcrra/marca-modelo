package bc

class GeneralController {
    
    def index() {
        redirect(uri: params.returnPage - request.contextPath)
        //render request.forwardURI
        //render params.returnPage - request.contextPath
        //- request.contextPath
    }
}
