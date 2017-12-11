DROP DATABASE IF EXISTS ims;
CREATE database ims;
use ims;

--
-- Table structure for table `laptop`
--

CREATE TABLE `laptop` (
  `id` int(20) primary key NOT NULL AUTO_INCREMENT,
  `laptop_tag` varchar(50)  NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `model_num` varchar(15) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `battery_serial_num` varchar(50) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `warranty` tinyint(1) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `wifi` tinyint(1) DEFAULT NULL,
  `ram` varchar(50) DEFAULT NULL,
  `processor` varchar(50) DEFAULT NULL,
  `hdd` varchar(50) DEFAULT NULL,
  `supplier` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `laptopusedby`
--

CREATE TABLE `laptopusedby` (
  `id` int(20) primary key NOT NULL AUTO_INCREMENT,
  `laptop_id` int(20)  UNIQUE,
  `usedby` varchar(50) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  constraint `laptop_fk` FOREIGN key(`laptop_id`) REFERENCES `laptop`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------
--
-- Table structure for table `adapter`
--

CREATE TABLE `adapter` (
  `id` int(20) primary key NOT NULL AUTO_INCREMENT,
  `adapter_tag`  varchar(50)  NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `model_num` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `warranty` tinyint(1) DEFAULT NULL,
  `supplier` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `adapterusedby`
--

CREATE TABLE `adapterusedby` (
  `id` int(20) primary key  NOT NULL AUTO_INCREMENT,
  `adapter_id` int(20) ,
  `usedby` varchar(50) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  constraint `adapter_fk` FOREIGN key(`adapter_id`) REFERENCES `adapter`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hdd`
--

CREATE TABLE `hdd` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `hdd_tag` varchar(50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `size` varchar(5) DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `keyboard`
--

CREATE TABLE `keyboard` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `keyboard_tag` varchar (50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------



--
-- Table structure for table `monitor`
--

CREATE TABLE `monitor` (
  `id` int(20) NOT NULL PRIMARY key AUTO_INCREMENT,
  `monitor_tag` varchar(50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `model_num` varchar(50) DEFAULT NULL,
  `resolution` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `motherboard`
--

CREATE TABLE `motherboard` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `motherboard_tag` varchar(50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `model_num` varchar(50) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mouse`
--

CREATE TABLE `mouse` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `mouse_tag` varchar(50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `conn_type` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `powersupply`
--

CREATE TABLE `powersupply` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `powersupply_tag` varchar(50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ram`
--

CREATE TABLE `ram` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `ram_tag` varchar(50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `serial_num` varchar(50) DEFAULT NULL,
  `size` varchar(5) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wifi`
--

CREATE TABLE `wifi` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `wifi_tag` varchar(50) NOT NULL UNIQUE,
  `brand` varchar(50) DEFAULT NULL,
  `model_num` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pc`
--

CREATE TABLE `pc` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `pc_tag` varchar(50) NOT NULL UNIQUE,
  `ram_id` int(20) DEFAULT NULL,
  `hdd_id` int(20) DEFAULT NULL,
  `keyboard_id` int(20) DEFAULT NULL,
  `mouse_id` int(20) DEFAULT NULL,
  `powersupply_id` int(20) DEFAULT NULL,
  `wifi_id` int(20) DEFAULT NULL,
  `motherboard_id` int(20) DEFAULT NULL,
  `monitor_id` int(20) DEFAULT NULL,
  `processor` varchar(50) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
   CONSTRAINT `hdd_fk` FOREIGN KEY (`hdd_id`) REFERENCES `hdd` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `keyboard_fk` FOREIGN KEY (`keyboard_id`) REFERENCES `keyboard` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `monitor_fk` FOREIGN KEY (`monitor_id`) REFERENCES `monitor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `motherboard_fk` FOREIGN KEY (`motherboard_id`) REFERENCES `motherboard` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `mouse_fk` FOREIGN KEY (`mouse_id`) REFERENCES `mouse` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `powersupply_fk` FOREIGN KEY (`powersupply_id`) REFERENCES `powersupply` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `ram_fk` FOREIGN KEY (`ram_id`) REFERENCES `ram` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `wifi_fk` FOREIGN KEY (`wifi_id`) REFERENCES `wifi` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
