--Creacion de tablas
CREATE TABLE PRODUCTOS (idProducto INT PRIMARY KEY NOT NULL, clave varchar(15), descripcion varchar(150), activo BIT);
CREATE TABLE CLIENTES (idCliente INT PRIMARY KEY NOT NULL, nombre char(50) NOT NULL, activo BIT);

CREATE TABLE LISTACOMPRA (iDLista Int PRIMARY KEY NOT NULL, customer_id INT NOT NULL, 
nombre char(50) NOT NULL, fechaRegistro DATE, fechaUltimaActualizacion DATE, activo BIT);
CREATE TABLE LISTACOMPRADETALLE (idListaCompra INT Not NULL, idCodigoProducto INT NOT NULL, cantidad INT);

 ALTER TABLE LISTACOMPRA
    ADD FOREIGN KEY (customer_id) 
    REFERENCES CLIENTES(idCliente);

 ALTER TABLE LISTACOMPRADETALLE
    ADD FOREIGN KEY (idListaCompra) 
    REFERENCES LISTACOMPRA(iDLista);

 ALTER TABLE LISTACOMPRADETALLE
    ADD FOREIGN KEY (idCodigoProducto) 
    REFERENCES PRODUCTOS(idProducto);