# persistence

## kubernetes
1. Pod состоит из контейнера(ов)
2. Deployment состоит из одинаковых под(ов), нужен для Auto Scaling и для обновления image, держит минимальное
   количество работающих подов
3. Service предоставляет доступ к Deployment через
- ClusterIP - внутренний ip-адрес, доступный в кластере
- NodePort
- LoadBalancer
- ExternalName (DNS)
4. Nodes - сервера
5. Cluster - объединение серверов

- ConfigMaps
- LoadBalancers
- Horizontal Pod Autoscaler
- Vertical Pod Autoscaler
- ReplicaSets
- DeamonSets
- StatefulSets
- Secrets
- PV
- SVC
