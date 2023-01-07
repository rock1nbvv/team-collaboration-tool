#!/bin/bash

declare -a DB_LIST=(
  "collaboration_tool"
)

set -e

for db_name in "${DB_LIST[@]}"; do

  psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
	CREATE DATABASE ${db_name} ENCODING = 'UTF8' TABLESPACE = pg_default LC_COLLATE = 'en_US.utf8' LC_CTYPE = 'en_US.utf8' CONNECTION LIMIT = -1;
EOSQL

done
