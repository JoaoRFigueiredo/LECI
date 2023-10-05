CREATE TABLE AIRPORT (
  airport_code INT NOT NULL,
  city VARCHAR(30) NOT NULL,
  state_name VARCHAR(30) NOT NULL,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (airport_code)
);

CREATE TABLE AIRPLANE_TYPE (
  typeName CHAR(15) NOT NULL,
  max_seats INT NOT NULL,
  company VARCHAR(30) NOT NULL,
  PRIMARY KEY (typeName)
);

CREATE TABLE FLIGHT (
  number INT NOT NULL,
  airline VARCHAR(30) NOT NULL,
  weekdays VARCHAR(10) NOT NULL,
  PRIMARY KEY (number)
);

CREATE TABLE FLIGHT_LEG (
  flight_num INT NOT NULL,
  leg_num INT NOT NULL,
  code_airport_arr INT NOT NULL,
  code_airport_departure INT NOT NULL,
  sched_dep_time TIME NOT NULL,
  sched_arr_time TIME NOT NULL,
  PRIMARY KEY (leg_num, flight_num),
  FOREIGN KEY (flight_num) REFERENCES FLIGHT(number),
  FOREIGN KEY (code_airport_arr) REFERENCES AIRPORT(airport_code),
  FOREIGN KEY (code_airport_departure) REFERENCES AIRPORT(airport_code)
);

CREATE TABLE FARE (
  code INT NOT NULL,
  flight_num INT NOT NULL,
  restrictions VARCHAR(30) NOT NULL,
  amount INT NOT NULL,
  PRIMARY KEY (code),
  FOREIGN KEY (flight_num) REFERENCES FLIGHT(number)
);

CREATE TABLE AIRPLANE (
  airplane_id INT NOT NULL,
  total_num_seats INT NOT NULL,
  typeAirplane VARCHAR(15) NOT NULL,
  PRIMARY KEY (airplane_id),
  FOREIGN KEY (typeAirplane) REFERENCES AIRPLANE_TYPE(typeName)
);

CREATE TABLE CAN_LAND (
  airport_code INT NOT NULL,
  typeName VARCHAR(15) NOT NULL,
  FOREIGN KEY (typeName) REFERENCES AIRPLANE_TYPE(typeName),
  FOREIGN KEY (airport_code) REFERENCES AIRPORT(airport_code)
);

CREATE TABLE LEG_INSTANCE (
  airplane_id INT NOT NULL,
  flight_num INT NOT NULL,
  date_ DATE NOT NULL,
  seat_num INT NOT NULL,
  code_airport_arr INT NOT NULL,
  code_airport_departure INT NOT NULL,
  leg_num INT NOT NULL,
  num_available_seats INT NOT NULL,
  sched_dep_time TIME NOT NULL,
  sched_arr_time TIME NOT NULL,
  PRIMARY KEY (date_, leg_num, flight_num),
  FOREIGN KEY (leg_num, flight_num) REFERENCES FLIGHT_LEG(leg_num, flight_num),
  FOREIGN KEY (code_airport_arr) REFERENCES AIRPORT(airport_code),
  FOREIGN KEY (code_airport_departure) REFERENCES AIRPORT(airport_code),
  FOREIGN KEY (airplane_id) REFERENCES AIRPLANE(airplane_id)
);

CREATE TABLE SEAT (
  seat_number INT NOT NULL,
  date_ DATE NOT NULL,
  leg_num INT NOT NULL,
  costumer_name VARCHAR(30) NOT NULL,
  costumer_phone INT NOT NULL,
  flight_number INT NOT NULL,
  PRIMARY KEY (seat_number),
  FOREIGN KEY (date_, leg_num, flight_number) REFERENCES LEG_INSTANCE(date_, leg_num, flight_num)
);
