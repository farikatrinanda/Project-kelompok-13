-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Nov 2021 pada 19.06
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` varchar(60) NOT NULL,
  `author` varchar(30) NOT NULL,
  `publisher` varchar(30) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `book`
--

INSERT INTO `book` (`id`, `title`, `author`, `publisher`, `created_at`) VALUES
(1, 'Hujan', 'Tere Liye', 'Grrr', '2021-10-13 00:07:53');

-- --------------------------------------------------------

--
-- Struktur dari tabel `borrow`
--

CREATE TABLE `borrow` (
  `id` int(11) NOT NULL,
  `id_member` int(11) NOT NULL,
  `id_book` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `date_borrow` date NOT NULL,
  `due_date` date NOT NULL,
  `date_return` date NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(60) NOT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `member`
--

INSERT INTO `member` (`id`, `name`, `address`, `phone`, `created_at`) VALUES
(1, 'lala', 'jl kusuma jaya no 16', '12345678', '2021-10-12 23:12:26'),
(2, 'lili', 'jl sukma indah', '19823456', '2021-10-12 23:18:17'),
(3, 'lulu', 'jl indah jaya ', '081234567890', '2021-10-12 23:19:06'),
(4, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-04 20:31:15'),
(5, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-04 20:57:39'),
(6, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-04 21:05:49'),
(7, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-04 22:00:53'),
(8, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-04 22:41:18'),
(9, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-04 23:42:06'),
(10, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-04 23:57:59'),
(11, 'Rara', 'jl Cendrawasih no 30', '01234567', '2021-11-05 00:02:06');

-- --------------------------------------------------------

--
-- Struktur dari tabel `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `status`
--

INSERT INTO `status` (`id`, `name`, `description`, `created_at`) VALUES
(1, 'borrowed', NULL, '2021-10-12 21:24:33'),
(2, 'returned', NULL, '2021-10-12 21:24:33');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` text NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `created_at`) VALUES
(2, 'sasa', 'sasa@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '2021-11-02 21:12:05'),
(3, 'sasa', 'sasa@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '2021-11-02 21:52:07'),
(4, 'sasa', 'sasa@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '2021-11-02 22:01:31'),
(5, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-02 22:06:54'),
(6, 'lili', 'lili@gmail.com', '9e1e06ec8e02f0a0074f2fcc6b26303b', '2021-11-03 21:12:11'),
(7, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 20:57:44'),
(8, '', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 20:57:46'),
(9, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 20:57:46'),
(10, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 21:05:50'),
(11, '', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 21:05:52'),
(12, 'Nana', '1nd80sm8ztasxkqrggnt@mail.com', '74293a8d63eb5b0dcb0f256e76d54e20', '2021-11-04 21:41:18'),
(13, 'Nana', '', '06e8a10d2dd6416b9050e22e844d9973', '2021-11-04 21:41:19'),
(14, 'Nana', '8bsjochub6mfvozogo7r@mail.com', '03f5bd407f27c6c9b2b6d3ba4a84d033', '2021-11-04 21:44:03'),
(15, 'Nana', '4mzkddyedda0fnblvdqk@mail.com', '84dfed50c2b159c760e13db25198e033', '2021-11-04 21:50:08'),
(16, 'nana', '', '5345eefc1b5144c8108b14aa8e282e1f', '2021-11-04 21:50:08'),
(17, 'Nana', 'zkrodnw7a974mgvnvnwk@mail.com', '6bc99f105001f426a3b8420d26610fba', '2021-11-04 21:53:08'),
(18, 'Nana', 'ont5p1wya5jvnsllcbmb@mail.com', 'b5eaefc4d907af6d35e123ff67c2943c', '2021-11-04 21:54:55'),
(19, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:00:55'),
(20, '', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:00:55'),
(21, 'Nana', 'uenagtbbimnnwudhopze@mail.com', '124d3a066ed6a6589ee4e47dd01982c5', '2021-11-04 22:01:01'),
(22, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:21:09'),
(23, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:26:10'),
(24, 'nana', 'rishyardah@mail.com', 'd41d8cd98f00b204e9800998ecf8427e', '2021-11-04 22:32:43'),
(25, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:32:46'),
(26, 'nana', 'sxk59lj7vi@mail.com', 'd41d8cd98f00b204e9800998ecf8427e', '2021-11-04 22:35:58'),
(27, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:35:59'),
(28, 'nana', 'e4mdldoxkn@mail.com', 'd41d8cd98f00b204e9800998ecf8427e', '2021-11-04 22:39:16'),
(29, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:39:16'),
(30, 'nana', '', '9549e53fc97d1a464843eeeb4ee57109', '2021-11-04 22:39:16'),
(31, '', 'mjjpspdwyw@mail.com', 'ff48b7a0150a6c748e49627506b530ce', '2021-11-04 22:39:16'),
(32, 'nana', 'iqswamohxp@mail.com', 'd41d8cd98f00b204e9800998ecf8427e', '2021-11-04 22:41:19'),
(33, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 22:41:20'),
(34, 'nana', '', '4557104161890fd87a7da9bece75da8e', '2021-11-04 22:41:21'),
(35, '', '7aiye75ggs@mail.com', 'd6d62129e247ed646eefeb269e3f5c61', '2021-11-04 22:41:21'),
(36, 'Nana', 'hg092ylp4hxckau9qim6@mail.com', '03a809730605278e5c187dc733069e42', '2021-11-04 22:41:27'),
(37, 'nana', '6qyinrbncj@mail.com', 'd41d8cd98f00b204e9800998ecf8427e', '2021-11-04 23:42:15'),
(38, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 23:42:16'),
(39, 'nana', '', 'b9840802b25e34d55d415f6ab82a8fc3', '2021-11-04 23:42:16'),
(40, '', 'ht9tszkdno@mail.com', '181773f02e940c6527f7e0ecfc482383', '2021-11-04 23:42:16'),
(41, 'Nana', 'vwbcq0opfi2fcbrmvgvq@mail.com', '17f41a7bb8fc8afdd0a44f38a78e2f77', '2021-11-04 23:42:24'),
(42, 'nana', 'i60an57cqy@mail.com', 'd41d8cd98f00b204e9800998ecf8427e', '2021-11-04 23:58:02'),
(43, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-04 23:58:02'),
(44, 'nana', '', '38654956f330d359c8fc43724886eb30', '2021-11-04 23:58:02'),
(45, '', '9hgelgpb9x@mail.com', 'dfed61c2ca9a0ae09d8b1f5df45be653', '2021-11-04 23:58:02'),
(46, 'Nana', '5nvlt1bcqtobz14ezrae@mail.com', 'dd91987bb67a054d158cd355aceb0d1d', '2021-11-04 23:58:07'),
(47, 'nana', 'i4iba0de7j@mail.com', 'd41d8cd98f00b204e9800998ecf8427e', '2021-11-05 00:02:06'),
(48, 'nana', 'nana@gmail.com', '202cb962ac59075b964b07152d234b70', '2021-11-05 00:02:07'),
(49, 'nana', '', '5c32f93cec743861bd2ba6e14e025a58', '2021-11-05 00:02:07'),
(50, '', '0trurb4ndr@mail.com', 'b450ff5936efc001f5f0356e8d1a86de', '2021-11-05 00:02:07'),
(51, 'Nana', 'vixsr2aa3ln3i4dcvlfi@mail.com', 'da49050e9362e2cd575ef99f0283ff9d', '2021-11-05 00:02:12');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_member` (`id_member`),
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_status` (`id_status`);

--
-- Indeks untuk tabel `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `borrow`
--
ALTER TABLE `borrow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `borrow`
--
ALTER TABLE `borrow`
  ADD CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`),
  ADD CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `borrow_ibfk_3` FOREIGN KEY (`id_status`) REFERENCES `status` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
