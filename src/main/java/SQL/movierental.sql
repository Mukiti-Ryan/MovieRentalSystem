CREATE DATABASE IF NOT EXISTS `movierental` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `movierental`;

-- Table Structure for table `city`

CREATE TABLE `city` (
`cityId` int(10) NOT NULL PRIMARY KEY,
`country_Id` int(10) NOT NULL,
`nameOfCity` varchar(50),
`lastUpdate` timestamp
);

-- Table structure for table `country`

CREATE TABLE `country` (
`countryId` int(10) NOT NULL PRIMARY KEY,
`nameOfCountry` varchar(50),
`lastUpdate` timestamp
);

-- Table structure for table `staff`

CREATE TABLE `staff` (
`staffId` int(10) NOT NULL PRIMARY KEY ,
`address_Id` int(10) NOT NULL,
`store_Id` int(10) NOT NULL,
`payment_Id` int(10) NOT NULL,
`firstName` varchar(255),
`lastName` varchar(255),
`email` varchar(50),
`active` char(1),
`userName` varchar(16),
`password` varchar(40),
`lastUpdate` timestamp,
`pictureUrl` varchar(1000)
);


-- Table structure for table `payment`

CREATE TABLE `payment` (
`paymentId` int(10) NOT NULL PRIMARY KEY,
`rental_Id` int(10) NOT NULL,
`customer_Id` int(10) NOT NULL,
`staff_id` int(10) NOT NULL,
`amount` decimal(5,2),
`paymentDate` timestamp
);

-- Table structure for table `rental`

CREATE TABLE `rental` (
`rentalId` int(10) NOT NULL PRIMARY KEY,
`staff_Id` int(10) NOT NULL,
`customer_Id` int(10) NOT NULL,
`inventory_Id` int(10) NOT NULL,
`rentalDate` timestamp,
`returnDate` timestamp,
`lastUpdate` timestamp
);

-- Table structure for table `customer`

CREATE TABLE `customer` (
`customerId` int(10) NOT NULL PRIMARY KEY,
`address_Id` int(10) NOT NULL,
`addressColumn` int(10) NOT NULL,
`firstName` varchar(255),
`lastName` varchar(255),
`email` varchar(50),
`active` char(1),
`createDate` timestamp,
`lastUpdate` timestamp
);

-- Table structure for table `address`

CREATE TABLE `address` (
`addressId` int(10) NOT NULL PRIMARY KEY,
`city_Id` int(10) NOT NULL,
`address` varchar(50),
`address2` varchar(50),
`district` int(20),
`postalCode` varchar(10),
`phoneNumber` varchar(20),
`lastUpdate` timestamp
);

-- Table structure for table `actor`

CREATE TABLE `actor` (
`actorId` int(10) NOT NULL PRIMARY KEY,
`firstName` varchar(255),
`lastName` varchar(255),
`lastUpdate` timestamp
);

-- Table structure for table `film_actor`

CREATE TABLE `film_actor` (
`film_Id` int(10) NOT NULL PRIMARY KEY,
`actor_Id` int(10) NOT NULL,
`lastUpdate` timestamp
);

-- Table structure for table `film_category`

CREATE TABLE `film_category` (
`film_Id` int(10) NOT NULL PRIMARY KEY,
`category_Id` int(10) NOT NULL,
`lastUpdate` timestamp
);

-- Table structure for table `category`

CREATE TABLE `category` (
`categoryId` int(10) NOT NULL PRIMARY KEY,
`nameOfCategory` varchar(25),
`lastUpdate` timestamp
);

-- Table structure for table `language`

CREATE TABLE `language` (
`languageId` int(10) NOT NULL PRIMARY KEY,
`nameOfLanguage` varchar(20),
`lastUpdate` timestamp
);

-- Table structure for table `inventory`

CREATE TABLE `inventory` (
`inventoryId` int(10) NOT NULL PRIMARY KEY,
`film_Id` int(10) NOT NULL,
`lastUpdate` timestamp
);

-- Table structure for table `film`

CREATE TABLE `film` (
`filmId` int(10) NOT NULL PRIMARY KEY,
`language_Id` int(10) NOT NULL,
`title` varchar(255),
`description` varchar(255),
`releaseYear` int(4),
`rentalDuration` int(10),
`rentalRate` decimal(5,2),
`length` int(2),
`replacementCost` decimal(4,2),
`rating` int(10),
`lastUpdate` timestamp,
`specialFeatures` varchar(255),
`fullTxt` varchar(255)
);

-- Table structure for table `store`

CREATE TABLE `store` (
`storeId` int(10) NOT NULL PRIMARY KEY,
`address_Id` int(10),
`lastUpdate` timestamp
);

-- Constraints for tables

-- Constraints for table `city`

ALTER TABLE `city`
	ADD CONSTRAINT FOREIGN KEY (`country_Id`) REFERENCES `country` (`countryId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `film_category`

ALTER TABLE `film_category`
	ADD CONSTRAINT FOREIGN KEY (`category_Id`) REFERENCES `category` (`categoryId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `film_actor`

ALTER TABLE `film_actor`
	ADD CONSTRAINT FOREIGN KEY (`actor_Id`) REFERENCES `actor` (`actorId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `staff`

ALTER TABLE `staff`
	ADD CONSTRAINT FOREIGN KEY (`address_Id`) REFERENCES `address` (`addressId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
ALTER TABLE `staff`
	ADD CONSTRAINT FOREIGN KEY (`store_Id`) REFERENCES `store` (`storeId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
ALTER TABLE `staff`
	ADD CONSTRAINT FOREIGN KEY (`payment_Id`) REFERENCES `payment` (`paymentId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `store`

ALTER TABLE `store`
	ADD CONSTRAINT FOREIGN KEY (`address_Id`) REFERENCES `address` (`addressId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `address`

ALTER TABLE `address`
	ADD CONSTRAINT FOREIGN KEY (`city_Id`) REFERENCES `city` (`cityId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `customer`

ALTER TABLE `customer`
	ADD CONSTRAINT FOREIGN KEY (`address_Id`) REFERENCES `address` (`addressId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

ALTER TABLE `customer`
	ADD CONSTRAINT FOREIGN KEY(`addressColumn`) REFERENCES `address` (`addressId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `inventory`

ALTER TABLE `inventory`
	ADD CONSTRAINT FOREIGN KEY (`film_Id`) REFERENCES `film` (`filmId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `film`

ALTER TABLE `film`
	ADD CONSTRAINT FOREIGN KEY (`language_Id`) REFERENCES `language` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `rental`

ALTER TABLE `rental`
	ADD CONSTRAINT FOREIGN KEY (`staff_Id`) REFERENCES `staff` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
ALTER TABLE `rental`
	ADD CONSTRAINT FOREIGN KEY (`customer_Id`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
ALTER TABLE `rental`
	ADD CONSTRAINT FOREIGN KEY (`inventory_Id`) REFERENCES `inventory` (`inventoryId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

-- Constraints for table `payment`

ALTER TABLE `payment`
	ADD CONSTRAINT FOREIGN KEY (`rental_Id`) REFERENCES `rental` (`rentalId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
ALTER TABLE `payment`
	ADD CONSTRAINT FOREIGN KEY (`customer_Id`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
ALTER TABLE `payment`
	ADD CONSTRAINT FOREIGN KEY (`staff_Id`) REFERENCES `staff` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;