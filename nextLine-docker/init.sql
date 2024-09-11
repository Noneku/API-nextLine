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
INSERT INTO public.role (id_role, nom_role) VALUES (1, 'ADMIN'), (2, 'STAGIAIRE'), (3, 'FORMATEUR');

-- Table: forme_juridique
INSERT INTO public.forme_juridique (nom_forme_juridique) VALUES ('SARL'), ('SAS'), ('SA'), ('SCI'), ('SNC'), ('EURL'), ('EI'), ('SASU'), ('SCOP'), ('SCA'), ('SCM'), ('GIE');

-- Table: fonction
INSERT INTO public.fonction (nom_fonction) VALUES ('DIRECTEUR');


-- Table: activites
INSERT INTO public.activites (attestation_reglementaire, nom_attestation, visite_medicale, travaux_dangereux, date_declaration_derogee)
VALUES (TRUE, 'Attestation A', TRUE, TRUE, '2023-01-01');

-- Table: jour
INSERT INTO public.jour (nom_jour) VALUES ('Lundi'), ('Mardi'), ('Mercredi'), ('Jeudi'), ('Vendredi');

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

-- Table: définir
INSERT INTO public.definir (id_type_travaux, id_activite)
VALUES (1, 1);