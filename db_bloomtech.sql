-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-12-2021 a las 19:36:52
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_bloomtech`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bono`
--

CREATE TABLE `bono` (
  `id_bono` bigint(20) NOT NULL,
  `nivel_bono` double DEFAULT NULL,
  `nombre_bono` varchar(50) DEFAULT NULL,
  `porcentaje_bono` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganancia`
--

CREATE TABLE `ganancia` (
  `id_ganancia` bigint(20) NOT NULL,
  `fecha_ganancia` date DEFAULT NULL,
  `g_bono` double DEFAULT NULL,
  `g_rango` double DEFAULT NULL,
  `usuario_id_usuario` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganancias_participacion`
--

CREATE TABLE `ganancias_participacion` (
  `id_equipo` bigint(20) NOT NULL,
  `precio_uvad` double DEFAULT NULL,
  `usd_apostado` double DEFAULT NULL,
  `uvad_obtenido` double DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganancia_nivel`
--

CREATE TABLE `ganancia_nivel` (
  `id_gan_nivel` bigint(20) NOT NULL,
  `uvad_obtenido` double DEFAULT NULL,
  `depositar_uvad` double DEFAULT NULL,
  `depositar_dolar` double DEFAULT NULL,
  `moneda` varchar(255) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganancia_nivelparticipacion`
--

CREATE TABLE `ganancia_nivelparticipacion` (
  `id_ganancia_nivel` bigint(20) NOT NULL,
  `dolar` double DEFAULT NULL,
  `uvad` double DEFAULT NULL,
  `a_quien_usuario` varchar(255) DEFAULT NULL,
  `de_quien_usuario` varchar(255) DEFAULT NULL,
  `fecha_ganancia` date DEFAULT NULL,
  `nivel` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hijo`
--

CREATE TABLE `hijo` (
  `id_hijo` bigint(20) NOT NULL,
  `fecha_creacion` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `hijo_id` bigint(20) DEFAULT NULL,
  `padre_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `padre`
--

CREATE TABLE `padre` (
  `id_padre` bigint(20) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premio`
--

CREATE TABLE `premio` (
  `id_premio` bigint(20) NOT NULL,
  `bono_id_bono` bigint(20) NOT NULL,
  `ganancia_id_ganancia` bigint(20) NOT NULL,
  `usuario_id_usuario` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rango`
--

CREATE TABLE `rango` (
  `id_rango` bigint(20) NOT NULL,
  `maximo_red` double DEFAULT NULL,
  `minimo_red` double DEFAULT NULL,
  `nivel_rango` double DEFAULT NULL,
  `nombre_rango` varchar(50) DEFAULT NULL,
  `numero_red` double DEFAULT NULL,
  `porcentage_rango` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `red`
--

CREATE TABLE `red` (
  `id_red` bigint(20) NOT NULL,
  `fecha_creacion` varchar(50) DEFAULT NULL,
  `nivel` bigint(20) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `hijo_id` bigint(20) DEFAULT NULL,
  `padre_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_ganancia_niveles`
--

CREATE TABLE `registro_ganancia_niveles` (
  `id_registro` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `id_transaccion` bigint(20) NOT NULL,
  `fecha_transaccion` date DEFAULT NULL,
  `tipo_transaccion` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `usuario` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL,
  `dni` bigint(20) DEFAULT NULL,
  `clave_invitacion` varchar(20) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `fecha_modificacion` date DEFAULT NULL,
  `foto` longblob DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `rango` varchar(50) DEFAULT NULL,
  `rol` varchar(15) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_login`
--

CREATE TABLE `usuario_login` (
  `id_usuario` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bono`
--
ALTER TABLE `bono`
  ADD PRIMARY KEY (`id_bono`);

--
-- Indices de la tabla `ganancia`
--
ALTER TABLE `ganancia`
  ADD PRIMARY KEY (`id_ganancia`),
  ADD KEY `FKe251nkowaiuitv4p6nw70dbas` (`usuario_id_usuario`);

--
-- Indices de la tabla `ganancias_participacion`
--
ALTER TABLE `ganancias_participacion`
  ADD PRIMARY KEY (`id_equipo`);

--
-- Indices de la tabla `ganancia_nivel`
--
ALTER TABLE `ganancia_nivel`
  ADD PRIMARY KEY (`id_gan_nivel`);

--
-- Indices de la tabla `ganancia_nivelparticipacion`
--
ALTER TABLE `ganancia_nivelparticipacion`
  ADD PRIMARY KEY (`id_ganancia_nivel`);

--
-- Indices de la tabla `hijo`
--
ALTER TABLE `hijo`
  ADD PRIMARY KEY (`id_hijo`),
  ADD KEY `FKsntbsiiuwfgy4nwcioif910vv` (`hijo_id`),
  ADD KEY `FKna8ags5jlp4seeygixi23icmu` (`padre_id`);

--
-- Indices de la tabla `padre`
--
ALTER TABLE `padre`
  ADD PRIMARY KEY (`id_padre`),
  ADD UNIQUE KEY `UK_9sb3fouu2bimcmhsp1id74kf1` (`usuario`);

--
-- Indices de la tabla `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`id_premio`),
  ADD KEY `FKbj36rycldqpyur08oaw22ns58` (`bono_id_bono`),
  ADD KEY `FKhledvx4oryomsrwa3qtoei1hl` (`ganancia_id_ganancia`),
  ADD KEY `FKn2r0srscviqkl5t6b5fqc0mrp` (`usuario_id_usuario`);

--
-- Indices de la tabla `rango`
--
ALTER TABLE `rango`
  ADD PRIMARY KEY (`id_rango`);

--
-- Indices de la tabla `red`
--
ALTER TABLE `red`
  ADD PRIMARY KEY (`id_red`),
  ADD KEY `FKewuvunmy8a2vwoi76h7gium6p` (`hijo_id`),
  ADD KEY `FKl73h9bm87157xu595960i8kcj` (`padre_id`);

--
-- Indices de la tabla `registro_ganancia_niveles`
--
ALTER TABLE `registro_ganancia_niveles`
  ADD PRIMARY KEY (`id_registro`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`id_transaccion`),
  ADD KEY `FK23mqxuafvspcnkggihemxjrm2` (`usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `UK_ma71x4n4tydibsd9qt0m71le7` (`dni`),
  ADD UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  ADD UNIQUE KEY `UK_i02kr8ui5pqddyd7pkm3v4jbt` (`usuario`);

--
-- Indices de la tabla `usuario_login`
--
ALTER TABLE `usuario_login`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bono`
--
ALTER TABLE `bono`
  MODIFY `id_bono` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ganancia`
--
ALTER TABLE `ganancia`
  MODIFY `id_ganancia` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ganancias_participacion`
--
ALTER TABLE `ganancias_participacion`
  MODIFY `id_equipo` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ganancia_nivel`
--
ALTER TABLE `ganancia_nivel`
  MODIFY `id_gan_nivel` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ganancia_nivelparticipacion`
--
ALTER TABLE `ganancia_nivelparticipacion`
  MODIFY `id_ganancia_nivel` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `hijo`
--
ALTER TABLE `hijo`
  MODIFY `id_hijo` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `padre`
--
ALTER TABLE `padre`
  MODIFY `id_padre` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `premio`
--
ALTER TABLE `premio`
  MODIFY `id_premio` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rango`
--
ALTER TABLE `rango`
  MODIFY `id_rango` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `red`
--
ALTER TABLE `red`
  MODIFY `id_red` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `registro_ganancia_niveles`
--
ALTER TABLE `registro_ganancia_niveles`
  MODIFY `id_registro` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `id_transaccion` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario_login`
--
ALTER TABLE `usuario_login`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
