Dual write problem
 - Transactional Outbox Pattern:
 - Change Data Capture (CDC)
      https://netflixtechblog.com/dblog-a-generic-change-data-capture-framework-69351fb9099b
 - Transactional Changelog Events
 - Idempotent Consumers
 - Compensating Transactions
 - Sagas Pattern


 ### What is service mesh?
 A Service Mesh is an infrastructure layer that manages communication between microservices in a distributed
 software architecture. It's designed to handle a variety of network-based inter-process communication
 complexities inherent in microservice architectures.

#### Key Features of Service Mesh:
***
 **Service-to-Service Communication:** Facilitates and controls how different parts of an application share data with one another.\
 **Load Balancing:** Distributes network traffic across multiple instances of a service to ensure even load and high availability.\
 **Service Discovery:** Enables services to dynamically discover and communicate with each other.\
 **Fault Tolerance and Resiliency:** Implements retries, circuit breakers, and timeouts to handle failures gracefully.\
 **Encryption and Security:** Provides secure service-to-service communication, often through mutual TLS (mTLS) to ensure encrypted traffic and secure identity verification.\
 **Observability:** Offers insights into the behavior of services through logging, tracing, and monitoring.
 
#### How It Works:
***
 **Sidecar Proxy:** In a typical service mesh, each service instance is paired with a lightweight proxy, often referred to as a "sidecar." These sidecars intercept network communication between microservices.\
 **Control Plane:** It manages and configures the sidecar proxies, enforcing policies, collecting metrics, and applying rules for traffic routing.
 
#### Popular Service Mesh Implementations:
***
 **_Istio:_** Integrates with Kubernetes and offers advanced traffic management, security features, and observability.\
 **_Linkerd:_** Known for its simplicity and lightweight nature, providing essential service mesh features with minimal resource consumption.\
 **_Consul:_** Provides service mesh capabilities with a focus on service discovery and configuration.