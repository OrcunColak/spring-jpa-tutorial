create TABLE cartitem (
    cartid INTEGER NOT NULL,
    productid INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    count INTEGER NOT NULL,
    PRIMARY KEY (cartid, productid)
);