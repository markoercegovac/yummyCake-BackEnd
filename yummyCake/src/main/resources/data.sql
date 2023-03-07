insert into role(id,name) values (1,'CUSTOMER') ON CONFLICT DO NOTHING

insert into role(id,name) values (2,'OWNER') ON CONFLICT DO NOTHING
