INSERT INTO public.users ("role") VALUES
    ('Admin');

INSERT INTO public.grids ("location",capacity) VALUES
    ('somewhere',100);

INSERT INTO public.charging_stations (id_grid,id_vehicle,state) VALUES
    (1,NULL,'available');