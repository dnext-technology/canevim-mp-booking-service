CREATE TABLE IF NOT EXISTS requesters
(
    id                   SERIAL PRIMARY KEY,
    identity_number      varchar(255) NOT NULL,
    first_name           varchar(255) NOT NULL,
    last_name            varchar(255) NOT NULL,
    email                varchar(255),
    phone                varchar(255) NOT NULL,
    city                 varchar(255) NOT NULL,
    district             varchar(255) NOT NULL,
    town                 varchar(255),
    neighborhood         varchar(255),
    address_detail       varchar(255),
    adult_number         int          NOT NULL,
    child_number         int          NOT NULL,
    accommodation_period varchar(255) NOT NULL,
    note                 varchar(255),
    status               varchar(255) NOT NULL,
    created_date         TIMESTAMP    NOT NULL,
    last_modified_date   TIMESTAMP    NOT NULL,
    version              INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS offerers
(
    id                   SERIAL PRIMARY KEY,
    identity_number      varchar(255) NOT NULL,
    first_name           varchar(255) NOT NULL,
    last_name            varchar(255) NOT NULL,
    email                varchar(255),
    phone                varchar(255) NOT NULL,
    city                 varchar(255) NOT NULL,
    district             varchar(255) NOT NULL,
    town                 varchar(255),
    neighborhood         varchar(255),
    address_detail       varchar(255),
    guest_capacity       int          NOT NULL,
    accommodation_type   varchar(255) NOT NULL,
    accommodation_period varchar(255) NOT NULL,
    note                 varchar(255),
    status               varchar(255) NOT NULL,
    created_date         TIMESTAMP    NOT NULL,
    last_modified_date   TIMESTAMP    NOT NULL,
    version              INT          NOT NULL
);

