CREATE TYPE KEYS_ENUM AS ENUM ('email', 'phoneNumber', 'crifAddressId', 'mobileNumber');

CREATE TABLE blacklist (
    key KEYS_ENUM,
    value VARCHAR(255),
    mf_user VARCHAR(255) NOT NULL,
    reason VARCHAR(255) NOT NULL,
    expiration DATE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (key, value)
);