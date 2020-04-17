create table site
(
    id character varying(40) not null constraint sites_pkey primary key,
    name character varying(255) not null
);

create table post_site
(
    post_id character varying(40) not null,
    site_id character varying(40) not null
);