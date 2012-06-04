

<%@ page import="bc.Vehiculo" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'vehiculo.label', default: 'Vehiculo')}" />
	<title><g:message code="default.create.label" args="[entityName]" /></title>
</head>

<body>
<section id="create" class="first">

	<g:hasErrors bean="${vehiculoInstance}">
	<div class="alert alert-error">
		<g:renderErrors bean="${vehiculoInstance}" as="list" />
	</div>
	</g:hasErrors>
	
	<g:form action="save" class="form-horizontal" >
				
							<div class="control-group ${hasErrors(bean: vehiculoInstance, field: 'fecha', 'error')}">
								<label for="fecha" class="control-label"><g:message code="vehiculo.fecha.label" default="Fecha" /></label>
				            	<div class="controls">
									<g:jqDatePicker name="fecha"/>
									<span class="help-inline">${hasErrors(bean: vehiculoInstance, field: 'fecha', 'error')}</span>
								</div>
							</div>
							
							<div class="control-group ${hasErrors(bean: vehiculoInstance, field: 'modelo.marca', 'error')}">
								<label for="marca" class="control-label"><g:message code="vehiculo.modelo.marca.label" default="Marca" /></label>
				            	<div class="controls">
									<g:jqAutocomplete id="marca" name="marca.id" hasMany="modelo" value="${vehiculoInstance?.modelo?.marca}" valueId="${vehiculoInstance?.modelo?.marca?.id}" controller="${bc.Marca.autocomplete_controller}" action="${bc.Marca.autocomplete_action}" labelItem="${bc.Marca.autocomplete_label}" valueItem="${bc.Marca.autocomplete_value}" />

									<span class="help-inline">${hasErrors(bean: vehiculoInstance, field: 'modelo', 'error')}</span>
								</div>
							</div>
				
							<div class="control-group ${hasErrors(bean: vehiculoInstance, field: 'modelo', 'error')}">
								<label for="modelo" class="control-label"><g:message code="vehiculo.modelo.label" default="Modelo" /></label>
				            	<div class="controls">
									<g:jqAutocomplete id="modelo" name="modelo.id" belongsTo="marca" value="${vehiculoInstance?.modelo}" valueId="${vehiculoInstance?.modelo?.id}" controller="${bc.Modelo.autocomplete_controller}" action="${bc.Modelo.autocomplete_action}" labelItem="${bc.Modelo.autocomplete_label}" valueItem="${bc.Modelo.autocomplete_value}" />

									<span class="help-inline">${hasErrors(bean: vehiculoInstance, field: 'modelo', 'error')}</span>
								</div>
							</div>
				
							<div class="control-group ${hasErrors(bean: vehiculoInstance, field: 'placa', 'error')}">
								<label for="placa" class="control-label"><g:message code="vehiculo.placa.label" default="Placa" /></label>
				            	<div class="controls">
									<g:textField name="placa" value="${vehiculoInstance?.placa}" />
									<span class="help-inline">${hasErrors(bean: vehiculoInstance, field: 'placa', 'error')}</span>
								</div>
							</div>
				
		<div class="form-actions">
			<g:submitButton name="create" class="save btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
            <button class="btn" type="reset">Cancel</button>
		</div>
	</g:form>
	
</section>
		
</body>

</html>
