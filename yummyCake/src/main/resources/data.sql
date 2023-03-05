insert into role(id,name) values (1,'ROLE_CUSTOMER') ON CONFLICT DO NOTHING

insert into role(id,name) values (2,'ROLE_OWNER') ON CONFLICT DO NOTHING
