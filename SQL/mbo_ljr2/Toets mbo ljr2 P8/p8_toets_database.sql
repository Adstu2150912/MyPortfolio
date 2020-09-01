CREATE DATABASE [superheroes];
GO

USE [superheroes]
GO
/****** Object:  Table [dbo].[alignment]    Script Date: 29-5-2018 12:13:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[alignment](
	[alignmentId] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[alignmentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[color]    Script Date: 29-5-2018 12:13:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[color](
	[colorId] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[colorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hero]    Script Date: 29-5-2018 12:13:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hero](
	[heroId] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](25) NOT NULL,
	[gender] [varchar](6) NULL,
	[eyeColorId] [int] NULL,
	[raceId] [int] NULL,
	[hairColorId] [int] NULL,
	[height] [numeric](5, 1) NULL,
	[publisherId] [int] NULL,
	[skinColorId] [int] NULL,
	[alignmentId] [int] NULL,
	[weight] [numeric](5, 1) NULL,
PRIMARY KEY CLUSTERED 
(
	[heroId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[publisher]    Script Date: 29-5-2018 12:13:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[publisher](
	[publisherId] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[publisherId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[race]    Script Date: 29-5-2018 12:13:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[race](
	[raceId] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[raceId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[alignment] ON 
GO
INSERT [dbo].[alignment] ([alignmentId], [name]) VALUES (1, N'bad')
GO
INSERT [dbo].[alignment] ([alignmentId], [name]) VALUES (2, N'good')
GO
INSERT [dbo].[alignment] ([alignmentId], [name]) VALUES (3, N'neutral')
GO
SET IDENTITY_INSERT [dbo].[alignment] OFF
GO
SET IDENTITY_INSERT [dbo].[color] ON 
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (1, N'amber')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (2, N'auburn')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (3, N'black')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (4, N'black / blue')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (5, N'blond')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (6, N'blue')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (7, N'blue / white')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (8, N'blue-white')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (9, N'brown')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (10, N'brown / black')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (11, N'brown / white')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (12, N'gold')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (13, N'gray')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (14, N'green')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (15, N'green / blue')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (16, N'grey')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (17, N'hazel')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (18, N'indigo')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (19, N'magenta')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (20, N'no hair')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (21, N'orange')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (22, N'orange / white')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (23, N'pink')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (24, N'purple')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (25, N'red')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (26, N'red / black')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (27, N'red / grey')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (28, N'red / orange')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (29, N'red / white')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (30, N'silver')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (31, N'strawberry blond')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (32, N'violet')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (33, N'white')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (34, N'white / red')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (35, N'yellow')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (36, N'yellow (without irises)')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (37, N'yellow / blue')
GO
INSERT [dbo].[color] ([colorId], [name]) VALUES (38, N'yellow / red')
GO
SET IDENTITY_INSERT [dbo].[color] OFF
GO
SET IDENTITY_INSERT [dbo].[hero] ON 
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (1, N'A-Bomb', N'Male', 35, 23, 20, CAST(203.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(441.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (2, N'Abe Sapien', N'Male', 6, 32, 20, CAST(191.0 AS Numeric(5, 1)), 2, 6, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (3, N'Abin Sur', N'Male', 6, 55, 20, CAST(185.0 AS Numeric(5, 1)), 3, 25, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (4, N'Abomination', N'Male', 14, 27, 20, CAST(203.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(441.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (5, N'Abraxas', N'Male', 6, 11, 3, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (6, N'Absorbing Man', N'Male', 6, 23, 20, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(122.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (7, N'Adam Monroe', N'Male', 6, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (8, N'Adam Strange', N'Male', 6, 23, 5, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (9, N'Agent 13', N'Female', 6, NULL, 5, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (10, N'Agent Bob', N'Male', 9, 23, 9, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (11, N'Agent Zero', N'Male', NULL, NULL, NULL, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (12, N'Air-Walker', N'Male', 6, NULL, 33, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(108.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (13, N'Ajax', N'Male', 9, 12, 3, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (14, N'Alan Scott', N'Male', 6, NULL, 5, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (15, N'Alex Mercer', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 24, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (16, N'Alex Woolsly', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (17, N'Alfred Pennyworth', N'Male', 6, 23, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (18, N'Alien', N'Male', NULL, 57, 20, CAST(244.0 AS Numeric(5, 1)), 2, 3, 1, CAST(169.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (19, N'Allan Quatermain', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 24, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (20, N'Amazo', N'Male', 25, 4, NULL, CAST(257.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(173.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (21, N'Ammo', N'Male', 9, 23, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (22, N'Ando Masahashi', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (23, N'Angel', N'Male', 6, NULL, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (24, N'Angel', N'Male', NULL, 56, NULL, CAST(-99.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (25, N'Angel Dust', N'Female', 35, 42, 3, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(57.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (26, N'Angel Salvadore', N'Female', 9, NULL, 3, CAST(163.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (27, N'Angela', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (28, N'Animal Man', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (29, N'Annihilus', N'Male', 14, NULL, 20, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (30, N'Ant-Man', N'Male', 6, 23, 5, CAST(211.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(122.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (31, N'Ant-Man II', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (32, N'Anti-Monitor', N'Male', 35, 20, 20, CAST(61.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (33, N'Anti-Spawn', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (34, N'Anti-Venom', N'Male', 6, 52, 5, CAST(229.0 AS Numeric(5, 1)), 12, NULL, NULL, CAST(358.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (35, N'Apocalypse', N'Male', 25, 42, 3, CAST(213.0 AS Numeric(5, 1)), 12, 16, 1, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (36, N'Aquababy', N'Male', 6, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (37, N'Aqualad', N'Male', 6, 7, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(106.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (38, N'Aquaman', N'Male', 6, 7, 5, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(146.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (39, N'Arachne', N'Female', 6, 23, 5, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (40, N'Archangel', N'Male', 6, 42, 5, CAST(183.0 AS Numeric(5, 1)), 12, 6, 2, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (41, N'Arclight', N'Female', 32, NULL, 24, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(57.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (42, N'Ardina', N'Female', 33, 1, 21, CAST(193.0 AS Numeric(5, 1)), 12, 12, 2, CAST(98.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (43, N'Ares', N'Male', 9, NULL, 9, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(270.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (44, N'Ariel', N'Female', 24, NULL, 23, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (45, N'Armor', N'Female', 3, NULL, 3, CAST(163.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (46, N'Arsenal', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (47, N'Astro Boy', N'Male', 9, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (48, N'Atlas', N'Male', 9, 42, 25, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (49, N'Atlas', N'Male', 6, 20, 9, CAST(198.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(126.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (50, N'Atom', N'Male', 6, NULL, 25, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (51, N'Atom', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (52, N'Atom Girl', N'Female', 3, NULL, 3, CAST(168.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (53, N'Atom II', N'Male', 9, 23, 2, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (54, N'Atom III', N'Male', NULL, NULL, 25, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (55, N'Atom IV', N'Male', 9, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (56, N'Aurora', N'Female', 6, 42, 3, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (57, N'Azazel', N'Male', 35, 45, 3, CAST(183.0 AS Numeric(5, 1)), 12, 25, 1, CAST(67.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (58, N'Azrael', N'Male', 9, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (59, N'Aztar', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (60, N'Bane', N'Male', NULL, 23, NULL, CAST(203.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(180.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (61, N'Banshee', N'Male', 14, 23, 31, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (62, N'Bantam', N'Male', 9, NULL, 3, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (63, N'Batgirl', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (64, N'Batgirl', N'Female', 14, 23, 25, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(57.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (65, N'Batgirl III', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (66, N'Batgirl IV', N'Female', 14, 23, 3, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (67, N'Batgirl V', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (68, N'Batgirl VI', N'Female', 6, NULL, 5, CAST(168.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (69, N'Batman', N'Male', 6, 23, 3, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (70, N'Batman', N'Male', 6, 23, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (71, N'Batman II', N'Male', 6, 23, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (72, N'Battlestar', N'Male', 9, NULL, 3, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(133.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (73, N'Batwoman V', N'Female', 14, 23, 25, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (74, N'Beak', N'Male', 3, NULL, 33, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (75, N'Beast', N'Male', 6, 42, 6, CAST(180.0 AS Numeric(5, 1)), 12, 6, 2, CAST(181.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (76, N'Beast Boy', N'Male', 14, 23, 14, CAST(173.0 AS Numeric(5, 1)), 3, 14, 2, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (77, N'Beetle', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (78, N'Ben 10', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (79, N'Beta Ray Bill', N'Male', NULL, NULL, 20, CAST(201.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(216.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (80, N'Beyonder', N'Male', NULL, 20, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (81, N'Big Barda', N'Female', 6, 44, 3, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (82, N'Big Daddy', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 7, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (83, N'Big Man', N'Male', 6, NULL, 9, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(71.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (84, N'Bill Harken', N'Male', NULL, 2, NULL, CAST(-99.0 AS Numeric(5, 1)), 20, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (85, N'Billy Kincaid', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (86, N'Binary', N'Female', 6, NULL, 5, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (87, N'Bionic Woman', N'Female', 6, 12, 3, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (88, N'Bird-Brain', NULL, NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (89, N'Bird-Man', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (90, N'Bird-Man II', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (91, N'Birdman', N'Male', NULL, 20, NULL, CAST(-99.0 AS Numeric(5, 1)), 5, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (92, N'Bishop', N'Male', 9, 42, 20, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(124.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (93, N'Bizarro', N'Male', 3, 8, 3, CAST(191.0 AS Numeric(5, 1)), 3, 33, 3, CAST(155.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (94, N'Black Abbott', N'Male', 25, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (95, N'Black Adam', N'Male', 9, NULL, 3, CAST(191.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(113.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (96, N'Black Bolt', N'Male', 6, 33, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (97, N'Black Canary', N'Female', 6, 23, 5, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(58.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (98, N'Black Canary', N'Female', 6, 41, 5, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (99, N'Black Cat', N'Female', 14, 23, 5, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (100, N'Black Flash', N'Male', NULL, 20, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (101, N'Black Goliath', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (102, N'Black Knight III', N'Male', 9, 23, 9, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (103, N'Black Lightning', N'Male', 9, NULL, 20, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (104, N'Black Mamba', N'Female', 14, NULL, 3, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (105, N'Black Manta', N'Male', 3, 23, 20, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(92.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (106, N'Black Panther', N'Male', 9, 23, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (107, N'Black Widow', N'Female', 14, 23, 2, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (108, N'Black Widow II', N'Female', 6, NULL, 5, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (109, N'Blackout', N'Male', 25, 16, 33, CAST(191.0 AS Numeric(5, 1)), 12, 33, 1, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (110, N'Blackwing', N'Male', 6, NULL, 3, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (111, N'Blackwulf', N'Male', 25, 1, 33, CAST(188.0 AS Numeric(5, 1)), 12, NULL, NULL, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (112, N'Blade', N'Male', 9, 56, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(97.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (113, N'Blaquesmith', NULL, 3, NULL, 20, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (114, N'Bling!', N'Female', NULL, NULL, NULL, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (115, N'Blink', N'Female', 14, 42, 19, CAST(165.0 AS Numeric(5, 1)), 12, 23, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (116, N'Blizzard', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (117, N'Blizzard', N'Male', NULL, NULL, 9, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (118, N'Blizzard II', N'Male', 9, NULL, 9, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (119, N'Blob', N'Male', 9, NULL, 9, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(230.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (120, N'Bloodaxe', N'Female', 6, 23, 9, CAST(218.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(495.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (121, N'Bloodhawk', N'Male', 3, 42, 20, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (122, N'Bloodwraith', N'Male', 33, NULL, 20, CAST(30.5 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (123, N'Blue Beetle', N'Male', 6, NULL, 9, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (124, N'Blue Beetle', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (125, N'Blue Beetle II', N'Male', 6, NULL, 9, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (126, N'Blue Beetle III', N'Male', 9, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (127, N'Boba Fett', N'Male', 9, 25, 3, CAST(183.0 AS Numeric(5, 1)), 4, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (128, N'Bolt', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (129, N'Bomb Queen', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (130, N'Boom-Boom', N'Female', 6, 42, 5, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(55.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (131, N'Boomer', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (132, N'Booster Gold', N'Male', 6, 23, 5, CAST(196.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(97.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (133, N'Box', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (134, N'Box III', NULL, 6, NULL, 5, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(110.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (135, N'Box IV', NULL, 9, NULL, 10, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (136, N'Brainiac', N'Male', 14, 4, 20, CAST(198.0 AS Numeric(5, 1)), 3, 14, 1, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (137, N'Brainiac 5', N'Male', 14, NULL, 5, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (138, N'Brother Voodoo', N'Male', 9, 23, 11, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (139, N'Brundlefly', N'Male', NULL, 42, NULL, CAST(193.0 AS Numeric(5, 1)), NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (140, N'Buffy', N'Female', 14, 23, 5, CAST(157.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (141, N'Bullseye', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (142, N'Bumblebee', N'Female', 9, 23, 3, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (143, N'Bumbleboy', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (144, N'Bushido', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (145, N'Cable', N'Male', 6, 42, 33, CAST(203.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(158.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (146, N'Callisto', N'Female', 6, NULL, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (147, N'Cameron Hicks', N'Male', NULL, 2, NULL, CAST(-99.0 AS Numeric(5, 1)), 20, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (148, N'Cannonball', N'Male', 6, NULL, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (149, N'Captain America', N'Male', 6, 23, 5, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(108.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (150, N'Captain Atom', N'Male', 6, 27, 30, CAST(193.0 AS Numeric(5, 1)), 3, 30, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (151, N'Captain Britain', N'Male', 6, 23, 5, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(116.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (152, N'Captain Cold', N'Male', 9, 23, 9, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (153, N'Captain Epic', N'Male', 6, NULL, 9, CAST(188.0 AS Numeric(5, 1)), 21, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (154, N'Captain Hindsight', N'Male', NULL, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 18, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (155, N'Captain Mar-vell', N'Male', 6, NULL, 5, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(108.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (156, N'Captain Marvel', N'Female', 6, 28, 5, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (157, N'Captain Marvel', N'Male', 6, 23, 3, CAST(193.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (158, N'Captain Marvel II', N'Male', 6, 23, 3, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (159, N'Captain Midnight', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (160, N'Captain Planet', N'Male', 25, 20, 14, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (161, N'Captain Universe', NULL, NULL, 20, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (162, N'Carnage', N'Male', 14, 52, 25, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (163, N'Cat', N'Female', 6, NULL, 5, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (164, N'Cat II', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (165, N'Catwoman', N'Female', 14, 23, 3, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (166, N'Cecilia Reyes', NULL, 9, NULL, 9, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(62.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (167, N'Century', N'Male', 33, 1, 33, CAST(201.0 AS Numeric(5, 1)), 12, 16, 2, CAST(97.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (168, N'Cerebra', N'Female', NULL, 42, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (169, N'Chamber', N'Male', 9, 42, 9, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (170, N'Chameleon', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (171, N'Changeling', N'Male', 9, NULL, 3, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (172, N'Cheetah', N'Female', 14, 23, 5, CAST(163.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (173, N'Cheetah II', N'Female', 14, 23, 9, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(55.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (174, N'Cheetah III', N'Female', 9, 23, 9, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (175, N'Chromos', N'Male', 9, NULL, 27, CAST(185.0 AS Numeric(5, 1)), 21, NULL, 1, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (176, N'Chuck Norris', N'Male', NULL, NULL, NULL, CAST(178.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (177, N'Citizen Steel', N'Male', 14, 23, 25, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(170.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (178, N'Claire Bennet', N'Female', 6, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (179, N'Clea', NULL, NULL, NULL, 33, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (180, N'Cloak', N'Male', 9, NULL, 3, CAST(226.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(70.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (181, N'Clock King', N'Male', 6, 23, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(78.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (182, N'Cogliostro', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (183, N'Colin Wagner', N'Male', 16, NULL, 9, CAST(-99.0 AS Numeric(5, 1)), 6, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (184, N'Colossal Boy', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (185, N'Colossus', N'Male', 30, 42, 3, CAST(226.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(225.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (186, N'Copycat', N'Female', 25, 42, 33, CAST(183.0 AS Numeric(5, 1)), 12, 6, 3, CAST(67.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (187, N'Corsair', N'Male', 9, NULL, 9, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (188, N'Cottonmouth', N'Male', 9, 23, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (189, N'Crimson Crusader', N'Male', 6, NULL, 31, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (190, N'Crimson Dynamo', N'Male', 9, NULL, 20, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (191, N'Crystal', N'Female', 14, 33, 25, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (192, N'Curse', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (193, N'Cy-Gor', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (194, N'Cyborg', N'Male', 9, 12, 3, CAST(198.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(173.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (195, N'Cyborg Superman', N'Male', 6, 12, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (196, N'Cyclops', N'Male', 9, 42, 9, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (197, N'Cypher', NULL, 6, NULL, 5, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (198, N'Dagger', N'Female', 6, NULL, 5, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (199, N'Danny Cooper', N'Male', 9, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 6, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (200, N'Daphne Powell', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 1, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (201, N'Daredevil', N'Male', 6, 23, 25, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (202, N'Darkhawk', N'Male', 9, 23, 9, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (203, N'Darkman', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 23, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (204, N'Darkseid', N'Male', 25, 44, 20, CAST(267.0 AS Numeric(5, 1)), 3, 16, 1, CAST(817.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (205, N'Darkside', NULL, NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (206, N'Darkstar', N'Female', 9, 42, 5, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (207, N'Darth Maul', N'Male', 38, 14, NULL, CAST(170.0 AS Numeric(5, 1)), 4, 26, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (208, N'Darth Vader', N'Male', 35, 12, 20, CAST(198.0 AS Numeric(5, 1)), 4, NULL, 1, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (209, N'Dash', N'Male', 6, 23, 5, CAST(122.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(27.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (210, N'Data', N'Male', 35, 4, 9, CAST(-99.0 AS Numeric(5, 1)), 19, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (211, N'Dazzler', N'Female', 6, 42, 5, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (212, N'Deadman', N'Male', 6, 23, 3, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (213, N'Deadpool', N'Male', 9, 42, 20, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 3, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (214, N'Deadshot', N'Male', 9, 23, 9, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(91.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (215, N'Deathlok', N'Male', 9, 12, 16, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(178.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (216, N'Deathstroke', N'Male', 6, 23, 33, CAST(193.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (217, N'Demogoblin', N'Male', 25, 16, 20, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (218, N'Destroyer', N'Male', NULL, NULL, NULL, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(383.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (219, N'Diamondback', N'Male', 9, 23, 3, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (220, N'DL Hawkins', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (221, N'Doc Samson', N'Male', 6, 27, 14, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(171.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (222, N'Doctor Doom', N'Male', 9, 23, 9, CAST(201.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(187.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (223, N'Doctor Doom II', N'Male', 9, NULL, 9, CAST(201.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(132.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (224, N'Doctor Fate', N'Male', 6, 23, 5, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(89.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (225, N'Doctor Octopus', N'Male', 9, 23, 9, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(110.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (226, N'Doctor Strange', N'Male', 16, 23, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (227, N'Domino', N'Female', 6, 23, 3, CAST(173.0 AS Numeric(5, 1)), 12, 33, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (228, N'Donatello', N'Male', 14, 42, 20, CAST(-99.0 AS Numeric(5, 1)), 8, 14, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (229, N'Donna Troy', N'Female', 6, 3, 3, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (230, N'Doomsday', N'Male', 25, 1, 33, CAST(244.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(412.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (231, N'Doppelganger', N'Male', 33, NULL, 20, CAST(196.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (232, N'Dormammu', N'Male', 35, NULL, 20, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (233, N'Dr Manhattan', N'Male', 33, 26, 20, CAST(-99.0 AS Numeric(5, 1)), 3, 6, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (234, N'Drax the Destroyer', N'Male', 25, 24, 20, CAST(193.0 AS Numeric(5, 1)), 12, 14, 2, CAST(306.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (235, N'Ego', NULL, NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (236, N'Elastigirl', N'Female', 9, 23, 9, CAST(168.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (237, N'Electro', N'Male', 6, 23, 2, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (238, N'Elektra', N'Female', 6, 23, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (239, N'Elle Bishop', N'Female', 6, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (240, N'Elongated Man', N'Male', 6, NULL, 25, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(80.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (241, N'Emma Frost', N'Female', 6, NULL, 5, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (242, N'Enchantress', N'Female', 6, 23, 5, CAST(168.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(57.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (243, N'Energy', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 6, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (244, N'ERG-1', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (245, N'Ethan Hunt', N'Male', 9, 23, 9, CAST(168.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (246, N'Etrigan', N'Male', 25, 16, 20, CAST(193.0 AS Numeric(5, 1)), 3, 35, 3, CAST(203.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (247, N'Evil Deadpool', N'Male', 33, 42, 25, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (248, N'Evilhawk', N'Male', 25, 1, 3, CAST(191.0 AS Numeric(5, 1)), 12, 14, 1, CAST(106.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (249, N'Exodus', N'Male', 6, 42, 3, CAST(183.0 AS Numeric(5, 1)), 12, 25, 1, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (250, N'Fabian Cortez', NULL, 6, NULL, 9, CAST(196.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(96.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (251, N'Falcon', N'Male', 9, 23, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(108.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (252, N'Fallen One II', N'Male', 3, NULL, 6, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (253, N'Faora', N'Female', NULL, 37, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (254, N'Feral', NULL, 36, NULL, 22, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (255, N'Fighting Spirit', N'Female', NULL, NULL, 25, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (256, N'Fin Fang Foom', N'Male', 25, 35, 20, CAST(975.0 AS Numeric(5, 1)), 12, 14, 2, CAST(18.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (257, N'Firebird', N'Female', 9, NULL, 3, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (258, N'Firelord', NULL, 33, NULL, 35, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (259, N'Firestar', N'Female', 14, 42, 25, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (260, N'Firestorm', N'Male', 9, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (261, N'Firestorm', N'Male', 6, 23, 2, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(91.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (262, N'Fixer', NULL, 25, NULL, 20, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (263, N'Flash', N'Male', 6, 23, 11, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (264, N'Flash Gordon', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (265, N'Flash II', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (266, N'Flash III', N'Male', NULL, 23, NULL, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (267, N'Flash IV', N'Male', 35, 23, 2, CAST(157.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (268, N'Forge', NULL, 9, NULL, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (269, N'Franklin Richards', N'Male', 6, 42, 5, CAST(142.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(45.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (270, N'Franklin Storm', NULL, 6, NULL, 16, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(92.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (271, N'Frenzy', N'Female', 9, NULL, 3, CAST(211.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (272, N'Frigga', N'Female', 6, NULL, 33, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(167.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (273, N'Galactus', N'Male', 3, 11, 3, CAST(876.0 AS Numeric(5, 1)), 12, NULL, 3, CAST(16.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (274, N'Gambit', N'Male', 25, 42, 9, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (275, N'Gamora', N'Female', 35, 60, 3, CAST(183.0 AS Numeric(5, 1)), 12, 14, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (276, N'Garbage Man', N'Male', NULL, 42, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (277, N'Gary Bell', N'Male', NULL, 2, NULL, CAST(-99.0 AS Numeric(5, 1)), 20, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (278, N'General Zod', N'Male', 3, 37, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (279, N'Genesis', N'Male', 6, NULL, 5, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (280, N'Ghost Rider', N'Male', 25, 16, 20, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (281, N'Ghost Rider II', NULL, NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (282, N'Giant-Man', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (283, N'Giant-Man II', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (284, N'Giganta', N'Female', 14, NULL, 25, CAST(62.5 AS Numeric(5, 1)), 3, NULL, 1, CAST(630.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (285, N'Gladiator', N'Male', 6, 51, 6, CAST(198.0 AS Numeric(5, 1)), 12, 24, 3, CAST(268.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (286, N'Goblin Queen', N'Female', 14, NULL, 25, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (287, N'Godzilla', NULL, NULL, 34, NULL, CAST(108.0 AS Numeric(5, 1)), NULL, 16, 1, NULL)
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (288, N'Gog', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (289, N'Goku', N'Male', NULL, 49, NULL, CAST(175.0 AS Numeric(5, 1)), 16, NULL, 2, CAST(62.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (290, N'Goliath', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (291, N'Goliath', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (292, N'Goliath', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (293, N'Goliath IV', N'Male', 9, NULL, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (294, N'Gorilla Grodd', N'Male', 35, 21, 3, CAST(198.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(270.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (295, N'Granny Goodness', N'Female', 6, NULL, 33, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(115.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (296, N'Gravity', N'Male', 6, 23, 9, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (297, N'Greedo', N'Male', 24, 48, NULL, CAST(170.0 AS Numeric(5, 1)), 4, 14, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (298, N'Green Arrow', N'Male', 14, 23, 5, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (299, N'Green Goblin', N'Male', 6, 23, 2, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (300, N'Green Goblin II', N'Male', 6, NULL, 2, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (301, N'Green Goblin III', N'Male', NULL, NULL, NULL, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (302, N'Green Goblin IV', N'Male', 14, NULL, 9, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (303, N'Groot', N'Male', 35, 18, NULL, CAST(701.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(4.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (304, N'Guardian', N'Male', 9, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (305, N'Guy Gardner', N'Male', 6, 31, 25, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (306, N'Hal Jordan', N'Male', 9, 23, 9, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (307, N'Han Solo', N'Male', 9, 23, 9, CAST(183.0 AS Numeric(5, 1)), 4, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (308, N'Hancock', N'Male', 9, 23, 3, CAST(188.0 AS Numeric(5, 1)), 17, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (309, N'Harley Quinn', N'Female', 6, 23, 5, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (310, N'Harry Potter', N'Male', 14, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 10, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (311, N'Havok', N'Male', 6, 42, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (312, N'Hawk', N'Male', 25, NULL, 9, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(89.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (313, N'Hawkeye', N'Male', 6, 23, 5, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (314, N'Hawkeye II', N'Female', 6, 23, 3, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(57.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (315, N'Hawkgirl', N'Female', 14, NULL, 25, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (316, N'Hawkman', N'Male', 6, NULL, 9, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (317, N'Hawkwoman', N'Female', 14, NULL, 25, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (318, N'Hawkwoman II', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (319, N'Hawkwoman III', N'Female', 6, NULL, 25, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (320, N'Heat Wave', N'Male', 6, 23, 20, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (321, N'Hela', N'Female', 14, 6, 3, CAST(213.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(225.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (322, N'Hellboy', N'Male', 12, 16, 3, CAST(259.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(158.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (323, N'Hellcat', N'Female', 6, 23, 25, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (324, N'Hellstorm', N'Male', 25, NULL, 25, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (325, N'Hercules', N'Male', 6, 15, 9, CAST(196.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(146.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (326, N'Hiro Nakamura', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (327, N'Hit-Girl', N'Female', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 7, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (328, N'Hobgoblin', N'Male', 6, NULL, 16, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (329, N'Hollow', N'Female', 6, NULL, 25, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (330, N'Hope Summers', N'Female', 14, NULL, 25, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(48.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (331, N'Howard the Duck', N'Male', 9, NULL, 35, CAST(79.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(18.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (332, N'Hulk', N'Male', 14, 27, 14, CAST(244.0 AS Numeric(5, 1)), 12, 14, 2, CAST(630.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (333, N'Human Torch', N'Male', 6, 27, 5, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (334, N'Huntress', N'Female', 6, NULL, 3, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (335, N'Husk', N'Female', 6, 42, 5, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(58.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (336, N'Hybrid', N'Male', 9, 52, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (337, N'Hydro-Man', N'Male', 9, NULL, 9, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(119.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (338, N'Hyperion', N'Male', 6, 17, 25, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(207.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (339, N'Iceman', N'Male', 9, 42, 9, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (340, N'Impulse', N'Male', 35, 23, 2, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (341, N'Indiana Jones', N'Male', NULL, 23, NULL, CAST(183.0 AS Numeric(5, 1)), 4, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (342, N'Indigo', N'Female', NULL, 1, 24, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (343, N'Ink', N'Male', 6, 42, 20, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (344, N'Invisible Woman', N'Female', 6, 27, 5, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (345, N'Iron Fist', N'Male', 6, 23, 5, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (346, N'Iron Man', N'Male', 6, 23, 3, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(191.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (347, N'Iron Monger', N'Male', 6, NULL, 20, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(2.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (348, N'Isis', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (349, N'Jack Bauer', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (350, N'Jack of Hearts', N'Male', 7, 23, 9, CAST(155.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (351, N'Jack-Jack', N'Male', 6, 23, 9, CAST(71.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(14.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (352, N'James Bond', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 22, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (353, N'James T. Kirk', N'Male', 17, 23, 9, CAST(178.0 AS Numeric(5, 1)), 19, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (354, N'Jar Jar Binks', N'Male', 35, 22, NULL, CAST(193.0 AS Numeric(5, 1)), 4, 22, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (355, N'Jason Bourne', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (356, N'Jean Grey', N'Female', 14, 42, 25, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (357, N'Jean-Luc Picard', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 19, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (358, N'Jennifer Kale', N'Female', 6, NULL, 5, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(55.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (359, N'Jesse Quick', N'Female', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (360, N'Jessica Cruz', N'Female', 14, 23, 9, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (361, N'Jessica Jones', N'Female', 9, 23, 9, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (362, N'Jessica Sanders', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (363, N'Jigsaw', N'Male', 6, NULL, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(113.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (364, N'Jim Powell', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 1, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (365, N'JJ Powell', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 1, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (366, N'Johann Krauss', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (367, N'John Constantine', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (368, N'John Stewart', N'Male', 14, 23, 3, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (369, N'John Wraith', N'Male', 9, NULL, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (370, N'Joker', N'Male', 14, 23, 14, CAST(196.0 AS Numeric(5, 1)), 3, 33, 1, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (371, N'Jolt', N'Female', 6, NULL, 3, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(49.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (372, N'Jubilee', N'Female', 25, 42, 3, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (373, N'Judge Dredd', N'Male', NULL, 23, NULL, CAST(188.0 AS Numeric(5, 1)), 15, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (374, N'Juggernaut', N'Male', 6, 23, 25, CAST(287.0 AS Numeric(5, 1)), 12, NULL, 3, CAST(855.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (375, N'Junkpile', N'Male', NULL, 42, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (376, N'Justice', N'Male', 17, 23, 9, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (377, N'Jyn Erso', N'Female', 14, 23, 9, CAST(-99.0 AS Numeric(5, 1)), 4, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (378, N'K-2SO', N'Male', 33, 4, 20, CAST(213.0 AS Numeric(5, 1)), 4, 13, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (379, N'Kang', N'Male', 9, NULL, 9, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (380, N'Karate Kid', N'Male', 9, 23, 9, CAST(173.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (381, N'Kathryn Janeway', N'Female', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 19, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (382, N'Katniss Everdeen', N'Female', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (383, N'Kevin 11', N'Male', NULL, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (384, N'Kick-Ass', N'Male', 6, 23, 5, CAST(-99.0 AS Numeric(5, 1)), 7, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (385, N'Kid Flash', N'Male', 14, 23, 25, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (386, N'Kid Flash II', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (387, N'Killer Croc', N'Male', 25, 41, 20, CAST(244.0 AS Numeric(5, 1)), 3, 14, 1, CAST(356.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (388, N'Killer Frost', N'Female', 6, 23, 5, CAST(-99.0 AS Numeric(5, 1)), 3, 6, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (389, N'Kilowog', N'Male', 25, 9, 20, CAST(234.0 AS Numeric(5, 1)), 3, 23, 2, CAST(324.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (390, N'King Kong', N'Male', 35, 5, 3, CAST(30.5 AS Numeric(5, 1)), NULL, NULL, 2, NULL)
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (391, N'King Shark', N'Male', 3, 5, 20, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (392, N'Kingpin', N'Male', 6, 23, 20, CAST(201.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(203.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (393, N'Klaw', N'Male', 25, 23, 20, CAST(188.0 AS Numeric(5, 1)), 12, 25, 1, CAST(97.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (394, N'Kool-Aid Man', N'Male', 3, NULL, 20, CAST(-99.0 AS Numeric(5, 1)), NULL, 25, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (395, N'Kraven II', N'Male', 9, 23, 3, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (396, N'Kraven the Hunter', N'Male', 9, 23, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(106.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (397, N'Krypto', N'Male', 6, 37, 33, CAST(64.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(18.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (398, N'Kyle Rayner', N'Male', 14, 23, 3, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (399, N'Kylo Ren', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 4, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (400, N'Lady Bullseye', N'Female', NULL, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (401, N'Lady Deathstrike', N'Female', 9, 12, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(58.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (402, N'Leader', N'Male', 14, NULL, 20, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (403, N'Leech', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (404, N'Legion', N'Male', 15, 42, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (405, N'Leonardo', N'Male', 6, 42, 20, CAST(-99.0 AS Numeric(5, 1)), 8, 14, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (406, N'Lex Luthor', N'Male', 14, 23, 20, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (407, N'Light Lass', N'Female', 6, NULL, 25, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (408, N'Lightning Lad', N'Male', 6, NULL, 25, CAST(155.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (409, N'Lightning Lord', N'Male', 6, NULL, 25, CAST(191.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (410, N'Living Brain', NULL, 35, NULL, NULL, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(360.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (411, N'Living Tribunal', NULL, 6, 11, 20, CAST(-99.0 AS Numeric(5, 1)), 12, 12, 3, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (412, N'Liz Sherman', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (413, N'Lizard', N'Male', 25, 23, 20, CAST(203.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(230.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (414, N'Lobo', N'Male', 25, 13, 3, CAST(229.0 AS Numeric(5, 1)), 3, 8, 3, CAST(288.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (415, N'Loki', N'Male', 14, 6, 3, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(236.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (416, N'Longshot', N'Male', 6, 23, 5, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(36.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (417, N'Luke Cage', N'Male', 9, 23, 3, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(191.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (418, N'Luke Campbell', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (419, N'Luke Skywalker', N'Male', 6, 23, 5, CAST(168.0 AS Numeric(5, 1)), 4, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (420, N'Luna', N'Female', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (421, N'Lyja', N'Female', 14, NULL, 14, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (422, N'Mach-IV', N'Male', 9, NULL, 9, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (423, N'Machine Man', NULL, 25, NULL, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(383.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (424, N'Magneto', N'Male', 16, 42, 33, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (425, N'Magog', N'Male', 6, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (426, N'Magus', N'Male', 3, NULL, NULL, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (427, N'Man of Miracles', NULL, 6, 20, 30, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (428, N'Man-Bat', N'Male', 9, 23, 9, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (429, N'Man-Thing', N'Male', 25, NULL, 20, CAST(213.0 AS Numeric(5, 1)), 12, 14, 2, CAST(225.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (430, N'Man-Wolf', N'Male', 9, NULL, 2, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (431, N'Mandarin', N'Male', 6, 23, 33, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(97.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (432, N'Mantis', N'Female', 14, 28, 3, CAST(168.0 AS Numeric(5, 1)), 12, 14, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (433, N'Martian Manhunter', N'Male', 25, 40, 20, CAST(201.0 AS Numeric(5, 1)), 3, 14, 2, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (434, N'Marvel Girl', N'Female', 14, NULL, 25, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (435, N'Master Brood', N'Male', 6, NULL, 3, CAST(183.0 AS Numeric(5, 1)), 21, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (436, N'Master Chief', N'Male', 9, 24, 9, CAST(213.0 AS Numeric(5, 1)), 13, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (437, N'Match', N'Male', 3, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (438, N'Matt Parkman', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (439, N'Maverick', N'Male', 6, NULL, 3, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(110.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (440, N'Maxima', N'Female', 9, NULL, 25, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (441, N'Maya Herrera', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (442, N'Medusa', N'Female', 14, 33, 25, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (443, N'Meltdown', N'Female', 6, NULL, 5, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (444, N'Mephisto', N'Male', 33, NULL, 3, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(140.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (445, N'Mera', N'Female', 6, 7, 25, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (446, N'Metallo', N'Male', 14, 4, 9, CAST(196.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (447, N'Metamorpho', N'Male', 3, NULL, 20, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (448, N'Meteorite', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (449, N'Metron', N'Male', 6, NULL, 3, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (450, N'Micah Sanders', N'Male', 9, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (451, N'Michelangelo', N'Male', 6, 42, NULL, CAST(-99.0 AS Numeric(5, 1)), 8, 14, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (452, N'Micro Lad', N'Male', 16, NULL, 9, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (453, N'Mimic', N'Male', 9, NULL, 9, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (454, N'Minna Murray', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 24, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (455, N'Misfit', N'Female', 6, NULL, 25, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (456, N'Miss Martian', N'Female', 25, NULL, 25, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (457, N'Mister Fantastic', N'Male', 9, 27, 9, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (458, N'Mister Freeze', N'Male', NULL, 23, NULL, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (459, N'Mister Knife', N'Male', 6, 50, 9, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (460, N'Mister Mxyzptlk', N'Male', NULL, 20, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (461, N'Mister Sinister', N'Male', 25, 24, 3, CAST(196.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(128.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (462, N'Mister Zsasz', N'Male', 6, 23, 5, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (463, N'Mockingbird', N'Female', 6, 23, 5, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (464, N'MODOK', N'Male', 33, 12, 9, CAST(366.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(338.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (465, N'Mogo', N'Male', NULL, 47, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (466, N'Mohinder Suresh', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (467, N'Moloch', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (468, N'Molten Man', N'Male', 12, NULL, 12, CAST(196.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(248.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (469, N'Monarch', N'Male', 6, NULL, 33, CAST(193.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (470, N'Monica Dawson', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (471, N'Moon Knight', N'Male', 9, 23, 9, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (472, N'Moonstone', N'Female', 6, NULL, 5, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (473, N'Morlun', N'Male', 34, NULL, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (474, N'Morph', N'Male', 33, NULL, 20, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (475, N'Moses Magnum', N'Male', 9, NULL, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (476, N'Mr Immortal', N'Male', 6, 42, 5, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(70.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (477, N'Mr Incredible', N'Male', 6, 23, 5, CAST(201.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(158.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (478, N'Ms Marvel II', N'Female', 6, NULL, 25, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (479, N'Multiple Man', N'Male', 6, NULL, 9, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(70.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (480, N'Mysterio', N'Male', 9, 23, 20, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (481, N'Mystique', N'Female', 36, 42, 28, CAST(178.0 AS Numeric(5, 1)), 12, 6, 1, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (482, N'Namor', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (483, N'Namor', N'Male', 16, 7, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(125.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (484, N'Namora', N'Female', 6, NULL, 5, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(85.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (485, N'Namorita', N'Female', 6, NULL, 5, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (486, N'Naruto Uzumaki', N'Male', NULL, 23, NULL, CAST(168.0 AS Numeric(5, 1)), 16, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (487, N'Nathan Petrelli', N'Male', 9, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (488, N'Nebula', N'Female', 6, 38, 20, CAST(185.0 AS Numeric(5, 1)), 12, 6, 1, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (489, N'Negasonic Teenage Warhead', N'Female', 3, 42, 3, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (490, N'Nick Fury', N'Male', 9, 23, 11, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (491, N'Nightcrawler', N'Male', 35, NULL, 18, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (492, N'Nightwing', N'Male', 6, 23, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (493, N'Niki Sanders', N'Female', 6, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (494, N'Nina Theroux', N'Female', NULL, 2, NULL, CAST(-99.0 AS Numeric(5, 1)), 20, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (495, N'Nite Owl II', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (496, N'Northstar', N'Male', 6, NULL, 3, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (497, N'Nova', N'Male', 9, 23, 9, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (498, N'Nova', N'Female', 33, 26, 25, CAST(163.0 AS Numeric(5, 1)), 12, 12, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (499, N'Odin', N'Male', 6, 20, 33, CAST(206.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(293.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (500, N'Offspring', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (501, N'Omega Red', N'Male', 25, NULL, 5, CAST(211.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(191.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (502, N'Omniscient', N'Male', 9, NULL, 3, CAST(180.0 AS Numeric(5, 1)), 21, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (503, N'One Punch Man', N'Male', NULL, 23, 20, CAST(175.0 AS Numeric(5, 1)), 16, NULL, 2, CAST(69.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (504, N'One-Above-All', NULL, NULL, 11, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 3, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (505, N'Onslaught', N'Male', 25, 42, 20, CAST(305.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(405.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (506, N'Oracle', N'Female', 6, 23, 25, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (507, N'Osiris', N'Male', 9, NULL, 9, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (508, N'Overtkill', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (509, N'Ozymandias', N'Male', 6, 23, 5, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (510, N'Parademon', NULL, NULL, 46, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (511, N'Paul Blart', N'Male', NULL, 23, NULL, CAST(170.0 AS Numeric(5, 1)), 17, NULL, 2, CAST(117.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (512, N'Penance', NULL, NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (513, N'Penance I', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (514, N'Penance II', N'Male', 6, NULL, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(89.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (515, N'Penguin', N'Male', 6, 23, 3, CAST(157.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (516, N'Peter Petrelli', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (517, N'Phantom', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (518, N'Phantom Girl', N'Female', 6, NULL, 3, CAST(168.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (519, N'Phoenix', N'Female', 14, 42, 25, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (520, N'Plantman', N'Male', 14, 42, 16, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(87.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (521, N'Plastic Lad', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (522, N'Plastic Man', N'Male', 6, 23, 3, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(80.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (523, N'Plastique', N'Female', 6, NULL, 25, CAST(168.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(55.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (524, N'Poison Ivy', N'Female', 14, 23, 25, CAST(168.0 AS Numeric(5, 1)), 3, 14, 1, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (525, N'Polaris', N'Female', 14, 42, 14, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (526, N'Power Girl', N'Female', 6, 37, 5, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (527, N'Power Man', N'Male', NULL, 42, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (528, N'Predator', N'Male', NULL, 58, NULL, CAST(213.0 AS Numeric(5, 1)), 2, NULL, 1, CAST(234.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (529, N'Professor X', N'Male', 6, 42, 20, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (530, N'Professor Zoom', N'Male', 6, 23, 31, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (531, N'Proto-Goblin', N'Male', 14, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (532, N'Psylocke', N'Female', 6, 42, 24, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(70.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (533, N'Punisher', N'Male', 6, 23, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(90.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (534, N'Purple Man', N'Male', 24, 23, 24, CAST(180.0 AS Numeric(5, 1)), 12, 24, 1, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (535, N'Pyro', N'Male', 6, NULL, 5, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (536, N'Q', N'Male', NULL, 20, NULL, CAST(-99.0 AS Numeric(5, 1)), 19, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (537, N'Quantum', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 6, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (538, N'Question', N'Male', 6, 23, 5, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (539, N'Quicksilver', N'Male', 6, 42, 30, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (540, N'Quill', N'Male', 9, NULL, 9, CAST(163.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (541, N'Ra''s Al Ghul', N'Male', 14, 23, 16, CAST(193.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(97.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (542, N'Rachel Pirzad', N'Female', NULL, 2, NULL, CAST(-99.0 AS Numeric(5, 1)), 20, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (543, N'Rambo', N'Male', 9, 23, 3, CAST(178.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (544, N'Raphael', N'Male', NULL, 42, 20, CAST(-99.0 AS Numeric(5, 1)), 8, 14, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (545, N'Raven', N'Female', 18, 23, 3, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (546, N'Ray', N'Male', 14, 23, 25, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(70.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (547, N'Razor-Fist II', N'Male', 6, NULL, 20, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(117.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (548, N'Red Arrow', N'Male', 14, 23, 25, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (549, N'Red Hood', N'Male', 6, 23, 3, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (550, N'Red Hulk', N'Male', 35, 27, 3, CAST(213.0 AS Numeric(5, 1)), 12, 25, 3, CAST(630.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (551, N'Red Mist', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 7, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (552, N'Red Robin', N'Male', 6, 23, 3, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (553, N'Red Skull', N'Male', 6, NULL, 20, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(108.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (554, N'Red Tornado', N'Male', 14, 4, 20, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(146.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (555, N'Redeemer II', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (556, N'Redeemer III', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (557, N'Renata Soliz', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 6, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (558, N'Rey', N'Female', 17, 23, 9, CAST(297.0 AS Numeric(5, 1)), 4, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (559, N'Rhino', N'Male', 9, 27, 9, CAST(196.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(320.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (560, N'Rick Flag', N'Male', 6, NULL, 9, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(85.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (561, N'Riddler', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (562, N'Rip Hunter', N'Male', 6, 23, 5, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (563, N'Ripcord', N'Female', 14, NULL, 3, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (564, N'Robin', N'Male', 6, 23, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (565, N'Robin II', N'Male', 6, 23, 25, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (566, N'Robin III', N'Male', 6, 23, 3, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (567, N'Robin V', N'Male', 6, 23, 3, CAST(137.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(38.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (568, N'Robin VI', N'Female', 14, 23, 25, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (569, N'Rocket Raccoon', N'Male', 9, 5, 9, CAST(122.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(25.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (570, N'Rogue', N'Female', 14, NULL, 11, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (571, N'Ronin', N'Male', 6, 23, 5, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(104.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (572, N'Rorschach', N'Male', 6, 23, 25, CAST(168.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (573, N'Sabretooth', N'Male', 1, 42, 5, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(171.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (574, N'Sage', N'Female', 6, NULL, 3, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (575, N'Sandman', N'Male', 9, 23, 9, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 3, CAST(203.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (576, N'Sasquatch', N'Male', 25, NULL, 21, CAST(305.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(900.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (577, N'Sauron', N'Male', NULL, 39, NULL, CAST(279.0 AS Numeric(5, 1)), 11, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (578, N'Savage Dragon', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (579, N'Scarecrow', N'Male', 6, 23, 9, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (580, N'Scarlet Spider', N'Male', 6, 23, 5, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (581, N'Scarlet Spider II', N'Male', 9, 10, 9, CAST(193.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(113.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (582, N'Scarlet Witch', N'Female', 6, 42, 9, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (583, N'Scorpia', N'Female', 14, NULL, 25, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (584, N'Scorpion', N'Male', 9, 23, 9, CAST(211.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(310.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (585, N'Sebastian Shaw', N'Male', NULL, 42, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (586, N'Sentry', N'Male', 6, 42, 5, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 3, CAST(87.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (587, N'Shadow King', NULL, 25, NULL, NULL, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(149.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (588, N'Shadow Lass', N'Female', 3, 53, 3, CAST(173.0 AS Numeric(5, 1)), 3, 6, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (589, N'Shadowcat', N'Female', 17, 42, 9, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (590, N'Shang-Chi', N'Male', 9, 23, 3, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (591, N'Shatterstar', N'Male', 9, NULL, 25, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(88.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (592, N'She-Hulk', N'Female', 14, 23, 14, CAST(201.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(315.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (593, N'She-Thing', N'Female', 6, 27, 20, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(153.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (594, N'Shocker', N'Male', 9, 23, 9, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (595, N'Shriek', N'Female', 37, NULL, 3, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (596, N'Shrinking Violet', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (597, N'Sif', N'Female', 6, 6, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(191.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (598, N'Silk', N'Female', 9, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (599, N'Silk Spectre', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (600, N'Silk Spectre II', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (601, N'Silver Surfer', N'Male', 33, 1, 20, CAST(193.0 AS Numeric(5, 1)), 12, 30, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (602, N'Silverclaw', N'Female', 9, NULL, 3, CAST(157.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (603, N'Simon Baz', N'Male', 9, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (604, N'Sinestro', N'Male', 3, 36, 3, CAST(201.0 AS Numeric(5, 1)), 3, 25, 3, CAST(92.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (605, N'Siren', N'Female', 6, 7, 24, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(72.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (606, N'Siren II', N'Female', 3, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (607, N'Siryn', N'Female', 6, NULL, 31, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (608, N'Skaar', N'Male', 14, NULL, 3, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(180.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (609, N'Snake-Eyes', N'Male', NULL, 5, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (610, N'Snowbird', N'Female', 33, NULL, 5, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(49.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (611, N'Sobek', N'Male', 33, NULL, 20, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (612, N'Solomon Grundy', N'Male', 3, 61, 33, CAST(279.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(437.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (613, N'Songbird', N'Female', 14, NULL, 29, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (614, N'Space Ghost', N'Male', NULL, 23, NULL, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(113.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (615, N'Spawn', N'Male', 9, 16, 3, CAST(211.0 AS Numeric(5, 1)), 9, NULL, 2, CAST(405.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (616, N'Spectre', N'Male', 33, 20, 20, CAST(-99.0 AS Numeric(5, 1)), 3, 33, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (617, N'Speedball', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (618, N'Speedy', N'Male', NULL, 23, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (619, N'Speedy', N'Female', 14, 23, 9, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (620, N'Spider-Carnage', N'Male', NULL, 52, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (621, N'Spider-Girl', N'Female', 6, 23, 9, CAST(170.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (622, N'Spider-Gwen', N'Female', 6, 23, 5, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (623, N'Spider-Man', N'Male', 17, 23, 9, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (624, N'Spider-Man', NULL, 25, 23, 9, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (625, N'Spider-Man', N'Male', 9, 23, 3, CAST(157.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (626, N'Spider-Woman', N'Female', 14, 23, 3, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (627, N'Spider-Woman II', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (628, N'Spider-Woman III', N'Female', 9, NULL, 9, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(55.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (629, N'Spider-Woman IV', N'Female', 25, NULL, 33, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(58.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (630, N'Spock', N'Male', 9, 30, 3, CAST(185.0 AS Numeric(5, 1)), 19, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (631, N'Spyke', N'Male', 9, 42, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (632, N'Stacy X', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (633, N'Star-Lord', N'Male', 6, 29, 5, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (634, N'Stardust', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (635, N'Starfire', N'Female', 14, 54, 2, CAST(193.0 AS Numeric(5, 1)), 3, 21, 2, CAST(71.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (636, N'Stargirl', N'Female', 6, 23, 5, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(62.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (637, N'Static', N'Male', 9, 42, 3, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (638, N'Steel', N'Male', 9, NULL, 20, CAST(201.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(131.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (639, N'Stephanie Powell', N'Female', NULL, NULL, 5, CAST(-99.0 AS Numeric(5, 1)), 1, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (640, N'Steppenwolf', N'Male', 25, 44, 3, CAST(183.0 AS Numeric(5, 1)), 3, 33, 1, CAST(91.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (641, N'Storm', N'Female', 6, 42, 33, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(57.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (642, N'Stormtrooper', N'Male', NULL, 23, NULL, CAST(183.0 AS Numeric(5, 1)), 4, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (643, N'Sunspot', N'Male', 9, 42, 3, CAST(173.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (644, N'Superboy', N'Male', 6, NULL, 3, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(68.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (645, N'Superboy-Prime', N'Male', 6, 37, 4, CAST(180.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(77.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (646, N'Supergirl', N'Female', 6, 37, 5, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (647, N'Superman', N'Male', 6, 37, 3, CAST(191.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (648, N'Swamp Thing', N'Male', 25, 20, 20, CAST(-99.0 AS Numeric(5, 1)), 3, 14, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (649, N'Swarm', N'Male', 35, 42, 20, CAST(196.0 AS Numeric(5, 1)), 12, 35, 1, CAST(47.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (650, N'Sylar', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (651, N'Synch', N'Male', 9, NULL, 3, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (652, N'T-1000', N'Male', NULL, 4, NULL, CAST(183.0 AS Numeric(5, 1)), 2, 30, 1, CAST(146.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (653, N'T-800', N'Male', 25, 12, NULL, CAST(-99.0 AS Numeric(5, 1)), 2, NULL, 1, CAST(176.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (654, N'T-850', N'Male', 25, 12, NULL, CAST(-99.0 AS Numeric(5, 1)), 2, NULL, 1, CAST(198.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (655, N'T-X', N'Female', NULL, 12, NULL, CAST(-99.0 AS Numeric(5, 1)), 2, 30, 1, CAST(149.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (656, N'Taskmaster', N'Male', 9, 23, 9, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (657, N'Tempest', N'Female', 9, NULL, 3, CAST(163.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (658, N'Thanos', N'Male', 25, 17, 20, CAST(201.0 AS Numeric(5, 1)), 12, 24, 1, CAST(443.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (659, N'The Cape', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), NULL, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (660, N'The Comedian', N'Male', 9, 23, 3, CAST(188.0 AS Numeric(5, 1)), 3, NULL, 3, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (661, N'Thing', N'Male', 6, 27, 20, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(225.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (662, N'Thor', N'Male', 6, 6, 5, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(288.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (663, N'Thor Girl', N'Female', 6, 6, 5, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(143.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (664, N'Thunderbird', N'Male', 9, NULL, 3, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(101.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (665, N'Thunderbird II', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (666, N'Thunderbird III', N'Male', 9, NULL, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (667, N'Thunderstrike', N'Male', 6, NULL, 5, CAST(198.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(288.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (668, N'Thundra', N'Female', 14, NULL, 25, CAST(218.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(158.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (669, N'Tiger Shark', N'Male', 16, 23, 20, CAST(185.0 AS Numeric(5, 1)), 12, 16, 1, CAST(203.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (670, N'Tigra', N'Female', 14, NULL, 2, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (671, N'Tinkerer', N'Male', 9, NULL, 33, CAST(163.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (672, N'Titan', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 6, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (673, N'Toad', N'Male', 3, 42, 9, CAST(175.0 AS Numeric(5, 1)), 12, 14, 3, CAST(76.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (674, N'Toxin', N'Male', 6, 52, 9, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(97.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (675, N'Toxin', N'Male', 3, 52, 5, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(117.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (676, N'Tracy Strauss', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 14, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (677, N'Trickster', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 3, NULL, NULL, CAST(81.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (678, N'Trigon', N'Male', 35, 20, 3, CAST(-99.0 AS Numeric(5, 1)), 3, 25, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (679, N'Triplicate Girl', N'Female', 24, NULL, 9, CAST(168.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(59.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (680, N'Triton', N'Male', 14, 33, 20, CAST(188.0 AS Numeric(5, 1)), 12, 14, 2, CAST(86.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (681, N'Two-Face', N'Male', NULL, NULL, NULL, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(82.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (682, N'Ultragirl', N'Female', 6, NULL, 5, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(105.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (683, N'Ultron', N'Male', 25, 4, NULL, CAST(206.0 AS Numeric(5, 1)), 12, 30, 1, CAST(331.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (684, N'Utgard-Loki', N'Male', 6, 19, 33, CAST(15.2 AS Numeric(5, 1)), 12, NULL, 1, CAST(58.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (685, N'Vagabond', N'Female', 6, NULL, 31, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (686, N'Valerie Hart', N'Female', 17, NULL, 3, CAST(175.0 AS Numeric(5, 1)), 21, NULL, 2, CAST(56.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (687, N'Valkyrie', N'Female', 6, NULL, 5, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(214.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (688, N'Vanisher', N'Male', 14, NULL, 20, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (689, N'Vegeta', N'Male', NULL, 49, 3, CAST(168.0 AS Numeric(5, 1)), 16, NULL, 1, CAST(73.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (690, N'Venom', N'Male', 6, 52, 31, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(117.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (691, N'Venom II', N'Male', 9, NULL, 3, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (692, N'Venom III', N'Male', 9, 52, 9, CAST(229.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(334.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (693, N'Venompool', N'Male', NULL, 52, NULL, CAST(226.0 AS Numeric(5, 1)), 12, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (694, N'Vertigo II', N'Female', 6, NULL, 30, CAST(168.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (695, N'Vibe', N'Male', 9, 23, 3, CAST(178.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(71.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (696, N'Vindicator', N'Female', 14, 23, 25, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (697, N'Vindicator', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (698, N'Violator', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 9, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (699, N'Violet Parr', N'Female', 32, 23, 3, CAST(137.0 AS Numeric(5, 1)), 2, NULL, 2, CAST(41.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (700, N'Vision', N'Male', 12, 4, 20, CAST(191.0 AS Numeric(5, 1)), 12, 25, 2, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (701, N'Vision II', NULL, 25, NULL, 20, CAST(191.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (702, N'Vixen', N'Female', 1, 23, 3, CAST(175.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(63.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (703, N'Vulcan', N'Male', 3, NULL, 3, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (704, N'Vulture', N'Male', 9, 23, 20, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(79.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (705, N'Walrus', N'Male', 6, 23, 3, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(162.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (706, N'War Machine', N'Male', 9, 23, 9, CAST(185.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (707, N'Warbird', N'Female', 6, NULL, 5, CAST(180.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(54.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (708, N'Warlock', N'Male', 25, NULL, 5, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(108.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (709, N'Warp', N'Male', 9, NULL, 3, CAST(173.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(67.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (710, N'Warpath', N'Male', 9, 42, 3, CAST(218.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(158.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (711, N'Wasp', N'Female', 6, 23, 2, CAST(163.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (712, N'Watcher', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (713, N'Weapon XI', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (714, N'White Canary', N'Female', 9, 23, 3, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (715, N'White Queen', N'Female', 6, NULL, 5, CAST(178.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(65.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (716, N'Wildfire', N'Male', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (717, N'Winter Soldier', N'Male', 9, 23, 9, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(117.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (718, N'Wiz Kid', NULL, 9, NULL, 3, CAST(140.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(39.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (719, N'Wolfsbane', N'Female', 14, NULL, 2, CAST(366.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(473.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (720, N'Wolverine', N'Male', 6, 42, 3, CAST(160.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(135.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (721, N'Wonder Girl', N'Female', 6, 15, 5, CAST(165.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(51.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (722, N'Wonder Man', N'Male', 25, NULL, 3, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(171.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (723, N'Wonder Woman', N'Female', 6, 3, 3, CAST(183.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(74.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (724, N'Wondra', N'Female', NULL, NULL, NULL, CAST(-99.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (725, N'Wyatt Wingfoot', N'Male', 9, NULL, 3, CAST(196.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(117.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (726, N'X-23', N'Female', 14, 43, 3, CAST(155.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(50.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (727, N'X-Man', N'Male', 6, NULL, 9, CAST(175.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(61.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (728, N'Yellow Claw', N'Male', 6, NULL, 20, CAST(188.0 AS Numeric(5, 1)), 12, NULL, 1, CAST(95.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (729, N'Yellowjacket', N'Male', 6, 23, 5, CAST(183.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(83.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (730, N'Yellowjacket II', N'Female', 6, 23, 31, CAST(165.0 AS Numeric(5, 1)), 12, NULL, 2, CAST(52.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (731, N'Ymir', N'Male', 33, 19, 20, CAST(304.8 AS Numeric(5, 1)), 12, 33, 2, CAST(-99.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (732, N'Yoda', N'Male', 9, 59, 33, CAST(66.0 AS Numeric(5, 1)), 4, 14, 2, CAST(17.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (733, N'Zatanna', N'Female', 6, 23, 3, CAST(170.0 AS Numeric(5, 1)), 3, NULL, 2, CAST(57.0 AS Numeric(5, 1)))
GO
INSERT [dbo].[hero] ([heroId], [name], [gender], [eyeColorId], [raceId], [hairColorId], [height], [publisherId], [skinColorId], [alignmentId], [weight]) VALUES (734, N'Zoom', N'Male', 25, NULL, 9, CAST(185.0 AS Numeric(5, 1)), 3, NULL, 1, CAST(81.0 AS Numeric(5, 1)))
GO
SET IDENTITY_INSERT [dbo].[hero] OFF
GO
SET IDENTITY_INSERT [dbo].[publisher] ON 
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (1, N'ABC Studios')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (2, N'Dark Horse Comics')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (3, N'DC Comics')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (4, N'George Lucas')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (5, N'Hanna-Barbera')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (6, N'HarperCollins')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (7, N'Icon Comics')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (8, N'IDW Publishing')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (9, N'Image Comics')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (10, N'J. K. Rowling')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (11, N'J. R. R. Tolkien')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (12, N'Marvel Comics')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (13, N'Microsoft')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (14, N'NBC - Heroes')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (15, N'Rebellion')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (16, N'Shueisha')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (17, N'Sony Pictures')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (18, N'South Park')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (19, N'Star Trek')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (20, N'SyFy')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (21, N'Team Epic TV')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (22, N'Titan Books')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (23, N'Universal Studios')
GO
INSERT [dbo].[publisher] ([publisherId], [name]) VALUES (24, N'Wildstorm')
GO
SET IDENTITY_INSERT [dbo].[publisher] OFF
GO
SET IDENTITY_INSERT [dbo].[race] ON 
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (1, N'Alien')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (2, N'Alpha')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (3, N'Amazon')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (4, N'Android')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (5, N'Animal')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (6, N'Asgardian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (7, N'Atlantean')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (8, N'Bizarro')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (9, N'Bolovaxian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (10, N'Clone')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (11, N'Cosmic Entity')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (12, N'Cyborg')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (13, N'Czarnian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (14, N'Dathomirian Zabrak')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (15, N'Demi-God')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (16, N'Demon')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (17, N'Eternal')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (18, N'Flora Colossus')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (19, N'Frost Giant')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (20, N'God / Eternal')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (21, N'Gorilla')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (22, N'Gungan')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (23, N'Human')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (24, N'Human / Altered')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (25, N'Human / Clone')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (26, N'Human / Cosmic')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (27, N'Human / Radiation')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (28, N'Human-Kree')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (29, N'Human-Spartoi')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (30, N'Human-Vulcan')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (31, N'Human-Vuldarian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (32, N'Icthyo Sapien')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (33, N'Inhuman')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (34, N'Kaiju')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (35, N'Kakarantharaian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (36, N'Korugaran')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (37, N'Kryptonian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (38, N'Luphomoid')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (39, N'Maiar')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (40, N'Martian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (41, N'Metahuman')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (42, N'Mutant')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (43, N'Mutant / Clone')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (44, N'New God')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (45, N'Neyaphem')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (46, N'Parademon')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (47, N'Planet')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (48, N'Rodian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (49, N'Saiyan')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (50, N'Spartoi')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (51, N'Strontian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (52, N'Symbiote')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (53, N'Talokite')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (54, N'Tamaranean')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (55, N'Ungaran')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (56, N'Vampire')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (57, N'Xenomorph XX121')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (58, N'Yautja')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (59, N'Yoda''s species')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (60, N'Zen-Whoberian')
GO
INSERT [dbo].[race] ([raceId], [name]) VALUES (61, N'Zombie')
GO
SET IDENTITY_INSERT [dbo].[race] OFF
GO
ALTER TABLE [dbo].[hero]  WITH CHECK ADD FOREIGN KEY([alignmentId])
REFERENCES [dbo].[alignment] ([alignmentId])
GO
ALTER TABLE [dbo].[hero]  WITH CHECK ADD FOREIGN KEY([eyeColorId])
REFERENCES [dbo].[color] ([colorId])
GO
ALTER TABLE [dbo].[hero]  WITH CHECK ADD FOREIGN KEY([hairColorId])
REFERENCES [dbo].[color] ([colorId])
GO
ALTER TABLE [dbo].[hero]  WITH CHECK ADD FOREIGN KEY([publisherId])
REFERENCES [dbo].[publisher] ([publisherId])
GO
ALTER TABLE [dbo].[hero]  WITH CHECK ADD FOREIGN KEY([raceId])
REFERENCES [dbo].[race] ([raceId])
GO
ALTER TABLE [dbo].[hero]  WITH CHECK ADD FOREIGN KEY([skinColorId])
REFERENCES [dbo].[color] ([colorId])
GO
