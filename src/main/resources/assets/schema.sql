USE paw_poster;

IF OBJECT_ID('member') IS NOT NULL
BEGIN
    DROP TABLE [member];
END

IF OBJECT_ID('pet') IS NOT NULL
BEGIN
    DROP TABLE [pet];
END

IF OBJECT_ID('pet_vote') IS NOT NULL
BEGIN
    DROP TABLE [pet_vote];
END

CREATE TABLE [member](
[member_id] int IDENTITY(1,1) NOT NULL,
[member_account] NVARCHAR(50),
[member_password] NVARCHAR(50),
[member_name] NVARCHAR(50),
[member_birth_date] DATE,
[member_status] NVARCHAR(5),
[member_photo] image,
[updated] DATE
)

CREATE TABLE [pet](
[pet_id] int IDENTITY(1,1) NOT NULL,
[member_id] int,
[pet_name] NVARCHAR(50),
[pet_type] NVARCHAR(50),
[pet_birth_date] DATE,
[pet_photo] image,
[updated] DATE
)

CREATE TABLE [pet_vote](
[vote_id] int IDENTITY(1,1) NOT NULL,
[pet_id] int,
[member_id] int,
[vote_type] int, -- 1 ªíÆg, 0 ªí­ËÆg
[vote_date] DATE
)