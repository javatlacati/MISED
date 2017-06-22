INSERT INTO PROGRAMA_INSTITUCIONAL(CLAVE, NOMBRE, DESCRIPCION) VALUES('1.1.01.004.R001-MD003','Servicios de Apoyo T�cnico', 'Sin descripci�n');
INSERT INTO PROGRAMA_INSTITUCIONAL(CLAVE, NOMBRE, DESCRIPCION) VALUES('1.1.01.004.R001-MD001', 'Servicios de Apoyo Parlamentario', 'Sin descripci�n');
INSERT INTO PROGRAMA_INSTITUCIONAL(CLAVE, NOMBRE, DESCRIPCION) VALUES('1.1.01.004.R001-MD002','Servicios de Apoyo Administrativo', 'Sin descripci�n');

INSERT INTO ORGANO_DIRECCION_ESTRATEGICA(id_programa_institucional, nombre, descripcion) VALUES( 1, 'Mesa Directiva','');
INSERT INTO ORGANO_DIRECCION_ESTRATEGICA(id_programa_institucional, nombre, descripcion) VALUES( 2, 'Secretar�a General de Servicios Parlamentarios','');
INSERT INTO ORGANO_DIRECCION_ESTRATEGICA(id_programa_institucional, nombre, descripcion) VALUES( 3, 'Secretar�a General de Servicios Administrativos','');



INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(2,'Secretar�a General de Servicios Parlamentarios', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(2,'Coordinaci�n de Consultor�a Jur�dica Legislativa', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(2,'Direcci�n General de Apoyo Parlamentario', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(2,'Coordinaci�n del Cuerpo T�cnico Profesional', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(2,'Direcci�n General de Archivo Hist�rico y Memoria Legislativa', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(2,'Direcci�n General de Proceso Legislativo', '');

INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Secretar�a General de Servicios Administrativos', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Recursos Humanos', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Inform�tica y Telecomunicaciones', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Recursos Materiales y Servicios Generales', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Unidad de Eventos', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Asuntos Jur�dicos', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Unidad de Atenci�n a Senadores', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Resguardo Parlamentario', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Servicios M�dicos', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Unidad de Modernizaci�n Administrativa', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Tesorer�a', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Programaci�n, Presupuesto y Finanzas', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Unidad de Pago a Senadores', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES( 3,'Direcci�n General de Contabilidad', '');

INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(1,'Centro de Estudios Internacionales Gilberto Bosques', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(1,'Unidad de Enlace para la Transparencia y el Acceso a la Informaci�n P�blica del Senado', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(1,'Contralor�a Interna', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(1,'Centro de Capacitaci�n y Formaci�n Permanente', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(1,'Instituto Belisario Dom�nguez', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(1,'Coordinaci�n de Comunicaci�n Social', '');
INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES(1,'Canal del Congreso', '');


INSERT INTO USUARIO(id_unidad_apoyo, identidad, clave_acceso, nombre, apellido_paterno, apellido_materno, puesto_laboral, correo_electronico, extension_telefonica, rol_designado, tipo_usuario, fecha_registro, hora_registro, puede_consultar, puede_actualizar, puede_agregar, puede_borrar, puede_autenticarse) VALUES (19, 'benjamin.ocotzi', '$2a$04$/pjtunFYAIzCmjBennRE7OsmTaTTytUKtccJR.iM/tSaCdOTDO4O.',
                               'Benjamin Natanael', 'Ocotzi', 'Alvarez', 'Proveedor de Soporte', 'benist.sci@gmail.com', '2345', 'ROLE_ADMINISTRADOR',
                            'TITULAR', 'martes 11 de abril de 2017', '21:57:35.42', true, true, true, true, true);




SELECT * FROM USUARIO U;



SELECT PI.*,
 (SELECT COUNT(*) FROM ORGANO_DIRECCION_ESTRATEGICA ODE
 WHERE ODE.ID_PROGRAMA_INSTITUCIONAL = PI.ID_PROGRAMA_INSTITUCIONAL)
  AS NUMERO_ORGANOS_DIRECCION_ESTRATEGICA_ADSCRITOS,
 (SELECT COUNT(*) FROM UNIDAD_APOYO UA
  INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE
   ON UA.ID_ORGANO_DIRECCION_ESTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA
 WHERE ODE.ID_PROGRAMA_INSTITUCIONAL = PI.ID_PROGRAMA_INSTITUCIONAL)
  AS NUMERO_UNIDADES_APOYO_ADSCRITAS
FROM PROGRAMA_INSTITUCIONAL PI;


SELECT ODE.*, (SELECT COUNT(UA.ID_UNIDAD_APOYO) FROM UNIDAD_APOYO UA
WHERE UA.ID_ORGANO_DIRECCION_ESTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA)
 AS NUMERO_UNIDADES_APOYO_ADSCRITAS FROM ORGANO_DIRECCION_ESTRATEGICA ODE;



SELECT UA.ID_UNIDAD_APOYO, UA.ID_ORGANO_DIRECCION_ESTRATEGICA, UA.NOMBRE, UA.PROPOSITO ,
 (SELECT COUNT(*) FROM ORGANO_DIRECCION_ESTRATEGICA ODE
 WHERE ODE.ID_PROGRAMA_INSTITUCIONAL = PI.ID_PROGRAMA_INSTITUCIONAL)
  AS NUMERO_ORGANOS_DIRECCION_ESTRATEGICA_ADSCRITOS,
 (SELECT COUNT(*) FROM UNIDAD_APOYO UA
  INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE
   ON UA.ID_ORGANO_DIRECCION_ESTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA
 WHERE ODE.ID_PROGRAMA_INSTITUCIONAL = PI.ID_PROGRAMA_INSTITUCIONAL)
  AS NUMERO_UNIDADES_APOYO_ADSCRITAS
FROM UNIDAD_APOYO UA INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE
  ON UA.ID_ORGANO_DIRECCION_eSTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA
 INNER JOIN PROGRAMA_INSTITUCIONAL PI ON ODE.ID_PROGRAMA_INSTITUCIONAL = PI.ID_PROGRAMA_INSTITUCIONAL
WHERE PI.ID_PROGRAMA_INSTITUCIONAL = 1;
