Feature: Inicio de sesion

Scenario: Login de usuario exitoso

Given El usuario ingresa a la siguiente direccion 'http://localhost:8080/MISED/inicio-sesion'
Then Ingresa su usuario 'benjamin.ocotzi' y la clave de acceso '123'
And Pulsa el boton de ENTRAR!
Then El usuario es redirigido a 'http://localhost:8080/MISED/inicio.htm'

