--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.2
-- Dumped by pg_dump version 9.4.0
-- Started on 2015-06-18 20:57:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 184 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 184
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16445)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente (
    id_cliente integer NOT NULL,
    nome character varying(255) NOT NULL,
    telefone character varying(11) NOT NULL,
    rua character varying(255) NOT NULL,
    numero integer,
    complemento character varying(50),
    bairro character varying(255),
    cidade character varying(255)
);


ALTER TABLE cliente OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16443)
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliente_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 172
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cliente_id_cliente_seq OWNED BY cliente.id_cliente;


--
-- TOC entry 182 (class 1259 OID 16519)
-- Name: contatos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE contatos (
    id integer NOT NULL,
    nome character varying(255) DEFAULT NULL::character varying,
    email character varying(255) DEFAULT NULL::character varying,
    endereco character varying(255) DEFAULT NULL::character varying,
    datanascimento date
);


ALTER TABLE contatos OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16517)
-- Name: contatos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE contatos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE contatos_id_seq OWNER TO postgres;

--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 181
-- Name: contatos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE contatos_id_seq OWNED BY contatos.id;


--
-- TOC entry 177 (class 1259 OID 16466)
-- Name: item_pedido; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE item_pedido (
    id_item_pedido integer NOT NULL,
    id_pedido integer NOT NULL,
    id_cliente integer NOT NULL,
    forma integer,
    area double precision,
    medida double precision,
    valor double precision
);


ALTER TABLE item_pedido OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16464)
-- Name: item_pedido_id_item_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE item_pedido_id_item_pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE item_pedido_id_item_pedido_seq OWNER TO postgres;

--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 176
-- Name: item_pedido_id_item_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE item_pedido_id_item_pedido_seq OWNED BY item_pedido.id_item_pedido;


--
-- TOC entry 183 (class 1259 OID 24659)
-- Name: item_sabores; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE item_sabores (
    id_sabor_pizza integer NOT NULL,
    id_item_pedido integer NOT NULL,
    id_pedido integer NOT NULL,
    id_cliente integer NOT NULL
);


ALTER TABLE item_sabores OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16458)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pedido (
    id_pedido integer NOT NULL,
    id_cliente integer NOT NULL,
    status integer,
    data timestamp without time zone,
    valor double precision
);


ALTER TABLE pedido OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16456)
-- Name: pedido_id_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pedido_id_pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pedido_id_pedido_seq OWNER TO postgres;

--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 174
-- Name: pedido_id_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pedido_id_pedido_seq OWNED BY pedido.id_pedido;


--
-- TOC entry 180 (class 1259 OID 16479)
-- Name: sabor_pizza; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sabor_pizza (
    id_sabor_pizza integer NOT NULL,
    nome character varying(50),
    ingredientes text,
    id_tipo integer NOT NULL
);


ALTER TABLE sabor_pizza OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16477)
-- Name: sabor_pizza_id_sabor_pizza_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sabor_pizza_id_sabor_pizza_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sabor_pizza_id_sabor_pizza_seq OWNER TO postgres;

--
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 179
-- Name: sabor_pizza_id_sabor_pizza_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sabor_pizza_id_sabor_pizza_seq OWNED BY sabor_pizza.id_sabor_pizza;


--
-- TOC entry 178 (class 1259 OID 16472)
-- Name: tipo_pizza; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_pizza (
    id_tipo integer NOT NULL,
    nome character varying(50),
    valor_cm double precision
);


ALTER TABLE tipo_pizza OWNER TO postgres;

--
-- TOC entry 1916 (class 2604 OID 16448)
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_id_cliente_seq'::regclass);


--
-- TOC entry 1920 (class 2604 OID 16522)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contatos ALTER COLUMN id SET DEFAULT nextval('contatos_id_seq'::regclass);


--
-- TOC entry 1918 (class 2604 OID 16469)
-- Name: id_item_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_pedido ALTER COLUMN id_item_pedido SET DEFAULT nextval('item_pedido_id_item_pedido_seq'::regclass);


--
-- TOC entry 1917 (class 2604 OID 16461)
-- Name: id_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido ALTER COLUMN id_pedido SET DEFAULT nextval('pedido_id_pedido_seq'::regclass);


--
-- TOC entry 1919 (class 2604 OID 16482)
-- Name: id_sabor_pizza; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sabor_pizza ALTER COLUMN id_sabor_pizza SET DEFAULT nextval('sabor_pizza_id_sabor_pizza_seq'::regclass);


--
-- TOC entry 2053 (class 0 OID 16445)
-- Dependencies: 173
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (id_cliente, nome, telefone, rua, numero, complemento, bairro, cidade) FROM stdin;
2	Guilherme Cercal	4188188483	General Lucas	93	casa	Vila Tarumã	Pinhais
5	Bruno teste	41727277272	marechal balbalabla	44	casa	centro	cwb
\.


--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 172
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_id_cliente_seq', 5, true);


--
-- TOC entry 2062 (class 0 OID 16519)
-- Dependencies: 182
-- Data for Name: contatos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY contatos (id, nome, email, endereco, datanascimento) FROM stdin;
\.


--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 181
-- Name: contatos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('contatos_id_seq', 33, true);


--
-- TOC entry 2057 (class 0 OID 16466)
-- Dependencies: 177
-- Data for Name: item_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY item_pedido (id_item_pedido, id_pedido, id_cliente, forma, area, medida, valor) FROM stdin;
\.


--
-- TOC entry 2079 (class 0 OID 0)
-- Dependencies: 176
-- Name: item_pedido_id_item_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('item_pedido_id_item_pedido_seq', 1, false);


--
-- TOC entry 2063 (class 0 OID 24659)
-- Dependencies: 183
-- Data for Name: item_sabores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY item_sabores (id_sabor_pizza, id_item_pedido, id_pedido, id_cliente) FROM stdin;
\.


--
-- TOC entry 2055 (class 0 OID 16458)
-- Dependencies: 175
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pedido (id_pedido, id_cliente, status, data, valor) FROM stdin;
\.


--
-- TOC entry 2080 (class 0 OID 0)
-- Dependencies: 174
-- Name: pedido_id_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pedido_id_pedido_seq', 1, false);


--
-- TOC entry 2060 (class 0 OID 16479)
-- Dependencies: 180
-- Data for Name: sabor_pizza; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sabor_pizza (id_sabor_pizza, nome, ingredientes, id_tipo) FROM stdin;
\.


--
-- TOC entry 2081 (class 0 OID 0)
-- Dependencies: 179
-- Name: sabor_pizza_id_sabor_pizza_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sabor_pizza_id_sabor_pizza_seq', 1, false);


--
-- TOC entry 2058 (class 0 OID 16472)
-- Dependencies: 178
-- Data for Name: tipo_pizza; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_pizza (id_tipo, nome, valor_cm) FROM stdin;
1	Simples	0.5
2	Especial	0.75
3	Premium	1
\.


--
-- TOC entry 1925 (class 2606 OID 16453)
-- Name: cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 1927 (class 2606 OID 16455)
-- Name: cliente_telefone_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_telefone_key UNIQUE (telefone);


--
-- TOC entry 1937 (class 2606 OID 16530)
-- Name: contatos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY contatos
    ADD CONSTRAINT contatos_pkey PRIMARY KEY (id);


--
-- TOC entry 1931 (class 2606 OID 16471)
-- Name: item_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT item_pedido_pkey PRIMARY KEY (id_item_pedido, id_pedido, id_cliente);


--
-- TOC entry 1929 (class 2606 OID 16463)
-- Name: pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido, id_cliente);


--
-- TOC entry 1935 (class 2606 OID 16487)
-- Name: sabor_pizza_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sabor_pizza
    ADD CONSTRAINT sabor_pizza_pkey PRIMARY KEY (id_sabor_pizza);


--
-- TOC entry 1933 (class 2606 OID 16476)
-- Name: tipo_pizza_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_pizza
    ADD CONSTRAINT tipo_pizza_pkey PRIMARY KEY (id_tipo);


--
-- TOC entry 1939 (class 2606 OID 16496)
-- Name: item_pedido_id_pedido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT item_pedido_id_pedido_fkey FOREIGN KEY (id_pedido, id_cliente) REFERENCES pedido(id_pedido, id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1941 (class 2606 OID 24662)
-- Name: item_sabores_id_item_pedido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_sabores
    ADD CONSTRAINT item_sabores_id_item_pedido_fkey FOREIGN KEY (id_item_pedido, id_pedido, id_cliente) REFERENCES item_pedido(id_item_pedido, id_pedido, id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1942 (class 2606 OID 24667)
-- Name: item_sabores_id_sabor_pizza_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_sabores
    ADD CONSTRAINT item_sabores_id_sabor_pizza_fkey FOREIGN KEY (id_sabor_pizza) REFERENCES sabor_pizza(id_sabor_pizza) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1938 (class 2606 OID 16491)
-- Name: pedido_id_cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1940 (class 2606 OID 16506)
-- Name: sabor_pizza_id_tipo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sabor_pizza
    ADD CONSTRAINT sabor_pizza_id_tipo_fkey FOREIGN KEY (id_tipo) REFERENCES tipo_pizza(id_tipo) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-06-18 20:57:48

--
-- PostgreSQL database dump complete
--

