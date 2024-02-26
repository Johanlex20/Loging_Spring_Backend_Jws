CREANDO PRIMERA PARTE BACKEND SPRINGBOOT 3 – SPRINGSECURITY 6  Y JWS	

1.	Crear directorio auth, config, demo, implementando funciones básicas y generando el filtro de seguridad SecurityFilterChain estableciendo los parámetros de acceso a los link.
2.	Crear directorio Jwt, add jwtauthenticationFilter, OncePerRequestFilter,class LoginRequest, RegisterRequest, AuthResponse
3.	ResponseEntity 
4.	implementando en la clase user UserDetails, modificando los metodos a true y creando lista con un unico objeto quesera asignado al role
5.	Creando el servicio y creando el JwtServices, e implementándolo, y moviendo a la carpeta jwt la clase
6.	Add pom las dependencias de jwt, implementando el JwtService, codificando el token
7.	Crear class aplicationConfig, DaoAuthenticationProvider, AuthenticationProvider
8.	Modificando el filtro de seguridad SecurityConfig
