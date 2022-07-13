CREATE TABLE life_data
(
    id                 serial primary key,
    date_time          timestamp,
    temperature        real,
    diastolic_pressure bigint,
    systolic_pressure  bigint,
    saturation         bigint,
    pulse              bigint,
    patient_id         bigint
);