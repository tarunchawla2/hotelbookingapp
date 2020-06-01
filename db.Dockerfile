FROM mysql:5

ENV MYSQL_DATABASE hotelbookingdb

#ADD ./mysql-table/ /docker-entrypoint-initdb.d/

EXPOSE 3306
