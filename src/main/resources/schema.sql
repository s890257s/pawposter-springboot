USE paw_poster;

DROP TABLE IF EXISTS [member];
DROP TABLE IF EXISTS [pet];
DROP TABLE IF EXISTS [pet_vote];

CREATE TABLE [member](
    [member_id] int IDENTITY(1, 1) NOT NULL,
    [member_account] NVARCHAR(50),
    [member_password] NVARCHAR(50),
    [member_name] NVARCHAR(50),
    [member_birth_date] DATE,
    [member_status] NVARCHAR(10),
    [member_photo] image,
    [updated] DATE
);

CREATE TABLE [pet](
    [pet_id] int IDENTITY(1, 1) NOT NULL,
    [member_id] int,
    [pet_name] NVARCHAR(50),
    [pet_type] NVARCHAR(50),
    [pet_birth_date] DATE,
    [pet_photo] image,
    [updated] DATE
);

CREATE TABLE [pet_vote](
    [vote_id] int IDENTITY(1, 1) NOT NULL,
    [pet_id] int,
    [member_id] int,
    [vote_type] int, -- 1 表讚, 0 表倒讚
    [vote_date] DATE
);