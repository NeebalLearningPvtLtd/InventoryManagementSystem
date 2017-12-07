DROP DATABASE IF EXISTS ims1;
CREATE database ims1;
use ims1;

--
-- Table structure for table `laptop`
--

CREATE TABLE `laptop` (
  `id` int(11) primary key NOT NULL AUTO_INCREMENT,
  `laptoptag` varchar(20)  NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `model_num` varchar(15) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `batteryserial_num` varchar(20) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `warranty` tinyint(1) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `wifi` tinyint(1) DEFAULT NULL,
  `ram` varchar(5) DEFAULT NULL,
  `processor` varchar(20) DEFAULT NULL,
  `hdd` varchar(5) DEFAULT NULL,
  `supplier` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `laptopusedby`
--

CREATE TABLE `laptopusedby` (
  `id` int(11) primary key NOT NULL AUTO_INCREMENT,
  `laptop_id` int(11)  UNIQUE,
  `usedby` varchar(20) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  constraint `laptop_fk` FOREIGN key(`laptop_id`) REFERENCES `laptop`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------
--
-- Table structure for table `adapter`
--

CREATE TABLE `adapter` (
  `id` int(11) primary key NOT NULL AUTO_INCREMENT,
  `adaptertag`  varchar(20)  NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `model_num` varchar(20) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `warranty` tinyint(1) DEFAULT NULL,
  `supplier` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `adapterusedby`
--

CREATE TABLE `adapterusedby` (
  `id` int(11) primary key  NOT NULL AUTO_INCREMENT,
  `adapter_id` int(11) ,
  `usedby` varchar(20) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  constraint `adapter_fk` FOREIGN key(`adapter_id`) REFERENCES `adapter`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hdd`
--

CREATE TABLE `hdd` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `hddtag` varchar(20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `size` varchar(5) DEFAULT NULL,
  `TYPE` varchar(10) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `keyboard`
--

CREATE TABLE `keyboard` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `keyboardtag` varchar (20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------



--
-- Table structure for table `monitor`
--

CREATE TABLE `monitor` (
  `id` int(11) NOT NULL PRIMARY key AUTO_INCREMENT,
  `monitortag` varchar(20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `model_num` varchar(20) DEFAULT NULL,
  `resolution` varchar(10) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `motherboard`
--

CREATE TABLE `motherboard` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `motherboardtag` varchar(20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `model_num` varchar(20) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mouse`
--

CREATE TABLE `mouse` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `mousetag` varchar(20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `conntype` varchar(10) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `powersupply`
--

CREATE TABLE `powersupply` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `powersupplytag` varchar(20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ram`
--

CREATE TABLE `ram` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `ramtag` varchar(20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `serial_num` varchar(20) DEFAULT NULL,
  `size` varchar(5) DEFAULT NULL,
  `TYPE` varchar(10) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wifi`
--

CREATE TABLE `wifi` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `wifitag` varchar(20) NOT NULL UNIQUE,
  `brand` varchar(10) DEFAULT NULL,
  `model_num` varchar(20) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pc`
--

CREATE TABLE `pc` (
  `id` int(11) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `pctag` varchar(20) NOT NULL UNIQUE,
  `ram_id` int(11) DEFAULT NULL,
  `hdd_id` int(11) DEFAULT NULL,
  `keyboard_id` int(11) DEFAULT NULL,
  `mouse_id` int(11) DEFAULT NULL,
  `powersupply_id` int(11) DEFAULT NULL,
  `wifi_id` int(11) DEFAULT NULL,
  `motherboard_id` int(11) DEFAULT NULL,
  `monitor_id` int(11) DEFAULT NULL,
  `processor` varchar(20) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
   CONSTRAINT `hdd_fk` FOREIGN KEY (`hdd_id`) REFERENCES `hdd` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `keyboard_fk` FOREIGN KEY (`keyboard_id`) REFERENCES `keyboard` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `monitor_fk` FOREIGN KEY (`monitor_id`) REFERENCES `monitor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `motherboard_fk` FOREIGN KEY (`motherboard_id`) REFERENCES `motherboard` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `mouse_fk` FOREIGN KEY (`mouse_id`) REFERENCES `mouse` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `powersupply_fk` FOREIGN KEY (`powersupply_id`) REFERENCES `powersupply` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `ram_fk` FOREIGN KEY (`ram_id`) REFERENCES `ram` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `wifi_fk` FOREIGN KEY (`wifi_id`) REFERENCES `wifi` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
