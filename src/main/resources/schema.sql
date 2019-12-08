DROP Table DiscountMaster IF exists;

create table DiscountMaster (
  id integer not null auto_increment,
  slabmin DOUBLE,
  slabmax DOUBLE,
  discount DOUBLE,
  primary key(id)
);