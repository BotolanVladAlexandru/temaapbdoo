create table importance
(
  id character varying(40) not null constraint importance_pkey primary key,
  name character varying(255) not null
);

alter table post
add column importance_id character varying(40) not null;

ALTER TABLE post
  ADD CONSTRAINT fk_post_importance
    FOREIGN KEY (importance_id)
      REFERENCES importance (id);