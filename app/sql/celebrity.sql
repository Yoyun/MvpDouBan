/*
Navicat SQLite Data Transfer

Source Server         : Douban
Source Server Version : 30808
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 30808
File Encoding         : 65001

Date: 2017-01-17 22:49:26
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for celebrity
-- ----------------------------
DROP TABLE IF EXISTS "main"."celebrity";
CREATE TABLE "celebrity" (
"id"  TEXT NOT NULL,
"name"  TEXT,
"alt"  TEXT,
"avatars"  TEXT,
PRIMARY KEY ("id")
);
