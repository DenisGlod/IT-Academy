--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-02-10 18:16:20

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

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 16436)
-- Name: book; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.book (
    id integer NOT NULL,
    name character varying NOT NULL,
    author character varying NOT NULL,
    publisher character varying NOT NULL,
    binding character varying NOT NULL,
    age_restrictions character varying NOT NULL,
    isbn character varying NOT NULL,
    description character varying,
    publishing_year smallint NOT NULL
);


--
-- TOC entry 204 (class 1259 OID 16434)
-- Name: book_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 204
-- Name: book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;


--
-- TOC entry 207 (class 1259 OID 16451)
-- Name: bookmarks; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.bookmarks (
    id integer NOT NULL,
    user_id integer NOT NULL,
    book_id integer NOT NULL
);


--
-- TOC entry 206 (class 1259 OID 16445)
-- Name: bookmarks_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.bookmarks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 206
-- Name: bookmarks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.bookmarks_id_seq OWNED BY public.bookmarks.id;


--
-- TOC entry 209 (class 1259 OID 16498)
-- Name: role; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.role (
    id integer NOT NULL,
    name character varying NOT NULL
);


--
-- TOC entry 208 (class 1259 OID 16496)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 208
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 201 (class 1259 OID 16408)
-- Name: user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    email character varying(30) NOT NULL,
    password character varying(20) NOT NULL,
    role_id integer NOT NULL,
    user_data_id integer
);


--
-- TOC entry 203 (class 1259 OID 16416)
-- Name: user_data; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_data (
    id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    middle_name character varying(30),
    age date
);


--
-- TOC entry 202 (class 1259 OID 16414)
-- Name: user_data_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.user_data_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 202
-- Name: user_data_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.user_data_id_seq OWNED BY public.user_data.id;


--
-- TOC entry 200 (class 1259 OID 16406)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 200
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- TOC entry 2882 (class 2604 OID 16439)
-- Name: book id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.book ALTER COLUMN id SET DEFAULT nextval('public.book_id_seq'::regclass);


--
-- TOC entry 2883 (class 2604 OID 16454)
-- Name: bookmarks id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bookmarks ALTER COLUMN id SET DEFAULT nextval('public.bookmarks_id_seq'::regclass);


--
-- TOC entry 2884 (class 2604 OID 16501)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 2880 (class 2604 OID 16411)
-- Name: user id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- TOC entry 2881 (class 2604 OID 16419)
-- Name: user_data id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_data ALTER COLUMN id SET DEFAULT nextval('public.user_data_id_seq'::regclass);


--
-- TOC entry 3038 (class 0 OID 16436)
-- Dependencies: 205
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.book VALUES (1, '1984', 'Джордж Оруэлл', 'АСТ', 'Твердый переплет', '16+', '978-5-17-103595-2', 'Своеобразный антипод второй великой антиутопии XX века - "О дивный новый мир" Олдоса Хаксли. Что, в сущности, страшнее: доведенное до абсурда "общество потребления" - или доведенное до абсолюта "общество идеи"?

По Оруэллу, нет и не может быть ничего ужаснее тотальной несвободы...', 2019);
INSERT INTO public.book VALUES (2, 'Краткие ответы на большие вопросы', 'Стивен Хокинг', 'Эксмо', 'Твердый переплет', '16+', '978-5-04-099443-4', 'Стивен Хокинг, величайший ученый современности, изменил наш мир. Его уход - огромная потеря для человечества. В своей финальной книге, над которой Стивен Хокинг работал практически до самого конца, великий физик делится с нами своим отношением к жизни, цивилизации, времени, Богу, к глобальным вещам, волнующим каждого из нас.

Перед вами книга-сенсация, книга-завещание, последний труд всемирно известного физика Стивена Хокинга, в которой он подводит некий итог и высказывается по самым главным вопросам, волнующим всех.

Выживет ли человечество? Должны ли мы так активно внедряться в космос? Есть ли Бог? Это лишь некоторые из вопросов, на которые отвечает Стивен Хокинг, один из величайших умов в истории, в своей финальной книге.

В книгу включены воспоминания оскароносца Эдди Редмэйна, игравшего Стивена Хокинга, Нобелевского лауреата Кипа Торна и дочери Хокинга, Люси.', 2019);


--
-- TOC entry 3040 (class 0 OID 16451)
-- Dependencies: 207
-- Data for Name: bookmarks; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3042 (class 0 OID 16498)
-- Dependencies: 209
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.role VALUES (1, 'Администратор');
INSERT INTO public.role VALUES (2, 'Модератор');
INSERT INTO public.role VALUES (3, 'Пользователь');


--
-- TOC entry 3034 (class 0 OID 16408)
-- Dependencies: 201
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public."user" VALUES (4, 'moderator1@freebook.test', 'moderator1', 2, NULL);
INSERT INTO public."user" VALUES (5, 'moderator2@freebook.test', 'moderator2', 2, NULL);
INSERT INTO public."user" VALUES (6, 'user3@freebook.test', 'user3', 3, NULL);
INSERT INTO public."user" VALUES (1, 'admin@freebook.test', 'admin', 1, 1);
INSERT INTO public."user" VALUES (3, 'user2@freebook.test', 'user2', 3, 2);
INSERT INTO public."user" VALUES (2, 'user1@freebook.test', 'user1', 3, 3);


--
-- TOC entry 3036 (class 0 OID 16416)
-- Dependencies: 203
-- Data for Name: user_data; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.user_data VALUES (1, 'Виктор', 'Петров', 'Валентинович', '1999-01-03');
INSERT INTO public.user_data VALUES (2, 'Николай', 'Кузнецов', 'Николаевич', '1998-03-09');
INSERT INTO public.user_data VALUES (3, 'Андрей', 'Шеремет', 'Витальевич', '2021-02-06');


--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 204
-- Name: book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.book_id_seq', 3, true);


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 206
-- Name: bookmarks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.bookmarks_id_seq', 1, false);


--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 208
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.role_id_seq', 3, true);


--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 202
-- Name: user_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.user_data_id_seq', 6, true);


--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 200
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.user_id_seq', 6, true);


--
-- TOC entry 2894 (class 2606 OID 16444)
-- Name: book book_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pk PRIMARY KEY (id);


--
-- TOC entry 2896 (class 2606 OID 16458)
-- Name: bookmarks bookmarks_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bookmarks
    ADD CONSTRAINT bookmarks_pk PRIMARY KEY (id);


--
-- TOC entry 2898 (class 2606 OID 16506)
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- TOC entry 2892 (class 2606 OID 16421)
-- Name: user_data user_data_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_data
    ADD CONSTRAINT user_data_pk PRIMARY KEY (id);


--
-- TOC entry 2886 (class 2606 OID 16413)
-- Name: user user_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- TOC entry 2888 (class 2606 OID 16592)
-- Name: user user_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_un UNIQUE (id);


--
-- TOC entry 2890 (class 2606 OID 16594)
-- Name: user user_un_1; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_un_1 UNIQUE (user_data_id);


--
-- TOC entry 2902 (class 2606 OID 16558)
-- Name: bookmarks bookmarks_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bookmarks
    ADD CONSTRAINT bookmarks_fk FOREIGN KEY (book_id) REFERENCES public.book(id) ON DELETE CASCADE;


--
-- TOC entry 2901 (class 2606 OID 16552)
-- Name: bookmarks bookmarks_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bookmarks
    ADD CONSTRAINT bookmarks_fk_1 FOREIGN KEY (user_id) REFERENCES public."user"(id) ON DELETE CASCADE;


--
-- TOC entry 2899 (class 2606 OID 16576)
-- Name: user user_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_fk FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2900 (class 2606 OID 16586)
-- Name: user user_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_fk_1 FOREIGN KEY (user_data_id) REFERENCES public.user_data(id) ON DELETE CASCADE;


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT USAGE ON SCHEMA public TO "user";


--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE book; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON TABLE public.book TO "user" WITH GRANT OPTION;


--
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 204
-- Name: SEQUENCE book_id_seq; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON SEQUENCE public.book_id_seq TO "user" WITH GRANT OPTION;


--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 207
-- Name: TABLE bookmarks; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON TABLE public.bookmarks TO "user" WITH GRANT OPTION;


--
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 206
-- Name: SEQUENCE bookmarks_id_seq; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON SEQUENCE public.bookmarks_id_seq TO "user" WITH GRANT OPTION;


--
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE role; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON TABLE public.role TO "user" WITH GRANT OPTION;


--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 208
-- Name: SEQUENCE role_id_seq; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON SEQUENCE public.role_id_seq TO "user" WITH GRANT OPTION;


--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE "user"; Type: ACL; Schema: public; Owner: -
--

REVOKE ALL ON TABLE public."user" FROM postgres;
GRANT ALL ON TABLE public."user" TO "user" WITH GRANT OPTION;


--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE user_data; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON TABLE public.user_data TO "user" WITH GRANT OPTION;


--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 202
-- Name: SEQUENCE user_data_id_seq; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON SEQUENCE public.user_data_id_seq TO "user" WITH GRANT OPTION;


--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 200
-- Name: SEQUENCE user_id_seq; Type: ACL; Schema: public; Owner: -
--

GRANT ALL ON SEQUENCE public.user_id_seq TO "user" WITH GRANT OPTION;


-- Completed on 2021-02-10 18:16:20

--
-- PostgreSQL database dump complete
--

