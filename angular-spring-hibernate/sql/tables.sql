CREATE TABLE contact
(
  id integer NOT NULL,
  email character varying(255),
  name character varying(255),
  phonenumber character varying(255),
  CONSTRAINT contact_pkey PRIMARY KEY (id)
);

CREATE TABLE customuser
(
  id character varying(32) NOT NULL,
  code character varying(4) NOT NULL,
  email character varying(256) NOT NULL,
  name character varying(40) NOT NULL,
  surname character varying(40) NOT NULL,
  version integer,
  systemuser_id character varying(32) NOT NULL,
  systemrole character varying(40),
  CONSTRAINT customuser_pkey PRIMARY KEY (id),
  CONSTRAINT fk188ba6fc3eab3607 FOREIGN KEY (systemuser_id)
      REFERENCES systemuser (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT customuser_code_key UNIQUE (code)
);

CREATE TABLE systemrole
(
  id character varying(32) NOT NULL,
  description character varying(255) NOT NULL,
  name character varying(50) NOT NULL,
  CONSTRAINT systemrole_pkey PRIMARY KEY (id),
  CONSTRAINT systemrole_name_key UNIQUE (name)
);


CREATE TABLE user_role
(
  user_id character varying(32) NOT NULL,
  role_id character varying(32) NOT NULL,
  CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk143bf46a28f4ab16 FOREIGN KEY (user_id)
      REFERENCES systemuser (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk143bf46a83c9e736 FOREIGN KEY (role_id)
      REFERENCES systemrole (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);