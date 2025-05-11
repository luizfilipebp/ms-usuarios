CREATE TABLE usuario
(
    usu_id           BIGSERIAL PRIMARY KEY,
    usu_nome         VARCHAR(100) NOT NULL,
    usu_email        VARCHAR(50) NOT NULL UNIQUE,
    usu_tipo_usuario VARCHAR(20) NOT NULL,
    usu_ativado      BOOLEAN     NOT NULL
);