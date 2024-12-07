# persistence

## kubernetes
1. Pod состоит из контейнера(ов)
2. Deployment состоит из одинаковых под(ов), нужен для Auto Scaling и для обновления image, держит минимальное
   количество работающих подов
3. Service предоставляет доступ к Deployment через
   - ClusterIP (по умолчанию) - внутренний ip-адрес, доступный в кластере
   - NodePort - определенный порт на ВСЕХ k8s worker nodes
   - LoadBalancer - работает только в cloud cluster (AWS, Azure and so on)
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

kubectl apply -f "file_name".yaml
kubectl delete -f "file_name".yaml
kubectl get pods
kubectl get nodes
kubectl get nodes
kubectl get deploy
kubectl get hpa
kubectl get rs
kubectl get svc (services)
kubectl describe pods "pod_name"
kubectl logs "pod_name"
kubectl port-forward "pod_name" 8082:8080