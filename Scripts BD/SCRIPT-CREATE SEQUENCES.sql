CREATE SEQUENCE public.codigo_seq
    INCREMENT 1
    START 18
    MINVALUE 1
    MAXVALUE 100000
    CACHE 1;

ALTER SEQUENCE public.codigo_seq
    OWNER TO postgres;
	

CREATE SEQUENCE public.codigo_seq_item
    INCREMENT 1
    START 32
    MINVALUE 1
    MAXVALUE 100000
    CACHE 1;

ALTER SEQUENCE public.codigo_seq_item
    OWNER TO postgres;
	
CREATE SEQUENCE public.codigo_seq_pedido
    INCREMENT 1
    START 24
    MINVALUE 1
    MAXVALUE 100000
    CACHE 1;

ALTER SEQUENCE public.codigo_seq_pedido
    OWNER TO postgres;
	
	
CREATE SEQUENCE public.codigo_seq_usuario
    INCREMENT 1
    START 16
    MINVALUE 1
    MAXVALUE 100000
    CACHE 1;

ALTER SEQUENCE public.codigo_seq_usuario
    OWNER TO postgres;