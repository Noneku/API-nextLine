------------------------------------------------------------
--        Script Postgre
------------------------------------------------------------



------------------------------------------------------------
-- Table: role
------------------------------------------------------------
CREATE TABLE public.role(
                            id_role    SERIAL NOT NULL ,
                            nom_role   VARCHAR (20) NOT NULL  ,
                            CONSTRAINT role_PK PRIMARY KEY (id_role)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: utilisateur
------------------------------------------------------------
CREATE TABLE public.utilisateur(
                                   id_utilisateur                  SERIAL NOT NULL ,
                                   nom_utilisateur                 VARCHAR (50) NOT NULL ,
                                   prenom_utilisateur              VARCHAR (50) NOT NULL ,
                                   utilisateur_login               VARCHAR (50) NOT NULL ,
                                   email_utilisateur               VARCHAR (100) NOT NULL ,
                                   mdp_utilisateur                 VARCHAR (250) NOT NULL ,
                                   date_creation                   DATE  NOT NULL ,
                                   isActive                        BOOL  NOT NULL ,
                                   numero_secu_stagiaire           VARCHAR (15)  ,
                                   numero_beneficiaire_stagiaire   VARCHAR (10)  ,
                                   date_naissance                  DATE   ,
                                   id_role                         INT  NOT NULL  ,
                                   CONSTRAINT utilisateur_PK PRIMARY KEY (id_utilisateur)

    ,CONSTRAINT utilisateur_role_FK FOREIGN KEY (id_role) REFERENCES public.role(id_role)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: formation
------------------------------------------------------------
CREATE TABLE public.formation(
                                 id_formation    SERIAL NOT NULL ,
                                 nom_formation   VARCHAR (200) NOT NULL ,
                                 code_grn        VARCHAR (10) NOT NULL  ,
                                 CONSTRAINT formation_PK PRIMARY KEY (id_formation)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: ville
------------------------------------------------------------
CREATE TABLE public.ville(
                             id_ville      SERIAL NOT NULL ,
                             nom_ville     VARCHAR (50) NOT NULL ,
                             code_postal   CHAR (5)  NOT NULL ,
                             code_insee    CHAR (5)  NOT NULL  ,
                             CONSTRAINT ville_PK PRIMARY KEY (id_ville)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: lien_formulaire
------------------------------------------------------------
CREATE TABLE public.lien_formulaire(
                                       id_lien           SERIAL NOT NULL ,
                                       token_lien        VARCHAR (200) NOT NULL ,
                                       date_generation   DATE  NOT NULL ,
                                       statut            BOOL  NOT NULL ,
                                       id_utilisateur    INT  NOT NULL  ,
                                       CONSTRAINT lien_formulaire_PK PRIMARY KEY (id_lien)

    ,CONSTRAINT lien_formulaire_utilisateur_FK FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: forme_juridique
------------------------------------------------------------
CREATE TABLE public.forme_juridique(
                                       id_forme_juridique    SERIAL NOT NULL ,
                                       nom_forme_juridique   VARCHAR (10) NOT NULL  ,
                                       CONSTRAINT forme_juridique_PK PRIMARY KEY (id_forme_juridique)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: session
------------------------------------------------------------
CREATE TABLE public.session(
                               id_session           SERIAL NOT NULL ,
                               date_debut_session   DATE  NOT NULL ,
                               date_fin_session     DATE  NOT NULL ,
                               numero_offre         VARCHAR (10) NOT NULL ,
                               date_debut_stage     DATE  NOT NULL ,
                               date_fin_stage       DATE  NOT NULL ,
                               id_formation         INT  NOT NULL  ,
                               CONSTRAINT session_PK PRIMARY KEY (id_session)

    ,CONSTRAINT session_formation_FK FOREIGN KEY (id_formation) REFERENCES public.formation(id_formation)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: fonction
------------------------------------------------------------
CREATE TABLE public.fonction(
                                id_fonction    SERIAL NOT NULL ,
                                nom_fonction   VARCHAR (50) NOT NULL  ,
                                CONSTRAINT fonction_PK PRIMARY KEY (id_fonction)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: dirigeant
------------------------------------------------------------
CREATE TABLE public.dirigeant(
                                 id_dirigeant       SERIAL NOT NULL ,
                                 nom_dirigeant      VARCHAR (50) NOT NULL ,
                                 prenom_dirigeant   VARCHAR (50) NOT NULL ,
                                 email_dirigeant    VARCHAR (100)  ,
                                 id_fonction        INT  NOT NULL  ,
                                 CONSTRAINT dirigeant_PK PRIMARY KEY (id_dirigeant)

    ,CONSTRAINT dirigeant_fonction_FK FOREIGN KEY (id_fonction) REFERENCES public.fonction(id_fonction)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: assurance
------------------------------------------------------------
CREATE TABLE public.assurance(
                                 id_assurance        SERIAL NOT NULL ,
                                 nom_assurance       VARCHAR (50) NOT NULL ,
                                 numero_societaire   VARCHAR (20) NOT NULL  ,
                                 CONSTRAINT assurance_PK PRIMARY KEY (id_assurance)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: entreprise
------------------------------------------------------------
CREATE TABLE public.entreprise(
                                  id_entreprise          SERIAL NOT NULL ,
                                  raison_sociale         VARCHAR (100) NOT NULL ,
                                  adresse_entreprise     VARCHAR (100) NOT NULL ,
                                  numero_siret           VARCHAR (14) NOT NULL ,
                                  telephone_entreprise   VARCHAR (10) NOT NULL ,
                                  email_entreprise       VARCHAR (50) NOT NULL ,
                                  id_ville               INT  NOT NULL ,
                                  id_forme_juridique     INT  NOT NULL ,
                                  id_dirigeant           INT  NOT NULL ,
                                  id_assurance           INT  NOT NULL  ,
                                  CONSTRAINT entreprise_PK PRIMARY KEY (id_entreprise)

    ,CONSTRAINT entreprise_ville_FK FOREIGN KEY (id_ville) REFERENCES public.ville(id_ville)
    ,CONSTRAINT entreprise_forme_juridique0_FK FOREIGN KEY (id_forme_juridique) REFERENCES public.forme_juridique(id_forme_juridique)
    ,CONSTRAINT entreprise_dirigeant1_FK FOREIGN KEY (id_dirigeant) REFERENCES public.dirigeant(id_dirigeant)
    ,CONSTRAINT entreprise_assurance2_FK FOREIGN KEY (id_assurance) REFERENCES public.assurance(id_assurance)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: tuteur
------------------------------------------------------------
CREATE TABLE public.tuteur(
                              id_tuteur        SERIAL NOT NULL ,
                              nom_tuteur       VARCHAR (50) NOT NULL ,
                              prenom_tuteur    VARCHAR (50) NOT NULL ,
                              email_tuteur     VARCHAR (100) NOT NULL ,
                              tel_tuteur       VARCHAR (10) NOT NULL ,
                              id_entreprise    INT  NOT NULL ,
                              id_fonction      INT  NOT NULL  ,
                              CONSTRAINT tuteur_PK PRIMARY KEY (id_tuteur)

    ,CONSTRAINT tuteur_entreprise_FK FOREIGN KEY (id_entreprise) REFERENCES public.entreprise(id_entreprise)
    ,CONSTRAINT tuteur_fonction0_FK FOREIGN KEY (id_fonction) REFERENCES public.fonction(id_fonction)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: activites
------------------------------------------------------------
CREATE TABLE public.activites(
                                 id_activite                 SERIAL NOT NULL ,
                                 attestation_reglementaire   BOOL  NOT NULL ,
                                 nom_attestation             VARCHAR (100)  ,
                                 visite_medicale             BOOL  NOT NULL ,
                                 travaux_dangereux           BOOL  NOT NULL ,
                                 date_declaration_derogee    DATE    ,
                                 CONSTRAINT activites_PK PRIMARY KEY (id_activite)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: jour
------------------------------------------------------------
CREATE TABLE public.jour(
                            id_jour    SERIAL NOT NULL ,
                            nom_jour   VARCHAR (20) NOT NULL  ,
                            CONSTRAINT jour_PK PRIMARY KEY (id_jour)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: locaux
------------------------------------------------------------
CREATE TABLE public.locaux(
                              id_locaux    SERIAL NOT NULL ,
                              nom_locaux   VARCHAR (100) NOT NULL  ,
                              CONSTRAINT locaux_PK PRIMARY KEY (id_locaux)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: type_travaux_dangereux
------------------------------------------------------------
CREATE TABLE public.type_travaux_dangereux(
                                              id_type_travaux    SERIAL NOT NULL ,
                                              lib_type_travaux   VARCHAR (200) NOT NULL  ,
                                              CONSTRAINT type_travaux_dangereux_PK PRIMARY KEY (id_type_travaux)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: frequence
------------------------------------------------------------
CREATE TABLE public.frequence(
                                 id_frequence    SERIAL NOT NULL ,
                                 nom_frequence   VARCHAR (100) NOT NULL  ,
                                 CONSTRAINT frequence_PK PRIMARY KEY (id_frequence)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: modes_deplacements
------------------------------------------------------------
CREATE TABLE public.modes_deplacements(
                                          id_mode_deplacement   SERIAL NOT NULL ,
                                          nom_deplacement       VARCHAR (150) NOT NULL  ,
                                          CONSTRAINT modes_deplacements_PK PRIMARY KEY (id_mode_deplacement)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: lieu_realisation
------------------------------------------------------------
CREATE TABLE public.lieu_realisation(
                                        id_lieu_realisation      SERIAL NOT NULL ,
                                        deplacements             BOOL  NOT NULL ,
                                        autres_locaux            VARCHAR (100)  ,
                                        autre_frequence          VARCHAR (100)  ,
                                        autre_mode_deplacement   VARCHAR (100)  ,
                                        id_locaux                INT  NOT NULL ,
                                        id_frequence             INT  NOT NULL ,
                                        id_mode_deplacement      INT  NOT NULL  ,
                                        CONSTRAINT lieu_realisation_PK PRIMARY KEY (id_lieu_realisation)

    ,CONSTRAINT lieu_realisation_locaux_FK FOREIGN KEY (id_locaux) REFERENCES public.locaux(id_locaux)
    ,CONSTRAINT lieu_realisation_frequence0_FK FOREIGN KEY (id_frequence) REFERENCES public.frequence(id_frequence)
    ,CONSTRAINT lieu_realisation_modes_deplacements1_FK FOREIGN KEY (id_mode_deplacement) REFERENCES public.modes_deplacements(id_mode_deplacement)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: stage
------------------------------------------------------------
CREATE TABLE public.stage(
                             id_stage                 SERIAL NOT NULL ,
                             modif_date_debut_stage   DATE   ,
                             objectif_stage           VARCHAR (2000)  NOT NULL ,
                             date_validation_stage    DATE   ,
                             id_tuteur                INT  NOT NULL ,
                             id_utilisateur           INT  NOT NULL ,
                             id_entreprise            INT  NOT NULL ,
                             id_session               INT  NOT NULL ,
                             id_lieu_realisation      INT  NOT NULL ,
                             id_activite              INT  NOT NULL  ,
                             CONSTRAINT stage_PK PRIMARY KEY (id_stage)

    ,CONSTRAINT stage_tuteur_FK FOREIGN KEY (id_tuteur) REFERENCES public.tuteur(id_tuteur)
    ,CONSTRAINT stage_utilisateur0_FK FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur)
    ,CONSTRAINT stage_entreprise1_FK FOREIGN KEY (id_entreprise) REFERENCES public.entreprise(id_entreprise)
    ,CONSTRAINT stage_session2_FK FOREIGN KEY (id_session) REFERENCES public.session(id_session)
    ,CONSTRAINT stage_lieu_realisation3_FK FOREIGN KEY (id_lieu_realisation) REFERENCES public.lieu_realisation(id_lieu_realisation)
    ,CONSTRAINT stage_activites4_FK FOREIGN KEY (id_activite) REFERENCES public.activites(id_activite)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: horaires_stage
------------------------------------------------------------
CREATE TABLE public.horaires_stage(
                                      id_horaires_stage       SERIAL NOT NULL ,
                                      heure_debut             TIMETZ  NOT NULL ,
                                      heure_debut_pause_dej   TIMETZ  NOT NULL ,
                                      heure_fin_pause_dej     TIMETZ  NOT NULL ,
                                      heure_fin               TIMETZ  NOT NULL ,
                                      id_stage                INT  NOT NULL ,
                                      id_jour                 INT  NOT NULL  ,
                                      CONSTRAINT horaires_stage_PK PRIMARY KEY (id_horaires_stage)

    ,CONSTRAINT horaires_stage_stage_FK FOREIGN KEY (id_stage) REFERENCES public.stage(id_stage)
    ,CONSTRAINT horaires_stage_jour0_FK FOREIGN KEY (id_jour) REFERENCES public.jour(id_jour)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: document
------------------------------------------------------------
CREATE TABLE public.document(
                                id_document                SERIAL NOT NULL ,
                                nom_pdf                    VARCHAR (150) NOT NULL ,
                                date_generation_document   DATE  NOT NULL ,
                                id_stage                   INT  NOT NULL  ,
                                CONSTRAINT document_PK PRIMARY KEY (id_document)

    ,CONSTRAINT document_stage_FK FOREIGN KEY (id_stage) REFERENCES public.stage(id_stage)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: participer
------------------------------------------------------------
CREATE TABLE public.participer(
                                  id_session       INT  NOT NULL ,
                                  id_utilisateur   INT  NOT NULL  ,
                                  CONSTRAINT participer_PK PRIMARY KEY (id_session,id_utilisateur)

    ,CONSTRAINT participer_session_FK FOREIGN KEY (id_session) REFERENCES public.session(id_session)
    ,CONSTRAINT participer_utilisateur0_FK FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: définir
------------------------------------------------------------
CREATE TABLE public.definir(
                               id_type_travaux   INT  NOT NULL ,
                               id_activite       INT  NOT NULL  ,
                               CONSTRAINT definir_PK PRIMARY KEY (id_type_travaux,id_activite)

    ,CONSTRAINT definir_type_travaux_dangereux_FK FOREIGN KEY (id_type_travaux) REFERENCES public.type_travaux_dangereux(id_type_travaux)
    ,CONSTRAINT definir_activites0_FK FOREIGN KEY (id_activite) REFERENCES public.activites(id_activite)
)WITHOUT OIDS;


------------------------------------------------------------
-- Insérer des données dans les tables
------------------------------------------------------------

-- Table: role
INSERT INTO public.role (id_role, nom_role) VALUES (1, 'Admin'), (2, 'Stagiaire'), (3, 'Formateur');

-- Table: utilisateur
INSERT INTO public.utilisateur (nom_utilisateur, prenom_utilisateur, utilisateur_login, email_utilisateur, mdp_utilisateur, date_creation, isActive, numero_secu_stagiaire, numero_beneficiaire_stagiaire, date_naissance, id_role)
VALUES ('Dupont', 'Jean', 'jdupont', 'j.dupont@example.com', 'mdp123', '2023-01-01', TRUE, '123456789012345', '9876543210', '1990-01-01', 2),
       ('Grey', 'Robert', 'grob34', 'r.grey@gmail.com', 'mdprob34', '2024-02-02', TRUE, '178055945678932', '4524769347', '1978-05-05', 3),
       ('Fretier', 'Clémentine', 'bclem79', 'c.boulanger@gmail.com', 'mdpclem79', '2023-05-05', TRUE, '268045934669821', '5279452747', '1968-04-04', 1),
       ('Messaoui', 'Fatima', 'mfat56', 'f.messaoui@gmail.com', 'mdpfat657', '2023-09-09', TRUE, '292085334862489', '4782395763', '1992-08-08', 2);

-- Table: formation
INSERT INTO public.formation (nom_formation, code_grn) VALUES ('Concepteur développeur applications', 'GRN123'), ('Patissier', 'GRN456'), ('Electricien', 'GRN789');

-- Table: ville
INSERT INTO public.ville (nom_ville, code_postal, code_insee) VALUES ('Lens', '62300', '62498'), ('Lyon', '69000', '69123'), ('Laval', '53000', '53130');

-- Table: lien_formulaire
INSERT INTO public.lien_formulaire (token_lien, date_generation, statut, id_utilisateur)
VALUES ('token123', '2023-01-01', TRUE, 1);

-- Table: forme_juridique
INSERT INTO public.forme_juridique (nom_forme_juridique) VALUES ('SARL'), ('SAS');

-- Table: session
INSERT INTO public.session (date_debut_session, date_fin_session, numero_offre, date_debut_stage, date_fin_stage, id_formation)
VALUES ('2023-02-01', '2023-06-01', 'OFF123', '2023-02-15', '2023-05-30', 1);

-- Table: fonction
INSERT INTO public.fonction (nom_fonction) VALUES ('Directeur'), ('Tuteur');

-- Table: dirigeant
INSERT INTO public.dirigeant (nom_dirigeant, prenom_dirigeant, email_dirigeant, id_fonction)
VALUES ('Martin', 'Paul', 'p.martin@example.com', 1);

-- Table: assurance
INSERT INTO public.assurance (nom_assurance, numero_societaire) VALUES ('Assurance A', 'SOC123');

-- Table: entreprise
INSERT INTO public.entreprise (raison_sociale, adresse_entreprise, numero_siret, telephone_entreprise, email_entreprise, id_ville, id_forme_juridique, id_dirigeant, id_assurance)
VALUES ('Entreprise A', '123 Rue A', '12345678901234', '0123456789', 'contact@entrepriseA.com', 1, 1, 1, 1);

-- Table: tuteur
INSERT INTO public.tuteur (nom_tuteur, prenom_tuteur, email_tuteur, tel_tuteur, id_entreprise, id_fonction)
VALUES ('Bernard', 'Jacques', 'j.bernard@example.com', '0987654321', 1, 2);

-- Table: activites
INSERT INTO public.activites (attestation_reglementaire, nom_attestation, visite_medicale, travaux_dangereux, date_declaration_derogee)
VALUES (TRUE, 'Attestation A', TRUE, TRUE, '2023-01-01');

-- Table: jour
INSERT INTO public.jour (nom_jour) VALUES ('Lundi'), ('Mardi');

-- Table: locaux
INSERT INTO public.locaux (nom_locaux) VALUES ('Locaux Entreprise'), ('Chantier'), ('Locaux clients');

-- Table: type_travaux_dangereux
INSERT INTO public.type_travaux_dangereux (lib_type_travaux) VALUES ('Travail en hauteur'), ('Travail avec produits chimiques');

-- Table: frequence
INSERT INTO public.frequence (nom_frequence) VALUES ('Quotidien'), ('Occasionnels');

-- Table: modes_deplacements
INSERT INTO public.modes_deplacements (nom_deplacement) VALUES ('Voiture'), ('Vélo');

-- Table: lieu_realisation
INSERT INTO public.lieu_realisation (deplacements, autres_locaux, autre_frequence, autre_mode_deplacement, id_locaux, id_frequence, id_mode_deplacement)
VALUES (TRUE, 'Autres locaux A', 'Autre fréquence A', 'Autre déplacement A', 1, 1, 1);

-- Table: stage
INSERT INTO public.stage (modif_date_debut_stage, objectif_stage, date_validation_stage, id_tuteur, id_utilisateur, id_entreprise, id_session, id_lieu_realisation, id_activite)
VALUES ('2023-02-20', 'Objectif A', '2023-02-01', 1, 1, 1, 1, 1, 1);

-- Table: horaires_stage
INSERT INTO public.horaires_stage (heure_debut, heure_debut_pause_dej, heure_fin_pause_dej, heure_fin, id_stage, id_jour)
VALUES ('08:00:00+00', '12:00:00+00', '13:00:00+00', '17:00:00+00', 1, 1);

-- Table: document
INSERT INTO public.document (nom_pdf, date_generation_document, id_stage)
VALUES ('Document A', '2023-02-01', 1);

-- Table: participer
INSERT INTO public.participer (id_session, id_utilisateur)
VALUES (1, 1);

-- Table: définir
INSERT INTO public.definir (id_type_travaux, id_activite)
VALUES (1, 1);