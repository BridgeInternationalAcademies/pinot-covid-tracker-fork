FROM apache/superset:latest
RUN pip install pymssql 
RUN superset fab create-admin --username admin --firstname Superset --lastname Admin --email admin@superset.com --password admin 
RUN superset db upgrade
RUN superset init
ENTRYPOINT [ "/usr/bin/docker-entrypoint.sh" ]