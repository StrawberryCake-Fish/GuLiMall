# Docker redis-cluster

## firewalld

```shell
firewall-cmd --zone=public --add-port=6371/tcp --permanent && \
firewall-cmd --zone=public --add-port=16371/tcp --permanent && \
firewall-cmd --zone=public --add-port=6372/tcp --permanent && \
firewall-cmd --zone=public --add-port=16372/tcp --permanent && \
firewall-cmd --zone=public --add-port=6373/tcp --permanent && \
firewall-cmd --zone=public --add-port=16373/tcp --permanent && \
firewall-cmd --zone=public --add-port=6374/tcp --permanent && \
firewall-cmd --zone=public --add-port=16374/tcp --permanent && \
firewall-cmd --zone=public --add-port=6375/tcp --permanent && \
firewall-cmd --zone=public --add-port=16375/tcp --permanent && \
firewall-cmd --zone=public --add-port=6376/tcp --permanent && \
firewall-cmd --zone=public --add-port=16376/tcp --permanent && \
firewall-cmd --reload
```

## dir

```shell
#!/bin/bash 
for port in $(seq 6371 6376); 
do 
mkdir -p /opt/redis/redis-${port}/conf
mkdir -p /opt/redis/redis-${port}/data
touch /opt/redis/redis-${port}/conf/redis.conf
cat  << EOF > /opt/redis/redis-${port}/conf/redis.conf
port ${port}
cluster-enabled yes
cluster-config-file nodes-${port}.conf
cluster-node-timeout 5000
appendonly yes
protected-mode no
requirepass 1234
masterauth 1234
cluster-announce-ip 172.16.4.31
cluster-announce-port ${port}
cluster-announce-bus-port 1${port}
EOF
done
```

```text
[root@localhost redis]# tree
.
├── docker-compose.yml
├── redis-6371
│ ├── conf
│ │ └── redis.conf
│ └── data
│     ├── appendonlydir
│     │ ├── appendonly.aof.1.base.rdb
│     │ ├── appendonly.aof.1.incr.aof
│     │ └── appendonly.aof.manifest
│     ├── dump.rdb
│     └── nodes-6371.conf
├── redis-6372
│ ├── conf
│ │ └── redis.conf
│ └── data
│     ├── appendonlydir
│     │ ├── appendonly.aof.1.base.rdb
│     │ ├── appendonly.aof.1.incr.aof
│     │ └── appendonly.aof.manifest
│     ├── dump.rdb
│     └── nodes-6372.conf
├── redis-6373
│ ├── conf
│ │ └── redis.conf
│ └── data
│     ├── appendonlydir
│     │ ├── appendonly.aof.1.base.rdb
│     │ ├── appendonly.aof.1.incr.aof
│     │ └── appendonly.aof.manifest
│     ├── dump.rdb
│     ├── nodes-6371.conf
│     └── nodes-6373.conf
├── redis-6374
│ ├── conf
│ │ └── redis.conf
│ └── data
│     ├── appendonlydir
│     │ ├── appendonly.aof.2.base.rdb
│     │ ├── appendonly.aof.2.incr.aof
│     │ └── appendonly.aof.manifest
│     ├── dump.rdb
│     ├── nodes-6371.conf
│     └── nodes-6374.conf
├── redis-6375
│ ├── conf
│ │ └── redis.conf
│ └── data
│     ├── appendonlydir
│     │ ├── appendonly.aof.2.base.rdb
│     │ ├── appendonly.aof.2.incr.aof
│     │ └── appendonly.aof.manifest
│     ├── dump.rdb
│     ├── nodes-6371.conf
│     └── nodes-6375.conf
└── redis-6376
    ├── conf
    │ └── redis.conf
    └── data
        ├── appendonlydir
        │ ├── appendonly.aof.2.base.rdb
        │ ├── appendonly.aof.2.incr.aof
        │ └── appendonly.aof.manifest
        ├── dump.rdb
        ├── nodes-6371.conf
        └── nodes-6376.conf
```

## docker-compose.yml

```yml
version: "3"

services:
  redis-6371:
    image: redis
    container_name: redis-6371
    restart: always
    volumes:
      - /opt/redis/redis-6371/conf/redis.conf:/usr/local/etc/redis/redis.conf
      - /opt/redis/redis-6371/data:/data
    ports:
      - 6371:6371
      - 16371:16371
    command:
      redis-server /usr/local/etc/redis/redis.conf

  redis-6372:
    image: redis
    container_name: redis-6372
    volumes:
      - /opt/redis/redis-6372/conf/redis.conf:/usr/local/etc/redis/redis.conf
      - /opt/redis/redis-6372/data:/data
    ports:
      - 6372:6372
      - 16372:16372
    command:
      redis-server /usr/local/etc/redis/redis.conf

  redis-6373:
    image: redis
    container_name: redis-6373
    volumes:
      - /opt/redis/redis-6373/conf/redis.conf:/usr/local/etc/redis/redis.conf
      - /opt/redis/redis-6373/data:/data
    ports:
      - 6373:6373
      - 16373:16373
    command:
      redis-server /usr/local/etc/redis/redis.conf

  redis-6374:
    image: redis
    container_name: redis-6374
    volumes:
      - /opt/redis/redis-6374/conf/redis.conf:/usr/local/etc/redis/redis.conf
      - /opt/redis/redis-6374/data:/data
    ports:
      - 6374:6374
      - 16374:16374
    command:
      redis-server /usr/local/etc/redis/redis.conf

  redis-6375:
    image: redis
    container_name: redis-6375
    volumes:
      - /opt/redis/redis-6375/conf/redis.conf:/usr/local/etc/redis/redis.conf
      - /opt/redis/redis-6375/data:/data
    ports:
      - 6375:6375
      - 16375:16375
    command:
      redis-server /usr/local/etc/redis/redis.conf

  redis-6376:
    image: redis
    container_name: redis-6376
    volumes:
      - /opt/redis/redis-6376/conf/redis.conf:/usr/local/etc/redis/redis.conf
      - /opt/redis/redis-6376/data:/data
    ports:
      - 6376:6376
      - 16376:16376
    command:
      redis-server /usr/local/etc/redis/redis.conf
```

## enable

```shell
redis-cli -a 1234 --cluster create 192.168.154.129:6371 192.168.154.129:6372 192.168.154.129:6373 192.168.154.129:6374 192.168.154.129:6375 192.168.154.129:6376 --cluster-replicas 1
```