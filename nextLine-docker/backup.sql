--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    id_admin integer NOT NULL,
    nom_admin character varying(50) NOT NULL,
    prenom_admin character varying(50) NOT NULL,
    email_admin character varying(150) NOT NULL,
    mdp_admin character varying(100) NOT NULL,
    date_creation date NOT NULL,
    ip_inscription character varying(50) NOT NULL,
    navigateur character varying(500) NOT NULL,
    id_role_utilisateur integer NOT NULL
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- Name: admin_id_admin_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.admin_id_admin_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.admin_id_admin_seq OWNER TO postgres;

--
-- Name: admin_id_admin_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.admin_id_admin_seq OWNED BY public.admin.id_admin;


--
-- Name: categorie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorie (
    id_categorie integer NOT NULL,
    niveau_categorie integer NOT NULL,
    prix_ttc numeric(15,3) NOT NULL,
    id_type_plat integer NOT NULL
);


ALTER TABLE public.categorie OWNER TO postgres;

--
-- Name: categorie_id_categorie_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorie_id_categorie_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categorie_id_categorie_seq OWNER TO postgres;

--
-- Name: categorie_id_categorie_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categorie_id_categorie_seq OWNED BY public.categorie.id_categorie;


--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id_client integer NOT NULL,
    num_beneficiare character varying(25) NOT NULL,
    code_pin character(4) NOT NULL,
    email_client character varying(255),
    mobile_client character varying(20),
    is_active boolean NOT NULL,
    id_role_utilisateur integer NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: client_id_client_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_id_client_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.client_id_client_seq OWNER TO postgres;

--
-- Name: client_id_client_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_id_client_seq OWNED BY public.client.id_client;


--
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id_commentaire integer NOT NULL,
    note integer NOT NULL,
    message character varying(500),
    suggestion character varying(500),
    id_client integer NOT NULL,
    id_menu integer NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- Name: commentaire_id_commentaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_commentaire_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.commentaire_id_commentaire_seq OWNER TO postgres;

--
-- Name: commentaire_id_commentaire_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_commentaire_seq OWNED BY public.commentaire.id_commentaire;


--
-- Name: composition; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.composition (
    id_composition integer NOT NULL,
    "position" integer NOT NULL,
    id_menu integer NOT NULL,
    id_document integer NOT NULL
);


ALTER TABLE public.composition OWNER TO postgres;

--
-- Name: composition_id_composition_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.composition_id_composition_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.composition_id_composition_seq OWNER TO postgres;

--
-- Name: composition_id_composition_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.composition_id_composition_seq OWNED BY public.composition.id_composition;


--
-- Name: couleur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.couleur (
    id_couleur integer NOT NULL,
    lib_couleur character varying(255) NOT NULL,
    code_couleur character varying(255) NOT NULL,
    id_type_plat integer NOT NULL
);


ALTER TABLE public.couleur OWNER TO postgres;

--
-- Name: couleur_id_couleur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.couleur_id_couleur_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.couleur_id_couleur_seq OWNER TO postgres;

--
-- Name: couleur_id_couleur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.couleur_id_couleur_seq OWNED BY public.couleur.id_couleur;


--
-- Name: document; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.document (
    id_document integer NOT NULL,
    nom_pdf character varying(500) NOT NULL,
    description_document character varying(2000),
    is_permanant boolean NOT NULL,
    id_theme integer NOT NULL
);


ALTER TABLE public.document OWNER TO postgres;

--
-- Name: document_id_document_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.document_id_document_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.document_id_document_seq OWNER TO postgres;

--
-- Name: document_id_document_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.document_id_document_seq OWNED BY public.document.id_document;


--
-- Name: element_graphique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.element_graphique (
    id_element_graphique integer NOT NULL,
    lib_element_graphique character varying(255) NOT NULL,
    url_element_graphique character varying(255) NOT NULL,
    id_type_element integer NOT NULL
);


ALTER TABLE public.element_graphique OWNER TO postgres;

--
-- Name: element_graphique_id_element_graphique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.element_graphique_id_element_graphique_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.element_graphique_id_element_graphique_seq OWNER TO postgres;

--
-- Name: element_graphique_id_element_graphique_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.element_graphique_id_element_graphique_seq OWNED BY public.element_graphique.id_element_graphique;


--
-- Name: entreprise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entreprise (
    id_entreprise integer NOT NULL,
    raison_sociale character varying(100) NOT NULL,
    adresse character varying(255) NOT NULL,
    comp_adresse character varying(255),
    email character varying(255) NOT NULL,
    telephone character varying(16) NOT NULL,
    logo character varying(255) NOT NULL,
    id_ville integer NOT NULL
);


ALTER TABLE public.entreprise OWNER TO postgres;

--
-- Name: entreprise_id_entreprise_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.entreprise_id_entreprise_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.entreprise_id_entreprise_seq OWNER TO postgres;

--
-- Name: entreprise_id_entreprise_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.entreprise_id_entreprise_seq OWNED BY public.entreprise.id_entreprise;


--
-- Name: labelliser; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.labelliser (
    id_logo_qualite integer NOT NULL,
    id_plat integer NOT NULL
);


ALTER TABLE public.labelliser OWNER TO postgres;

--
-- Name: logo_qualite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.logo_qualite (
    id_logo_qualite integer NOT NULL,
    lib_logo_qualite character varying(255) NOT NULL,
    url_logo_quatlite character varying(255) NOT NULL
);


ALTER TABLE public.logo_qualite OWNER TO postgres;

--
-- Name: logo_qualite_id_logo_qualite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.logo_qualite_id_logo_qualite_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.logo_qualite_id_logo_qualite_seq OWNER TO postgres;

--
-- Name: logo_qualite_id_logo_qualite_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.logo_qualite_id_logo_qualite_seq OWNED BY public.logo_qualite.id_logo_qualite;


--
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu (
    id_menu integer NOT NULL,
    num_semaine character(2) NOT NULL,
    titre_menu character varying(100),
    date_creation_menu date NOT NULL,
    is_favoris boolean,
    url_excel character varying(50) NOT NULL,
    id_admin integer NOT NULL
);


ALTER TABLE public.menu OWNER TO postgres;

--
-- Name: menu_id_menu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.menu_id_menu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.menu_id_menu_seq OWNER TO postgres;

--
-- Name: menu_id_menu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.menu_id_menu_seq OWNED BY public.menu.id_menu;


--
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    id_message integer NOT NULL,
    lib_message character varying(2000) NOT NULL,
    id_admin integer NOT NULL,
    id_menu integer NOT NULL
);


ALTER TABLE public.message OWNER TO postgres;

--
-- Name: message_id_message_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.message_id_message_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.message_id_message_seq OWNER TO postgres;

--
-- Name: message_id_message_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.message_id_message_seq OWNED BY public.message.id_message;


--
-- Name: parametres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parametres (
    id_parametres integer NOT NULL,
    heure_rappel time with time zone NOT NULL
);


ALTER TABLE public.parametres OWNER TO postgres;

--
-- Name: parametres_id_parametres_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.parametres_id_parametres_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.parametres_id_parametres_seq OWNER TO postgres;

--
-- Name: parametres_id_parametres_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.parametres_id_parametres_seq OWNED BY public.parametres.id_parametres;


--
-- Name: plat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plat (
    id_plat integer NOT NULL,
    date_plat date NOT NULL,
    lib_plat character varying(255) NOT NULL,
    id_menu integer NOT NULL,
    id_categorie integer NOT NULL
);


ALTER TABLE public.plat OWNER TO postgres;

--
-- Name: plat_id_plat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.plat_id_plat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.plat_id_plat_seq OWNER TO postgres;

--
-- Name: plat_id_plat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.plat_id_plat_seq OWNED BY public.plat.id_plat;


--
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id_reservation integer NOT NULL,
    date_enregistrement date NOT NULL,
    id_client integer NOT NULL
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- Name: reservation_id_reservation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_reservation_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.reservation_id_reservation_seq OWNER TO postgres;

--
-- Name: reservation_id_reservation_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_id_reservation_seq OWNED BY public.reservation.id_reservation;


--
-- Name: role_utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_utilisateur (
    id_role_utilisateur integer NOT NULL,
    lib_role_utilisateur character varying(255) NOT NULL,
    code_role_utilisateur character varying(255) NOT NULL
);


ALTER TABLE public.role_utilisateur OWNER TO postgres;

--
-- Name: role_utilisateur_id_role_utilisateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_utilisateur_id_role_utilisateur_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.role_utilisateur_id_role_utilisateur_seq OWNER TO postgres;

--
-- Name: role_utilisateur_id_role_utilisateur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_utilisateur_id_role_utilisateur_seq OWNED BY public.role_utilisateur.id_role_utilisateur;


--
-- Name: style; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.style (
    id_style integer NOT NULL,
    id_menu integer NOT NULL,
    id_element_graphique integer NOT NULL
);


ALTER TABLE public.style OWNER TO postgres;

--
-- Name: style_id_style_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.style_id_style_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.style_id_style_seq OWNER TO postgres;

--
-- Name: style_id_style_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.style_id_style_seq OWNED BY public.style.id_style;


--
-- Name: theme; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.theme (
    id_theme integer NOT NULL,
    lib_theme character varying(100) NOT NULL
);


ALTER TABLE public.theme OWNER TO postgres;

--
-- Name: theme_id_theme_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.theme_id_theme_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.theme_id_theme_seq OWNER TO postgres;

--
-- Name: theme_id_theme_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.theme_id_theme_seq OWNED BY public.theme.id_theme;


--
-- Name: travailler; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.travailler (
    id_entreprise integer NOT NULL,
    id_admin integer NOT NULL
);


ALTER TABLE public.travailler OWNER TO postgres;

--
-- Name: type_element; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_element (
    id_type_element integer NOT NULL,
    lib_type_element character varying(255) NOT NULL
);


ALTER TABLE public.type_element OWNER TO postgres;

--
-- Name: type_element_id_type_element_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_element_id_type_element_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.type_element_id_type_element_seq OWNER TO postgres;

--
-- Name: type_element_id_type_element_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_element_id_type_element_seq OWNED BY public.type_element.id_type_element;


--
-- Name: type_plat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_plat (
    id_type_plat integer NOT NULL,
    lib_type_plat character varying(255) NOT NULL
);


ALTER TABLE public.type_plat OWNER TO postgres;

--
-- Name: type_plat_id_type_plat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_plat_id_type_plat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.type_plat_id_type_plat_seq OWNER TO postgres;

--
-- Name: type_plat_id_type_plat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_plat_id_type_plat_seq OWNED BY public.type_plat.id_type_plat;


--
-- Name: ville; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ville (
    id_ville integer NOT NULL,
    nom_ville character varying(100) NOT NULL,
    slug_ville character varying(100) NOT NULL,
    code_insee character(5) NOT NULL,
    code_postal character(5) NOT NULL,
    lat_ville double precision NOT NULL,
    long_ville double precision NOT NULL
);


ALTER TABLE public.ville OWNER TO postgres;

--
-- Name: admin id_admin; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin ALTER COLUMN id_admin SET DEFAULT nextval('public.admin_id_admin_seq'::regclass);


--
-- Name: categorie id_categorie; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie ALTER COLUMN id_categorie SET DEFAULT nextval('public.categorie_id_categorie_seq'::regclass);


--
-- Name: client id_client; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN id_client SET DEFAULT nextval('public.client_id_client_seq'::regclass);


--
-- Name: commentaire id_commentaire; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id_commentaire SET DEFAULT nextval('public.commentaire_id_commentaire_seq'::regclass);


--
-- Name: composition id_composition; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.composition ALTER COLUMN id_composition SET DEFAULT nextval('public.composition_id_composition_seq'::regclass);


--
-- Name: couleur id_couleur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.couleur ALTER COLUMN id_couleur SET DEFAULT nextval('public.couleur_id_couleur_seq'::regclass);


--
-- Name: document id_document; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.document ALTER COLUMN id_document SET DEFAULT nextval('public.document_id_document_seq'::regclass);


--
-- Name: element_graphique id_element_graphique; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.element_graphique ALTER COLUMN id_element_graphique SET DEFAULT nextval('public.element_graphique_id_element_graphique_seq'::regclass);


--
-- Name: entreprise id_entreprise; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entreprise ALTER COLUMN id_entreprise SET DEFAULT nextval('public.entreprise_id_entreprise_seq'::regclass);


--
-- Name: logo_qualite id_logo_qualite; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.logo_qualite ALTER COLUMN id_logo_qualite SET DEFAULT nextval('public.logo_qualite_id_logo_qualite_seq'::regclass);


--
-- Name: menu id_menu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu ALTER COLUMN id_menu SET DEFAULT nextval('public.menu_id_menu_seq'::regclass);


--
-- Name: message id_message; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message ALTER COLUMN id_message SET DEFAULT nextval('public.message_id_message_seq'::regclass);


--
-- Name: parametres id_parametres; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parametres ALTER COLUMN id_parametres SET DEFAULT nextval('public.parametres_id_parametres_seq'::regclass);


--
-- Name: plat id_plat; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plat ALTER COLUMN id_plat SET DEFAULT nextval('public.plat_id_plat_seq'::regclass);


--
-- Name: reservation id_reservation; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN id_reservation SET DEFAULT nextval('public.reservation_id_reservation_seq'::regclass);


--
-- Name: role_utilisateur id_role_utilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_utilisateur ALTER COLUMN id_role_utilisateur SET DEFAULT nextval('public.role_utilisateur_id_role_utilisateur_seq'::regclass);


--
-- Name: style id_style; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.style ALTER COLUMN id_style SET DEFAULT nextval('public.style_id_style_seq'::regclass);


--
-- Name: theme id_theme; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.theme ALTER COLUMN id_theme SET DEFAULT nextval('public.theme_id_theme_seq'::regclass);


--
-- Name: type_element id_type_element; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_element ALTER COLUMN id_type_element SET DEFAULT nextval('public.type_element_id_type_element_seq'::regclass);


--
-- Name: type_plat id_type_plat; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_plat ALTER COLUMN id_type_plat SET DEFAULT nextval('public.type_plat_id_type_plat_seq'::regclass);


--
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (id_admin, nom_admin, prenom_admin, email_admin, mdp_admin, date_creation, ip_inscription, navigateur, id_role_utilisateur) FROM stdin;
1	Admin A	Prenom A	adminA@example.com	passwordA	2024-04-23	127.0.0.1	Chrome	1
2	Admin B	Prenom B	adminB@example.com	passwordB	2024-04-23	127.0.0.2	Firefox	2
\.


--
-- Data for Name: categorie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categorie (id_categorie, niveau_categorie, prix_ttc, id_type_plat) FROM stdin;
3	1	10.000	0
4	2	20.000	1
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id_client, num_beneficiare, code_pin, email_client, mobile_client, is_active, id_role_utilisateur) FROM stdin;
1	Benef 1	1234	client1@example.com	0123456789	t	1
2	Benef 2	5678	client2@example.com	9876543210	t	2
3	Benef 1	1234	client1@example.com	0123456789	t	1
4	Benef 2	5678	client2@example.com	9876543210	t	2
\.


--
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id_commentaire, note, message, suggestion, id_client, id_menu) FROM stdin;
1	5	Bon plat	Plus de l├®gumes	1	1
2	4	Tr├¿s bon	RAS	2	2
3	5	Bon plat	Plus de l├®gumes	1	1
4	4	Tr├¿s bon	RAS	2	2
\.


--
-- Data for Name: composition; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.composition (id_composition, "position", id_menu, id_document) FROM stdin;
0	1	1	3
1	2	2	4
\.


--
-- Data for Name: couleur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.couleur (id_couleur, lib_couleur, code_couleur, id_type_plat) FROM stdin;
6	Couleur 1	#FFFFFF	0
7	Couleur 2	#000000	1
\.


--
-- Data for Name: document; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.document (id_document, nom_pdf, description_document, is_permanant, id_theme) FROM stdin;
3	Document 1.pdf	Description du document 1	t	0
4	Document 2.pdf	Description du document 2	f	1
\.


--
-- Data for Name: element_graphique; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.element_graphique (id_element_graphique, lib_element_graphique, url_element_graphique, id_type_element) FROM stdin;
1	Element 1	url_element1.png	1
2	Element 2	url_element2.png	2
\.


--
-- Data for Name: entreprise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.entreprise (id_entreprise, raison_sociale, adresse, comp_adresse, email, telephone, logo, id_ville) FROM stdin;
9	Entreprise A	Adresse A	\N	emailA@example.com	0123456789	logoA.png	1
10	Entreprise B	Adresse B	\N	emailB@example.com	9876543210	logoB.png	2
\.


--
-- Data for Name: labelliser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.labelliser (id_logo_qualite, id_plat) FROM stdin;
9	5
10	6
\.


--
-- Data for Name: logo_qualite; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.logo_qualite (id_logo_qualite, lib_logo_qualite, url_logo_quatlite) FROM stdin;
9	Logo 1	url_logo1.png
10	Logo 2	url_logo2.png
\.


--
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.menu (id_menu, num_semaine, titre_menu, date_creation_menu, is_favoris, url_excel, id_admin) FROM stdin;
1	01	Menu 1	2024-04-23	t	excel1.xlsx	1
2	02	Menu 2	2024-04-23	f	excel2.xlsx	2
\.


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.message (id_message, lib_message, id_admin, id_menu) FROM stdin;
3	Message 1	1	1
4	Message 2	2	2
\.


--
-- Data for Name: parametres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parametres (id_parametres, heure_rappel) FROM stdin;
9	10:00:00+02
10	15:00:00+02
\.


--
-- Data for Name: plat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.plat (id_plat, date_plat, lib_plat, id_menu, id_categorie) FROM stdin;
5	2024-04-23	Plat 1	1	3
6	2024-04-24	Plat 2	2	4
\.


--
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id_reservation, date_enregistrement, id_client) FROM stdin;
1	2024-04-23	1
2	2024-04-24	2
3	2024-04-23	1
4	2024-04-24	2
\.


--
-- Data for Name: role_utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role_utilisateur (id_role_utilisateur, lib_role_utilisateur, code_role_utilisateur) FROM stdin;
1	Role 1	ROLE1
2	Role 2	ROLE2
3	Role 1	ROLE1
4	Role 2	ROLE2
\.


--
-- Data for Name: style; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.style (id_style, id_menu, id_element_graphique) FROM stdin;
1	1	1
2	2	2
\.


--
-- Data for Name: theme; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.theme (id_theme, lib_theme) FROM stdin;
0	Theme 1
1	Theme 2
\.


--
-- Data for Name: travailler; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.travailler (id_entreprise, id_admin) FROM stdin;
9	1
10	2
\.


--
-- Data for Name: type_element; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type_element (id_type_element, lib_type_element) FROM stdin;
1	Type Element 1
2	Type Element 2
\.


--
-- Data for Name: type_plat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type_plat (id_type_plat, lib_type_plat) FROM stdin;
0	Type Plat 1
1	Type Plat 2
\.


--
-- Data for Name: ville; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ville (id_ville, nom_ville, slug_ville, code_insee, code_postal, lat_ville, long_ville) FROM stdin;
1	Paris	paris	75000	75000	48.8566	2.3522
2	Lyon	lyon	69000	69000	45.764	4.8357
\.


--
-- Name: admin_id_admin_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admin_id_admin_seq', 2, true);


--
-- Name: categorie_id_categorie_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categorie_id_categorie_seq', 4, true);


--
-- Name: client_id_client_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_id_client_seq', 4, true);


--
-- Name: commentaire_id_commentaire_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_commentaire_seq', 4, true);


--
-- Name: composition_id_composition_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.composition_id_composition_seq', 2, true);


--
-- Name: couleur_id_couleur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.couleur_id_couleur_seq', 7, true);


--
-- Name: document_id_document_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.document_id_document_seq', 4, true);


--
-- Name: element_graphique_id_element_graphique_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.element_graphique_id_element_graphique_seq', 2, true);


--
-- Name: entreprise_id_entreprise_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.entreprise_id_entreprise_seq', 10, true);


--
-- Name: logo_qualite_id_logo_qualite_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.logo_qualite_id_logo_qualite_seq', 10, true);


--
-- Name: menu_id_menu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.menu_id_menu_seq', 2, true);


--
-- Name: message_id_message_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.message_id_message_seq', 4, true);


--
-- Name: parametres_id_parametres_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.parametres_id_parametres_seq', 10, true);


--
-- Name: plat_id_plat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.plat_id_plat_seq', 6, true);


--
-- Name: reservation_id_reservation_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_reservation_seq', 4, true);


--
-- Name: role_utilisateur_id_role_utilisateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_utilisateur_id_role_utilisateur_seq', 4, true);


--
-- Name: style_id_style_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.style_id_style_seq', 2, true);


--
-- Name: theme_id_theme_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.theme_id_theme_seq', 8, true);


--
-- Name: type_element_id_type_element_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_element_id_type_element_seq', 2, true);


--
-- Name: type_plat_id_type_plat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_plat_id_type_plat_seq', 1, false);


--
-- Name: admin admin_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pk PRIMARY KEY (id_admin);


--
-- Name: categorie categorie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie
    ADD CONSTRAINT categorie_pk PRIMARY KEY (id_categorie);


--
-- Name: client client_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pk PRIMARY KEY (id_client);


--
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (id_commentaire);


--
-- Name: composition composition_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.composition
    ADD CONSTRAINT composition_pk PRIMARY KEY (id_composition);


--
-- Name: couleur couleur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.couleur
    ADD CONSTRAINT couleur_pk PRIMARY KEY (id_couleur);


--
-- Name: document document_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.document
    ADD CONSTRAINT document_pk PRIMARY KEY (id_document);


--
-- Name: element_graphique element_graphique_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.element_graphique
    ADD CONSTRAINT element_graphique_pk PRIMARY KEY (id_element_graphique);


--
-- Name: entreprise entreprise_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entreprise
    ADD CONSTRAINT entreprise_pk PRIMARY KEY (id_entreprise);


--
-- Name: labelliser labelliser_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.labelliser
    ADD CONSTRAINT labelliser_pk PRIMARY KEY (id_logo_qualite, id_plat);


--
-- Name: logo_qualite logo_qualite_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.logo_qualite
    ADD CONSTRAINT logo_qualite_pk PRIMARY KEY (id_logo_qualite);


--
-- Name: menu menu_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pk PRIMARY KEY (id_menu);


--
-- Name: message message_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pk PRIMARY KEY (id_message);


--
-- Name: parametres parametres_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parametres
    ADD CONSTRAINT parametres_pk PRIMARY KEY (id_parametres);


--
-- Name: plat plat_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plat
    ADD CONSTRAINT plat_pk PRIMARY KEY (id_plat);


--
-- Name: reservation reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pk PRIMARY KEY (id_reservation);


--
-- Name: role_utilisateur role_utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_utilisateur
    ADD CONSTRAINT role_utilisateur_pk PRIMARY KEY (id_role_utilisateur);


--
-- Name: style style_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.style
    ADD CONSTRAINT style_pk PRIMARY KEY (id_style);


--
-- Name: theme theme_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.theme
    ADD CONSTRAINT theme_pk PRIMARY KEY (id_theme);


--
-- Name: travailler travailler_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.travailler
    ADD CONSTRAINT travailler_pk PRIMARY KEY (id_entreprise, id_admin);


--
-- Name: type_element type_element_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_element
    ADD CONSTRAINT type_element_pk PRIMARY KEY (id_type_element);


--
-- Name: type_plat type_plat_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_plat
    ADD CONSTRAINT type_plat_pk PRIMARY KEY (id_type_plat);


--
-- Name: ville ville_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT ville_pk PRIMARY KEY (id_ville);


--
-- Name: admin admin_role_utilisateur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_role_utilisateur_fk FOREIGN KEY (id_role_utilisateur) REFERENCES public.role_utilisateur(id_role_utilisateur);


--
-- Name: categorie categorie_type_plat_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie
    ADD CONSTRAINT categorie_type_plat_fk FOREIGN KEY (id_type_plat) REFERENCES public.type_plat(id_type_plat);


--
-- Name: client client_role_utilisateur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_role_utilisateur_fk FOREIGN KEY (id_role_utilisateur) REFERENCES public.role_utilisateur(id_role_utilisateur);


--
-- Name: commentaire commentaire_client_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_client_fk FOREIGN KEY (id_client) REFERENCES public.client(id_client);


--
-- Name: commentaire commentaire_menu0_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_menu0_fk FOREIGN KEY (id_menu) REFERENCES public.menu(id_menu);


--
-- Name: composition composition_document0_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.composition
    ADD CONSTRAINT composition_document0_fk FOREIGN KEY (id_document) REFERENCES public.document(id_document);


--
-- Name: composition composition_menu_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.composition
    ADD CONSTRAINT composition_menu_fk FOREIGN KEY (id_menu) REFERENCES public.menu(id_menu);


--
-- Name: couleur couleur_type_plat_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.couleur
    ADD CONSTRAINT couleur_type_plat_fk FOREIGN KEY (id_type_plat) REFERENCES public.type_plat(id_type_plat);


--
-- Name: document document_theme_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.document
    ADD CONSTRAINT document_theme_fk FOREIGN KEY (id_theme) REFERENCES public.theme(id_theme);


--
-- Name: element_graphique element_graphique_type_element_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.element_graphique
    ADD CONSTRAINT element_graphique_type_element_fk FOREIGN KEY (id_type_element) REFERENCES public.type_element(id_type_element);


--
-- Name: entreprise entreprise_ville_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entreprise
    ADD CONSTRAINT entreprise_ville_fk FOREIGN KEY (id_ville) REFERENCES public.ville(id_ville);


--
-- Name: labelliser labelliser_logo_qualite_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.labelliser
    ADD CONSTRAINT labelliser_logo_qualite_fk FOREIGN KEY (id_logo_qualite) REFERENCES public.logo_qualite(id_logo_qualite);


--
-- Name: labelliser labelliser_plat0_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.labelliser
    ADD CONSTRAINT labelliser_plat0_fk FOREIGN KEY (id_plat) REFERENCES public.plat(id_plat);


--
-- Name: menu menu_admin_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_admin_fk FOREIGN KEY (id_admin) REFERENCES public.admin(id_admin);


--
-- Name: message message_admin_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_admin_fk FOREIGN KEY (id_admin) REFERENCES public.admin(id_admin);


--
-- Name: message message_menu0_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_menu0_fk FOREIGN KEY (id_menu) REFERENCES public.menu(id_menu);


--
-- Name: plat plat_categorie0_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plat
    ADD CONSTRAINT plat_categorie0_fk FOREIGN KEY (id_categorie) REFERENCES public.categorie(id_categorie);


--
-- Name: plat plat_menu_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plat
    ADD CONSTRAINT plat_menu_fk FOREIGN KEY (id_menu) REFERENCES public.menu(id_menu);


--
-- Name: reservation reservation_client_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_client_fk FOREIGN KEY (id_client) REFERENCES public.client(id_client);


--
-- Name: style style_element_graphique0_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.style
    ADD CONSTRAINT style_element_graphique0_fk FOREIGN KEY (id_element_graphique) REFERENCES public.element_graphique(id_element_graphique);


--
-- Name: style style_menu_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.style
    ADD CONSTRAINT style_menu_fk FOREIGN KEY (id_menu) REFERENCES public.menu(id_menu);


--
-- Name: travailler travailler_admin0_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.travailler
    ADD CONSTRAINT travailler_admin0_fk FOREIGN KEY (id_admin) REFERENCES public.admin(id_admin);


--
-- Name: travailler travailler_entreprise_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.travailler
    ADD CONSTRAINT travailler_entreprise_fk FOREIGN KEY (id_entreprise) REFERENCES public.entreprise(id_entreprise);


--
-- PostgreSQL database dump complete
--

