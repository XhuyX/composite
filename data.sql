USE [composite]
GO
/****** Object:  Table [dbo].[ThanhPhan]    Script Date: 4/22/2025 1:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhPhan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[Size] [bigint] NULL,
	[ParentId] [int] NULL,
 CONSTRAINT [PK_ThanhPhan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[ThanhPhan] ON 

GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (1, N'LAPTRINH', -1, -1)
GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (2, N'JAVA', -1, 1)
GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (3, N'C#', -1, 1)
GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (4, N'test', 1, 1)
GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (5, N'baitap01', 5, 2)
GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (6, N'baitap02', 3, 2)
GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (7, N'LYTHUYET', -1, 2)
GO
INSERT [dbo].[ThanhPhan] ([ID], [Ten], [Size], [ParentId]) VALUES (8, N'abc', 12, 7)
GO
SET IDENTITY_INSERT [dbo].[ThanhPhan] OFF
GO
