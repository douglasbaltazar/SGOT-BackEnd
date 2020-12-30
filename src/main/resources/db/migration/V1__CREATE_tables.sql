CREATE TABLE tbl_orders (
	id SERIAL PRIMARY KEY,
	product1 VARCHAR(100) NOT NULL,
	product2 VARCHAR(100),
	product3 VARCHAR(100),
	totalValue DOUBLE PRECISION
) WITH (
	OIDS=FALSE
);

CREATE TABLE tbl_transportOrder (
	id SERIAL PRIMARY KEY,
	id_product INTEGER,
	sent boolean
) WITH (
	OIDS=FALSE
);