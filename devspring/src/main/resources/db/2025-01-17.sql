-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.32 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.4.0.6659
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

-- 테이블 ceratrust.ct_board 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_board` (
  `CT_BOARD_IDX` int NOT NULL AUTO_INCREMENT,
  `CT_BOARD_ID` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_BOARD_SUBJECT` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_BOARD_NAME` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_BOARD_CREATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`CT_BOARD_IDX`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='상단바';

-- 테이블 데이터 ceratrust.ct_board:~42 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_board` (`CT_BOARD_IDX`, `CT_BOARD_ID`, `CT_BOARD_SUBJECT`, `CT_BOARD_NAME`, `CT_BOARD_CREATE_DATE`) VALUES
	(1, 'CT_LNB_HOME', 'Home', 'N', '2025-01-01 22:38:48'),
	(2, 'CT_LNB_INFORMATION', 'Information', 'Y', '2025-01-01 22:38:48'),
	(3, 'CT_LNB_SERVICE', 'Service', 'Y', '2025-01-01 22:38:48'),
	(4, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(36, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(37, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(38, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(39, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(40, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(41, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(42, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(43, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(44, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(45, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(46, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(47, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(48, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(49, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(50, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(51, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(52, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(53, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(54, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(55, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(56, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(57, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(58, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(59, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(60, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(61, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(62, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(63, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(64, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(65, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(66, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(67, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(68, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(69, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(70, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(71, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(72, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(73, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(74, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48'),
	(75, 'CT_LNB_CONTACT', 'Contact', 'Y', '2025-01-01 22:38:48');

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
  PRIMARY KEY (`CT_LNB_IDX`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상단바';

-- 테이블 데이터 ceratrust.ct_lnb:~5 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_lnb` (`CT_LNB_IDX`, `CT_LNB_ID`, `CT_LNB_NAME`, `CT_LNB_SUB_YN`, `CT_LNB_URL`, `CT_LNB_USE_YN`) VALUES
	(1, 'CT_LNB_HOME', 'Home', 'N', '/', 'Y'),
	(2, 'CT_LNB_COMPANY', 'Company', 'Y', '', 'Y'),
	(3, 'CT_LNB_SERVICE', 'Service', 'Y', '', 'Y'),
	(4, 'CT_LNB_CONTACT', 'Contact', 'Y', '', 'Y'),
	(5, 'CT_LNB_BOARD', 'board', 'N', '/board', 'N');

-- 테이블 ceratrust.ct_lnb_sub 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_lnb_sub` (
  `CT_LNB_SUB_IDX` int DEFAULT NULL,
  `CT_LNB_ID` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_LNB_SUB_ID` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_LNB_SUB_NAME` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CT_LNB_SUB_URL` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='상단바';

-- 테이블 데이터 ceratrust.ct_lnb_sub:~6 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_lnb_sub` (`CT_LNB_SUB_IDX`, `CT_LNB_ID`, `CT_LNB_SUB_ID`, `CT_LNB_SUB_NAME`, `CT_LNB_SUB_URL`) VALUES
	(1, 'CT_LNB_CONTACT', 'CT_LNB_CONTACT_EMAIL', 'E-Mail', '/email'),
	(1, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE1', 'Service1', '/service1'),
	(2, 'CT_LNB_CONTACT', 'CT_LNB_CONTACT_LOCATION', 'Location', '/location'),
	(2, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE2', 'Service2', '/service2'),
	(3, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE3', 'Service3', '/service3'),
	(4, 'CT_LNB_SERVICE', 'CT_LNB_SERVICE_SERVICE4', 'Service4', '/service4'),
	(1, 'CT_LNB_COMPANY', 'CT_LNB_COMPANY_ABOUT', 'About us', '/about');

-- 테이블 ceratrust.ct_member 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct_member` (
  `CT_MEMBER_IDX` int NOT NULL AUTO_INCREMENT,
  `CT_MEMBER_NAME` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`CT_MEMBER_IDX`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원정보';

-- 테이블 데이터 ceratrust.ct_member:~1 rows (대략적) 내보내기
INSERT IGNORE INTO `ct_member` (`CT_MEMBER_IDX`, `CT_MEMBER_NAME`) VALUES
	(1, '서태우');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
