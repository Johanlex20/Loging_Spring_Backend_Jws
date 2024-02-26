CREANDO PRIMERA PARTE BACKEND SPRINGBOOT 3 – SPRINGSECURITY 6  Y JWS	

1. Application.properties crear la configuracion base de datos, Crear el diseño en la base de datos.

2. Crear paquete Auth | Crear clase AuthController. -- Creamos paquete Demo | Crear clase DemoController -- Crear paquete Config | Crear clase SegurityConfig.

3. Realizar pruebas POSTMAN probando los Url Private y Public.

4. Crear paquete Jwt | Crear Clase JwtAutentticationFilter -- Implementar el metodo doFilterInternal -- Implementar el Metodo getTokenFromRequest.

5. Crear Class | LoginRequest | RegisterRequest | AuthResponse |

6. Implentamos los Metodos con ResponseEntity.

7. Crear Servicio AuthService | Agregar Metodo Login - Register | Implementar el metodo Register.

8. Crear paquete User| crear class | Role | user | UserRepository |-- user implementar UserDetails. 

9. Crear Clase JwtService | Implementar Metodo getToken -- Cambiamos la ubicacion de la carpeta a JWT

10. Agregar dependencias (api, impl, jackson) JWT en el archivo pom.xml

11. Implementar la clase JwtService | getToken | getKey | Decoders.BASE64 | hmacShaKeyFor |

12. En Config | Crear class ApplicationConfig | crear metodo AuthenticationManager | DaoAuthenticationProvider()

13. En SecurityConfig agregamso la implentacion session Management para la autenticacion.

14. Realizar pruebas POSTMAN probando los Url Private y Public.

15. En AuthService Implementar Metodo Login | 

16. Realizar pruebas POSTMAN probando los Url Private y Public.

17. En JwtAuthenticationFilter Acceder username del Token, fortalezer el filtro.

18. Implementar en JwtServices los metodos  getUsernameFromToken() y isTokenValid() | Crear Metodo Claims 

19. Realizar pruebas POSTMAN probando los Url Private y Public.
