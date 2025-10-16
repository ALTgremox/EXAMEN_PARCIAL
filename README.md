# 🎨 Juego de Colores – Examen Parcial 2025-2

> **Curso:** Programación para Dispositivos Móviles  
> **Docente:** Josue Miguel Flores Parra  
> **Alumno:** *[Tu nombre aquí]*  
> **Semestre:** Sexto  
> **Fecha:** 16 de octubre de 2025  

---

## 🧠 Descripción del Proyecto

**Juego de Colores** es una aplicación Android desarrollada en **Kotlin** y **Android Studio**,  
que pone a prueba los reflejos del usuario al identificar correctamente los colores mostrados en pantalla.  

El jugador debe presionar el botón que coincida con el color que se muestra, dentro de un límite de **30 segundos**.  
El juego lleva el control de los puntajes de cada partida, guarda el **récord histórico**,  
y muestra un **historial de partidas** utilizando la base de datos local **Room**.

---

## 🎯 Objetivos del Examen

- Demostrar dominio del desarrollo con **Fragments** y **navegación dinámica**.  
- Implementar un **temporizador** (`CountDownTimer`) para medir el tiempo de juego.  
- Aplicar **lógica condicional y manejo de estados** en Kotlin.  
- Crear una interfaz moderna con **ConstraintLayout**.  
- Implementar **almacenamiento persistente** con **Room** y **SharedPreferences**.  
- Mejorar la interacción del usuario mediante **AlertDialog** y componentes visuales.  
- Cumplir las buenas prácticas de programación, organización y diseño.

---

## 🧩 Estructura de la Aplicación

```
📁 app/
 ┣ 📂 java/com/example/examparcial/
 ┃ ┣ 📜 MainActivity.kt
 ┃ ┣ 📜 WelcomeFragment.kt
 ┃ ┣ 📜 GameFragment.kt
 ┃ ┣ 📜 ResultFragment.kt
 ┃ ┣ 📜 PuntajeAdapter.kt
 ┃ ┗ 📂 data/
 ┃    ┣ 📜 AppDatabase.kt
 ┃    ┣ 📜 ScoreDao.kt
 ┃    ┗ 📜 ScoreEntity.kt
 ┣ 📂 res/
 ┃ ┣ 📂 layout/
 ┃ ┃ ┣ 📜 activity_main.xml
 ┃ ┃ ┣ 📜 fragment_welcome.xml
 ┃ ┃ ┣ 📜 fragment_game.xml
 ┃ ┃ ┣ 📜 fragment_result.xml
 ┃ ┃ ┗ 📜 item_puntaje.xml
 ┃ ┗ 📂 values/
 ┃    ┗ 📜 colors.xml, strings.xml, themes.xml
```

---

## 🧮 Flujo del Juego

| Etapa | Descripción |
|--------|--------------|
| 🏁 **WelcomeFragment** | Muestra el título, reglas del juego (en `AlertDialog`) y un botón “Iniciar juego”. |
| 🎮 **GameFragment** | Muestra un color aleatorio, botones de colores, contador de tiempo y puntaje. |
| 🧾 **ResultFragment** | Presenta el puntaje final, el puntaje máximo histórico (`Room` + `SharedPreferences`), y un historial con `RecyclerView`. |

---

## 💾 Persistencia de Datos

### 🔹 SharedPreferences  
Guarda el **puntaje más alto histórico**, incluso si el jugador cierra la app.  
```kotlin
val prefs = requireActivity().getSharedPreferences("game_prefs", Context.MODE_PRIVATE)
prefs.edit().putInt("high_score", finalScore).apply()
```

### 🔹 Room Database  
Guarda el **historial de partidas** con los siguientes componentes:

| Archivo | Función |
|----------|----------|
| `ScoreEntity.kt` | Define la entidad de la tabla `scores`. |
| `ScoreDao.kt` | Contiene consultas `INSERT` y `SELECT`. |
| `AppDatabase.kt` | Crea la base de datos `scores_db` y provee acceso al DAO. |

---

## 🧠 Tecnologías y Librerías

| Tecnología | Uso |
|-------------|-----|
| 🧩 Kotlin | Lenguaje principal |
| 🧭 AndroidX Navigation | Navegación entre Fragments |
| 🧱 ConstraintLayout | Diseño responsivo |
| ⏱ CountDownTimer | Temporizador de 30 segundos |
| 💾 Room Database | Almacenamiento persistente del historial |
| ⚙️ SharedPreferences | Guardar récord más alto |
| 🧰 RecyclerView | Mostrar historial de puntajes |
| 🪟 AlertDialog | Mostrar reglas del juego |

---

## 📋 Requisitos de Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/[tu_usuario]/JuegoDeColores.git
   ```

2. **Abrir el proyecto en Android Studio.**

3. **Compilar con:**
   - `compileSdk = 34`
   - `minSdk = 24`
   - `targetSdk = 34`
   - JDK 17 o superior.

4. **Ejecutar en un emulador o dispositivo físico Android.**

---

## 🧑‍💻 Ejemplo de Ejecución

```text
🟩 Aparece un cuadro verde.
➡️ El jugador presiona el botón verde.
✅ +1 punto, se genera un nuevo color aleatorio.
⏱ El temporizador baja hasta 0.
🧾 Se muestra el resultado, el récord y el historial de partidas.
```

---

## 🏆 Cumplimiento de Criterios

| Criterio Evaluado | Estado | Implementación |
|--------------------|---------|----------------|
| Navegación entre Fragments | ✅ | `Welcome → Game → Result` |
| Temporizador (`CountDownTimer`) | ✅ | Juego de 30 segundos |
| Interacción y feedback | ✅ | Botones + cambio de color |
| Manejo de estados y lógica | ✅ | Control de aciertos y reinicio |
| Diseño con ConstraintLayout | ✅ | En todos los Fragments |
| Buenas prácticas Kotlin | ✅ | Código modular, `binding`, `companion object` |
| SharedPreferences | ✅ | Guarda récord más alto |
| AlertDialog | ✅ | Muestra reglas iniciales |
| Room Database | ✅ | Guarda y lista historial persistente |
| RecyclerView | ✅ | Visualiza partidas jugadas |

---

## 🧑‍🏫 Créditos

**Desarrollado por:**  
👨‍💻 *[Tu nombre completo]*  
📚 Estudiante de Ingeniería – Facultad de Ingenierías y Arquitectura  

**Profesor:**  
🎓 *Josue Miguel Flores Parra*  

---

## 📜 Licencia

Este proyecto fue desarrollado con fines académicos en el marco del **Examen Parcial 2025-2**  
del curso *Programación para Dispositivos Móviles*.  
Se autoriza su uso educativo y demostrativo.
