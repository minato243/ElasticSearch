# ElasticSearch
Client log tracking using Elasticsearch, Kibana, and Logstash for games or apps.

![Iap](https://github.com/user-attachments/assets/596857b2-bdeb-4274-85b6-b8d82acc6f29)
![Rewarded](https://github.com/user-attachments/assets/64cec8f1-652b-4528-8c9b-fd4383d303f3)
![Level](https://github.com/user-attachments/assets/b77ff0e1-6259-44a0-b236-43cc3a41ed7a)

Install Elasticsearch:
https://www.elastic.co/docs/deploy-manage/deploy/self-managed/install-kibana-from-archive-on-linux-macos
  
  Set up transport TLS
```ssh
bin/elasticsearch-keystore list
./bin/elasticsearch-certutil ca
./bin/elasticsearch-certutil cert --ca elastic-stack-ca.p12
cp transport.p12 config/certs/
```
  Start Elasticsearch:
```ssh
bin/elasticsearch-certutil http

sysctl vm.max_map_count
sudo sysctl -w vm.max_map_count=262144
cd elasticsearch-9.2.3/
bin/elasticsearch -d 1>log.txt 2>log.txt
```
Install Kibana:
```ssh
nano install_kibana.sh
```
Paste the command:
```ssh
curl -O https://artifacts.elastic.co/downloads/kibana/kibana-9.2.3-linux-x86_64.tar.gz
curl https://artifacts.elastic.co/downloads/kibana/kibana-9.2.3-linux-x86_64.tar.gz.sha512 | shasum -a 512 -c -
tar -xzf kibana-9.2.3-linux-x86_64.tar.gz
cd kibana-9.2.3/
```
In Elasticsearch home, create a crt and copy it to Kibana
```ssh
openssl pkcs12 -in config/certs/http.p12 -cacerts -nokeys -out http_ca.crt
cp http_ca.crt ../kibana-9.2.3/config/certs/
```

Add to kibana.yml:
```kibana.yml
elasticsearch.hosts: ["https://localhost:9200"]

elasticsearch.ssl.certificateAuthorities:
  - config/certs/http_ca.crt

elasticsearch.ssl.verificationMode: full
```

Edit kibana.yml: find server.host change to 0.0.0.0
``` kibana.yml
server.host: 0.0.0.0


```
Start Kibana:
```ssh
bin/kibana 1>log.txt 2>log.txt &
```

Filebeat
```ssh
curl -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-9.2.3-linux-x86_64.tar.gz
tar -xzf filebeat-9.2.3-linux-x86_64.tar.gz
```

Run Project. Now the server listens on port 8080 and will log to Elasticseach when a client posts to. You can view your data on Kibana, which runs on port 5601 (default).
