create table user
(
    created_at  datetime(6),
    id          bigint not null auto_increment,
    modified_at datetime(6),
    email       varchar(255),
    name        varchar(255),
    primary key (id)
)

create table currency
(
    exchange_rate decimal(38, 2),
    created_at    datetime(6),
    id            bigint not null auto_increment,
    modified_at   datetime(6),
    currency_name varchar(255),
    symbol        varchar(255),
    primary key (id)
)

create table user_to_currency
(
    id                    bigint not null auto_increment,
    amount_after_exchange decimal(38, 2),
    amount_in_krw         integer,
    currency_id           bigint,
    created_at            datetime(6),
    modified_at           datetime(6),
    user_id               bigint,
    status                varchar(255),
    primary key (id)
)

alter table user_to_currency
    add constraint
        foreign key (currency_id)
            references currency (id)

alter table user_to_currency
    add constraint
        foreign key (user_id)
            references user (id)