## Spring Boot JWT API - Authentification Sécurisée

Ce projet est une API REST développée avec Spring Boot 3 et Spring Security. Elle implémente une authentification complète basée sur les tokens JWT (JSON Web Token) et une connexion à une base de données MySQL.


## Technologies utilisées
 
Java 17

Spring Boot 3.x

Spring Security (JWT Authentication)

Spring Data JPA & Hibernate

MySQL Database

Postman 


## Architecture de Sécurité (Filtre JWT)
Le cœur de ce projet repose sur un Filtre de Sécurité personnalisé. Voici le flux d'une requête :

Interception : Chaque requête arrivant sur le serveur est interceptée par le JwtAuthorizationFilter.

Extraction : Le filtre cherche le header Authorization et extrait le texte après "Bearer ".

Validation : Le token est vérifié par la clé secrète. Si le token est expiré ou modifié, l'accès est refusé (403).

Authentification : Si le token est valide, l'utilisateur est injecté dans le SecurityContextHolder de Spring, permettant l'accès aux routes privées (200 OK).


## Démonstration des Tests 
1. Authentification et Génération du Token
Lorsqu'un utilisateur valide ses identifiants, le serveur génère un token JWT unique. Ce token est nécessaire pour accéder aux ressources protégées.
<img width="760" height="900" alt="Screenshot 2026-03-24 192946" src="https://github.com/user-attachments/assets/c56e23bd-5413-482d-b1b6-6fb4e9b5e140" />
<img width="752" height="819" alt="Screenshot 2026-03-24 193156" src="https://github.com/user-attachments/assets/94e68dcf-f3e9-4bb9-85ad-b129fc49df36" />

2. Accès aux Routes Protégées (200 OK)
Une fois le token obtenu, il doit être envoyé dans le header Authorization en tant que Bearer Token. Voici la preuve que le filtre de sécurité valide le token et autorise l'accès aux données :
<img width="1184" height="827" alt="Screenshot 2026-03-25 024916" src="https://github.com/user-attachments/assets/48b77876-9dde-44c3-a32f-c068e109cf5c" />
<img width="745" height="865" alt="Screenshot 2026-03-25 025708" src="https://github.com/user-attachments/assets/92a38f17-a148-49f0-a608-4d914ef7dfe1" />


## Architecture du projet 

<img width="573" height="922" alt="Screenshot 2026-03-25 031203" src="https://github.com/user-attachments/assets/d44275c4-e0f4-4d99-9b50-ac51d57425e6" />

<img width="572" height="787" alt="Screenshot 2026-03-25 031221" src="https://github.com/user-attachments/assets/a56f6736-aa0e-4621-affc-b297b444be5a" />


## Installation de la Sécurité

Le projet utilise un JwtAuthorizationFilter personnalisé qui intercepte chaque requête pour vérifier la signature du token avant d'accorder l'accès au contexte de sécurité de Spring.
