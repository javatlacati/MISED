Feature: Pantalla de Inicio de Sesión

  Scenario: Inicio de sesión fallido
    Given Se abre el navegador
    When Se abre la url del sistema
    Then Debe existir un campo de texto para el nombre de usuario
    Then Debe existir un campo de texto para la contraseña
    Then Se cierra el navegador