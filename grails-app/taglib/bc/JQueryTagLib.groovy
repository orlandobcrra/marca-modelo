package bc

import org.codehaus.groovy.grails.web.mapping.LinkGenerator

class JQueryTagLib {
    
    //http://docs.jquery.com/UI/Datepicker/formatDate
    //http://jqueryui.com/demos/datepicker/
    //http://jquery-ui.googlecode.com/svn/trunk/ui/i18n/
    
    def jqDatePicker = {attrs, body ->
        def out=out
        def name=attrs.name
        def id=attrs.id?:name
        def format=attrs.format?:"dd/mm/yy"
        
        //Create date text field and supporting hidden text fields need by grails
        out.println """
            <input type=\"text\" name=\"${name}\" id=\"${id}\" />
            <input type=\"hidden\" name=\"${name}_day\" id=\"${id}_day\" />
            <input type=\"hidden\" name=\"${name}_month\" id=\"${id}_month\" />
            <input type=\"hidden\" name=\"${name}_year\" id=\"${id}_year\" />
        """
        
        //Code to parse selected date into hidden fields required by grails
        out.println """
            <script type="text/javascript">
                \$(document).ready(function(){
                    \$("#${id}").datepicker({
                        dateFormat: "${format}",
                        changeMonth: true,
                        changeYear: true,                        
                        onClose: function(dateText, inst) {
                            var d=\$.datepicker.parseDate( "${format}", \$("#${id}").val());
                            if(d!=null){                                
                                \$("#${id}_month").val(d.getMonth() +1);
                                \$("#${id}_day").val(d.getDate());
                                \$("#${id}_year").val(d.getFullYear());
                            }else{      
                                \$("#${id}_month").val(null);
                                \$("#${id}_day").val(null);
                                \$("#${id}_year").val(null);
                            }
                        }
                    });
                    
                })
            </script>
        """
        /*
          \$("#${id}").change(function() {
                        var d=\$.datepicker.parseDate( "${format}", \$("#${id}").val());
                        alert(d);
                        if(d!=null){                                
                            \$("#${id}_month").val(d.getMonth() +1);
                            \$("#${id}_day").val(d.getDate());
                            \$("#${id}_year").val(d.getFullYear());
                        }else{      
                            \$("#${id}_month").val(null);
                            \$("#${id}_day").val(null);
                            \$("#${id}_year").val(null);
                        }
                    });
        */
    }
    
    def jqAutocomplete = {attrs, body ->
        def out=out
        def name=attrs.name
        def id=attrs.id?:name
        def value=attrs.value?:""
        def valueId=attrs.valueId?:""
        def controller=attrs.controller
        def action=attrs.acction?:"listJSON"
        def labelItem=attrs.labelItem
        def valueItem=attrs.valueItem
        def belongsTo1=attrs.belongsTo?:""
        def hasMany1=attrs.hasMany?:""
        def hasMany2=attrs.hasMany?:""
        def disabled=""
        
        if(belongsTo1){
            belongsTo1=""", ${belongsTo1}Id: \$("#${belongsTo1}Id").val()"""
            disabled="disabled"
        }
        
        if(hasMany1){
            hasMany1="""
                    \$("#${hasMany1}").removeAttr("disabled");
                    \$("#${hasMany1}").val("");
                    \$("#${hasMany1}Id").val(null);
            """            
            hasMany2="""
                    \$("#${hasMany2}").attr("disabled","disabled"); 
                    \$("#${hasMany2}").val("");
                    \$("#${hasMany2}Id").val(null);
            """
        }
        
        def g = new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib()
        def link = g.createLink(controller: controller, action: action)
        
        out.println """ <input type="text" id="${id}" value="${value}" ${disabled}> """
        out.println """ <input type="hidden" id="${id}Id" name="${name}" value="${valueId}"> """
        out.println """
            <script>
                \$(function() {
                    \$("#${id}").autocomplete({
                        source: function( request, response ) {
                            \$.ajax({
                                url: '${link}',
                                data: {
                                    term: \$("#${id}").val()
                                    ${belongsTo1}                                   
                                },
                                dataType: "json",
                                success: function( data ) {
                                    response( \$.map( data, function( item ) {
                                        return {
                                            label: ${labelItem},
                                            value: ${valueItem},
                                            id: item.id
                                        }
                                    }));
                                }
                            });
                        },
                        minLength: 2,
                        select: function(event, ui) {
                            \$("#${id}Id").val(ui.item.id);
                            ${hasMany1}
                        },
                        change: function(event, ui) {
                            if(ui.item==null){
                                \$("#${id}Id").val(null);
                                ${hasMany2}
                            }
                        }
                    });
                });
            </script>        
        """
        
    }
}
