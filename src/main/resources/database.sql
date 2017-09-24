create table if not exists task (task_id int, task_type_id int, task_description varchar(100))
create table if not exists task_type(task_type_id int, task_type varchar(20))
create index if not exists task_idx on task(task_id)
create index if not exists task_type_idx on task_type(task_type_id)