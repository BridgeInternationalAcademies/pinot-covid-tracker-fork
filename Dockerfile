FROM apache/superset:e5b68e5cfb94ae0876b2e005b2ba3bd32c2cb592-dev
RUN pip install pymssql
ENV PYTHONPATH "${PYTHONPATH}:/app/superset_home/superset_config.py"