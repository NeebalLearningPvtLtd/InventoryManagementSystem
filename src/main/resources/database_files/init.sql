DROP DATABASE IF EXISTS ims;
CREATE database ims;
use ims;

--
-- Table structure for table `laptop`
--

CREATE TABLE `laptop` (
  `id` int(20) primary key NOT NULL AUTO_INCREMENT,
  `laptop_tag` varchar(255)  NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `model_num` varchar(15) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `battery_serial_num` varchar(255) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `warranty` tinyint(1) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `wifi` tinyint(1) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `processor` varchar(255) DEFAULT NULL,
  `hdd` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `laptopusedby`
--

CREATE TABLE `laptopusedby` (
  `id` int(20) primary key NOT NULL AUTO_INCREMENT,
  `laptop_id` int(20) ,
  `location` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  constraint `laptop_fk` FOREIGN key(`laptop_id`) REFERENCES `laptop`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------
--
-- Table structure for table `adapter`
--

CREATE TABLE `adapter` (
  `id` int(20) primary key NOT NULL AUTO_INCREMENT,
  `adapter_tag`  varchar(255)  NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `warranty` tinyint(1) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `adapterusedby`
--

CREATE TABLE `adapterusedby` (
  `id` int(20) primary key  NOT NULL AUTO_INCREMENT,
  `adapter_id` int(20) ,
  `location` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  constraint `adapter_fk` FOREIGN key(`adapter_id`) REFERENCES `adapter`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hdd`
--

CREATE TABLE `hdd` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `hdd_tag` varchar(255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `keyboard`
--

CREATE TABLE `keyboard` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `keyboard_tag` varchar (255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------



--
-- Table structure for table `monitor`
--

CREATE TABLE `monitor` (
  `id` int(20) NOT NULL PRIMARY key AUTO_INCREMENT,
  `monitor_tag` varchar(255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `resolution` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `motherboard`
--

CREATE TABLE `motherboard` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `motherboard_tag` varchar(255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mouse`
--

CREATE TABLE `mouse` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `mouse_tag` varchar(255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `conn_type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `powersupply`
--

CREATE TABLE `powersupply` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `powersupply_tag` varchar(255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ram`
--

CREATE TABLE `ram` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `ram_tag` varchar(255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wifi`
--

CREATE TABLE `wifi` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `wifi_tag` varchar(255) NOT NULL UNIQUE,
  `brand` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pc`
--

CREATE TABLE `pc` (
  `id` int(20) NOT NULL  PRIMARY key AUTO_INCREMENT,
  `pc_tag` varchar(255) NOT NULL UNIQUE,
  `ram_id` int(20) DEFAULT NULL,
  `hdd_id` int(20) DEFAULT NULL,
  `keyboard_id` int(20) DEFAULT NULL,
  `mouse_id` int(20) DEFAULT NULL,
  `powersupply_id` int(20) DEFAULT NULL,
  `wifi_id` int(20) DEFAULT NULL,
  `motherboard_id` int(20) DEFAULT NULL,
  `monitor_id` int(20) DEFAULT NULL,
  `processor` varchar(255) DEFAULT NULL,
  `vt` tinyint(1) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
   CONSTRAINT `hdd_fk` FOREIGN KEY (`hdd_id`) REFERENCES `hdd` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `keyboard_fk` FOREIGN KEY (`keyboard_id`) REFERENCES `keyboard` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `monitor_fk` FOREIGN KEY (`monitor_id`) REFERENCES `monitor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `motherboard_fk` FOREIGN KEY (`motherboard_id`) REFERENCES `motherboard` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `mouse_fk` FOREIGN KEY (`mouse_id`) REFERENCES `mouse` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `powersupply_fk` FOREIGN KEY (`powersupply_id`) REFERENCES `powersupply` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `ram_fk` FOREIGN KEY (`ram_id`) REFERENCES `ram` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT `wifi_fk` FOREIGN KEY (`wifi_id`) REFERENCES `wifi` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DELIMITER $$

CREATE TRIGGER `pc_insert_set_parts_used_to_1` AFTER INSERT ON `pc` 
 FOR EACH ROW 
 begin
update hdd set hdd.used=1 where hdd.id= new.hdd_id;
update ram set ram.used=1 where ram.id = new.ram_id;
update keyboard set keyboard.used=1 where keyboard.id = new.keyboard_id;
update mouse set mouse.used=1 where mouse.id = new.mouse_id;
update monitor set monitor.used=1 where monitor.id = new.monitor_id;
update powersupply set powersupply.used=1 where powersupply.id = new.powersupply_id;
update motherboard set motherboard.used=1 where motherboard.id = new.motherboard_id;
update wifi set wifi.used=1 where wifi.id = new.wifi_id;
end$$

CREATE TRIGGER `pc_delete_set_parts_used_to_0` AFTER DELETE ON `pc` 
 FOR EACH ROW 
 begin
update hdd set hdd.used=0 where hdd.id= old.hdd_id;
update ram set ram.used=0 where ram.id = old.ram_id;
update keyboard set keyboard.used=0 where keyboard.id = old.keyboard_id;
update mouse set mouse.used=0 where mouse.id = old.mouse_id;
update monitor set monitor.used=0 where monitor.id = old.monitor_id;
update powersupply set powersupply.used=0 where powersupply.id = old.powersupply_id;
update motherboard set motherboard.used=0 where motherboard.id = old.motherboard_id;
update wifi set wifi.used=0 where wifi.id = old.wifi_id;
end$$

CREATE TRIGGER `pc_update_set_respective_parts_used_to_0_or_1` AFTER update ON `pc` 
 FOR EACH ROW 
 begin
 if( (new.hdd_id <> old.hdd_id) or (old.hdd_id is null and new.hdd_id is not null ) or (new.hdd_id is null and old.hdd_id is not null ) ) then
 update hdd set hdd.used=0 where hdd.id= old.hdd_id;
 update hdd set hdd.used=1 where hdd.id= new.hdd_id;
end if;
if( (new.ram_id <> old.ram_id) or (old.ram_id is null and new.ram_id is not null ) or (new.ram_id is null and old.ram_id is not null )) then
update ram set ram.used=0 where ram.id = old.ram_id;
update ram set ram.used=1 where ram.id = new.ram_id;
end if;
if( (new.monitor_id <> old.monitor_id) or (old.monitor_id is null and new.monitor_id is not null ) or (new.monitor_id is null and old.monitor_id is not null )) then
update monitor set monitor.used=0 where monitor.id = old.monitor_id;
update monitor set monitor.used=1 where monitor.id = new.monitor_id;
end if;
if( (new.mouse_id <> old.mouse_id) or (old.mouse_id is null and new.mouse_id is not null ) or (new.mouse_id is null and old.mouse_id is not null )) then
update mouse set mouse.used=0 where mouse.id = old.mouse_id;
update mouse set mouse.used=1 where mouse.id = new.mouse_id;
end if;
if( (new.keyboard_id <> old.keyboard_id) or (old.keyboard_id is null and new.keyboard_id is not null ) or (new.keyboard_id is null and old.keyboard_id is not null )) then
update keyboard set keyboard.used=0 where keyboard.id = old.keyboard_id;
update keyboard set keyboard.used=1 where keyboard.id = new.keyboard_id;
end if;
if( (new.powersupply_id <> old.powersupply_id) or (old.powersupply_id is null and new.powersupply_id is not null ) or (new.powersupply_id is null and old.powersupply_id is not null )) then
update powersupply set powersupply.used=0 where powersupply.id = old.powersupply_id;
update powersupply set powersupply.used=1 where powersupply.id = new.powersupply_id;
end if;
if( (new.motherboard_id <> old.motherboard_id) or (old.motherboard_id is null and new.motherboard_id is not null ) or (new.motherboard_id is null and old.motherboard_id is not null )) then
update motherboard set motherboard.used=0 where motherboard.id = old.motherboard_id;
update motherboard set motherboard.used=1 where motherboard.id = new.motherboard_id;
end if;
if( (new.wifi_id <> old.wifi_id) or (old.wifi_id is null and new.wifi_id is not null ) or (new.wifi_id is null and old.wifi_id is not null )) then
update wifi set wifi.used=0 where wifi.id = old.wifi_id;
update wifi set wifi.used=1 where wifi.id = new.wifi_id;
end if;
end$$

DELIMITER ;


-- Audit tables

--
-- Table structure for table `adapterusedby_audit_log`
--

CREATE TABLE `adapterusedby_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `adapter_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `adapter_audit_log`
--

CREATE TABLE `adapter_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `adapter_tag` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `dop` datetime DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `warranty` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hdd_audit_log`
--

CREATE TABLE `hdd_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `hdd_tag` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `keyboard_audit_log`
--

CREATE TABLE `keyboard_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `keyboard_tag` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `laptopusedby_audit_log`
--

CREATE TABLE `laptopusedby_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `laptop_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `laptop_audit_log`
--

CREATE TABLE `laptop_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `battery_serial_num` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `dop` datetime DEFAULT NULL,
  `hdd` varchar(255) DEFAULT NULL,
  `laptop_tag` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `processor` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `vt` bit(1) DEFAULT NULL,
  `warranty` bit(1) DEFAULT NULL,
  `wifi` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `monitor_audit_log`
--

CREATE TABLE `monitor_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `monitor_tag` varchar(255) DEFAULT NULL,
  `resolution` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `motherboard_audit_log`
--

CREATE TABLE `motherboard_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `motherboard_tag` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL,
  `vt` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `mouse_audit_log`
--

CREATE TABLE `mouse_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `conn_type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `mouse_tag` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pc_audit_log`
--

CREATE TABLE `pc_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `pc_tag` varchar(255) DEFAULT NULL,
  `processor` varchar(255) DEFAULT NULL,
  `vt` bit(1) DEFAULT NULL,
  `hdd_id` bigint(20) DEFAULT NULL,
  `keyboard_id` bigint(20) DEFAULT NULL,
  `monitor_id` bigint(20) DEFAULT NULL,
  `motherboard_id` bigint(20) DEFAULT NULL,
  `mouse_id` bigint(20) DEFAULT NULL,
  `powersupply_id` bigint(20) DEFAULT NULL,
  `ram_id` bigint(20) DEFAULT NULL,
  `wifi_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `powersupply_audit_log`
--

CREATE TABLE `powersupply_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `powersupply_tag` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ram_audit_log`
--

CREATE TABLE `ram_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `ram_tag` varchar(255) DEFAULT NULL,
  `serial_num` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `revinfo`
--

CREATE TABLE `revinfo` (
  `rev` int(11) NOT NULL,
  `revtstmp` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `wifi_audit_log`
--

CREATE TABLE `wifi_audit_log` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `model_num` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL,
  `wifi_tag` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adapterusedby_audit_log`
--
ALTER TABLE `adapterusedby_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKn9pqto89quu0brqutvmkodvh6` (`rev`);

--
-- Indexes for table `adapter_audit_log`
--
ALTER TABLE `adapter_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKt91beef58wc90ur3nwm1hoevi` (`rev`);

--
-- Indexes for table `hdd_audit_log`
--
ALTER TABLE `hdd_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FK4wxofjp5d1e74dqke6emtb64g` (`rev`);

--
-- Indexes for table `keyboard_audit_log`
--
ALTER TABLE `keyboard_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKqdplijh4cuiguehns242k10r8` (`rev`);

--
-- Indexes for table `laptopusedby_audit_log`
--
ALTER TABLE `laptopusedby_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FK89semi46bmwi5gcfvfnnijny5` (`rev`);

--
-- Indexes for table `laptop_audit_log`
--
ALTER TABLE `laptop_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKesmmmndtp4h8gv1t7jsq55njy` (`rev`);

--
-- Indexes for table `monitor_audit_log`
--
ALTER TABLE `monitor_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FK8rwfb2q069156nebxwcnbpikg` (`rev`);

--
-- Indexes for table `motherboard_audit_log`
--
ALTER TABLE `motherboard_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKmp6tn2drvk518nvtccaohyjbj` (`rev`);

--
-- Indexes for table `mouse_audit_log`
--
ALTER TABLE `mouse_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKk38k7nfpev8yr4egim7o4b3gm` (`rev`);

--
-- Indexes for table `pc_audit_log`
--
ALTER TABLE `pc_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FK69x9hfdnbykb0ryc1yamd72da` (`rev`);

--
-- Indexes for table `powersupply_audit_log`
--
ALTER TABLE `powersupply_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKhf9qhogdnyec7a7wgehe2fi1` (`rev`);

--
-- Indexes for table `ram_audit_log`
--
ALTER TABLE `ram_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FKrb5dxer30ns7m8qjpplxvwje4` (`rev`);

--
-- Indexes for table `revinfo`
--
ALTER TABLE `revinfo`
  ADD PRIMARY KEY (`rev`);

--
-- Indexes for table `wifi_audit_log`
--
ALTER TABLE `wifi_audit_log`
  ADD PRIMARY KEY (`id`,`rev`),
  ADD KEY `FK1tmu6fj6c58s0ua21tydglu0x` (`rev`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `revinfo`
--
ALTER TABLE `revinfo`
  MODIFY `rev` int(11) NOT NULL AUTO_INCREMENT;
  
--
-- Constraints for dumped tables
--

--
-- Constraints for table `adapterusedby_audit_log`
--
ALTER TABLE `adapterusedby_audit_log`
  ADD CONSTRAINT `FKn9pqto89quu0brqutvmkodvh6` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `adapter_audit_log`
--
ALTER TABLE `adapter_audit_log`
  ADD CONSTRAINT `FKt91beef58wc90ur3nwm1hoevi` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `hdd_audit_log`
--
ALTER TABLE `hdd_audit_log`
  ADD CONSTRAINT `FK4wxofjp5d1e74dqke6emtb64g` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `keyboard_audit_log`
--
ALTER TABLE `keyboard_audit_log`
  ADD CONSTRAINT `FKqdplijh4cuiguehns242k10r8` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `laptopusedby_audit_log`
--
ALTER TABLE `laptopusedby_audit_log`
  ADD CONSTRAINT `FK89semi46bmwi5gcfvfnnijny5` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `laptop_audit_log`
--
ALTER TABLE `laptop_audit_log`
  ADD CONSTRAINT `FKesmmmndtp4h8gv1t7jsq55njy` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `monitor_audit_log`
--
ALTER TABLE `monitor_audit_log`
  ADD CONSTRAINT `FK8rwfb2q069156nebxwcnbpikg` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `motherboard_audit_log`
--
ALTER TABLE `motherboard_audit_log`
  ADD CONSTRAINT `FKmp6tn2drvk518nvtccaohyjbj` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `mouse_audit_log`
--
ALTER TABLE `mouse_audit_log`
  ADD CONSTRAINT `FKk38k7nfpev8yr4egim7o4b3gm` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `pc_audit_log`
--
ALTER TABLE `pc_audit_log`
  ADD CONSTRAINT `FK69x9hfdnbykb0ryc1yamd72da` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `powersupply_audit_log`
--
ALTER TABLE `powersupply_audit_log`
  ADD CONSTRAINT `FKhf9qhogdnyec7a7wgehe2fi1` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `ram_audit_log`
--
ALTER TABLE `ram_audit_log`
  ADD CONSTRAINT `FKrb5dxer30ns7m8qjpplxvwje4` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);

--
-- Constraints for table `wifi_audit_log`
--
ALTER TABLE `wifi_audit_log`
  ADD CONSTRAINT `FK1tmu6fj6c58s0ua21tydglu0x` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`);