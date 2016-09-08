INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'USER');
INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'ADMIN');

INSERT INTO `fitness`.`users` (`version`, `username`, `password`, `enabled`) VALUES ('0', 'bob@aol.com', '$2a$10$8jBGVl3r1DCCHqLHUabm2uV3IT8tA2p8yfYmR7Lru1QcspIYwrf8S', '1');

INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('2', '1');

INSERT INTO `fitness`.`profiles` (`version`, `gender`, `age`, `height`, `weight`, `photo`, `user_id`)
VALUES ('0', 'M', '25', '70', '165', 'http://findicons.com/files/icons/1072/face_avatars/300/i05.png', '1');

INSERT INTO `fitness`.`exercises` (`version`, `type`, `quantity`, `calories`, `duration`, `user_id`)
VALUES ('0', 'RUN', '3', '900', '45', '1');


INSERT INTO `fitness`.`devices` (`version`, `serial_id`, `product`, `category`, `user_id`, `created`, `modified`) VALUES ('0', 'ABC', 'FitBit', 'Run', '1', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`devices` (`version`, `serial_id`, `product`, `category`, `user_id`, `created`, `modified`) VALUES ('0', '123', 'Watch', 'Swim', '1', '2016-09-07', '2016-09-07');

INSERT INTO `fitness`.`runs` (`version`, `start_time`, `stop_time`, `device_id`, `created`, `modified`) VALUES ('0', '2016-09-07', '2016-09-07', '1', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`runs` (`version`, `start_time`, `device_id`, `created`, `modified`) VALUES ('0', '2016-09-07', '1', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`runs` (`version`, `start_time`, `device_id`, `created`, `modified`) VALUES ('0', '2016-09-07', '2', '2016-09-07', '2016-09-07');

INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '1', '1', '1', '2016-09-07 10:00', '1', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '2', '2', '2', '2016-09-07 10:02', '1', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '3', '3', '3', '2016-09-07 10:03', '1', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '4', '4', '4', '2016-09-07 10:04', '1', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '11', '11', '11', '2016-09-07 11:10', '2', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '12', '12', '12', '2016-09-07 11:20', '2', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '12', '12', '12', '2016-09-07 11:30', '2', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '120', '120', '120', '2016-09-07 11:30', '3', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '121', '121', '121', '2016-09-07 11:35', '3', '2016-09-07', '2016-09-07');
INSERT INTO `fitness`.`positions` (`version`, `latitude`, `longitude`, `altitude`, `c_time`, `run_id`, `created`, `modified`) VALUES ('0', '122', '122', '122', '2016-09-07 11:40', '3', '2016-09-07', '2016-09-07');