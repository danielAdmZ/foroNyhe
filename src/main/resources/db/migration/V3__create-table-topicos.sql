CREATE TABLE Topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(180) NOT NULL,
    fecha datetime NOT NULL ,
    status tinyint NOT NULL,
    usuario_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    constraint fk_Topicos_usuario_id foreign key(usuario_id) references Usuarios(id)
);
