-- member 會員資料
INSERT INTO [member] ([member_account], [member_password], [member_name], [member_birth_date], [member_status])
VALUES
('alice01', '1234', 'Alice', '1991-05-14', 'active'),
('bob01', '1234', 'Bob', '1987-09-22', 'active'),
('charlie01', '1234', 'Charlie', '1996-01-01', 'active'),
('david01', '1234', 'David', '1990-03-11', 'inactive'),
('eve01', '1234', 'Eve', '1993-07-25', 'ban');

-- pet 寵物資料
INSERT INTO [pet] ([member_id], [pet_name], [pet_type], [pet_birth_date])
VALUES
(1, '阿毛', '狗', '2020-03-15'),
(2, 'Happy', '貓', '2018-07-22'),
(3, '米粒', '狗', '2019-11-05'),
(4, 'Max', '狗', '2017-09-10'),
(5, 'Lucky', '貓', '2021-01-25'),
(1, '包子', '狗', '2022-06-18'),
(2, '甜甜', '貓', '2020-12-05'),
(3, '布丁', '貓', '2019-03-30'),
(4, '天天', '狗', '2021-08-13'),
(5, '麻糬', '貓', '2023-02-02');

-- vote 投票記錄
INSERT INTO [pet_vote] ([pet_id], [member_id], [vote_type], [vote_date])
VALUES
(1, 1, 1, GETDATE()), 
(2, 2, 1, GETDATE()), 
(3, 3, 0, GETDATE()), 
(4, 4, 1, GETDATE()), 
(5, 5, 0, GETDATE()), 
(1, 2, 1, GETDATE()), 
(2, 3, 1, GETDATE()), 
(3, 4, 0, GETDATE()), 
(4, 1, 0, GETDATE()), 
(5, 2, 1, GETDATE()), 
(1, 3, 0, GETDATE()), 
(2, 4, 1, GETDATE()), 
(3, 5, 1, GETDATE()), 
(4, 1, 1, GETDATE()), 
(5, 2, 0, GETDATE()), 
(1, 4, 0, GETDATE()), 
(2, 1, 1, GETDATE()), 
(3, 2, 1, GETDATE()), 
(4, 3, 1, GETDATE()), 
(5, 5, 0, GETDATE()); 