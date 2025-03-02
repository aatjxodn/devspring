-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.32 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- ceratrust 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `ceratrust` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ceratrust`;

-- 테이블 ceratrust.ct_catg_code_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_catg_code_info` (
  `CT_CATG_ID` char(20) DEFAULT NULL,
  `CT_CATG_CODE_ID` char(20) DEFAULT NULL,
  `CT_CATG_CODE_NAME` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='카테고리별 세부 정보';

-- 테이블 데이터 ceratrust.ct_catg_code_info:~0 rows (대략적) 내보내기

-- 테이블 ceratrust.ct_catg_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_catg_info` (
  `CT_CATG_ID` char(20) DEFAULT NULL,
  `CT_CATG_CODE` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_CATG_NAME` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='카테고리 정보';

-- 테이블 데이터 ceratrust.ct_catg_info:~0 rows (대략적) 내보내기

-- 테이블 ceratrust.ct_lnb 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_lnb` (
  `CT_LNB_IDX` int NOT NULL AUTO_INCREMENT,
  `CT_LNB_ID` char(20) DEFAULT NULL,
  `CT_LNB_NAME` char(20) DEFAULT NULL,
  `CT_LNB_SUB_YN` char(1) DEFAULT NULL,
  `CT_LNB_URL` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_LNB_USE_YN` char(20) DEFAULT NULL,
  `CT_LNB_AUTHORITY` char(10) DEFAULT NULL,
  `CT_LNB_CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`CT_LNB_IDX`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상단바';

-- 테이블 데이터 ceratrust.ct_lnb:~8 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_lnb` (`CT_LNB_IDX`, `CT_LNB_ID`, `CT_LNB_NAME`, `CT_LNB_SUB_YN`, `CT_LNB_URL`, `CT_LNB_USE_YN`, `CT_LNB_AUTHORITY`, `CT_LNB_CREATE_TIME`) VALUES
	(1, 'CT_LNB_HOME', 'Home', 'N', '/', 'Y', 'USER', '2025-02-12 07:54:53'),
	(2, 'CT_LNB_COMPANY', 'Company', 'Y', '', 'Y', 'USER', '2025-02-12 07:54:54'),
	(3, 'CT_LNB_SERVICE', 'Service', 'Y', '', 'Y', 'USER', '2025-02-12 07:54:54'),
	(4, 'CT_LNB_CONTACT', 'Contact', 'Y', '', 'Y', 'USER', '2025-02-12 07:54:55'),
	(5, 'CT_LNB_BOARD', 'board', 'N', '/board', 'N', 'USER', '2025-02-12 07:54:56'),
	(6, 'CT_LNB_ADMIN', 'Main', 'N', '/adminMain', 'Y', 'ADMIN', '2025-02-12 07:54:56'),
	(7, 'CT_LNB_ADMIN_TEST', 'Test', 'Y', '', 'Y', 'ADMIN', '2025-02-12 07:54:56'),
	(8, 'CT_LNB_ADMIN_NOTICE', 'Notice', 'N', '/notice', 'Y', 'ADMIN', '2025-02-12 07:54:56');

-- 테이블 ceratrust.ct_lnb_sub 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_lnb_sub` (
  `CT_LNB_SUB_IDX` int DEFAULT NULL,
  `CT_LNB_ID` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_LNB_SUB_ID` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_LNB_SUB_NAME` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_LNB_SUB_URL` char(20) DEFAULT NULL,
  `CT_LNB_SUB_CREATE_TIME` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='상단바';

-- 테이블 데이터 ceratrust.ct_lnb_sub:~9 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_lnb_sub` (`CT_LNB_SUB_IDX`, `CT_LNB_ID`, `CT_LNB_SUB_ID`, `CT_LNB_SUB_NAME`, `CT_LNB_SUB_URL`, `CT_LNB_SUB_CREATE_TIME`) VALUES
	(1, 'CT_LNB_CONTACT', 'CT_LNB_CONTACT_EMAIL', 'E-Mail', '/email', '2025-02-12 07:55:23'),
	(1, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE1', 'Service1', '/service1', '2025-02-12 07:55:24'),
	(2, 'CT_LNB_CONTACT', 'CT_LNB_CONTACT_LOCATION', 'Location', '/location', '2025-02-12 07:55:24'),
	(2, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE2', 'Service2', '/service2', '2025-02-12 07:55:25'),
	(3, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE3', 'Service3', '/service3', '2025-02-12 07:55:25'),
	(4, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE4', 'Service4', '/service4', '2025-02-12 07:55:26'),
	(1, 'CT_LNB_ADMIN_TEST', 'CT_LNB_ADMIN_TEST', 'TEST1', '/test1', '2025-02-12 07:55:27'),
	(1, 'CT_LNB_COMPANY', 'CT_LNB_COMPANY_ABOUT', 'About us', '/about', '2025-02-12 07:55:27'),
	(2, 'CT_LNB_ADMIN_TEST', 'CT_LNB_ADMIN_TEST2', 'TEST2', '/test2', '2025-02-12 07:55:27');

-- 테이블 ceratrust.ct_notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_notice` (
  `CT_NOTICE_IDX` int NOT NULL AUTO_INCREMENT,
  `CT_NOTICE_SUBJECT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_NOTICE_CONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CT_NOTICE_AUTHOR` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_NOTICE_MODIFIER` char(50) DEFAULT NULL,
  `CT_NOTICE_CREATE_TIME` datetime DEFAULT NULL,
  `CT_NOTICE_UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`CT_NOTICE_IDX`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='notice';

-- 테이블 데이터 ceratrust.ct_notice:~21 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_notice` (`CT_NOTICE_IDX`, `CT_NOTICE_SUBJECT`, `CT_NOTICE_CONTENT`, `CT_NOTICE_AUTHOR`, `CT_NOTICE_MODIFIER`, `CT_NOTICE_CREATE_TIME`, `CT_NOTICE_UPDATE_TIME`) VALUES
	(1, 'testr', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(76, 'testr', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(77, 'testr', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(78, 'testr', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(79, 'testr', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(80, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(81, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(82, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(83, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(84, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(85, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(86, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(87, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(88, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(89, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(90, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(91, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(92, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(93, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(94, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(95, '길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트길이테스트', '1', '1', '1', '2025-02-19 12:09:13', '2025-02-19 12:09:14'),
	(96, 'ㅁㄴㅇㅁㄴㅇ', '<p>ㅁㄴㅇㅁㄴㅇ</p>', '서태우', NULL, '2025-03-02 11:44:30', NULL),
	(97, 'ㅁㄴㅇㅁㄴㅇ', '<p>ㅁㄴㅇㅁㄴㅇㅁㄴㅇ</p>', '서태우', NULL, '2025-03-02 11:45:39', '2025-03-02 11:45:39'),
	(98, '하이이', '<p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span></p><p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;"></span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span></p><p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;"><br></span></p><p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;"><br></span></p><p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;"><br></span></p><p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;"><br></span></p><p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;"><br></span></p><p><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;"></span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span><span style="font-family: sans-serif; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400;">길이테스트</span></p>', '서태우', NULL, '2025-03-02 11:47:01', '2025-03-02 11:47:01'),
	(99, 'ㅁㄴㅇㅁㄴㅇㅁ', '<p>ㄴㅇㅁㄴㅇㅁㄴㅇ</p>', '서태우', '', '2025-03-02 11:48:35', '2025-03-02 11:48:35'),
	(100, 'ㅁㄴㄻㄴ', '<p>ㄻㄴㄻㄴㄻㄴㄹ</p>', '서태우', '', '2025-03-02 11:49:54', '2025-03-02 11:49:54'),
	(101, 'ㅁㄴㅇ', '<p>ㅁㄴㅇㅁㄴㅇㅁㄴㅇ</p>', '서태우', '', '2025-03-02 11:50:58', '2025-03-02 11:50:58'),
	(102, 'ㅎㅎ', '<p>ㅗ호호호</p>', '서태우', '', '2025-03-02 11:52:23', '2025-03-02 11:52:23'),
	(103, 'ㅁㄴㅇ', '<p>ㅁㄴㅇㅁㄴㅇ</p>', '서태우', '', '2025-03-02 11:54:24', '2025-03-02 11:54:24'),
	(104, 'ㅁㄴㅇㅁㄴㅇㅁㄴㅇ', '<p>ㅁㄴㅇㅁㄴㅁㄴㅇ</p>', '서태우', '', '2025-03-02 11:54:44', '2025-03-02 11:54:44'),
	(105, 'ㄴㅇㅎㄴㅇㅎ', '<p>ㄴㅇㅎㄴㅇㅎ</p>', '서태우', '', '2025-03-02 11:57:26', '2025-03-02 11:57:26'),
	(106, 'ㅁㄴㅇㅁㄴ', '<p>ㅇㅁㄴㅇ</p>', '서태우', '', '2025-03-02 11:57:37', '2025-03-02 11:57:37'),
	(107, 'ㄴㅇㅎㄴㅇㅎ', '<p>ㄴㅇㅎㄴㅇㅎ</p>', '서태우', '', '2025-03-02 11:58:50', '2025-03-02 11:58:50'),
	(108, 'ㄴㅇㅎㄴㅇㅎ', '<p>ㄴㅇㅎㄴㅇㅎ</p>', '서태우', '', '2025-03-02 11:59:14', '2025-03-02 11:59:14'),
	(109, 'ㅁㄴㅇㅁㄴ', '<p>ㅇㅁㄴㅇㅁㄴㅇ</p>', '서태우', '', '2025-03-02 12:27:27', '2025-03-02 12:27:27'),
	(110, 'dfgdfgdfg', '<p>dfgdfgdfg</p>', '서태우', '', '2025-03-02 12:31:39', '2025-03-02 12:31:39');

-- 테이블 ceratrust.ct_notice_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_notice_file` (
  `CT_NOTICE_FILE_IDX` int NOT NULL AUTO_INCREMENT,
  `CT_NOTICE_IDX` int DEFAULT NULL,
  `CT_NOTICE_FILE_ORIGINAL_NAME` char(100) DEFAULT NULL,
  `CT_NOTICE_FILE_SAVED_NAME` char(255) DEFAULT NULL,
  `CT_NOTICE_FILE_SAVED_PATH` char(255) DEFAULT NULL,
  `CT_NOTICE_FILE_CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`CT_NOTICE_FILE_IDX`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Notice File 저장소';

-- 테이블 데이터 ceratrust.ct_notice_file:~5 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_notice_file` (`CT_NOTICE_FILE_IDX`, `CT_NOTICE_IDX`, `CT_NOTICE_FILE_ORIGINAL_NAME`, `CT_NOTICE_FILE_SAVED_NAME`, `CT_NOTICE_FILE_SAVED_PATH`, `CT_NOTICE_FILE_CREATE_TIME`) VALUES
	(1, NULL, '2.png', '162662f2-36f2-4b26-9382-b5cd79d1ec7a.png', 'D:\\uploadTest\\162662f2-36f2-4b26-9382-b5cd79d1ec7a.png', NULL),
	(2, NULL, '1.png', 'b037355f-1079-4613-bae9-c33bf680c5ed.png', 'D:\\uploadTest\\b037355f-1079-4613-bae9-c33bf680c5ed.png', NULL),
	(3, NULL, '1.png', '0014f23d-94cd-478c-b265-cf0d31b619a2.png', 'D:\\uploadTest\\0014f23d-94cd-478c-b265-cf0d31b619a2.png', NULL),
	(4, NULL, '2.png', '8e34af98-eef0-414a-b03f-cb3d4356e361.png', 'D:\\uploadTest\\8e34af98-eef0-414a-b03f-cb3d4356e361.png', NULL),
	(5, NULL, '3.png', '667ea12d-8be8-4931-874f-1309c67b3312.png', 'D:\\uploadTest\\667ea12d-8be8-4931-874f-1309c67b3312.png', NULL);

-- 테이블 ceratrust.ct_user 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_user` (
  `CT_USER_IDX` int NOT NULL AUTO_INCREMENT,
  `CT_USER_ID` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CT_USER_PWD` char(100) NOT NULL,
  `CT_USER_NAME` char(20) NOT NULL,
  `CT_USER_EMAIL` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CT_USER_PHONE_NUMBER` char(20) NOT NULL,
  `CT_USER_AUTHORITY` enum('ADMIN','USER') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_USER_CREATE_TIME` datetime DEFAULT NULL,
  `CT_USER_UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`CT_USER_IDX`,`CT_USER_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원정보';

-- 테이블 데이터 ceratrust.ct_user:~3 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_user` (`CT_USER_IDX`, `CT_USER_ID`, `CT_USER_PWD`, `CT_USER_NAME`, `CT_USER_EMAIL`, `CT_USER_PHONE_NUMBER`, `CT_USER_AUTHORITY`, `CT_USER_CREATE_TIME`, `CT_USER_UPDATE_TIME`) VALUES
	(2, 'test', '$2a$10$n7r0ku9AjEmdoJx6m3VEyOnxneR8.Jkav46fc5drojarJRTCJ6mEa', 'tjxodn', 'tjxodn@naver.com', '010-1111-2222', 'ADMIN', '2025-02-11 19:15:18', '2025-02-11 19:15:18'),
	(3, 'test1', '$2a$10$50VLPQRgpKcQPEgXKOBsDeq7Tkbcs3f3qZQyG38F07QJlU5Q3Bzpq', 'tjxodn', 'tjxodn@naver.com', '010-1111-2222', 'ADMIN', '2025-02-11 19:17:16', '2025-02-11 19:17:16'),
	(4, 'tjxodn', '$2a$10$eJ1NS2rvYUsWH35epkQseemLJSH81vnUMGGjLA.xgA7ANd1ZFQNPW', 'tjxodn', 'tjxodn@naver.com', '010-1111-2222', 'ADMIN', '2025-02-11 19:18:17', '2025-02-11 19:18:17');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
