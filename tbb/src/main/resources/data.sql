INSERT INTO CUSTOMERS (CUST_ID, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS,
            BUSINESS_ZIP, EMAIL, FIRST_NAME, LAST_NAME, PERSONAL_PHONE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1001, 'Middletown', 'USA', 'The Busy Beevers', 'Ohio', '2433 Buckingham Ct', '45044', 'sab@gmail.com', 'Sara', 'Beevers',
null, 'Virtual Assistant', '480-694-8993');
INSERT INTO CUSTOMERS (CUST_ID, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS,
            BUSINESS_ZIP, EMAIL, FIRST_NAME, LAST_NAME, PERSONAL_PHONE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1002, 'Queen Creek', 'USA', 'Home business', 'Arizona', '4966 E Vista Grande', '85142', 'ryan2914@gmail.com', 'Ryan', 'Beevers',
null, 'Home Studio', '813-860-4976');
INSERT INTO CUSTOMERS (CUST_ID, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS,
            BUSINESS_ZIP, EMAIL, FIRST_NAME, LAST_NAME, PERSONAL_PHONE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1003, 'Ruskin', 'USA', 'Beach Cleaner', 'Florida', '905 Seagrape Dr', '33570', 'faithharsh@yahoo.com', 'Faith', 'Harsh',
'480-695-8931', 'Beach cleaning business', '480-888-9173');
INSERT INTO CUSTOMERS (CUST_ID, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS,
            BUSINESS_ZIP, EMAIL, FIRST_NAME, LAST_NAME, PERSONAL_PHONE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1004, 'San Tan Valley', 'USA', 'Horse Washer', 'Arizona', '1234 Lane Dr', '85242', 'anotherEmail@gmail.com', 'John', 'Smith',
null, 'Animal Care', '888-888-1234');
INSERT INTO CUSTOMERS (CUST_ID, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS,
            BUSINESS_ZIP, EMAIL, FIRST_NAME, LAST_NAME, PERSONAL_PHONE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1005, 'Tampa', 'USA', 'Another business', 'Florida', '123456 Another Lane', '12345', 'another@yahoo.com', 'Jane', 'Smith',
'123-123-1234', 'Lawn mowing summer job', '999-999-9999');

INSERT INTO INVOICES (INVOICE_ID, INVOICE_DATE_OF_ISSUE, INVOICE_DISCOUNT, INVOICE_PAID_DATE, INVOICE_PAID_FLAG, INVOICE_PAY_BY_DATE, INVOICE_TOTAL, CUST_ID) VALUES
(1, current_timestamp, 0, current_timestamp, 1,current_timestamp, 100.00, 1001);
INSERT INTO INVOICES (INVOICE_ID, INVOICE_DATE_OF_ISSUE, INVOICE_DISCOUNT, INVOICE_PAID_DATE, INVOICE_PAID_FLAG, INVOICE_PAY_BY_DATE, INVOICE_TOTAL, CUST_ID) VALUES
(2, current_timestamp, 20, null, 0, current_timestamp, 20.00, 1002);
INSERT INTO INVOICES (INVOICE_ID, INVOICE_DATE_OF_ISSUE, INVOICE_DISCOUNT, INVOICE_PAID_DATE, INVOICE_PAID_FLAG, INVOICE_PAY_BY_DATE, INVOICE_TOTAL, CUST_ID) VALUES
(3, current_timestamp, 40, current_timestamp, 1, current_timestamp, 160.00, 1003);
INSERT INTO INVOICES (INVOICE_ID, INVOICE_DATE_OF_ISSUE, INVOICE_DISCOUNT, INVOICE_PAID_DATE, INVOICE_PAID_FLAG, INVOICE_PAY_BY_DATE, INVOICE_TOTAL, CUST_ID) VALUES
(4, current_timestamp, 20, null, 0, current_timestamp , 140.00, 1004);
INSERT INTO INVOICES (INVOICE_ID, INVOICE_DATE_OF_ISSUE, INVOICE_DISCOUNT, INVOICE_PAID_DATE, INVOICE_PAID_FLAG, INVOICE_PAY_BY_DATE, INVOICE_TOTAL, CUST_ID) VALUES
(5, current_timestamp, 0, current_timestamp, 1, current_timestamp, 1000.00, 1005);

INSERT INTO TASKS (TASK_ID, TASK_ACTUAL_EFFORT, TASK_COST_PER_HOUR, TASK_DESC, TASK_DUE_DATE, TASK_ESTIMATED_COST, TASK_ESTIMATED_EFFORT, TASK_FINAL_COST,
TASK_NAME, TASK_STATUS, TASK_SUBMITTED_DATE, INVOICE_ID, CUST_ID) VALUES
(1, 8, 10.20, 'This is a task.', current_timestamp, 100.00, 8, 81.60, 'do a thing', 'Completed', current_timestamp, 1, 1001);
INSERT INTO TASKS (TASK_ID, TASK_ACTUAL_EFFORT, TASK_COST_PER_HOUR, TASK_DESC, TASK_DUE_DATE, TASK_ESTIMATED_COST, TASK_ESTIMATED_EFFORT, TASK_FINAL_COST,
TASK_NAME, TASK_STATUS, TASK_SUBMITTED_DATE, INVOICE_ID, CUST_ID) VALUES
(2, 1, 10.00, 'This is another task.', current_timestamp, 10.00, 1, 20.00, 'do a different thing', 'Completed', current_timestamp, 1, 1001);
INSERT INTO TASKS (TASK_ID, TASK_ACTUAL_EFFORT, TASK_COST_PER_HOUR, TASK_DESC, TASK_DUE_DATE, TASK_ESTIMATED_COST, TASK_ESTIMATED_EFFORT, TASK_FINAL_COST,
TASK_NAME, TASK_STATUS, TASK_SUBMITTED_DATE, INVOICE_ID, CUST_ID) VALUES
(3, 1, 11.20, 'This is 2 task.', current_timestamp, 100.00, 8, 81.60, 'do a thing', 'In progress', current_timestamp, 2, 1002);
INSERT INTO TASKS (TASK_ID, TASK_ACTUAL_EFFORT, TASK_COST_PER_HOUR, TASK_DESC, TASK_DUE_DATE, TASK_ESTIMATED_COST, TASK_ESTIMATED_EFFORT, TASK_FINAL_COST,
TASK_NAME, TASK_STATUS, TASK_SUBMITTED_DATE, INVOICE_ID, CUST_ID) VALUES
(4, 2, 12.20, 'This is 3 task.', current_timestamp, 100.00, 8, 81.60, 'do a thing', 'Not yet started', current_timestamp, null, 1002);
INSERT INTO TASKS (TASK_ID, TASK_ACTUAL_EFFORT, TASK_COST_PER_HOUR, TASK_DESC, TASK_DUE_DATE, TASK_ESTIMATED_COST, TASK_ESTIMATED_EFFORT, TASK_FINAL_COST,
TASK_NAME, TASK_STATUS, TASK_SUBMITTED_DATE, INVOICE_ID, CUST_ID) VALUES
(5, 3, 13.20, 'This is 4 task.', current_timestamp, 100.00, 8, 81.60, 'do a thing', 'Completed', current_timestamp, null, 1003);
INSERT INTO TASKS (TASK_ID, TASK_ACTUAL_EFFORT, TASK_COST_PER_HOUR, TASK_DESC, TASK_DUE_DATE, TASK_ESTIMATED_COST, TASK_ESTIMATED_EFFORT, TASK_FINAL_COST,
TASK_NAME, TASK_STATUS, TASK_SUBMITTED_DATE, INVOICE_ID, CUST_ID) VALUES(6, 4, 14.20, 'This is 5 task.', current_timestamp, 100.00, 8, 81.60, 'do a thing', 'Completed', current_timestamp, 4, 4);
INSERT INTO TASKS (TASK_ID, TASK_ACTUAL_EFFORT, TASK_COST_PER_HOUR, TASK_DESC, TASK_DUE_DATE, TASK_ESTIMATED_COST, TASK_ESTIMATED_EFFORT, TASK_FINAL_COST,
TASK_NAME, TASK_STATUS, TASK_SUBMITTED_DATE, INVOICE_ID, CUST_ID) VALUES
(7, 5, 15.20, 'This is 6 task.', current_timestamp, 100.00, 8, 81.60, 'do a thing', 'Completed', current_timestamp, 5, 1004);

INSERT INTO USERS (USER_ID, ALREADY_TEXTED, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS, BUSINESS_ZIP,
EMAIL, FIRST_NAME, LAST_NAME, FIRST_TIME_LOGIN, PASSWORD, PERSONAL_PHONE, ROLE_TYPE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1001, 1, 'Middletown', 'USA', 'The Busy Beevers', 'OHIO', '2433 Buckingham Ct', '45055', 'test1@yahoo.com', 'Sara','Beevers', 0,
'password', '480-694-8993', 'admin', 'Virtual Assistant', '813-860-4976');
INSERT INTO USERS (USER_ID, ALREADY_TEXTED, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS, BUSINESS_ZIP,
EMAIL, FIRST_NAME, LAST_NAME, FIRST_TIME_LOGIN, PASSWORD, PERSONAL_PHONE, ROLE_TYPE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1002, 0, 'Tampa', 'USA', 'Another business', 'Florida', '123456 Another Lane', '12345', 'test2@yahoo.com', 'John', 'Smith', 1,
'password', '123-123-1234', 'user', 'Lawn mowing summer job', '999-999-9999');
INSERT INTO USERS (USER_ID, ALREADY_TEXTED, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS, BUSINESS_ZIP,
EMAIL, FIRST_NAME, LAST_NAME, FIRST_TIME_LOGIN, PASSWORD, PERSONAL_PHONE, ROLE_TYPE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1003, 0, 'Tampa', 'USA', 'Another business', 'Florida', '123456 Another Lane', '12345', 'test3@yahoo.com', 'Ryan', 'Beevers', 0,
'password', '123-123-1234', 'admin', 'Lawn mowing summer job', '999-999-9999');
INSERT INTO USERS (USER_ID, ALREADY_TEXTED, BUSINESS_CITY, BUSINESS_COUNTRY, BUSINESS_NAME, BUSINESS_STATE, BUSINESS_STREET_ADDRESS, BUSINESS_ZIP,
EMAIL, FIRST_NAME, LAST_NAME, FIRST_TIME_LOGIN, PASSWORD, PERSONAL_PHONE, ROLE_TYPE, TYPE_OF_BUSINESS, WORK_PHONE) VALUES
(1004, 0, 'Tampa', 'USA', 'Another business', 'Florida', '123456 Another Lane', '12345', 'test4@yahoo.com', 'Jane', 'Smith', 1,
'password', '123-123-1234', 'user', 'Lawn mowing summer job', '999-999-9999');

INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1000, 'What is your mothers maiden name?', 'Femling');
INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1000, 'What is your fathers middle name?", "Vincent');

INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1001, 'What is your mothers maiden name?', 'Femling');
INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1001, 'What is your fathers middle name?', 'Vincent');

INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1002, 'What is your mothers maiden name?', 'Femling');
INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1002, 'What is your fathers middle name?', 'Vincent');

INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1003, 'What is your mothers maiden name?', 'Femling');
INSERT INTO CHALLENGE_QUESTIONS (USER_ID, CHALLENGE_QUESTION, CHALLENGE_ANSWER) VALUES
(1003, 'What is your fathers middle name?', 'Vincent');

INSERT INTO SERVICES (SERVICE_ID, CARD_TITLE, CARD_IMG, CARD_TITLE_2, CARD_DESC, CARD_PRICING_DETAIL) VALUES
(1, 'Event Planning', 'https://images.pexels.com/photos/267507/pexels-photo-267507.jpeg?cs=srgb&dl=businessmen-classroom-communication-267507.jpg&fm=jpg',
'Title1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Et sollicitudin ac orci phasellus egestas tellus. Phasellus faucibus scelerisque eleifend donec.',
'$16-$18 Per Hour');

INSERT INTO SERVICES (SERVICE_ID, CARD_TITLE, CARD_IMG, CARD_TITLE_2, CARD_DESC, CARD_PRICING_DETAIL) VALUES(
'Travel Management', 'https://images.pexels.com/photos/1204649/pexels-photo-1204649.jpeg?cs=srgb&dl=brainstorming-collaborate-collaboration-1204649.jpg&fm=jpg',
'Title2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Dignissim suspendisse in est ante in. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt tortor.',
'$20-$22 Per Hour');

INSERT INTO SERVICES (SERVICE_ID, CARD_TITLE, CARD_IMG, CARD_TITLE_2, CARD_DESC, CARD_PRICING_DETAIL) VALUES(
'Administrative Assistant', 'http://www.intheblack.com/~/media/intheblack/allimages/sponsored-content/2018/dexus-office-space.jpg',
'Title3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eget mi proin sed libero enim sed faucibus turpis in. Sed enim ut sem viverra aliquet eget.',
'$10-$12 Per Hour');

INSERT INTO SERVICES (SERVICE_ID, CARD_TITLE, CARD_IMG, CARD_TITLE_2, CARD_DESC, CARD_PRICING_DETAIL) VALUES(
'Virtual Assistant','https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE28gcp?ver=be70&q=90&m=2&h=768&w=1024&b=%23FFFFFFFF&aim=true',
'Title4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Bibendum est ultricies integer quis auctor elit sed vulputate mi. Senectus et netus et malesuada.',
'$1-$2 Per Hour');
