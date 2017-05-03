    <nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                <a href="#" class="bars"></a>
                <a class="navbar-brand" href="/MISED/inicio.htm">
                	<fmt:message key="mensaje.nombre-aplicacion" />
                </a>
            </div>     
        </div>
    </nav>
    <section>
        <aside id="leftsidebar" class="sidebar">
            <div class="user-info">
                <div class="info-container">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></div>
                    <div class="email"></div>
                    <div class="btn-group user-helper-dropdown">
                        <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="#"><i class="material-icons">person</i>Perfil</a></li>
                            <li role="seperator" class="divider"></li>
                            <li><a href="#"><i class="material-icons">build</i>Configuraci&oacute;n</a></li>
                            <li role="seperator" class="divider"></li>
                            <li><a href="#"><i class="material-icons">input</i>Cerrar sesi&oacute;n</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="menu">
                <ol class="list">
                    <li class="header"><fmt:message key="mensaje.label-menu" /></li>
                    <li id="inicio-menu">
                        <a href="/MISED/inicio.htm">
                            <i class="material-icons">home</i>
                            <span><fmt:message key="mensaje.inicio" /></span>
                        </a>
                    </li>
                    <li id="inicio-menu">
                        <a href="/MISED/mi-perfil.htm">
                            <i class="material-icons">account_box</i>
                            <span><fmt:message key="mensaje.informacion-personal" /></span>
                        </a>
                    </li>
                    <li id="arbol-objetivos-menu">
                        <a class="menu-toggle">
                            <i class="material-icons">format_shapes</i>
                            <span><fmt:message key="mensaje.arbol-menu" /></span>
                        </a>
                        <ol class="ml-menu">
                            <li id="opcion-captura-objetivos">
                                <a href="#"><fmt:message key="mensaje.objetivos-captura" /></a>
                            </li>
                            <li id="opcion-actualizacion-objetivos">
                                <a href="#"><fmt:message key="mensaje.objetivos-actualizacion" /></a>
                            </li>
                            <li id="opcion-baja-objetivos">
                                <a href="#"><fmt:message key="mensaje.objetivos-borrado" /></a>
                            </li>
                            <li id="opcion-creacion-arbol-objetivos">
                                <a href="#"><fmt:message key="mensaje.arbol-objetivos-creacion" /></a>
                            </li>
                            <li id="opcion-borrar-arbol-objetivos">
                                <a href="#"><fmt:message key="mensaje.arbol-objetivos-borrado" /></a>
                            </li>
                            <li id="opcion-busqueda-arbol-objetivos-historial">
                                <a href="#"><fmt:message key="mensaje.arbol-objetivos-busqueda-historico" /></a>
                            </li>
                            <li id="opcion-reportes-arbol-objetivos">
                                <a href="#"><fmt:message key="mensaje.arbol-objetivos-reportes" /></a>
                            </li>
                        </ol>
                    </li>
                    <li id="matriz-indicadores-resultados-menu">
                        <a class="menu-toggle">
                            <i class="material-icons">view_list</i>
                            <span>Matriz de Indicadores para Resultados</span>
                        </a>
                        <ol class="ml-menu">
                            <li class="opcion-captura-indicador">
                                <a href="#">Captura de Indicadores</a>
                            </li>
                            <li class="opcion-busqueda-indicador">
                                <a href="#" class="menu-toggle">
                                    B&uacute;squeda de Indicadores
                                </a>
                                <ol class="ml-menu">
                                    <li class="sub-opcion-busqueda-indicador-ejercicio-presente">
                                        <a href="#">
                                           B&uacute;squeda de Indicadores del Ejercicio Fiscal Presente
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-indicador-historial">
                                        <a href="#">
                                            B&uacute;squeda de indicadores en el Historial
                                        </a>
                                    </li>
                                </ol>
                            </li>
                            <li id="opcion-actualizar-indicador">
                                <a href="#">Actualizaci&oacute;n de Indicadores</a>
                            </li>
                            <li id="opcion-reportes-matriz-indicadores-resultados">
                                <a href="#">Reportes de la Matriz de Indicadores para Resultados</a>
                            </li>
                        </ol>
                    </li>
                    <li id="cuestionario-menu">
                        <a class="menu-toggle">
                            <i class="material-icons">style</i>
                            <span>Cuestionarios de Calidad de la ESP</span>
                        </a>
                        <ol class="ml-menu">
                            <li id="opcion-calculo-muestra-y-formato-cuestionario">
                                <a href="#">C&aacute;lculo del tama&ntilde;o de la muestra y obtenci&oacute;n del Formato del Cuestionario</a>
                            </li>
                            <li id="opcion-captura-resultados-cuestionarios-esp">
                                <a href="#">Captura de Resultados de los Cuestionarios de Calidad de la ESP</a>
                            </li>
                            <li id="opcion-actualizacion-cuestionario-calidad-esp">
                                <a href="#">Actualizaci&oacute;n de Cuestionario de Calidad de la ESP</a>
                            </li>
                            <li id="opcion-busqueda-cuestionarios-calidad-esp">
                                <a href="#" class="menu-toggle">
                                    B&uacute;squeda de Cuestionarios de Calidad de la ESP
                                </a>
                                <ol class="ml-menu">
                                    <li id="sub-opcion-busqueda-cuestionarios-calidad-esp-ejercicio-presente">
                                        <a href="#">
                                            B&uacute;squeda de Cuestionarios de Calidad de la ESP del Ejercicio Fiscal Presente
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-cuestionarios-calidad-esp-historial">
                                        <a href="#">
                                            B&uacute;squeda de Cuestionarios de Calidad de la ESP en el Historial
                                        </a>
                                    </li>
                                </ol>
                            </li>
                            <li id="opcion-consulta-estadisticas-y-sugerencias-obtenidas-cuestionarios-calidad-esp">
                                <a href="#">Consultar Estad&iacute;sticas y Sugerencias Obtenidas de
                                los Cuestionarios de Calidad de la ESP</a>
                            </li>
                            <li id="opcion-reportes-cuestionarios-calidad-esp">
                                <a href="#">Reportes de Cuestionarios de Calidad de la ESP</a>
                            </li>
                        </ol>
                    </li>
                    <li id="calendario-metas-menu">
                        <a class="menu-toggle">
                            <i class="material-icons">date_range</i>
                            <span>Calendario de Metas de la Matriz de Indicadores para Resultados</span>
                        </a>
                        <ol class="ml-menu">
                            <li id="opcion-captura-calendario-metas-mir">
                                <a href="#">Captura de Calendarios de Metas de la MIR</a>
                            </li>
                            <li id="opcion-busqueda-calendario-metas-mir">
                                <a href="#" class="menu-toggle">
                                    B&uacute;squeda de Calendarios de Metas de la MIR
                                </a>
                                <ol class="ml-menu">
                                    <li id="sub-opcion-busqueda-calendarios-metas-mir-ejercicio-presente">
                                        <a href="#">
                                            B&uacute;squeda de Calendarios de Metas de la MIR
                                            del Ejercicio Fiscal Presente
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-calendarios-metas-mir-historial">
                                        <a href="#">
                                            B&uacute;squeda de Calendarios de Metas de la MIR
                                            en el Historial
                                        </a>
                                    </li>
                                </ol>
                            </li>
                            <li id="opcion-actualizacion-calendarios-metas-mir">
                                <a href="#">Actualizaci&oacute;n de Calendarios de Metas de la MIR</a>
                            </li>
                            <li id="opcion-actualizacion-reportes-calendarios-metas-mir">
                                <a href="#">Reportes de Calendarios de Metas de la MIR</a>
                            </li>
                        </ol>
                    </li>
                    <li id="informe-menu">
                        <a class="menu-toggle">
                            <i class="material-icons">insert_drive_file</i>
                            <span>Informe Cuatrimestral de Avance de los Indicadores</span>
                        </a>
                        <ol class="ml-menu">
                            <li id="opcion-captura-informe-indicador">
                                <a href="#">Captura de Informe Cuatrimestral de Avance de los Indicadores</a>
                            </li>
                            <li id="opcion-busqueda-informe-indicador">
                                <a href="#" class="menu-toggle">
                                   B&uacute;squeda de Informes Cuatrimestrales de Avances de los Indicadores
                                </a>
                                <ol class="ml-menu">
                                    <li id="sub-opcion-busqueda-informe-indicador-ejercicio-presente">
                                        <a href="#">
                                            B&uacute;squeda de Informe Cuatrimestral de Avance de los
                                            Indicadores del Ejercicio Fiscal Presente
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-informe-indicador-historial">
                                        <a href="#">
                                            B&uacute;squeda de Informes Cuatrimestrales de Avances de los
                                            Indicadores en el Historial
                                        </a>
                                    </li>
                                </ol>
                            </li>
                            <li id="opcion-actualizacion-informe-indicador">
                                <a href="#">Actualizaci&oacute;n de Informes Cuatrimestrales de Avances de los Indicadores</a>
                            </li>
                            <li id="opcion-reportes-informe-indicador">
                                <a href="#">Reportes de Informes Cuatrimestrales de Avances de los Indicadores</a>
                            </li>
                        </ol>
                    </li>
                    <li id="cuadro-mando-menu">
                        <a class="menu-toggle">
                            <i class="material-icons">grid_on</i>
                            <span>Cuadros de Mando</span>
                        </a>
                        <ol class="ml-menu">
                            <li id="opcion-busqueda-cuadro-mando">
                                <a href="#" class="menu-toggle">
                                    B&uacute;squeda de Cuadros de Mando
                                </a>
                                <ol class="ml-menu">
                                    <li id="opcion-busqueda-cuadro-mando-ejercicio-presente">
                                        <a href="#">
                                            B&uacute;squeda de Cuadros de Mando del Ejercicio Fiscal Presente
                                        </a>
                                    </li>
                                    <li id="opcion-busqueda-cuadro-mando-historial">
                                        <a href="#">
                                            B&uacute;squeda de Cuadros de Mando en el Historial
                                        </a>
                                    </li>
                                </ol>
                            </li>
                            <li id="opcion-reportes-cuadro-mando">
                                <a href="#">Reportes de Cuadros de Mando</a>
                            </li>
                        </ol>
                    </li>
                    <sec:authorize access="hasRole('ADMINISTRADOR')">
                    <li id="administracion-sistema-menu">
                        <a class="menu-toggle">
                            <i class="material-icons">build</i>
                            <span>Administraci&oacute;n del Sistema</span>
                        </a>
                        <ol class="ml-menu">


                            <li id="opcion-programa-institucional">
                                <a class="menu-toggle">
                                	<i class="material-icons">view_agenda</i>
                                    <span>Programas Institucionales</span>
                                </a>
                                <ul class="ml-menu">
                                    <li id="sub-opcion-administracion-programas-institucionales">
                                        <a href="/MISED/administrador/programa-institucional/administracion-programas-institucionales.htm">
                                            Administraci&oacute;n de Programas Institucionales
                                        </a>
                                    </li>


                                </ul>
                            </li>

                            <li id="opcion-organo-direccion-estrategica">
                            	<a href="/MISED/administrador/organo-direccion-estrategica/administracion-organos-direccion-estrategica.htm">
                                	<i class="material-icons">book</i>
                                    <span>&Oacute;rganos de Direcci&oacute;n Estrat&eacute;gica</span>
                                </a>
                            </li>

                        	<li id="opcion-unidad-apoyo">
                            	<a href="/MISED/administrador/unidad-apoyo/administracion-unidades-apoyo.htm">
                                	<i class="material-icons">bookmark_border</i>
                                    <span>Unidades de Apoyo</span>
                                </a>
                            </li>

                            <li id="opcion-usuario">
                                <a class="menu-toggle">
                                	<i class="material-icons">people</i>
                                    <span>Usuarios</span>
                                </a>
                                <ul class="ml-menu">
                                    <li id="sub-opcion-captura-usuario">
                                        <a href="/MISED/administrador/usuarios/captura-usuarios.htm">
                                            Captura de Usuarios
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-usuario">
                                        <a href="/MISED/administrador/usuarios/busqueda-usuarios.htm">
                                            B&uacute;squeda de Usuarios
                                        </a>
                                    </li>
                                    <li id="sub-opcion-permisos-usuario">
                                        <a href="/MISED/administrador/usuarios/permisos-usuarios.htm">
                                            Permisos de Usuarios
                                        </a>
                                    </li>
                                    <li id="sub-opcion-actualizacion-usuario">
                                        <a href="/MISED/administrador/usuarios/actualizar-usuarios.htm">
                                            Actualizaci&oacute;n de Usuarios
                                        </a>
                                    </li>
                                    <li id="sub-opcion-baja-usuario">
                                        <a href="/MISED/administrador/usuarios/baja-usuarios.htm">
                                            Baja de Usuarios
                                        </a>
                                    </li>
                                    <li id="sub-opcion-reestablecer-contrasena-usuario">
                                        <a href="/MISED/administrador/usuarios/reestablecer-credenciales-usuarios.htm">
                                            Reestablecer Contrase&ntilde;a de Usuario
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li id="opcion-aviso-y-archivo-sistema">
                                <a href="/MISED/administrador/avisos/gestion.htm">
                                	<i class="material-icons">cast_connected</i>
                                    <span>Avisos y Archivos del Sistema</span>
                                </a>
                            </li>
                            <li id="opcion-configuracion-fechas">
                                <a href="/MISED/administrador/ejercicios-fiscales/gestion.htm">
                                	<i class="material-icons">event</i>
                                    <span>Configuraci&oacute;n de Fechas de Captura del Sistema</span>
                                </a>
                            </li>
                            <li id="opcion-menu-arbol-objetivos-admin">
                                <a class="menu-toggle">
		                            <i class="material-icons">format_shapes</i>
		                            <span>&Aacute;rbol de Objetivos</span>
		                        </a>
                                <ul class="ml-menu">
                                	<li id="sub-opcion-alta-objetivos-admin">
                                        <a href="#">
											Alta de Objetivos	
                                        </a>
                                    </li>
                                	<li id="sub-opcion-edicion-objetivos-admin">
                                        <a href="#">
											Edición de Objetivos	
                                        </a>
                                    </li>
                                    <li id="sub-opcion-baja-objetivos-admin">
                                        <a href="#">
											Baja de Objetivos	
                                        </a>
                                    </li>
                                    <li id="sub-opcion-edicion-arbol-objetivos-admin">
                                        <a href="#">
											Edici&oacute;n de &Aacute;rbol de Objetivos
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-arbol-objetivos-admin">
                                        <a href="#">
                                        	B&uacute;squeda de &Aacute;rboles de Objetivos
                                        </a>
                                    </li>
                                    <li id="sub-opcion-reportes-arboles-objetivos-admin">
                                        <a href="#">
											Reporte de &Aacute;rboles de Objetivos
                                        </a>
                                    </li>
                                </ul>
                            </li>                            
                            <li id="opcion-matriz-indicadores-resultados-admin">
                                <a class="menu-toggle">
		                            <i class="material-icons">view_list</i>
		                            <span>Matriz de Indicadores para Resultados</span>
		                        </a>
                                <ul class="ml-menu">
                                    <li id="sub-opcion-edicion-indicadores-resultados-admin">
                                        <a href="#">
											Edici&oacute;n de Indicadores para Resultados
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-indicadores-resultados-admin">
                                        <a href="#">
                                        	Busqueda de Indicadores para Resultados
                                        </a>
                                    </li>
                                    <li id="sub-opcion-reporte-matrices-indicadores-resultados-admin">
                                        <a href="#">
											Reporte de Matrices de Indicadores para Resultados
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li id="opcion-cuestionarios-calidad-esp-admin">
                                <a class="menu-toggle">
		                            <i class="material-icons">style</i>
		                            <span>Cuestionarios de Calidad de la ESP</span>
		                        </a>
                                <ul class="ml-menu">
                                    <li id="sub-opcion-busqueda-cuestionarios-calidad-esp-historial-admin">
                                        <a href="#">
											B&uacute;squeda de Cuestionarios de Calidad de la ESP en el Historial
                                        </a>
                                    </li>
                                    <li id="sub-opcion-consultar-estadisticas-y-sugerencias-cuestionarios-esp-admin">
                                    	<a href="#">
                                    		Consultar Estad&iacute;sticas y Sugerencias Obtenidas de
                                			los Cuestionarios de Calidad de la ESP
                                    	</a>
                                    </li>
                                    <li id="sub-opcion-reportes-cuestionarios-calidad-esp-admin">
                                        <a href="#">
											Reportes de Cuestionarios de Calidad de la ESP
                                        </a>
                                    </li>
                                </ul>
                            </li> 
                            <li id="opcion-calendario-metas-indicadores-admin">
                                <a class="menu-toggle">
		                            <i class="material-icons">date_range</i>
		                            <span>Calendario de Metas de la Matriz de Indicadores para Resultados</span>
		                        </a>
                                <ul class="ml-menu">
                                    <li id="sub-opcion-busqueda-calendarios-metas-mir-admin">
                                        <a href="#">
											B&uacute;squeda de Calendarios de Metas de la MIR
                                        </a>
                                    </li>
                                    <li id="sub-opcion-actualizacion-calendarios-metas-mir-admin">
                                    	<a href="#">
                                    		Actualizaci&oacute;n de Calendarios de Metas de la MIR
                                    	</a>
                                    </li>
                                    <li id="sub-opcion-reporte-calendarios-metas-mir-admin">
                                        <a href="#">
											Reporte de Calendarios de Metas de la MIR
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            
                            
                            <li id="opcion-informes-cuatrimestrales-admin">
                                <a class="menu-toggle">
		                            <i class="material-icons">insert_drive_file</i>
		                            <span>Informe Cuatrimestral de Avance de los Indicadores</span>
		                        </a>
                                <ul class="ml-menu">
                                    <li id="sub-opcion-busqueda-informe-cuatrimestrales-indicadores-admin">
                                        <a href="#">
											Búsqueda de Informes Cuatrimestrales de Avances de los Indicadores
                                        </a>
                                    </li>
                                    <li id="sub-opcion-actualizacion-informe-cuatrimestrales-indicadores-admin">
                                    	<a href="#">
                                    		Actualización de Informe Cuatrimestral de Avance de los Indicadores
                                    	</a>
                                    </li>
                                    <li id="sub-opcion-reporte-informe-cuatrimestrales-indicadores-admin">
                                        <a href="#">
											Reporte de Informes Cuatrimestrales de Avances de los Indicadores
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            
                            
                            <li class="opcion-cuadros-mando-admin" style="margin-bottom: 60px;">
                                <a class="menu-toggle">
		                            <i class="material-icons">grid_on</i>
		                            <span>Cuadros de Mando</span>
		                        </a>
                                <ul class="ml-menu">
                                    <li id="sub-opcion-generacion-cuadros-mando-admin">
                                        <a href="#">
											Generaci&oacute;n de Cuadros de Mando
                                        </a>
                                    </li>
                                    <li id="sub-opcion-busqueda-cuadros-mando-admin">
                                    	<a href="#">
                                    		Busqueda de Cuadros de Mando
                                    	</a>
                                    </li>
                                    <li id="sub-opcion-observacion-cuadros-mando-admin">
                                    	<a href="#">
                                    		A&ntilde;adir Observaci&oacute;n a Cuadro de Mando
                                    	</a>
                                    </li>
                                    <li id="sub-opcion-reportes-cuadros-mando-admin">
                                        <a href="#">
											Reporte de Cuadros de Mando
                                        </a>
                                    </li>
                                </ul>
                            </li>  

                        </ol>     
                    </li>
					</sec:authorize>	
<!-- 					<sec:authorize access="hasRole('SEGP')"> -->
<!-- 					<li id="inicio-menu"> -->
<!--                         <a href="/MISED/sadsadasdasdasd.htm"> -->
<!--                             <i class="material-icons">label</i> -->
<!--                             <span>Auditoria de la Gestión Parlamentaria</span> -->
<!--                         </a> -->
<!--                     </li> 	 -->
<!--                     </sec:authorize> -->
                    
<!--                     <sec:authorize access="hasRole('SEGA')"> -->
<!--                     <li id="inicio-menu"> -->
<!--                         <a href="/MISED/sadsadasdasdasd.htm"> -->
<!--                             <i class="material-icons">label</i> -->
<!--                             <span>Auditoria de la Gestión Administrativa</span> -->
<!--                         </a> -->
<!--                     </li> 	 -->
<!--                     </sec:authorize>	 -->
                    	
			        <li id="cerrar-sesion">
				       <form method="post" id="frmCierreSesion" action="<c:url value="/cierre-sesion?${_csrf.parameterName}=${_csrf.token}" />">
		                   <a onclick="cerrarSesion();">
		                       <i class="material-icons glyphicon glyphicon-log-in"></i>
		                       <span>Cerrar Sesi&oacute;n</span>
		                   </a>
		               </form>
	                </li> 
                </ol>
            </div>
        </aside>
    </section>