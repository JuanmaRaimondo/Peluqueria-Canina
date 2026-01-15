# Peluqueria-Canina
# 🐶 Sistema de Gestión de Peluquería Canina

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![NetBeans](https://img.shields.io/badge/Apache%20NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans&logoColor=white)

> Una aplicación de escritorio robusta para la gestión digital de clientes (mascotas) y sus dueños, diseñada para optimizar el flujo de trabajo de una peluquería canina.

---

## 📸 Capturas de Pantalla

*(¡Reemplaza estas líneas con tus propias imágenes! Una imagen vale más que mil líneas de código)*

| Carga de Datos | Visualización de Registros |
|:---:|:---:|
| ![Formulario](assets/tu_captura_formulario.png) | ![Tabla](assets/tu_captura_tabla.png) |
| *Interfaz intuitiva para el registro de nuevas mascotas* | *Panel de administración con opciones de edición y borrado* |

---

## 🚀 Funcionalidades Principales (CRUD)

El sistema permite realizar todas las operaciones de persistencia de datos necesarias para el negocio:

- **📝 Alta de Clientes:** Registro simultáneo de datos de la Mascota y el Dueño en una sola transacción.
- **👀 Lectura de Datos:** Visualización de todos los clientes en una tabla interactiva.
- **✏️ Edición:** Modificación de datos existentes (ej: cambio de dirección del dueño o corrección de observaciones del perro).
- **🗑️ Baja:** Eliminación lógica o física de registros de la base de datos.
- **🔍 Relación 1 a 1:** Implementación de relación `@OneToOne` entre las entidades `Mascota` y `Dueño`.

---

## 🛠️ Tecnologías Utilizadas

Este proyecto fue construido siguiendo el modelo de **Capas (MVC / N-Tier)** para asegurar un código limpio y escalable.

- **Lenguaje:** Java (JDK 11+)
- **Interfaz Gráfica (GUI):** Java Swing (JFrame, JPanel).
- **Base de Datos:** MySQL.
- **Persistencia (ORM):** JPA (Java Persistence API) con Hibernate y `mysql-connector`.
- **Gestor de Dependencias:** Maven.
- **Entorno de Desarrollo:** NetBeans / IntelliJ IDEA.

---

## 💾 Modelo de Datos

La aplicación gestiona la información detallada requerida por el cliente:

### 🐾 Entidad Mascota
- **Num Cliente (ID):** Identificador único.
- **Datos:** Nombre, Raza, Color.
- **Salud:** Alérgico (Sí/No), Atención Especial (Sí/No).
- **Notas:** Observaciones del peluquero.

### 👤 Entidad Dueño
- **ID Dueño:** Identificador único.
- **Datos de contacto:** Nombre, Celular, Dirección.

---

## 🔧 Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/TU-USUARIO/peluqueria-canina-java.git](https://github.com/TU-USUARIO/peluqueria-canina-java.git)
