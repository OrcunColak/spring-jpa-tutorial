create TABLE cartitem (
    cartid BIGINT NOT NULL,
    productid BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    count BIGINT NOT NULL,
    PRIMARY KEY (cartid, productid)
);

