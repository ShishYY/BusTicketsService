CREATE TABLE "user"(
	"id" SERIAL PRIMARY KEY,
	"first_name" VARCHAR (20),
	"last_name" VARCHAR (20),
	"login" VARCHAR (60),
	"email" VARCHAR (60),
	"password" TEXT,
);

CREATE TABLE "roles"(
    "id" SERIAL PRIMARY KEY,
    "name" VARCHAR (15)
);

CREATE TABLE "user_roles"(
    "id" SERIAL PRIMARY KEY,
    "user_id" BIGINT,
    "role_id" BIGINT
);

CREATE TABLE "tickets"(
	"id" SERIAL PRIMARY KEY,
	"passenger_first_name" VARCHAR (60),
	"passenger_last_name" VARCHAR(60),
	"route_id" BIGINT,
	"unique_pay_id" VARCHAR (10) DEFAULT 'no_pay',
	"purchase_status" VARCHAR (20)
);
CREATE TABLE "route_list"(
	"id" SERIAL PRIMARY KEY,
	"from_station" VARCHAR (70) NOT NULL,
	"where_station" VARCHAR(50) NOT NULL,
	"seats_number" INT NOT NULL,
	"free_seats" INT NOT NULL, 
	"departure_time" timestamp NOT NULL,
	"price" REAL CONSTRAINT positive_price CHECK (price > 0)
);
ALTER TABLE "tickets"
	ADD CONSTRAINT "route_id_CT"
	FOREIGN KEY ("route_id")
	REFERENCES"route_list"(id);

ALTER TABLE "user_roles"
    ADD CONSTRAINT "user_role_CT"
    FOREIGN KEY ("user_id")
    REFERENCES"user"(id);

ALTER TABLE "user_roles"
    ADD CONSTRAINT "role_name_CT)"
    FOREIGN KEY ("role_id")
    REFERENCES"roles"(id) ;