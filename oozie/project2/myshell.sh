#!/usr/bin/env bash

mysql -uroot -p123456 -Dshop_platform_analyse -e "update user_info set active_status = 0";
mysql -uroot -p123456 -Dshop_platform_analyse -e "update user_info set active_status = 1 where login_status = 1";