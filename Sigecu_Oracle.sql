CREATE TABLE hr.instructor (
  idinstructor INT NOT NULL,
  iNombre VARCHAR(45) NOT NULL,
  iPaterno VARCHAR(45) NULL,
  iMaterno VARCHAR(45) NULL,
  Carrera VARCHAR(45) NULL,
  Especialidad VARCHAR(45) NULL,
  iEmail VARCHAR(45) NULL,
  iTelefono VARCHAR(45) NULL,
  iDireccion VARCHAR(45) NULL,
  PRIMARY KEY (idinstructor)
);


-- -----------------------------------------------------
-- Table hr.cursos
-- -----------------------------------------------------
CREATE TABLE hr.cursos (
  idcursos INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  horario VARCHAR(45) NULL,
  fechaInicio VARCHAR(45) NULL,
  fechaFin VARCHAR(45) NULL,
  tipo VARCHAR(45) NOT NULL,
  i_idinstructor INT NOT NULL,
  PRIMARY KEY (idcursos),
  CONSTRAINT fk_cursos_instructor1
    FOREIGN KEY (i_idinstructor)
    REFERENCES hr.instructor (idinstructor)
  );


-- -----------------------------------------------------
-- Table hr.evaluaciones
-- -----------------------------------------------------
CREATE TABLE hr.evaluaciones (
  idevaluacion INT NOT NULL,
  c_idcursos INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  idAlumno INT NOT NULL,
  fechaInicio DATE NOT NULL,
  fechaFin DATE NOT NULL,
  tiempo VARCHAR(30) NOT NULL,
  PRIMARY KEY (idevaluacion),
  CONSTRAINT fk_evaluaciones_cursos1
    FOREIGN KEY (c_idcursos)
    REFERENCES hr.cursos (idcursos)
  );


-- -----------------------------------------------------
-- Table hr.preguntas
-- -----------------------------------------------------
CREATE TABLE hr.preguntas (
  idpregunta INT NOT NULL,
  e_idevaluacion INT NOT NULL,
  idEvaluacion INT NOT NULL,
  Pregunta VARCHAR(45) NOT NULL,
  PRIMARY KEY (idpregunta),
  CONSTRAINT fk_preguntas_evaluaciones1
    FOREIGN KEY (e_idevaluacion)
    REFERENCES hr.evaluaciones (idevaluacion)
  );


-- -----------------------------------------------------
-- Table hr.Respuestas
-- -----------------------------------------------------
CREATE TABLE hr.Respuestas (
  idRespuesta INT NOT NULL,
  p_idpregunta INT NOT NULL,
  Respuesta VARCHAR(45) NOT NULL,
  Solucion VARCHAR(45) NOT NULL,
  Puntaje VARCHAR(45) NOT NULL,
  PRIMARY KEY (idRespuesta),
  CONSTRAINT fk_Respuestas_preguntas1
    FOREIGN KEY (p_idpregunta)
    REFERENCES hr.preguntas (idpregunta)
  );


-- -----------------------------------------------------
-- Table hr.templetes
-- -----------------------------------------------------
CREATE TABLE hr.templetes (
  idtempletes INT NOT NULL,
  descripcion VARCHAR(150) NULL,
  imagen VARCHAR(45) NULL,
  PRIMARY KEY (idtempletes)
);


-- -----------------------------------------------------
-- Table hr.pais
-- -----------------------------------------------------
CREATE TABLE hr.pais (
  idPais INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  region VARCHAR(45) NULL,
  PRIMARY KEY (idPais)
);


-- -----------------------------------------------------
-- Table hr.ciudad
-- -----------------------------------------------------
CREATE TABLE hr.ciudad (
  idCiudad INT NOT NULL,
  nombre VARCHAR(45) NULL,
  p_idPais INT NOT NULL,
  PRIMARY KEY (idCiudad),
  CONSTRAINT fk_ciudad_pais1
    FOREIGN KEY (p_idPais)
    REFERENCES hr.pais (idPais)
  );


-- -----------------------------------------------------
-- Table hr.promociones
-- -----------------------------------------------------
CREATE TABLE hr.promociones (
  idpromociones INT NOT NULL,
  tipo VARCHAR(45) NULL,
  PRIMARY KEY (idpromociones)
);


-- -----------------------------------------------------
-- Table hr.eventos
-- -----------------------------------------------------
CREATE TABLE hr.eventos (
  idevento INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  fechaInicio DATE NULL,
  descripcion VARCHAR(45) NULL,
  programa VARCHAR(45) NULL,
  i_idinstructor INT NOT NULL,
  lugar VARCHAR(45) NULL,
  c_idCiudad INT NOT NULL,
  capacidad VARCHAR(45) NOT NULL,
  tipo VARCHAR(45) NULL,
  estatus VARCHAR(45) NULL,
  costo VARCHAR(45) NULL,
  t_idtempletes INT NOT NULL,
  p_idpromociones INT NOT NULL,
  PRIMARY KEY (idevento),
  CONSTRAINT fk_eventos_instructor1
    FOREIGN KEY (i_idinstructor)
    REFERENCES hr.instructor (idinstructor),
  CONSTRAINT fk_eventos_templetes1
    FOREIGN KEY (t_idtempletes)
    REFERENCES hr.templetes (idtempletes),
  CONSTRAINT fk_eventos_ciudad1
    FOREIGN KEY (c_idCiudad)
    REFERENCES hr.ciudad (idCiudad),
  CONSTRAINT fk_eventos_promociones1
    FOREIGN KEY (p_idpromociones)
    REFERENCES hr.promociones (idpromociones)
  );


-- -----------------------------------------------------
-- Table hr.empresa
-- -----------------------------------------------------
CREATE TABLE hr.empresa (
  idEmpresa INT NOT NULL,
  nombre VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  PRIMARY KEY (idEmpresa)
);


-- -----------------------------------------------------
-- Table hr.alumno
-- -----------------------------------------------------
CREATE TABLE hr.alumno (
  idalumno INT NOT NULL,
  aNombre VARCHAR(45) NOT NULL,
  aPaterno VARCHAR(45) NOT NULL,
  aMaterno VARCHAR(45) NOT NULL,
  telefono VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  e_idEmpresa INT NOT NULL,
  carrera VARCHAR(45) NULL,
  notebook VARCHAR(45) NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (idalumno),
  CONSTRAINT fk_alumno_empresa1
    FOREIGN KEY (e_idEmpresa)
    REFERENCES hr.empresa (idEmpresa)
  );


-- -----------------------------------------------------
-- Table hr.materiales
-- -----------------------------------------------------
CREATE TABLE hr.materiales (
  idmaterial INT NOT NULL,
  mNombre VARCHAR(45) NOT NULL,
  mDescripcion VARCHAR(45) NULL,
  mRuta VARCHAR(45) NULL,
  c_idcursos INT NOT NULL,
  PRIMARY KEY (idmaterial),
  CONSTRAINT fk_materiales_cursos1
    FOREIGN KEY (c_idcursos)
    REFERENCES hr.cursos (idcursos)
  );


-- -----------------------------------------------------
-- Table hr.factura
-- -----------------------------------------------------
CREATE TABLE hr.factura (
  idfactura INT NOT NULL,
  valor VARCHAR(30) NOT NULL,
  descripcion VARCHAR(100) NULL,
  RCFexpide VARCHAR(45) NOT NULL,
  selloDigital VARCHAR(45) NOT NULL,
  lugar VARCHAR(45) NULL,
  fecha DATE NOT NULL,
  RFCrecibe VARCHAR(45) NOT NULL,
  valorLetra VARCHAR(100) NULL,
  certificadoDigital VARCHAR(45) NOT NULL,
  PRIMARY KEY (idfactura)
);


-- -----------------------------------------------------
-- Table hr.pagos
-- -----------------------------------------------------
CREATE TABLE hr.pagos (
  idpagos INT NOT NULL,
  f_idfactura INT NOT NULL,
  tipo VARCHAR(20) NOT NULL,
  status INT NULL,
  PRIMARY KEY (idpagos),
  CONSTRAINT fk_pagos_factura1
    FOREIGN KEY (f_idfactura)
    REFERENCES hr.factura (idfactura)
  );


-- -----------------------------------------------------
-- Table hr.alumno_has_eventos
-- -----------------------------------------------------
CREATE TABLE hr.alumno_has_eventos (
  a_idalumno INT NOT NULL,
  e_idevento INT NOT NULL,
  PRIMARY KEY (a_idalumno, e_idevento),
  CONSTRAINT fk_alumno_has_eventos_alumno1
    FOREIGN KEY (a_idalumno)
    REFERENCES hr.alumno (idalumno),
  CONSTRAINT fk_alumno_has_eventos_eventos1
    FOREIGN KEY (e_idevento)
    REFERENCES hr.eventos (idevento)
  );


-- -----------------------------------------------------
-- Table hr.alumno_has_cursos
-- -----------------------------------------------------
CREATE TABLE hr.alumno_has_cursos (
  a_idalumno INT NOT NULL,
  c_idcursos INT NOT NULL,
  PRIMARY KEY (a_idalumno, c_idcursos),
  CONSTRAINT fk_alumno_has_cursos_alumno1
    FOREIGN KEY (a_idalumno)
    REFERENCES hr.alumno (idalumno),
  CONSTRAINT fk_alumno_has_cursos_cursos1
    FOREIGN KEY (c_idcursos)
    REFERENCES hr.cursos (idcursos)
  );


-- -----------------------------------------------------
-- Table hr.cursos_has_pagos
-- -----------------------------------------------------
CREATE TABLE hr.cursos_has_pagos (
  c_idcursos INT NOT NULL,
  p_idpagos INT NOT NULL,
  promocion VARCHAR(30) NOT NULL,
  PRIMARY KEY (c_idcursos, p_idpagos),
  CONSTRAINT fk_cursos_has_pagos_cursos1
    FOREIGN KEY (c_idcursos)
    REFERENCES hr.cursos (idcursos),
  CONSTRAINT fk_cursos_has_pagos_pagos1
    FOREIGN KEY (p_idpagos)
    REFERENCES hr.pagos (idpagos)
  );


-- -----------------------------------------------------
-- Table hr.eventos_has_pagos
-- -----------------------------------------------------
CREATE TABLE hr.eventos_has_pagos (
  e_idevento INT NOT NULL,
  p_idpagos INT NOT NULL,
  PRIMARY KEY (e_idevento, p_idpagos),
  CONSTRAINT fk_eventos_has_pagos_eventos1
    FOREIGN KEY (e_idevento)
    REFERENCES hr.eventos (idevento),
  CONSTRAINT fk_eventos_has_pagos_pagos1
    FOREIGN KEY (p_idpagos)
    REFERENCES hr.pagos (idpagos)
  );


-- -----------------------------------------------------
-- Table hr.diploma
-- -----------------------------------------------------
CREATE TABLE hr.diploma (
  iddiploma INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  curso VARCHAR(45) NOT NULL,
  fecha VARCHAR(45) NOT NULL,
  PRIMARY KEY (iddiploma)
);


-- -----------------------------------------------------
-- Table hr.pre-inscripcion
-- -----------------------------------------------------
CREATE TABLE hr.preInscripcion (
  idpreInscripcion INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  apellido VARCHAR(45) NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  e_idEmpresa INT NOT NULL,
  carrera VARCHAR(45) NULL,
  confirmar VARCHAR(45) NULL,
  PRIMARY KEY (idpreInscripcion),
  CONSTRAINT fk_preInscripcion_empresa1
    FOREIGN KEY (e_idEmpresa)
    REFERENCES hr.empresa (idEmpresa)
  );


-- -----------------------------------------------------
-- Table hr.alumno_has_diploma
-- -----------------------------------------------------
CREATE TABLE hr.alumno_has_diploma (
  a_idalumno INT NOT NULL,
  d_iddiploma INT NOT NULL,
  PRIMARY KEY (a_idalumno, d_iddiploma),
  CONSTRAINT fk_alumno_has_diploma_alumno1
    FOREIGN KEY (a_idalumno)
    REFERENCES hr.alumno (idalumno),
  CONSTRAINT fk_alumno_has_diploma_diploma1
    FOREIGN KEY (d_iddiploma)
    REFERENCES hr.diploma (iddiploma)
  );


-- -----------------------------------------------------
-- Table hr.pre-inscripcion_has_pagos
-- -----------------------------------------------------
CREATE TABLE hr.preInscripcion_has_pagos (
  p_idpreInscripcion INT NOT NULL,
  p_idpagos INT NOT NULL,
  PRIMARY KEY (p_idpreInscripcion, p_idpagos),
  CONSTRAINT fk_has_preInscripcion1
    FOREIGN KEY (p_idpreInscripcion)
    REFERENCES hr.preInscripcion (idpreInscripcion),
  CONSTRAINT fk_has_pagos
    FOREIGN KEY (p_idpagos)
    REFERENCES hr.pagos (idpagos)
  );


-- -----------------------------------------------------
-- Table hr.perfil
-- -----------------------------------------------------
CREATE TABLE hr.perfil (
  idPerfil INT NOT NULL,
  perfil VARCHAR(45) NOT NULL,
  PRIMARY KEY (idPerfil)
);


-- -----------------------------------------------------
-- Table hr.usuarios
-- -----------------------------------------------------
CREATE TABLE hr.usuarios (
  idusuarios INT NOT NULL,
  idPerfil INT NOT NULL,
  userName VARCHAR(45) NOT NULL,
  userPass VARCHAR(45) NOT NULL,
  PRIMARY KEY (idusuarios),
  CONSTRAINT fk_usuarios_perfil1
    FOREIGN KEY (idPerfil)
    REFERENCES hr.perfil (idPerfil)
  );
