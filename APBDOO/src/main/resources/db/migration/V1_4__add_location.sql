create table location
(
  id character varying(40) not null constraint location_pkey primary key,
  name character varying(255) not null
);

alter table post
add column location_id character varying(40) not null;

ALTER TABLE post
  ADD CONSTRAINT fk_post_location
    FOREIGN KEY (location_id)
      REFERENCES location (id);