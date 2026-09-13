# E-Commerce Microservices

A monolithic e-commerce application migrated
to a microservices-based architecture.

## Architecture

Client
  ↓
API Gateway
  ↓
 ┌──────────────┐
 │ Auth Service │
 └──────────────┘
       ↓
 ┌───────────────┐
 │ Product       │
 │ Category      │
 │ Order         │
 │ Payment       │
 └───────────────┘
