-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mer 13 Juillet 2016 à 20:13
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `Ticket_certificat`
--
CREATE DATABASE IF NOT EXISTS `Ticket_certificat` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `Ticket_certificat`;

-- --------------------------------------------------------

--
-- Structure de la table `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `adress` varchar(256) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `company`
--

INSERT INTO `company` (`id`, `name`, `adress`) VALUES
(1, 'Michax Company', '168 route de nangizer'),
(2, 'Pouget computer', '18 rue du pommier 93700');

-- --------------------------------------------------------

--
-- Structure de la table `computer`
--

CREATE TABLE `computer` (
  `id` int(11) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `computer`
--

INSERT INTO `computer` (`id`, `name`, `id_company`) VALUES
(1, 'PC4567W', 1),
(2, 'PC456W', 2);

-- --------------------------------------------------------

--
-- Structure de la table `license`
--

CREATE TABLE `license` (
  `id` int(11) NOT NULL,
  `type_license` int(11) DEFAULT NULL,
  `id_software` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `license`
--

INSERT INTO `license` (`id`, `type_license`, `id_software`) VALUES
(1, 1, 1),
(10, 1, 2),
(14, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `license_owner`
--

CREATE TABLE `license_owner` (
  `id` int(11) NOT NULL,
  `date_debut` varchar(256) DEFAULT NULL,
  `date_expiration` varchar(256) DEFAULT NULL,
  `id_computer` int(11) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL,
  `id_license` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `license_owner`
--

INSERT INTO `license_owner` (`id`, `date_debut`, `date_expiration`, `id_computer`, `id_company`, `id_license`) VALUES
(1, '2016-06-12', '2016-23-07', 1, 1, 1),
(2, '2016-05-04', '2016-05-06', 1, 1, 1),
(3, '2016-05-04', '2017-01-07 ', 2, 2, 1),
(4, '2016-05-04', '2016-05-04', 2, 1, 14);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'comptable'),
(3, 'user');

-- --------------------------------------------------------

--
-- Structure de la table `software`
--

CREATE TABLE `software` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `software`
--

INSERT INTO `software` (`id`, `name`) VALUES
(1, 'Office'),
(2, 'Chromex');

-- --------------------------------------------------------

--
-- Structure de la table `type_license`
--

CREATE TABLE `type_license` (
  `id` int(11) NOT NULL,
  `type` varchar(64) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_license`
--

INSERT INTO `type_license` (`id`, `type`) VALUES
(1, 'Licence fixe'),
(2, 'Licence flottante');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `uid` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `uid`, `email`, `password`, `id_company`) VALUES
(1, '997244', 'pouget.al@gmail.com', '$2a$10$7/.gMiDDJG5oeyng1Y2M4.2lsIRgJ9lRugcqpirSFVvRFa0B7wCqS', NULL),
(7, 'GZAA', 'gabriel.zaafrani@gmail.com', '$2a$10$nz88rOZ4XoXYAa/093.VneFpIaCn3kEcwkhI/f.Fv.prZBMWYMPAu', 1),
(19, 'kk', 'kk@jmail.com', '$2a$10$TsLCTaKOLGq32pjhQGKC2.fM5o5wXphJfL.6ibtI7GlYvWXEBqAUC', 2),
(20, 'PP', 'pp@gmail.com', '$2a$10$a4YEeuPc2v3Ri.9vqu84buzUKCtxQVywA8xOWYBJ4qxLM3DIX3xtu', 2);

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_role`
--

INSERT INTO `user_role` (`id`, `id_user`, `id_role`) VALUES
(1, 1, 1),
(8, 7, 3),
(20, 19, 3),
(21, 20, 3);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `computer`
--
ALTER TABLE `computer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_computer_company` (`id_company`);

--
-- Index pour la table `license`
--
ALTER TABLE `license`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_license_software` (`id_software`),
  ADD KEY `fk_license_type` (`type_license`);

--
-- Index pour la table `license_owner`
--
ALTER TABLE `license_owner`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_license_owner` (`id_license`),
  ADD KEY `fk_license_owner_computer` (`id_computer`),
  ADD KEY `fk_license_owner_company` (`id_company`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `software`
--
ALTER TABLE `software`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_license`
--
ALTER TABLE `type_license`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_company` (`id_company`);

--
-- Index pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_role_user` (`id_user`),
  ADD KEY `fk_user_role_role` (`id_role`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `computer`
--
ALTER TABLE `computer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `license`
--
ALTER TABLE `license`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `license_owner`
--
ALTER TABLE `license_owner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `software`
--
ALTER TABLE `software`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `type_license`
--
ALTER TABLE `type_license`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT pour la table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `computer`
--
ALTER TABLE `computer`
  ADD CONSTRAINT `fk_computer_company` FOREIGN KEY (`id_company`) REFERENCES `company` (`id`);

--
-- Contraintes pour la table `license`
--
ALTER TABLE `license`
  ADD CONSTRAINT `fk_license_software` FOREIGN KEY (`id_software`) REFERENCES `software` (`id`),
  ADD CONSTRAINT `fk_license_type` FOREIGN KEY (`type_license`) REFERENCES `type_license` (`id`);

--
-- Contraintes pour la table `license_owner`
--
ALTER TABLE `license_owner`
  ADD CONSTRAINT `fk_license_owner` FOREIGN KEY (`id_license`) REFERENCES `license` (`id`),
  ADD CONSTRAINT `fk_license_owner_company` FOREIGN KEY (`id_company`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `fk_license_owner_computer` FOREIGN KEY (`id_computer`) REFERENCES `computer` (`id`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_company` FOREIGN KEY (`id_company`) REFERENCES `company` (`id`);

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_user_role_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `fk_user_role_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
