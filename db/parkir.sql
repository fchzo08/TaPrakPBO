-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Jun 2023 pada 13.52
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
(9, 'ADMIN', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),
(10, 'ghifari', 'ghifari', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

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
(9000001, '2023-05-22 20:29:37', '2023-05-22 20:32:30', 'Sepeda', 1000),
(2, '2023-05-22 20:31:01', '0001-01-01 01:01:01', NULL, NULL),
(3, '2023-05-22 20:31:17', '0001-01-01 01:01:01', NULL, NULL),
(9000004, '2023-05-22 20:31:18', '2023-05-22 23:27:16', 'Sepeda', 2000),
(5, '2023-05-22 20:31:18', '0001-01-01 01:01:01', NULL, NULL),
(6, '2023-05-22 20:31:20', '0001-01-01 01:01:01', NULL, NULL),
(7, '2023-05-22 20:31:22', '0001-01-01 01:01:01', NULL, NULL),
(8, '2023-05-22 20:31:32', '0001-01-01 01:01:01', NULL, NULL),
(9, '2023-05-22 20:31:33', '0001-01-01 01:01:01', NULL, NULL),
(10, '2023-05-22 20:31:33', '0001-01-01 01:01:01', NULL, NULL),
(11, '2023-05-22 20:31:38', '0001-01-01 01:01:01', NULL, NULL),
(12, '2023-05-22 20:31:50', '0001-01-01 01:01:01', NULL, NULL),
(13, '2023-05-22 20:31:50', '0001-01-01 01:01:01', NULL, NULL),
(9000014, '2023-05-22 20:31:51', '2023-05-22 23:25:33', 'Motor', 4000),
(9000015, '2023-05-24 08:17:59', '2023-05-24 08:19:58', 'Mobil', 5000),
(9000016, '2023-05-24 08:24:06', '2023-05-24 08:24:37', 'Sepeda', 1000),
(17, '2023-05-30 21:40:01', '0001-01-01 01:01:01', NULL, NULL);

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
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
