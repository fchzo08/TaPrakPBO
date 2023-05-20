-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Bulan Mei 2023 pada 20.13
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkir`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `passwword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama`, `username`, `passwword`) VALUES
(1, 'budi', 'budi', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiket`
--

CREATE TABLE `tiket` (
  `id_tiket` int(11) NOT NULL,
  `waktu_masuk` datetime NOT NULL,
  `waktu_keluar` datetime DEFAULT '0001-01-01 01:01:01',
  `kendaraan` varchar(255) DEFAULT NULL,
  `tarif` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tiket`
--

INSERT INTO `tiket` (`id_tiket`, `waktu_masuk`, `waktu_keluar`, `kendaraan`, `tarif`) VALUES
(1, '2023-05-20 13:12:48', '0001-01-01 01:01:01', NULL, NULL),
(2, '2023-05-20 13:16:58', '0001-01-01 01:01:01', NULL, NULL),
(3, '2023-05-20 13:18:12', '0001-01-01 01:01:01', NULL, NULL),
(4, '2023-05-20 13:27:20', '0001-01-01 01:01:01', NULL, NULL),
(5, '2023-05-20 13:29:54', '0001-01-01 01:01:01', NULL, NULL),
(6, '2023-05-20 13:31:32', '0001-01-01 01:01:01', NULL, NULL),
(7, '2023-05-20 13:32:16', '0001-01-01 01:01:01', NULL, NULL),
(8, '2023-05-20 13:37:22', '0001-01-01 01:01:01', NULL, NULL),
(9, '2023-05-20 13:38:24', '0001-01-01 01:01:01', NULL, NULL),
(10, '2023-05-20 13:38:48', '0001-01-01 01:01:01', NULL, NULL),
(11, '2023-05-20 13:40:15', '0001-01-01 01:01:01', NULL, NULL),
(12, '2023-05-20 13:41:01', '0001-01-01 01:01:01', NULL, NULL),
(13, '2023-05-20 13:47:05', '0001-01-01 01:01:01', NULL, NULL),
(14, '2023-05-20 13:47:33', '0001-01-01 01:01:01', NULL, NULL),
(15, '2023-05-20 13:48:15', '0001-01-01 01:01:01', NULL, NULL),
(16, '2023-05-20 13:48:18', '0001-01-01 01:01:01', NULL, NULL),
(17, '2023-05-20 13:48:19', '0001-01-01 01:01:01', NULL, NULL),
(18, '2023-05-20 13:48:19', '0001-01-01 01:01:01', NULL, NULL),
(19, '2023-05-20 13:48:19', '0001-01-01 01:01:01', NULL, NULL),
(20, '2023-05-20 13:48:19', '0001-01-01 01:01:01', NULL, NULL),
(21, '2023-05-20 13:48:20', '0001-01-01 01:01:01', NULL, NULL),
(22, '2023-05-20 13:48:20', '0001-01-01 01:01:01', NULL, NULL),
(23, '2023-05-20 13:48:20', '0001-01-01 01:01:01', NULL, NULL),
(24, '2023-05-20 13:48:20', '0001-01-01 01:01:01', NULL, NULL),
(25, '2023-05-20 13:48:20', '0001-01-01 01:01:01', NULL, NULL),
(26, '2023-05-20 13:48:20', '0001-01-01 01:01:01', NULL, NULL),
(27, '2023-05-20 13:48:20', '0001-01-01 01:01:01', NULL, NULL),
(28, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(29, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(30, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(31, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(32, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(33, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(34, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(35, '2023-05-20 13:48:21', '0001-01-01 01:01:01', NULL, NULL),
(36, '2023-05-20 13:48:22', '0001-01-01 01:01:01', NULL, NULL),
(37, '2023-05-20 14:01:32', '0001-01-01 01:01:01', NULL, NULL),
(38, '2023-05-20 23:36:33', '0001-01-01 01:01:01', NULL, NULL),
(39, '2023-05-20 23:36:34', '0001-01-01 01:01:01', NULL, NULL),
(40, '2023-05-20 23:36:34', '0001-01-01 01:01:01', NULL, NULL),
(41, '2023-05-20 23:36:34', '0001-01-01 01:01:01', NULL, NULL),
(42, '2023-05-20 23:36:34', '0001-01-01 01:01:01', NULL, NULL),
(43, '2023-05-20 23:36:35', '0001-01-01 01:01:01', NULL, NULL),
(44, '2023-05-20 23:36:35', '0001-01-01 01:01:01', NULL, NULL),
(45, '2023-05-20 23:36:35', '0001-01-01 01:01:01', NULL, NULL),
(46, '2023-05-20 23:36:35', '0001-01-01 01:01:01', NULL, NULL),
(47, '2023-05-20 23:36:35', '0001-01-01 01:01:01', NULL, NULL),
(48, '2023-05-20 23:36:35', '0001-01-01 01:01:01', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
