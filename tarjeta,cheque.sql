CREATE TABLE `db_sigecu`.`Tarjeta` (
  `numero_tarjeta` INTEGER UNSIGNED NOT NULL,
  `titular_tarjeta` VARCHAR(45) NOT NULL,
  `fecha_expiracion` DATE NOT NULL,
  `codigo_seguridad` INTEGER UNSIGNED NOT NULL
)
ENGINE = InnoDB;

CREATE TABLE `db_sigecu`.`cheque` (
  `numero_seguridad` INTEGER UNSIGNED NOT NULL,
  `cantidad` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`numero_seguridad`)
)
ENGINE = InnoDB;
