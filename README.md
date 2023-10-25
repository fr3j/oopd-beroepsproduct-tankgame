### TankGimma Controls

---

**Speler 1 Besturing:**
- **Vooruit:** W
- **Roteer naar Links:** A
- **Achteruit:** S
- **Roteer naar Rechts:** D
- **Schieten:** Spatie
- **Schild Activeren:** Q

**Speler 2 Besturing:**
- **Vooruit:** Pijl-Omhoog (UP)
- **Roteer naar Links:** Pijl-Links (LEFT)
- **Achteruit:** Pijl-Omlaag (DOWN)
- **Roteer naar Rechts:** Pijl-Rechts (RIGHT)
- **Schieten:** Enter
- **Schild Activeren:** Shift

---

**GitHub:**

[Tank Game Repository](https://github.com/fr3j/oopd-beroepsproduct-tankgame)

---

**Bug:** 
Tijdens het ontwikkelen van onze game stuitte ik op een specifiek probleem gerelateerd aan collisions. Deze documentatie biedt inzicht in het geïdentificeerde probleem en de relevante implementatiedetails.

**Probleemomschrijving:** 

1. **Bullet-Wall Collision:**
    - Doel: Wanneer een kogel (bullet) een muur (wall) raakt, moet de collision op een bepaalde manier reageren. Dit werkt, bij codefragment 1 zie je wat het verschil maakt of die wel werkt of niet.
  
2. **TankPlayer-Wall Collision:**
    - Doel: Deze collision moet ervoor zorgen dat de TankPlayer niet door muren kan bewegen. Dit is gerealiseerd in codefragment 2, maar introduceert problemen met de Bullet-Wall collision.

**Implementatiedetails:** 

- Met alleen de `Collided` interface geïmplementeerd in de `Wall` klasse, werkt de collision tussen `Bullet` en `Wall` zoals verwacht. Echter, in deze configuratie kan de speler door muren heen rijden.

- Bij het toevoegen van de `Collider` interface aan de `Wall` klasse, samen met de eerdergenoemde `Collided` interface, werkt de collision tussen TankPlayer en Wall. Echter, in deze configuratie reflecteert de kogel niet wanneer deze de muur raakt.

**Relevante Codefragmenten:**

```java
public class Wall extends SpriteEntity implements Collided, Collider {
// Verdere implementatie van deze klasse
}
```
