-- member �|�����
INSERT INTO [member] ([member_account], [member_password], [member_name], [member_birth_date], [member_status])
VALUES
('alice01', '1234', 'Alice', '1991-05-14', 'active'),
('bob01', '1234', 'Bob', '1987-09-22', 'active'),
('charlie01', '1234', 'Charlie', '1996-01-01', 'active'),
('david01', '1234', 'David', '1990-03-11', 'inactive'),
('eve01', '1234', 'Eve', '1993-07-25', 'ban');

-- pet �d�����
INSERT INTO [pet] ([member_id], [pet_name], [pet_type], [pet_birth_date])
VALUES
(1, '����', '��', '2020-03-15'),
(2, 'Happy', '��', '2018-07-22'),
(3, '�̲�', '��', '2019-11-05'),
(4, 'Max', '��', '2017-09-10'),
(5, 'Lucky', '��', '2021-01-25'),
(1, '�]�l', '��', '2022-06-18'),
(2, '����', '��', '2020-12-05'),
(3, '���B', '��', '2019-03-30'),
(4, '�Ѥ�', '��', '2021-08-13'),
(5, '���', '��', '2023-02-02');

-- vote �벼�O��
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