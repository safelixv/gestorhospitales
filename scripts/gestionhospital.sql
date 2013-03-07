-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 07-03-2013 a las 11:20:43
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gestionhospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitaciones`
--

CREATE TABLE IF NOT EXISTS `habitaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `hospital_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `habitaciones`
--

INSERT INTO `habitaciones` (`id`, `numero`, `telefono`, `hospital_id`) VALUES
(1, 1, 1111, 1),
(2, 2, 2222, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hospital`
--

CREATE TABLE IF NOT EXISTS `hospital` (
  `Id` int(6) NOT NULL AUTO_INCREMENT,
  `Direccion` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Telefono` int(9) DEFAULT NULL,
  `Personal` varchar(255) DEFAULT NULL,
  `Salas` int(6) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `hospital`
--

INSERT INTO `hospital` (`Id`, `Direccion`, `Nombre`, `Telefono`, `Personal`, `Salas`) VALUES
(1, 'la fe', 'La fe', 32322, 'muchos', 3),
(2, 'blasco ibañez', 'quiron', 96582, 'pocos', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE IF NOT EXISTS `pacientes` (
  `Id` int(6) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) DEFAULT NULL,
  `Apellidos` varchar(255) DEFAULT NULL,
  `Telefono` int(9) DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `NSS` varchar(255) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `hospital_id` int(11) DEFAULT NULL,
  `habitacion_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`Id`, `Nombre`, `Apellidos`, `Telefono`, `Direccion`, `DNI`, `NSS`, `sexo`, `hospital_id`, `habitacion_id`) VALUES
(2, 'Jordi', 'Chisbert Perales', 622578245, 'c/isla cabrera', '22704877F', '12345678', NULL, 0, NULL),
(3, 'Alejandro', 'Riaza Ross', 632578245, 'c/bernat descoll', '23704877F', '13345678', NULL, 0, NULL),
(5, 'Miguel', 'Alonso Lopez', 652578245, 'c/Hermanos maristas', '25704877F', '15345678', NULL, 0, NULL),
(6, 'Richard', 'Gauto Ojeda', 662578245, 'c/la plata', '26704877F', '16345678', NULL, 0, NULL),
(13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL),
(14, 'aaa', 'aaa', 2123, '', '', '', '', 0, NULL),
(16, 'bbb', 'bbb', 123, '', '', '', '', 0, NULL),
(19, 'eee', 'eee', 231, '', '', '', '', 0, NULL),
(21, 'ggg', 'ggg', 123, '', '', 'null', '', 0, NULL),
(23, 'rr', 'rr', 123, 'rr', 'rr', 'rr', 'h', 1, NULL),
(24, 'joselito', 'perez', 958545, 'calle', '3232', '322', 'h', 1, NULL),
(25, 'el rey', 'borbon', 5655, 'madrid', '1', '1', 'H', NULL, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiene`
--

CREATE TABLE IF NOT EXISTS `tiene` (
  `Id_Paciente` int(6) NOT NULL,
  `Id_hospital` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
