/*
Navicat MySQL Data Transfer

Source Server         : 192.168.4.155
Source Server Version : 50626
Source Host           : 192.168.4.155:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-11-21 21:25:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cfg_servers
-- ----------------------------
DROP TABLE IF EXISTS `cfg_servers`;
CREATE TABLE `cfg_servers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `server` varchar(255) DEFAULT NULL,
  `servername` varchar(255) DEFAULT NULL,
  `port` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
