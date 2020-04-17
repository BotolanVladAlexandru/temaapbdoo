create table tag
(
  id character varying(40) not null constraint tag_pkey primary key,
  name character varying(255) not null
);

alter table post
add column tag_id character varying(40);