# AGENTS.md - payment-api

## Proyecto
API de pagos de Friendly E-Shop. Es un servicio independiente en Java 25 y Spring Boot que posee intentos de pago, notificaciones de proveedores e idempotencia; expone `/payments`.
Persiste únicamente en la base `payments`, usa Flyway, prepara RabbitMQ para eventos y emite telemetría mediante Actuator/OpenTelemetry.

## Comandos
- Ejecutar: `./mvnw spring-boot:run`
- Tests: `./mvnw test`
- Compilar y verificar: `./mvnw verify`
- Lint: `./mvnw checkstyle:check`; también se ejecuta automáticamente en la fase `validate`.

## Estilo y convenciones
- Usa Java 25, Spring Boot 4.1 y el paquete `com.friendlyeshop.payment`.
- Nombres, código y documentación técnica en inglés; mensajes visibles al usuario en español.
- Respeta `checkstyle.xml`: 4 espacios, sin tabs, líneas de hasta 120 caracteres e imports explícitos.
- Mantén controladores delgados y separa contratos del proveedor de la lógica de pagos.
- Crea nuevas migraciones Flyway; no edites migraciones ya aplicadas. Hibernate solo valida el esquema.

## Reglas
- Lee la spec activa, si existe, antes de tocar código.
- Para implementar usa solo `/spring-boot-project-creator` en su opción Layered y `/clean-code-guard`.
- La opción Layered organiza el paquete `com.friendlyeshop.payment` en `controller/`, `service/`, `repository/`, `model/`, `model/dto/`, `config/` y `exception/`.
- Usa `/spring-boot-layered-template` como complemento de la opción Layered cuando una clase no encaje claramente en las carpetas básicas o al decidir si corresponde crear paquetes como `client/`, `http/`, `auth/`, `security/`, `messaging/`, `event/`, `mapper/` o `validation/`.
- No uses la opción DDD de esa skill ni regeneres el proyecto con Spring Initializr al modificar este servicio.
- Este servicio es la fuente de verdad de intentos, referencias del proveedor e idempotencia, no del pedido.
- Toda creación o notificación repetible debe preservar la unicidad de `idempotency_key` y ser segura ante reintentos.
- Nunca escribas tablas de pedidos; comunica resultados mediante contratos o eventos definidos.
- Mercado Pago está diferido: no añadas su SDK, webhooks ni credenciales sin una spec aprobada.
- Conserva `/payments`, variables de entorno, health checks, métricas y RabbitMQ; no añadas Kafka.
- No omitas ni desactives reglas de Checkstyle para evitar corregir una violación.
- Los manifiestos y secretos pertenecen a `infra`; coordina allí cambios de puerto, ruta o configuración.

## Al terminar cualquier tarea
- Tras cambios no triviales de código de producción, aplica `/clean-code-guard` antes de finalizar.
- Ejecuta `./mvnw verify`; incluye Checkstyle y los tests.
- Prueba idempotencia, reintentos y transiciones afectadas; añade migraciones para cambios de esquema.
- Comprueba que no se hayan roto `/payments` ni los endpoints de Actuator.
