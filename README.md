# CAHIER DES CHARGES - NEXTLINE

## La description détaillée du besoin :
### Le ou les objectif(s) de l'application web :
Permettre aux stagiaires, formateurs et entreprises de remplir de manière rapide et efficace la fiche de renseignement Entreprise dans le cadre d’une période de stage en entreprise.  
Celle-ci sera numérisée et à remplir en ligne, afin de pouvoir également ultérieurement accéder aux données des entreprises disponibles à prendre des futurs stagiaires. 

### Le public cible et les besoins des utilisateurs :
#### Cible : 
Les stagiaires, le centre de formation et les entreprises : facilité d’accès, de complétion et de transmission de la fiche de renseignement.

#### Besoins :
- Dématérialiser la fiche de renseignement Entreprise.
- Pré-complétion des informations pour le stagiaire.
- Envoi d’un lien pour permettre à l’entreprise de remplir sa partie de la fiche de renseignement.
- Les données et coordonnées des entreprises sont enregistrées en BDD pour faciliter les recherches de stages des futurs stagiaires.

## Les fonctionnalités à implémenter :

### En tant que stagiaire : 
- Avoir accès à son compte personnel et se connecter à l’aide de ses identifiants (à déterminer).
- Modifier ses informations personnelles si besoin.
- Générer la fiche de renseignement pré-complétée avec ses informations et la télécharger.
- Envoyer automatiquement la fiche de renseignement en renseignant une adresse e-mail destinataire.

### En tant que formateur : 
- Créer le compte de ses stagiaires en remplissant les informations personnelles de base (nom, prénom, matricule, numéro bénéficiaire, infos sur la formation et la période de stage).
- Réception des fiches de renseignement de ses stagiaires remplies par l’entreprise et pouvoir les signer.
- Être informé des stagiaires ayant envoyé la fiche de renseignement à une entreprise (avec adresse e-mail d’envoi et date).
- Pouvoir rechercher les entreprises enregistrées en BDD ayant déjà pris des stagiaires.

### En tant qu’entreprise : 
- Accéder à la fiche de renseignement pré-remplie avec les informations du stagiaire (informations sensibles censurées) à partir d’un lien reçu (mail automatique pré-rempli).
- Formulaire en mode “Step by step” / Wizard Form.
- Question demandant si l’entreprise est déjà enregistrée en BDD.
- Si l’entreprise a déjà été enregistrée en BDD, renseigner son numéro SIRET : vérification des informations enregistrées en BDD à partir du numéro de SIRET et récupération et complétion des informations de l’entreprise.
- Lors du renseignement des horaires de stage, vérification de l’amplitude minimum de 30h et max de 35h / semaine et 10h / jour max.
- Signature et émission du cachet d’entreprise : Open eSignForms / E-Signature Java SDK by DSS (DSS GitHub) / Signer.Digital / A voir si cachet absolument nécessaire ou si signature seule ok.
- Visuel de la fiche de renseignement pour vérification avant envoi et possibilité de modification en cas d’erreur.
- Une fois validée, la fiche est envoyée sur le compte du formateur pour validation.

### En tant qu’admin : 
- Créer le compte des formateurs en remplissant les informations personnelles de base (nom, prénom, infos sur la formation et la période de stage).
- Pouvoir assigner et modifier les rôles.

## La charte graphique :

### Logo :
- Logo de l’afpa.
- Logo personnalisé.

### Police :
- Police du site AFPA.

### Code couleur :
- Vert : #87bb34
- Bleu : #00a0e0
- Violet : #e3007e

## Notes diverses : 
- jquery pad : utiliser pour effectuer les signatures.
