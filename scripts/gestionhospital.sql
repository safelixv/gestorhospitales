-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-02-2013 a las 13:12:11
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
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE IF NOT EXISTS `especialidad` (
  `Id_especialidad` int(6) NOT NULL,
  `Nombre_especialidad` varchar(255) NOT NULL,
  `Sala_especialidad` int(6) NOT NULL,
  `Personal_especialidad` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hospital`
--

CREATE TABLE IF NOT EXISTS `hospital` (
  `Id_hospital` int(6) NOT NULL,
  `Direccion_hospital` varchar(255) NOT NULL,
  `Nombre_hospital` varchar(255) NOT NULL,
  `Telefono_hospital` int(9) NOT NULL,
  `Personal_hospital` varchar(255) NOT NULL,
  `Salas_hospital` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE IF NOT EXISTS `pacientes` (
  `Id` int(6) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `DNI` varchar(255) NOT NULL,
  `NSS` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`Id`, `Nombre`, `Apellidos`, `Telefono`, `Direccion`, `DNI`, `NSS`) VALUES
(1, 'Cristian', 'Trives Gil', 612578245, 'c/mmlilla', '21704877F', '11345678'),
(2, 'Jordi', 'Chisbert Perales', 622578245, 'c/isla cabrera', '22704877F', '12345678'),
(3, 'Alejandro', 'Riaza Ross', 632578245, 'c/bernat descoll', '23704877F', '13345678'),
(4, 'Guillermo', 'Porras Gomez', 642578245, 'c/Audsias march', '2704877F', '14345678'),
(5, 'Miguel', 'Alonso Lopez', 652578245, 'c/Hermanos maristas', '25704877F', '15345678'),
(6, 'Richard', 'Gauto Ojeda', 662578245, 'c/la plata', '26704877F', '16345678');

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
