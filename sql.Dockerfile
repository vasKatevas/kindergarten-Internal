FROM mysql:5.7.33

ENV MYSQL_USER=hbstudent
ENV MYSQL_PASSWORD=p@ssword123
ENV MYSQL_ROOT_PASSWORD=root

RUN echo "bind-address            = 0.0.0.0" >> etc/mysql/mysql.conf.d/mysqld.cnf

EXPOSE 3306
COPY database.sql /docker-entrypoint-initdb.d/

ENTRYPOINT ["/entrypoint.sh","mysqld"]
