INSERT INTO PROGRAMA_INSTITUCIONAL VALUES(1, '1.1.01.004.R001-MD003','Servicios de Apoyo Técnico', 'Sin descripción');
INSERT INTO PROGRAMA_INSTITUCIONAL VALUES(2,'1.1.01.004.R001-MD001', 'Servicios de Apoyo Parlamentario', 'Sin descripción');
INSERT INTO PROGRAMA_INSTITUCIONAL VALUES(3, '1.1.01.004.R001-MD002','Servicios de Apoyo Administrativo', 'Sin descripción');

INSERT INTO ORGANO_DIRECCION_ESTRATEGICA VALUES(1, 1, 'Mesa Directiva','');
INSERT INTO ORGANO_DIRECCION_ESTRATEGICA VALUES(2, 2, 'Secretaría General de Servicios Parlamentarios','');
INSERT INTO ORGANO_DIRECCION_ESTRATEGICA VALUES(3, 3, 'Secretaría General de Servicios Administrativos','');



INSERT INTO UNIDAD_APOYO VALUES(1, 2,'Secretaría General de Servicios Parlamentarios', '');
INSERT INTO UNIDAD_APOYO VALUES(2, 2,'Coordinación de Consultoría Jurídica Legislativa', '');
INSERT INTO UNIDAD_APOYO VALUES(3, 2,'Dirección General de Apoyo Parlamentario', '');
INSERT INTO UNIDAD_APOYO VALUES(4, 2,'Coordinación del Cuerpo Técnico Profesional', '');
INSERT INTO UNIDAD_APOYO VALUES(5, 2,'Dirección General de Archivo Histórico y Memoria Legislativa', '');
INSERT INTO UNIDAD_APOYO VALUES(6, 2,'Dirección General de Proceso Legislativo', '');

INSERT INTO UNIDAD_APOYO VALUES(7, 3,'Secretaría General de Servicios Administrativos', '');
INSERT INTO UNIDAD_APOYO VALUES(8, 3,'Dirección General de Recursos Humanos', '');
INSERT INTO UNIDAD_APOYO VALUES(9, 3,'Dirección General de Informática y Telecomunicaciones', '');
INSERT INTO UNIDAD_APOYO VALUES(10, 3,'Dirección General de Recursos Materiales y Servicios Generales', '');
INSERT INTO UNIDAD_APOYO VALUES(11, 3,'Unidad de Eventos', '');
INSERT INTO UNIDAD_APOYO VALUES(12, 3,'Dirección General de Asuntos Jurídicos', '');
INSERT INTO UNIDAD_APOYO VALUES(13, 3,'Unidad de Atención a Senadores', '');
INSERT INTO UNIDAD_APOYO VALUES(14, 3,'Dirección General de Resguardo Parlamentario', '');
INSERT INTO UNIDAD_APOYO VALUES(15, 3,'Dirección General de Servicios Médicos', '');
INSERT INTO UNIDAD_APOYO VALUES(16, 3,'Unidad de Modernización Administrativa', '');
INSERT INTO UNIDAD_APOYO VALUES(17, 3,'Tesorería', '');
INSERT INTO UNIDAD_APOYO VALUES(18, 3,'Dirección General de Programación, Presupuesto y Finanzas', '');
INSERT INTO UNIDAD_APOYO VALUES(19, 3,'Unidad de Pago a Senadores', '');
INSERT INTO UNIDAD_APOYO VALUES(20, 3,'Dirección General de Contabilidad', '');

INSERT INTO UNIDAD_APOYO VALUES(21, 1,'Centro de Estudios Internacionales Gilberto Bosques', '');
INSERT INTO UNIDAD_APOYO VALUES(22, 1,'Unidad de Enlace para la Transparencia y el Acceso a la Información Pública del Senado', '');
INSERT INTO UNIDAD_APOYO VALUES(23, 1,'Contraloría Interna', '');
INSERT INTO UNIDAD_APOYO VALUES(24, 1,'Centro de Capacitación y Formación Permanente', '');
INSERT INTO UNIDAD_APOYO VALUES(25, 1,'Instituto Belisario Domínguez', '');
INSERT INTO UNIDAD_APOYO VALUES(26, 1,'Coordinación de Comunicación Social', '');
INSERT INTO UNIDAD_APOYO VALUES(27, 1,'Canal del Congreso', '');

SELECT * FROM USUARIO U
INNER JOIN USUARIO_PERMISO UP
ON U.ID_USUARIO = UP.ID_USUARIO
INNER JOIN ACTIVIDAD_EXTEMPORANEA AE
ON U.ID_USUARIO = AE.ID_USUARIO;

INSERT INTO USUARIO VALUES (1, 19, 'benjamin.ocotzi', '$2a$04$/pjtunFYAIzCmjBennRE7OsmTaTTytUKtccJR.iM/tSaCdOTDO4O.', 
'Benjamin Natanael', 'Ocotzi', 'Alvarez', 'Proveedor de Soporte', 'benist.sci@gmail.com', '', 'ROLE_ADMINISTRADOR', 
'martes 11 de abril de 2017', '21:57:35.42');

INSERT INTO USUARIO_PERMISO VALUES(1, 1, true, true, true, true, true);

INSERT INTO ACTIVIDAD_EXTEMPORANEA VALUES(1, 1, false, false, false, false, false);


INSERT INTO USUARIO VALUES (2, 18, 'ruslan.lopez', '$2a$10$8UnZCnafgrZoSC/WARL5u.usGM0O2MpyGBPg6/hR7LuMKXTslYZtq',
'Ruslan', 'López', 'López', 'Tester y Diseñador Grafico', 'rustland@gmail.com','','ROLE_ADMINISTRADOR', 
'martes 11 de abril de 2017', '21:57:35.42');
INSERT INTO USUARIO_PERMISO VALUES(2, 2, true, true, true, true, true);
INSERT INTO ACTIVIDAD_EXTEMPORANEA VALUES(2, 2, false, false, false, false, false);

