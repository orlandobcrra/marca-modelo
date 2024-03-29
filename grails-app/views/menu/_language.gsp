<g:set var="lang" value="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'}"/>


<ul class="nav pull-right language-dropdown">
						<li class="dropdown js-language-dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="javascript:;">
							<span class="js-current-language">${lang ? lang.toString().toUpperCase() : "${message(code: 'default.language.button', default: 'Language')}"}</span>
							</a>
							<ul class="dropdown-menu dropdown-menu-dark">	


			
			<li><a class="js-language-link" title="English" data-lang-code="en" href="${createLink(uri: '/general?lang=us&returnPage='+ request.forwardURI)}">English</a></li>
			
			<li><a class="js-language-link" title="German" data-lang-code="de" href="${createLink(uri: '/general?lang=de&returnPage='+ request.forwardURI)}">Deutsch</a></li>
		
			<li><a class="js-language-link" title="Spanish" data-lang-code="es" href="${createLink(uri: '/general?lang=es&returnPage='+ request.forwardURI)}">Español</a></li>
		
			<li><a class="js-language-link" title="French" data-lang-code="fr" href="${createLink(uri: '/general?lang=fr&returnPage='+ request.forwardURI)}">Français</a></li>
			
		</ul>
	</li>
</ul>