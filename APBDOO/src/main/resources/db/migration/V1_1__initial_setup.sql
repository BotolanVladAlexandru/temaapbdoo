create table post
(
  id character varying(40) not null constraint posts_pkey primary key,
  title character varying(255) not null,
  text text not null,
  deleted boolean not null,
  created_at timestamp,
  updated_at timestamp
)