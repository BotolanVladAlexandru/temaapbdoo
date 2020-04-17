create table category
(
  id character varying(40) not null constraint category_pkey primary key,
  name character varying(255) not null,
  post_id CHARACTER VARYING(40)
);