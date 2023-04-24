# GeoQuiz

Avsluttende prosjekt fra TISIP fagskole 2023.

Prosjektet er bygget på Java, basisen for prosjektet er å lage en geo quiz ved bruk av et API.

Apiet som er brukt er REST Countries API: https://restcountries.com/

Programmet har en enkel GUI bygd på swing med pålogging og autentisering (ikke noe sikkert, sjekker tilgang i Databasen), med to forskjellige grensesnitt.

Administrator grensesnitt om brukeren har admin tilgang, hvor man har tilgang til å opprette, slette og hente ut registrerte brukere, samt. opprette
(har ikke lagt inn slette) spørsmål.

Brukergrensesnittet går ut på å opprette og bruke spørsmålene som er opprettet i form av en quiz. Når man logger inn som en bruker
blir man bedt om å angi hvor mange spørsmål (størrelsen på quizen), hvor man da blir spurt om forskjellig spørsmål basert på forskjellige land

Eksempler: 
- What capital does Norway have? 
- In what region is France located?
- Whats the population of Portugal?
- In what country do we find the capital Moscow?
