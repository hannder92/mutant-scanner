CREATE TABLE dna (
id SERIAL NOT NULL PRIMARY KEY,
dna_pattern TEXT NOT NULL UNIQUE,
mutant boolean NOT NULL DEFAULT FALSE
);

CREATE INDEX I_dna_pattern
ON dna (dna_pattern);