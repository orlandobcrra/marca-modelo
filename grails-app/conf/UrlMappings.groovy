class UrlMappings {
    
    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
        
        /*
         * Pages without controller
         */
        "/about"        (view:"/siteinfo/about")
        "/blog"         (view:"/siteinfo/blog")
        "/systeminfo"   (view:"/siteinfo/systeminfo")
        "/contact"      (view:"/siteinfo/contact")
        "/terms"        (view:"/siteinfo/terms")
        "/imprint"      (view:"/siteinfo/imprint")
        
        "/"(view:"/index")
        "500"(view:'/error')
    }
}
