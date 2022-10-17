create database if not exists ss5_list_music;
use ss5_list_music;

create table music(
id int auto_increment primary key,
name_song varchar(50),
singer varchar(50),
type varchar (50),
link varchar(50),
);

INSERT INTO `ss5_list_music`.`music` (name_song, singer,'type', link) VALUES ('Milk Song','Haku' ,'VPOP', 'MilkSong.mp3');
INSERT INTO `ss5_list_music`.`music` (name_song, singer,'type', link) VALUES ('Chan da cham dat chua','ICD' ,'VPOP', 'ICD_chanchamdatchua.mp3');
