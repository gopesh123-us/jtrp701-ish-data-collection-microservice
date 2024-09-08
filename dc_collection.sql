USE jrtp701_ish_db;

SHOW TABLES;

jrtp701_ish_dbjr701_dc_cases
SELECT * FROM jr701_citizen_application;
SELECT * FROM citizen_application;

INSERT INTO jr701_citizen_application SELECT * FROM citizen_application;

SELECT * FROM jr701_dc_cases;

SELECT * FROM jr701_plan_master;
SELECT * FROM jr701_dc_income;
SELECT * FROM jr701_dc_education;
SELECT * FROM jr701_dc_children;


INSERT INTO JR701_PLAN_MASTER (
    plan_id,
    plan_name,
    plan_category_id,
    start_date,
    end_date,
    description,
    active_sw,
    created_at,
    created_by
)
VALUES
(
    1,
    'Medicare Basic',
    1,
    '2022-01-01',
    '2022-12-31',
    'Basic health coverage for citizens',
    'Y',
    '2022-01-01 12:00:00',
    'admin'
),
(
    2,
    'Medicare Premium',
    2,
    '2022-01-01',
    '2022-12-31',
    'Enhanced health coverage with additional benefits',
    'Y',
    '2022-01-01 12:00:00',
    'admin'
),
(
    3,
    'Medicare Senior',
    3,
    '2022-01-01',
    '2022-12-31',
    'Specialized health coverage for senior citizens',
    'Y',
    '2022-01-01 12:00:00',
    'admin'
),
(
    4,
    'Medicare Family',
    4,
    '2022-01-01',
    '2022-12-31',
    'Family health coverage with dependent benefits',
    'Y',
    '2022-01-01 12:00:00',
    'admin'
),
(
    5,
    'Medicare Disability',
    5,
    '2022-01-01',
    '2022-12-31',
    'Specialized health coverage for citizens with disabilities',
    'Y',
    '2022-01-01 12:00:00',
    'admin'
),
(
    6,
    'Medicare Chronic',
    6,
    '2022-01-01',
    '2022-12-31',
    'Specialized health coverage for citizens with chronic conditions',
    'Y',
    '2022-01-01 12:00:00',
    'admin'
),
(
    7,
    'Medicare Pediatric',
    7,
    '2022-01-01',
    '2022-12-31',
    'Specialized health coverage for children',
    'Y',
    '2022-01-01 12:00:00',
    'admin'
);
