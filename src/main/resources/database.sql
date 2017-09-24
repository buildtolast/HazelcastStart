create table if not exists task (task_id int, task_type_id int, task_description varchar(100))
create table if not exists task_type(task_type_id int, task_type varchar(20))
create index if not exists task_idx on task(task_id)
create index if not exists task_type_idx on task_type(task_type_id)

insert into task_type values(1, 'Grocery')
Insert into task_type values(2, 'BJ')
Insert into task_type values(3, 'Learning')

Insert into task values(100, 1, ' Coffee ')
Insert into task values(101, 1, ' Bread ')
Insert into task values(102, 1, ' Frozen Pizza ')
Insert into task values(103, 1, ' Milk ')
Insert into task values(104, 2, 'Chocolates')
Insert into task values(105, 2, 'Cookies')
Insert into task values(106, 3, 'Coursera')

