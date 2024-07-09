CREATE TABLE Usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correoElectronico VARCHAR(180) NOT NULL UNIQUE,
    contrasena VARCHAR(300) NOT NULL,
    perfil_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    constraint fk_Usuarios_perfil_id foreign key(perfil_id) references Perfiles(id)
);
