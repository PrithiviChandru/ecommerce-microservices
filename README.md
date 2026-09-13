# E-Commerce Microservices

A monolithic e-commerce application migrated to a microservices-based architecture.

## Architecture

```text
                         ┌─────────────────┐
                         │     Client      │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │   API Gateway   │
                         │     :8080       │
                         └────────┬────────┘
                                  │
              ┌───────────────────┼───────────────────┐
              │                   │                   │
              ▼                   ▼                   ▼
      ┌──────────────┐    ┌──────────────┐    ┌──────────────┐
      │ Auth Service │    │Product Service│   │ Order Service│
      │    :8081     │    │    :8082      │   │    :8083     │
      └──────┬───────┘    └──────┬────────┘   └──────┬───────┘
             │                   │                   │
             ▼                   ▼                   ▼
      ┌──────────────┐    ┌──────────────┐    ┌──────────────┐
      │ Users / Auth │    │Category/Product│  │Orders/Payment│
      └──────────────┘    └──────────────┘    └──────────────┘
```

### Services

| Service             | Responsibility                                             |
| ------------------- | ---------------------------------------------------------- |
| **API Gateway**     | Single entry point for client requests and request routing |
| **Auth Service**    | Authentication, JWT, users and role-based authorization    |
| **Product Service** | Product and category management                            |
| **Order Service**   | Order creation, order retrieval and payment simulation     |

### Architecture Flow

```text
Client
   │
   ▼
API Gateway
   │
   ├── /api/auth/**     → Auth Service
   ├── /api/users/**    → Auth Service
   ├── /api/categories/** → Product Service
   ├── /api/products/**   → Product Service
   ├── /api/orders/**     → Order Service
   └── /api/payment/**    → Order Service
```
