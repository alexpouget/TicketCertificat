-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Dim 12 Juin 2016 à 22:29
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `Ticket_certificat`
--

-- --------------------------------------------------------

--
-- Structure de la table `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `adress` varchar(256) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `company`
--

INSERT INTO `company` (`id`, `name`, `adress`) VALUES
(1, 'Michax Company', '168 route de nangis');

-- --------------------------------------------------------

--
-- Structure de la table `computer`
--

CREATE TABLE `computer` (
  `id` int(11) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `computer`
--

INSERT INTO `computer` (`id`, `name`, `id_company`) VALUES
(1, 'PC4567W', 1);

-- --------------------------------------------------------

--
-- Structure de la table `license`
--

CREATE TABLE `license` (
  `id` int(11) NOT NULL,
  `type_license` int(11) DEFAULT NULL,
  `id_software` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `license`
--

INSERT INTO `license` (`id`, `type_license`, `id_software`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `license_owner`
--

CREATE TABLE `license_owner` (
  `id` int(11) NOT NULL,
  `date_debut` datetime DEFAULT NULL,
  `date_expiration` datetime DEFAULT NULL,
  `id_computer` int(11) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL,
  `id_license` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `license_owner`
--

INSERT INTO `license_owner` (`id`, `date_debut`, `date_expiration`, `id_computer`, `id_company`, `id_license`) VALUES
(1, '2016-06-12 00:00:00', '2016-07-22 00:00:00', 1, 1, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `software`
--

INSERT INTO `software` (`id`, `name`) VALUES
(1, 'Office');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `uid`, `email`, `password`, `id_company`) VALUES
(1, '997244', 'pouget@gmail.com', '$2a$04$16/UikoINtqcBCdvyZN6tebTeabJC9VHipGvZ8Fi8HCRVy9VeBlFO', 1),
(6, '222222', 'pazpaz@gma.com', '$2a$10$aX.oJhZR9WJh9dHJsSLRxuwftBlxA2F8owhWFesaf.1PvJXqNwLHK', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_role`
--

INSERT INTO `user_role` (`id`, `id_user`, `id_role`) VALUES
(1, 1, 1),
(7, 6, 3);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `computer`
--
ALTER TABLE `computer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `license`
--
ALTER TABLE `license`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `license_owner`
--
ALTER TABLE `license_owner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `software`
--
ALTER TABLE `software`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `type_license`
--
ALTER TABLE `type_license`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
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
