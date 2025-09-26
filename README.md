# Parcial-Corte-1-CVDS-DOSW
David Alejandro Patacon Henao
Grupo 3

## Comaandos para ejecucion:

./mvnw clean compile

./mvnw spring-boot:run

./mvnw test jacoco:report

docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube:latest

./mvnw sonar:sonar -Dsonar.token=sqa_1defed449a392dc3ecb0b374f7510e8998830d2b  

Alternativamente:  

$env:SONAR_TOKEN = 'sqa_1defed449a392dc3ecb0b374f7510e8998830d2b'; ./mvnw sonar:sonar


## Respuestas parte 2  

3. Realice un diagrama de clases que permita entender su solución, adicional mencione que principios SOLID está aplicando, en que componentes y como.  

### Principios SOLID aplicados  

#### **S**s
Cada clase tiene una única responsabilidad:  
- `CreditCardPayment` solo maneja pagos con tarjeta  
- `PayPalPayment` solo maneja pagos con PayPal  
- `CryptoPayment` solo maneja pagos con cripto  
- `InventoryModule` solo maneja inventario  
- `NotificationModule` solo maneja notificaciones  
- `BillingModule` solo maneja facturación  


#### **O**
El sistema está abierto a extensión, cerrado a modificación:  
- Se pueden agregar nuevos métodos de pago implementando `PaymentFactory`.  
- Se pueden agregar nuevos observadores implementando `PaymentObserver`.  


#### **L**
En las jerarquías de herencia:  
- Cualquier `Payment` puede ser sustituido por sus subclases.  
- Cualquier `PaymentObserver` puede ser sustituido por sus implementaciones.  


#### **I**
Aplicado en la interfaz `PaymentObserver`:  
- Es específica y pequeña, con un solo método.  


#### **D**
Aplicado en `EciPayments`:  
- Depende de abstracciones (`PaymentFactory`, `PaymentObserver`).  
- No depende de implementaciones concretas.   

---

4. Identifique los 2 patrones de diseño que se están solicitando a implementar en el caso de estudio, especificando por cada uno:  

#### Patron 1: 
- a. Nombre del Patrón: Factory Pattern
- b. Tipo de Patrón: Creacional
- c. Argumentación del porque se utiliza y como se ve reflejado en el diagrama de clases anterior: Se necesita crear familias de objetos (pago, validador). Cada método de pago requiere su propio validador específico.


#### Patron 2:  
- a. Nombre del Patrón: Observer Pattern
- b. Tipo de Patrón: Comportamiento
- c. Argumentación del porque se utiliza y como se ve reflejado en el diagrama de clases anterior: Múltiples módulos necesitan ser notificados cuando ocurre un pago . Los módulos (inventario, facturación, notificaciones) implementan la interfaz PaymentObserver.

5. Desarrolle a nivel de código su solución, realizando la ejecución de los datos de entrada del enunciado y presentando las respectivas evidencias de sus datos de salida (screenshot).  

Toda la implementacion de la solucion se encuentra en la carpeta util

Datos de entrada:  
<img width="1003" height="293" alt="image" src="https://github.com/user-attachments/assets/edf27cc8-abf1-400c-96ef-9a975370f8d9" />

Datos de salida:  
<img width="482" height="397" alt="image" src="https://github.com/user-attachments/assets/2ebfcb38-a251-4a30-b2e2-5de19c292451" />

7. Ejecute el análisis de cobertura de JACOCO (debe presentar más del 80%
de cobertura)  
![alt text](image-3.png)

8. Ejecute el análisis estático de Sonar Qube y presente en un pantallazo su
evidencia a nivel de implementación.  

![alt text](image-1.png)  
![alt text](image-2.png)
