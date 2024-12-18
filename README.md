# Backend-Wakanda-Transporte-Movilidad


1. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Frontend-Wakanda
2. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-API-Central   -> API-Central (Gestiona los microservicios y muestra un tablero de Wakanda).
3. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Eureka-Server   -> Eureka-Server/Grafana/Prometheus
4. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/InitManager   -> Lanza el Eureka-Server/Prometheus/Grafana y ejecuta un script para lanzar los microservicios.
5. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Python-Script-Launcher   -> Script para lanzar los microservicios en orden.
6. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend_Wakanda_Salud
7. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Agua
8. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Transporte-Movilidad
9. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Gobierno
10. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Cultura-Ocio-Turismo
11. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Trafico
12. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Seguridad
13. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Residuos
14. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Conectividad-Redes
15. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Energia-Sostenible-Eficiente
16. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Servicios-Emergencia
17. https://github.com/Sistema-Gestion-Servicios-Wakanda-J-M-N/Backend-Wakanda-Educacion

## Participantes del proyecto

- Jaime López Díaz
- Marcos García Benito
- Nicolas Jimenez
- Juan Manuel

## Servicios

### `TransporteService`

- **Descripción**: Servicio para gestionar transportes.
- **Métodos**:
    - `List<TransporteDTO> getAll()`: Obtener todos los transportes.
    - `TransporteDTO getById(Long id)`: Obtener un transporte por ID.
    - `Long create(TransporteDTO dto)`: Crear un nuevo transporte.
    - `void update(Long id, TransporteDTO dto)`: Actualizar un transporte existente.
    - `void delete(Long id)`: Eliminar un transporte por ID.

### `DatosTransporteService`

- **Descripción**: Servicio para gestionar datos de transporte.
- **Métodos**:
    - `List<DatosTransporte> getAll()`: Obtener todos los datos de transporte.
    - `DatosTransporte getById(Long id)`: Obtener datos de transporte por ID.
    - `DatosTransporte create(Long transporteId)`: Crear datos de transporte desde una entidad de transporte existente.
    - `List<DatosTransporte> createAll()`: Crear datos de transporte para todos los transportes existentes.
    - `void update(Transporte transporte)`: Actualizar datos de transporte a partir de un transporte.
    - `void delete(Long id)`: Eliminar datos de transporte por ID.

### `UsuarioService`

- **Descripción**: Servicio para gestionar usuarios.
- **Métodos**:
    - `List<UsuarioDTO> findAll()`: Obtener todos los usuarios.
    - `UsuarioDTO get(Long id)`: Obtener un usuario por ID.
    - `Long create(UsuarioDTO dto)`: Crear un nuevo usuario y sus credenciales.
    - `void update(Long id, UsuarioDTO dto)`: Actualizar un usuario y sus credenciales.
    - `void delete(Long id)`: Eliminar un usuario y sus credenciales.

## Endpoints

### `TransporteController`

- **Base URL**: `/api/transportes`
- **Endpoints**:
    - `GET /api/transportes`: Obtener todos los transportes.
    - `GET /api/transportes/{id}`: Obtener un transporte por ID.
    - `POST /api/transportes`: Crear un nuevo transporte.
    - `PUT /api/transportes/{id}`: Actualizar un transporte existente.
    - `DELETE /api/transportes/{id}`: Eliminar un transporte por ID.

### `DatosTransporteController`

- **Base URL**: `/api/datos-transporte`
- **Endpoints**:
    - `GET /api/datos-transporte`: Obtener todos los datos de transporte.
    - `GET /api/datos-transporte/{id}`: Obtener datos de transporte por ID.
    - `POST /api/datos-transporte/crear-todos`: Crear datos de transporte para todos los transportes existentes.

### `UsuarioResource`

- **Base URL**: `/api/usuarios`
- **Endpoints**:
    - `GET /api/usuarios`: Obtener todos los usuarios.
    - `GET /api/usuarios/{id}`: Obtener un usuario por ID.
    - `POST /api/usuarios`: Crear un nuevo usuario.
    - `PUT /api/usuarios/{id}`: Actualizar un usuario existente.
    - `DELETE /api/usuarios/{id}`: Eliminar un usuario por ID.