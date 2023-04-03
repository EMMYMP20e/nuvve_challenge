CREATE TABLE GRIDS
(
    "id_grid"  SERIAL      NOT NULL,
    "location" VARCHAR(30) NOT NULL,
    "capacity" INT         NOT NULL,
    PRIMARY KEY ("id_grid")
);

CREATE TABLE USERS
(
    "id_user" SERIAL      NOT NULL,
    "role"    VARCHAR(20) NOT NULL,
    PRIMARY KEY ("id_user")
);


CREATE TABLE VEHICLES
(
    "id_vehicle"     SERIAL      NOT NULL,
    "id_user"        INT         NOT NULL,
    "battery"        INT         NOT NULL,
    "next_distance"  INT NULL,
    "scheduled_time" TIMESTAMP NULL,
    "state"          VARCHAR(20) NOT NULL,
    PRIMARY KEY ("id_vehicle"),
    CONSTRAINT "fk_VEHICLES_OWNERS"
        FOREIGN KEY ("id_user")
            REFERENCES USERS ("id_user")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE CHARGING_STATIONS
(
    "id_cs"      SERIAL      NOT NULL,
    "id_grid"    INT         NOT NULL,
    "id_vehicle" INT NULL,
    "state"      VARCHAR(20) NOT NULL,
    PRIMARY KEY ("id_cs"),
    CONSTRAINT "fk_CS_GRID"
        FOREIGN KEY ("id_grid")
            REFERENCES GRIDS ("id_grid")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_CS_CAR"
        FOREIGN KEY ("id_vehicle")
            REFERENCES VEHICLES ("id_vehicle")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

