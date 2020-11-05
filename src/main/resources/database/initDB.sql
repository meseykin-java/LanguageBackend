CREATE TABLE IF NOT EXISTS t_language
(
    f_id    SERIAL PRIMARY KEY,
    f_name  VARCHAR(200) NOT NULL,
    f_description VARCHAR(200) NOT NULL,
    f_rating INTEGER
);