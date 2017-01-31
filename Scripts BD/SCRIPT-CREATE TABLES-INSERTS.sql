-- Table: public.cargo

-- DROP TABLE public.cargo;

CREATE TABLE public.cargo
(
    codcargo integer NOT NULL,
    nome character(50) NOT NULL,
    CONSTRAINT codcargo_pkey PRIMARY KEY (codcargo)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cargo
    OWNER to postgres;
    
INSERT INTO cargo VALUES (1,'Dono_Da_Empresa'),(2,'Gerente_Da_Loja'),(3,'Vendedor');


-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
    codigo integer NOT NULL DEFAULT nextval('codigo_seq_usuario'::regclass),
    nome character varying(50) NOT NULL,
    login character varying(10) NOT NULL,
    senha character varying(20) NOT NULL,
    codcargo integer NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (codigo),
    CONSTRAINT usuario_codcargo_fkey FOREIGN KEY (codcargo)
        REFERENCES public.cargo (codcargo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;
    

-- Table: public.tamanho

-- DROP TABLE public.tamanho;

CREATE TABLE public.tamanho
(
    codtamanho integer NOT NULL,
    nome character varying(3),
    CONSTRAINT tamanho_pkey PRIMARY KEY (codtamanho)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tamanho
    OWNER to postgres;
    
INSERT INTO tamanho VALUES (1,'PP'),(2,'P'),(3,'M'),(4,'G'),(5,'GG');


-- Table: public.camiseta

-- DROP TABLE public.camiseta;

CREATE TABLE public.camiseta
(
    codigo integer NOT NULL DEFAULT nextval('codigo_seq'::regclass),
    nome character(50) NOT NULL,
    hashtag character(100) NOT NULL,
    precocusto real NOT NULL,
    precovenda real NOT NULL,
    qm integer,
    quantidade integer,
    codtamanho integer,
    CONSTRAINT camiseta_pkey PRIMARY KEY (codigo),
    CONSTRAINT camiseta_codtamanho_fkey FOREIGN KEY (codtamanho)
        REFERENCES public.tamanho (codtamanho) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.camiseta
    OWNER to postgres;
    

-- Table: public.tipopagamento

-- DROP TABLE public.tipopagamento;

CREATE TABLE public.tipopagamento
(
    codigo integer NOT NULL,
    nome character(50) NOT NULL,
    CONSTRAINT tipopagamento_pkey PRIMARY KEY (codigo)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tipopagamento
    OWNER to postgres;

INSERT INTO tipopagamento VALUES (1,'DinheiroAVista'),(2,'CartaoDebitoAVista'),(3,'CartaoCreditoAVista');


-- Table: public.pedido

-- DROP TABLE public.pedido;

CREATE TABLE public.pedido
(
    codigo integer NOT NULL DEFAULT nextval('codigo_seq_pedido'::regclass),
    data date NOT NULL,
    desconto real NOT NULL,
    tipopagamento integer,
    usuario integer NOT NULL,
    datacancelamento date,
    CONSTRAINT pedido_pkey PRIMARY KEY (codigo),
    CONSTRAINT pedido_tipopagamento_fkey FOREIGN KEY (tipopagamento)
        REFERENCES public.tipopagamento (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT pedido_usuario_fkey FOREIGN KEY (usuario)
        REFERENCES public.usuario (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pedido
    OWNER to postgres;
    
    
-- Table: public.itempedido

-- DROP TABLE public.itempedido;

CREATE TABLE public.itempedido
(
    codigo integer NOT NULL DEFAULT nextval('codigo_seq_item'::regclass),
    camiseta integer NOT NULL,
    quantidade integer NOT NULL,
    valortotal real NOT NULL,
    pedido integer NOT NULL,
    CONSTRAINT itempedido_pkey PRIMARY KEY (codigo),
    CONSTRAINT itempedido_camiseta_fkey FOREIGN KEY (camiseta)
        REFERENCES public.camiseta (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT itempedido_pedido_fkey FOREIGN KEY (pedido)
        REFERENCES public.pedido (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.itempedido
    OWNER to postgres;

	
insert into usuario (nome, login, senha, codcargo) values ('teste' , 'teste' , 'teste', 1);