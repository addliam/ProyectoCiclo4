# Proyecto Ciclo 4

Sistema de reporte de errores y sugerencias

## Convenciones

PascalCase → Para clases. (Ejemplo: Usuario)

camelCase → Para atributos y metodos. (Ejemplo: apellidoPaterno, iniciarSesion)

## Nomenclatura para componentes Swing

| Nomenclatura   | Componente | Ejemplo             |
| -------------- | ---------- | ------------------- |
| btnNombre      | JButton    | btnCrear            |
| txtNombre      | JTextField | txtApellidos        |
| labelNombre    | JLabel     | labelProductoNombre |
| textAreaNombre | JTextArea  | textAreaNombre      |
| checkNombre    | JCheckBox  | checkActivo         |
| tablaNombre    | JTable     | tablaEmpleados      |
| panelNombre    | JPanel     | panelUsuario        |

## Estructura de carpetas

```yaml
├── proyectociclo4/
│   ├── controlador/ - Gestiona las interacciones del usuario, actualiza vista y modelo
│   ├── modelo/ - Representa los datos y la lógica de negocio
│   ├── vista/ - Interfaz de usuario y presentación de datos
│   ├── recursos/
│   │   └── imagenes/
│   ├── test/ - Clases de pruebas
│   └── ProyectoCiclo4.java - Archivo principal
```

## Subir cambios a Github

```bash
git add .
git commit -m "mensaje"
git pull --rebase origin main
git push origin main
```
