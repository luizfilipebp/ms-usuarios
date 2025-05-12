CREATE TABLE usuario
(
    usu_email        VARCHAR(50) PRIMARY KEY,
    usu_nome         VARCHAR(100) NOT NULL,
    usu_tipo_usuario VARCHAR(20) NOT NULL,
    usu_ativado      BOOLEAN     NOT NULL
);