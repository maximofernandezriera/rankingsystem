# Explicación del kata ranking system
https://www.codewars.com/kata/51fda2d95d6efda45e00004e/java

### Clase Usuario

La clase `Usuario` representa a un usuario dentro de un sistema de ranking similar a Codewars.

Tiene dos atributos privados:
- `rank`: El rango actual del usuario (va de -8 a 8, saltando el 0).
- `progress`: El progreso actual del usuario hacia el siguiente rango (valor de 0 a 99).

#### Constructor

El constructor inicializa el rango a -8 y el progreso a 0.

#### Métodos Getters

- `getRank()`: Devuelve el rank actual del usuario.
- `getProgress()`: Devuelve el progreso actual del usuario.

#### Método calculateProgress

Este método calcula el progreso obtenido al completar una actividad con el rango dado `activityRank`.

- Valida que el rango de la actividad sea válido (-8 a 8, sin 0).
- No se gana progreso si se alcanza el rango máximo (8).
- Calcula la diferencia de rango (`rankDiff`) entre el usuario y la actividad, ajustando por el salto de -1 a 1.
- Establece diferentes ganancias de progreso según la diferencia de rango:
  - Mismo rango: 3 puntos
  - 1 rango menos: 1 punto
  - 2 o más rangos menos: 0 puntos
  - Mayor rango: 10 * (diferencia de rango)^2

#### Método incProgress

Este método actualiza el progreso del usuario al completar una actividad con el rango dado `activityRank`.

- Llama al método `calculateProgress` para obtener los puntos ganados.
- Suma los puntos ganados al progreso actual.
- Mientras el progreso supere 100:
  - Reduce el progreso en 100.
  - Si el rango es negativo y el siguiente sería 0, lo salta y sube directamente a 1.
  - Si el rango es menor a 8, lo sube de nivel.
  - Si se alcanza el rango máximo (8), reinicia el progreso a 0.

