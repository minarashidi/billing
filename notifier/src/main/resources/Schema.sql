DROP SCHEMA NOTIFIER CASCADE;
CREATE SCHEMA NOTIFIER;

-- CUSTOMER
CREATE SEQUENCE NOTIFIER.S_CUSTOMER START WITH 1 INCREMENT BY 1;
CREATE TABLE NOTIFIER.CUSTOMER(
ID INTEGER DEFAULT NEXTVAL('NOTIFIER.S_CUSTOMER') PRIMARY KEY,
FIRST_NAME TEXT,
LAST_NAME TEXT,
EMAIL TEXT,
MOBILE TEXT
);

-- BILLING
CREATE SEQUENCE NOTIFIER.S_BILLING START WITH 1 INCREMENT BY 1;
CREATE TABLE NOTIFIER.BILLING(
ID INTEGER DEFAULT NEXTVAL ('NOTIFIER.S_BILLING') PRIMARY KEY ,
AMOUNT NUMERIC ,
CUSTOMER_ID INTEGER REFERENCES NOTIFIER.CUSTOMER(ID),
DUE_DATE TIMESTAMP ,
BILLING_NOTIFICATION_STATUS TEXT,
CREATED_DATE TIMESTAMP ,
CHANGED_DATE TIMESTAMP
);

-- EMAIL_NOTIFICATION
CREATE SEQUENCE NOTIFIER.S_EMAIL_NOTIFICATION START WITH 1 INCREMENT BY 1;
CREATE TABLE NOTIFIER.EMAIL_NOTIFICATION(
ID INTEGER DEFAULT NEXTVAL('NOTIFIER.S_EMAIL_NOTIFICATION') PRIMARY KEY,
CONTENT TEXT,
ADDRESS TEXT,
STATUS TEXT,
CREATED_DATE TIMESTAMP ,
CHANGED_DATE TIMESTAMP
);

-- SMS_NOTIFICATION
CREATE SEQUENCE NOTIFIER.S_SMS_NOTIFICATION START WITH 1 INCREMENT BY 1;
CREATE TABLE NOTIFIER.SMS_NOTIFICATION(
ID INTEGER DEFAULT NEXTVAL('NOTIFIER.S_SMS_NOTIFICATION') PRIMARY KEY,
CONTENT TEXT,
MOBILE TEXT,
STATUS TEXT,
CREATED_DATE TIMESTAMP ,
CHANGED_DATE TIMESTAMP
);