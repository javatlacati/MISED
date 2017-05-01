INSERT INTO PROGRAMA_INSTITUCIONAL VALUES(1, '1.1.01.004.R001-MD003','Servicios de Apoyo T�cnico', 'Sin descripci�n');
INSERT INTO PROGRAMA_INSTITUCIONAL VALUES(2,'1.1.01.004.R001-MD001', 'Servicios de Apoyo Parlamentario', 'Sin descripci�n');
INSERT INTO PROGRAMA_INSTITUCIONAL VALUES(3, '1.1.01.004.R001-MD002','Servicios de Apoyo Administrativo', 'Sin descripci�n');

INSERT INTO ORGANO_DIRECCION_ESTRATEGICA VALUES(1, 1, 'Mesa Directiva','');
INSERT INTO ORGANO_DIRECCION_ESTRATEGICA VALUES(2, 2, 'Secretar�a General de Servicios Parlamentarios','');
INSERT INTO ORGANO_DIRECCION_ESTRATEGICA VALUES(3, 3, 'Secretar�a General de Servicios Administrativos','');



INSERT INTO UNIDAD_APOYO VALUES(1, 2,'Secretar�a General de Servicios Parlamentarios', '');
INSERT INTO UNIDAD_APOYO VALUES(2, 2,'Coordinaci�n de Consultor�a Jur�dica Legislativa', '');
INSERT INTO UNIDAD_APOYO VALUES(3, 2,'Direcci�n General de Apoyo Parlamentario', '');
INSERT INTO UNIDAD_APOYO VALUES(4, 2,'Coordinaci�n del Cuerpo T�cnico Profesional', '');
INSERT INTO UNIDAD_APOYO VALUES(5, 2,'Direcci�n General de Archivo Hist�rico y Memoria Legislativa', '');
INSERT INTO UNIDAD_APOYO VALUES(6, 2,'Direcci�n General de Proceso Legislativo', '');

INSERT INTO UNIDAD_APOYO VALUES(7, 3,'Secretar�a General de Servicios Administrativos', '');
INSERT INTO UNIDAD_APOYO VALUES(8, 3,'Direcci�n General de Recursos Humanos', '');
INSERT INTO UNIDAD_APOYO VALUES(9, 3,'Direcci�n General de Inform�tica y Telecomunicaciones', '');
INSERT INTO UNIDAD_APOYO VALUES(10, 3,'Direcci�n General de Recursos Materiales y Servicios Generales', '');
INSERT INTO UNIDAD_APOYO VALUES(11, 3,'Unidad de Eventos', '');
INSERT INTO UNIDAD_APOYO VALUES(12, 3,'Direcci�n General de Asuntos Jur�dicos', '');
INSERT INTO UNIDAD_APOYO VALUES(13, 3,'Unidad de Atenci�n a Senadores', '');
INSERT INTO UNIDAD_APOYO VALUES(14, 3,'Direcci�n General de Resguardo Parlamentario', '');
INSERT INTO UNIDAD_APOYO VALUES(15, 3,'Direcci�n General de Servicios M�dicos', '');
INSERT INTO UNIDAD_APOYO VALUES(16, 3,'Unidad de Modernizaci�n Administrativa', '');
INSERT INTO UNIDAD_APOYO VALUES(17, 3,'Tesorer�a', '');
INSERT INTO UNIDAD_APOYO VALUES(18, 3,'Direcci�n General de Programaci�n, Presupuesto y Finanzas', '');
INSERT INTO UNIDAD_APOYO VALUES(19, 3,'Unidad de Pago a Senadores', '');
INSERT INTO UNIDAD_APOYO VALUES(20, 3,'Direcci�n General de Contabilidad', '');

INSERT INTO UNIDAD_APOYO VALUES(21, 1,'Centro de Estudios Internacionales Gilberto Bosques', '');
INSERT INTO UNIDAD_APOYO VALUES(22, 1,'Unidad de Enlace para la Transparencia y el Acceso a la Informaci�n P�blica del Senado', '');
INSERT INTO UNIDAD_APOYO VALUES(23, 1,'Contralor�a Interna', '');
INSERT INTO UNIDAD_APOYO VALUES(24, 1,'Centro de Capacitaci�n y Formaci�n Permanente', '');
INSERT INTO UNIDAD_APOYO VALUES(25, 1,'Instituto Belisario Dom�nguez', '');
INSERT INTO UNIDAD_APOYO VALUES(26, 1,'Coordinaci�n de Comunicaci�n Social', '');
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
'Ruslan', 'L�pez', 'L�pez', 'Tester y Dise�ador Grafico', 'rustland@gmail.com','','ROLE_ADMINISTRADOR', 
'martes 11 de abril de 2017', '21:57:35.42');
INSERT INTO USUARIO_PERMISO VALUES(2, 2, true, true, true, true, true);
INSERT INTO ACTIVIDAD_EXTEMPORANEA VALUES(2, 2, false, false, false, false, false);

