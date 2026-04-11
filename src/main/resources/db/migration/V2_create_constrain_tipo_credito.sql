ALTER TABLE tipo_credito
ADD CONSTRAINT uk_tipo_credito_descripcion
UNIQUE (descripcion);