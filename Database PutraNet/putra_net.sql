-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2026 at 06:39 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `putra_net`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin`, `password`) VALUES
('admin', 'admin'),
('admin1', 'admin1');

-- --------------------------------------------------------

--
-- Table structure for table `langganan`
--

CREATE TABLE `langganan` (
  `id_langganan` varchar(25) NOT NULL,
  `nama_pel` varchar(25) NOT NULL,
  `tanggal` date NOT NULL,
  `nama_paket` varchar(100) NOT NULL,
  `harga` int(30) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tipe_router` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `langganan`
--

INSERT INTO `langganan` (`id_langganan`, `nama_pel`, `tanggal`, `nama_paket`, `harga`, `nama`, `tipe_router`) VALUES
('IN0001', 'RIZAL', '2026-07-02', 'PRIME', 750000, 'YUSUF', 'G-PON (FIBER HOME)'),
('IN0002', 'SRI MULYANI', '2026-07-04', 'PRIME', 750000, 'ARIEL', 'G-PON (FIBER HOME)'),
('IN0003', 'YANTO', '2026-07-03', 'ROYAL', 255000, 'GILANG', 'E-PON (HUAWEI)'),
('IN0004', 'ANGGIA JONATHAN', '2026-07-01', 'NEXUS', 450000, 'GILANG', 'E-PON (HUAWEI)');

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id_paket` varchar(25) NOT NULL,
  `nama_paket` varchar(25) NOT NULL,
  `speed` varchar(25) NOT NULL,
  `harga` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`id_paket`, `nama_paket`, `speed`, `harga`) VALUES
('PKT-001', 'STANDAR', '20MBps', 155000),
('PKT-002', 'ROYAL', '75MBps', 255000),
('PKT-003', 'NEXUS', '150MBps', 450000),
('PKT-004', 'PRIME', '350Mbps', 750000);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(25) NOT NULL,
  `nama_pel` varchar(25) NOT NULL,
  `no_hp` varchar(25) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pel`, `no_hp`, `alamat`) VALUES
('ID-0001', 'YANTO', '08818882342', 'Bojong gede'),
('ID-0002', 'RIZAL', '08998812121', 'Bogor'),
('ID-0003', 'SRI MULYANI', '08987654231', 'Jakarta Barat Perum Asri no 172'),
('ID-0004', 'ANGGIA JONATHAN', '08578812812', 'Mampang Jakarta Pusat');

-- --------------------------------------------------------

--
-- Table structure for table `router`
--

CREATE TABLE `router` (
  `ip_address` varchar(25) NOT NULL,
  `tipe_router` varchar(25) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `router`
--

INSERT INTO `router` (`ip_address`, `tipe_router`, `status`) VALUES
('192.168.110.1', 'G-PON (FIBER HOME)', 'Aktif'),
('192.168.120.1', 'E-PON (HUAWEI)', 'Aktif'),
('192.168.130.1', 'X-PON (ZTE)', 'Nonaktif');

-- --------------------------------------------------------

--
-- Table structure for table `teknisi`
--

CREATE TABLE `teknisi` (
  `id_teknisi` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `no_hp` varchar(25) NOT NULL,
  `spesialis` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teknisi`
--

INSERT INTO `teknisi` (`id_teknisi`, `nama`, `no_hp`, `spesialis`, `status`) VALUES
('TKS-001', 'YUSUF', '088882981212', 'LAPANGAN', 'Cuti'),
('TKS-002', 'ARIEL', '088987341623', 'FIBER OPTIC ', 'Aktif'),
('TKS-003', 'GILANG', '089876533187', 'HARDWARE', 'Cuti');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `no_tiket` varchar(25) NOT NULL,
  `nama_pel` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `masalah` varchar(30) NOT NULL,
  `prioritas` varchar(30) NOT NULL,
  `id_teknisi` varchar(30) NOT NULL,
  `tgl_lapor` date NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`no_tiket`, `nama_pel`, `alamat`, `masalah`, `prioritas`, `id_teknisi`, `tgl_lapor`, `status`) VALUES
('TX0001', 'RIZAL', 'Bogor', 'INDIKATOR LOS', 'NORMAL ', 'TKS-001', '2026-07-05', 'Selesai'),
('TX0002', 'SRI MULYANI', 'Jakarta Barat Perum Asri no 172', 'INDIKATOR LOS', 'SEDANG', 'TKS-002', '2026-07-04', 'Selesai');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(25) NOT NULL,
  `nama_pel` varchar(100) NOT NULL,
  `paket` varchar(25) NOT NULL,
  `harga` int(50) NOT NULL,
  `tgl_bayar` date NOT NULL,
  `metode` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `admin` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `nama_pel`, `paket`, `harga`, `tgl_bayar`, `metode`, `status`, `admin`) VALUES
('IN0001', 'RIZAL', 'PRIME', 750000, '2026-07-05', 'Tunai', 'Lunas', 'admin'),
('IN0002', 'SRI MULYANI', 'PRIME', 750000, '2026-07-05', 'Transfer', 'Lunas', 'admin'),
('IN0003', 'YANTO', 'ROYAL', 255000, '2026-07-05', 'QRIS', 'Lunas', 'admin'),
('IN0004', 'ANGGIA JONATHAN', 'NEXUS', 450000, '2026-07-05', '-', 'Belum Lunas', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `langganan`
--
ALTER TABLE `langganan`
  ADD PRIMARY KEY (`id_langganan`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `router`
--
ALTER TABLE `router`
  ADD PRIMARY KEY (`ip_address`);

--
-- Indexes for table `teknisi`
--
ALTER TABLE `teknisi`
  ADD PRIMARY KEY (`id_teknisi`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`no_tiket`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
