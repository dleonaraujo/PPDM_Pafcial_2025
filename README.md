# Examen - Juego de Colores

Este repositorio contiene la solución al examen parcial del curso **Programación para Dispositivos Móviles**, desarrollado en Kotlin usando Android Studio. El proyecto consiste en una aplicación interactiva llamada Juego de Colores (tambien conocida game_color en mi version del app), donde el usuario debe tocar el botón del color que se muestra aleatoriamente como texto.

**Descripción de la Aplicación**

game_color es una aplicación que pone a prueba la agilidad y atención del usuario al mostrar un nombre de color (por ejemplo, "Verde") y ofrecer varios botones con diferentes colores. El jugador debe presionar el botón que coincide con el nombre mostrado.

**Flujo de Navegación**

1. La aplicación inicia en la Pantalla de Bienvenida (WelcomeFragment).
2. Al presionar el botón "Comenzar", navega hacia la Pantalla de Juego (GameFragment).
3. En la Pantalla de Juego:
   - Se muestra el nombre de un color.
   - El usuario selecciona uno de los tres botones de color.
   - Se valida si la elección fue correcta o incorrecta.
4. Luego de una pausa (temporizador), se navega automáticamente a la Pantalla de Resultado (ResultFragment) con el resultado.
5. En la Pantalla de Resultado se muestra un mensaje (correcto/incorrecto) y un botón para volver a empezar.
6. Al presionar “Volver a Jugar”, se regresa a la Pantalla de Juego para un nuevo intento.


**Características Implementadas**

- Interfaz compuesta por tres pantallas:
  - Pantalla de Bienvenida: incluye un botón para comenzar el juego.
  - Pantalla de Juego: muestra el nombre del color a adivinar y tres botones (verde, azul y amarillo).
  - Pantalla de Resultado: muestra si la respuesta fue correcta o incorrecta.
- Uso de Fragments y Navigation Component para la navegación entre pantallas.
- Temporizador para mostrar la siguiente pregunta tras la respuesta.
- Paso de datos entre fragments usando Bundle y setFragmentResult().
- Diseño responsivo con LinearLayout y estilos personalizados de botones.


## Como ejecutar

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/dleonaraujo/PPDM_Pafcial_2025.git
   ```
2. Abrir el proyecto en Android Studio.
3. Compilar y ejecutar en un emulador o dispositivo físico.

---

## Estructura del Proyecto

```plaintext
JuegoColores/
├── app/
│   ├── src/main/java/com/ppdm/game_color/
│   │   ├── WelcomeFragment.kt
│   │   ├── GameFragment.kt
│   │   ├── ResultFragment.kt
│   ├── res/layout/
│   │   ├── fragment_welcome.xml
│   │   ├── fragment_game.xml
│   │   ├── fragment_result.xml
│   ├── res/navigation/
│   │   ├── nav_graph.xml
│   ├── res/values/
│   │   ├── colors.xml
│   │   ├── strings.xml
├── README.md
└── build.gradle

```
